package juego.de.memomria;

import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

class Render extends JPanel{

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); 
    
        if(SimonDice.simon != null){
        SimonDice.simon.paint((Graphics2D) g);
        }

    } 
    
    @Override
    public void repaint() {
        super.repaint();  // Llama a repaint() de JPanel
    }
}
