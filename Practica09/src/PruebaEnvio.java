/**
 * Programa de pruebas y simulacion para las Guias de Envios
 * Ejecuta pruebas automatizadas.
 * 
 * @author Ximena Vidals / 324207785
 * @version 1.1
 */
public class PruebaEnvio {

    /*
    * - Incluye las secciones guiadas para que agregues las pruebas de tu diseno
    *   de Persona (Parte 2), Envio y generacion de folios consecutivos (Parte 3),
    *   asi como la simulacion integral de envios, clones y devolucion (Parte 4).
    */

    private static int pruebasExitosas = 0;
    private static int totalPruebas = 0;

    /**
     * Metodo principal de verificacion y simulacion no interactiva.
     * 
     * @param args Argumentos de linea de comandos (no utilizados).
     */
    public static void main(String[] args) {
        System.out.println("================================================================================");
        System.out.println("  ICC 2027-1 | PRACTICA 9: AGREGACION, CLONACION Y GUIAS DE ENVIO");
        System.out.println("================================================================================\n");

        // ---------------------------------------------------------------------
        // PARTE 1: PAQUETES ESTANDARIZADOS (CONSTRUCTOR POR COPIA Y TOSTRING)
        // ---------------------------------------------------------------------
        System.out.println(">>> PARTE 1: REPRESENTACION TEXTUAL Y CLONACION DE PAQUETE");
        Paquete kitBase = new Paquete("KIT-101", 4.0, 20.0, 20.0, 20.0, 500.0, false);
        Paquete otroPaquete = new Paquete("PKG-202", 12.0, 40.0, 30.0, 30.0, 1500.0, false);

        String txtKit = kitBase.toString();
        verificar("Paquete.toString() incluye el codigo de rastreo",
                  txtKit != null && txtKit.contains("KIT-101") && !txtKit.contains("Paquete@"));

        Paquete kitClon = new Paquete(kitBase);
        double pesoOriginal = kitBase.getPeso();
        kitBase.setPeso(99.0);
        verificar("Constructor por copia de Paquete crea instancia independiente en memoria",
                  kitClon != kitBase && Math.abs(kitClon.getPeso() - pesoOriginal) < 1e-6);
        kitBase.setPeso(pesoOriginal);

        kitClon.setCodigoRastreo("KIT-102"); // Nuevo codigo para envio en serie
        verificar("Modificar el codigo del paquete clonado no altera el paquete plantilla original",
                  "KIT-101".equals(kitBase.getCodigoRastreo()) && "KIT-102".equals(kitClon.getCodigoRastreo()));

        Paquete clonNulo = new Paquete(null);
        verificar("Constructor por copia con null asigna valores predeterminados validos",
                  clonNulo.getCodigoRastreo() != null && clonNulo.getPeso() > 0.0);
        System.out.println();

        // ---------------------------------------------------------------------
        // PARTE 2: PRUEBAS DE TU DISENO DE LA CLASE PERSONA
        // ---------------------------------------------------------------------
        System.out.println(">>> PARTE 2: VERIFICACION DE LA CLASE PERSONA");
        // POR HACER (Parte 2):
        // Instancia al menos 3 objetos Persona con los constructores que disenaste:
        // - Dos personas en la misma ciudad/codigo postal (ej. personaX y personaY).
        // - Una persona en otra ciudad/codigo postal (ej. personaZ) y una copia con el mismo ID que personaX.
        // Agrega llamadas a verificar(...) para comprobar:
        // 1. Que mismaUbicacionQue(...) devuelve true entre personaX y personaY, y false con personaZ.
        // 2. Que esLaMismaPersona(...) devuelve true para el mismo identificador unico y false para distinto o null.
        // 3. Que toString() devuelve una cadena legible con sus datos.

        Persona personaX = new Persona("ID-009", "Gustavo Adrian Cerati Clark", "06700");
        Persona personaY = new Persona("ID-012", "Saul Alfonso Hernández Estrada", "06700");
        Persona personaZ = new Persona("ID-165", "Dipper Mason Pines", "04100");
        Persona copiaX = new Persona("ID-009", "Gustavo Adrian Cerati Clark", "06700");

        verificar("mismaUbicacionQue es true entre personaX y personaY",
                  personaX.mismaUbicacionQue(personaY));
        verificar("mismaUbicacionQue es false entre personaX y personaZ",
                  !personaX.mismaUbicacionQue(personaZ));
        verificar("esLaMismaPersona es true con mismo identificador",
                  personaX.esLaMismaPersona(copiaX));
        verificar("esLaMismaPersona es false con distinta persona o null",
                  !personaX.esLaMismaPersona(personaY) && !personaX.esLaMismaPersona(null));

        String textoPersona = personaX.toString();
        verificar("Persona.toString() contiene los datos principales",
                  textoPersona != null && textoPersona.contains("ID-009") && textoPersona.contains("Gustavo Adrian Cerati Clark"));
        System.out.println();

        // ---------------------------------------------------------------------
        // PARTE 3: PRUEBAS DE AGREGACION, FOLIOS CONSECUTIVOS Y OPERACIONES EN ENVIO
        // ---------------------------------------------------------------------
        System.out.println(">>> PARTE 3: VERIFICACION DE ENVIO Y FOLIOS AUTOMATICOS");
        // POR HACER (Parte 3):
        // 1. Verifica con tu metodo de consulta que al inicio se han emitido 0 guias.
        // 2. Crea una guia local (entre personaX y personaY con kitBase) y una foranea (hacia personaZ con kitClon).
        // 3. Verifica que ambas guias tienen folios no nulos, distintos y con numeracion consecutiva (1 y 2),
        //    y que el total de guias emitidas ahora es 2.
        // 4. Verifica esEnvioForaneo(), esAutoEnvio() y calcularCostoTotal() (confirmando el cargo foraneo).
        // 5. Verifica que cambiarDestinatario(...) rechaza null y acepta actualizar a otra persona (o a si misma).
        verificar("Al inicio se han emitido 0 guias",
                  Envio.obtenerTotalGuiasEmitidas() == 0);

        Envio guiaLocal = new Envio(personaX, personaY, kitBase);
        Envio guiaForanea = new Envio(personaX, personaZ, kitClon);

        verificar("Ambas guias tienen folios no nulos, distintos y consecutivos (1 y 2)",
                  guiaLocal.getFolioGuia() != null
                  && guiaForanea.getFolioGuia() != null
                  && !guiaLocal.getFolioGuia().equals(guiaForanea.getFolioGuia())
                  && guiaLocal.getFolioGuia().endsWith("-1")
                  && guiaForanea.getFolioGuia().endsWith("-2"));
        verificar("Total de guias emitidas es 2",
                  Envio.obtenerTotalGuiasEmitidas() == 2);

        verificar("esEnvioForaneo distingue guiaLocal (false) y guiaForanea (true)",
                  !guiaLocal.esEnvioForaneo() && guiaForanea.esEnvioForaneo());
        verificar("esAutoEnvio es false cuando remitente y destinatario son distintos",
                  !guiaLocal.esAutoEnvio());
        verificar("calcularCostoTotal aplica cargo foraneo en guiaForanea",
                  guiaForanea.calcularCostoTotal() > guiaLocal.calcularCostoTotal());

        verificar("cambiarDestinatario rechaza null y acepta nuevo destinatario",
                  !guiaLocal.cambiarDestinatario(null)
                  && guiaLocal.cambiarDestinatario(personaY));
        guiaLocal.cambiarDestinatario(personaY);
        System.out.println();

        // ---------------------------------------------------------------------
        // PARTE 4: SIMULACION INTEGRAL (CLONACION DE GUIA Y DEVOLUCION / RETORNO)
        // ---------------------------------------------------------------------
        System.out.println(">>> PARTE 4: SIMULACION DE ENVIOS, CLONACION DE GUIA Y RETORNO");
        // POR HACER (Parte 4):
        // Modela e imprime en consola el siguiente escenario completo:
        // a) Persona X envia 'kitBase' a Persona Y (imprime la guia generada).
        // b) Persona X necesita enviar un segundo paquete ('otroPaquete') a la misma Persona Y
        //    clonando la guia anterior; verifica que conserva remitente y destinatario
        //    pero tiene el nuevo paquete y un nuevo folio consecutivo.
        // c) Persona Y solicita devolver el primer paquete a Persona X generando una guia de retorno;
        //    verifica con verificar(...) que en la guia de retorno el remitente es Y, el destinatario es X,
        //    el paquete es una copia independiente con prefijo "RET-" y cuenta con un nuevo folio consecutivo.
        //    Imprime la guia de retorno y el total acumulado de guias emitidas en el sistema.
        Envio envio1 = new Envio(personaX, personaY, kitBase);
        System.out.println("Guia 1 (X -> Y con kitBase):\n" + envio1);

        Envio envio2 = new Envio(envio1, otroPaquete);
        System.out.println("\nGuia 2 (clonada de Guia 1 con otroPaquete):\n" + envio2);
        verificar("Guia 2 conserva remitente y destinatario, cambia paquete y aumenta folio",
                  envio2.getRemitente().esLaMismaPersona(personaX)
                  && envio2.getDestinatario().esLaMismaPersona(personaY)
                  && envio2.getPaquete().getCodigoRastreo().equals("PKG-202")
                  && !envio2.getFolioGuia().equals(envio1.getFolioGuia()));

        Paquete kitParaZ = new Paquete(kitBase);
        Envio envioZ = new Envio(personaX, personaZ, kitParaZ);
        System.out.println("\nGuia 3 (X -> Z en otra ciudad con kitBase clonado):\n" + envioZ);
        verificar("Guia 3 es foranea y usa copia independiente del kit",
                  envioZ.esEnvioForaneo()
                  && envioZ.getPaquete() != kitBase
                  && !envioZ.getFolioGuia().equals(envio2.getFolioGuia()));

        Envio guiaRetorno = envio1.generarGuiaRetorno();
        System.out.println("\nGuia de retorno (Y -> X):\n" + guiaRetorno);
        verificar("Guia de retorno invierte roles, agrega RET- y genera nuevo folio",
                  guiaRetorno != null
                  && guiaRetorno.getRemitente().esLaMismaPersona(personaY)
                  && guiaRetorno.getDestinatario().esLaMismaPersona(personaX)
                  && guiaRetorno.getPaquete() != envio1.getPaquete()
                  && guiaRetorno.getPaquete().getCodigoRastreo() != null
                  && guiaRetorno.getPaquete().getCodigoRastreo().startsWith("RET-")
                  && !guiaRetorno.getFolioGuia().equals(envio1.getFolioGuia()));

        System.out.println("\nTotal acumulado de guias emitidas: " + Envio.obtenerTotalGuiasEmitidas());

        System.out.println("\n================================================================================");
        System.out.println("  RESUMEN DE PRUEBAS: " + pruebasExitosas + " / " + totalPruebas + " pruebas superadas con exito");
        System.out.println("================================================================================");
    }

    /**
     * Evalua una condicion booleana e imprime [OK] o [FALLO].
     * 
     * @param nombrePrueba Descripcion breve del caso evaluado.
     * @param condicion Resultado booleano esperado (true si paso).
     */
    private static void verificar(String nombrePrueba, boolean condicion) {
        totalPruebas++;
        if (condicion) {
            pruebasExitosas++;
            System.out.println("  [OK]    " + nombrePrueba);
        } else {
            System.out.println("  [FALLO] " + nombrePrueba);
        }
    }
}
