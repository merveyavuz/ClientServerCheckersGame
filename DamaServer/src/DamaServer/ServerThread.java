package DamaServer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ServerThread extends Thread {  //server threadi için gerekli tanımlamalar yapılır.
    private Server server = null;
    private Socket socket = null;
    private PrintWriter out = null;
    private BufferedReader in = null;
    private boolean listening = true;
    private boolean ready = false;
    
    public String name = "";
    
    private static class Message {  
        public String alici;
        public String icerik;
        
        public Message(String str) {
            alici = str.substring(str.indexOf("sendto")+7, str.indexOf("message="));
            icerik = str.substring(str.indexOf("message")+8, str.length());
        }
        
        @Override
        public String toString() {
            return "Recipiant: " + alici + " Message: " + icerik;
        }
    }
    
    public ServerThread(Server server, Socket socket) { //server thread değerleri atanır.
        super("MyCheckersServerThread");
        this.socket = socket;
        this.server = server;
        try {                                                                      //socket yazımı ve okumu boluşturulur.
            this.out = new PrintWriter(socket.getOutputStream(), true);
            this.in = in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        } catch (IOException e) {
        }
    }
    
    public Socket getSocket() { 
        return this.socket;
    }
    
    public void sendMessage(String sender, String msg) { // gönderen ve mesaj girilir.
       out.println("sentfrom=" + sender + "message=" + msg);
    }
    
    public void kill() {    //thread bitirilir.
        listening = false;
    }
    
    @Override
    public void run() {
        try {
            String inputLine;
            
            while ((inputLine = in.readLine()) != null && listening) { //girilen mesaj boş değilse ve port dinleme devam ediyorsa
                Message message = new Message(inputLine); //mesajı oluşturur
                if (message.alici.equals("server")) {   //eğer alici server ise 
                    if (message.icerik.equals("disconnecting")) { //eger içerik disconnecing ise 
                        server.sendMessage("all", name, "potential_chat_disconnected"); //serverdan tüm clientlara disconnect mesajı gider.
                        break;
                    }
                    else if (message.icerik.contains("name=")) { //mesajda isim varsa 
                        name = message.icerik.substring(message.icerik.indexOf("=")+1, message.icerik.length()); //stringi böler
                        
                        int res = server.addClient(this); //client ekler
                        if (res == 0) { // 1 tane gönderen varsa gönderime hazır olur
                            ready = true;
                        } else if (res == 1) { //fazlaysa hata verir
                            sendMessage("server", "too_many_connections");
                            break;
                        } else if (res == 2) { // aynısından varsa hata verir
                            sendMessage("server", "name_already_taken");
                            break;
                        }
                    }
                } else {
                    if (ready) { //mesaj hazırsa
                        if (message.icerik.equals("###new_game_window###")) { //yeni oyun penceresi açılacaksa
                            server.newGame(name, message.alici); //serverdan yeni oyun isteği iletilir
                        }
                        else if (message.icerik.contains("###new_move")) { //yeni hamle yapıldıysa
                            server.gameMove(name, message.alici, message.icerik);
                        }
                        else if (message.icerik.equals("game_over###you_win")) { //oyun bittiyse
                            server.endGame(name, message.alici);
                        }
                        else if (message.icerik.equals("new_game_restarted")) { //oyun tekrar başladıysa
                            server.restartGame(name, message.alici);
                        }
                        
                        else { //mesaj içeriği bunlardan değilse alıcı ve içeriği serverdan gönderilir.
                            server.sendMessage(message.alici, name, message.icerik);
                        }
                    }
                }
            }
            
            out.close();    //yazma ve okuma kapatılır.
            in.close();
            socket.close(); //socket kapatılır.
            if (ready) {    //mesaj hazırsa işlem tamamlanmıştır ve bu client silinir.
                server.removeClient(this);
            }
            
        } catch (IOException e) {}
    }
}
