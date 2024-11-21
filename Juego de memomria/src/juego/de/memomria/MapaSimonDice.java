
package juego.de.memomria;

public class MapaSimonDice {
    
    int mapa;
    int Dificultad;

    public MapaSimonDice(int mapa, int Dificultad) {
        this.mapa = mapa;
        this.Dificultad = Dificultad;
    }

    public int getMapa() {
        return mapa;
    }

    public void setMapa(int mapa) {
        this.mapa = mapa;
    }

    public int getDificultad() {
        return Dificultad;
    }

    public void setDificultad(int Dificultad) {
        this.Dificultad = Dificultad;
    }

    @Override
    public String toString() {
        return "mapa# " + mapa + ", Dificultad = " + Dificultad;
    }
    
    
    
}
