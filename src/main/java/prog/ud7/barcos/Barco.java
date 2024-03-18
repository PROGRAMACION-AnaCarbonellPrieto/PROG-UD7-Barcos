/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package prog.ud7.barcos;

/**
 *
 * @author Ana Carbonell Prieto
 */
public class Barco {
    private String nombre;
    private String matrícula;
    private int añoConstruccion;
    //private Data fechaAdquisicion;
    private int horasMantenimiento;

    public Barco(String nombre, String matrícula, int añoConstruccion) {
        this.nombre = nombre;
        this.matrícula = matrícula;
        this.añoConstruccion = añoConstruccion;
        //this.fechaAdquisicion = new Data();
        this.horasMantenimiento = 0;
    }

    @Override
    public String toString() {
        return String.format(
                "Tipo de barco: BARCO, nombre: %s, matrícula: %s, año de construcción: %d, horas de mantenimiento: %d",
                this.nombre, this.matrícula, this.añoConstruccion, this.horasMantenimiento
        );
    }
    
    private void realizarMantenimiento() {
        this.horasMantenimiento += 100;
    }
}
