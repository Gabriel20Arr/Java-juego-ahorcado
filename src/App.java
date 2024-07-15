import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        // Proyecto Ahorcado
        // clase scanner que nos permite que el usuario escriba
        Scanner scanner = new Scanner(System.in);

        // Asiganaciones de las variables
        String palabraSecreta = "messi";        
        int intentosMaximos = 6;
        int intentos = 0;
        boolean palabraAdivinada = false;

        //Arreglo
        char[] letrasAdivinadas = new char[palabraSecreta.length()];

        for (int i = 0; i < letrasAdivinadas.length; i++) {
            letrasAdivinadas[i] = '_';
            // System.out.print(letrasAdivinadas[i]);
        }

        while (!palabraAdivinada && intentos < intentosMaximos) {
            System.out.println("Palabra a adivinar: " + String.valueOf(letrasAdivinadas) + "(" + palabraSecreta.length() + ")");
            
            System.out.println("Intruduce una letra, por favor");

            char letra = Character.toLowerCase(scanner.next().charAt(0));

            boolean letraCorrecta = false;

            for (int i = 0; i < palabraSecreta.length(); i++) {
                if(palabraSecreta.charAt(i) == letra){
                    letrasAdivinadas[i] = letra;
                    letraCorrecta = true;                    
                }
            }

            if(!letraCorrecta){
                intentos++;
                System.out.println("Letra incorrecta! Te quedan: " + (intentosMaximos - intentos) + " intentos");
            }

            if(String.valueOf(letrasAdivinadas).equals(palabraSecreta)){
                palabraAdivinada = true;
                System.out.println("Felicidades adivinaste la palabra!!");
            }
        }    
        
        if(!palabraAdivinada){
            System.out.println("Haz perdido el juego. intentos: " + (intentosMaximos - intentos));
        }
        scanner.close();
    } 
}
