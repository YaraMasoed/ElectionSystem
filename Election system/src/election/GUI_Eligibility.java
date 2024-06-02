package election;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class GUI_Eligibility extends javax.swing.JFrame {

    Voter v;
    Candidate c;
    Admin a;

    public GUI_Eligibility(Admin a) {
        initComponents();
        this.v = new Voter();
        this.a = a;
        this.c = new Candidate();
        votersTable();
        candidateTable();
    }

    public GUI_Eligibility() {
        initComponents();
        votersTable();
        candidateTable();
    }

    void votersTable() {
        DefaultTableModel model = (DefaultTableModel) VoterTable.getModel();
        model.setRowCount(v.getAllVoter().size());
        int row = 0;
        int col;

        for (Voter v : v.getAllVoter()) {
            col = 0;
            model.setValueAt(v.getVoterID(), row, col++);
            model.setValueAt(v.getName(), row, col++);
            model.setValueAt(v.getGender(), row, col++);
            model.setValueAt(v.getEmail(), row, col++);
            model.setValueAt(v.getNationalID(), row, col++);
            model.setValueAt(v.getDateOfBirth(), row, col++);
            model.setValueAt(v.getUsername(), row, col++);
            model.setValueAt(v.getPassword(), row, col++);
            model.setValueAt(v.isApproved(), row, col);
            row++;
        }
    }

    void candidateTable() {
        DefaultTableModel model = (DefaultTableModel) CandidateTable.getModel();
        model.setRowCount(c.viewAllCandidates().size());
        int row = 0;
        int col;

        for (Candidate c : c.viewAllCandidates()) {
            col = 0;
            model.setValueAt(c.getCandidateID(), row, col++);
            model.setValueAt(c.getName(), row, col++);
            model.setValueAt(c.getGender(), row, col++);
            model.setValueAt(c.getEmail(), row, col++);
            model.setValueAt(c.getNationalID(), row, col++);
            model.setValueAt(c.getDateOfBirth(), row, col++);
            model.setValueAt(c.getUsername(), row, col++);
            model.setValueAt(c.getPassword(), row, col++);
            model.setValueAt(c.getPosition(), row, col++);
            model.setValueAt(c.getYearsOfexp(), row, col++);
            model.setValueAt(c.getROIelection().getElectionID(), row, col++);
            model.setValueAt(c.isApproved(), row, col);
            row++;
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        VoterTable = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        Backbtn = new javax.swing.JButton();
        ElegibilityBTN = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        CandidateTable = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        ElegibilityBTN1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("KAYPS Airline");

        jPanel2.setBackground(new java.awt.Color(69, 152, 144));

        VoterTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Voter ID", "Name", "Gender", "Email", "nationalID", "DOB", "username", "password", "approved"
            }
        ));
        jScrollPane1.setViewportView(VoterTable);

        jPanel3.setBackground(new java.awt.Color(1, 33, 46));

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/approvedresized.png"))); // NOI18N
        jLabel7.setText("Check Elegibility");

        Backbtn.setBackground(new java.awt.Color(69, 152, 144));
        Backbtn.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        Backbtn.setForeground(new java.awt.Color(0, 0, 0));
        Backbtn.setText("<<");
        Backbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackbtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(Backbtn)
                .addGap(282, 282, 282)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(Backbtn))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        ElegibilityBTN.setBackground(new java.awt.Color(1, 33, 46));
        ElegibilityBTN.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        ElegibilityBTN.setForeground(new java.awt.Color(255, 255, 255));
        ElegibilityBTN.setText("Check Eligibility");
        ElegibilityBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ElegibilityBTNActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Candidates");

        CandidateTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Candidate ID", "Name", "Gender", "Email", "nationalID", "DOB", "username", "password", "Position", "Experience", "Election ID", "approved"
            }
        ));
        jScrollPane2.setViewportView(CandidateTable);

        jLabel9.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Voters");

        ElegibilityBTN1.setBackground(new java.awt.Color(1, 33, 46));
        ElegibilityBTN1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        ElegibilityBTN1.setForeground(new java.awt.Color(255, 255, 255));
        ElegibilityBTN1.setText("Check Eligibility");
        ElegibilityBTN1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ElegibilityBTN1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1050, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1050, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(16, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(ElegibilityBTN1)
                                .addGap(431, 431, 431))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(ElegibilityBTN)
                                .addGap(429, 429, 429))))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ElegibilityBTN1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ElegibilityBTN)
                .addGap(33, 33, 33))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void BackbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackbtnActionPerformed
        GUI_Admin_MENU menu = new GUI_Admin_MENU(a);
        menu.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_BackbtnActionPerformed

    private void ElegibilityBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ElegibilityBTNActionPerformed
        //retrives that voters details to check thier elgibility
        DefaultTableModel model = (DefaultTableModel) CandidateTable.getModel();
        int SelectedRow = CandidateTable.getSelectedRow();
        int col = 0;

        int CandidateID = (int) model.getValueAt(SelectedRow, col++);
        String name = model.getValueAt(SelectedRow, col++).toString();
        char gender = model.getValueAt(SelectedRow, col++).toString().charAt(0);
        String email = model.getValueAt(SelectedRow, col++).toString();
        String nationalID = model.getValueAt(SelectedRow, col++).toString();
        String dateOfBirth = model.getValueAt(SelectedRow, col++).toString();
        String username = model.getValueAt(SelectedRow, col++).toString();
        String password = model.getValueAt(SelectedRow, col++).toString();
        String position = model.getValueAt(SelectedRow, col++).toString();
        int YOE = (int) model.getValueAt(SelectedRow, col++);
        int electionID = (int) model.getValueAt(SelectedRow, col++);
        boolean approved = Boolean.parseBoolean(model.getValueAt(SelectedRow, col++).toString());

        Election ele = new Election();
        ele = ele.getElectionByID(electionID);

        if (approved) {
            JOptionPane.showMessageDialog(this, "Already Approved");
        } else {
            Candidate c = new Candidate(CandidateID, approved, position, YOE, ele, name, gender, email, nationalID, dateOfBirth, username, password);
            a.setEligibility(new CandidateEligibility());
            if (a.checkElegibility(c)) {
                JOptionPane.showMessageDialog(this, "Approved");
            } else {
                JOptionPane.showMessageDialog(this, "Not Approved");
            }
        }
        candidateTable();
    }//GEN-LAST:event_ElegibilityBTNActionPerformed

    private void ElegibilityBTN1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ElegibilityBTN1ActionPerformed
        //retrives that voters details to check thier elgibility
        DefaultTableModel model = (DefaultTableModel) VoterTable.getModel();
        int SelectedRow = VoterTable.getSelectedRow();
        int col = 0;

        int voterID = (int) model.getValueAt(SelectedRow, col++);
        String name = model.getValueAt(SelectedRow, col++).toString();
        char gender = model.getValueAt(SelectedRow, col++).toString().charAt(0);
        String email = model.getValueAt(SelectedRow, col++).toString();
        String nationalID = model.getValueAt(SelectedRow, col++).toString();
        String dateOfBirth = model.getValueAt(SelectedRow, col++).toString();
        String username = model.getValueAt(SelectedRow, col++).toString();
        String password = model.getValueAt(SelectedRow, col++).toString();
        boolean approved = Boolean.parseBoolean(model.getValueAt(SelectedRow, col++).toString());

        if (approved) {
            JOptionPane.showMessageDialog(this, "Already Approved");
        } else {
            Voter voter = new Voter(voterID, approved, name, gender, email, nationalID, dateOfBirth, username, password);
            a.setEligibility(new VoterEligibility());
            if (a.checkElegibility(voter)) {
                JOptionPane.showMessageDialog(this, "Approved");
            } else {
                JOptionPane.showMessageDialog(this, "Not Approved");
            }
        }

        votersTable();
    }//GEN-LAST:event_ElegibilityBTN1ActionPerformed

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
            java.util.logging.Logger.getLogger(GUI_Eligibility.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI_Eligibility.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI_Eligibility.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI_Eligibility.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUI_Eligibility().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Backbtn;
    private javax.swing.JTable CandidateTable;
    private javax.swing.JButton ElegibilityBTN;
    private javax.swing.JButton ElegibilityBTN1;
    private javax.swing.JTable VoterTable;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
