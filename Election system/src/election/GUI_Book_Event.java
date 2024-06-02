package election;

import java.awt.event.ItemEvent;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class GUI_Book_Event extends javax.swing.JFrame {

    private Voter v;

    public GUI_Book_Event() {
        initComponents();
    }

    public GUI_Book_Event(Voter v) {
        initComponents();
        this.v = v;
        fillItemsInComboBox();
        tfName.setText(v.getName());
        tfName.setEditable(false);
        tfID.setText(String.valueOf(v.getVoterID()));
        tfID.setEditable(false);
        tfEventID.setEditable(false);
    }

    public void fillItemsInComboBox() {
        for (Election e : v.viewElections()) {
            String fnum = e.getElectionTitle();
            election.addItem(fnum);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel8 = new javax.swing.JLabel();
        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        tfName = new javax.swing.JTextField();
        tfID = new javax.swing.JTextField();
        tfEventID = new javax.swing.JTextField();
        tfNoOfSeats = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        Backbtn = new javax.swing.JButton();
        cash = new javax.swing.JRadioButton();
        jCard = new javax.swing.JRadioButton();
        jLabel6 = new javax.swing.JLabel();
        tfPrice = new javax.swing.JTextField();
        crediticon = new javax.swing.JLabel();
        cashicon = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        EventTable = new javax.swing.JTable();
        bookbtn = new javax.swing.JButton();
        election = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        Candidates = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        tfReservation = new javax.swing.JTextField();

        jLabel8.setText("jLabel8");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Election Online System");

        jPanel1.setBackground(new java.awt.Color(69, 152, 144));

        tfName.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        tfID.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        tfEventID.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        tfNoOfSeats.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        tfNoOfSeats.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfNoOfSeatsActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/name.png"))); // NOI18N
        jLabel1.setText("Name");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/ID.png"))); // NOI18N
        jLabel2.setText("Voter ID");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/EventID.png"))); // NOI18N
        jLabel3.setText("Event ID");

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Election");

        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/wallet.png"))); // NOI18N
        jLabel5.setText("Payment Method");

        jPanel2.setBackground(new java.awt.Color(1, 33, 46));

        jLabel7.setBackground(new java.awt.Color(255, 172, 50));
        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(69, 152, 144));
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/book.png"))); // NOI18N
        jLabel7.setText("Book Event");

        Backbtn.setBackground(new java.awt.Color(69, 152, 144));
        Backbtn.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        Backbtn.setForeground(new java.awt.Color(255, 255, 255));
        Backbtn.setText("<<");
        Backbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackbtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addComponent(Backbtn)
                .addGap(174, 174, 174)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Backbtn))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        buttonGroup1.add(cash);
        cash.setForeground(new java.awt.Color(255, 255, 255));
        cash.setText("Cash");

        buttonGroup1.add(jCard);
        jCard.setForeground(new java.awt.Color(255, 255, 255));
        jCard.setText("Card");
        jCard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCardActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/dollarresized.png"))); // NOI18N
        jLabel6.setText("Price");

        tfPrice.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        tfPrice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfPriceActionPerformed(evt);
            }
        });

        crediticon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/credit-card.png"))); // NOI18N

        cashicon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/cash.png"))); // NOI18N

        EventTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Event ID", "Event Title", "Date", "Start Time ", "End Time", "Price", "Capacity", "No of Seats left", "Description "
            }
        ));
        EventTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                EventTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(EventTable);

        bookbtn.setBackground(new java.awt.Color(1, 33, 46));
        bookbtn.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        bookbtn.setForeground(new java.awt.Color(255, 255, 255));
        bookbtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/bookevent.png"))); // NOI18N
        bookbtn.setText("Book Event");
        bookbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bookbtnActionPerformed(evt);
            }
        });

        election.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                electionItemStateChanged(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/seats.png"))); // NOI18N
        jLabel9.setText("No.of seats");

        jLabel10.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Candidate");

        Candidates.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                CandidatesItemStateChanged(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/ID.png"))); // NOI18N
        jLabel11.setText("Reservation ID");

        tfReservation.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(128, 128, 128)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(election, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(78, 78, 78)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Candidates, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGap(250, 250, 250)
                                    .addComponent(jLabel11)
                                    .addGap(18, 18, 18)
                                    .addComponent(tfReservation, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                    .addGap(166, 166, 166)
                                                    .addComponent(cashicon)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(cash, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                    .addComponent(crediticon)
                                                    .addGap(3, 3, 3))
                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                            .addComponent(jCard)
                                            .addGap(129, 129, 129))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel2)
                                                .addComponent(jLabel3))
                                            .addGap(71, 71, 71)
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(tfID, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(tfEventID, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGap(117, 117, 117)))
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel9)
                                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(40, 40, 40)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(tfPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(tfName)
                                            .addComponent(tfNoOfSeats, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 819, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(327, 327, 327)
                                .addComponent(bookbtn)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(40, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(election, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(Candidates, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addGap(27, 27, 27)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tfReservation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addGap(39, 39, 39)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tfName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(tfID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(tfEventID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfNoOfSeats, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cashicon)
                            .addComponent(jLabel5)
                            .addComponent(cash, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addComponent(crediticon))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(tfPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel6))
                    .addComponent(jCard))
                .addGap(27, 27, 27)
                .addComponent(bookbtn)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jCardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCardActionPerformed

    }//GEN-LAST:event_jCardActionPerformed

    private void bookbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bookbtnActionPerformed
        int reservationID = Integer.parseInt(tfReservation.getText());
        int noOfSeats = Integer.parseInt(tfNoOfSeats.getText());

        DefaultTableModel model = (DefaultTableModel) EventTable.getModel();
        int SelectedRow = EventTable.getSelectedRow();
        int col = 0;
        int eventID = Integer.parseInt(model.getValueAt(SelectedRow, col++).toString());
        String title = (String) model.getValueAt(SelectedRow, col++);
        String date = model.getValueAt(SelectedRow, col++).toString();
        String sTime = (String) model.getValueAt(SelectedRow, col++);
        String endTime = model.getValueAt(SelectedRow, col++).toString();
        float Price = Float.parseFloat(model.getValueAt(SelectedRow, col++).toString());
        int capacity = Integer.parseInt(model.getValueAt(SelectedRow, col++).toString());
        int noOfSeatsAvailable = Integer.parseInt(model.getValueAt(SelectedRow, col++).toString());
        String info = model.getValueAt(SelectedRow, col++).toString();

        Event e = new Event(eventID, title, date, sTime, endTime, Price, capacity, noOfSeatsAvailable, info);
        Reservation r = new Reservation(reservationID, noOfSeats, e);
        v.setReservations(r);
        if (v.makeReservation()) {
            JOptionPane.showMessageDialog(this, "Reservation made succeffully");
            if (jCard.isSelected()) {
                v.getReservations().getPay().setPaymentMethod(new PayByCard());
                v.getReservations().getPay().makePayment();
            } else if (cash.isSelected()) {
                v.getReservations().getPay().setPaymentMethod(new PayBYCash());
                v.getReservations().getPay().makePayment();
            }

        } else {
            JOptionPane.showMessageDialog(this, " No available seats");
        }

    }//GEN-LAST:event_bookbtnActionPerformed

    private void BackbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackbtnActionPerformed
        GUI_Voter_MENU menu = new GUI_Voter_MENU(v);
        menu.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_BackbtnActionPerformed

    private void electionItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_electionItemStateChanged

        if (evt.getStateChange() == ItemEvent.SELECTED) { // Check if the event is due to a selection change
            String electionName = (String) election.getSelectedItem();
            Election selectedElection = new Election();
            selectedElection = selectedElection.getElectionByName(electionName);
            v.setVote(selectedElection);

            Candidates.removeAllItems();

            ArrayList<Candidate> participatingCandidates = v.viewParticipatingCandidates();

            if (participatingCandidates.isEmpty()) {
                Candidates.removeAllItems();
            } else {
                // Add candidate names to the Candidates combo box
                for (Candidate c : participatingCandidates) {
                    String candidateName = c.getName();
                    Candidates.addItem(candidateName);
                }
            }
        }
    }//GEN-LAST:event_electionItemStateChanged

    private void CandidatesItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_CandidatesItemStateChanged
        int cID = 0;
        String candidateName = (String) Candidates.getSelectedItem();

        if (candidateName != null) {
            for (Candidate c : v.viewParticipatingCandidates()) {
                if (candidateName.equals(c.getName())) {
                    cID = c.getCandidateID();
                }
            }

            DefaultTableModel model = (DefaultTableModel) EventTable.getModel();
            model.setRowCount(v.viewCandidateEvents(cID).size());
            int row = 0;
            int col;

            for (Event e : v.viewCandidateEvents(cID)) {

                col = 0;
                model.setValueAt(e.getEventID(), row, col++);
                model.setValueAt(e.getEventTitle(), row, col++);
                model.setValueAt(e.getEventDate(), row, col++);
                model.setValueAt(e.getEventStartTime(), row, col++);
                model.setValueAt(e.getEventEndTime(), row, col++);
                model.setValueAt(e.getEventPrice(), row, col++);
                model.setValueAt(e.getEventCapacity(), row, col++);
                model.setValueAt(e.getNoOfSeatsAvailable(), row, col++);
                model.setValueAt(e.getEventInfo(), row, col++);
                row++;
            }

            tfEventID.setText("");
            tfEventID.setEditable(false);
        }
    }//GEN-LAST:event_CandidatesItemStateChanged

    private void EventTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EventTableMouseClicked

        DefaultTableModel model = (DefaultTableModel) EventTable.getModel();
        int SelectedRow = EventTable.getSelectedRow();
        String eventID = String.valueOf(model.getValueAt(SelectedRow, 0));
        tfEventID.setText(eventID);
        tfEventID.setEditable(false);
    }//GEN-LAST:event_EventTableMouseClicked

    private void tfPriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfPriceActionPerformed

    }//GEN-LAST:event_tfPriceActionPerformed

    private void tfNoOfSeatsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfNoOfSeatsActionPerformed
        DefaultTableModel model = (DefaultTableModel) EventTable.getModel();
        int SelectedRow = EventTable.getSelectedRow();

        float Price = Float.parseFloat(model.getValueAt(SelectedRow, 5).toString());

        int numberOfBookedSeat = Integer.parseInt(tfNoOfSeats.getText());
        float totalPrice = numberOfBookedSeat * Price;
        tfPrice.setText(String.valueOf(totalPrice));
    }//GEN-LAST:event_tfNoOfSeatsActionPerformed

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
            java.util.logging.Logger.getLogger(GUI_Book_Event.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI_Book_Event.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI_Book_Event.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI_Book_Event.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
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
                new GUI_Book_Event().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Backbtn;
    private javax.swing.JComboBox<String> Candidates;
    private javax.swing.JTable EventTable;
    private javax.swing.JButton bookbtn;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JRadioButton cash;
    private javax.swing.JLabel cashicon;
    private javax.swing.JLabel crediticon;
    private javax.swing.JComboBox<String> election;
    private javax.swing.JRadioButton jCard;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField tfEventID;
    private javax.swing.JTextField tfID;
    private javax.swing.JTextField tfName;
    private javax.swing.JTextField tfNoOfSeats;
    private javax.swing.JTextField tfPrice;
    private javax.swing.JTextField tfReservation;
    // End of variables declaration//GEN-END:variables
}
