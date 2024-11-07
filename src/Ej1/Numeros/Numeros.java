package Ej1.Numeros;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Numeros {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String respuesta= "";

        {
            try {
                respuesta = br.readLine();
            } catch (IOException e) {
                System.out.println("Error al leer");
            }
            String[] numeros = respuesta.split(",");

            for (String numero : numeros){
                System.out.println(numero);
            }
        }
    }


}