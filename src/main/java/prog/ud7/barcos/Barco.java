/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package prog.ud7.barcos;

import java.time.LocalDate;
import prog.u6.data.Data;

/**
 *
 * @author Ana Carbonell Prieto
 */
public class Barco {
    protected String nombre;
    protected String matrícula;
    protected int anyoConstruccion;
    protected Data fechaAdquisicion;
    protected int horasMantenimiento;

    public Barco(String nombre, String matrícula, int añoConstruccion) {
        this.nombre = nombre;
        this.matrícula = matrícula;
        this.anyoConstruccion = añoConstruccion;
        
        LocalDate fechaActual = LocalDate.now();
        this.fechaAdquisicion = new Data(fechaActual.getDayOfMonth(), fechaActual.getMonthValue(), fechaActual.getYear());
        
        this.horasMantenimiento = 0;
    }

    @Override
    public String toString() {
        return String.format("Tipo de barco: BARCO, nombre: %s, matrícula: %s, año de construcción: %d, horas de mantenimiento: %d",
                this.nombre, this.matrícula, this.anyoConstruccion, this.horasMantenimiento
        );
    }
    
    public void realizarMantenimiento() {
        this.horasMantenimiento += 100;
    }
}
