/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

/**
 *
 * @author User
 */
public class JuegosAdministrador extends javax.swing.JFrame {

    /**
     * Creates new form JuegosAdministrador
     */
    public JuegosAdministrador() {
        initComponents();
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
        PanelJuegosAdministrador = new javax.swing.JPanel();
        TituloJuegosAdministrador = new javax.swing.JLabel();
        JUegoSimonDiceAdministrador = new javax.swing.JButton();
        Operaciones = new javax.swing.JButton();
        Palabras = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        PanelJuegosAdministrador.setBackground(new java.awt.Color(0, 204, 255));

        TituloJuegosAdministrador.setFont(new java.awt.Font("Gramatika-BlackItalic", 1, 60)); // NOI18N
        TituloJuegosAdministrador.setForeground(new java.awt.Color(0, 0, 0));
        TituloJuegosAdministrador.setText("Juegos");

        JUegoSimonDiceAdministrador.setIcon(new javax.swing.ImageIcon("C:\\Users\\User\\Desktop\\Estructura de datos\\Circulo de 4 colores.png")); // NOI18N
        JUegoSimonDiceAdministrador.setBorderPainted(false);
        JUegoSimonDiceAdministrador.setContentAreaFilled(false);
        JUegoSimonDiceAdministrador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JUegoSimonDiceAdministradorActionPerformed(evt);
            }
        });

        Operaciones.setIcon(new javax.swing.ImageIcon("C:\\Users\\User\\Desktop\\Estructura de datos\\Operaciones.png")); // NOI18N
        Operaciones.setBorderPainted(false);
        Operaciones.setContentAreaFilled(false);

        Palabras.setIcon(new javax.swing.ImageIcon("C:\\Users\\User\\Desktop\\Estructura de datos\\ABC.png")); // NOI18N
        Palabras.setBorderPainted(false);
        Palabras.setContentAreaFilled(false);
        Palabras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PalabrasActionPerformed(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon("C:\\Users\\User\\Desktop\\Estructura de datos\\Salida mas pequeÃ±o.png")); // NOI18N
        jButton1.setBorderPainted(false);
        jButton1.setContentAreaFilled(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelJuegosAdministradorLayout = new javax.swing.GroupLayout(PanelJuegosAdministrador);
        PanelJuegosAdministrador.setLayout(PanelJuegosAdministradorLayout);
        PanelJuegosAdministradorLayout.setHorizontalGroup(
            PanelJuegosAdministradorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelJuegosAdministradorLayout.createSequentialGroup()
                .addGroup(PanelJuegosAdministradorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelJuegosAdministradorLayout.createSequentialGroup()
                        .addGroup(PanelJuegosAdministradorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PanelJuegosAdministradorLayout.createSequentialGroup()
                                .addGap(295, 295, 295)
                                .addComponent(TituloJuegosAdministrador))
                            .addGroup(PanelJuegosAdministradorLayout.createSequentialGroup()
                                .addGap(86, 86, 86)
                                .addComponent(JUegoSimonDiceAdministrador)
                                .addGap(90, 90, 90)
                                .addComponent(Operaciones)
                                .addGap(98, 98, 98)
                                .addComponent(Palabras)))
                        .addGap(0, 44, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelJuegosAdministradorLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton1)))
                .addContainerGap())
        );
        PanelJuegosAdministradorLayout.setVerticalGroup(
            PanelJuegosAdministradorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelJuegosAdministradorLayout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(TituloJuegosAdministrador)
                .addGap(78, 78, 78)
                .addGroup(PanelJuegosAdministradorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JUegoSimonDiceAdministrador)
                    .addComponent(Operaciones)
                    .addGroup(PanelJuegosAdministradorLayout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(Palabras)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 63, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelJuegosAdministrador, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelJuegosAdministrador, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JUegoSimonDiceAdministradorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JUegoSimonDiceAdministradorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JUegoSimonDiceAdministradorActionPerformed

    private void PalabrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PalabrasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PalabrasActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(JuegosAdministrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JuegosAdministrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JuegosAdministrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JuegosAdministrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JuegosAdministrador().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JUegoSimonDiceAdministrador;
    private javax.swing.JButton Operaciones;
    private javax.swing.JButton Palabras;
    private javax.swing.JPanel PanelJuegosAdministrador;
    private javax.swing.JLabel TituloJuegosAdministrador;
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
