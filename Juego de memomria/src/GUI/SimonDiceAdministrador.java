package GUI;

import java.util.HashMap;
import javax.swing.ButtonGroup;
import juego.de.memomria.MapaSimonDice;

public class SimonDiceAdministrador extends javax.swing.JFrame {

    int mapa;
    int dificultad;
    private static MapaSimonDice mapas;

    public SimonDiceAdministrador() {
        initComponents();
        agrupar();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        SimonDice5ColoresLabel = new javax.swing.JLabel();
        SimonDice4ColoresLabel = new javax.swing.JLabel();
        SimonDice6ColoresLabel = new javax.swing.JLabel();
        SimonDice7ColoresLabel = new javax.swing.JLabel();
        SimonDice7ColoresLabel1 = new javax.swing.JLabel();
        Cuatroboton = new javax.swing.JRadioButton();
        Fiveboton = new javax.swing.JRadioButton();
        Sixboton = new javax.swing.JRadioButton();
        SevenBoton = new javax.swing.JRadioButton();
        Eightnboton = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        ControlNivel = new javax.swing.JSlider();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        GuardarSimonDice = new javax.swing.JButton();
        SalirSimonAdministrador = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 204, 255));

        SimonDice5ColoresLabel.setIcon(new javax.swing.ImageIcon("C:\\Users\\User\\Desktop\\Estructura de datos\\Circulo 5 Colores.png")); // NOI18N

        SimonDice4ColoresLabel.setIcon(new javax.swing.ImageIcon("C:\\Users\\User\\Desktop\\Estructura de datos\\Circulo de 4 colores.png")); // NOI18N

        SimonDice6ColoresLabel.setIcon(new javax.swing.ImageIcon("C:\\Users\\User\\Desktop\\Estructura de datos\\Circulo 6 Colores.png")); // NOI18N

        SimonDice7ColoresLabel.setIcon(new javax.swing.ImageIcon("C:\\Users\\User\\Desktop\\Estructura de datos\\Circulo 7 Colores.png")); // NOI18N

        SimonDice7ColoresLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\User\\Desktop\\Estructura de datos\\Circulo 8 Colores.png")); // NOI18N

        Cuatroboton.setContentAreaFilled(false);

        Fiveboton.setContentAreaFilled(false);

        Sixboton.setContentAreaFilled(false);

        SevenBoton.setContentAreaFilled(false);

        Eightnboton.setContentAreaFilled(false);

        jLabel1.setFont(new java.awt.Font("Gramatika-BlackItalic", 1, 60)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Simon Dice");

        ControlNivel.setBackground(new java.awt.Color(51, 204, 255));
        ControlNivel.setFont(new java.awt.Font("Gramatika-BlackItalic", 0, 48)); // NOI18N
        ControlNivel.setForeground(new java.awt.Color(0, 0, 0));
        ControlNivel.setMajorTickSpacing(1);
        ControlNivel.setMaximum(10);
        ControlNivel.setMinimum(1);
        ControlNivel.setPaintLabels(true);
        ControlNivel.setPaintTicks(true);
        ControlNivel.setValue(1);

        jLabel2.setFont(new java.awt.Font("Gramatika-BlackItalic", 0, 36)); // NOI18N
        jLabel2.setText("Dificultad");

        jLabel3.setFont(new java.awt.Font("Gramatika-BlackItalic", 0, 36)); // NOI18N
        jLabel3.setText("Velocidad");

        GuardarSimonDice.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/GuardarIcono.png"))); // NOI18N
        GuardarSimonDice.setBorderPainted(false);
        GuardarSimonDice.setContentAreaFilled(false);
        GuardarSimonDice.setDefaultCapable(false);
        GuardarSimonDice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GuardarSimonDiceActionPerformed(evt);
            }
        });

        SalirSimonAdministrador.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Salida pequemio.png"))); // NOI18N
        SalirSimonAdministrador.setBorderPainted(false);
        SalirSimonAdministrador.setContentAreaFilled(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(139, 139, 139))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(66, 66, 66)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(62, 62, 62)
                                .addComponent(Cuatroboton))
                            .addComponent(SimonDice4ColoresLabel))
                        .addGap(35, 35, 35)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(65, 65, 65)
                                .addComponent(Fiveboton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(SimonDice5ColoresLabel, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(292, 292, 292)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(SimonDice6ColoresLabel)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(59, 59, 59)
                                        .addComponent(Sixboton)))
                                .addGap(25, 25, 25)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(60, 60, 60)
                                        .addComponent(SevenBoton))
                                    .addComponent(SimonDice7ColoresLabel))
                                .addGap(18, 18, 18))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(ControlNivel, javax.swing.GroupLayout.PREFERRED_SIZE, 439, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(31, 31, 31)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(SimonDice7ColoresLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGap(65, 65, 65)
                                    .addComponent(Eightnboton)
                                    .addGap(57, 57, 57)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(32, 32, 32)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(SalirSimonAdministrador)
                                    .addComponent(GuardarSimonDice))))))
                .addContainerGap(34, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(SimonDice4ColoresLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Cuatroboton))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(SimonDice7ColoresLabel1)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(SimonDice7ColoresLabel)
                                .addGap(18, 18, 18)
                                .addComponent(SevenBoton))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(SimonDice5ColoresLabel)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(Fiveboton))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(SimonDice6ColoresLabel)
                                        .addGap(12, 12, 12)
                                        .addComponent(Sixboton)
                                        .addGap(58, 58, 58)))
                                .addGap(7, 7, 7)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Eightnboton)))
                .addGap(20, 20, 20)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(ControlNivel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(82, 82, 82))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(GuardarSimonDice)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(SalirSimonAdministrador))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void GuardarSimonDiceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GuardarSimonDiceActionPerformed
javax.swing.ButtonModel modeloSeleccionado = grupoSimonDice.getSelection();
    
    if (modeloSeleccionado != null) {
        // Obtener el ActionCommand del botón seleccionado
        String numeroSeleccionado = modeloSeleccionado.getActionCommand();
        
        // Mostrar el número que se ha seleccionado
        System.out.println("Número seleccionado: " + numeroSeleccionado);
        
        // Puedes convertir el número a un tipo int si es necesario
         mapa = Integer.parseInt(numeroSeleccionado);

    } else {
        mapa = 4;
        
    }

    dificultad = ControlNivel.getValue()*2;

    mapas = new MapaSimonDice(mapa, dificultad);

            System.out.println(mapas.toString());

    }//GEN-LAST:event_GuardarSimonDiceActionPerformed

    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(SimonDiceAdministrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SimonDiceAdministrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SimonDiceAdministrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SimonDiceAdministrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SimonDiceAdministrador().setVisible(true);
            }
        });
                
    }

    ButtonGroup grupoSimonDice = new ButtonGroup();

    private void agrupar() {

        Cuatroboton.setActionCommand("4");  
        Fiveboton.setActionCommand("5");    
        Sixboton.setActionCommand("6");     
        SevenBoton.setActionCommand("7");   
        Eightnboton.setActionCommand("8");  
        grupoSimonDice.add(Cuatroboton);
        grupoSimonDice.add(Fiveboton);
        grupoSimonDice.add(Sixboton);
        grupoSimonDice.add(SevenBoton);
        grupoSimonDice.add(Eightnboton);

        grupoSimonDice.clearSelection();
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JSlider ControlNivel;
    private javax.swing.JRadioButton Cuatroboton;
    private javax.swing.JRadioButton Eightnboton;
    private javax.swing.JRadioButton Fiveboton;
    private javax.swing.JButton GuardarSimonDice;
    private javax.swing.JButton SalirSimonAdministrador;
    private javax.swing.JRadioButton SevenBoton;
    private javax.swing.JLabel SimonDice4ColoresLabel;
    private javax.swing.JLabel SimonDice5ColoresLabel;
    private javax.swing.JLabel SimonDice6ColoresLabel;
    private javax.swing.JLabel SimonDice7ColoresLabel;
    private javax.swing.JLabel SimonDice7ColoresLabel1;
    private javax.swing.JRadioButton Sixboton;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
