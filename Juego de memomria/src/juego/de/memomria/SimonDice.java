package juego.de.memomria;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.TimerTask;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.Timer;

public class SimonDice extends JFrame implements ActionListener, MouseListener {

    public Render renderizado;
    public static SimonDice simon;
    public static final int width = 800, height = 800;
    private static int flash = 0, ticks, oscuro, indicePatron, maximo = 8, color = 1,velocidad;
    public static boolean patronCreado = true;
    public static ArrayList<Integer> patronJuego = new ArrayList<>();
    public static Random random;
    private boolean gameOver;
    private static boolean esperandoPatron = false, esGanador = false;
    private static int tiempoSegundos = 0;
    private long startTime;
    private long elapsedTime;
    private Timer cronometro;
    private int patronesConseguidos = 0;
    private JDesktopPane desktopPane;


    private boolean isTimerRunning;

    private static final Map<Integer, String> colores = new HashMap<>();

    static {
        colores.put(1, "Verde");
        colores.put(2, "Amarillo");
        colores.put(3, "Azul");
        colores.put(4, "Magenta");
        colores.put(5, "Personalizado Magenta");
        colores.put(6, "Personalizado Café");
        colores.put(7, "Rojo");
        colores.put(8, "Color Personalizado");
    }

    public SimonDice() {
        // Crear la ventana principal (JFrame)
        JFrame frame = new JFrame("Simon");
        Timer tiepo = new Timer(25, this);
        renderizado = new Render();

        // Configurar la ventana
        frame.setSize(width, 549);
        frame.setVisible(true);
        frame.addMouseListener(this);
        frame.setResizable(false);
        frame.add(renderizado);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        cronometro = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!isTimerRunning) {
                    return; 
                }
            }
        });

        // Iniciar el juego
        Iniciar();
        patronesConseguidos = 0;
        gameOver = false;
        esGanador = false;
        startTime = System.currentTimeMillis();
        isTimerRunning = true;  // Cronómetro está activo
        tiepo.start();
        cronometro.start();  // Iniciar cronómetro
    }

    public static void main(String[] args) {
        simon = new SimonDice();
    }

    public void Iniciar() {
        random = new Random();
        indicePatron = 0;
        oscuro = 2;
        flash = 0;
        ticks = 0;

        startTime = System.currentTimeMillis();
        isTimerRunning = true;

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (isTimerRunning) {
            elapsedTime = System.currentTimeMillis() - startTime;
        }
        ticks++;

        if (ticks % 10 == 0) {
            flash = 0;
            if (oscuro >= 0) {
                oscuro--;
            }
        }

        if (patronCreado) {
            if (indicePatron < maximo) {
                if (oscuro <= 0) {
                    if (indicePatron >= patronJuego.size()) {
                        if (patronJuego.size() >= maximo) {
                            gameOver = true;
                            patronCreado = true;
                            return;
                        }
                        flash = random.nextInt(8) + 1;
                        patronJuego.add(flash);
                        indicePatron = 0;
                        patronCreado = false;
                    } else {
                        flash = patronJuego.get(indicePatron);
                        indicePatron++;
                    }
                    oscuro = 2;
                }
            }
        } else if (indicePatron == patronJuego.size()) {
            patronCreado = true;
            indicePatron = 0;
            oscuro = 2;
        }
        if (gameOver) {
            isTimerRunning = false; // Detenemos el cronómetro si el juego terminó
        }

        renderizado.repaint();
    }

    void paint(Graphics2D grafico) {

        int circleWidth = 1000 / 2;
        int circleHeight = 1000 / 2;
        int offsetX = 0;
        int offsetY = 5;
        int centerX = offsetX + circleWidth / 2;;
        int centerY = offsetY + circleHeight / 2;;

        Color colorCustonMagenta = new Color(204, 169, 221);
        Color colorCustomCafe = new Color(161, 130, 98);
        Color colorNegroClaro = new Color(51, 51, 51);

        grafico.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Fondo negro
        grafico.setColor(colorNegroClaro);
        grafico.fillRect(0, 0, width, height);
        
        switch (color) {
            case 1:
                
        grafico.setColor(flash == 1 ? Color.GREEN : Color.GREEN.darker());
        grafico.fillArc(offsetX, offsetY, circleWidth, circleHeight, 0, 45);

        grafico.setColor(flash == 2 ? Color.YELLOW : Color.YELLOW.darker());
        grafico.fillArc(offsetX, offsetY, circleWidth, circleHeight, 45, 45);

        grafico.setColor(flash == 3 ? Color.BLUE : Color.BLUE.darker());
        grafico.fillArc(offsetX, offsetY, circleWidth, circleHeight, 90, 45);

        grafico.setColor(flash == 4 ? colorCustonMagenta : colorCustonMagenta.darker());
        grafico.fillArc(offsetX, offsetY, circleWidth, circleHeight, 135, 45);

        grafico.setColor(flash == 5 ? Color.CYAN : Color.CYAN.darker());
        grafico.fillArc(offsetX, offsetY, circleWidth, circleHeight, 180, 45);

        grafico.setColor(flash == 6 ? Color.PINK : Color.PINK.darker());
        grafico.fillArc(offsetX, offsetY, circleWidth, circleHeight, 225, 45);

        grafico.setColor(flash == 7 ? colorCustomCafe : colorCustomCafe.darker());
        grafico.fillArc(offsetX, offsetY, circleWidth, circleHeight, 270, 45);

        grafico.setColor(flash == 8 ? Color.RED : Color.RED.darker());
        grafico.fillArc(offsetX, offsetY, circleWidth, circleHeight, 315, 45);

        // Dibujar el rectángulo central negro
        grafico.setColor(Color.BLACK);
        int rectSize = circleWidth / 2; // Ajustar tamaño del rectángulo central
        grafico.fillRoundRect(offsetX + rectSize / 2, offsetY + rectSize / 2, rectSize, rectSize, rectSize, rectSize);

        // Dibujar líneas divisorias
        grafico.setColor(Color.BLACK);
        grafico.setStroke(new BasicStroke(10));
        int radius = circleWidth / 2;

        for (int i = 0; i < 8; i++) {
            double angle = Math.toRadians(i * 45); // Ángulo de cada división
            int endX = centerX + (int) (radius * Math.cos(angle));
            int endY = centerY + (int) (radius * Math.sin(angle));
            grafico.drawLine(centerX, centerY, endX, endY);
        }

        grafico.setColor(Color.BLACK); // Color del borde
        grafico.setStroke(new BasicStroke(10)); // Grosor del borde
        grafico.drawOval(offsetX, offsetY, circleWidth, circleHeight);
        
            break;
            default:
        }
        grafico.setFont(new Font("Arial", Font.BOLD, 70));
        grafico.setColor(Color.WHITE);

// Convertir tiempo a formato mm:ss
        long seconds = (elapsedTime / 1000) % 60;
        long minutes = (elapsedTime / 1000) / 60;

        String timeText = String.format("%02d:%02d", minutes, seconds);
        grafico.drawString(timeText, width - 220, 70);

        grafico.setFont(new Font("Arial", Font.BOLD, 120));
        int textX = offsetX + circleWidth + 50;
        int textY = offsetY + circleHeight / 2;

        grafico.setColor(Color.WHITE);
        if (gameOver) {
            String mensaje = esGanador ? "¡Ganaste!" : ":(";
            if (esGanador == true) {
                grafico.setFont(new Font("Arial", Font.ITALIC, 130));
                textX = centerX - 100;
                textY = centerY;
                grafico.drawString(mensaje, textX, textY);
            } else if (esGanador == false) {
                grafico.setFont(new Font("Arial", Font.BOLD, 120));
                textX = centerX - 50;
                textY = centerY + 40;
                grafico.drawString(mensaje, textX, textY);
            }

        } else {
            grafico.setFont(new Font("Arial", Font.BOLD, 100));
            grafico.setColor(Color.WHITE);
            textX = offsetX + circleWidth + 50;
            textY = offsetY + circleHeight / 2;
            grafico.drawString(indicePatron + "/" + patronJuego.size(), width - 200, 300);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (gameOver) {
            if (esGanador) {
                System.out.println("¡Ganaste!");
            } else {
                System.out.println(":("); // Perdiste 
            }
            if (isTimerRunning) {
                isTimerRunning = false;
                cronometro.stop();
            }

            return;
        }

        int x = e.getX(); // Coordenada X del clic
        int y = e.getY(); // Coordenada Y del clic

        // Cálculo del clic dentro del círculo y su color
        int cx = 0 + (1000 / 4);
        int cy = 5 + (1000 / 4);
        double dx = x - cx;
        double dy = y - cy;
        double distancia = Math.sqrt(dx * dx + dy * dy);

        int radioExterno = (1000 / 2) / 2;
        int radioInterno = radioExterno / 2;
        if (distancia < radioInterno || distancia > radioExterno) {
            System.out.println("Clic fuera del rango del círculo.");
            return;
        }

        double angulo = Math.atan2(dy, dx);
        if (angulo < 0) {
            angulo += 2 * Math.PI;
        }

        int colorIndex = -1;
        if (angulo >= 0 && angulo < Math.PI / 4) {
            colorIndex = 8;
            flash = 8;
        } else if (angulo >= Math.PI / 4 && angulo < Math.PI / 2) {
            colorIndex = 7;
            flash = 7;
        } else if (angulo >= Math.PI / 2 && angulo < 3 * Math.PI / 4) {
            colorIndex = 6;
            flash = 6;
        } else if (angulo >= 3 * Math.PI / 4 && angulo < Math.PI) {
            colorIndex = 5;
            flash = 5;
        } else if (angulo >= Math.PI && angulo < 5 * Math.PI / 4) {
            colorIndex = 4;
            flash = 4;
        } else if (angulo >= 5 * Math.PI / 4 && angulo < 3 * Math.PI / 2) {
            colorIndex = 3;
            flash = 3;
        } else if (angulo >= 3 * Math.PI / 2 && angulo < 7 * Math.PI / 4) {
            colorIndex = 2;
            flash = 2;
        } else {
            colorIndex = 1;
            flash = 1;
        }

        System.out.println("Clic en el color: " + colorIndex);
        System.out.println("Patrón actual: " + (indicePatron < patronJuego.size() ? patronJuego.get(indicePatron) : "N/A"));

        if (colorIndex == patronJuego.get(indicePatron)) {
            indicePatron++;

            if (indicePatron == patronJuego.size()) {
                if (patronJuego.size() >= maximo) {
                    gameOver = true;
                    esGanador = true; // Marcamos que el jugador ganó
                } else {
                    Timer espera = new Timer(200, new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            if (!gameOver) {
                                patronCreado = true;
                                flash = 0;
                                indicePatron = 0;
                                renderizado.repaint();
                            }
                        }
                    });
                    espera.setRepeats(false);
                    espera.start();
                }
            }
        } else {
            gameOver = true;
            esGanador = false;
            cronometro.stop();
        }

    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
}
