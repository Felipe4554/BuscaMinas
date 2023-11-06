/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Modelo;

/**
 *
 * @author ´Felipe Chacón
 */
public interface SujetoObservable {
    void registrarObservador(TableroObserver observador);
    void removerObservador(TableroObserver observador);
    void notificarObservadores();
}
