package es.cheste;

import java.util.Arrays;

public class P001 {
    static java.util.Scanner in;
    static final int K_KAPREKAR = 6174;
    public static void casoDePrueba() {
        int numBase = in.nextInt();
        in.nextLine();
        if(numBase % 1111 != 0) {

            int contador = 0;
            int numAscendente;
            int numDescendente;

            while (numBase != K_KAPREKAR) {

                numAscendente = convertirAAscendenteODescendente(numBase, true);
                numDescendente = convertirAAscendenteODescendente(numBase, false);
                numBase = numDescendente - numAscendente;
                contador++;

            }

            System.out.println(contador);

        } else {

            System.out.println(8);

        }
        

    }
    public static int convertirAAscendenteODescendente(int numeroBase, boolean esAscendente){

        StringBuilder cadenaNumero = new StringBuilder(String.valueOf(numeroBase));
        while(cadenaNumero.length() < 4){

            cadenaNumero.append("0");

        }
        char[] numerosSeparados = cadenaNumero.toString().toCharArray();

        Arrays.sort(numerosSeparados);
        String cadenaOrdenada = new String(numerosSeparados);

        if(!esAscendente){

            StringBuilder sb = new StringBuilder(cadenaOrdenada);
            sb.reverse();
            return Integer.parseInt(sb.toString());

        }

        return Integer.parseInt(cadenaOrdenada);
        
    }

    public static void main(String[] args) {

        in = new java.util.Scanner(System.in);

        int numCasos = in.nextInt();
        for (int i = 0; i < numCasos; i++)
            casoDePrueba();
    }
}
