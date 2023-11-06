package Modelo;

public class Casilla {

    private int fila;
    private int columna;
    private boolean tieneMina;
    private int minasCircundantes;
    private boolean abierta;

    public Casilla(int fila, int columna) {
        this.fila = fila;
        this.columna = columna;
    }

    public int getFila() {
        return fila;
    }

    public void setFila(int fila) {
        this.fila = fila;
    }

    public int getColumna() {
        return columna;
    }

    public void setColumna(int columna) {
        this.columna = columna;
    }

    public boolean isMina() {
        return tieneMina;
    }

    public void setMina(boolean mina) {
        this.tieneMina = mina;
    }

    public int getNumMinasAlrededor() {
        return minasCircundantes;
    }

    public void setNumMinasAlrededor(int numMinasAlrededor) {
        this.minasCircundantes = numMinasAlrededor;
    }

    public void incrementarNumeroMinasAlrededor() {
        this.minasCircundantes++;
    }

    public boolean isAbierta() {
        return abierta;
    }

    public void setAbierta(boolean abierta) {
        this.abierta = abierta;
    }

}
