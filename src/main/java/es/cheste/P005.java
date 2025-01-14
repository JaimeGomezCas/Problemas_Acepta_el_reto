package es.cheste;

import java.util.ArrayList;
import java.util.Scanner;

public class P005 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String linea = "";
        ArrayList<String> lineas = new ArrayList<>();
        while (!linea.equals("0 0 0 0")) {
            linea = sc.nextLine();
            lineas.add(linea);
        }

        casoDePrueba(pasarLineasAMattriz(lineas));
    }

    private static int[][] pasarLineasAMattriz(ArrayList<String> lineas) {
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

//    private static void imprimirMatriz(int[][] matriz) {
//        for (int[] ints : matriz) {
//            for (int j = 0; j < matriz[0].length; j++) {
//                System.out.print(ints[j] + " ");
//            }
//            System.out.println();
//        }
//    }

    private static void casoDePrueba(int[][] matriz) {
        //imprimirMatriz(matriz);
        ArrayList<int[]> lineas = new ArrayList<>();
        int contadorDeCeros = 1;

        for (int[] fila : matriz) {
            contadorDeCeros--;
            for (int j = 0; j < matriz[0].length; j++) {
                if (fila[j] == 0) {
                    contadorDeCeros++;
                }
            }
            lineas.add(fila);
            if (contadorDeCeros == 0) {
                resolverCaso(prepararMatriz(lineas));
                contadorDeCeros = 1;
            }
        }


    }

    private static int[][] prepararMatriz(ArrayList<int[]> lineas) {
        int[][] matriz = new int[lineas.size()][4];
        int temp = lineas.size();
        for (int i = 0; i < temp; i++) {
            matriz[temp - i - 1] = lineas.get(0);
            lineas.remove(0);
        }
        //System.out.println("-------");
        //imprimirMatriz(matriz);
        return matriz;
    }

    private static void resolverCaso(int[][] matriz) {
        boolean balanceado = Boolean.TRUE;
        for (int i = 0; i < matriz.length - 1; i++) {

            int totalFilaActual = matriz[i][0]  + matriz[i][2] ;
            if (matriz[i + 1][0] == 0) {
                matriz[i + 1][0] = totalFilaActual;
            } else if (matriz[i + 1][2] == 0) {
                matriz[i + 1][2] = totalFilaActual;
            } else {
                buscarPrimerCeroIzquierdo(totalFilaActual, matriz);
            }


        }

        for (int[] fila : matriz) {
            for (int j = 0; j < matriz[0].length; j++) {
                if (fila[0] * fila[1] != fila[2] * fila[3]) {
                    balanceado = false;
                    break;
                }
            }
        }
//        System.out.println("RESULTADO");
//        imprimirMatriz(matriz);

        if (balanceado) {
            System.out.println("SI");
        } else {
            System.out.println("NO");
        }
    }

    private static void buscarPrimerCeroIzquierdo(int total, int[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {

            if (matriz[matriz.length - 1 - i][2] == 0) {
                matriz[matriz.length - 1 - i][2] = total;
                break;
            }
        }
    }

}
