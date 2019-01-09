/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author Fabian
 */
public class ABM extends javax.swing.JFrame {
    
    private DefaultTableModel modelo;
    private int id;

    /**
     * Creates new form ABM
     */
    public ABM() {
        initComponents();
        modelo = new DefaultTableModel();
        setLocationRelativeTo(null);
        btnModificar.setEnabled(false);
        btnEliminar.setEnabled(false);
        cargarTabla();
    }
    
    public void cargarTabla(){
        tabPersona.setModel(modelo);
        modelo.addColumn("Dni");
        modelo.addColumn("Nombre");
        modelo.addColumn("Apellido");
        modelo.addColumn("Estatura");
        modelo.addColumn("Masa");

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        
        String hql = "from Persona";
        Query query = session.createQuery(hql);
        
        List<Persona> personas = query.list();
        for (Persona persona : personas){
            Object[] fila = new Object[5];
            fila[0] = persona.getDni();
            fila[1] = persona.getNombre();
            fila[2] = persona.getApellido();
            fila[3] = persona.getEstatura();
            fila[4] = persona.getMasa();
            modelo.addRow(fila);
        }
        
        transaction.commit();
        session.close();
        sessionFactory.close();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblABM = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        lblApellido = new javax.swing.JLabel();
        lblEstatura = new javax.swing.JLabel();
        lblMasa = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        txtApellido = new javax.swing.JTextField();
        txtEstatura = new javax.swing.JTextField();
        txtMasa = new javax.swing.JTextField();
        btnAgregar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabPersona = new javax.swing.JTable();
        lblDNI = new javax.swing.JLabel();
        txtDNI = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("ABM");
        setResizable(false);

        lblABM.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        lblABM.setText("ABM");

        lblNombre.setText("Nombre");

        lblApellido.setText("Apellido");

        lblEstatura.setText("Estatura");

        lblMasa.setText("Masa");

        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        btnModificar.setText("Modificar");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnLimpiar.setText("Limpiar");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        tabPersona.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tabPersona.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabPersonaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabPersona);

        lblDNI.setText("DNI");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(lblNombre)
                                        .addGap(83, 83, 83))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lblApellido)
                                        .addGap(84, 84, 84)))
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lblEstatura)
                                        .addComponent(lblDNI, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(66, 66, 66)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblMasa)
                                .addGap(6, 6, 6)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtNombre)
                            .addComponent(txtApellido)
                            .addComponent(txtEstatura)
                            .addComponent(txtMasa)
                            .addComponent(txtDNI, javax.swing.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE))
                        .addGap(29, 29, 29))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnAgregar)
                        .addGap(90, 90, 90)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnModificar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnEliminar)
                        .addGap(88, 88, 88)
                        .addComponent(btnLimpiar)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblABM)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 456, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(31, 31, 31))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(lblABM)
                .addGap(1, 1, 1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDNI)
                    .addComponent(txtDNI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblNombre)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblApellido)
                            .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblEstatura)
                            .addComponent(txtEstatura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblMasa)
                            .addComponent(txtMasa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAgregar)
                    .addComponent(btnModificar)
                    .addComponent(btnEliminar)
                    .addComponent(btnLimpiar))
                .addGap(22, 22, 22))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        // TODO add your handling code here:
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        
        String hql = "insert into Persona(dni, nombre, apellido, estatura, masa) values(?, ?, ?, ?, ?)";
        Query query = session.createQuery(hql);
        
        query.setParameter(1, txtDNI.getText());
        query.setParameter(2, txtNombre.getText());
        query.setParameter(3, txtApellido.getText());
        query.setParameter(4, txtEstatura.getText());
        query.setParameter(5, txtMasa.getText());
        
        int result = query.executeUpdate();
        
        transaction.commit();
        session.close();
        sessionFactory.close();
        
        JOptionPane.showMessageDialog(null, "Persona agregada");
        
        Object[] fila = new Object[5];
        fila[0] = txtDNI.getText();
        fila[1] = txtNombre.getText();
        fila[2] = txtApellido.getText();
        fila[3] = txtEstatura.getText();
        fila[4] = txtMasa.getText();
        modelo.addRow(fila);

        vaciarCampos();
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        // TODO add your handling code here:
        int fila = tabPersona.getSelectedRow();
        
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        
        String hql = "update Persona set nombre = ?, apellido = ?, estatura = ?, masa = ? where dni = ?";
        Query query = session.createQuery(hql);
        
        query.setParameter(1, txtNombre.getText());
        query.setParameter(2, txtApellido.getText());
        query.setParameter(3, txtEstatura.getText());
        query.setParameter(4, txtMasa.getText());
        query.setParameter(5, txtDNI.getText());
        
        int result = query.executeUpdate();
        
        transaction.commit();
        session.close();
        sessionFactory.close();
        
        JOptionPane.showMessageDialog(null, "Persona modificada");

        tabPersona.setValueAt(txtNombre.getText(), fila, 1);
        tabPersona.setValueAt(txtApellido.getText(), fila, 2);
        tabPersona.setValueAt(txtEstatura.getText(), fila, 3);
        tabPersona.setValueAt(txtMasa.getText(), fila, 4);

        vaciarCampos();

        btnAgregar.setEnabled(true);
        btnModificar.setEnabled(false);
        btnEliminar.setEnabled(false);
        txtDNI.setEnabled(true);
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        
        String hql = "delete from Persona where dni = ?";
        Query query = session.createQuery(hql);
        query.setParameter(1, txtDNI.getText());
        
        int result = query.executeUpdate();
        
        transaction.commit();
        session.close();
        sessionFactory.close();
        
        int fila = tabPersona.getSelectedRow();
        modelo.removeRow(fila);
        
        JOptionPane.showMessageDialog(null, "Persona eliminada");
        
        vaciarCampos();

        btnAgregar.setEnabled(true);
        btnModificar.setEnabled(false);
        btnEliminar.setEnabled(false);
        txtDNI.setEnabled(true);
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        // TODO add your handling code here:
        vaciarCampos();
        
        btnAgregar.setEnabled(true);
        btnModificar.setEnabled(false);
        btnEliminar.setEnabled(false);
        txtDNI.setEnabled(true);
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void tabPersonaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabPersonaMouseClicked
        // TODO add your handling code here:
        
        int fila = tabPersona.getSelectedRow();
        String dni = tabPersona.getValueAt(fila, 0).toString();

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        
        String hql = "select dni, nombre, apellido, estatura, masa from Persona where dni = ?";
        Query query = session.createQuery(hql);
        
        query.setParameter(1, dni);
        
        List<Persona> personas = query.list();
        for (Persona persona : personas) {
            txtDNI.setText(String.valueOf(persona.getDni()));
            txtNombre.setText(persona.getNombre());
            txtApellido.setText(persona.getApellido());
            txtEstatura.setText(String.valueOf(persona.getEstatura()));
            txtMasa.setText(String.valueOf(persona.getMasa()));
        }

        transaction.commit();
        session.close();
        sessionFactory.close();
        
        btnAgregar.setEnabled(false);
        btnModificar.setEnabled(true);
        btnEliminar.setEnabled(true);
        txtDNI.setEnabled(false);
    }//GEN-LAST:event_tabPersonaMouseClicked

    private void vaciarCampos(){
        txtDNI.setText(null);
        txtNombre.setText(null);
        txtApellido.setText(null);
        txtEstatura.setText(null);
        txtMasa.setText(null);
   }
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
            java.util.logging.Logger.getLogger(ABM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ABM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ABM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ABM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ABM().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblABM;
    private javax.swing.JLabel lblApellido;
    private javax.swing.JLabel lblDNI;
    private javax.swing.JLabel lblEstatura;
    private javax.swing.JLabel lblMasa;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JTable tabPersona;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtDNI;
    private javax.swing.JTextField txtEstatura;
    private javax.swing.JTextField txtMasa;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
