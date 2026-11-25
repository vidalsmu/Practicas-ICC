/**
 * Representa a una persona registrada en el sistema postal, la cual puede actuar
 * como remitente o como destinatario dentro de una guia de envio.
 *  * 
 * @author Ximena Vidals / 324207785
 * @version 1.1
 */
public class Persona {


    // 1. ATRIBUTOS

    /*
     PARTE 2 (DISENO ABIERTO):
     Define los atributos privados, constructores, getters/setters y metodos necesarios
     para modelar a una persona considerando al menos:
     - Un identificador corto unico
     - Nombre completo.
     - Ubicacion (ciudad, alcaldia o codigo postal) para distinguir envios locales de foraneos.
     */

    // POR HACER: Declara los atributos que consideres necesarios
    // para representar a la persona (identificador unico, nombre, ubicacion, etc.).

    /** Identificador corto ficticio para el usuario */
    private String identificadorCorto;

    /** Nombre completo del usuario*/
    private String nombreUsuario;

    /** Ubicación del usuario */
    private String ubicacionUsuario; 



    // 2. CONSTRUCTORES 

    // POR HACER: Implementa al menos un constructor por omision y un constructor
    // con parametros (aplicando validaciones basicas para evitar cadenas nulas o vacias).

    /** Crea una persona con información y datos predeterminados */

    public Persona () {
        this.identificadorCorto = "ID-707";
        this.nombreUsuario = "Alexander David Turner";
        this.ubicacionUsuario = "08721";
    }

    /** 
     * Crea una persona con parametros especificos 
     * @param identificadorCorto Identificador unico para un usuario
     * @param nombreUsuario Nombre completo del usuario
     * @param ubicacionUsuario Codigo postal del usuario   
     */
    public Persona(String identificadorCorto, String nombreUsuario, String ubicacionUsuario) {
        if (identificadorCorto != null && !identificadorCorto.equals("")){
        this.identificadorCorto = identificadorCorto;
        } else {
            this.identificadorCorto = "ID-000";
        }

        if (nombreUsuario != null && !nombreUsuario.equals("")){
        this.nombreUsuario = nombreUsuario;
        } else {
            this.nombreUsuario = "Sin nombre de usuario";
        }
        if (ubicacionUsuario != null && !ubicacionUsuario.equals("")){
        this.ubicacionUsuario = ubicacionUsuario;
        } else {
            this.ubicacionUsuario = "00000";
        }
        
    }


    // 3. GETTERS, SETTERS Y COLABORACION 

    // POR HACER: Implementa los getters y setters necesarios para tus atributos.
    /** @return nombre de usuario */
    public String getNombreUsuario() {
        return nombreUsuario;
    }
    /** @param nombreUsuario El nuevo nombre completo del usuario */
    public void setNombreUsuario(String nombreUsuario) {
        if (nombreUsuario != null && !nombreUsuario.equals("")) {
            this.nombreUsuario = nombreUsuario;
        }
    }

    /** @return identificador corto del usuario */
    public String getIdentificadorCorto() {
        return identificadorCorto;
    }
    /** @param identificadorCorto Nuevo identificador del usuario */
    public void setIdentificadorCorto(String idenficadorCorto) {
        if (identificadorCorto != null && !identificadorCorto.equals("")) {
            this.identificadorCorto = identificadorCorto;
        }
    }

    /** @return ubicacion del usuario */
    public String getUbicacionUsuario() {
        return ubicacionUsuario;
    }
    /** @param ubicacionUsuario Nueva ubicacion del usuario */
    public void setUbicacionUsuario(String ubicacionUsuario) {
        if (ubicacionUsuario != null && !ubicacionUsuario.equals("")) {
            this.ubicacionUsuario = ubicacionUsuario;
        }
    }    

    /**
     * Determina si esta persona se encuentra en la misma ubicacion (ciudad o codigo postal)
     * que otra persona recibida como parametro, para saber si un envio entre ambas
     * es local o foraneo.
     * 
     * @param otra La otra persona con quien comparar la ubicacion.
     * @return true si otra no es null y ambas comparten la misma ubicacion; false en caso contrario.
     */
    public boolean mismaUbicacionQue(Persona otra) {
        // POR HACER: Compara la ubicacion de this contra la de 'otra' 
        if (otra == null) {
        return false;
        }
        if (this.ubicacionUsuario == null) {
        return false;
        }
        return this.ubicacionUsuario.equals(otra.ubicacionUsuario);
        }


    /**
     * Determina si este objeto Persona y el recibido como parametro representan
     * a la misma persona comparando su identificador unico.
     * 
     * @param otra La otra persona a comparar.
     * @return true si otra no es null y ambas tienen el mismo identificador; false en caso contrario.
     */
    public boolean esLaMismaPersona(Persona otra) {
        // POR HACER: Verifica que otra != null y compara el identificador unico.
        if (otra == null) {
            return false;
        }
        if (this.identificadorCorto == null) {
            return false;
        }
        return this.identificadorCorto.equals(otra.identificadorCorto);
    }


    // 4. REPRESENTACION TEXTUAL

    /**
     * Devuelve una representacion legible de la persona con sus datos principales.
     * 
     * @return Cadena con el identificador, nombre y ubicacion de la persona.
     */
    public String toString() {
        // POR HACER: Sobrescribe toString() con el formato de tu preferencia.
        return "Identificador corto del usuario: " + identificadorCorto + "\n"
             + "Nombre completo del usuario: " + nombreUsuario + "\n"
             + "Ubicacion del usuario: " + ubicacionUsuario ;
    }
}
