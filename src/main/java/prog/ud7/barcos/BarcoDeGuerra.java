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
public class BarcoDeGuerra extends Barco {
    private String[] armamento;
    private int maxTripulacion;
    private int numTripulacion;

    public BarcoDeGuerra(String[] armamento, int maxTripulacion, int numTripulacion, String nombre, String matrícula, int añoConstruccion) {
        super(nombre, matrícula, añoConstruccion);
        
        this.armamento = new String[0];
        anyadirArmamento(armamento);
        
        this.maxTripulacion = maxTripulacion;
        this.numTripulacion = comprobarNumTripulacion(numTripulacion);
    }
    
    public void aumentarTripulantes(int numAumento) {
        this.numTripulacion = comprobarNumTripulacion(this.numTripulacion + numAumento);
    }
    
    public void aumentarMaximoDeTripulantes(int numAumento) {
        this.maxTripulacion += numAumento;
    }
    
    public void anyadirArmamento(String[] armamento) {
        for (String arma: armamento) {
            if (!comprobarArmamentoExistente(arma)) {
                int tamanyo = this.armamento.length;
                
                this.armamento = Arrays.copyOf(this.armamento, tamanyo + 1);
                this.armamento[tamanyo] = arma;
            }
        }
    }
    
    @Override
    public void realizarMantenimiento() {
        super.horasMantenimiento += 300;
    }

    @Override
    public String toString() {
        return String.format(
                "Tipo de barco: BARCO DE GUERRA, nombre: %s, matrícula: %s, año de construcción: %d, horas de mantenimiento: %d, armas a bordo: %s, número de tripulantes: %d",
                super.nombre, super.matrícula, super.añoConstruccion, super.horasMantenimiento, Arrays.toString(armamento), this.numTripulacion
        );
    }
    
    private int comprobarNumTripulacion(int numTripulacion) {
        return (this.maxTripulacion > numTripulacion) ? numTripulacion : this.maxTripulacion;
    }
    
    private boolean comprobarArmamentoExistente(String nuevaArma) {
        for (String arma: this.armamento) {
            if (arma.equals(nuevaArma)) return true;
        }
        
        return false;
    }
}
