/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package juego.de.memomria;
import javax.swing.*;
import javax.swing.Timer;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Operaciones extends JFrame {
    private static final long serialVersionUID = 1L;

    private JLabel cuadroDeTexto, cuadroDeResultado;
    private JButton btnIniciar, btnVerificar;
    private JTextField campoRespuesta;
    private ArrayList<String> listaNumYOpera; // Lista para almacenar números y operadores
    private int resultadoActu; // Resultado actual
    private int numElementos = 3; // Configurable: cantidad de números que aparecen
    private Timer timer; // Temporizador para mostrar elementos secuenciales
    private int i; // Índice para recorrer la secuencia

    public Operaciones() {
        setTitle("Test de memoria");
        setSize(500, 400); // Tamaño de la ventana
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null); // Usamos diseño absoluto
        setLocationRelativeTo(null);
        
        JMenuBar menuBar = new JMenuBar();
        JMenu menuDificultad = new JMenu("Dificultad");
        JMenuItem facil = new JMenuItem("Fácil");
        JMenuItem normal = new JMenuItem("Normal");
        JMenuItem dificil = new JMenuItem("Difícil");
        
        facil.addActionListener(e -> cambiarDificultad(3));  // 3 elementos
        normal.addActionListener(e -> cambiarDificultad(5));  // 5 elementos
        dificil.addActionListener(e -> cambiarDificultad(7));  // 7 elementos
        
        menuDificultad.add(facil);
        menuDificultad.add(normal);
        menuDificultad.add(dificil);
        menuBar.add(menuDificultad);
        setJMenuBar(menuBar);
        
        // Inicializar componentes
        cuadroDeTexto = new JLabel("Haz clic en 'Iniciar' para comenzar.");
        cuadroDeTexto.setBounds(50, 40, 400, 150); // Posición y tamaño del label
        cuadroDeTexto.setHorizontalAlignment(SwingConstants.CENTER);
        cuadroDeTexto.setFont(new Font("Arial", Font.BOLD, 20));
        add(cuadroDeTexto);

        btnIniciar = new JButton("Iniciar");
        btnIniciar.setBounds(50, 325, 150, 30); // Posición y tamaño del botón
        add(btnIniciar);

        cuadroDeResultado = new JLabel("Resultado: ?");
        cuadroDeResultado.setBounds(50, 280, 150, 30); // Posición y tamaño del label
        add(cuadroDeResultado);

        campoRespuesta = new JTextField();
        campoRespuesta.setBounds(250, 280, 150, 30); // Posición y tamaño del campo de texto
        campoRespuesta.setEnabled(false);
        add(campoRespuesta);

        btnVerificar = new JButton("Verificar");
        btnVerificar.setBounds(250, 325, 150, 30); // Posición y tamaño del botón
        btnVerificar.setEnabled(false);
        add(btnVerificar);

        // Inicializar lista de secuencia y resultado
        listaNumYOpera = new ArrayList<>();
        resultadoActu = 0;

        // Acción para el botón de inicio
        btnIniciar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                iniciarJuego();
            }
        });

        // Acción para verificar la respuesta
        btnVerificar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                verificarRespuesta();
            }
        });
    }
    
    private void cambiarDificultad(int elementos) {
        numElementos = elementos;
        JOptionPane.showMessageDialog(this, "Dificultad cambiada a " + (elementos == 3 ? "Fácil" : (elementos == 5 ? "Normal" : "Difícil")));
    }

    public void iniciarJuego() {
        listaNumYOpera.clear();
        generarNumeros();
        resultadoActu = calcularResultado();
        i = 0;

        cuadroDeTexto.setText("Prepárate...");
        cuadroDeResultado.setText("Resultado: ?");
        campoRespuesta.setText("");
        campoRespuesta.setEnabled(false);
        btnVerificar.setEnabled(false);
        btnIniciar.setEnabled(false);

        // Muestra los elementos uno por uno con un temporizador
        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (i < listaNumYOpera.size()) {
                    cuadroDeTexto.setFont(new Font("Arial", Font.BOLD, 100));
                    cuadroDeTexto.setText(listaNumYOpera.get(i));
                    i++;
                    
                } else {
                    timer.stop();
                    cuadroDeTexto.setFont(new Font("Arial", Font.BOLD, 20));
                    cuadroDeTexto.setText("Escribe el resultado:");
                    campoRespuesta.setEnabled(true);
                    btnVerificar.setEnabled(true);
                }
            }
        });
        timer.setRepeats(true);
        timer.start();
    }

    private void generarNumeros() {
        Random random = new Random();
        String[] operators = {"+", "-"};

        for (int i = 0; i < numElementos; i++) {
            // Genera un número entre 1 y 20
            listaNumYOpera.add(String.valueOf(random.nextInt(20) + 1));
            // Agrega un operador si no es el último número
            if (i < numElementos - 1) {
                listaNumYOpera.add(operators[random.nextInt(2)]);
            }
        }
    }

    private int calcularResultado() {
        // Calcula el resultado de la secuencia generada
        int result = Integer.parseInt(listaNumYOpera.get(0)); // Primer número
        for (int i = 1; i < listaNumYOpera.size(); i += 2) {
            String operator = listaNumYOpera.get(i);
            int nextNumber = Integer.parseInt(listaNumYOpera.get(i + 1));
            if (operator.equals("+")) {
                result += nextNumber;
            } else if (operator.equals("-")) {
                result -= nextNumber;
            }
        }
        return result;
    }

    private void verificarRespuesta() {
        try {
            int userAnswer = Integer.parseInt(campoRespuesta.getText());
            if (userAnswer == resultadoActu) {
                JOptionPane.showMessageDialog(this, "¡Correcto! Bien hecho.");
            } else {
                JOptionPane.showMessageDialog(this, "Incorrecto. El resultado correcto era: " + resultadoActu);
            }
            reiniciarJuego();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Por favor ingresa un número válido.");
        }
    }

    private void reiniciarJuego() {
        cuadroDeTexto.setText("Haz clic en 'Iniciar' para comenzar.");
        cuadroDeResultado.setText("Resultado: ?");
        btnIniciar.setEnabled(true);
        btnVerificar.setEnabled(false);
        campoRespuesta.setEnabled(false);
    }

    public void Iniciar() {
        SwingUtilities.invokeLater(new Runnable() {
            
            @Override
            public void run() {
                new Operaciones().setVisible(true);
            }
        });
    }
}