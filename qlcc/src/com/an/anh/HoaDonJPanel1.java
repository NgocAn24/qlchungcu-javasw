package com.an.anh;

import com.an.HoaDon;
import com.an.Nhanvien;
import java.awt.Dimension;

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ngoca
 */
public class HoaDonJPanel1 extends javax.swing.JPanel {
	 
	  private int id;
	 private Connection connection;;

    
    
	  private boolean isIdExists(String id) {
        try {
            String query = "SELECT COUNT(*) AS count FROM HOADON WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, id);
            ResultSet result = preparedStatement.executeQuery();

            if (result.next()) {
                int count = result.getInt("count");
                return count > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
	 
	 
    private void connectToDatabase() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String connectionUrl = "jdbc:sqlserver://localhost:1433;databaseName=DANGNHAP;user=sa;password=123456;encrypt=true;trustServerCertificate=true";
            connection = DriverManager.getConnection(connectionUrl);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    
    
    
    
   private void loadDataToTable() {
        try {
            String query = "select * from HOADON"; // Sửa truy vấn SQL tùy theo cấu trúc cơ sở dữ liệu của bạn.
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(query);

            DefaultTableModel model = (DefaultTableModel) table1.getModel();
            model.setRowCount(0); // Xóa dữ liệu cũ trong bảng

            while (result.next()) {
                Object[] row = {
                    result.getString("id"),
                    result.getString("chuho"),
                    result.getDouble("dien"),
                    result.getDouble("nuoc"),
                    result.getDouble("dichvu"),
                    result.getDouble("tong")
                };
                model.addRow(row);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
 public HoaDonJPanel1() {
        initComponents();
	loadDataToTable();
	connectToDatabase();
	
 }

 
 
 
 
 
    
	/**
	 * This method is called from within the constructor to initialize the
	 * form. WARNING: Do NOT modify this code. The content of this method is
	 * always regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
        // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
        private void initComponents() {

                jPanel1 = new javax.swing.JPanel();
                jPanel2 = new javax.swing.JPanel();
                jThanhtoan = new javax.swing.JButton();
                jChinh = new javax.swing.JButton();
                jLabel3 = new javax.swing.JLabel();
                jLabel4 = new javax.swing.JLabel();
                jLabel5 = new javax.swing.JLabel();
                txtNuoc = new javax.swing.JTextField();
                txtDien = new javax.swing.JTextField();
                txtDichvu = new javax.swing.JTextField();
                jLabel8 = new javax.swing.JLabel();
                txtId = new javax.swing.JTextField();
                txtChuho = new javax.swing.JTextField();
                jLabel1 = new javax.swing.JLabel();
                jLabel2 = new javax.swing.JLabel();
                jScrollPane1 = new javax.swing.JScrollPane();
                table1 = new javax.swing.JTable();
                jPanel3 = new javax.swing.JPanel();
                jLabel7 = new javax.swing.JLabel();

                jPanel1.setBackground(new java.awt.Color(204, 255, 255));

                jPanel2.setBackground(new java.awt.Color(255, 255, 255));
                jPanel2.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

                jThanhtoan.setText("Thanh toán");
                jThanhtoan.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                jThanhtoanActionPerformed(evt);
                        }
                });

                jChinh.setText("Chỉnh sửa");
                jChinh.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                jChinhActionPerformed(evt);
                        }
                });

                jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
                jLabel3.setForeground(new java.awt.Color(204, 204, 204));
                jLabel3.setText("Số điện");

                jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
                jLabel4.setForeground(new java.awt.Color(204, 204, 204));
                jLabel4.setText("Số nước");

                jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
                jLabel5.setForeground(new java.awt.Color(204, 204, 204));
                jLabel5.setText("Tiền dịch vụ");

                txtNuoc.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                txtNuocActionPerformed(evt);
                        }
                });

                txtDien.addMouseListener(new java.awt.event.MouseAdapter() {
                        public void mouseClicked(java.awt.event.MouseEvent evt) {
                                txtDienMouseClicked(evt);
                        }
                });
                txtDien.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                txtDienActionPerformed(evt);
                        }
                });

                txtDichvu.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                txtDichvuActionPerformed(evt);
                        }
                });

                txtChuho.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                txtChuhoActionPerformed(evt);
                        }
                });

                jLabel1.setForeground(new java.awt.Color(204, 204, 204));
                jLabel1.setText("ID");

                jLabel2.setForeground(new java.awt.Color(204, 204, 204));
                jLabel2.setText("Chủ hộ");

                table1.setModel(new javax.swing.table.DefaultTableModel(
                        new Object [][] {
                                {null, null, null, null, null, null},
                                {null, null, null, null, null, null},
                                {null, null, null, null, null, null},
                                {null, null, null, null, null, null}
                        },
                        new String [] {
                                "id", "Tên", "Điện", "Nước", "Dịch vụ", "Tổng"
                        }
                ));
                jScrollPane1.setViewportView(table1);

                javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
                jPanel2.setLayout(jPanel2Layout);
                jPanel2Layout.setHorizontalGroup(
                        jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                                .addGap(145, 145, 145)
                                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                                                .addComponent(jLabel1)
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                                .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                                                .addComponent(jLabel2)
                                                                                .addGap(18, 18, 18)
                                                                                .addComponent(txtChuho, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                                .addGap(43, 43, 43)
                                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(jLabel4)))
                                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                                .addGap(173, 173, 173)
                                                                .addComponent(jThanhtoan, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                                .addGap(18, 18, 18)
                                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(txtDien, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(txtNuoc, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(jLabel8))
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                                                                .addComponent(jChinh, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(161, 161, 161))))
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jLabel5)
                                                .addGap(18, 18, 18)
                                                .addComponent(txtDichvu, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(145, 145, 145)))
                                .addContainerGap())
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(33, 33, 33)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 763, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                );
                jPanel2Layout.setVerticalGroup(
                        jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGap(91, 91, 91)
                                                .addComponent(jLabel8))
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGap(23, 23, 23)
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(txtDien, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel3)
                                                        .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel1))
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                                .addGap(20, 20, 20)
                                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                                        .addComponent(txtNuoc, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(jLabel4)))
                                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                                .addGap(44, 44, 44)
                                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                                        .addComponent(txtChuho, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(jLabel2))))
                                                .addGap(1, 1, 1)
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(txtDichvu, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel5))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jThanhtoan, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jChinh, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(26, 26, 26))
                );

                jPanel3.setBackground(new java.awt.Color(204, 255, 204));

                jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
                jLabel7.setForeground(new java.awt.Color(255, 204, 204));
                jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                jLabel7.setText("Hóa đơn");

                javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
                jPanel3.setLayout(jPanel3Layout);
                jPanel3Layout.setHorizontalGroup(
                        jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(274, 274, 274)
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(390, Short.MAX_VALUE))
                );
                jPanel3Layout.setVerticalGroup(
                        jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addComponent(jLabel7)
                                .addContainerGap(20, Short.MAX_VALUE))
                );

                javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
                jPanel1.setLayout(jPanel1Layout);
                jPanel1Layout.setHorizontalGroup(
                        jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                );
                jPanel1Layout.setVerticalGroup(
                        jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(18, Short.MAX_VALUE))
                );

                javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
                this.setLayout(layout);
                layout.setHorizontalGroup(
                        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 6, Short.MAX_VALUE))
                );
                layout.setVerticalGroup(
                        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                );

                getAccessibleContext().setAccessibleName("872");
                getAccessibleContext().setAccessibleDescription("548");
        }// </editor-fold>//GEN-END:initComponents

        private void jChinhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jChinhActionPerformed
        String id = txtId.getText();
        String chuho = txtChuho.getText();
        String dienText = txtDien.getText();
        String nuocText = txtNuoc.getText();
        String dichvuText = txtDichvu.getText();

        // Kiểm tra nếu một trong các trường trống
        if (id.isEmpty() || chuho.isEmpty() || dienText.isEmpty() || nuocText.isEmpty() || dichvuText.isEmpty()) {
            // Hiển thị thông báo nếu có trường trống
            JOptionPane.showMessageDialog(this, "Vui lòng điền đầy đủ thông tin");
        } else {
            // Kiểm tra xem id đã tồn tại hay chưa
            if (isIdExists(id)) {
                JOptionPane.showMessageDialog(this, "ID đã tồn tại. Vui lòng chọn ID khác.");
            } else {
                try {
                    double dien = Double.parseDouble(dienText) * 2000; // Convert to kWh
                    double nuoc = Double.parseDouble(nuocText) * 14000; // Convert to m3
                    double dichvu = Double.parseDouble(dichvuText);

                    // Tính tổng tiền
                    double tong = dien + nuoc + dichvu;

                    // Thực hiện chèn dữ liệu vào CSDL
                    insertDataIntoDatabase(id, chuho, dien, nuoc, dichvu, tong);

                    // Hiển thị thông báo "Đã cập nhật dữ liệu thành công"
                    JOptionPane.showMessageDialog(this, "Đã cập nhật dữ liệu thành công");

                    // Cập nhật bảng
                    loadDataToTable();
                } catch (NumberFormatException ex) {
                    // Xảy ra lỗi khi chuyển đổi văn bản thành số
                    JOptionPane.showMessageDialog(this, "Vui lòng nhập số hợp lệ trong các trường số");
                }
            }
        
    }
   
                // TODO add your handling code here:
        }//GEN-LAST:event_jChinhActionPerformed

        private void txtDichvuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDichvuActionPerformed
                // TODO add your handling code here:
        }//GEN-LAST:event_txtDichvuActionPerformed

        private void jThanhtoanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jThanhtoanActionPerformed
               // Hiển thị hộp thoại xác nhận mật khẩu
	           try {
            // Hiển thị hộp thoại xác nhận mật khẩu
            String password = JOptionPane.showInputDialog("Nhập mật khẩu:");

            if (password != null && password.equals("123456")) {
                double dien = 0;
                double nuoc = 0;
                double dichvu = 0;

                // Kiểm tra và chuyển đổi giá trị từ các trường
                String dienText = txtDien.getText();
                if (dienText != null && !dienText.isEmpty()) {
                    double dienKWh = Double.parseDouble(dienText) * 2000; // Convert to VND
                    dien = dienKWh;
                }

                String nuocText = txtNuoc.getText();
                if (nuocText != null && !nuocText.isEmpty()) {
                    double nuocM3 = Double.parseDouble(nuocText) * 14000; // Convert to VND
                    nuoc = nuocM3;
                }

                String dichvuText = txtDichvu.getText();
                if (dichvuText != null && !dichvuText.isEmpty()) {
                    dichvu = Double.parseDouble(dichvuText);
                }

                // Tính tổng tiền
                double tong = dien + nuoc + dichvu;

                
	    }
                if (JOptionPane.showConfirmDialog(this, "Bạn có muốn thanh toán không?", "Xác nhận thanh toán", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            // User clicked "Yes," process the payment
            // Update the database record with id = the relevant record's id
            updateDatabaseRecord(id, 0.0, 0.0, 0.0);

            // Hiển thị thông báo "Đã thanh toán thành công"
            JOptionPane.showMessageDialog(this, "Đã thanh toán thành công");

            // Set the fields to zero
            txtDien.setText("0");
            txtNuoc.setText("0");
            txtDichvu.setText("0");
        } else {
            // User clicked "No," do nothing or provide feedback
            JOptionPane.showMessageDialog(this, "Thanh toán bị hủy.");
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
	

    
        }//GEN-LAST:event_jThanhtoanActionPerformed

        private void txtNuocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNuocActionPerformed
                // TODO add your handling code here:
        }//GEN-LAST:event_txtNuocActionPerformed

        private void txtDienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtDienMouseClicked
                // TODO add your handling code here:
        }//GEN-LAST:event_txtDienMouseClicked

        private void txtDienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDienActionPerformed
                // TODO add your handling code here:
        }//GEN-LAST:event_txtDienActionPerformed

        private void txtChuhoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtChuhoActionPerformed
                // TODO add your handling code here:
        }//GEN-LAST:event_txtChuhoActionPerformed


        // Variables declaration - do not modify//GEN-BEGIN:variables
        private javax.swing.JButton jChinh;
        private javax.swing.JLabel jLabel1;
        private javax.swing.JLabel jLabel2;
        private javax.swing.JLabel jLabel3;
        private javax.swing.JLabel jLabel4;
        private javax.swing.JLabel jLabel5;
        private javax.swing.JLabel jLabel7;
        private javax.swing.JLabel jLabel8;
        private javax.swing.JPanel jPanel1;
        private javax.swing.JPanel jPanel2;
        private javax.swing.JPanel jPanel3;
        private javax.swing.JScrollPane jScrollPane1;
        private javax.swing.JButton jThanhtoan;
        private javax.swing.JTable table1;
        private javax.swing.JTextField txtChuho;
        private javax.swing.JTextField txtDichvu;
        private javax.swing.JTextField txtDien;
        private javax.swing.JTextField txtId;
        private javax.swing.JTextField txtNuoc;
        // End of variables declaration//GEN-END:variables

    
	

private boolean isCorrectPassword(char[] inputPassword) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

	private void insertDataIntoDatabase(String id, String chuho, double dien, double nuoc, double dichvu, double tong) {
    String connectionString = "jdbc:sqlserver://localhost:1433;databaseName=DANGNHAP;user=sa;password=123456;encrypt=true;trustServerCertificate=true";
    String sql = "INSERT INTO HOADON (id, chuho, dien, nuoc, dichvu, tong) VALUES (?, ?, ?, ?, ?, ?)";

    try (Connection connection = DriverManager.getConnection(connectionString);
         PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

        preparedStatement.setString(1, id);
        preparedStatement.setString(2, chuho);
        preparedStatement.setDouble(3, dien);
        preparedStatement.setDouble(4, nuoc);
        preparedStatement.setDouble(5, dichvu);
        preparedStatement.setDouble(6, tong);

        int rowsAffected = preparedStatement.executeUpdate();
        if (rowsAffected > 0) {
            System.out.println("Data inserted successfully.");
        } else {
            System.out.println("Data insert failed.");
        }
    } catch (SQLException ex) {
        ex.printStackTrace();
    }
}

private void updateDatabaseRecord(int id, double dien, double nuoc, double dichvu) {
    String connectionString = "jdbc:sqlserver://localhost:1433;databaseName=DANGNHAP;user=sa;password=123456;encrypt=true;trustServerCertificate=true";
    String sql = "UPDATE HOADON SET dien = ?, nuoc = ?, dichvu = ? WHERE id = ?";

    try (Connection connection = DriverManager.getConnection(connectionString);
         PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
        preparedStatement.setDouble(1, dien);
        preparedStatement.setDouble(2, nuoc);
        preparedStatement.setDouble(3, dichvu);
        preparedStatement.setInt(4, id);

        preparedStatement.executeUpdate();
    } catch (SQLException ex) {
        ex.printStackTrace();
    }
}

	  public void xoa(int id){
        int rows = 0; 
        try{
             Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://localhost:1433;databaseName=DANGNHAP;user=sa;password=123456;encrypt=true;trustServerCertificate=true ";
            Connection con = DriverManager.getConnection(url, "sa", "123456");
            String sql = "Delete from HOADON where id=?";
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setInt(1, id);
            rows = stm.executeUpdate();
            if(rows >= 1){
                System.out.println("Xóa thành công");
                System.out.println(rows);
            }
            else
            {
                System.out.println(rows);
                System.out.println("Thất Bại");
                stm.close(); con.close();
            }
	} catch(Exception ex){
                ex.printStackTrace();
                    System.out.println("cập nhật thát bại");
                    System.out.println(rows);
            
        }
    }

	 
	}
