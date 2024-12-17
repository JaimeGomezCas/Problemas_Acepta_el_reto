package es.cheste;

import java.util.ArrayList;
import java.util.Scanner;

public class P005 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String linea = "";
        ArrayList<String> lineas = new ArrayList<>();
        while (!linea.equals("0 0 0 0")){
            linea = sc.nextLine();
            lineas.add(linea);
        }
        casoDePrueba(pasarLineasAMattriz(lineas));
    }
    private static int[][] pasarLineasAMattriz(ArrayList<String> lineas){
        int[][] matriz = new int[lineas.size()][4];

        for (int i = 0; i < matriz.length; i++) {

            String[] lineaSeparada = lineas.get(i).split(" ");

            for (int j = 0; j < 4; j++) {

                matriz[i][j] = Integer.parseInt(lineaSeparada[j]);

            }

        }

        return matriz;
    }
    private static void casoDePrueba(int[][] matriz){



    }
}
