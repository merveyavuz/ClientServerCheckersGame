package DamaServer;

import java.io.IOException;
import java.net.ServerSocket;

public class FindClients extends Thread {                  //Clientları bulmak ve listelemek için
    private Server server = null;                           //gerekli tanımlar oluşturuldu.
    private ServerSocket serverSocket = null;           
    private boolean searchClient = true;
    
    public FindClients(Server server, ServerSocket serverSocket) {  //server ve socket'i olacağından constructora atıldı.
        this.server = server;
        this.serverSocket = serverSocket;
    }
    
    public void kill() {    // clientın dinlenmesini iptal etmek için oluşturuldu.
        searchClient = false;
    }
    
    @Override
    public void run() {
        while (searchClient) {
            try {
                ServerThread newThread = new ServerThread(server, serverSocket.accept()); //Threadin başlatılması için server ve
                newThread.start();                                                          // serverın bilgi kabul etmesi için accept metodu atıldı.
            } catch(IOException e) {}
        }
    }
}
