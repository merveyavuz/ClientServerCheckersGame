package DamaServer;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.HashMap;

public class Server extends Thread {
    private ServerSocket serverSocket = null;       //gerekli tanımlamalar yapıldı.
    private FindClients findClients = null;
    private ServerGUI gui = null;
    private HashMap clients = null;
    private HashMap games = null; //oyuncu eşleşmeleri
    private boolean listening = false;  //socketin dinlenip dinlenilmediğin, anlamak için
    
    public Server(ServerGUI gui) {  //server constructorı oluşturuldu.
        this.gui = gui;
    }
    
    public int startListener(int port) { //port dinlenmesi için ik atamalatı yapar
        try {
            serverSocket = new ServerSocket(port);                  
            clients = new HashMap();
            games = new HashMap();
            findClients = new FindClients(this, serverSocket);
            findClients.start();
            listening = true;
            return 1;
        } catch (IOException e) {
            return 0;
        } catch (IllegalArgumentException e) {
            return 0;
        }
    }
    
    public int addClient(ServerThread client) {      //client ekleme işlemi yapar
        if (clients.containsKey(client.name)) {     //gelen clientın adı hashmapte varsa uyarı döndürür
            System.err.println("İsim tekrarı.");    
            return 2;
        }
        else {                                  //client yoksa listeye adı ve clientı mapleyerek eker
            clients.put(client.name, client);   
            sendClientList();                   //yeniden thread edilecek liste yollanır
            return 0;
        }
    }
    
    public void removeClient(ServerThread client) { //gelen clientı siler
        if (clients.containsKey(client.name)) {
            clients.remove(client.name);
            sendClientList();
        } else {
        }
    }
    
    private void sendClientList() {                       
        String[] clientIPList = new String[clients.size()];         //clientların iplerini tutmak için client dizisi uzunluğunda array oluşturuldu.
        ServerThread[] clientsList = (ServerThread[]) clients.values().toArray(new ServerThread[0]);
        String names = "name_list=";
        
        
        for(int n = 0; n < clientsList.length; n++) {   //client ip listesine socket adress ve client adını atar.
            clientIPList[n] = String.valueOf(clientsList[n].getSocket().getRemoteSocketAddress()) + " " + clientsList[n].name;
            names += clientsList[n].name + ","; //isimlere clientıın adını ekler.
        }
        names = names.substring(0, names.length()-1);
   
        for(int n = 0; n < clientsList.length; n++) {          //client listesindeki her elemanı iletir
            if (clientsList[n] != null) {
                clientsList[n].sendMessage("server", names);
            }
        }
    }
    
    
    
    public int stopListening() { //socket dinlemeyi bırakmak içn.
        try {
            if (listening) {
                for (ServerThread client : (ServerThread[]) clients.values().toArray(new ServerThread[0])) { 
                    client.sendMessage("server", "disconnected"); //her client için disconnect mesajı iletilir
                    client.kill();                                      //clientlar bitirilir.
                }
                findClients.kill();  
                findClients = null;
                serverSocket.close();
                clients.clear();
                games.clear();
                listening = false;
            }
            return 1;
        } catch (IOException e) {
            return 0;
        }
    }
    
    public void sendMessage(String alici, String gonderen, String mesaj) {   
        if (clients.containsKey(alici)) {    //iletilecek olan clientlarda bulunuyorsa thread oluşturur ve mesaj gönderir.
            ServerThread threadReciever = (ServerThread) clients.get(alici);
            threadReciever.sendMessage(gonderen, mesaj);
        } else if (alici.equals("all")) { //tümüyse clientların hepsine mesajı atar.
            ServerThread[] clientsList = (ServerThread[]) clients.values().toArray(new ServerThread[0]);
            for (ServerThread c : clientsList) {
                c.sendMessage(gonderen, mesaj);
            }
        } else {
            System.err.println("mesaj gönderilemedi. " );
        }
    }
    
    public void newGame(String client1, String client2) {   //yeni oyun başlatmak için
        String gameString = "";
        if (games.containsKey(client1+":"+client2)) {    //oyuncuların maplenmiş hali bulunuyorsa atanır
            gameString = client1+":"+client2;
        } else if (games.containsKey(client2+":"+client1)) { 
            gameString = client2+":"+client1;
        }
        
        if (!gameString.equals("")) {   //string boş değilse
            Game game = (Game) games.get(gameString);  //yeni oyun oluşturulur.
            String board;                               //oyun tahtası tanımlanır.
            if (gameString.substring(0, gameString.indexOf(":")).equals(client1)) { //gamestringteki ilk client client1se 
                board = game.getBoard();                                            //oyun tahtasını oluşturur
            } else {                                                               //client2yse tam tersi matrisi kullancağından
                board = game.getRotatedBoard(game.getBoard());                      //döndürülmüş matris ile board oluşturulur.
            }
            sendMessage(client1, client2, "game_already_exists###board="+board+"###turn="+game.getTurn());
        } else {
            Game game = new Game(client1, client2);   //string doluysa 
            games.put(client1+":"+client2, game);       //hashmaplenir.
            sendMessage(client1, client2, "###new_game_started###board="+game.getBoard()+"###"); // mesaj göderilir.
        }
    }
    
    public void endGame(String loser, String winner) { //oyunu bitirmek için
        String gameString = "";
        if (games.containsKey(loser+":"+winner)) {  //kazanan kaybeden hashmeptekiler içindeyse 
            gameString = loser+":"+winner;          //stringi oluşturur
        } else if (games.containsKey(winner+":"+loser)) { //yer değiştirmiş hali için
            gameString = winner+":"+loser;
        } else {                                            //oyuncular mapte yoksa hata verir
            System.err.println("oyuncular bulunamadı");
        }
        
        sendMessage(winner, loser, "you_won");    //kazananı mesaj olaarak iletir
        games.remove(gameString);                       //oyun bittiği için eşleşmeyi listeden siler
    }
    
    public void restartGame(String client1, String client2) { //yeniden başlatmak için 
        Game game = new Game(client1, client2); //gelen clientlarla yeni oyun oluşturulur.
        games.put(client1+":"+client2, game);   //oyuncular eşlenir
        sendMessage(client1, client2,   //oyunun tekrar başladığının ve oyun sırasının mesajı iletilir 
            "new_game_restarted###board="+game.getBoard()+"###turn="+game.getTurn()+"###");
        sendMessage(client2, client1,"new_game_restarted###board="+game.getRotatedBoard(game.getBoard())+"###turn="+game.getTurn()+"###");
    }
    
    public void gameMove(String from, String to, String message) { //hamle 
        String gameString = "";
        if (games.containsKey(from+":"+to)) { //hamlenin kimden kime yapıldığı stringe atanır
            gameString = from+":"+to;
        } else if (games.containsKey(to+":"+from)) {
            gameString = to+":"+from;
        } else {
            System.err.println("hamlenin kimden kime olduğu atanamadı");
        }
        
        Game game = (Game) games.get(gameString); // oyun eşleşmeye göre oluşturulur
        
        int[][] realBoard = new int[8][8];
        String res = message.substring(message.indexOf("###new_board=")+14, message.length()-4);
        String[] rows = res.split("\\],\\[");
        rows[0] = rows[0].substring(1, rows[0].length());
        rows[7] = rows[7].substring(0, rows[7].length()-1);
        
        for (int y = 0; y < 8; y++) {       //boyut kadar dönerek değerleri atar 
            String chars[] = rows[y].split(",");
            for (int x = 0; x < 8; x++) {
                realBoard[y][x] = Integer.parseInt(chars[x]);
            }
        }
        
        game.setBoard(realBoard);   //asıl tahtaya göre atama yapar
        game.changeTurns();         // oyun sırasını değiştirir.
        String newBoard;            
        if (gameString.substring(0, gameString.indexOf(":")).equals(to)) { //client1'e eşitse board oluşturulur
            newBoard = game.getBoard();
        } else {
            newBoard = game.getRotatedBoard(game.getBoard());       //client2e eşitse döndürülmüş board oluşturulur.
        }
        sendMessage(to, from, "###checkers_move###new_board="+newBoard+"###");
    }
}       