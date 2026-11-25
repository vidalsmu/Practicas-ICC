# Práctica 9: Agregación, Clonación de Objetos y Guías de Envío
**Introducción a las Ciencias de la Computación (Semestre 2027-1)**  
**Facultad de Ciencias, UNAM**

---

## Descripción de la práctica y decisiones de diseño en los métodos y clases

Describe brevemente los atributos, constructores y métodos que decidiste diseñar para `Persona.java`, así como tu implementación de `Envio.java`:
>
---
Los atributos son identificadorCorto que es para el identificador corto y único, nombreUsuario que es para el nombre completo del usuario y ubicacionUsuario que es para el código postal de cada usuario.
Los constructores 
Los métodos 

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
  Ubicacion (CP o ciudad): 07650

--- Captura de datos del DESTINATARIO ---
  Identificador corto: ID-017
  Nombre completo: Ximena Vidals
  Ubicacion (CP o ciudad): 07650

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
Ubicacion del usuario: 07650
Destinatario 
Identificador corto del usuario: ID-017
Nombre completo del usuario: Ximena Vidals
Ubicacion del usuario: 07650
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
   > [Escribe aquí tu respuesta]

2. **Para generar el `folioGuia` con un número consecutivo global y consultar cuántas guías se han emitido en total, ¿qué modificador tuviste que utilizar en ese atributo y en su método de consulta? ¿Por qué no funcionaría si el contador fuera un atributo normal de instancia?**
   > [Escribe aquí tu respuesta]

3. **Si una guía `envio1` se descarta (`envio1 = null;`), ¿qué ocurre en memoria con los objetos `Persona` (remitente/destinatario) y `Paquete` que estaban asociados a ella?**
   > [Escribe aquí tu respuesta]
