package Ej1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

public class Main {
    public static void main(String[] args) {
        String[] comandoNumeros = {"Java", "-jar" ,"out/artifacts/numeros/numeros.jar"};
        String[] comandoOperaciones = {"Java", "-jar" ,"out/artifacts/operaciones/operaciones.jar"};
        //Leer desde usuario
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Dime un listado de numeros separados por coma");
        String numeros = "";
        try {
            numeros = br.readLine();
        } catch (IOException e) {
            System.out.println("Error al leer desde teclado");
        }

        //Crear procesos numeros y operaciones
        /* Poner en diferentes try y catch para saber que proceso no se pudo crear en ese caso */
        Process pNumeros = null;
        Process pOperaciones = null;
        try {

             pNumeros = new ProcessBuilder(comandoNumeros).start();

        } catch (IOException e) {
            System.out.println("No se pudo crear el proceso numeros");
        } try {

             pOperaciones = new ProcessBuilder(comandoOperaciones).start();
        } catch (IOException e) {
            System.out.println("No se pudo crear el proceso operaciones");
        }
        //Mandar a numeros
        if (pNumeros != null){
            PrintStream psNumeros = new PrintStream(pNumeros.getOutputStream());
            psNumeros.println(numeros);
            psNumeros.close();
        }
        //Recoger de numeros y mandar a operaciones
        if (pNumeros != null && pOperaciones != null){
            BufferedReader brNumeros = new BufferedReader(new InputStreamReader(pNumeros.getInputStream()));
           PrintStream psOperaciones = new PrintStream(pOperaciones.getOutputStream());
            String datosNumeros;
            try {
                while ((datosNumeros = brNumeros.readLine())!=null){
                    psOperaciones.println(datosNumeros);
                }
            } catch (IOException e) {
                System.out.println("Error al leer desde numeros");
            }
        }
        //Recoger de operaciones
        if (pOperaciones!=null){
            BufferedReader brOperaciones = new BufferedReader(new InputStreamReader(pOperaciones.getInputStream()));
            try { //se ponen 3 souts por las 3 operaciones que hay. Hay que controlar las lineas que vas a recibir siempre.
                System.out.println(brOperaciones.readLine());
                System.out.println(brOperaciones.readLine());
                System.out.println(brOperaciones.readLine());
            } catch (IOException e) {
                System.out.println("Error al leer desde operaciones");
            }
        }
        //Mostrar por pantalla
    }
}
