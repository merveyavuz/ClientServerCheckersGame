package DamaClient;

import java.awt.event.*;
import java.util.HashMap;
import javax.swing.DefaultListModel;

public class ClientGUI extends javax.swing.JFrame {
    private Client client = null;   
    public HashMap chats = null;    //mesajlaşmaları mapler
    private String name;
    DefaultListModel playerList = null;  //netteki kullanıcıları listeler
    
    public ClientGUI() {
        playerList = new DefaultListModel(); //ilk atamaları yapar.
        chats = new HashMap();
        initComponents();
        
        MouseListener mouseListener = new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    if (userList.getSelectedValue() != null) {
                        newChatWindow((String) userList.getSelectedValue());
                        userList.clearSelection();
                    }
                }
            }
        };
        userList.addMouseListener(mouseListener);

        
        addWindowListener(new clientWindowListener());
    }

 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txt_ip = new javax.swing.JTextField();
        ipAddressLabel = new javax.swing.JLabel();
        btn_connect = new javax.swing.JButton();
        portLabel = new javax.swing.JLabel();
        txt_port = new javax.swing.JTextField();
        connectionLabel = new javax.swing.JLabel();
        btn_disconnect = new javax.swing.JButton();
        nameLabel = new javax.swing.JLabel();
        txt_name = new javax.swing.JTextField();
        lbl_oyuncular = new javax.swing.JLabel();
        btn_basla = new javax.swing.JButton();
        usersScrollPane = new javax.swing.JScrollPane();
        userList = new javax.swing.JList();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("MyCheckers");
        setResizable(false);

        txt_ip.setText("127.0.0.1");
        txt_ip.setNextFocusableComponent(txt_port);
        txt_ip.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_ipActionPerformed(evt);
            }
        });

        ipAddressLabel.setText("IP Address:");
        ipAddressLabel.setFocusable(false);

        btn_connect.setText("Connect");
        btn_connect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_connectActionPerformed(evt);
            }
        });

        portLabel.setText("Port:");
        portLabel.setFocusable(false);

        txt_port.setText("4000");
        txt_port.setNextFocusableComponent(txt_name);
        txt_port.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_portActionPerformed(evt);
            }
        });

        connectionLabel.setText("Not connected");
        connectionLabel.setFocusable(false);

        btn_disconnect.setText("Disconnect");
        btn_disconnect.setEnabled(false);
        btn_disconnect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_disconnectActionPerformed(evt);
            }
        });

        nameLabel.setText("İsim:");
        nameLabel.setFocusable(false);

        txt_name.setNextFocusableComponent(btn_connect);
        txt_name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_nameActionPerformed(evt);
            }
        });

        lbl_oyuncular.setText("Oyuncular:");
        lbl_oyuncular.setFocusable(false);

        btn_basla.setText("New Game");
        btn_basla.setEnabled(false);
        btn_basla.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_baslaActionPerformed(evt);
            }
        });

        userList.setModel(playerList);
        userList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        userList.setFocusable(false);
        userList.setMaximumSize(new java.awt.Dimension(0, 50));
        usersScrollPane.setViewportView(userList);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(connectionLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(usersScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_oyuncular)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(ipAddressLabel)
                                    .addComponent(portLabel, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(nameLabel, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txt_ip)
                                    .addComponent(txt_port)
                                    .addComponent(txt_name, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(36, 36, 36)
                                        .addComponent(btn_connect))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(26, 26, 26)
                                        .addComponent(btn_disconnect)))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_basla)
                .addGap(143, 143, 143))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ipAddressLabel)
                            .addComponent(txt_ip, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_port, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(portLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nameLabel)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(btn_connect)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_disconnect)))
                .addGap(18, 18, 18)
                .addComponent(lbl_oyuncular)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(usersScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_basla)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(connectionLabel))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_ipActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_ipActionPerformed
        if (btn_connect.isEnabled()) {
            connectClient();
        }
    }//GEN-LAST:event_txt_ipActionPerformed

    private void txt_portActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_portActionPerformed
        if (btn_connect.isEnabled()) {
            connectClient();
        }
    }//GEN-LAST:event_txt_portActionPerformed

    private void btn_connectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_connectActionPerformed
        connectClient(); //clientla bağlanır.
    }//GEN-LAST:event_btn_connectActionPerformed

    private void connectClient() {
        String IPAddress = txt_ip.getText();                //ip alir
        int port = Integer.parseInt(txt_port.getText());    //port alir
        name = txt_name.getText();                          //client ismini alir
        
        if (name.equals("")) {
            connectionLabel.setText("İsim giriniz");     //isim boş bırakıldaysa uyarı verilir.
            return;
        }
        
        Client c = new Client(this);    //yeni client oluşturulur.
        if (c.connect(IPAddress, port, name) == 1) {    //client doğru bağlandıysa aktifleştirme yapılır.
            this.client = c;
            connectionLabel.setText("Bağlandı.");
            btn_disconnect.setEnabled(true);
            btn_connect.setEnabled(false);
            btn_basla.setEnabled(true);
            
            txt_ip.setEnabled(false);
            txt_port.setEnabled(false);
            txt_name.setEnabled(false);
            
            this.client.start(); //client başlatılır.
        } else {
            connectionLabel.setText("Bağlantı yok."); //bağlantı kurulamadıysa hata verir.
        }
    }
    
    public void setUserList(String[] names) {           //oyuncu seçmek için
        playerList.clear();  //eskiler çıkmasın diye clear edilir.
        for (String userName : names) {
            if (!userName.equals(name)) { //isimler listesinde yoksa
                playerList.addElement(userName); //eklenir
            }
            if (chats.containsKey(userName)) { //mesajlaşmada varsa
                ClientGameGUI chat = (ClientGameGUI) chats.get(userName); // ekranı oluşturur
                chat.partnerExists();   
            }
        }
    }
    
    public void recievedMessage(String sender, String message) { //gelen mesaj
        if (!chats.containsKey(sender)) { //chatteki gönderenlerden bulunmuyorsa
            newChatWindow(sender); //yeni mesajlasma olusturulur
        }
        ClientGameGUI chat = (ClientGameGUI) chats.get(sender); //gönderenden gelen mesajları alır
        chat.addToChatField(message); //mesaj alanına ekler
    }
    
    public void updateGame(String sender, String board, String message) { //boardu update eder.
        updateGame(sender, board, name, message);
    }
    
    public void updateGame(String sender, String board, String turn, String message) {
        if (!chats.containsKey(sender)) {  //chatteki gönderenlerden bulunmuyorsa
            newChatWindow(sender, true); //yeni ekran açar
        } else {
            int[][] realBoard = new int[8][8];      //board oluşturur
            String res = board.substring(1, board.length()-1); //gelen string, boardu alır
            String[] rows = res.split("\\],\\[");   //satırlara böler
            rows[0] = rows[0].substring(1, rows[0].length());
            rows[7] = rows[7].substring(0, rows[7].length()-1);

            for (int y = 0; y < 8; y++) { //parçalanan stringdeki board değerlerini alarak yeni int matrise atar
                String chars[] = rows[y].split(","); 
                for (int x = 0; x < 8; x++) {
                    realBoard[y][x] = Integer.parseInt(chars[x]);
                }
            }

            ClientGameGUI game = (ClientGameGUI) chats.get(sender); //göndericinin arayüzünü oluşturur.
            String final_message = message; //mesaj olusturulur.
            game.setTurn(turn.equals(name));
            
            if (message.equals("Yeni oyun başladı.")) {
                if (turn.equals(name)) {
                    final_message = "Yeni oyuna başladın!";
                } else {
                    final_message = sender+" seninle yeni oyuna başladı!";
                    game.restartGame();
                }
            }
            game.writeBoard(realBoard, final_message);
        }
    }
    
    public void notifyWin(String opponent) { // kazananı belirt.
        if (!chats.containsKey(opponent)) { //rakip mapte yoksa 
            newChatWindow(opponent, true); //yeni ekran oluştur
        }
        ClientGameGUI game = (ClientGameGUI) chats.get(opponent); //rakibin arayüzünü oluşturur.
        game.notifyWin();
    }
    
    public void newChatWindow(String opponent) { 
        newChatWindow(opponent, false);
    }
    
    public void newChatWindow(String opponent, boolean auto) {
        if (!chats.containsKey(opponent)) {  //rakip mapte bulunmuyorsa
            final ClientGameGUI newChat = new ClientGameGUI(opponent, client, this); //oluştur
            chats.put(opponent, newChat); //rakibi ve mesajlarını maple
       
            client.sendMessage(opponent, "###new_game_window###"); //yeni mesaj gönderir
            java.awt.EventQueue.invokeLater(new Runnable() {
                @Override
                public void run() {
                    newChat.setVisible(true); //yeni ekran gözükür olur
                }
            });
        } else {
            System.err.println("Bu kişiyle oyun zaten var");
            connectionLabel.setText("Bu kişiyle oyun zaten var");
        }
    }
    
    public void connectionDied(String partner) {
        if (chats.containsKey(partner)) {
            ClientGameGUI chatWindow = (ClientGameGUI) chats.get(partner);
            chatWindow.disconnect("rakibinin bağlantısı kesildi");
        }
    }
    
    public void cleanUpChatWindowClosed(String partner) {
        chats.remove(partner);
    }
    
    public void disconnect(String reason) {
        if (client.disconnect() == 1) {   //clientın bağlantısı koptuysa ekranı temizler
            connectionLabel.setText(reason);
            btn_disconnect.setEnabled(false);
            btn_connect.setEnabled(true);
            btn_basla.setEnabled(false);
            
            txt_ip.setEnabled(true);
            txt_port.setEnabled(true);
            txt_name.setEnabled(true);
            
            if (!chats.isEmpty()) {
                for (ClientGameGUI chat : (ClientGameGUI[]) chats.values().toArray(new ClientGameGUI[0])) {
                    chat.disconnect(reason);
                }
            }
            
            playerList.clear(); //netteki kullanıcıları temizler
            
            client = null;
            name = "";
        }
    }
    
    private void btn_disconnectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_disconnectActionPerformed
        disconnect("Disconnected");
    }//GEN-LAST:event_btn_disconnectActionPerformed

    private void btn_baslaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_baslaActionPerformed
        if (userList.getSelectedValue() != null) {
            newChatWindow((String) userList.getSelectedValue());
            userList.clearSelection();
        }
    }//GEN-LAST:event_btn_baslaActionPerformed

    private void txt_nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_nameActionPerformed
        if (btn_connect.isEnabled()) {
            connectClient();
        }
    }//GEN-LAST:event_txt_nameActionPerformed
    
    public static void main(String args[]) {
        /*
         * Set the Nimbus look and feel
         */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the
         * default look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ClientGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ClientGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ClientGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ClientGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                new ClientGUI().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_basla;
    private javax.swing.JButton btn_connect;
    private javax.swing.JButton btn_disconnect;
    private javax.swing.JLabel connectionLabel;
    private javax.swing.JLabel ipAddressLabel;
    private javax.swing.JLabel lbl_oyuncular;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JLabel portLabel;
    private javax.swing.JTextField txt_ip;
    private javax.swing.JTextField txt_name;
    private javax.swing.JTextField txt_port;
    private javax.swing.JList userList;
    private javax.swing.JScrollPane usersScrollPane;
    // End of variables declaration//GEN-END:variables

    private class clientWindowListener extends WindowAdapter {
        @Override
        public void windowClosing(WindowEvent e) {
            if (client != null) {
                disconnect("");
            }
        }
    }
}
