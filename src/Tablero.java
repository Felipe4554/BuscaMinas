
import java.util.LinkedList;
import java.util.List;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ´Felipe Chacón
 */
public class Tablero {
    Casilla[][] casillas;
    
    private int numFilas;
    private int numColumnas;
    private int numMinas;

    public Tablero(int numFilas, int numColumnas, int numMinas) {
        this.numFilas = numFilas;
        this.numColumnas = numColumnas;
        this.numMinas = numMinas;
        this.inicializarCasillas(numFilas, numColumnas);
    }
    
    public void inicializarCasillas(int numFilas, int numColumnas){
        casillas = new Casilla [this.numFilas][this.numColumnas];
        for (int i = 0; i < casillas.length; i++){
            for (int j = 0; j < casillas[i].length; j++){
                casillas[i][j]= new Casilla(i, j);
            }
        }
        generarMinas();
    }
    
    private void generarMinas(){
        int minasGeneradas=0;
        while(minasGeneradas!=numMinas){
            int posTmpFila=(int)(Math.random()*casillas.length);
            int posTmpColumna=(int)(Math.random()*casillas[0].length);
            if(!casillas[posTmpFila][posTmpColumna].isMina()){
                casillas[posTmpFila][posTmpColumna].setMina(true);
                minasGeneradas++;
            }
        }
        actualizarNumeroMinasAlrededor();
    }
    
    private void actualizarNumeroMinasAlrededor(){
        for (int i = 0; i < casillas.length; i++){
            for (int j = 0; j < casillas[i].length; j++){
                if (casillas[i][j].isMina()){
                    List<Casilla> casillasAlrededor=obtenerCasillasAlrededor(i, j);
                    casillasAlrededor.forEach((c)->c.incrementarNumeroMinasAlrededor());
                }
            }
        }
    }
    
    private List<Casilla> obtenerCasillasAlrededor(int posFila, int posColumna){
        List<Casilla> listaCasillas=new LinkedList();
        for(int i = 0; i < 8; i++){
            int tmpPosFila = posFila;
            int tmpPosColumna = posColumna;
            switch(i){
                case 0 -> tmpPosFila--;
                //Arriba
                case 1 -> {
                    tmpPosFila--;
                    tmpPosColumna++;
                    //Arriba Derecha
                }
                case 2 -> tmpPosColumna++;
                //Derecha
                case 3 -> {
                    tmpPosColumna++;
                    tmpPosFila++;
                    // Derecha Abajo
                }
                case 4 -> tmpPosFila++;
                // Abajo
                case 5 -> {
                    tmpPosFila++;
                    tmpPosColumna--;
                    // Abajo Izquierda
                }
                case 6 -> tmpPosColumna--;
                // Izquierda
                case 7 -> {
                    tmpPosFila--;
                    tmpPosColumna--;
                    // Izquierda Arriba
                }
            }
            
            if(tmpPosFila>=0 && tmpPosFila<this.casillas.length
                    && tmpPosColumna>=0 && tmpPosColumna<this.casillas[0].length){
                listaCasillas.add(this.casillas[tmpPosFila][tmpPosColumna]);
            }
        }
        return listaCasillas;
    }
}
