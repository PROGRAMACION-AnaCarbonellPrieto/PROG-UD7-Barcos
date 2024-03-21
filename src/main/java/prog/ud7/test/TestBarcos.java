/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prog.ud7.test;

import prog.ud7.barcos.Barco;
import prog.ud7.barcos.BarcoDeGuerra;
import prog.ud7.barcos.BarcoDePesca;
import prog.ud7.barcos.MaterialRed;
import prog.ud7.barcos.Red;
import prog.ud7.barcos.TamanyoRed;
import prog.ud7.barcos.TipoPesca;

/**
 *
 * @author Ana Carbonell Prieto
 */
public class TestBarcos {
    
    public static void main(String[] args) {
        System.out.println(
                """
                ---- Se crean tres barcos, uno de cada tipo. En el barco de guerra,
                comprueba que funciona tanto la eliminación de armas repetidas, como la
                creación de un barco de guerra con más tripulantes actuales que máximo.
                También deberás comprobar que el barco pesquero no tiene ninguna red dada
                de alta ----
                """
        );
        
        Barco barco = new Barco("La molinera", "XXXX", 2005);
        String[] armas = {"Lanza torpedos"};
        BarcoDeGuerra barcoDeGuerra = new BarcoDeGuerra(armas, 10, 0, "Arrasator", "YYYYY", 2017);
        BarcoDePesca barcoDePesca = new BarcoDePesca(20, 40, "Faenero", "ZZZZZ", 2001);
        
        System.out.println(barco);
        System.out.println(barcoDeGuerra);
        System.out.println(barcoDePesca);
        
        
        System.out.println(
                """
                
                ---- Incrementa las horas de mantenimiento de los tres barcos, y del
                pesquero una vez más ----
                """
        );
        
        barco.realizarMantenimiento();
        barcoDeGuerra.realizarMantenimiento();
        barcoDePesca.realizarMantenimiento();
        barcoDePesca.realizarMantenimiento();
        
        System.out.println(barco);
        System.out.println(barcoDeGuerra);
        System.out.println(barcoDePesca);
        
        System.out.println(
                """
                
                ---- Añade 2 redes diferentes al barco pesquero y un armamento compuesto
                por 2 armas iguales al barco de guerra, pero diferente a la que ya tiene
                registrada ----
                """
        );
        
        Red red1 = new Red(TamanyoRed.MEDIANA, MaterialRed.POLIAMIDA, TipoPesca.CARPFISHING);
        Red red2 = new Red(TamanyoRed.PEQUENYA, MaterialRed.POLIESTER, TipoPesca.SUBMARINA);
        barcoDePesca.anyadirNuevaRed(red1);
        barcoDePesca.anyadirNuevaRed(red2);
        
        String[] armamento = {"Misil de crucero", "Misil de crucero"};
        barcoDeGuerra.anyadirArmamento(armamento);
        
        System.out.println(barcoDeGuerra);
        System.out.println(barcoDePesca);
        
        System.out.println("\n---- Barco de pesca después de eliminar su primera red ----\n");
        
        barcoDePesca.eliminarRed(red1);
        System.out.println(barcoDePesca);
        
        System.out.println(
                """
                
                ---- Aumenta en 15 la tripulacion del barco de guerra con un máximo de 10
                tripulantes, posteriormente aumenta la tripulacion máxima en 10 y el número
                de tripulantes en 5 ----
                """
        );
        
        /*
        Como la tripulación máxima es de 10 y empezamos con un número de 0 tripulante el
        resultado ha de ser 10 tripulantes.
        */
        barcoDeGuerra.aumentarTripulantes(15);
        System.out.println(barcoDeGuerra);
        
        /*
        El máximo pasa a ser de 20 y la tripulación a 15.
        */
        barcoDeGuerra.aumentarMaximoDeTripulantes(10);
        barcoDeGuerra.aumentarTripulantes(5);
        System.out.println(barcoDeGuerra);
    }
}
