package DamaClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client extends Thread {
    private ClientGUI gui = null;
    private Socket clientSocket = null;
    private PrintWriter out = null;
    private BufferedReader in = null;
    private boolean listening = true;
    
    public Client(ClientGUI gui) {
        this.gui = gui;
    }
    
    private static class Message {
        public String gonderen;
        public String icerik;
        
        public Message(String mesaj) {
            gonderen = mesaj.substring(mesaj.indexOf("sentfrom=")+9, mesaj.indexOf("message="));
            icerik = mesaj.substring(mesaj.indexOf("message=")+8, mesaj.length());
        }
        
        @Override
        public String toString() {
            return "Sender: " + gonderen + " Message: " + icerik;
        }
    }
    
    
    
    public int connect(String IPAddress, int port, String name) {
        try {
            this.clientSocket = new Socket(IPAddress, port);
            this.out = new PrintWriter(clientSocket.getOutputStream(), true);
            this.in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            sendMessage("server", "name=" + name);
            return 1;
        } catch (UnknownHostException e) {
            System.err.println("host nulunamadı");
            return 0;
        } catch (IOException e) {
            System.err.println("hosta bağlanılamadı");
            return 0;
        }
    }
    
    public int disconnect() {
        sendMessage("server", "disconnecting");
        listening = false;
        return 1;
    }
    
    public int sendMessage(String destination, String message) {
        out.println("sendto=" + destination + "message=" + message);
        return 1;
    }
    
    @Override
    public void run() {
        String fromServer;
        
        try {
            while((fromServer = in.readLine()) != null && listening) {
                Message message = new Message(fromServer);
                if (message.gonderen.equals("server")) {
                   if (message.icerik.equals("disconnected")) {
                        gui.disconnect("Server bağlantısı kesildi");
                    }
                    else if (message.icerik.equals("too_many_connections")) {
                        gui.disconnect("serverda çok fazla bağlantı var");
                    }
                    else if (message.icerik.equals("name_already_taken")) {
                        gui.disconnect("başka isim seçiniz");
                    }
                    else 
                    if (message.icerik.contains("name_list=")) {
                        String[] names = message.icerik.substring(10, message.icerik.length()).split(",");
                        gui.setUserList(names);
                    }
                } else {
                    if (message.icerik.equals("potential_chat_disconnected")) {
                        gui.connectionDied(message.gonderen);
                    }
                    else if (message.icerik.contains("game_already_exists")) {
                        String b = message.icerik.substring(message.icerik.indexOf("###board=")+9, message.icerik.indexOf("###turn="));
                        String t = message.icerik.substring(message.icerik.indexOf("###turn=")+8, message.icerik.length());
                        gui.updateGame(message.gonderen, b, t, "Var olan oyun açıldı.");
                    }
                    else if (message.icerik.contains("new_game_started")) {
                        String b = message.icerik.substring(message.icerik.indexOf("###board=")+9, message.icerik.length()-3);
                        gui.updateGame(message.gonderen, b, "Yeni oyun başladı.");
                    }
                    else if (message.icerik.contains("new_game_restarted")) {
                        String b = message.icerik.substring(message.icerik.indexOf("###board=")+9, message.icerik.indexOf("###turn="));
                        String t = message.icerik.substring(message.icerik.indexOf("###turn=")+8, message.icerik.length());
                        gui.updateGame(message.gonderen, b, t, "Yeni oyun başladı.");
                    }
                    else if (message.icerik.contains("###checkers_move")) {
                        String b = message.icerik.substring(message.icerik.indexOf("###new_board=")+13, message.icerik.length()-3);
                        gui.updateGame(message.gonderen, b, message.gonderen+"'dan yeni hamle.");
                    }
                    else if (message.icerik.equals("you_won")) {
                        gui.notifyWin(message.gonderen);
                    }
                    
                    else {
                        gui.recievedMessage(message.gonderen, message.icerik);
                    }
                }
            }
            
            in.close();
            out.close();
            clientSocket.close();
        } catch(IOException e) {
            System.exit(1);
        }
    }
}
