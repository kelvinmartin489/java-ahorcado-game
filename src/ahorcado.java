import java.util.Scanner;

public class ahorcado {
    public static void main(String[] args) throws Exception {
       
        Scanner scanner = new Scanner(System.in);

        String palabraSecreta = "mouse";
        int intentosMax = 10;
        int intentos = 0;
        boolean acertar = false;

        char[] letrasAdivinadas = new char[palabraSecreta.length()];

        for (int i = 0; i < letrasAdivinadas.length; i++) {
            letrasAdivinadas[i] = '_';
        }

        // Instrucciones del juego

        // Win 
        while (!acertar && intentos < intentosMax) {
            
            System.out.println("Palabra a adivinar: "+ String.valueOf(letrasAdivinadas) + " (" + palabraSecreta.length() + " letras)");

            System.out.println("Introduce una letra, por favor");

            char letra =  Character.toLowerCase(scanner.next().charAt(0));
            boolean letracorrecta = false;


            // Mecanismo del juego 
            for (int i = 0; i < palabraSecreta.length(); i++) {
                if (palabraSecreta.charAt(i) == letra) {
                    letrasAdivinadas[i] = letra;
                    letracorrecta = true;
                }
            }

            //validacion de instrucciones 
            if (!letracorrecta) {
                intentos++;
                System.out.println("Incorrecto te quedan "+(intentosMax - intentos) + " intentos." );
            }

            if(String.valueOf(letrasAdivinadas).equals(palabraSecreta)){
                acertar = true;
                System.out.println("Adivinastes la palabra secreta: "+palabraSecreta);
            }
        }

        // lose
        if (!acertar) {
            System.out.println("No pudiste acertar por malo");
        }

        scanner.close();

    }
}
