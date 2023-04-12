/*Saya Riska Nurohmah [2109103] mengerjakan Tugas Praktikum 2 dalam mata kuliah Desain dan Pemrograman Berorientasi Objek 
untuk keberkahanNya maka saya tidak melakukan kecurangan seperti yang telah dispesifikasikan. Aamiin.*/

package component;

import myClass.dbConnection;
import java.awt.GridBagConstraints;
import java.awt.Image;
import java.awt.Insets;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

public final class Item extends javax.swing.JPanel {
   
    private final int id;
    private boolean isDrama = true;
    static dbConnection db = new dbConnection();
    private Main.MainFrame mf;
    private File myImg;
    
    public Item(int id, boolean isDrama, Main.MainFrame mf) {
        initComponents();
        this.id = id;
        this.isDrama = isDrama;
        this.mf = mf;
        if(this.isDrama){
            setDrama();
        }else{
            setScreenwriter();
        }
    }
    

    public void setDrama(){
        label1.setText("Judul");
        label2.setText("Screenwriter");
        label3.setText("Plot Summary");
        label3.setVisible(true);
        
        try{
            String sql = "SELECT *, b.img as bimg FROM tb_drama b JOIN tb_screenwriter a ON b.id_screenwriter = a.id WHERE b.id = '"+this.id+"'";
            ResultSet res = db.Query(sql);
            while(res.next()){
                valueLabel1.setText(res.getString("drama_name"));
                valueLabel2.setText(res.getString("nama"));
                sinopsis.setText(res.getString("plot_summary"));
                sinopsis.setVisible(true);
                BufferedImage fileImg = null;
                this.myImg = new File("src/img/drama/"+res.getString("bimg"));
                fileImg = ImageIO.read(this.myImg);
                Image dimg = fileImg.getScaledInstance(120, 150,Image.SCALE_SMOOTH);
                img.setIcon(new javax.swing.ImageIcon(dimg));
                
            }            
        }catch(SQLException|IOException e){
            System.out.println(e.getMessage());
        }
    }
    
    public void setScreenwriter(){
        label1.setText("Nama");
        label2.setText("Jumlah Drama");
        label3.setVisible(false);
        try{
            String sql = "SELECT * FROM tb_screenwriter WHERE id = '"+this.id+"'";
            ResultSet res = db.Query(sql);
            while(res.next()){
                valueLabel1.setText(res.getString("nama"));
                valueLabel2.setText(res.getString("jumlah_drama"));
                sinopsis.setVisible(false);
                jScrollPane1.setVisible(false);
                BufferedImage fileImg = null;
                this.myImg = new File("src/img/screenwriter/"+res.getString("img"));
                fileImg = ImageIO.read(this.myImg);
                Image dimg = fileImg.getScaledInstance(120, 150,Image.SCALE_SMOOTH);
                img.setIcon(new javax.swing.ImageIcon(dimg));
            }            
        }catch(SQLException|IOException e){
            System.out.println(e.getMessage());
        }
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        img = new javax.swing.JLabel();
        label1 = new javax.swing.JLabel();
        label2 = new javax.swing.JLabel();
        label3 = new javax.swing.JLabel();
        valueLabel1 = new javax.swing.JLabel();
        valueLabel2 = new javax.swing.JLabel();
        btnDelete = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        sinopsis = new javax.swing.JTextArea();

        jTextField1.setText("jTextField1");

        setBackground(new java.awt.Color(255, 255, 255));
        setMaximumSize(new java.awt.Dimension(32767, 150));

        img.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        label1.setText("jLabel1");

        label2.setText("jLabel1");

        label3.setText("jLabel1");

        valueLabel1.setText("jLabel1");

        valueLabel2.setText("jLabel1");

        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnEdit.setText("Update");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        sinopsis.setColumns(20);
        sinopsis.setRows(5);
        jScrollPane1.setViewportView(sinopsis);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(img, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(label3, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnDelete)
                            .addComponent(btnEdit))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(valueLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(label2, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(valueLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 59, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(img, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(valueLabel1)
                            .addComponent(label1))
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(valueLabel2)
                            .addComponent(label2))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(label3)
                                .addGap(18, 18, 18)
                                .addComponent(btnEdit)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnDelete)))))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        if(isDrama){
            FormDrama fb = new FormDrama(this.id, this.mf);
            fb.setVisible(true);
        }else{
            FormScreenWriter fa = new FormScreenWriter(this.id, this.mf);
            fa.setVisible(true);
        }
        
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        int opsi = JOptionPane.showConfirmDialog(null, "Benarkah anda ingin menghapus data ini ?", "Delete Data", JOptionPane.YES_NO_OPTION);
        if (opsi == JOptionPane.YES_OPTION){
            try {
                // TODO add your handling code here:
                String table = this.isDrama ? "tb_drama" : "tb_screenwriter";
                db.stm.execute("DELETE FROM "+table+" WHERE id = '"+id+"'");
                if(myImg != null) myImg.delete();
                this.mf.setItem();
                JOptionPane.showMessageDialog(null, "Data Berhasil Dihapus");
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "ERROR", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnDeleteActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEdit;
    private javax.swing.JLabel img;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel label1;
    private javax.swing.JLabel label2;
    private javax.swing.JLabel label3;
    private javax.swing.JTextArea sinopsis;
    private javax.swing.JLabel valueLabel1;
    private javax.swing.JLabel valueLabel2;
    // End of variables declaration//GEN-END:variables
}