public class EstimacionPi {
	public static void main (String []args){

    int dardos = 1000000;
    int dardosDentro = 0;
    
    int dardosLanzados = 0;
    
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
    

	}

}