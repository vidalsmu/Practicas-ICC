 public class CotizadorPines {
    public static void main (String [] args) {

        //Datos sacados del problema 
        String nombreCliente1 = "Robbie Valentino";
        int precioLaptop = 12899;
        int mesesPago = 21;
        char estandar = 'E';
        char preferente = 'P';
        char riesgoso = 'R';
        double tasaAnual = 15;
        char tipoCliente = 'E';

          //Condición, si los valores iniciales son 0 o negativos el programa no se va a ejecutar 
          if (precioLaptop <= 0) {
          System.out.println("El precio de la laptop es 0 o negativo, las operaciones no se pueden realizar"); 
          
          } else if (mesesPago <= 0) {
           System.out.println("Los meses de pago son incorrectos, las operaciones no se pueden realizar"); 

            //Verifica si el tipo de cliente es correcto
            } else if (tipoCliente != estandar && tipoCliente != preferente && tipoCliente != riesgoso) {
          System.out.println("El tipo de cliente es incorrecto, las operaciones no se pueden realizar");
           
            } else {     

           if (tipoCliente == preferente) {
          tasaAnual = tasaAnual - 2 ;

          } else if (tipoCliente == estandar) {
           tasaAnual = tasaAnual;

          } else if (tipoCliente == riesgoso) {
          tasaAnual = tasaAnual + 3 ;
          }
         
         //Operaciones
         double totalInteres = precioLaptop * (tasaAnual / 100.0) * (mesesPago / 12.0); 
         double precioTotal = totalInteres + precioLaptop;
         double mensualidad = precioTotal / mesesPago; 
         double tasaMensual = (tasaAnual / 100.0) / 12.0;


        System.out.println("===Prestamos Cabaña del Misterio===");
        System.out.println("Cliente: " + nombreCliente1);
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
        System.out.printf("Interes Compuesto: %.2f\n", interesCompuesto);

        }
        } 
     }
