package Controlador;

import Modelo.Casilla;
import Modelo.CasillaAbiertaListener;
import Modelo.PartidaGanadaListener;
import Modelo.PartidaPerdidaListener;
import Modelo.Tablero;
import java.util.List;
import javax.swing.JOptionPane;

public class JuegoControlador {

    private Tablero tablero;

    public JuegoControlador(int numFilas, int numColumnas, int numMinas) {
        tablero = new Tablero(numFilas, numColumnas, numMinas);
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

    public boolean partidaPerdida() {
        try {
            return tablero.partidaPerdida();
        } catch (Exception e) {
            mostrarError("Error al verificar si la partida está perdida");
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

    public void seleccionarCasilla(int posFila, int posColumna) {
        try {
            tablero.seleccionarCasilla(posFila, posColumna);
        } catch (ArrayIndexOutOfBoundsException e) {
            mostrarError("Posición inválida. Por favor, selecciona una casilla válida.");
        } catch (NumberFormatException e) {
            mostrarError("Entrada inválida. Por favor, introduce un número válido.");
        } catch (Exception e) {
            mostrarError("Error inesperado. Por favor, reinicia el juego.");
        }
    }

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

