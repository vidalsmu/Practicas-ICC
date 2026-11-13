# Práctica 8 (Mini-Lab): La Clase Punto
**Introducción a las Ciencias de la Computación (Semestre 2027-1)**  
**Facultad de Ciencias, UNAM**

---


## Descripción de la práctica

Se creó la clase Punto, se crearon constructores para iniciar posiciones, métodos get y set para modificar datos, funciones para desplazar puntos, calcular distancias y hallar puntos medios, también se puede saber en que parametro de una recta se ubica un punto, expresar correctamente sus coordenadas, compararlo con otros usando una tolerancia para decimales y comprobar si tres puntos están alineados en una misma línea recta.
>
---

## Comandos para compilar, ejecutar y documentar

Ejecuta los siguientes comandos desde la terminal ubicado en la raíz de esta carpeta:

### 1. Compilación
```bash
javac -d bin src /*. java
```

### 2. Ejecución de la verificación
```bash
java - cp bin PruebaPunto
```

### 3. Generación de documentación Javadoc
```bash
javadoc -d doc -author -version src/Punto.java 
```

---

## Evidencia de ejecución

Copia y pega aquí el resumen final que mostró tu terminal al ejecutar `PruebaPunto`:

```text
  RESUMEN DE PRUEBAS: 21 / 21 pruebas superadas con exito.
  ¡FELICIDADES! Todos los metodos de la clase Punto funcionan correctamente.
```

---

## Preguntas de reflexión (1.0 punto)

1. **¿Por qué el método `puntoMedio` crea y regresa un nuevo objeto `Punto`, mientras que `desplazar` modifica al mismo objeto que recibe el mensaje?**
   > Porque en punto medio estamos usando new para crear otro objeto pero en dezplazar lo modifica porque le estamos asignando un nuevo valor.

2. **Al ejecutar `p1.distancia(p2)`, ¿a qué objeto en memoria hace referencia `this` y cómo accede el método a las coordenadas de `p2`?**
   > this hace referencia a al objeto p1 que fue creado con nuevo punto y el método accede a las coordenadas de p2 a través del parámetro que recibe entre paréntesis usando otroPunto.x y otroPunto.y .

3. **Observa el archivo `PruebaPunto.java`: ¿por qué los atributos `pruebasExitosas`, `totalPruebas` y el método `verificar` están declarados como `static`? ¿Qué ocurriría si les quitáramos la palabra `static` y los llamáramos desde `main`? Menciona además dos métodos estáticos de las bibliotecas estándar de Java que utilizaste en `Punto.java`.**
   > Porque pertenecen a la clase y no a un objeto individual, permitiendo que el método main los invoque sin necesidad de crear un objeto nuevo.
   Un error de compilación ya que main no puede hacer referencia a elementos no estáticos sin haber creado un objeto.
   Use Math.sqrt() y Math.pow()
