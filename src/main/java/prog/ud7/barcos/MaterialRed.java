/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prog.ud7.barcos;

/**
 *
 * @author Ana Carbonell Prieto
 */
public enum MaterialRed {
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
