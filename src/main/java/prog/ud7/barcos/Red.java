/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prog.ud7.barcos;

/**
 *
 * @author Ana Carbonell Prieto
 */
public class Red {
    private TamanyoRed tamanyo;
    private MaterialRed material;
    private TipoPesca tipoPesca;

    public Red(TamanyoRed tamanyo, MaterialRed material, TipoPesca tipoPesca) {
        this.tamanyo = tamanyo;
        this.material = material;
        this.tipoPesca = tipoPesca;
    }
    
    protected boolean comprobarIgualdad(Red red) {
        return (this.tamanyo == red.tamanyo && this.material == red.material && this.tipoPesca == red.tipoPesca);
    }

    @Override
    public String toString() {
        return String.format(
                "tamano: %s, material: %s, tipo de pesca: %s",
                this.tamanyo.toString(), this.material.toString(), this.tipoPesca.toString()
        );
    }
}

enum TamanyoRed {
    PEQUENYA("pequeña"),
    MEDIANA("mediana"),
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

enum MaterialRed {
    POLIAMIDA("poliamida"),
    POLIESTER("poliéster"),
    POLIETILENO("polietileno");
    
    private String material;
    
    MaterialRed(String material) {
        this.material = material;
    }

    @Override
    public String toString() {
        return this.material;
    }
}

enum TipoPesca {
    SPINNING("spinning"),
    SUBMARNA("submarina"),
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