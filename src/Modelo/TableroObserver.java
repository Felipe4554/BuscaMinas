package Modelo;

import java.util.List;

public interface TableroObserver {

    void actualizar(Tablero tablero);

    void casillaAbierta(Casilla casilla);

    void partidaPerdida(List<Casilla> casillas);

    void partidaGanada(List<Casilla> casillas);
}
