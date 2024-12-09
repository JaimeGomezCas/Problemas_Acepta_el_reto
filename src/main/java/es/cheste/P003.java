package es.cheste;

import java.util.Scanner;

public class P003 {
    static Scanner sc = new Scanner(System.in);
    static final String SALIDA = "FIN";

    public static void main(String[] args) {
        String mensaje = " ";

        while (!mensaje.equals(SALIDA)){

            mensaje = casoDePrueba();

        }
    }
    public static String casoDePrueba(){
        String mensajeCodificado = sc.nextLine();
        char primeraLetra = mensajeCodificado.charAt(0);
        int clave =  'p' - primeraLetra;
        String mensajeDecodificado = decodificarMensaje(clave, mensajeCodificado.toUpperCase());
        System.out.println(contadorVocales(mensajeDecodificado));

        if (Character.isUpperCase(mensajeCodificado.charAt(1)) && Character.isUpperCase(mensajeCodificado.charAt(2))) {
            Character.isUpperCase(mensajeCodificado.charAt(3));
        }
        return mensajeDecodificado.toLowerCase();

    }
    public static String decodificarMensaje(int clave, String mensajeCodificado){
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < mensajeCodificado.length(); i++) {
            char letra = mensajeCodificado.charAt(i);

            if(letra >= 65 && letra <= 90){
                int letraResultante = letra + clave;
                if(letraResultante > 90){
                    letraResultante -= 25;
                } else if (letraResultante < 65) {
                    letraResultante += 25;
                }
                char letraBuena = (char) letraResultante;
                sb.append(letraBuena);
            } else {
                sb.append(letra);
            }

        }
        return sb.toString();
    }
    public static int contadorVocales(String mensaje){
        int contador = 0;
        for (int i = 0; i < mensaje.length(); i++) {
            if(mensaje.charAt(i) == 'A' || mensaje.charAt(i) == 'E' || mensaje.charAt(i) == 'I' || mensaje.charAt(i) == 'O' || mensaje.charAt(i) == 'U'){
                contador++;
            }
        }
        return contador;
    }


}
