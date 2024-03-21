/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prog.ud7.barcos;

/**
 *
 * @author Ana Carbonell Prieto
 */
public enum TipoPesca {
    SPINNING("spinning"),
    SUBMARINA("submarina"),
    CARPFISHING("carpfishing");
    
    private String tipo;
    
    TipoPesca(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return this.tipo;
    }
}
