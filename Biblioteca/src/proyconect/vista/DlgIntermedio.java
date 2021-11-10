/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyconect.vista;

import javax.swing.JButton;
import javax.swing.JTextField;

/**
 *
 * @author Luis Miguel
 */
public class DlgIntermedio extends javax.swing.JDialog {

    /**
     * Creates new form DlgIntermedio
     */
    public DlgIntermedio(java.awt.Frame parent) {
        super(parent, true);
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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        campoCodigo = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        campoTitulo = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        campoAutor = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        campoAsignatura = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        campoEstado = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        campoEditorial = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        campoPrestado = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        campoDevuelto = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        campoEstado2 = new javax.swing.JTextField();
        btnCancelar = new javax.swing.JButton();
        btnAceptar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Prestamos");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Libro"));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("Código");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 20, 61, -1));

        campoCodigo.setEditable(false);
        jPanel1.add(campoCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(87, 17, 333, -1));

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Título");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 53, 61, -1));
        jPanel1.add(campoTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(87, 50, 333, -1));

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Autor");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 84, 61, -1));
        jPanel1.add(campoAutor, new org.netbeans.lib.awtextra.AbsoluteConstraints(87, 81, 333, -1));

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Asignatura");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 148, 61, -1));
        jPanel1.add(campoAsignatura, new org.netbeans.lib.awtextra.AbsoluteConstraints(87, 142, 333, -1));

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Estado");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 176, 61, -1));
        jPanel1.add(campoEstado, new org.netbeans.lib.awtextra.AbsoluteConstraints(87, 173, 333, -1));

        btnBuscar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnBuscar.setText("Buscar");
        jPanel1.add(btnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(438, 16, -1, -1));

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel9.setText("Editorial");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 115, 61, -1));
        jPanel1.add(campoEditorial, new org.netbeans.lib.awtextra.AbsoluteConstraints(87, 112, 333, -1));

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Prestado");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 15, -1, -1));
        jPanel2.add(campoPrestado, new org.netbeans.lib.awtextra.AbsoluteConstraints(72, 12, 129, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setText("Devuelto");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 15, -1, -1));
        jPanel2.add(campoDevuelto, new org.netbeans.lib.awtextra.AbsoluteConstraints(311, 12, 152, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("Estado");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 61, 51, -1));
        jPanel2.add(campoEstado2, new org.netbeans.lib.awtextra.AbsoluteConstraints(72, 58, 391, -1));

        btnCancelar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnCancelar.setText("Cancelar");

        btnAceptar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnAceptar.setText("Aceptar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnCancelar)
                        .addGap(18, 18, 18)
                        .addComponent(btnAceptar)
                        .addGap(36, 36, 36))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 529, Short.MAX_VALUE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 19, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar)
                    .addComponent(btnAceptar))
                .addGap(20, 20, 20))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents



    public JButton getBtnAceptar() {
        return btnAceptar;
    }

    public void setBtnAceptar(JButton btnAceptar) {
        this.btnAceptar = btnAceptar;
    }

    public JButton getBtnBuscar() {
        return btnBuscar;
    }

    public void setBtnBuscar(JButton btnBuscar) {
        this.btnBuscar = btnBuscar;
    }

    public JButton getBtnCancelar() {
        return btnCancelar;
    }

    public void setBtnCancelar(JButton btnCancelar) {
        this.btnCancelar = btnCancelar;
    }

    public JTextField getCampoAsignatura() {
        return campoAsignatura;
    }

    public void setCampoAsignatura(JTextField campoAsignatura) {
        this.campoAsignatura = campoAsignatura;
    }

    public JTextField getCampoAutor() {
        return campoAutor;
    }

    public void setCampoAutor(JTextField campoAutor) {
        this.campoAutor = campoAutor;
    }

    public JTextField getCampoEditorial() {
        return campoEditorial;
    }

    public void setCampoEditorial(JTextField campoEditorial) {
        this.campoEditorial = campoEditorial;
    }
    
    

    public JTextField getCampoCodigo() {
        return campoCodigo;
    }

    public void setCampoCodigo(JTextField campoCodigo) {
        this.campoCodigo = campoCodigo;
    }

    public JTextField getCampoDevuelto() {
        return campoDevuelto;
    }

    public void setCampoDevuelto(JTextField campoDevuelto) {
        this.campoDevuelto = campoDevuelto;
    }

    public JTextField getCampoEstado() {
        return campoEstado;
    }

    public void setCampoEstado(JTextField campoEstado) {
        this.campoEstado = campoEstado;
    }

    public JTextField getCampoEstado2() {
        return campoEstado2;
    }

    public void setCampoEstado2(JTextField campoEstado2) {
        this.campoEstado2 = campoEstado2;
    }

    public JTextField getCampoPrestado() {
        return campoPrestado;
    }

    public void setCampoPrestado(JTextField campoPrestado) {
        this.campoPrestado = campoPrestado;
    }

    public JTextField getCampoTitulo() {
        return campoTitulo;
    }

    public void setCampoTitulo(JTextField campoTitulo) {
        this.campoTitulo = campoTitulo;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JTextField campoAsignatura;
    private javax.swing.JTextField campoAutor;
    private javax.swing.JTextField campoCodigo;
    private javax.swing.JTextField campoDevuelto;
    private javax.swing.JTextField campoEditorial;
    private javax.swing.JTextField campoEstado;
    private javax.swing.JTextField campoEstado2;
    private javax.swing.JTextField campoPrestado;
    private javax.swing.JTextField campoTitulo;
    private javax.swing.JLabel jLabel1;
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
    // End of variables declaration//GEN-END:variables
}
