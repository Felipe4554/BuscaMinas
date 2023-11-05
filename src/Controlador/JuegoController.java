package Controlador;

import Modelo.Casilla;
import Modelo.CasillaAbiertaListener;
import Modelo.PartidaGanadaListener;
import Modelo.PartidaPerdidaListener;
import Modelo.TableroBuscaminas;
import java.util.List;
import javax.swing.JOptionPane;

public class JuegoController {

    private TableroBuscaminas tablero;

    public JuegoController(int numFilas, int numColumnas, int numMinas) {
        tablero = new TableroBuscaminas(numFilas, numColumnas, numMinas);
    }

    // Métodos relacionados con la inicialización y configuración del tablero
    public void inicializarCasillas() {
        try {
            tablero.inicializarCasillas();
        } catch (ArrayIndexOutOfBoundsException e) {
            JOptionPane.showMessageDialog(null, "Error al inicializar casillas: índice fuera de rango", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void generarMinas() {
        try {
            tablero.generarMinas();
        } catch (ArrayIndexOutOfBoundsException e) {
            JOptionPane.showMessageDialog(null, "Error al generar minas: índice fuera de rango", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void actualizarNumeroMinasAlrededor() {
        try {
            tablero.actualizarNumeroMinasAlrededor();
        } catch (ArrayIndexOutOfBoundsException e) {
            JOptionPane.showMessageDialog(null, "Error al actualizar el número de minas alrededor: índice fuera de rango", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public boolean partidaGanada() {
        try {
            return tablero.partidaGanada();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al verificar si la partida está ganada", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    public boolean partidaPerdida() {
        try {
            return tablero.partidaPerdida();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al verificar si la partida está perdida", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    public List<Casilla> obtenerCasillasConMinas() {
        try {
            return tablero.obtenerCasillasConMinas();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al obtener casillas con minas", "Error", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }

    public void marcarCasillaAbierta(int posFila, int posColumna) {
        try {
            tablero.marcarCasillaAbierta(posFila, posColumna);
        } catch (ArrayIndexOutOfBoundsException e) {
            JOptionPane.showMessageDialog(null, "Error: posición inválida. Por favor, selecciona una casilla válida.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Métodos relacionados con la selección de casillas y manejo de eventos
    public void seleccionarCasilla(int posFila, int posColumna) {
        try {
            tablero.seleccionarCasilla(posFila, posColumna);
        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(null, "Se produjo un error. Por favor, reinicia el juego.", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (ArrayIndexOutOfBoundsException e) {
            JOptionPane.showMessageDialog(null, "Posición inválida. Por favor, selecciona una casilla válida.", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (ArithmeticException e) {
            JOptionPane.showMessageDialog(null, "Se produjo un error en el cálculo. Por favor, reinicia el juego.", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Entrada inválida. Por favor, introduce un número válido.", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Se produjo un error inesperado. Por favor, reinicia el juego.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Listeners
    public void setCasillaAbiertaListener(CasillaAbiertaListener listener) {
        tablero.setCasillaAbiertaListener(listener);
    }

    public void setPartidaPerdidaListener(PartidaPerdidaListener listener) {
        tablero.setPartidaPerdidaListener(listener);
    }

    public void setPartidaGanadaListener(PartidaGanadaListener listener) {
        tablero.setPartidaGanadaListener(listener);
    }
}
