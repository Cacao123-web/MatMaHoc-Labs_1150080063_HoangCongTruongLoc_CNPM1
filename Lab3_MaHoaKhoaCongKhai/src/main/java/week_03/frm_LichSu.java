package week_03;

import javax.swing.JOptionPane;

public class frm_LichSu extends javax.swing.JFrame {

    public frm_LichSu() {
        initComponents();
        setLocationRelativeTo(null);
        tbl_history.setModel(HistoryDao.emptyModel());
        loadData();
    }

    /** Đọc 50 dòng mới nhất từ SQL Server và hiện lên JTable. */
    private void loadData() {
        try {
            tbl_history.setModel(HistoryDao.loadLatest(50));
            lbl_status.setText("Đã tải " + tbl_history.getRowCount() + " dòng mới nhất từ dbo.History.");
        } catch (java.sql.SQLException ex) {
            lbl_status.setText("Không đọc được lịch sử: " + ex.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_history = new javax.swing.JTable();
        btn_refresh = new javax.swing.JButton();
        lbl_status = new javax.swing.JLabel();

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setTitle("Lịch sử thao tác (SQL Server)");
        jLabel1.setText("LỊCH SỬ THAO TÁC - BẢNG DBO.HISTORY");
        jLabel1.setFont(new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 18));
        jScrollPane1.setViewportView(tbl_history);
        btn_refresh.setText("Tải lại");
        btn_refresh.addActionListener(this::btn_refreshActionPerformed);
        lbl_status.setText("Đang tải...");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup()
            .addGroup(layout.createSequentialGroup().addGap(18)
                .addGroup(layout.createParallelGroup()
                .addGroup(layout.createSequentialGroup()
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 760, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createSequentialGroup()
                    .addComponent(jScrollPane1, 0, 760, Short.MAX_VALUE))
                .addGroup(layout.createSequentialGroup()
                    .addComponent(btn_refresh, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(12)
                    .addComponent(lbl_status, javax.swing.GroupLayout.PREFERRED_SIZE, 640, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18)));
        layout.setVerticalGroup(layout.createParallelGroup()
            .addGroup(layout.createSequentialGroup().addGap(12)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(7)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(7)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(btn_refresh, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(lbl_status, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(12, Short.MAX_VALUE)));
        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_refreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_refreshActionPerformed
        loadData();
    }//GEN-LAST:event_btn_refreshActionPerformed

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> new frm_LichSu().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTable tbl_history;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton btn_refresh;
    private javax.swing.JLabel lbl_status;
    // End of variables declaration//GEN-END:variables
}
