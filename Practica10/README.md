# Práctica 10 (Mini-Lab): Arreglos de Tipos Primitivos (`EstacionMeteorologica`)
**Introducción a las Ciencias de la Computación (Semestre 2027-1)**  
**Facultad de Ciencias, UNAM**

---

## Descripción de la práctica

Los ejericicios consisten en la clase EstacionMeteorologica para guardar y validar temperaturas diarias con -300.0 como valor null, sacar promedio, máxima, días calurosos e imprimir toda la información, convertir a Fahrenheit, detectar la primera helada y el mayor salto entre días seguidos
>

---

## Comandos para compilar, ejecutar y documentar

Ejecuta los siguientes comandos desde la terminal ubicado en la raíz de esta carpeta:

### 1. Compilación
```bash
<javac -d bin src/*.java>
```

### 2. Ejecución de las pruebas
```bash
<java -cp bin PruebaEstacionMeteorologica>
```

### 3. Generación de documentación Javadoc
```bash
<javadoc -d doc -author -version src/*.java>
```

---

## Evidencia de ejecución

Copia y pega aquí el resumen final de pruebas y la salida de tu prueba personalizada al ejecutar `PruebaEstacionMeteorologica`:

```text
================================================================================
  RESUMEN DE PRUEBAS: 22 / 22 pruebas superadas con exito.
================================================================================

>>> 5. PRUEBA PERSONALIZADA:
Estacion: Estacion Vidals | Dias: 5 | Promedio: 12.1 C | Maxima: 21.0 C
Promedio (°C): 12.1
Promedio (°F): 53.78

```

---

## Preguntas de reflexión (1.0 punto)

1. **En la Parte 3.2 definiste el método `convertirAFahrenheit(double celsius)`. ¿Lo implementaste como método de instancia o como método de clase (`static`)? Justifica tu decisión de diseño explicando qué ventajas o implicaciones tiene la opción que elegiste.**
   > Lo implemente como static porque es una operacion y no depende de los datos de un objeto en específico, la ventaja es que podemos usarlo sin tener que crear antes una instancia y no es exclusivo de un objeto 

2. **En el método `obtenerMaxima()`, ¿por qué es incorrecto inicializar la variable auxiliar del máximo en `0.0`? Explica qué problema concreto ocurre en estaciones donde todas las temperaturas son negativas y cómo lo resolviste.**
   > Es incorrecto inicializar con 0.0 porque no sabemos si es un valor que se encuentra en el arreglo y lo inicializamos con el primer valor del arreglo ya que tenemos la seguridad de que ese si se encuentre en el arreglo

3. **Sobre la Parte 4 (Retos) y el manejo de días sin lectura (`-300.0`): explica brevemente cómo diseñaste la lógica de alguno de los dos retos (o qué limitaciones tendría calcular el promedio de la Parte 2 si un usuario consulta el promedio cuando solo se han registrado algunos días del arreglo).**
   > Para el reto de buscar primer día helada el método consiste en recorrer temperaturas desde el primero con un ciclo for y viendo si las temperaturas son menores a 0, en cuanto se cumple la condición hago return i que es la temperatura
   Si termina el ciclo sin encontrar ninguna regreso -1
   Si un usuario consulta el promedio cuando solo se han registrado algunos días y el resto siguen en -300.0 no se podrá dar la información verdadera ya que los días de los que no hay datos se tomaran como -300 y no se tomara en cuenta solamente la información registrada 

---

## Comentarios adicionales sobre tu experiencia

Agrega aquí cualquier observación pertinente sobre el desarrollo de la práctica (por ejemplo: qué partes te costaron más trabajo, en dónde te atoraste o si algún caso específico no lograste resolver).
> Me costó mas trabajo pensar en una solución para calcular la temperatura máxima y en el ejercio de variación brusca entre días consecutivos porque necesita de más cosas para funcionar
