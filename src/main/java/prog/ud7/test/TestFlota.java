/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prog.ud7.test;

import prog.ud7.barcos.BarcoDeGuerra;
import prog.ud7.barcos.BarcoDePesca;
import prog.ud7.barcos.Flota;

/**
 *
 * @author Ana Carbonell Prieto
 */
public class TestFlota {
    
    public static void main(String[] args) {
        String[] armamento1 = {"Lanza cohetes", "Detector misiles", "Bombardero"};
        BarcoDeGuerra bg1 = new BarcoDeGuerra(armamento1, 10, 0, "Missiling", "AAAA", 2012);
        
        String[] armamento2 = {"Bombardero", "Lanza cohetes", "Detector misiles"};
        BarcoDeGuerra bg2 = new BarcoDeGuerra(armamento2, 10, 0, "Naviero feroz", "BBBB", 2013);
        
        String[] armamento3 = {"Lanza cohetes", "Detector misiles", "Machete"};
        BarcoDeGuerra bg3 = new BarcoDeGuerra(armamento3, 10, 0, "Tiatomic", "CCCC", 2014);
        
        String[] armamento4 = {"Lanza granadas", "Detector misiles"};
        BarcoDeGuerra bg4 = new BarcoDeGuerra(armamento4, 10, 0, "Hunter", "DDDD", 2015);
        
        String[] armamento5 = {"Bombardero", "Detector misiles"};
        BarcoDeGuerra bg5 = new BarcoDeGuerra(armamento5, 10, 0, "Terrorific", "EEEE", 2016);
        
        BarcoDePesca bp1 = new BarcoDePesca(20, 80, "Sardina Express", "SE-123", 2005);
        BarcoDePesca bp2 = new BarcoDePesca(20, 70, "Pez Payaso", "PP-456", 2010);
        BarcoDePesca bp3 = new BarcoDePesca(20, 85, "Calamar Cautivado", "CC-789", 2018);
        BarcoDePesca bp4 = new BarcoDePesca(20, 75, "Bacalao Bromista", "BB-101", 2008);
        BarcoDePesca bp5 = new BarcoDePesca(20, 65, "Atún Travies", "AT-234", 2015);
        
        Flota flota = new Flota();
        flota.anyadirBarco(bg1);
        flota.anyadirBarco(bg2);
        flota.anyadirBarco(bg3);
        flota.anyadirBarco(bg4);
        flota.anyadirBarco(bg5);
        flota.anyadirBarco(bp1);
        flota.anyadirBarco(bp2);
        flota.anyadirBarco(bp3);
        flota.anyadirBarco(bp4);
        flota.anyadirBarco(bp5);
        
        System.out.println("------ Todos Los Barcos --------");
        System.out.println(flota);
        System.out.println("------------------------");
        
        System.out.println("------ Coste de mantenimiento actual --------");
        flota.calcularCosteMantenimiento();
        System.out.println("------------------------");
        
        System.out.println("------ Mantenimiento generalizado -------");
        flota.realizarMantenimiento();
        System.out.println("------------------------");
        
        System.out.println("------ Todos los barcos de guerra -------");
        flota.mostrarBarcosDeGuerra();
        System.out.println("------------------------");
        
        System.out.println("------ Todos los barcos pesqueros -------");
        flota.mostrarBarcosDePesca();
        System.out.println("------------------------");
        
        System.out.println("------ Eliminar barco con matrícula PP-456 y mostrar todos los barcos -------");
        flota.eliminarBarco("PP-456");
        System.out.println(flota);
        System.out.println("------------------------");
    }
}
