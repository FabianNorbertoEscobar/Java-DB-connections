/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import com.mysql.jdbc.Connection;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import modelo.SQLConnection;

/**
 *
 * @author Fabian
 */
public class App1 extends javax.swing.JFrame {

    /**
     * Creates new form App
     */
    public App1() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpnImagen = new javax.swing.JPanel();
        btnCargar = new javax.swing.JButton();
        btnMostrar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        javax.swing.GroupLayout jpnImagenLayout = new javax.swing.GroupLayout(jpnImagen);
        jpnImagen.setLayout(jpnImagenLayout);
        jpnImagenLayout.setHorizontalGroup(
            jpnImagenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jpnImagenLayout.setVerticalGroup(
            jpnImagenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 253, Short.MAX_VALUE)
        );

        btnCargar.setText("Cargar");
        btnCargar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCargarActionPerformed(evt);
            }
        });

        btnMostrar.setText("Mostrar");
        btnMostrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMostrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jpnImagen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addComponent(btnCargar)
                .addGap(45, 45, 45)
                .addComponent(btnMostrar)
                .addContainerGap(54, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jpnImagen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCargar)
                    .addComponent(btnMostrar))
                .addGap(21, 21, 21))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCargarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCargarActionPerformed
        // TODO add your handling code here:
        
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("*.JPEG" , "jpeg");
        fileChooser.setFileFilter(filtro);
        
        int seleccion = fileChooser.showOpenDialog(this);
        
        PreparedStatement ps;
        ResultSet rs;
        
        if(seleccion == JFileChooser.APPROVE_OPTION){
            File fichero = fileChooser.getSelectedFile();
            String ruta = fichero.getAbsolutePath();
            
            try{
                FileInputStream fis = new FileInputStream(fichero);
                
                Connection connection = new SQLConnection().getConnection();
                ps = connection.prepareStatement("INSERT INTO datos(imagen) VALUES (?)");
                ps.setBinaryStream(1, fis, (int)fichero.length());
                ps.execute();
                JOptionPane.showMessageDialog(null, "Imagen guardada");
            }catch(SQLException e){
                Logger.getLogger(App1.class.getName()).log(Level.SEVERE, null, e);
                JOptionPane.showMessageDialog(null, "Error");
            } catch (FileNotFoundException ex) {
                Logger.getLogger(App1.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        /*
        int x = jpnImagen.getWidth();
        int y = jpnImagen.getHeight();

        Imagen img = new Imagen(x, y, ruta);
        jpnImagen.add(img);
        jpnImagen.repaint();
        */
    }//GEN-LAST:event_btnCargarActionPerformed

    private void btnMostrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMostrarActionPerformed
        // TODO add your handling code here:
        PreparedStatement ps;
        ResultSet rs;
        
        try{
            Connection connection = new SQLConnection().getConnection();
            ps = connection.prepareStatement("SELECT imagen FROM datos WHERE id = ?");
            ps.setInt(1, 1);
            rs = ps.executeQuery();
            
            BufferedImage buffimg;
            byte[] image;
            while(rs.next()){
                image = rs.getBytes("imagen");
                InputStream img = rs.getBinaryStream(1);
                
                try{
                    buffimg = ImageIO.read(img);
                    ImagenMySQL imagen = new ImagenMySQL(jpnImagen.getHeight(), jpnImagen.getWidth(), buffimg);
                    jpnImagen.add(imagen);
                    jpnImagen.repaint();
                }catch(IOException ex){
                    Logger.getLogger(App1.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(App1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnMostrarActionPerformed

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
            java.util.logging.Logger.getLogger(App1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(App1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(App1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(App1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new App1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCargar;
    private javax.swing.JButton btnMostrar;
    private javax.swing.JPanel jpnImagen;
    // End of variables declaration//GEN-END:variables
}
