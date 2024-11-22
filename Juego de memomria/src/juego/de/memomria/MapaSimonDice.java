
package juego.de.memomria;

public class MapaSimonDice {
    
    int mapa = 4;
    double Dificultad = 15;


    public int getMapa() {
        return mapa;
    }

    public void setMapa(int mapa) {
        this.mapa = mapa;
    }

    public double getDificultad() {
        return Dificultad;
    }

    public void setDificultad(double Dificultad) {
        this.Dificultad = Dificultad;
    }

    @Override
    public String toString() {
        return "mapa# " + mapa + ", Dificultad = " + Dificultad;
    }
    
    
    
}
