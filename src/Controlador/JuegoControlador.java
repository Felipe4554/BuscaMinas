package Controlador;

import Modelo.Casilla;
import Modelo.Tablero;
import Modelo.TableroObserver;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JOptionPane;

public class JuegoControlador implements TableroObserver {

    private Tablero tablero;
    private JButton[][] matrizBtn;

    public JuegoControlador(int numFilas, int numColumnas, int numMinas, JButton[][] matrizBtn) {
        this.matrizBtn = matrizBtn;
        tablero = new Tablero(numFilas, numColumnas, numMinas);
        tablero.registrarObservador(this);
    }

    private void mostrarError(String mensaje) {
        JOptionPane.showMessageDialog(null, "Error: " + mensaje, "Error", JOptionPane.ERROR_MESSAGE);
    }

    public void inicializarCasillas() {
        try {
            tablero.inicializarCasillas();
        } catch (ArrayIndexOutOfBoundsException e) {
            mostrarError("Índice fuera de rango al inicializar casillas");
        }
    }

    public void generarMinas() {
        try {
            tablero.generarMinas();
        } catch (ArrayIndexOutOfBoundsException e) {
            mostrarError("Índice fuera de rango al generar minas");
        }
    }

    public void actualizarNumeroMinasAlrededor() {
        try {
            tablero.actualizarNumeroMinasAlrededor();
        } catch (ArrayIndexOutOfBoundsException e) {
            mostrarError("Índice fuera de rango al actualizar el número de minas alrededor");
        }
    }

    public boolean partidaGanada() {
        try {
            return tablero.partidaGanada();
        } catch (Exception e) {
            mostrarError("Error al verificar si la partida está ganada");
            return false;
        }
    }

    public List<Casilla> obtenerCasillasConMinas() {
        try {
            return tablero.obtenerCasillasConMinas();
        } catch (Exception e) {
            mostrarError("Error al obtener casillas con minas");
            return null;
        }
    }

    public void marcarCasillaAbierta(int posFila, int posColumna) {
        try {
            tablero.marcarCasillaAbierta(posFila, posColumna);
        } catch (ArrayIndexOutOfBoundsException e) {
            mostrarError("Posición inválida. Por favor, selecciona una casilla válida.");
        }
    }

    public void escogerCasilla(int posFila, int posColumna) {
        try {
            tablero.escogerCasilla(posFila, posColumna);
        } catch (ArrayIndexOutOfBoundsException e) {
            mostrarError("Posición inválida. Por favor, selecciona una casilla válida.");
        } catch (NumberFormatException e) {
            mostrarError("Entrada inválida. Por favor, introduce un número válido.");
        } catch (Exception e) {
            mostrarError("Error inesperado. Por favor, reinicia el juego.");
        }
    }

    public void deshabilitarBotones() {
        for (int i = 0; i < matrizBtn.length; i++) {
            for (int j = 0; j < matrizBtn[i].length; j++) {
                matrizBtn[i][j].setEnabled(false);
            }
        }
    }

    @Override
    public void casillaAbierta(Casilla casilla) {
        int fila = casilla.getFila();
        int columna = casilla.getColumna();
        matrizBtn[fila][columna].setEnabled(false);
        matrizBtn[fila][columna].setText(casilla.getNumMinasAlrededor() == 0 ? "" : String.valueOf(casilla.getNumMinasAlrededor()));
    }

    @Override
    public void partidaPerdida(List<Casilla> casillas) {
        for (Casilla casillaConMina : casillas) {
            int fila = casillaConMina.getFila();
            int columna = casillaConMina.getColumna();
            matrizBtn[fila][columna].setText("*");
        }
    }

    @Override
    public void partidaGanada(List<Casilla> casillas) {
        for (Casilla casillaConMina : casillas) {
            int fila = casillaConMina.getFila();
            int columna = casillaConMina.getColumna();
            matrizBtn[fila][columna].setText(":)");
        }
    }

    @Override
    public void actualizar(Tablero tablero) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
