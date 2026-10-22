public class Programa{	
	public static void main(String[] args) {
	
	String producto = "Laptop para la carrera";
	// Precio en pesos mexicanos
	int precio = 15000;
	int descuento = 3000;
	double meses = 18.0;

	System.out.println("=== Ficha de compra ===");
	//Laptop para la carrera 
	System.out.println("- Producto : " + producto);	
	System.out.println("- Precio con descuento : " + (precio - descuento));
	System.out.println("- Plazo de pago en anios : " + (meses / 12.0));
	// Lo que se va a pagar cada mes 
	System.out.println("- Pago mensual : " + ((precio - descuento) / meses));
	System.out.println("=== Fin de la ficha ===");

	}
}