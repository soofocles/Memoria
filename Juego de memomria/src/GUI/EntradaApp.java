package GUI;

public class EntradaApp extends javax.swing.JFrame {

    public EntradaApp() {
        initComponents();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        TituloJuego = new javax.swing.JLabel();
        administradorBoton = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(51, 204, 255));
        jPanel1.setMaximumSize(new java.awt.Dimension(1000, 1000));
        jPanel1.setPreferredSize(new java.awt.Dimension(1000, 1000));

        TituloJuego.setBackground(new java.awt.Color(0, 0, 0));
        TituloJuego.setFont(new java.awt.Font("Gramatika-BlackItalic", 1, 60)); // NOI18N
        TituloJuego.setForeground(new java.awt.Color(0, 0, 0));
        TituloJuego.setText("Juego de memoria");

        administradorBoton.setIcon(new javax.swing.ImageIcon("C:\\Users\\User\\Desktop\\Estructura de datos\\Engranaje sin fondo.png")); // NOI18N
        administradorBoton.setBorderPainted(false);
        administradorBoton.setContentAreaFilled(false);
        administradorBoton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                administradorBotonActionPerformed(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon("C:\\Users\\User\\Desktop\\Estructura de datos\\Usuario sin fondo.png")); // NOI18N
        jButton1.setBorderPainted(false);
        jButton1.setContentAreaFilled(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(127, 127, 127)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(TituloJuego)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(234, 234, 234)
                        .addComponent(administradorBoton)))
                .addContainerGap(132, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(85, 85, 85)
                .addComponent(TituloJuego)
                .addGap(106, 106, 106)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(administradorBoton)
                    .addComponent(jButton1))
                .addContainerGap(117, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 800, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 549, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void administradorBotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_administradorBotonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_administradorBotonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel TituloJuego;
    private javax.swing.JButton administradorBoton;
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
