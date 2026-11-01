import java.util.Scanner;
public class BinarioInteractivo {
	public static void main (String [] args){

		Scanner entrada = new Scanner(System.in);

		char seguirPrograma;
        
        //Programa ejecutado al menos una vez
		do {
		int numero;
		String binario = "" ;


        //Scanner para pedir número al usuario 
		System.out.print("Ingresa el número que quieres transformar a binario: ");


		while (entrada.hasNextInt() == false) {
        	System.out.print("Lo que ingresaste es diferente a un número entero positivo, ingresa un número valido: ");
        	entrada.next();
        }

            if (entrada.hasNextInt()) {
            numero = entrada.nextInt();

             
            //Repetir si el numero no es positivo 
            while (numero < 0) {
                System.out.print("Lo que ingresaste es un número negativo, ingresa un número valido: ");

                //Repetir si se volvió a ingresar algo diferente a un número
                while (entrada.hasNextInt() == false) {
                    System.out.print("Lo que ingresaste es diferente a un número entero positivo, ingresa un número valido: ");
                    entrada.next();
                }

                numero = entrada.nextInt();

               }

	
			     //Condición para que ingrese un número válido
		         if (numero > 0) {
				int numeroInicial = numero;
				while (numero > 0) {

				 int residuo = numero % 2 ;
				 binario = residuo + binario;
				 numero = numero / 2;
				  }

				 System.out.println("Tu número es: " + numeroInicial);
				 System.out.println("Tu número en binario es: " + binario);
			      }

			      //Condición para el 0
			      else if (numero == 0){
			      	System.out.println("Tu número es: " + numero);
				    System.out.println("Tu número en binario es: " + numero);
			      }
          
          //Condición si el lo ingresado no es un número
		 } else {
			System.out.println("Lo que ingresaste es distinto a un número entero positivo, ingresa un número valido");
		}
	  

	        System.out.print("Presiona S o s si deseas convertir otro número, si quieres salir presiona cualquier otra cosa: ");
            seguirPrograma = entrada.next().charAt(0);
      }
      // Para saber si se debe o no seguir ejecutando
	  while (seguirPrograma == 'S' || seguirPrograma == 's');

	  System.out.println("Programa finalizado :D");
 
	}
}
