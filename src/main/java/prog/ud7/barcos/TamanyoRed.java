/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prog.ud7.barcos;

/**
 *
 * @author Ana Carbonell Prieto
 */
public enum TamanyoRed {
    PEQUENYA("pequeño"),
    MEDIANA("mediano"),
    GRANDE("grande");
    
    private String tamanyo;
    
    TamanyoRed(String tamanyo) {
        this.tamanyo = tamanyo;
    }

    @Override
    public String toString() {
        return this.tamanyo;
    }
}
