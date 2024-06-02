package election;

import javax.swing.JOptionPane;

public class GUI_reply_message extends javax.swing.JFrame {

    private int voterID;
    private Candidate c;

    public GUI_reply_message() {
        initComponents();
    }

    public GUI_reply_message(Candidate c, int vI) {
        initComponents();
        this.c = c;
        this.voterID = vI;

        tfvoID.setText("" + vI);
        tfcaID.setText("" + c.getCandidateID());

        tfvoID.setEditable(false);
        tfcaID.setEditable(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        Backbtn2 = new javax.swing.JButton();
        senderID2 = new javax.swing.JLabel();
        senderIDlabel = new javax.swing.JLabel();
        candidateID2 = new javax.swing.JLabel();
        enterlabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        replyarea2 = new javax.swing.JTextArea();
        sendreplybtn = new javax.swing.JButton();
        tfvoID = new javax.swing.JTextField();
        tfcaID = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Election Online System");

        jPanel1.setBackground(new java.awt.Color(69, 152, 144));

        jPanel2.setBackground(new java.awt.Color(1, 33, 46));

        jLabel7.setBackground(new java.awt.Color(255, 172, 50));
        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(69, 152, 144));
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/replytitle.png"))); // NOI18N
        jLabel7.setText("Reply message");

        Backbtn2.setBackground(new java.awt.Color(69, 152, 144));
        Backbtn2.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        Backbtn2.setForeground(new java.awt.Color(0, 0, 0));
        Backbtn2.setText("<<");
        Backbtn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Backbtn2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addComponent(Backbtn2)
                .addGap(109, 109, 109)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 349, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(274, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(23, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Backbtn2))
                .addGap(25, 25, 25))
        );

        senderID2.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        senderID2.setForeground(new java.awt.Color(255, 255, 255));
        senderID2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/ID.png"))); // NOI18N
        senderID2.setText("Voter ID :");

        senderIDlabel.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        senderIDlabel.setForeground(new java.awt.Color(255, 255, 255));

        candidateID2.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        candidateID2.setForeground(new java.awt.Color(255, 255, 255));
        candidateID2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/candidateid.png"))); // NOI18N
        candidateID2.setText("Candidate ID :");

        enterlabel2.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        enterlabel2.setForeground(new java.awt.Color(255, 255, 255));
        enterlabel2.setText("Enter your reply");

        replyarea2.setColumns(20);
        replyarea2.setRows(5);
        jScrollPane1.setViewportView(replyarea2);

        sendreplybtn.setBackground(new java.awt.Color(1, 33, 46));
        sendreplybtn.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        sendreplybtn.setForeground(new java.awt.Color(255, 255, 255));
        sendreplybtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/send.png"))); // NOI18N
        sendreplybtn.setText("Send reply");
        sendreplybtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendreplybtnActionPerformed(evt);
            }
        });

        tfcaID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfcaIDActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(candidateID2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tfcaID, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(senderID2)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(senderIDlabel))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(39, 39, 39)
                                        .addComponent(tfvoID, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 755, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(enterlabel2))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(sendreplybtn)
                .addGap(343, 343, 343))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(senderID2)
                    .addComponent(senderIDlabel)
                    .addComponent(tfvoID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(candidateID2)
                    .addComponent(tfcaID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(enterlabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(sendreplybtn)
                .addContainerGap(32, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void sendreplybtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sendreplybtnActionPerformed
        JOptionPane.showMessageDialog(this, "Message sent successfully!");
    }//GEN-LAST:event_sendreplybtnActionPerformed

    private void tfcaIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfcaIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfcaIDActionPerformed

    private void Backbtn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Backbtn2ActionPerformed
        GUI_view_message msg = new GUI_view_message(c);
        msg.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_Backbtn2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GUI_reply_message.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI_reply_message.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI_reply_message.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI_reply_message.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUI_reply_message().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Backbtn2;
    private javax.swing.JLabel candidateID2;
    private javax.swing.JLabel enterlabel2;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea replyarea2;
    private javax.swing.JLabel senderID2;
    private javax.swing.JLabel senderIDlabel;
    private javax.swing.JButton sendreplybtn;
    private javax.swing.JTextField tfcaID;
    private javax.swing.JTextField tfvoID;
    // End of variables declaration//GEN-END:variables
}
