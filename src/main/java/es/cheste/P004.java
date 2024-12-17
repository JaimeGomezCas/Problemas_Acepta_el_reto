

import java.util.Arrays;
import java.util.Scanner;

public class P004 {
    private static final double EXCEDENTE = 0.001;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int grado = Integer.parseInt(sc.nextLine());

        while (grado != 20) {

            String funcionLinea = sc.nextLine();
            String[] numerosSeparadosCadena = funcionLinea.split(" ");

            int[] funcion = new int[grado + 1];
            for (int i = 0; i < numerosSeparadosCadena.length; i++) {
                funcion[i] = Integer.parseInt(numerosSeparadosCadena[i]) ;
            }

            casoDePrueba(funcion, Integer.parseInt(sc.nextLine()));

            grado = Integer.parseInt(sc.nextLine());

        }

        sc.close();

    }

    public static void casoDePrueba(int[] funcion, int n) {
        double x = 1.0 / n;
        double areaCain = 0;
        double areaFx = 0;
        double incrementoX = x;
        int exponente = funcion.length - 1;

        //se calculan n funciones, donde n son las subdivisiones para aproximar mas o menos.
        for (int i = 0; i < n - 1; i++) {

            //se calcula el area del rectangulo creado en esa area
            for (int j = 0; j < funcion.length; j++) {

                if (j != funcion.length - 1) {
                    areaFx += (funcion[j] * Math.pow(incrementoX, exponente));
                } else {
                    areaFx += funcion[j];
                }
                if (exponente > 1) {
                    exponente--;
                }

            }
            /*
            Despues de calcular, solo sumaremos el valor que se halle en el rango deseado.
            El area máxima de cada f(xi) tiene que ser por definición de altura 1 y de base (b-a)/n.
            Tambíen si f(x) tiene un valor negativo no lo contaremos, ya que no entra dentro de nuestro rango.
            */
            if (areaFx < 0) {
                areaFx = 0;
            } else if (areaFx > 1) {
                areaFx = 1;
            }
            areaFx *= x;
            areaCain += areaFx;

            //Seteamos los  valores para la siguiente iteración.
            incrementoX += x;
            exponente = funcion.length - 1;
            areaFx = 0;
        }


        double areaAbel = Math.abs(1.0 - areaCain);
        double diferencia = areaCain - areaAbel;


        if (Math.abs(diferencia) < EXCEDENTE) {
            System.out.println("JUSTO");
        } else if (diferencia > 0) {
            System.out.println("CAIN");
        } else {
            System.out.println("ABEL");
        }
    }
}
