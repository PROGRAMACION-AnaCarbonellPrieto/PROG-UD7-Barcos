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
                "Red de tamaño %s hecha de %s para pesca %s",
                this.tamanyo, this.material, this.tipoPesca
        );
    }
}