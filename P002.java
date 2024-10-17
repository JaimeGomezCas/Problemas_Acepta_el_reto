package es.cheste;

public class P002 {
    static java.util.Scanner in;
    public static int CM;
    public static int CM2;
    public static  int RANGO_MAXIMO;

    public static void casoDePrueba(int num) {
        RANGO_MAXIMO = num * num;
        CM = 0;
        CM2 = 0;
        int[][] cuadrado = crearMatriz(num);
        int[][] cuadradoTraspuesto = trasponerMatriz(cuadrado);
        boolean esDiabolico = comprobarMagia(cuadrado, cuadradoTraspuesto);
        if(esDiabolico){
            if(comprobarEsotereidad(cuadrado)){
                System.out.println("ESOTERICO");
            } else {
                System.out.println("DIABOLICO");
            }
        } else{
            System.out.println("NO");
        }

    }
    private static int[][] crearMatriz(int num){
        int[][] cuadrado = new int[num][num];

        for (int i = 0; i < num; i++) {
            for (int j = 0; j < num; j++) {
                cuadrado[i][j] = in.nextInt();

            }
        }
        return cuadrado;
    }
    private static int[][] trasponerMatriz(int[][] matriz){
        int[][] cuadradoTraspuesto = new int[matriz.length][matriz.length];

        for (int i = 0; i <matriz.length ; i++) {
            CM += matriz[0][i];
            for (int j = 0; j < matriz.length; j++) {
                cuadradoTraspuesto[j][i] = matriz[i][j];
            }
        }
        return cuadradoTraspuesto;

    }
    private static boolean comprobarMagia(int[][] cuadrado, int[][] cuadradoTraspuesto){




        int diagonal1 = 0;
        int diagonal2 = 0;

        int sum1, sum2;
        for (int i = 0; i < cuadrado.length; i++) {
            sum1 = 0;
            sum2 = 0;
            for (int j = 0; j < cuadrado.length; j++) {
                sum1 += cuadrado[i][j];
                sum2 += cuadradoTraspuesto[i][j];
            }
            if(sum2 != CM || sum1 != CM){
                return false;
            }
            diagonal1 += cuadrado[i][i];
            diagonal2 += cuadrado[cuadrado.length - 1 - i][i];

        }
        return diagonal1 == CM && diagonal2 == CM;

    }
    private static boolean comprobarEsotereidad(int[][] cuadrado){
        CM2 = (4 * CM) / cuadrado.length;

        for (int i = 0; i < cuadrado.length; i++) {
            for (int j = 0; j < cuadrado.length; j++) {
                if(cuadrado[i][j] > RANGO_MAXIMO){
                    return false;
                }
            }
        }
        if(cuadrado[0][0] + cuadrado[0][cuadrado.length - 1] + cuadrado[cuadrado.length -1][0] + cuadrado[cuadrado.length -1][cuadrado.length -1] != CM2){
            return false;
        }
        boolean esEsoterico = Boolean.TRUE;

        if(cuadrado.length % 2 == 0){

            int mitadMas = cuadrado.length / 2;
            int mitadMenos = cuadrado.length / 2  - 1;
            if(cuadrado[mitadMas][mitadMas] + cuadrado[mitadMas][mitadMenos] + cuadrado[mitadMenos][mitadMas] + cuadrado[mitadMenos][mitadMenos] != CM2){
                esEsoterico = false;
            } else if (cuadrado[mitadMas][0] + cuadrado[mitadMas][cuadrado.length -1] + cuadrado[mitadMenos][0] + cuadrado[mitadMenos][cuadrado.length - 1] + cuadrado[0][mitadMas] + cuadrado[0][mitadMenos] + cuadrado[cuadrado.length - 1][mitadMas] + cuadrado[cuadrado.length - 1][mitadMenos] != (CM2 * 2)) {
                esEsoterico = false;
            }

        } else {

            int mitad = cuadrado.length / 2;
            if(cuadrado[mitad][mitad] * 4 != CM2){
                esEsoterico = false;
            } else if(cuadrado[mitad][mitad] + cuadrado[mitad][mitad] + cuadrado[mitad][mitad] + cuadrado[mitad][mitad] != CM2){
                esEsoterico = false;
            }


        }
        return esEsoterico;
    }
    public static void main(String[] args) {


        in = new java.util.Scanner(System.in);

        int num = in.nextInt();
        while (num != 0){
            casoDePrueba(num);
            num = in.nextInt();

        }

    }
}
