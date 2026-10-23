public class PrecisionPi {
	public static void main (String [] args){

		double tolerancia = 0.001;
		int dardosDentro = 0;
		int dardosLanzados = 0;

		double error =	1.0;
		double valorPi = 0.0;

		while (error >= tolerancia){
			
			double coordenadaX = Math.random();
            double coordenadaY = Math.random();
    
            if ((coordenadaX * coordenadaX) + (coordenadaY * coordenadaY) <= 1) {
    	    dardosDentro = dardosDentro + 1;
        }
        dardosLanzados = dardosLanzados + 1;
		
		valorPi = 4.0 * ((double) dardosDentro/dardosLanzados);
		error = Math.abs(valorPi - Math.PI);
	}

		System.out.println("=== Precisión del valor de Pi ===");
		System.out.println("Tolerancia: " + " " + tolerancia);
		System.out.println("Dardos necesarios" + " " + dardosLanzados);
		System.out.println("Dardos dentro" + " " + dardosDentro);
		System.out.printf("Valor de Pi: %.6f\n", valorPi);
		System.out.printf("Error de la estimación: %.6f\n", error);



	}
}