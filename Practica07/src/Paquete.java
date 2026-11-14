/**
 * Clase que modela un paquete para una empresa de envios postales y paqueteria.
 * Permite registrar sus dimensiones espaciales, peso fisico y valor declarado,
 * asi como calcular su peso volumetrico y determinar el peso cobrable final.
 * 
 * @author Ximena Vidals
 * @version 1.0
 */
public class Paquete {

    // *** ATRIBUTOS ***
    // POR HACER: Declara los atributos necesarios de acuerdo a tu diseno y a la documentacion.
    // Recuerda aplicar el principio de encapsulamiento (declararlos privados).

    /** Codigo de rastro del paquete (Pueden ser numeros o letras)*/
    private String codigoRastreo;
    /** Peso del paquete (No puede ser cero o un numero negativo)*/
    private double peso;
    /** Alto del paquete (No puede ser cero o un numero negativo)*/
    private double alto;
    /** Ancho del paquete (No puede ser cero o un numero negativo)*/
    private double ancho;
    /** Largo del paquete (No puede ser cero o un numero negativo)*/
    private double largo;
    /** Valor Monetario de su contenido (No puede ser cero o un numero negativo) */
    private double valorMonetario; 

    // Atributos para propuesta de diseño personal 
    /** Es o no un paquete fragil (Solo puede ser verdadero o falso) */
    private boolean fragil;
    /** El destino de envío es o no un destino local (Solo puede ser verdadero o falso) */
    private boolean local;
    /** Costo Inicial del paquete antes de aplicar descuento por envío local o aumentar por paquete fragil */
    private double costoInicial;
 
    // *** CONSTRUCTORES ***
    // POR HACER: Agrega el constructor por defecto y el constructor con parametros.
    // En el constructor con parametros, asegura que el paquete cuente con dimensiones validas.
public Paquete() {
    codigoRastreo = "PAQUETE001";
    peso = 1.0;
    alto = 10.0;
    ancho = 10.0;
    largo = 10.0;
    valorMonetario = 0.0;
    fragil = false;
    local = false;
    costoInicial = 50;
}


    
    /**
     * Constructor con parámetros.
     * Crea una partida con los datos indicados. Si algun dato no es
     * valido, se corrige con un valor seguro.
     * @param codigo Codigo de rastreo del paquete.
     * @param peso Peso del paquete (peso > 0).
     * @param alto Alto del paquete (alto > 0).
     * @param ancho Ancho del paquete (ancho > 0).
     * @param largo Largo del paquete (largo > 0).
     * @param valor Valor monetario del paquete (valor >= 0).
     * @param fragil El paquete es o no fragil. 
     * @param local El destino del paquete es o no un destino local.
     */

public Paquete(String codigo, double peso, double alto, double ancho, double largo, double valor, boolean fragil, boolean local) {
    codigoRastreo = codigo;

//para comprobar que el peso sea un número válido
if (peso > 0) {
        this.peso = peso;
    } else {
        this.peso = 1.0;
    }

    if (alto > 0 && ancho > 0 && largo > 0){
        this.alto = alto;
        this.ancho = ancho;
        this.largo = largo;
    } else {
        this.alto = 10.0;
        this.ancho = 10.0;
        this.largo = 10.0;
    }

    if (valor >= 0) {
        valorMonetario = valor;
    } else {
        valorMonetario = 0.0;
    }

    this.fragil = fragil;
    this.local = local;
    costoInicial = 50.0;
}



    // *** METODOS DE ACCESO Y ASIGNACION ***
    // POR HACER: Agrega los metodos de consulta (getters) y de modificacion (setters) necesarios.

/**
 * Devuelve el código de rastreo
 * @return codigo de rastreo
 */
public String getCodigoRastreo() {
    return codigoRastreo;
}
public void setCodigoRastreo(String codigo){
    this.codigoRastreo = codigo;
}

/**
 * Devuelve el peso del paquete
 * @return peso del paquete 
 */
public double getPeso() {
    return peso;
}
/**
 * Cambia el peso del paquete solo si no es negativo.
 * @param nuevoPeso Nuevos puntos de la partida.
 */
public void setPeso(double nuevoPeso){
    if (nuevoPeso > 0) {
        peso = nuevoPeso;
    } else {
        System.out.println("Error el peso debe ser mayor a 0");
    }
}

/**
 * Devuelve el alto del paquete
 * @return alto del paquete 
 */
public double getAlto (){
    return alto;
}
/** 
 * Cambia el alto del paquete solo si es positivo
 * @param nuevoAlto
 */
public void setAlto(double nuevoAlto) {
    if (nuevoAlto > 0) {
        alto = nuevoAlto;
    } else {
        System.out.println("Error, el alto debe ser mayor a 0");
    }
}

/**
 * Devuelve el ancho del paquete  
 * @return ancho del paquete
 */
public double getAncho () {
    return ancho;
}
/**
 * Cambia el ancho solo si es mayor a 0 
 * @param nuevoAncho
 */
public void setAncho(double nuevoAncho){
    if (nuevoAncho > 0) {
        ancho = nuevoAncho;
    } else {
        System.out.println("Error, el ancho debe ser mayor a 0");
    }
}

/**
 * Devuelve el largo del paquete 
 *  @return largo del paquete
 */
public double getLargo () {
    return largo;
}
/**
 * Cambia el largo del paquete solo si es positivo 
 * @param nuevoLargo
 */
public void setLargo(double nuevoLargo){
    if (nuevoLargo > 0){
        largo = nuevoLargo;
    } else {
        System.out.println("Error, el largo debe ser mayor a 0");
    }
}

/**
 * Devuelve el valor monetario del paquete 
 * @return valor monetario del paquete
 */
public double getValorMonetario() {
    return valorMonetario;
}
/**
 * Cambia el valor del paquete solo si es igual o mayor que cero 
 * @param nuevoValor
 */
public void setValorMonetario (double nuevoValor){
    if (nuevoValor >= 0) {
        valorMonetario = nuevoValor;
    } else {
        System.out.println("Error, el valor monetario debe ser igual o mayor que 0");
    }
}

/**
 * Devuelve si el paquete es o no frágil
 * @return fragil 
 */
public boolean isFragil() {
    return fragil;
}
/**
 * Da true o false dependiendo de si el paquete es o no fragil
 * @param fragil
 */
public void setFragil(boolean fragil){
    this.fragil = fragil;
}

/**
 * Devuelve local si el destino del paquete es local
 * @return local
 */
public boolean isLocal() {
    return local;
}
/**
 * Da true o false dependiendo del paquete es o no local
 * @param local
 */
public void setLocal(boolean local){
    this.local = local;
}




// *** METODOS CALCULADORES BASE ***

    /**
     * Calcula el peso volumetrico del paquete segun el estandar comercial (IATA):
     * (largo * ancho * alto) / 5000.
     * 
     * @return El peso volumetrico equivalente en kilogramos.
     */

private boolean validaDatos() {
    if (peso <= 0 || alto <= 0 || ancho <= 0 || largo <= 0) {
            System.out.println("Error, no se pueden realizar calculos con valores negativos");
    return false;
 } return true;
}

public double calculaPesoVolumetrico() {
        if (!validaDatos()) {
        return 0.0;
    }
    double pesoVolumetrico = (largo * ancho * alto) / 5000;
    return pesoVolumetrico; 
    }

    /**
     * Determina el peso cobrable final para efectos de tarificacion postal,
     * el cual corresponde al valor maximo entre el peso fisico y el volumetrico.
     * 
     * @return El mayor entre el peso real y el peso volumetrico.
     */

    public double obtienePesoCobrable() {
        // POR HACER: Implementa la comparacion entre peso real y peso volumetrico
        if (!validaDatos()){
        return 0.0;
    }
    double pesoVolumetrico = calculaPesoVolumetrico();
    if (peso > pesoVolumetrico) {
        return peso;
    } else {
        return pesoVolumetrico;
    }
    }


    // *** PROPUESTA PERSONAL ***
    // POR HACER: Agrega aqui al menos un nuevo metodo calculador util para la empresa
    // (ejemplo: recargo por envio express, costo por material fragil, descuento local, etc.)
    // Incluye sus comentarios Javadoc y los atributos necesarios.

/**
 * Indica un aumento en el costo total si el paquete es fragil
 * 
 * @return Costo adicional si el paquete es fragil.
 */

public double calculaCostoFragil() {
    if (fragil){
        return 20.0;
    } else {
        return 0.0;
    }
}

/**
 * Indica un descuento si el destino del paquete es local
 * 
 * @return Descuento si el destino es local
 */

public double calculaDescuentoLocal () {
    if (local) {
        return costoInicial * 0.10;
    } else {
        return 0.0;
    }
}

public String toString() {
    return "Paquete Código: " + codigoRastreo + " Peso: " + peso + " Alto: " + alto + " Largo: " + largo + " Valor Monetario: " + valorMonetario + " Fragil: " + fragil + " Local " + local;
}
}
