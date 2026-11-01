import java.util.Scanner;
public class CabanaDelMisterio {
	public static void main (String [] args){
	
  	Scanner entrada = new Scanner(System.in);

     //Datos sacados del problema 
        String nombreCliente;
        char tipoCliente;
        char estandar ='E';
        char preferente = 'P';
        char riesgoso = 'R';

        double tasaAnual;
        double precioLaptop;
        int mesesPago;
        

      System.out.print("Ingresa tu  nombre: ");
      nombreCliente = entrada.nextLine();

      //Verifica el tipo de cliente 
      System.out.print("Ingresa el tipo de cliente que eres: ");
      tipoCliente = entrada.next().charAt(0);
      while (tipoCliente != 'P' && tipoCliente != 'E' && tipoCliente != 'R') {
      System.out.println("El tipo de cliente es incorrecto, ingresa un tipo de cliente correcto");
      tipoCliente = entrada.next().charAt(0);
       }



      // Verifica el capital del prestamo (precio de la laptop)
      System.out.print("Ingresa el capital del prestamo (con ,): ");
      while (entrada.hasNextDouble() == false) {
        System.out.print("Por favor ingresa el capital de tu prestamo (con ,): ");
        entrada.next();
      }
      precioLaptop = entrada.nextDouble();
      while (precioLaptop < 0){
        System.out.print("Ingresa un número positivo: ");
      while (entrada.hasNextDouble() == false) {
        System.out.print("Por favor ingresa el capital de tu prestamo (con ,): ");
        entrada.next();
      }
        precioLaptop = entrada.nextDouble();
        }



      //Verifica tasa 
      System.out.print("Ingresa la tasa anual (con ,): ");
      while (entrada.hasNextDouble() == false) {
        System.out.print("Por favor ingresa la tasa anual: ");
        entrada.next();
      }
      tasaAnual = entrada.nextDouble();
        while (tasaAnual < 0){
        System.out.print("Ingresa un número positivo: ");
      //Verifica de nuevo que sea un número
      while (entrada.hasNextDouble() == false) {
        System.out.print("Por favor ingresa el capital de tu prestamo (con ,): ");
        entrada.next();
      }
        tasaAnual = entrada.nextDouble();
      }
        

      //Pedir y verificar plazo en meses 
      System.out.print("Ingresa los meses de pago: ");
      while (entrada.hasNextInt() == false) {
        System.out.print("Por favor ingresa los meses de pago: ");
        entrada.next();
      }
      mesesPago = entrada.nextInt();
        while (mesesPago < 0){
        System.out.print("Ingresa un número positivo: ");
      //Verifica de nuevo que sea un número
      while (entrada.hasNextInt() == false) {
        System.out.print("Por favor ingresa los meses de pago: ");
        entrada.next();
      }
        mesesPago = entrada.nextInt();
      }

      //Descuentos tipo de cliente
      if (tipoCliente == preferente) {
          tasaAnual = tasaAnual - 2 ;

          } else if (tipoCliente == estandar) {
           tasaAnual = tasaAnual;

          } else if (tipoCliente == riesgoso) {
          tasaAnual = tasaAnual + 3 ;
          }
         
        int intentosPermitidos = 0;
        int erroresMenu = 0;
        String motivoFin = "";


    // Cuenta intentos y errores permitidos
    while (intentosPermitidos < 5 && erroresMenu < 3) {
            
            System.out.println("##### Sistema de prestamos de la Cabaña del misterio #####");
            System.out.println("> Intentos Permitidos: " + intentosPermitidos + " de 5");
            System.out.println("> Errores en menú: " + erroresMenu + " de 3");
            System.out.println("> Las operaciones disponibles son: ");
            System.out.println("1) Cotizar con interes simple.");
            System.out.println("2) Cotizar con interes compuesto.");
            System.out.println("3) Comparar interes simple y compuesto.");
            System.out.println("4) Cambiar el capital del prestamo.");
            System.out.println("0) Salir.");
            System.out.println("> Por favor, elige una opción :");

            if (entrada.hasNextInt() == false) {  
                erroresMenu++; 
                System.out.println("Por favor ingresa una opción válida, llevas " + erroresMenu + " errores");
                entrada.next();
                if (erroresMenu >= 3) {
                    motivoFin = "Se alcanzó el límite de errores en el menú.";
                    break;
                }
                continue;
            }


            int opcionMenu = entrada.nextInt();

          double totalInteres = 0;
          double precioTotal = 0;
          double mensualidad = 0;
          double tasaMensual = 0;
          double saldoFinal = 0;
          double interesCompuesto = 0;
          double diferenciaIntereses = 0;

          if (opcionMenu == 0) {
                motivoFin = "Has salido del programa";
                break;
            }
            else if (opcionMenu < 1 || opcionMenu > 4) {
                erroresMenu++;
                System.out.println("Opción incorrecta, llevas " + erroresMenu + " errores");
                if (erroresMenu >= 3) {
                    motivoFin = "Se alcanzó el límite de errores en el menú.";
                    break; 
                }
            }
            else {



          switch (opcionMenu) {
            case 1: 
              System.out.println("#### Opción 1: Cotización de interés simple ####");
              System.out.println("- Nombre Cliente :" + nombreCliente);
              System.out.println("- Tipo de Cliente: " + tipoCliente);
              System.out.println("- Capital del prestamo: " + precioLaptop);
              System.out.println("- Tasa Anual: " + tasaAnual);
              System.out.println("- Plazo en meses: " + mesesPago);

              //Operaciones 
              //Interes simple
               totalInteres = precioLaptop * (tasaAnual / 100.0) * (mesesPago / 12.0); 
               System.out.printf("> Interés Simple: %.2f\n", totalInteres);
               //Total a pagar
               precioTotal = totalInteres + precioLaptop;
               System.out.printf(">Total a pagar : %.2f\n", precioTotal);
              
              break;

            case 2:
              System.out.println("### Opcion 2 : Cotizacion de interes compuesto ###");
              System.out.println("- Nombre Cliente :" + nombreCliente);
              System.out.println("- Tipo de Cliente: " + tipoCliente);
              System.out.println("- Capital del prestamo: " + precioLaptop);
              System.out.println("- Tasa Anual: " + tasaAnual);
              System.out.println("- Plazo en meses: " + mesesPago);

              //Operaciones
              totalInteres = precioLaptop * (tasaAnual / 100.0) * (mesesPago / 12.0); 
              precioTotal = totalInteres + precioLaptop;
              mensualidad = precioTotal / mesesPago; 
              tasaMensual = (tasaAnual / 100.0) / 12.0;
              
              //Tabla acumulada mes por mes con ciclo fo
              System.out.println("=== Tabla de Crecimiento del Saldo ===");
              double saldoAcumulado = 0.0;
              for (int mes = 1; mes <= mesesPago; mes++) {
              saldoAcumulado = saldoAcumulado + mensualidad;
              System.out.printf("> Mes" + " " + mes + " " + "= %.2f\n", saldoAcumulado);
               }
              
              //Total a pagar
              saldoFinal = precioLaptop * Math.pow((1 + tasaMensual), mesesPago);
              System.out.printf("> Total a pagar: %.2f\n", saldoFinal);

              //Interes compuesto
              interesCompuesto = saldoFinal - precioLaptop;
              System.out.printf("> Interes Compuesto: %.2f\n", interesCompuesto);
              break;

            case 3: 
              System.out.println("### Comparación de intereses ###");

              //Operaciones 
              totalInteres = precioLaptop * (tasaAnual / 100.0) * (mesesPago / 12.0); 
              precioTotal = totalInteres + precioLaptop;
              mensualidad = precioTotal / mesesPago; 
              tasaMensual = (tasaAnual / 100.0) / 12.0;

              saldoFinal = precioLaptop * Math.pow((1 + tasaMensual), mesesPago);
              interesCompuesto = saldoFinal - precioLaptop;
              diferenciaIntereses = Math.abs(totalInteres - interesCompuesto);

              System.out.printf("> Interés Simple: %.2f\n", totalInteres);
              System.out.printf("> Interés Compuesto: %.2f\n", interesCompuesto);
              System.out.printf("> La diferencia entre ellos es de %.2f\n", diferenciaIntereses);
              if (interesCompuesto > totalInteres){
                System.out.println("El interés compuesto es mayor");
              } else if (interesCompuesto < totalInteres) {
                System.out.println("El interés simple es mayor");
              } else {
                System.out.println("El interés simple y el interés compuesto son iguales");
              }
               break;

              case 4: 
              
              double nuevoCapital;

              //Cambiar capital
               System.out.print("Ingresa el nuevo capital: ");
              while (entrada.hasNextDouble() == false) {
              System.out.print("Por favor ingresa el nuevo capital: ");
              entrada.next();
              }
              nuevoCapital = entrada.nextDouble();
              while (nuevoCapital < 0){
              System.out.print("Ingresa un número positivo: ");
              while (entrada.hasNextDouble() == false) {
              System.out.print("Por favor ingresa el nuevo capital: ");
              entrada.next();
              }
              nuevoCapital = entrada.nextDouble();
              }

              precioLaptop = nuevoCapital;

              //Operaciones
              totalInteres = precioLaptop * (tasaAnual / 100.0) * (mesesPago / 12.0); 
              precioTotal = totalInteres + precioLaptop;
              mensualidad = precioTotal / mesesPago; 
              tasaMensual = (tasaAnual / 100.0) / 12.0;
              saldoFinal = precioLaptop * Math.pow((1 + tasaMensual), mesesPago);
              interesCompuesto = saldoFinal - precioLaptop;
              diferenciaIntereses = Math.abs(totalInteres - interesCompuesto);


              System.out.printf("> Interés Simple: %.2f\n", totalInteres);
              System.out.printf("> Total con Interés Simple: %.2f\n", precioTotal);
              System.out.printf("> Interes Compuesto: %.2f\n", interesCompuesto);
              System.out.printf("> Total con Interés Compuesto: %.2f\n", interesCompuesto, precioLaptop );
              System.out.printf("> Diferencia: %.2f\n", diferenciaIntereses);
              break;

           
            }


          intentosPermitidos++;
                if (intentosPermitidos == 5) {
                    motivoFin = "Has realizado 5 operaciones, programa finalizado";
                    break; 
                }
            }
        }    

        System.out.println("       ### Resumen final ###     ");
        System.out.println("- Nombre del cliente: " + nombreCliente);
        System.out.println("- Número de intentos permitidos: " + intentosPermitidos);
        System.out.println("- Número de errores cen el menú: " + erroresMenu);
        System.out.printf("- Capital final del préstamo: %.2f\n", precioLaptop);
        System.out.println("- Motivo por el que finalizó la sesión: " + motivoFin);

        }
      }
        /*   


        Código de la práctica pasada en el que me base para hacer este


         //Operaciones
         double totalInteres = precioLaptop * (tasaAnual / 100.0) * (mesesPago / 12.0); 
         double precioTotal = totalInteres + precioLaptop;
         double mensualidad = precioTotal / mesesPago; 
         double tasaMensual = (tasaAnual / 100.0) / 12.0;


        System.out.println("===Prestamos Cabaña del Misterio===");
        System.out.println("Cliente: " + nombreCliente);
        System.out.println("Clasificación cliente: " + tipoCliente);
        System.out.printf("Total a pagar de intereses (Interes Simple): %.2f\n", totalInteres);

        //Es lo que se pagará entre los intereses y el precio de la laptop
        System.out.printf("Total a pagar: %.2f\n", precioTotal);
        System.out.printf("Las mensualidades serán de: %.2f\n", mensualidad);
        System.out.println("Prestamo: $" + precioLaptop);
        System.out.println("Tasa Aplicada: " + tasaAnual);
        System.out.println("Meses de pago: " + mesesPago);


        //Tabla acumulada mes por mes con ciclo for
        System.out.println("=== Tabla de Crecimiento del Saldo ===");

        double saldoAcumulado = 0.0;
        for (int mes = 1; mes <= mesesPago; mes++) {
        saldoAcumulado = saldoAcumulado + mensualidad;
        System.out.printf("En el mes" + " " + mes + " " + "se tiene un saldo de: %.2f\n", saldoAcumulado);
        }
        System.out.printf("Saldo Acumulado final (Total con Interes Simple): %.2f\n", saldoAcumulado);
        
        double saldoFinal = precioLaptop * Math.pow((1 + tasaMensual), mesesPago);
        System.out.printf("Saldo Final(Total con Interes Compuesto): %.2f\n", saldoFinal);

        double interesCompuesto = saldoFinal - precioLaptop;
        System.out.printf("Interes Compuesto: %.2f\n", interesCompuesto); */

        
   
     

