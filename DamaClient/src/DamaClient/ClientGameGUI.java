package DamaClient;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.text.DefaultCaret;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

public class ClientGameGUI extends javax.swing.JFrame {
    private Client client = null;
    private ClientGUI gui = null;
    private String partner = "";
    private boolean myTurn = false;
   
    private SimpleAttributeSet yourNameStyle = null;    //mesajlaşmanın stilli olarak ekrana gelmesi için 
    private SimpleAttributeSet opponentNameStyle = null;
    private SimpleAttributeSet messageNameStyle = null;
    
    private StyledDocument chatDoc = null;
    
    public ClientGameGUI(String partner, Client client, ClientGUI gui) {
        initComponents();                   //ilk atamaları yapar
        setTitle(partner+" ile oynuyorsun " );
        this.client = client;
        this.gui = gui;
        this.partner = partner;
     
        yourNameStyle = new SimpleAttributeSet();               //bir konuşmacıyı kırmızı bir konuşmacıyı mavi olarak ve bold olarak gösterir.
        StyleConstants.setForeground(yourNameStyle, Color.RED);
        StyleConstants.setBold(yourNameStyle, true);
        
        opponentNameStyle = new SimpleAttributeSet();
        StyleConstants.setForeground(opponentNameStyle, Color.BLUE);
        StyleConstants.setBold(opponentNameStyle, true);
        
        messageNameStyle = new SimpleAttributeSet(); //mesaj isim stilini oluşturur.
        
        chatDoc = mesajTextPane.getStyledDocument();  
        
        addWindowListener(new chatWindowListener());
        
        mesajTextPane.setEditable(false);
        DefaultCaret caret = (DefaultCaret)mesajTextPane.getCaret();
        caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
    }

 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txt_mesaj = new javax.swing.JTextField();
        btn_Gonder = new javax.swing.JButton();
        javax.swing.JPanel gamePanel = new CheckersPanel();
        this.gamePanel = (CheckersPanel) gamePanel;
        centerSeparator = new javax.swing.JSeparator();
        btn_hamleYap = new javax.swing.JButton();
        lbl_oyunSirasi = new javax.swing.JLabel();
        connectionLabel = new javax.swing.JLabel();
        mesaj = new javax.swing.JLabel();
        btn_newGame = new javax.swing.JButton();
        chatScrollPane = new javax.swing.JScrollPane();
        mesajTextPane = new javax.swing.JTextPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Chat with ...");
        setResizable(false);

        txt_mesaj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_mesajActionPerformed(evt);
            }
        });

        btn_Gonder.setText("Gönder");
        btn_Gonder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_GonderActionPerformed(evt);
            }
        });

        gamePanel.setBackground(java.awt.Color.white);
        gamePanel.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        gamePanel.setFocusable(false);
        gamePanel.setMaximumSize(new java.awt.Dimension(400, 400));
        gamePanel.setMinimumSize(new java.awt.Dimension(400, 400));
        gamePanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                gamePanelMousePressed(evt);
            }
        });

        javax.swing.GroupLayout gamePanelLayout = new javax.swing.GroupLayout(gamePanel);
        gamePanel.setLayout(gamePanelLayout);
        gamePanelLayout.setHorizontalGroup(
            gamePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        gamePanelLayout.setVerticalGroup(
            gamePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        centerSeparator.setOrientation(javax.swing.SwingConstants.VERTICAL);

        btn_hamleYap.setText("Hamle Yap");
        btn_hamleYap.setEnabled(false);
        btn_hamleYap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_hamleYapActionPerformed(evt);
            }
        });

        lbl_oyunSirasi.setFont(new java.awt.Font("DejaVu Sans", 0, 18)); // NOI18N
        lbl_oyunSirasi.setText("Oyun sırası:");

        mesaj.setText("Mesajlaşma:");

        btn_newGame.setText("Yeni Oyun");
        btn_newGame.setEnabled(false);
        btn_newGame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_newGameActionPerformed(evt);
            }
        });

        chatScrollPane.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        chatScrollPane.setAutoscrolls(true);
        chatScrollPane.setFocusable(false);
        chatScrollPane.setHorizontalScrollBar(null);
        chatScrollPane.setMaximumSize(new java.awt.Dimension(329, 400));
        chatScrollPane.setMinimumSize(new java.awt.Dimension(329, 400));
        chatScrollPane.setPreferredSize(new java.awt.Dimension(329, 400));

        mesajTextPane.setEditable(false);
        mesajTextPane.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        mesajTextPane.setFocusable(false);
        mesajTextPane.setMaximumSize(new java.awt.Dimension(329, 400));
        mesajTextPane.setMinimumSize(new java.awt.Dimension(329, 400));
        mesajTextPane.setPreferredSize(new java.awt.Dimension(329, 400));
        chatScrollPane.setViewportView(mesajTextPane);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addComponent(lbl_oyunSirasi, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btn_newGame)
                                .addGap(105, 105, 105))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(gamePanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addGap(119, 119, 119)
                                        .addComponent(btn_hamleYap)))
                                .addGap(12, 12, 12)))
                        .addComponent(centerSeparator, javax.swing.GroupLayout.PREFERRED_SIZE, 6, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(txt_mesaj)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_Gonder))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(mesaj)
                                    .addComponent(chatScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addComponent(connectionLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(18, 18, 18)
                            .addComponent(lbl_oyunSirasi))
                        .addComponent(mesaj, javax.swing.GroupLayout.Alignment.TRAILING))
                    .addComponent(btn_newGame, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(centerSeparator)
                    .addComponent(gamePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(chatScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_Gonder)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txt_mesaj, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btn_hamleYap)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(connectionLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

   
    private void btn_GonderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_GonderActionPerformed
        sendText();
    }//GEN-LAST:event_btn_GonderActionPerformed

    private void txt_mesajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_mesajActionPerformed
        if (btn_Gonder.isEnabled()) {
            sendText();
        }
    }//GEN-LAST:event_txt_mesajActionPerformed


    private void sendText() {           //mesaj gönder
        String txt = txt_mesaj.getText();   //texti alır
        if (!txt.equals("")) {              //boş değilse 
            if (client.sendMessage(partner, txt) == 1) {    //clienttan mesaj yollar
                try {
                    chatDoc.insertString(chatDoc.getLength(), "Sen: ", yourNameStyle); //ekrana isim yazı tipiyle mesajı yazdırır.
                    chatDoc.insertString(chatDoc.getLength(), txt + "\n", messageNameStyle);
                } catch(Exception e) {
                    System.err.println(e);
                }                
                txt_mesaj.setText("");
            } else {
                System.err.println("mesaj gönderilemedi");
            }
        }
    }
    
    public void addToChatField(String message) { //rakipten gelen mesajı sstille ekrana ekler
        try {
            chatDoc.insertString(chatDoc.getLength(), partner+": ", opponentNameStyle);
            chatDoc.insertString(chatDoc.getLength(), message + "\n", messageNameStyle);
        } catch(Exception e) {
            System.err.println(e);
        }
    }
    
    public void partnerExists() { //rakip bağlantıdan koptuysa hata verir.
        if (!btn_Gonder.isEnabled()) {
            btn_Gonder.setEnabled(true);
            connectionLabel.setText("Tekrar bağlandın!");
        }
    }
    
    public void disconnect(String msg) { //bağlantı yoksa mesaj atmaz 
        btn_Gonder.setEnabled(false);   //hata mesajı labela yazdırılır.
        connectionLabel.setText(msg);
    }
    
    private void btn_hamleYapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_hamleYapActionPerformed
        myTurn = false; //sıra rakipte değil
        client.sendMessage(partner, "###new_move###new_board="+gamePanel.getFormattedBoard()+"###"); //clienttan yeni boardu gönderir
        setTurn(false); 
        btn_hamleYap.setEnabled(false);
        gamePanel.setSelected(-1, -1);
        connectionLabel.setText("Hamle yapıldı...");
    }//GEN-LAST:event_btn_hamleYapActionPerformed

    private void gamePanelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_gamePanelMousePressed
        int x_pos = (int)Math.floor(evt.getX()/50.0);   //tıklanan yerin indexlerini alır.
        int y_pos = (int)Math.floor(evt.getY()/50.0);
        
        if (myTurn) { //sıra rakipte değilse 
            if (gamePanel.selected == null && //tıklanan yer boşsa ve seçilmediyse 
                    (gamePanel.getBoard()[y_pos][x_pos] == 1 || gamePanel.getBoard()[y_pos][x_pos] == 2) ) {
                gamePanel.setSelected(x_pos, y_pos); //seç
            } else if (gamePanel.selected != null) { //seçildiyse 
                int[] to = {x_pos, y_pos}; //taş konulacak yeri tutar 
                int res = checkMove(gamePanel.getSelected(), to); //hamleyi kontrol et
                if ((res == 1) || (res == 2)) { 
                    int[] s = gamePanel.getSelected();
                    
                    int type = gamePanel.removePiece(s[0], s[1]);// taşı sil
                    if (to[1] == 0) { //x'i 0sa
                        gamePanel.addPiece(to[0], to[1], 2);
                    } else {//değilse 
                        gamePanel.addPiece(to[0], to[1], type);
                    }
                    
                    btn_hamleYap.setEnabled(true); //hamle yapılabilir.
                    if (res == 1) {
                        gamePanel.setSelected(-1, -1);
                    } else if (res == 2) {
                        int dir_x = (int) ((to[0]-s[0])/2);
                        int dir_y = (int) ((to[1]-s[1])/2);
                        gamePanel.removePiece(s[0]+dir_x, s[1]+dir_y);
                        gamePanel.setSelected(to[0], to[1]);
                    }
                } 
            }
        }
    }//GEN-LAST:event_gamePanelMousePressed

    private void btn_newGameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_newGameActionPerformed
        client.sendMessage(partner, "new_game_restarted"); //clienttan yeni oyun başlandığına dair mesaj at
        setTurn(true);
        btn_newGame.setEnabled(false);
      
    }//GEN-LAST:event_btn_newGameActionPerformed
    
    public void setTurn(boolean turn) { //labellara sıranın kimde olduğunu atar
        myTurn = turn;
        if (turn) {
            lbl_oyunSirasi.setText("Senin sıran:");
        } else {
            lbl_oyunSirasi.setText(partner+"'nın sırası:");
        }
    }
    
  
    
    public void writeBoard(int[][] board, String message) { //
        gamePanel.setBoard(board);
        connectionLabel.setText(message);

        
        if (checkEnd()) { //bitip bitmedğini kontrol eder bittiyse
            lbl_oyunSirasi.setText("Kaybettin!");
            client.sendMessage(partner, "game_over###you_win");
            
            myTurn = false;
            btn_hamleYap.setEnabled(false);
            gamePanel.setSelected(-1, -1);
            btn_newGame.setEnabled(true);
            
            JOptionPane.showMessageDialog(null, "Kaybettin.", "Kaybettin", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    public void restartGame() { //yeniden başlat
        btn_newGame.setEnabled(false);
    }
    
    public void notifyWin() { //kazananı bildir
        lbl_oyunSirasi.setText("Kazandın!");
        myTurn = false;
        btn_hamleYap.setEnabled(false);
        gamePanel.setSelected(-1, -1);
        btn_newGame.setEnabled(true);
        
        JOptionPane.showMessageDialog(null, "Kazandın!", "Kazandın", JOptionPane.INFORMATION_MESSAGE);
    }
    
    private int checkMove(int[] from, int[] to) { //hamle uygun mu kontrol eder
        if (gamePanel.getBoard()[to[1]][to[0]] == 0) { //eğer bulunduğu yer d
            if (gamePanel.getBoard()[from[1]][from[0]] == 1 && to[1] > from[1]) {
                return 0;
            }
            
            if (Math.abs(to[0]-from[0]) == 1 && Math.abs(to[1]-from[1]) == 1) {
                return 1;
            }
            
            if (Math.abs(to[0]-from[0]) == 2 && Math.abs(to[1]-from[1]) == 2) {
                int dir_x = (int) ((to[0]-from[0])/2);
                int dir_y = (int) ((to[1]-from[1])/2);
                int enemy_num = gamePanel.getBoard()[from[1]+dir_y][from[0]+dir_x];
                if (enemy_num == 3 || enemy_num == 4) {
                    return 2;
                }
            }
        }
        return 0;
    }
    
    private boolean checkEnd() { // taşları sayar ve bitip bitmediğini kontrol eder.
        int[][] b = gamePanel.getBoard();
        for (int y = 0; y < 8; y++) {
            for (int x = 0; x < 8; x++) {
                if (b[y][x] == 1 || b[y][x] == 2) {
                    for (int j = 0; j < 8; j++) {
                        for (int k = 0; k < 8; k++) {
                            int[] from = {x, y};
                            int[] to = {k, j}; 
                            if (checkMove(from, to) != 0) {
                                return false;
                            }
                        }
                    }
                }
            }
        }
        
        return true;
    }
    
    private class CheckersPanel extends JPanel {
        private int[][] board = null;  //tahtayı ve resimleri tanmlar
        private int[] selected = null;
        
        private Image red_piece = null;
        private Image blue_piece = null;
        private Image red_piece_king = null;
        private Image blue_piece_king = null;
        
        public CheckersPanel() { //ilk değerleri atar.
            try {
                red_piece = ImageIO.read(this.getClass().getResource("images/red_piece.png"));
                blue_piece = ImageIO.read(this.getClass().getResource("images/blue_piece.png"));
                red_piece_king = ImageIO.read(this.getClass().getResource("images/red_piece_king.png"));
                blue_piece_king = ImageIO.read(this.getClass().getResource("images/blue_piece_king.png"));
            } catch (IOException e) {               
            }
        }
        
        public int[] getSelected() {// seçileni döndürür
            return selected;
        }
        
        public void setSelected(int x, int y) { //seçilenin indexlerini setler
            if (x == -1 && y == -1) {   
                selected = null;
            } else {
                selected = new int[2];
                selected[0] = x;
                selected[1] = y;
            }
            repaint(); 
        }
        
        public void addPiece(int x, int y, int type) { //oyun taşı tipine göre  ekleme 
            if (board[y][x] == 0 && (type == 1 || type == 2 || type == 3 || type ==3)) {
                board[y][x] = type;
                repaint();
            } else {
                System.err.println("Zaten taş var.");
            }
        }
        
        public int removePiece(int x, int y) { // oyun taşını tahtadan sil
            if (board[y][x] != 0) {
                int res = board[y][x];
                board[y][x] = 0;
                repaint();
                return res;
            } else {
                System.err.println("Taş bulunmamakta");
                return 0;
            }
        }
        
        public int[][] getBoard() {
            int[][] b = new int[8][8];
            for (int y = 0; y < 8; y++) {
                System.arraycopy(board[y], 0, b[y], 0, 8);
            }
            return b;
        }
        
        public String getFormattedBoard() { 
            String res = "[";
            for (int[] y : board) {
                res += "[";
                for (int x: y) {
                    res += x+",";
                }
                res = res.substring(0, res.length()-1);
                res += "],";
            }
            res = res.substring(0, res.length()-1);
            res += "]";
            return res;
        }
        
        public void setBoard(int[][] newBoard) { //boardu update eder
            this.board = newBoard;
            repaint();
        }
        
        @Override
        public void paintComponent(Graphics g) { //Boardu görsel olarak oluşturur
            super.paintComponent(g);
            
            //arkaplan
            g.setColor(Color.DARK_GRAY);
            for (int y = 0; y < 8; y++) {
                for (int x = 0; x < 8; x++) {
                    if ((x+y) % 2 == 0) {
                        g.fillRect(x*50, y*50, 50, 50);
                    }
                }
            }
            
            //seçimi yeşil
            g.setColor(Color.GREEN);
            if (selected != null) {
                g.fillRect(selected[0]*50, selected[1]*50, 50, 50);
            }
            
            //Draw the pieces
            if (board != null) {
                for (int y = 0; y < board.length; y++) {
                    for (int x = 0; x < board.length; x++) {
                        if (board[y][x] == 1) {
                            g.drawImage(red_piece, x*50+5, y*50+5, x*50+45, y*50+45,
                                                   0, 0, red_piece.getWidth(null), red_piece.getHeight(null), null);
                        } else if (board[y][x] == 2) {
                            g.drawImage(red_piece_king, x*50+5, y*50+5, x*50+45, y*50+45,
                                                   0, 0, red_piece_king.getWidth(null), red_piece_king.getHeight(null), null);
                        } else if (board[y][x] == 3) {
                            g.drawImage(blue_piece, x*50+5, y*50+5, x*50+45, y*50+45,
                                                   0, 0, blue_piece.getWidth(null), blue_piece.getHeight(null), null);
                        } else if (board[y][x] == 4) {
                            g.drawImage(blue_piece_king, x*50+5, y*50+5, x*50+45, y*50+45,
                                                   0, 0, blue_piece_king.getWidth(null), blue_piece_king.getHeight(null), null);
                        }
                    }
                }
            }
        }
    }

    private CheckersPanel gamePanel;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Gonder;
    private javax.swing.JButton btn_hamleYap;
    private javax.swing.JButton btn_newGame;
    private javax.swing.JSeparator centerSeparator;
    private javax.swing.JScrollPane chatScrollPane;
    private javax.swing.JLabel connectionLabel;
    private javax.swing.JLabel lbl_oyunSirasi;
    private javax.swing.JLabel mesaj;
    private javax.swing.JTextPane mesajTextPane;
    private javax.swing.JTextField txt_mesaj;
    // End of variables declaration//GEN-END:variables

    // on window close listener
    private class chatWindowListener extends WindowAdapter {
        @Override
        public void windowClosing(WindowEvent e) {
            gui.cleanUpChatWindowClosed(partner);
        }
    }
}