public class Cotizador {
	public static void main (String [] args) {
		
		//Datos sacados del problema 
		String nombreCliente1 = "Robbie Valentino";
		int precioLaptop = 12899;
		int mesesPago = 21;
		char estandar = 'E';
		char preferente = 'P';
		char riesgoso = 'R';

		//Operaciones 
		double tasaAnual = 15;
		double totalInteres = precioLaptop * (tasaAnual / 100) * (mesesPago / 12.0); 
		double precioTotal = totalInteres + precioLaptop;
		double mensualidad = precioTotal / mesesPago;

		
        System.out.println("===Prestamos Cabaña del Misterio===");
		System.out.println("Cliente: " + nombreCliente1);
		System.out.println("Clasificación cliente: " + estandar);
		System.out.printf("Total a pagar de intereses: %.2f\n", totalInteres);
		//Es lo que se pagará entre los intereses y el precio de la laptop
		System.out.printf("Total a pagar: %.2f\n", precioTotal);
		System.out.printf("Las mensualidades serán de: %.2f\n", mensualidad);




	}
}
