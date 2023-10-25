/**
 * 
 */
/**
 * 
 */

import java.security.SecureRandom;
import java.util.Random;
import java.util.Scanner;

public class ProgramaAritmetico {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SecureRandom random = new SecureRandom();
        
        int nivelDificultad, tipoProblema, respuesta, respuestaCorrecta;
        int preguntasCorrectas = 0;
        int preguntasIncorrectas = 0;
        
        while (preguntasCorrectas < 10) {
            nivelDificultad = obtenerEntero(scanner, "Elige el nivel de dificultad (1, 2, 3, ...):");
            tipoProblema = obtenerEntero(scanner, "Elige el tipo de problema (1: suma, 2: resta, 3: multiplicación, 4: división, 5: mezcla):");
            
            int numero1 = random.nextInt((int)Math.pow(10, nivelDificultad));
            int numero2 = random.nextInt((int)Math.pow(10, nivelDificultad));
            
            if (tipoProblema == 5) {
                tipoProblema = random.nextInt(4) + 1; // Mezcla aleatoria
            }
            
            String operador = "+-*/".substring(tipoProblema - 1, tipoProblema);
            
            System.out.printf("¿Cuánto es %d %s %d? ", numero1, operador, numero2);
            respuestaCorrecta = calcularRespuesta();
            respuesta = obtenerEntero(scanner, "");
            
            if (respuesta == respuestaCorrecta) {
                System.out.println(obtenerMensajeAleatorio(true));
                preguntasCorrectas++;
            } else {
                System.out.println(obtenerMensajeAleatorio(false));
                preguntasIncorrectas++;
            }
        }
        
        double porcentajeCorrecto = 100.0 * preguntasCorrectas / (preguntasCorrectas + preguntasIncorrectas);
        System.out.println(porcentajeCorrecto < 75 ? "Por favor pide ayuda adicional a tu instructor." : "¡Felicidades, estás listo para pasar al siguiente nivel!");
    }
    
    public static int obtenerEntero(Scanner scanner, String mensaje) {
        System.out.print(mensaje);
        return scanner.nextInt();
    }
    
    public static int calcularRespuesta() {
    	>         return (int) (tipoProblema == 4 ? (double) num1 / num2 : evaluar (num1 + "*-+".charAt(tipoProblema - 1) + num2));
    }
    
    private static int evaluar(int i) {
		// TODO Auto-generated method stub
		return 0;
	}

	public static void evaluar(String expresion) {
       
    }
    
    public static String obtenerMensajeAleatorio(boolean exito) {
        String[] mensajes = exito ? new String[]{"¡Muy bien!", "¡Excelente!", "¡Buen trabajo!", "¡Sigue así!"} : new String[]{"No. Por favor intenta de nuevo.", "Incorrecto. Intenta una vez más.", "¡No te rindas!", "No. Sigue intentando."};
        return mensajes[new SecureRandom().nextInt(mensajes.length)];
    }
}