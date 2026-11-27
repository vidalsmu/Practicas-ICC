/**
 * Modela una estacion meteorologica universitaria que almacena y procesa
 * las temperaturas diarias (en grados Celsius) de un periodo de monitoreo.
 *
 * @author Vidals Muñoz Ximena Guadalupe 
 * @version 1.1
 */
public class EstacionMeteorologica {

    // ATRIBUTOS 
    // POR HACER 
    String nombreEstacion;
    double [] temperaturas;


    // CONSTRUCTORES

    /**
     * Inicializa la estacion con el nombre predeterminado "Estacion UNAM"
     * y reserva espacio para una semana (7 dias), marcando cada posicion
     * inicialmente sin lectura registrada (-300.0).
     */
    public EstacionMeteorologica() {
        // POR HACER (1.1): Inicializa nombre, arreglo e inicializa todas las casillas con ciclo for.
        nombreEstacion = "Estacion UNAM";
        temperaturas = new double [7];
        for (int i = 0; i < temperaturas.length; i++) {
            temperaturas[i] = -300;
        }
    }

    // POR HACER (Parte 5.3): Redacta la documentacion Javadoc para este constructor y los metodos restantes.
    /**
     * Crea estación meteorologica, valida nombre y su numero de dias 
     * @param nombreEstacion es el nombre de la estación 
     * @param numDias es el numero de dias  
     */
    public EstacionMeteorologica(String nombreEstacion, int numDias) {
        // POR HACER (1.2): Valida nombreEstacion y numDias; crea el arreglo e inicializa sus casillas en -300.0.
        if (nombreEstacion == null || nombreEstacion.trim().isEmpty()) {
            this.nombreEstacion = "Estacion UNAM";
        } else {
            this.nombreEstacion = nombreEstacion;
        }

        if (numDias <= 0) {
            temperaturas = new double [7];
        } else {
            temperaturas = new double [numDias];
        }

        for (int i = 0; i < temperaturas.length; i++){
            temperaturas[i] = -300;
        }
    }

    // METODOS DE CONSULTA Y REGISTRO (PARTE 1)

    /**
     * @return regresa el nombre de la estacion 
     */
    public String getNombreEstacion() {
        return nombreEstacion;
    }
    /**
     * @return dias que se registra la temperatura
     */
    public int getNumeroDias() {
        // POR HACER (1.3)
        return temperaturas.length;
    }

    /**
     * Registra la temperatura de un dia especifico en grados Celsius.
     * Solo modifica el arreglo si el indice es valido y la temperatura esta
     * dentro del rango fisico ambiental [-90.0, 60.0].
     *
     * @param indiceDia Posicion del dia a registrar (desde 0 hasta N - 1).
     * @param temp Temperatura ambiental registrada en grados Celsius.
     * @return true si el dato fue valido y se almaceno; false en caso contrario.
     */
    public boolean registrarTemperatura(int indiceDia, double temp) {
        // POR HACER (1.4): Valida indiceDia y el rango fisico de temp.
        if (indiceDia >= 0 && temp >= -90.0 && temp <= 60.0 && indiceDia < temperaturas.length) {
            temperaturas [indiceDia] = temp; 
            return true;
        }
        return false;
    }

     /**
     * Temperatura almacenada en el dia indicado.
     * @param indiceDia dia a consultar
     * @return temperatura registrada o -300.0 
     */
    public double obtenerTemperatura(int indiceDia) {
        // POR HACER (1.5): Devuelve la lectura en indiceDia, o -300.0 si el indice es invalido.
        if (indiceDia >= 0 && indiceDia < temperaturas.length) { 
            return temperaturas[indiceDia]; 
        }
        return -300.0;
    }

    // METODOS ESTADISTICOS (PARTE 2)


    /**
     * @return promedio de las temperaturas 
     */
    public double calcularPromedio() {
        // POR HACER (2.1): Suma todas las temperaturas con un ciclo for y calcula el promedio.
        double suma = 0.0;
        for (int i = 0; i < temperaturas.length; i++) {
         suma += temperaturas[i];
        }
        return suma / temperaturas.length; 
    }

    /**
     * @return la temperatura maxima
     */
    public double obtenerMaxima() {
        // POR HACER (2.2): Recorre el arreglo y encuentra el valor maximo.
        double maxima = temperaturas[0];
        for (int i = 1; i < temperaturas.length; i++) {
            if (temperaturas[i] > maxima) { 
                maxima = temperaturas[i];
            }
        }
        return maxima;
    }

    /**
     * Cuenta los dias que superan el umbral 
     * @param umbral
     * @return cuantos dias superan umbral
     */
    public int contarDiasCalurosos(double umbral) {
        // POR HACER (2.3): Cuenta cuantos dias superan estrictamente 'umbral'.
        int contadorDias = 0;
        for (int i = 0; i < temperaturas.length; i++){
            if (temperaturas[i] > umbral) {
                contadorDias++;
            }
        }
        return contadorDias;
    }

    @Override
    public String toString() {
        // POR HACER (2.4): Formato exacto:
        // "Estacion: <nombreEstacion> | Dias: <N> | Promedio: <prom> C | Maxima: <max> C"
        return "Estacion: " + nombreEstacion
             + " | Dias: " + getNumeroDias()
             + " | Promedio: " + calcularPromedio() + " C"
             + " | Maxima: " + obtenerMaxima() + " C"; 
    }

    // CONVERSION DE ESCALAS (PARTE 3)


    /**
     * Pasa de grados Celsius a Farenheit 
     * @param celsius 
     * @return grados celsius convertidos a Fahrenheit 
     */
    public static double convertirAFahrenheit(double celsius) {
        // POR HACER (3.2): Decide si este metodo sera de instancia o static y realiza la conversion.
        return celsius * 1.8 + 32.0;
    }

    // POR HACER (3.3): Una vez creado Escala.java, descomenta y completa el metodo sobrecargado:
    /**
     * Calcula el promedio
     * @param escala 
     * @return promedio en grados Celsius o Farenheit
     */
    public double calcularPromedio(Escala escala) {
        double promedioCelsius = calcularPromedio();
        if (escala == Escala.FAHRENHEIT) {
            return convertirAFahrenheit(promedioCelsius);
        } 
        return promedioCelsius;
    }


    // RETOS (PARTE 4)

    /**
     * @return el primer día con heladas o -1 si no hubo 
     */
    public int buscarPrimerDiaHelada() {
        // POR HACER (4.1): Devuelve el indice del primer dia con temp <= 0.0, o -1 si no hubo heladas.
        for (int i = 0; i < temperaturas.length; i++) {
            if (temperaturas[i] <= 0.0) {
            return i;
          }
        }
        return -1;
    }

    public double mayorCambioConsecutivo() {
        // POR HACER (4.2): Calcula la mayor variacion |t[i+1] - t[i]| entre dias seguidos.
        if (temperaturas.length < 2) {
            return 0.0;
        }

        double mayorCambio = Math.abs(temperaturas[1] - temperaturas[0]);
        for (int i = 1; i < temperaturas.length -1 ; i++) {
            double cambioActual = Math.abs(temperaturas[i + 1] - temperaturas[i]);
            if (cambioActual > mayorCambio) {
                mayorCambio = cambioActual;
            }
        }
        return mayorCambio;
    }
}
