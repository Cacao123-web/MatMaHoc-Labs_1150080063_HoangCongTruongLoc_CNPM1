package week_03;

import javax.swing.JOptionPane;

public class frm_RSA_AES extends javax.swing.JFrame {
    private final RSA_AES_Cipher hybrid = new RSA_AES_Cipher();

    public frm_RSA_AES() {
        initComponents();
        setLocationRelativeTo(null);
    }

    /** Hiện khóa công khai / khóa riêng (Base64) lên form. */
    private void showKeys() {
        txt_public.setText(hybrid.getPublicKeyBase64());
        txt_private.setText(hybrid.getPrivateKeyBase64().isEmpty() ? "" : "[Khóa riêng đã nạp]");
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
        txt_plaintext = new javax.swing.JTextArea();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        txt_ciphertext = new javax.swing.JTextArea();
        btn_encrypt = new javax.swing.JButton();
        btn_decrypt = new javax.swing.JButton();
        btn_tamper = new javax.swing.JButton();
        lbl_status = new javax.swing.JLabel();

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setTitle("RSA + AES Cipher");
        jLabel1.setText("HỆ MÃ LAI RSA + AES-GCM (VĂN BẢN DÀI)");
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
        jLabel4.setText("Plaintext:");
        txt_plaintext.setLineWrap(true);
        txt_plaintext.setRows(3);
        jScrollPane3.setViewportView(txt_plaintext);
        jLabel5.setText("Ciphertext:");
        txt_ciphertext.setLineWrap(true);
        txt_ciphertext.setRows(3);
        jScrollPane4.setViewportView(txt_ciphertext);
        btn_encrypt.setText("Encrypt");
        btn_encrypt.addActionListener(this::btn_encryptActionPerformed);
        btn_decrypt.setText("Decrypt");
        btn_decrypt.addActionListener(this::btn_decryptActionPerformed);
        btn_tamper.setText("Sửa 1 ký tự bản mã");
        btn_tamper.addActionListener(this::btn_tamperActionPerformed);
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
                    .addComponent(btn_encrypt, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(12)
                    .addComponent(btn_decrypt, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(12)
                    .addComponent(btn_tamper, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(7)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(7)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(btn_encrypt, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(btn_decrypt, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(btn_tamper, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(7)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(lbl_status, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(12, Short.MAX_VALUE)));
        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_generateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_generateActionPerformed
        try {
            hybrid.generateKeys();
            showKeys();
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
        String content = CryptoSupport.toKeyFile(txt_public.getText(), hybrid.getPrivateKeyBase64());
        String path = FileTextIO.saveString(this, content, "rsa_aes_keys.txt");
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
            hybrid.loadKeys(keys[0], keys[1]);
            showKeys();
            lbl_status.setText("Đã nạp khóa từ tệp.");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Tệp khóa không hợp lệ: " + ex.getMessage(),  "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btn_loadkeysActionPerformed

    private void btn_encryptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_encryptActionPerformed
        String plaintext = txt_plaintext.getText();
        if (plaintext.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Hãy nhập Plaintext trước khi mã hóa.");  return;
        }
        try {
            String ciphertext = hybrid.encrypt(plaintext);
            txt_ciphertext.setText(ciphertext);
            txt_ciphertext.setCaretPosition(0);
            lbl_status.setText("Đã mã hóa RSA-AES (" + ciphertext.length() + " ký tự Base64). "  + HistoryDao.tryInsert("RSA-AES", "ENCRYPT", plaintext.length(), true));
        } catch (Exception ex) {
            HistoryDao.tryInsert("RSA-AES", "ENCRYPT", plaintext.length(), false);
            JOptionPane.showMessageDialog(this, "Mã hóa thất bại: " + ex.getMessage(),  "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btn_encryptActionPerformed

    private void btn_decryptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_decryptActionPerformed
        String ciphertext = txt_ciphertext.getText();
        if (ciphertext.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Hãy nhập Ciphertext trước khi giải mã.");  return;
        }
        try {
            String plaintext = hybrid.decrypt(ciphertext);
            txt_plaintext.setText(plaintext);
            txt_plaintext.setCaretPosition(0);
            lbl_status.setText("Đã giải mã RSA-AES. " + HistoryDao.tryInsert("RSA-AES", "DECRYPT",
            ciphertext.length(), true));
        } catch (Exception ex) {
            HistoryDao.tryInsert("RSA-AES", "DECRYPT", ciphertext.length(), false);
            lbl_status.setText("Giải mã RSA-AES THẤT BẠI (sai khóa hoặc bản mã bị sửa).");
            JOptionPane.showMessageDialog(this, "Giải mã thất bại: sai khóa riêng hoặc bản mã bị sửa.\n"  + ex,
            "Giải mã thất bại", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btn_decryptActionPerformed

    private void btn_tamperActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_tamperActionPerformed
        try {

            byte[] data = CryptoSupport.unb64(txt_ciphertext.getText());

            if (data.length < 284) {

                throw new IllegalArgumentException("Hãy Encrypt trước.");

            }

            int index = Math.max(268, data.length / 2);
            data[index] ^= 1;

            txt_ciphertext.setText(CryptoSupport.b64(data));

            lbl_status.setText("Đã sửa dữ liệu AES-GCM. Bấm Decrypt để kiểm tra.");
        } catch (IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Bản mã không hợp lệ", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btn_tamperActionPerformed

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> new frm_RSA_AES().setVisible(true));
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
    private javax.swing.JTextArea txt_plaintext;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextArea txt_ciphertext;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JButton btn_encrypt;
    private javax.swing.JButton btn_decrypt;
    private javax.swing.JButton btn_tamper;
    private javax.swing.JLabel lbl_status;
    // End of variables declaration//GEN-END:variables
}
