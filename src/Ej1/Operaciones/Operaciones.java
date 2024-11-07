package Ej1.Operaciones;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Operaciones {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String linea;
        float division = 0;
        int resta = 0, multiplicacion = 0;
        try {
            linea = br.readLine();
            resta = Integer.parseInt(linea);
            multiplicacion = Integer.parseInt(linea);
            division = Float.parseFloat(linea);
            while ((linea = br.readLine()) != null){
                int num = Integer.parseInt(linea);
                multiplicacion *= num;
                resta -= num;
                if (num != 0){
                    division /= num;
                }

            }
        } catch (IOException e) {
            System.out.println("Error al leer desde teclado");
        }
        System.out.println("Multiplicacion: " + multiplicacion);
        System.out.println("Division: " + division);
        System.out.println("Resta: " + resta);
    }


}
