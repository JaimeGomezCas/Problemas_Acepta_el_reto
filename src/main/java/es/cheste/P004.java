package es.cheste;

import java.util.Scanner;

public class P004 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int grado = 0;

        while (grado < 20){
            grado = sc.nextInt();
            int[] funcion = new int[grado + 1];
            for (int i = 0; i < funcion.length; i++) {
                funcion[i] = sc.nextInt();
            }
            casoDePrueba(funcion, sc.nextInt());
        }

    }
    public static void casoDePrueba(int[] funcion, int n){

        double incrementoDeX =  1.0 / n;
        double areaCain = 0;
        int exponenteFuncion = 0;
        double valorFuncionXn = 0;
        for (int i = 0; i < n; i++) {

            exponenteFuncion = funcion.length - 1;

            for (int j = 0; j < funcion.length; j++) {
                
                if(funcion[j] > 0 && j != funcion.length - 1){

                    valorFuncionXn += (funcion[j] * Math.pow(incrementoDeX, exponenteFuncion));

                }
                exponenteFuncion --;


            }

            areaCain += valorFuncionXn;
            incrementoDeX += 1.0 /n;
        }

        System.out.println("AREA CAIN: " + areaCain);


    }
}
