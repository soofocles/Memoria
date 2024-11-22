package juego.de.memomria;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Window;
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
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

public class SimonDice extends JFrame implements ActionListener, MouseListener {

    public Render renderizado;
    static public MapaSimonDice mapaSimonDice;
    public static SimonDice simon;
    public static final int width = 800, height = 800;
    private static int flash = 0, ticks, oscuro, indicePatron, maximo = 8, color = 6;
    public static boolean patronCreado = true;
    private static double velocidad = 15;
    public static ArrayList<Integer> patronJuego = new ArrayList<>();
    public static Random random;
    private boolean gameOver;
    private static boolean esperandoPatron = false, esGanador = false, modoSupervivencia = false, iniciandoJuego = true;
    private static int tiempoSegundos = 0;
    private long startTime;
    private long elapsedTime;
    private Timer cronometro;
    private int patronesConseguidos = 0;
    private JDesktopPane desktopPane;
    private JPanel Panel;
    private JFrame frame;

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

    public SimonDice(boolean iniciandoJuego) {
        // Crear la ventana principal (JFrame)
        frame = new JFrame("Simon");
        Panel = new JPanel();
        
        Timer tiepo = new Timer(25, this);
        renderizado = new Render();
        frame.add(Panel);
        this.add(renderizado);
        
        if (modoSupervivencia == true){
            maximo = 100;
            color = 4;
        }else {
         mapaSimonDice = new MapaSimonDice();
        
        color = mapaSimonDice.getMapa();
        velocidad = mapaSimonDice.getDificultad();
        }
        // Configurar la ventana
        frame.setSize(width, 549);
        
        frame.addMouseListener(this);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.add(getRenderPanel());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        this.add(Panel = new JPanel());
        
        
       renderizado.repaint();
        
        Timer tiempos = new Timer(16, e -> renderizado.repaint());
        
        tiempos.start();

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
    
    public Render getRenderPanel() {
        return renderizado;
    }

    public static void main(String[] args) {
        
        simon = new SimonDice(iniciandoJuego);
    }

    public void Iniciar() {
        random = new Random();
        indicePatron = 0;
        oscuro = 2;
        flash = 0;
        ticks = 0;
        frame.setVisible(true);
        renderizado.repaint();
        startTime = System.currentTimeMillis();
        isTimerRunning = true;

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (isTimerRunning) {
            elapsedTime = System.currentTimeMillis() - startTime;
        }
        ticks++;

        if (ticks % velocidad == 0) {
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
                        flash = random.nextInt(color) + 1;
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

        SwingUtilities.invokeLater(new Runnable() {
    public void run() {
        
        renderizado.repaint();
        
    }
});
    }

    void paint(Graphics2D grafico) {
        
        while (iniciandoJuego == true) {            
            
        

        int circleWidth = 1000 / 2;
        int circleHeight = 1000 / 2;
        int offsetX = 0;
        int offsetY = 5;
        int centerX = offsetX + circleWidth / 2;
        int centerY = offsetY + circleHeight / 2;

        
        Color colorCustonMagenta = new Color(204, 169, 221);
        Color colorCustomCafe = new Color(161, 130, 98);
        Color colorNegroClaro = new Color(51, 51, 51);

        grafico.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Fondo negro
        grafico.setColor(colorNegroClaro);
        grafico.fillRect(0, 0, width, height);

        // Número de colores (sectores)
        int numColores = color; // Variable que define cuántos sectores tiene el círculo

        // Colores para cada sector
        Color[] colores = {
            Color.GREEN, Color.ORANGE, Color.BLUE, Color.RED ,
            Color.CYAN, Color.PINK, colorCustomCafe,colorCustonMagenta
        };

        int anguloSector = 360 / numColores;
        for (int i = 0; i < numColores; i++) {
            grafico.setColor(flash == (i + 1) ? colores[i] : colores[i].darker());
            grafico.fillArc(offsetX, offsetY, circleWidth, circleHeight, i * anguloSector, anguloSector);
        }

        grafico.setColor(Color.BLACK);
        int rectSize = circleWidth / 2;
        grafico.fillRoundRect(offsetX + rectSize / 2, offsetY + rectSize / 2, rectSize, rectSize, rectSize, rectSize);

        grafico.setColor(Color.BLACK);
        grafico.setStroke(new BasicStroke(10));
        int radius = circleWidth / 2;

        for (int i = 0; i < color; i++) {
            double angle = Math.toRadians(i * anguloSector);
            int endX = centerX + (int) (radius * Math.cos(angle));
            int endY = centerY + (int) (radius * Math.sin(angle));
            grafico.drawLine(centerX, centerY, endX, endY);
        }

        grafico.setColor(Color.BLACK);
        grafico.setStroke(new BasicStroke(10));
        grafico.drawOval(offsetX, offsetY, circleWidth, circleHeight);

        grafico.setFont(new Font("Arial", Font.BOLD, 70));
        grafico.setColor(Color.WHITE);

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
            grafico.setFont(new Font("Arial", esGanador ? Font.ITALIC : Font.BOLD, 130));
            textX = centerX - (esGanador ? 100 : 50);
            textY = centerY + (esGanador ? 0 : 40);
            grafico.drawString(mensaje, textX, textY);
        } else {
            grafico.setFont(new Font("Arial", Font.BOLD, 100));
            grafico.setColor(Color.WHITE);
            grafico.drawString(indicePatron + "/" + patronJuego.size(), width - 200, 300);
        }
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
                System.out.println(":(");
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

        switch (color) {
            case 4:

                if (angulo >= 0 && angulo < Math.PI / 2) {
                    colorIndex = 4;
                    flash = 4;
                } else if (angulo >= Math.PI / 2 && angulo < Math.PI) {
                    colorIndex = 3;
                    flash = 3;
                } else if (angulo >= Math.PI && angulo < 3 * Math.PI / 2) {
                    colorIndex = 2;
                    flash = 2;
                } else {
                    colorIndex = 1;
                    flash = 1;
                }
                break;
            case 5:

                if (angulo >= 0 && angulo < 2 * Math.PI / 5) {
                    colorIndex = 5;
                    flash = 5;
                } else if (angulo >= 2 * Math.PI / 5 && angulo < 4 * Math.PI / 5) {
                    colorIndex = 4;
                    flash = 4;
                } else if (angulo >= 4 * Math.PI / 5 && angulo < 6 * Math.PI / 5) {
                    colorIndex = 3;
                    flash = 3;
                } else if (angulo >= 6 * Math.PI / 5 && angulo < 8 * Math.PI / 5) {
                    colorIndex = 2;
                    flash = 2;
                } else {
                    colorIndex = 1;
                    flash = 1;
                }

                break;
            case 6:

                if (angulo >= 0 && angulo < Math.PI / 3) {
                    colorIndex = 6;
                    flash = 6;
                } else if (angulo >= Math.PI / 3 && angulo < 2 * Math.PI / 3) {
                    colorIndex = 5;
                    flash = 5;
                } else if (angulo >= 2 * Math.PI / 3 && angulo < Math.PI) {
                    colorIndex = 4;
                    flash = 4;
                } else if (angulo >= Math.PI && angulo < 4 * Math.PI / 3) {
                    colorIndex = 3;
                    flash = 3;
                } else if (angulo >= 4 * Math.PI / 3 && angulo < 5 * Math.PI / 3) {
                    colorIndex = 2;
                    flash = 2;
                } else {
                    colorIndex = 1;
                    flash = 1;
                }

                break;
            case 7:

                if (angulo >= 0 && angulo < Math.PI / 7) {
                    colorIndex = 7;
                    flash = 7;
                } else if (angulo >= Math.PI / 7 && angulo < 2 * Math.PI / 7) {
                    colorIndex = 6;
                    flash = 6;
                } else if (angulo >= 2 * Math.PI / 7 && angulo < 3 * Math.PI / 7) {
                    colorIndex = 5;
                    flash = 5;
                } else if (angulo >= 3 * Math.PI / 7 && angulo < 4 * Math.PI / 7) {
                    colorIndex = 4;
                    flash = 4;
                } else if (angulo >= 4 * Math.PI / 7 && angulo < 5 * Math.PI / 7) {
                    colorIndex = 3;
                    flash = 3;
                } else if (angulo >= 5 * Math.PI / 7 && angulo < 6 * Math.PI / 7) {
                    colorIndex = 2;
                    flash = 2;
                } else {
                    colorIndex = 1;
                    flash = 1;
                }

                break;
            case 8:

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

                break;
            default:
                throw new AssertionError();
        }

        System.out.println("Clic en el color: " + colorIndex);
        System.out.println("Patrón actual: " + (indicePatron < patronJuego.size() ? patronJuego.get(indicePatron) : "N/A"));

        if (colorIndex == patronJuego.get(indicePatron)) {
            indicePatron++;

            if (indicePatron == patronJuego.size()) {
                if (indicePatron == patronJuego.size()) {
    if (patronJuego.size() >= maximo) {
        gameOver = true;
        esGanador = true; // Marcamos que el jugador ganó
    } else {
        // Cambiar configuración según la dificultad
        if (modoSupervivencia) {
            if (patronJuego.size() < 5) {
                color = 4;
                velocidad = 15;
            } else if (patronJuego.size() < 10) {
                color = 5;
                velocidad = 1.5;
            } else if (patronJuego.size() < 15) {
                color = 6;
                velocidad = 11;
            } else if (patronJuego.size() < 20) {
                color = 7;
                velocidad = 9;
            } else {
                color = 8;
                velocidad = 7.5;
            }
        }

        // Preparar para el próximo patrón
        Timer espera = new Timer(50, new ActionListener() {
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
