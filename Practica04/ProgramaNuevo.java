public class ProgramaNuevo{	
	public static void main(String[] args) {
	
	String producto = "Laptop para la carrera";
	// Precio en pesos mexicanos
	int precio = 15000;
	int descuento = 3000;
	double meses = 18.0;

    /*
	System.out.println("=== Ficha de compra ===");
	//Laptop para la carrera 
	System.out.println("- Producto : " + producto);	
	System.out.println("- Precio con descuento : " + (precio - descuento));
	System.out.println("- Plazo de pago en anios : " + (meses / 12.0));
	// Lo que se va a pagar cada mes 
	// Valor que daba 666.6666666
	System.out.printf("- Pago mensual : %.2f", ((precio - descuento) / meses));
	System.out.println("=== Fin de la ficha ===");
    */

    System.out.printf("=== Ficha de compra ===, -Producto: %s, -Precio con descuento: %d, -Plazo de pago en anios: %.1f, -Pago mensual: %.2f, ===Ficha de compra=== \n", producto, (precio - descuento), (meses / 12), (precio - descuento) / meses);

	}
}