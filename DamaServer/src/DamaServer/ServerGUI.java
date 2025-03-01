package DamaServer;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ServerGUI extends javax.swing.JFrame{
    private Server server = null;
    
    public ServerGUI() {
        initComponents();
        server = new Server(this); //server oluşturulur.
        
        addWindowListener(new serverWindowListener()); 
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        portNo = new javax.swing.JTextField();
        btn_dinle = new javax.swing.JButton();
        btn_durdur = new javax.swing.JButton();
        connectionLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("MyCheckersServer");

        portNo.setText("4000");
        portNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                portNoActionPerformed(evt);
            }
        });

        btn_dinle.setText("Port Dinle");
        btn_dinle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_dinleActionPerformed(evt);
            }
        });

        btn_durdur.setText("Durdur");
        btn_durdur.setEnabled(false);
        btn_durdur.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_durdurActionPerformed(evt);
            }
        });

        connectionLabel.setText("Bağlantı yok.");
        connectionLabel.setFocusable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(95, 95, 95)
                        .addComponent(portNo, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_dinle)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_durdur)
                        .addGap(0, 54, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(connectionLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(portNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_dinle)
                    .addComponent(btn_durdur))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                .addComponent(connectionLabel))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_dinleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_dinleActionPerformed
        startListening();
    }//GEN-LAST:event_btn_dinleActionPerformed

    private void btn_durdurActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_durdurActionPerformed
        if (server.stopListening() == 1) {      //durdura basıldıysa server dinlemeyi bırakır
            connectionLabel.setText("Bağlantı yok"); //bağlantının bilgisi yazdırılır.
            btn_dinle.setEnabled(true);     
            btn_durdur.setEnabled(false);
        } else {
            connectionLabel.setText("Bağlantı kesilemedi");
        }
    }//GEN-LAST:event_btn_durdurActionPerformed

    private void portNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_portNoActionPerformed
        if (btn_dinle.isEnabled()) {    //buton aktifse dinleme başlanır
            startListening();
        }
    }//GEN-LAST:event_portNoActionPerformed

    private void startListening() {
        int port = Integer.parseInt(portNo.getText());  //port no alınır.
        if (server.startListener(port) == 1) {              //server dinlemeye başladıysa
            connectionLabel.setText("Dinlenen port: " + port); //labela mesaj yazdırır.
            btn_dinle.setEnabled(false);
            btn_durdur.setEnabled(true);
        } else {
            connectionLabel.setText("Port dinlenemedi ");
        }
    }
    
  
    
    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(ServerGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ServerGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ServerGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ServerGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                new ServerGUI().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_dinle;
    private javax.swing.JButton btn_durdur;
    private javax.swing.JLabel connectionLabel;
    private javax.swing.JTextField portNo;
    // End of variables declaration//GEN-END:variables

    private class serverWindowListener extends WindowAdapter {
        @Override
        public void windowClosing(WindowEvent e) {
            server.stopListening();
        }
    }
}
