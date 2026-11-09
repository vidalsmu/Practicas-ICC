/**
 * Programa de prueba para verificar el correcto funcionamiento de las clases
 * {@link Paquete} y {@link CotizadorEnvio}.
 * 
 * @author Ximena Vidals 
 * @version 1.0
 */
public class PruebaPaqueteria {

    public static void main(String[] args) {
        System.out.println("======================================================");
        System.out.println("  PRUEBAS DEL SISTEMA DE ENVIOS POSTALES (PRACTICA 7) ");
        System.out.println("======================================================\n");

        // ---------------------------------------------------------------------
        // CASO 1: Paquete estandar pequeno (peso fisico domina)
        // Datos requeridos: codigo "PK-001", peso 3.5 kg, dimensiones 20x15x10 cm,
        // valor declarado $800.0 pesos.
        // ---------------------------------------------------------------------
        System.out.println("--- Caso 1: Paquete pequeno estandar ---");
        Paquete p1 = new Paquete("PK-001", 3.5, 20.0, 15.0, 10.0, 800.0, false, false);
        mostrarDetallePaquete(p1);
        System.out.println("Es valido?: " + CotizadorEnvio.esPaqueteValido(p1));
        System.out.printf("Costo de envio cotizado: $%.2f (Esperado: $120.00)\n", CotizadorEnvio.cotizarEnvio(p1));
        System.out.println("Requiere seguro?: " + CotizadorEnvio.requiereSeguro(p1));
        System.out.println();

        // ---------------------------------------------------------------------
        // CASO 2: Paquete liviano pero voluminoso (peso volumetrico domina)
        // Datos requeridos: codigo "PK-002", peso 2.0 kg, dimensiones 50x40x50 cm,
        // valor declarado $1500.0 pesos.
        // ---------------------------------------------------------------------
        System.out.println("--- Caso 2: Paquete voluminoso (volumen predomina) ---");
        // POR HACER: Instancia el objeto p2 con los datos indicados arriba
        Paquete p2 = new Paquete("PK-002", 2.0, 50.0, 40.0, 50.0, 1500.0, false, false);
        mostrarDetallePaquete(p2);
        if (CotizadorEnvio.esPaqueteValido(p2)) {
            System.out.printf("Peso volumetrico calculado: %.2f kg\n", p2.calculaPesoVolumetrico());
            System.out.printf("Peso cobrable final: %.2f kg\n", p2.obtienePesoCobrable());
        }
        System.out.printf("Costo de envio cotizado: $%.2f (Esperado: $425.00)\n", CotizadorEnvio.cotizarEnvio(p2));
        System.out.println("Requiere seguro?: " + CotizadorEnvio.requiereSeguro(p2));
        System.out.println();

        // ---------------------------------------------------------------------
        // CASO 3: Paquete de alto valor comercial (requiere seguro por monto)
        // Datos requeridos: codigo "PK-003", peso 4.0 kg, dimensiones 30x25x20 cm,
        // valor declarado $6500.0 pesos.
        // ---------------------------------------------------------------------
        System.out.println("--- Caso 3: Paquete de alto valor monetario ---");
        // POR HACER: Instancia el objeto p3 con los datos indicados arriba
        Paquete p3 = new Paquete("PK-003", 4.0, 20.0, 25.0, 30.0, 6500.0, false, false);
        mostrarDetallePaquete(p3);
        System.out.printf("Costo de envio: $%.2f\n", CotizadorEnvio.cotizarEnvio(p3));
        System.out.println("Requiere seguro?: " + CotizadorEnvio.requiereSeguro(p3) + " (Esperado: true)");
        System.out.println();

        // ---------------------------------------------------------------------
        // CASO 4: Paquete sobredimensionado (arista > 60 cm o suma > 150 cm)
        // Datos requeridos: codigo "PK-004", peso 5.0 kg, dimensiones 70x30x20 cm,
        // valor declarado $1200.0 pesos.
        // ---------------------------------------------------------------------
        System.out.println("--- Caso 4: Paquete sobredimensionado ---");
        // POR HACER: Instancia el objeto p4 con los datos indicados arriba
        Paquete p4 = new Paquete("PK-004", 5.0, 70.0, 30.0, 20.0, 1200.0, false, false);
        mostrarDetallePaquete(p4);
        System.out.println("Requiere seguro?: " + CotizadorEnvio.requiereSeguro(p4) + " (Esperado: true por dimensiones)");
        System.out.println();

        // ---------------------------------------------------------------------
        // CASO 5: Validacion de referencia nula (null)
        // ---------------------------------------------------------------------
        System.out.println("--- Caso 5: Validacion de referencia nula (null) ---");
        Paquete pNulo = null;
        System.out.println("Es valido un paquete null?: " + CotizadorEnvio.esPaqueteValido(pNulo) + " (Esperado: false)");
        System.out.printf("Cotizacion de un paquete null: $%.2f (Esperado: -1.00)\n", CotizadorEnvio.cotizarEnvio(pNulo));
        System.out.println("Requiere seguro un paquete null?: " + CotizadorEnvio.requiereSeguro(pNulo) + " (Esperado: false)");
        System.out.println();

        // =====================================================================
        // CASO 6: PRUEBAS DE TU METODO PERSONAL (PARTE 2)
        // =====================================================================
        System.out.println("======================================================");
        System.out.println("        PRUEBAS DE TU PROPUESTA PERSONAL              ");
        System.out.println("======================================================");
        // POR HACER: Instancia los paquetes necesarios y llama a tu metodo personal
        // propuesto en la Parte 2
        // Imprime en consola los datos y resultados para evidenciar su funcionamiento.
        Paquete p5 = new Paquete("PK-005", 2.0, 15.0, 15.0, 15.0, 50.0, true, false);
        mostrarDetallePaquete(p5);
        System.out.println("El paquete es fragil?: " + p5.isFragil());
        System.out.printf("Precio extra por paquete frágil: $%.2f\n", p5.calculaCostoFragil());
        Paquete p6 = new Paquete("PK-006", 3.0, 20.0, 20.0, 20.0, 50.0, false, true);
        mostrarDetallePaquete(p6);
        System.out.println("El destino es local?: " + p6.isLocal());
        System.out.printf("Descuento por ser local: $%.2f\n", p6.calculaDescuentoLocal());
        System.out.println();

    }

    /**
     * Metodo auxiliar para imprimir en consola los datos basicos de un paquete.
     * Utiliza los metodos de acceso (getters) implementados en la clase Paquete.
     * 
     * @param p Paquete a imprimir.
     */
    private static void mostrarDetallePaquete(Paquete p) {
        if (!CotizadorEnvio.esPaqueteValido(p)) {
            System.out.println("  [Paquete no valido o no instanciado]");
            return;
        }
        // POR HACER: Imprime en consola la informacion basica del paquete (codigo, dimensiones, peso)
        System.out.println(" -> Código: " + p.getCodigoRastreo());
        System.out.println("Peso: " + p.getPeso() + " kg");
        System.out.println("Dimensiones(alto, ancho y largo): " + p.getAlto() + " " + p.getAncho() + " " + p.getLargo() + " (todo en centímetros)");
    }
}
