/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prog.ud7.barcos;

import java.util.Arrays;

/**
 *
 * @author Ana Carbonell Prieto
 */
public class BarcoDePesca extends Barco {
    private int capacidadCarga;
    private Red[] redes;
    private int porcentajeCapturas;

    public BarcoDePesca(int capacidad, int capturas, String nombre, String matrícula, int anyoConstruccion) {
        super(nombre, matrícula, anyoConstruccion);
        this.capacidadCarga = capacidad;
        this.redes = new Red[0];
        this.porcentajeCapturas = capturas;
    }
    
    public void anyadirNuevaRed(Red red) {
        int tamanyo = this.redes.length;

        this.redes = Arrays.copyOf(this.redes, tamanyo + 1);
        this.redes[tamanyo] = red;
    }
    
    public void eliminarRed(Red red) {
        for (int i = 0; i < this.redes.length; i++) {
            if (this.redes[i].comprobarIgualdad(red)) {
                this.redes[i] = null;
            }
        }
    }

    @Override
    public String toString() {
        return String.format("Tipo de barco:  BARCO DE PESCA, nombre: %s, matrícula: %s, año de construcción: %d, horas de mantenimiento: %d, redes: %s, porcentaje de éxito en captura: %d",
                super.nombre, super.matrícula, super.anyoConstruccion, super.horasMantenimiento, Arrays.toString(this.redes), this.porcentajeCapturas
        ) + '%';
    }

    @Override
    public void realizarMantenimiento() {
        for (int i = 0; i < 2; i++) {
            super.realizarMantenimiento();
        }
    }
}
