/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/*Saya Riska Nurohmah [2109103] mengerjakan Tugas Praktikum 2 dalam mata kuliah Desain dan Pemrograman Berorientasi Objek 
untuk keberkahanNya maka saya tidak melakukan kecurangan seperti yang telah dispesifikasikan. Aamiin.*/
package component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import myClass.ScreenWriter;
import myClass.dbConnection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import myClass.MyImageHandler;
/**
 *
 * @author riska
 */
public class FormDrama extends javax.swing.JFrame {

    /**
     * Creates new form FormDrama
     */
    private int id;
    private int id_screenwriter;
    private String drama_name;
    private String plot_summary;
    private String img;
    private Main.MainFrame mf;
    myClass.MyImageHandler imgHandler = new MyImageHandler();
    static dbConnection db = new dbConnection();
    
//    public FormDrama() {
//        initComponents();
//        this.mf = mf;
//        setAddForm();
//    }
    
    public FormDrama(Main.MainFrame mf) {
        initComponents();
        this.mf = mf;
        setAddForm();
    }
    
    public FormDrama(int id, Main.MainFrame mf) {
        initComponents();
        this.id = id;
        this.mf = mf;
        setEditForm();
    }
    
    public void setDrama(){
        try{
            String sql = "SELECT * FROM tb_drama WHERE id = '"+this.id+"'";
            ResultSet res = db.Query(sql);
            while(res.next()){
                this.id_screenwriter = res.getInt("id_screenwriter");
                this.drama_name = res.getString("drama_name");
                this.plot_summary = res.getString("plot_summary");
                this.img = res.getString("img");
            }            
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }
    
     public void setAddForm(){
        listWriter.removeAllItems();
        try{
            String sql = "SELECT id, nama FROM tb_screenwriter";
            ResultSet res = db.Query(sql);
            while(res.next()){
                ScreenWriter author = new ScreenWriter();
                author.setId(res.getInt("id"));
                author.setPosition(res.getString("nama"));
                listWriter.addItem(author);
            }            
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        
        judul.setText("ADD DRAMA");
        addBtn.setVisible(true);
        btnUpdate.setVisible(false);
        labelid.setVisible(false);
    }
     
    public void setEditForm(){
        setDrama();
        addBtn.setVisible(false);
        btnClear.setVisible(false);
        judul.setText("EDIT DRAMA");
        isiJudul.setText(this.drama_name);
        isiPlot.setText(this.plot_summary);
        labelid.setText("ID : "+this.id);
        namaimage.setText(this.img);
        listWriter.removeAllItems();
        setDrama();
        try{
            String sql = "SELECT id, nama FROM tb_screenwriter";
            ResultSet res = db.Query(sql);
            while(res.next()){
                ScreenWriter author = new ScreenWriter();
                author.setId(res.getInt("id"));
                author.setPosition(res.getString("nama"));
                listWriter.addItem(author);
                if(res.getInt("id") == this.id_screenwriter)
                    listWriter.setSelectedItem(author);
            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }
    
     public void uploadImg(String img){
         try {
            Path copied = Paths.get("src/img/drama/"+img);
            Path originalPath = Paths.get(imgHandler.getFile().getAbsolutePath());
            Files.copy(originalPath, copied, StandardCopyOption.REPLACE_EXISTING);
          } catch (IOException e) {
              JOptionPane.showMessageDialog(null, e.getMessage());
              e.printStackTrace();
          }
    }
     
    public void clearForm(){
        isiJudul.setText("");
        isiPlot.setText("");
        listWriter.setSelectedIndex(0);
        namaimage.setText("");
        imgHandler = new MyImageHandler();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        judul = new javax.swing.JLabel();
        judulDrama = new javax.swing.JLabel();
        plot = new javax.swing.JLabel();
        labelimg = new javax.swing.JLabel();
        writer = new javax.swing.JLabel();
        isiJudul = new javax.swing.JTextField();
        listWriter = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        isiPlot = new javax.swing.JTextArea();
        labelid = new javax.swing.JLabel();
        namaimage = new javax.swing.JLabel();
        browse = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        addBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(102, 102, 102));

        judul.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        judul.setText("ADD DRAMA");

        judulDrama.setText("JUDUL");

        plot.setText("PLOT SUMMARY");

        labelimg.setText("IMAGE");

        writer.setText("SCREENWRITER");

        listWriter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listWriterActionPerformed(evt);
            }
        });

        isiPlot.setColumns(20);
        isiPlot.setRows(5);
        jScrollPane2.setViewportView(isiPlot);

        labelid.setText("id");

        browse.setText("BROWSE");
        browse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                browseActionPerformed(evt);
            }
        });

        btnClear.setText("Clear");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });

        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        addBtn.setText("Add");
        addBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(plot)
                            .addComponent(writer)
                            .addComponent(judulDrama)
                            .addComponent(labelimg))
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnClear)
                                .addGap(27, 27, 27)
                                .addComponent(addBtn)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnUpdate))
                            .addComponent(listWriter, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(isiJudul)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(browse)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(namaimage, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 20, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(labelid)
                        .addGap(129, 129, 129)
                        .addComponent(judul)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(judul)
                    .addComponent(labelid))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(judulDrama)
                    .addComponent(isiJudul, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(writer)
                    .addComponent(listWriter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(plot)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(namaimage, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(browse)
                        .addComponent(labelimg)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnClear)
                    .addComponent(addBtn)
                    .addComponent(btnUpdate))
                .addGap(49, 49, 49))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
  
    private void browseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_browseActionPerformed
        // TODO add your handling code here:
        imgHandler.Browse();
        namaimage.setText(imgHandler.getPath());
    }//GEN-LAST:event_browseActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        // TODO add your handling code here:
        clearForm();
    }//GEN-LAST:event_btnClearActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // TODO add your handling code here:
        drama_name = isiJudul.getText();
        id_screenwriter = ((ScreenWriter)listWriter.getSelectedItem()).getId();
        plot_summary = isiPlot.getText();
        if((drama_name != null) && (id_screenwriter != 0) && (plot_summary != null)){
            if(imgHandler.getFile()!=null){
                uploadImg(this.img);
            }
            int opsi = JOptionPane.showConfirmDialog(null, "Benarkah anda ingin mengubah data ini ?", "Edit Data", JOptionPane.YES_NO_OPTION);
            if (opsi == JOptionPane.YES_OPTION){
                try{
                    String sql = "UPDATE `tb_drama` SET drama_name = '"+drama_name+"', id_screenwriter= '"+id_screenwriter+"', plot_summary = '"+plot_summary+"' WHERE id = '"+id+"'";
                    db.stm.execute(sql);
                    JOptionPane.showMessageDialog(null, "Data Berhasil Diubah", "SUCCESS", JOptionPane.INFORMATION_MESSAGE);
                    clearForm();
                    this.mf.setItem();
                    this.dispose();
                }catch(SQLException e){
                    JOptionPane.showMessageDialog(null, e.getMessage(), "ERROR", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        }else{
            JOptionPane.showMessageDialog(null, "Lengkapi Form", "Warning", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void addBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBtnActionPerformed
        // TODO add your handling code here:
         drama_name = isiJudul.getText();
        id_screenwriter = ((ScreenWriter)listWriter.getSelectedItem()).getId();
        plot_summary = isiPlot.getText();
        if((drama_name != null) && (id_screenwriter != 0) && (plot_summary != null) && (imgHandler.getFile() != null)){
            Date dNow = new Date();
            SimpleDateFormat ft = new SimpleDateFormat("yyMMddhhmmssMs");
            this.img = ft.format(dNow)+"_"+imgHandler.getFile().getName();
            try{
                uploadImg(this.img);
                String sql = "INSERT INTO `tb_drama` (`id`, `id_screenwriter`, `drama_name`, `plot_summary`, `img`) VALUES (null, '"+id_screenwriter+"','"+drama_name+"','"+plot_summary+"','"+img+"')";
                db.stm.execute(sql);
                JOptionPane.showMessageDialog(null, "Data Berhasil Ditambah", "SUCCESS", JOptionPane.INFORMATION_MESSAGE);
                clearForm();
                this.mf.setItem();
                this.dispose();
            }catch(SQLException e){
                JOptionPane.showMessageDialog(null, e.getMessage(), "ERROR", JOptionPane.INFORMATION_MESSAGE);
            }
        }else{
            JOptionPane.showMessageDialog(null, "Lengkapi Form", "Warning", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_addBtnActionPerformed

    private void listWriterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listWriterActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_listWriterActionPerformed

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(FormDrama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(FormDrama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(FormDrama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(FormDrama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new FormDrama().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addBtn;
    private javax.swing.JButton browse;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JTextField isiJudul;
    private javax.swing.JTextArea isiPlot;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel judul;
    private javax.swing.JLabel judulDrama;
    private javax.swing.JLabel labelid;
    private javax.swing.JLabel labelimg;
    private javax.swing.JComboBox<myClass.ScreenWriter> listWriter;
    private javax.swing.JLabel namaimage;
    private javax.swing.JLabel plot;
    private javax.swing.JLabel writer;
    // End of variables declaration//GEN-END:variables
}
