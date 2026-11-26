package week_03;

import javax.swing.JOptionPane;

public class frm_ECC_Signature extends javax.swing.JFrame {
    private final ECCSignature ecdsa = new ECCSignature();

    public frm_ECC_Signature() {
        initComponents();
        setLocationRelativeTo(null);
    }

    /** Hiện khóa công khai / khóa riêng (Base64) lên form. */
    private void showKeys() {
        txt_public.setText(ecdsa.getPublicKeyBase64());
        txt_private.setText(ecdsa.getPrivateKeyBase64().isEmpty() ? "" : "[Khóa riêng đã nạp]");
        txt_public.setCaretPosition(0);
        txt_private.setCaretPosition(0);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txt_public = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txt_private = new javax.swing.JTextArea();
        btn_generate = new javax.swing.JButton();
        btn_savekeys = new javax.swing.JButton();
        btn_loadkeys = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        txt_message = new javax.swing.JTextArea();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        txt_signature = new javax.swing.JTextArea();
        btn_sign = new javax.swing.JButton();
        btn_verify = new javax.swing.JButton();
        lbl_result = new javax.swing.JLabel();
        lbl_status = new javax.swing.JLabel();

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setTitle("ECDSA Signature");
        jLabel1.setText("CHỮ KÝ SỐ ECDSA (SHA256withECDSA)");
        jLabel1.setFont(new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 18));
        jLabel2.setText("Public key:");
        txt_public.setLineWrap(true);
        txt_public.setRows(2);
        txt_public.setEditable(false);
        jScrollPane1.setViewportView(txt_public);
        jLabel3.setText("Private key:");
        txt_private.setLineWrap(true);
        txt_private.setRows(2);
        txt_private.setEditable(false);
        jScrollPane2.setViewportView(txt_private);
        btn_generate.setText("Generate Keys");
        btn_generate.addActionListener(this::btn_generateActionPerformed);
        btn_savekeys.setText("Save Keys");
        btn_savekeys.addActionListener(this::btn_savekeysActionPerformed);
        btn_loadkeys.setText("Load Keys");
        btn_loadkeys.addActionListener(this::btn_loadkeysActionPerformed);
        jLabel4.setText("Message:");
        txt_message.setLineWrap(true);
        txt_message.setRows(2);
        jScrollPane3.setViewportView(txt_message);
        jLabel5.setText("Signature:");
        txt_signature.setLineWrap(true);
        txt_signature.setRows(2);
        jScrollPane4.setViewportView(txt_signature);
        btn_sign.setText("Sign");
        btn_sign.addActionListener(this::btn_signActionPerformed);
        btn_verify.setText("Verify");
        btn_verify.addActionListener(this::btn_verifyActionPerformed);
        lbl_result.setFont(new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 20));
        lbl_status.setText("Bấm Generate Keys hoặc Load Keys.");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup()
            .addGroup(layout.createSequentialGroup().addGap(18)
                .addGroup(layout.createParallelGroup()
                .addGroup(layout.createSequentialGroup()
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createSequentialGroup()
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(12)
                    .addComponent(jScrollPane1, 0, 600, Short.MAX_VALUE))
                .addGroup(layout.createSequentialGroup()
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(12)
                    .addComponent(jScrollPane2, 0, 600, Short.MAX_VALUE))
                .addGroup(layout.createSequentialGroup()
                    .addGap(116)
                    .addComponent(btn_generate, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(12)
                    .addComponent(btn_savekeys, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(12)
                    .addComponent(btn_loadkeys, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createSequentialGroup()
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(12)
                    .addComponent(jScrollPane3, 0, 600, Short.MAX_VALUE))
                .addGroup(layout.createSequentialGroup()
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(12)
                    .addComponent(jScrollPane4, 0, 600, Short.MAX_VALUE))
                .addGroup(layout.createSequentialGroup()
                    .addGap(116)
                    .addComponent(btn_sign, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(12)
                    .addComponent(btn_verify, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(12)
                    .addComponent(lbl_result, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createSequentialGroup()
                    .addGap(116)
                    .addComponent(lbl_status, 0, 600, Short.MAX_VALUE)))
                .addGap(18)));
        layout.setVerticalGroup(layout.createParallelGroup()
            .addGroup(layout.createSequentialGroup().addGap(12)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(7)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(7)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(7)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(btn_generate, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(btn_savekeys, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(btn_loadkeys, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(7)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(7)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(7)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(btn_sign, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(btn_verify, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(lbl_result, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(7)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(lbl_status, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(12, Short.MAX_VALUE)));
        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_generateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_generateActionPerformed
        try {
            ecdsa.generateKeys();
            showKeys();

            lbl_result.setText("");
            lbl_status.setText("Đã tạo cặp khóa mới. Bản mã/chữ ký cũ sẽ không dùng được với khóa  mới.");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Không tạo được khóa: " + ex.getMessage(),  "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btn_generateActionPerformed

    private void btn_savekeysActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_savekeysActionPerformed
        if (txt_public.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Chưa có khóa để lưu.");
            return;
        }
        String content = CryptoSupport.toKeyFile(txt_public.getText(), ecdsa.getPrivateKeyBase64());
        String path = FileTextIO.saveString(this, content, "ecdsa_keys.txt");
        if (path != null) {
            lbl_status.setText("Đã lưu khóa vào: " + path + " (giữ bí mật dòng PRIVATE).");
        }
    }//GEN-LAST:event_btn_savekeysActionPerformed

    private void btn_loadkeysActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_loadkeysActionPerformed
        String content = FileTextIO.openString(this);
        if (content == null) {
            return;
        }
        try {
            String[] keys = CryptoSupport.fromKeyFile(content);
            ecdsa.loadKeys(keys[0], keys[1]);
            showKeys();
            lbl_status.setText("Đã nạp khóa từ tệp.");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Tệp khóa không hợp lệ: " + ex.getMessage(),  "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btn_loadkeysActionPerformed

    private void btn_signActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_signActionPerformed
        String message = txt_message.getText();
        try {
            txt_signature.setText(ecdsa.sign(message));
            lbl_result.setText("");
            lbl_status.setText("Đã ký bằng KHÓA RIÊNG. " + HistoryDao.tryInsert("ECDSA", "SIGN",
            message.length(), true));
        } catch (Exception ex) {

            lbl_result.setText("");

            lbl_status.setText(HistoryDao.tryInsert("ECDSA", "SIGN", message.length(), false));
            JOptionPane.showMessageDialog(this, "Ký thất bại: " + ex.getMessage(),  "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btn_signActionPerformed

    private void btn_verifyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_verifyActionPerformed
        String message = txt_message.getText();
        try {
            boolean ok = ecdsa.verify(message, txt_signature.getText());
            lbl_result.setText(ok ? "VALID" : "INVALID");
            lbl_result.setForeground(ok ? new java.awt.Color(0, 128, 0) : java.awt.Color.RED);
            lbl_status.setText("Đã xác minh bằng KHÓA CÔNG KHAI. " + HistoryDao.tryInsert("ECDSA",  "VERIFY", message.length(), ok));
        } catch (Exception ex) {

            lbl_result.setText("");

            lbl_status.setText(HistoryDao.tryInsert("ECDSA", "VERIFY", message.length(), false));
            JOptionPane.showMessageDialog(this, "Xác minh thất bại: " + ex.getMessage(),  "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btn_verifyActionPerformed

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> new frm_ECC_Signature().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextArea txt_public;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextArea txt_private;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton btn_generate;
    private javax.swing.JButton btn_savekeys;
    private javax.swing.JButton btn_loadkeys;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextArea txt_message;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextArea txt_signature;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JButton btn_sign;
    private javax.swing.JButton btn_verify;
    private javax.swing.JLabel lbl_result;
    private javax.swing.JLabel lbl_status;
    // End of variables declaration//GEN-END:variables
}
