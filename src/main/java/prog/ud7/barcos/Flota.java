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
public class Flota {
    private Barco[] barcos;
    
    public void anyadirBarcos(Barco barco) {
        if (!existeBarco(barco)) {
            int tamanyo = this.barcos.length;

            this.barcos = Arrays.copyOf(this.barcos, tamanyo + 1);
            this.barcos[tamanyo] = barco;
        }
    }
    
    public void eliminarBarco(String matricula) {
        for (int i = 0; i < this.barcos.length; i++) {
            if (this.barcos[i].matrícula.equals(matricula)) {
                int tamanyo = this.barcos.length;
                
                Barco temp = this.barcos[i];
                this.barcos[i] = this.barcos[tamanyo -1];
                this.barcos[tamanyo -1] = temp;
                
                this.barcos = Arrays.copyOf(this.barcos, tamanyo - 1);
                return;
            }
        }
    }
    
    private void mostrarInfoBarco(String matricula) {
        for (int i = 0; i < this.barcos.length; i++) {
            if (this.barcos[i].matrícula.equals(matricula)) {
                System.out.println(this.barcos[i]);
            }
        }
    }
    
    public void mostrarBarcosDeGuerra() {
        int cont = 1;
        
        for (int i = 0; i < this.barcos.length; i++) {
            if (this.barcos[i] instanceof BarcoDeGuerra) {
                System.out.printf("%d) ", cont++);
                mostrarInfoBarco(this.barcos[i].matrícula);
            }
        }
    }
    
    public void mostrarBarcosDePesca() {
        int cont = 1;
        
        for (int i = 0; i < this.barcos.length; i++) {
            if (this.barcos[i] instanceof BarcoDePesca) {
                System.out.printf("%d) ", cont++);
                mostrarInfoBarco(this.barcos[i].matrícula);
            }
        }
    }
    
    public void calcularCosteMantenimiento() {
        float coste = 0f;
        
        for (Barco barco: this.barcos) {
            if (barco instanceof BarcoDeGuerra) {
                coste += barco.horasMantenimiento * 6;
            } else {
                coste += barco.horasMantenimiento * 4;
            }
        }
        
        System.out.printf("El coste total en mantenimientos es %.2f €\n", coste);
    }
    
    public void realizarMantenimiento() {
        for (Barco barco: this.barcos) {
            barco.realizarMantenimiento();
        }
        
        calcularCosteMantenimiento();
    }
    
    @Override
    public String toString() {
        String flota = "";
        
        for (int i = 0; i < this.barcos.length; i++) {
            flota += String.format("%d) %s\n", i + 1, this.barcos[i]);
        }
        
        return flota;
    }
    
    private boolean existeBarco(Barco nuevoBarco) {
        for (Barco barco: this.barcos) {
            if (barco.equals(nuevoBarco)) return true;
        }
        return false;
    }
}
