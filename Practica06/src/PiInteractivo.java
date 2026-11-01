import java.util.Scanner;

public class PiInteractivo {
	public static void main (String []args){

        Scanner entrada = new Scanner(System.in); 

    int dardos = 0;
    int dardosDentro = 0;
    int dardosLanzados = 0;

        // Escaner que pide numero de datos al usuario
        System.out.print("Escribe el numero de dardos que quieres lanzar: ");
        if (entrada.hasNextInt() ) {
            dardos = entrada.nextInt();
        
        // Condicion para que solo funcione con numeros positivos 
         if (dardos > 0) {

         while (dardosLanzados < dardos) {

    	//Coordenadas aleatorias de cada dardo
        double coordenadaX = Math.random();
        double coordenadaY = Math.random();
    
           if ((coordenadaX * coordenadaX) + (coordenadaY * coordenadaY) <= 1) {
    	   dardosDentro = dardosDentro + 1;
          }
             dardosLanzados = dardosLanzados + 1;
         }
    

        //Estimación del valor de Pi
        double valorPi = 4.0 * ((double) dardosDentro / dardosLanzados);

        System.out.println("==== Estimación del valor de Pi ====");
        System.out.println("Dardos que queremos lanzar: " + " " + dardos);
        System.out.println("Dardos que cayeron dentro: " + " " + dardosDentro);
        System.out.println("Valor estimado de Pi: " + " " + valorPi);
        
         //Mensaje si el número es negativo o 0
        } else {
            System.out.println("La cantidad de dardos que ingresaste es 0 o negativo");
        }
    
      //Mensaje si no se ingresa un número
     } else {
            System.out.println("La cantidad de dardos que quieres lanzar no es válida, ingresa otro número");
           }

	}
}

