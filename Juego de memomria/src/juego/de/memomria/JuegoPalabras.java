package juego.de.memomria;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class JuegoPalabras extends JFrame {
    private ArrayList<String> wordSequence;
    private JLabel displayLabel;
    private JTextField inputField;
    private JButton submitButton, startStandardButton, startAdvancedButton, startVersusButton, backToMenuButton;
    private JLabel messageLabel;
    private int currentRound = 1;
    private boolean isAdvancedMode = false;
    private boolean isVersusMode = false;
    private int currentWordIndex = 0;
    private int playerTurn = 1;
    private int player1Score = 0;
    private int player2Score = 0;

    public JuegoPalabras() {
        setTitle("Juego de Memoria");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        wordSequence = new ArrayList<>();
        displayLabel = new JLabel("", SwingConstants.CENTER);
        inputField = new JTextField();
        submitButton = new JButton("Enviar");
        startStandardButton = new JButton("Modo Estándar");
        startAdvancedButton = new JButton("Modo Avanzado");
        startVersusButton = new JButton("Modo Versus");
        backToMenuButton = new JButton("Volver al Menú");
        messageLabel = new JLabel("Elige un modo para comenzar.", SwingConstants.CENTER);

        displayLabel.setFont(new Font("Times New Roman", Font.BOLD, 48));
        displayLabel.setForeground(Color.BLACK);

        JPanel startPanel = new JPanel();
        startPanel.setLayout(new GridLayout(5, 1, 20, 20));
        startPanel.setBackground(Color.WHITE);

        startStandardButton.setBackground(new Color(200, 162, 200));
        startStandardButton.setForeground(Color.BLACK);
        startStandardButton.setFont(new Font("Times New Roman", Font.BOLD, 24));

        startAdvancedButton.setBackground(new Color(173, 216, 230));
        startAdvancedButton.setForeground(Color.BLACK);
        startAdvancedButton.setFont(new Font("Times New Roman", Font.BOLD, 24));

        startVersusButton.setBackground(new Color(255, 72, 72));
        startVersusButton.setForeground(Color.BLACK);
        startVersusButton.setFont(new Font("Times New Roman", Font.BOLD, 24));

        backToMenuButton.setBackground(Color.LIGHT_GRAY);
        backToMenuButton.setForeground(Color.BLACK);
        backToMenuButton.setFont(new Font("Times New Roman", Font.BOLD, 20));

        startPanel.add(messageLabel);
        startPanel.add(startStandardButton);
        startPanel.add(startAdvancedButton);
        startPanel.add(startVersusButton);
        startPanel.add(backToMenuButton);

        add(startPanel, BorderLayout.CENTER);

        startStandardButton.addActionListener(e -> startGame(false, false));
        startAdvancedButton.addActionListener(e -> startGame(true, false));
        startVersusButton.addActionListener(e -> startGame(false, true));
        backToMenuButton.addActionListener(e -> returnToMenu());
        submitButton.addActionListener(e -> checkSequence());

        inputField.setEnabled(false);
        submitButton.setEnabled(false);
        submitButton.setFont(new Font("Times New Roman", Font.BOLD, 18));
        submitButton.setBackground(Color.GRAY);
        submitButton.setForeground(Color.WHITE);
    }

    private void startGame(boolean advancedMode, boolean versusMode) {
        currentRound = 1;
        wordSequence.clear();
        isAdvancedMode = advancedMode;
        isVersusMode = versusMode;
        currentWordIndex = 0;

        getContentPane().removeAll();
        setBackground(Color.WHITE);

        JPanel gamePanel = new JPanel(new BorderLayout());
        gamePanel.setBackground(Color.WHITE);

        displayLabel.setText("");
        gamePanel.add(displayLabel, BorderLayout.CENTER);

        JPanel inputPanel = new JPanel(new BorderLayout());
        inputField.setFont(new Font("Times New Roman", Font.PLAIN, 24));
        inputPanel.add(inputField, BorderLayout.CENTER);
        inputPanel.add(submitButton, BorderLayout.EAST);

        gamePanel.add(inputPanel, BorderLayout.SOUTH);

        JPanel backPanel = new JPanel();
        backPanel.setLayout(new BorderLayout());
        backPanel.add(backToMenuButton, BorderLayout.CENTER);
        gamePanel.add(backPanel, BorderLayout.NORTH);

        add(gamePanel);
        revalidate();
        repaint();

        messageLabel.setText(advancedMode ? "Modo Avanzado. Recuerda ingresar las palabras en orden, separadas por espacio."
                : (versusMode ? "Modo Versus. Turno del Jugador 1." : "Modo Estándar. Recuerda ingresar las palabras en orden, separadas por espacio."));

        Timer timer = new Timer(3000, e -> startCountdown());
        timer.setRepeats(false);
        timer.start();
    }

    private void startCountdown() {
        new Thread(() -> {
            for (int i = 3; i > 0; i--) {
                SwingUtilities.invokeLater(() -> displayLabel.setText("Comienza en: "));
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
            SwingUtilities.invokeLater(this::nextRound);
        }).start();
    }

    private void nextRound() {
        generateSequence(currentRound, isAdvancedMode);
        currentWordIndex = 0;
        showNextWord();
    }

    private void generateSequence(int length, boolean advancedMode) {
        wordSequence.clear();

        String[] standardWords = {"luna", "mesa", "puerta", "flor", "gato", "mar", "viento", "sol", "piedra", "playa", "luz", "manzana", "pared", "silla", "libro", "vela", "tierra", "pueblo", "mundo", "lago", "toro", "tiza", "hueso", "nube", "mujer", "rosa", "barco", "hombre", "pluma", "colina", "perro", "niña", "niño", "botella", "fuego", "casa", "ratón", "nieve", "hierro", "salón"};
        String[] advancedWords = {"ventilador", "bicicleta", "computadora", "universidad", "estantería", "repostería", "carretera", "ventanilla", "refrigerador", "microondas", "almohadilla", "diseñador", "navegación", "localizador", "televisión", "radiografía", "estudiante", "relajación", "transportador", "camioneta", "fotografía", "biblioteca", "resplandor", "electricidad", "observatorio", "anticonstitucionalidad", "bibliografía", "manipulación", "organización", "revolucionario", "calculadora", "termómetro", "celular", "diccionario", "pantalla", "alpinismo", "demostración", "espiritualidad", "caracterización", "estampilla"};

        ArrayList<String> wordPool = new ArrayList<>(List.of(advancedMode ? advancedWords : standardWords));
        Random random = new Random();

        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(wordPool.size());
            wordSequence.add(wordPool.remove(randomIndex));
        }
    }

    private void showNextWord() {
        if (currentWordIndex < wordSequence.size()) {
            displayLabel.setText(wordSequence.get(currentWordIndex));
            currentWordIndex++;
            Timer timer = new Timer(isAdvancedMode ? 500 : 1000, e -> showNextWord());
            timer.setRepeats(false);
            timer.start();
        } else {
            displayLabel.setText("");
            enableInput();
        }
    }

    private void enableInput() {
        inputField.setEnabled(true);
        submitButton.setEnabled(true);
        inputField.setText("");
        displayLabel.setText("Escribe la secuencia en el orden mostrado (por ejemplo: luna cielo mesa):");
    }

    private void checkSequence() {
        String userInput = inputField.getText().trim().toLowerCase();
        String correctSequence = String.join(" ", wordSequence).toLowerCase();

        if (userInput.equals(correctSequence)) {
            displayLabel.setText("¡Correcto!");
            if (isVersusMode) {
                if (playerTurn == 1) {
                    player1Score += currentRound;
                    playerTurn = 2;
                    displayLabel.setText("Turno del Jugador 2.");
                } else {
                    player2Score += currentRound;
                    playerTurn = 1;
                    displayLabel.setText("Turno del Jugador 1.");
                }
            }
            currentRound++;
        } else {
            displayLabel.setText("Incorrecto. La secuencia era: " + correctSequence);
        }

        inputField.setEnabled(false);
        submitButton.setEnabled(false);

        Timer timer = new Timer(2000, e -> nextRound());
        timer.setRepeats(false);
        timer.start();
    }

    private void returnToMenu() {
        player1Score = 0;
        player2Score = 0;
        currentRound = 1;
        playerTurn = 1;
        wordSequence.clear();

        getContentPane().removeAll();
        JPanel startPanel =

 new JPanel(new GridLayout(5, 1, 20, 20));
        startPanel.add(messageLabel);
        startPanel.add(startStandardButton);
        startPanel.add(startAdvancedButton);
        startPanel.add(startVersusButton);
        startPanel.add(backToMenuButton);

        add(startPanel, BorderLayout.CENTER);
        revalidate();
        repaint();
    }

    public void Iniciar() {
        SwingUtilities.invokeLater(() -> {
            JuegoPalabras game = new JuegoPalabras();
            game.setVisible(true);
        });
    }
}