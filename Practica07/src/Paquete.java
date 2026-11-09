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

    private String codigoRastreo;
    private double peso;
    private double alto;
    private double ancho;
    private double largo;
    private double valorMonetario; 

    // Parámetros para propuesta de diseño personal 
    private boolean fragil;
    private boolean local;
    private double costoInicial;
 
    // *** CONSTRUCTORES ***
    // POR HACER: Agrega el constructor por defecto y el constructor con parametros.
    // En el constructor con parametros, asegura que el paquete cuente con dimensiones validas.
public Paquete() {
    codigoRastreo = "PAQUETE0001";
    peso = 1.0;
    alto = 10.0;
    ancho = 10.0;
    largo = 10.0;
    valorMonetario = 0.0;
}

    //constructores con parametros
public Paquete(String pCodigo, double pPeso, double pAlto, double pAncho, double pLargo, double pValor, boolean pFragil, boolean pLocal) {
    codigoRastreo = pCodigo;

//para comprobar que el peso sea un número válido
if (pPeso > 0) {
        peso = pPeso;
    } else {
        peso = 1.0;
    }

    if (pAlto > 0 && pAncho > 0 && pLargo > 0){
        alto = pAlto;
        ancho = pAncho;
        largo = pLargo;
    } else {
        alto = 10.0;
        ancho = 10.0;
        largo = 10.0;
    }

    if (pValor >= 0) {
        valorMonetario = pValor;
    } else {
        valorMonetario = 0.0;
    }

    fragil = pFragil;
    local = pLocal;
    costoInicial = 50.0;
}

    // *** METODOS DE ACCESO Y ASIGNACION ***
    // POR HACER: Agrega los metodos de consulta (getters) y de modificacion (setters) necesarios.
public String getCodigoRastreo() {
    return codigoRastreo;
}

public void setCodigoRastreo(String codigo){
    this.codigoRastreo = codigo;
}

public double getPeso() {
    return peso;
}
public void setPeso(double peso){
    if (peso > 0) {
        this.peso = peso;
    } else {
        System.out.println("Error el peso debe ser mayor a 0");
    }
}

public double getAlto (){
    return alto;
}

public void setAlto(double alto) {
    if (alto > 0) {
        this.alto = alto;
    } else {
        System.out.println("Error, el alto debe ser mayor a 0");
    }
}

public double getAncho () {
    return ancho;
}
public void setAncho(double ancho){
    if (ancho > 0) {
        this.ancho = ancho;
    } else {
        System.out.println("Error, el ancho debe ser mayor a 0");
    }
}

public double getLargo () {
    return largo;
}
public void setLargo(double largo){
    if (largo > 0){
        this.largo = largo;
    } else {
        System.out.println("Error, el largo debe ser mayor a 0");
    }
}

public double getValorMonetario() {
    return valorMonetario;
}
public void setValorMonetario (double valor){
    if (valor >= 0) {
        this.valorMonetario = valor;
    } else {
        System.out.println("Error, el valor monetario debe ser igual o mayor que 0");
    }
}

public boolean isFragil() {
    return fragil;
}
public void setFragil(boolean fragil){
    this.fragil = fragil;
}

public boolean isLocal() {
    return local;
}
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
}
