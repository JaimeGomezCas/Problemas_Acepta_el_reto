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
        lineas.remove(lineas.size() - 1);
        int[][] matriz = new int[lineas.size()][4];

        for (int i = 0; i < matriz.length; i++) {

            String[] lineaSeparada = lineas.get(i).split(" ");

            for (int j = 0; j < 4; j++) {

                matriz[i][j] = Integer.parseInt(lineaSeparada[j]);

            }

        }

        return matriz;
    }
    private static void imprimirMatriz(int[][] matriz){
        for (int[] ints : matriz) {
            for (int j = 0; j < matriz[0].length; j++) {
                System.out.print(ints[j] + " ");
            }
            System.out.println();
        }
    }
    private static void casoDePrueba(int[][] matriz){
        imprimirMatriz(matriz);
        ArrayList<int[]> lineas = new ArrayList<>();
        int contadorDeCeros = 1;

        for (int i = 0; i < matriz.length; i++) {
            contadorDeCeros--;
            for (int j = 0; j < matriz[0].length; j++) {
                if(matriz[i][j] == 0){
                    contadorDeCeros ++;
                }
            }
            lineas.add(matriz[i]);
            if(contadorDeCeros == 0){
                resolverCaso();
                contadorDeCeros = 1;
            }
        }


    }
    private static int[][] prepararMatriz(ArrayList<int[]> lineas){
        int[][] matriz = new int[lineas.size()][4];
        for (int i = 0; i < lineas.size(); i++) {
            matriz[i] = lineas.get(0);
            lineas.remove(0);
        }
        return matriz;
    }
    private static void resolverCaso(int[][] matriz){

    }

}
