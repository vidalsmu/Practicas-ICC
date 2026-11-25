# Práctica 9: Agregación, Clonación de Objetos y Guías de Envío
**Introducción a las Ciencias de la Computación (Semestre 2027-1)**  
**Facultad de Ciencias, UNAM**

---

## Descripción de la práctica y decisiones de diseño en los métodos y clases

Describe brevemente los atributos, constructores y métodos que decidiste diseñar para `Persona.java`, así como tu implementación de `Envio.java`:
>
---
En Persona 
Los atributos son identificadorCorto que es para el identificador corto y único, nombreUsuario que es para el nombre completo del usuario y ubicacionUsuario que es para el código postal de cada usuario.
Los constructores son Persona sin Parametros que solo le da datos predeterminados y persona con parametros que le da un ID-000 si el usuario no ingresa un ID, pone nombre "Sin nombre" y 00000 para el código postal.
Los métodos en getters y setters es solo para obtener y modificar los atributos, mismaUbicacionQue nos ayuda a determinar si una persona tiene la misma ubicación que otra, esLaMismaPersona sirve para saber si alguien es igual a otra persona con su identificador corto su ID, el ultimo es toString que nos da toda la informacion de la persona.

En Envio tenemos dos Personas que son el remitente y el destinatario y un Paquete para formar una guía con su propio folio automático, tambien un contador static que va contando cuantas guias llevamos 
Sus constructores validan los datos para evitar nulls y permiten crear una guia nueva o clonar una con otro paquete dandole un folio nuevo
Revisa si el envío es local o foraneo comparando ubicaciones para sacar el costo total, tiene toString para mostrar toda la información de la guía y cuenta con generarGuiaRetorno, que copia el paquete, le pone RET- al código de rastreo e invierte remitente y destinatario en una nueva guía o regresa null si no hay paquete

## Comandos para compilar, ejecutar y documentar

Ejecuta los siguientes comandos desde la terminal ubicado en la raíz de esta carpeta (`practica09/`):

### 1. Compilación
```bash
<javac -d bin src/*.java >
```

### 2. Ejecución de pruebas y simulación (`PruebaEnvio`)
```bash
<java -cp bin PruebaEnvio>
```

### 3. Ejecución del menú interactivo (`MenuPostal`)
```bash
<java -cp bin MenuPostal>
```

### 4. Generación de documentación Javadoc
```bash
<javadoc -d doc -author -version src/*.java>
```

---

## Evidencia de ejecución

### 1. Salida de `PruebaEnvio`
Copia y pega aquí la salida final que mostró tu terminal al ejecutar `PruebaEnvio`:

```text
RESUMEN DE PRUEBAS: 19 / 19 pruebas superadas con exito
```

### 2. Ejemplo de ejecución interactiva (`MenuPostal`)
Copia y pega aquí un ejemplo sencillo de interacción en terminal ejecutando `MenuPostal`:

```text
--- Captura de datos del REMITENTE ---
  Identificador corto: ID-017
  Nombre completo: Ximena Vidals
  Ubicacion (CP o ciudad): 01323

--- Captura de datos del DESTINATARIO ---
  Identificador corto: ID-017
  Nombre completo: Ximena Vidals
  Ubicacion (CP o ciudad): 01323

--- Captura de datos del Paquete ---
  Codigo de rastreo (ej. PKG-500): AKS-210
  Peso fisico en kg (ej. 3.5): 5.2
  Alto en cm (ej. 20): 12
  Ancho en cm (ej. 20): 31
  Largo en cm (ej. 30): 10
  Valor declarado en MXN (ej. 800): 532
  ¿Es envio express? (s/n): n

Guia emitida con exito:
Folio: GUIA-TOS-1
Tipo de ruta: LOCAL
Envio personal: Si
Costo total: 120.0
Remitente 
Identificador corto del usuario: ID-017
Nombre completo del usuario: Ximena Vidals
Ubicacion del usuario: 01323
Destinatario 
Identificador corto del usuario: ID-017
Nombre completo del usuario: Ximena Vidals
Ubicacion del usuario: 01323
Paquete 
Código rastreo: AKS-210
Peso: 1.0
Alto: 12.0
Ancho: 31.0
Largo: 10.0
Valor: 532.0
Envío Express: false

```

---

## Preguntas de reflexión 

1. **¿En qué se diferencia clonar un `Paquete` (`new Paquete(kitBase)`) de clonar una guía de `Envio` (`new Envio(guiaBase, nuevoPaquete)`) respecto a qué objetos se comparten y cuáles se duplican en memoria?**
   > Cuando clonamos Paquete se crea un nuevo paquete con los mismos datos pero son independientes ya que al cambiar uno no se cambia el otro, mientras que al clonar Envio se hace una guia con su propio folio, se utiliza las referencias de guia base y se toma el nuevo paquete pero no se duplica 

2. **Para generar el `folioGuia` con un número consecutivo global y consultar cuántas guías se han emitido en total, ¿qué modificador tuviste que utilizar en ese atributo y en su método de consulta? ¿Por qué no funcionaría si el contador fuera un atributo normal de instancia?**
   > Tuve que usar el modificador static tanto en el contador como en el método que consulta el total de guías emitidas
   Si fuera un atributo normal de instancia cada Envio tendría su propia copia independiente del contador y no se llevaría un conteo consecutivo ni el total de todas las guías creadas

3. **Si una guía `envio1` se descarta (`envio1 = null;`), ¿qué ocurre en memoria con los objetos `Persona` (remitente/destinatario) y `Paquete` que estaban asociados a ella?**
   > Al hacer envio1 = null esa guía ya no está referenciada y los objetos Persona y Paquete que tenía asociados solo se pueden eliminar en memoria si ninguna otra variable o guía los sigue usando
   Si otra guía o variable sí apunta a ellos siguen existiendo ahí
