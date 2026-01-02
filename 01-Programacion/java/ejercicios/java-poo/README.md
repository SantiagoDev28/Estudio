# Conociendo Java

En este primer ejercicio lo que realice fue una clase llamada main que imprime un Hola mundo sencillo 
y utilice la clase Scanner que me permite capturar datos desde la consola para luego imprimirlos, estos datos capturados pueden ser 
de cualquier tipo.

[Ejercicio #1](../java-poo/src/estudio/personal/Main.java)

# Primera Clase en Java.

En este ejercicio numero dos, orientado a realizar un mini proyecto de peliculas cree la clase Pelicula con sus respectivos atributos y metodos. 

[Ejercicio #2](../java-poo/src/estudio/personal/contenido/Pelicula.java)

Creamos una segunda clase llamada usuario, con atributos minimos y un metodo llamado ver, el cual nos permita ver la pelicula que se le pasa por parametro.

[Ejercicio #3](../java-poo/src/estudio/personal/plataforma/Usuario.java)

Estas clases fueron instanciadas en la clase main para poder realizar las acciones que se solicitan en el ejercicio.

[Codigo fuente](../java-poo/src/estudio/personal/Main.java)

# Segunda Clase en Java.

En Java, los métodos estáticos son aquellos que pertenecen a la clase y no a una instancia específica (objeto). Esto significa que pueden ser utilizados sin necesidad de crear un objeto de la clase, ya que existe una única copia del método compartida por todas las instancias. 

En esta ocasión creé un nuevo paquete de utilidades que contiene una clase con métodos estáticos basados en Scanner. Estos métodos permiten recibir los datos ingresados por el usuario desde la consola sin necesidad de instanciar la clase, ya que se accede a ellos directamente mediante los métodos estáticos.

[Ejercicio #4](../java-poo/src/estudio/personal/util/ScannerUtils.java)

En el codigo fuente se puede observar como se utiliza la clase ScannerUtils para capturar los datos del usuario y luego imprimirlos en pantalla.

[Codigo fuente](../java-poo/src/estudio/personal/Main.java#L21)

# Tercera Clase en Java.

En esta ocasion le agregamos a nuetra clase pelicula un metodo constructor que nos permite inicializar los atributos de nuestra clase.
[Ejemplo](../java-poo/src/estudio/personal/contenido/Pelicula.java#L16)

# Cuarta Clase en Java.

## Ciclo de vida de los objetos en Java.
En Java existen principalmente dos áreas de memoria: Stack y Heap.
El Stack almacena las variables de tipo primitivo y las referencias a objetos que pertenecen al contexto de ejecución de los métodos.
El Heap almacena los objetos creados dinámicamente en memoria.

En el siguiente ejemplo ponemos en practica el uso de estos espacios de memoria.
[Ejercicio #5](../java-poo/src/estudio/personal/MainStackHeap.java)

## Encapsulamiento en Java.

El encapsulamiento se refiere a ocultar y proteger los detalles de una clase para que solo se puedan acceder de manera mas controlada.
Esto nos permite mayor seguridad, un codigo mantenible y limpio.

Existen dos tipos de metodos muy importantes para este proceso de encapsulamiento: Getters y Setters.

Los getters nos sirvens para obtener informacion y los setters nos sirven para modificarla.

Con los get al obtener informacion no deberiamos de tener problemas pero con los set si, ya que estos son los que nos permiten modificar los datos, por lo tanto
debemos de ser mas cuidadosos

[Ejemplos de uso](../java-poo/src/estudio/personal/contenido/Pelicula.java)

## Listas en Java.

Las listas en java nos permiten almacenar una coleccion de elementos en una estructura de datos dinamica.
Estas listas pueden ser de tipo primitivo o de objetos.

[Ejemplo](../java-poo/src/estudio/personal/plataforma/Plataforma.java)  