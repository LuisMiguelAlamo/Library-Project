/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyconect.vista;

import javax.swing.JButton;
import java.awt.Image;
import java.awt.Toolkit;
/**
 *
 * @author Luis Miguel
 */
public class FrmPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form MenuPrincipal
     */
    public FrmPrincipal() {
        initComponents();
    }

    @Override
    public Image getIconImage(){
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("imagenes/books_library_1767.png"));
        return retValue;
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButtonAlumno = new javax.swing.JButton();
        jButtonLibros = new javax.swing.JButton();
        jButtonSalir = new javax.swing.JButton();
        jButtonMovimiento = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Aplicación Biblioteca - @Luis Miguel Alamo Hernández");
        setIconImage(getIconImage());
        setUndecorated(true);

        jButtonAlumno.setBackground(new java.awt.Color(51, 153, 255));
        jButtonAlumno.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButtonAlumno.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/usuarios.icon.png"))); // NOI18N
        jButtonAlumno.setText("Alumnos");

        jButtonLibros.setBackground(new java.awt.Color(51, 153, 255));
        jButtonLibros.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButtonLibros.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/libros.icon.png"))); // NOI18N
        jButtonLibros.setText("Libros");

        jButtonSalir.setBackground(new java.awt.Color(255, 0, 51));
        jButtonSalir.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButtonSalir.setText("Salir");

        jButtonMovimiento.setBackground(new java.awt.Color(51, 153, 255));
        jButtonMovimiento.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButtonMovimiento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/prestamos.icon.png"))); // NOI18N
        jButtonMovimiento.setText("Movimientos");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonMovimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(83, 83, 83)
                        .addComponent(jButtonSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41)
                        .addComponent(jButtonLibros, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonAlumno)
                    .addComponent(jButtonLibros))
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonMovimiento)
                    .addComponent(jButtonSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(39, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public JButton getjButtonLibros() {
        return jButtonLibros;
    }

    public void setjButtonLibros(JButton jButton2) {
        this.jButtonLibros = jButton2;
    }


    public JButton getjButtonMovimiento() {
        return jButtonMovimiento;
    }

    public void setjButtonMovimiento(JButton jButton4) {
        this.jButtonMovimiento = jButton4;
    }

    public JButton getjButtonAlumno() {
        return jButtonAlumno;
    }

    public void setjButtonAlumno(JButton jButtonAlumno) {
        this.jButtonAlumno = jButtonAlumno;
    }


    public JButton getjButtonSalir() {
        return jButtonSalir;
    }

    public void setjButtonSalir(JButton jButtonSalir) {
        this.jButtonSalir = jButtonSalir;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAlumno;
    private javax.swing.JButton jButtonLibros;
    private javax.swing.JButton jButtonMovimiento;
    private javax.swing.JButton jButtonSalir;
    // End of variables declaration//GEN-END:variables


}
