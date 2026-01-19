# Conociendo Java

En este primer ejercicio lo que realice fue una clase llamada main que imprime un Hola mundo sencillo 
y utilice la clase Scanner que me permite capturar datos desde la consola para luego imprimirlos, estos datos capturados pueden ser 
de cualquier tipo.

[Ejercicio #1](../java-poo/src/estudio/personal/Main.java)

# Primera Clase en Java.

En este ejercicio numero dos, orientado a realizar un mini proyecto de peliculas cree la clase Pelicula con sus respectivos atributos y metodos. 

[Ejercicio #2](../java-poo/src/estudio/personal/contenido/Pelicula.java)

Creamos una segunda clase llamada usuario, con atributos minimos y un metodo llamado ver, el cual nos permita ver la contenido que se le pasa por parametro.

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

En esta ocasion le agregamos a nuetra clase contenido un metodo constructor que nos permite inicializar los atributos de nuestra clase.
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

Busqueda y eliminacion en listas, mas filtros y ordenamientos con lambda y streams: 

[Ejemplo](../java-poo/src/estudio/personal/plataforma/Plataforma.java#L23-L45)

# Quinta clase en Java.

## Relaciones entre clases.

Asociacion: Dos clases se conocen, pero no dependen una de la otra. Son independientes pero pueden trabajar juntas.

Agregacion: Siguen siendo clases independientes pero con un poco mas de relacion, una clase contiene a la otra como atributo, pero no la controla por completo.
Se puede eliminar sin que la clase princial se vea afectada.

Composicion: Una clase, crea, posee y controla a otra clase dentro de su propia estructura.

## Flujos de control.

Estos flujos de control nos permiten llevar a cabo una accion dependiendo de una condicion.
En el siguiente ejemplo con el flujo de control switch:
[Ejemplo](../java-poo/src/estudio/personal/Main.java#32)

A partir de esta clase se reescribio todo el contenido del archivo main principal para dejar todo lo aprendido en un solo proyecto entendible y bien estructurado.
Aqui se encontrara todo lo anterior visto en las clases pasadas ya dedicado a un mini proyecto de peliculas.

# Sexta clase en Java.

En esta clase, aplique mas metodos con Streams y lambda para mejorar el codigo de la clase Plataforma haciendolo mas limpio y facil de entender.

[Evidencia](../java-poo/src/estudio/personal/plataforma/Plataforma.java#L29)

## Validaciones de entrada con Enums.

Con estas validaciones buscamos definir un conjunto de valores constantes que haran nuestro codigo mas limpio y seguro.
De esta manera podemos controlar lo que el usuario ingrese por consola y asi evitar posibles errores, mantenendo el codigo mas seguro.

[Enum creado](../java-poo/src/estudio/personal/contenido/Genero.java)

y lo usamos dentro de la clase Pelicula para definir el genero de la contenido: [Ejemplo](../java-poo/src/estudio/personal/contenido/Pelicula.java#L12)

tambien ajustando nuestra clase ScannerUtils para que nos permita usar el enum de Genero: [Ejemplo](../java-poo/src/estudio/personal/util/ScannerUtils.java#L46)

# Septima clase en Java.

## Excepciones en Java.

Las excepciones son eventos que pueden ocurrir en nuestro codigo y que nos permiten manejar errores de manera mas controlada.
existen dos tipos de excepciones: Checked y Unchecked.
Checked son las que se deben de manejar en el codigo, ya que pueden provocar problemas en tiempo de ejecucion.
Unchecked son las que no se deben de manejar en el codigo, ya que no pueden provocar problemas en tiempo de ejecucion. 

Creamos la excepcion en un nuevo paquete de excepciones: [Ejemplo](../java-poo/src/estudio/personal/excepcion/PeliculaExistenteException.java)
Y con esta controlamos el agregar peliculas ya existentes en nuestra plataforma. 
[Uso](../java-poo/src/estudio/personal/plataforma/Plataforma.java#L26)

Control de excepciones con Try Catch: [Ejemplo](../java-poo/src/estudio/personal/Main.java#L68)

## Records
Los records son una nueva caracteristica de java 16 que nos permiten crear clases con atributos y metodos sin necesidad de instanciar la clase.
[Ejemplo](../java-poo/src/estudio/personal/contenido/ResumenContenido.java)

# Octava clase en Java 

## Mapas 
Los mapas son colecciones de pares clave-valor donde cada clave es unica y nos permite almacenar un valor.
[Ejemplo](../java-poo/src/estudio/personal/plataforma/Plataforma.java#L32)

# Novena clase en Java

## Lectura de archivos planos y conversion a objetos.

En esta clase aplico la lectura de archivos planos y la conversion a objetos para poder trabajar con los datos de la plataforma.
Exactamente lo que hice fue crear una nueva clase para manejar este tipo de archivos llamada FileUtils, dentro de esta clase cree un metodo llamado leerContenido, este lo que hace es convertir todo el texto del archivo plano en una lista separada de atributos de la clase Pelicula, y a cada posicion de esa lista le asigno un valor equivalente al contructor de la clase Pelicula y luego instancio la clase Pelicula con esos valores, creando objetos nuevos a partir de ese archivo plano.
[Ejemplo](../java-poo/src/estudio/personal/util/FileUtils.java#L36)

## Agregar objetos a un archivo plano.

Ahora lo que busque hacer es poder tener un registro real de las peliculas agregadas desde el sistema mandando las nuevas peliculas al archivo plano.

[Ejemplo](../java-poo/src/estudio/personal/util/FileUtils.java#L19)

## HERENCIA

En esta clase aplico la herencia generalizando el contenido de la plataforma para poder crear objetos de diferentes tipos de contenido, y poder trabajar con ellos de manera mas eficiente.
Aca manejamos la clase Contenido con todos los atibutos y metodos generales y se los heredamos a las clases hijas Pelicula y Documental.

[Clase Padre(Contenido)](../java-poo/src/estudio/personal/contenido/Contenido.java)
[Clase Hija(Pelicula)](../java-poo/src/estudio/personal/contenido/Pelicula.java)
[Clase Hija(Documental)](../java-poo/src/estudio/personal/contenido/Documental.java)


# Decima clase en Java.

## Polimorfismo.
En esta clase aplique el polimorfismo aprevechando que creamos clases hijas a partir de una clase generla (Padre) que nos hereda varios metodos que varian dependiendo de la clase hija que se instancie.
Para este ejemplo primero filtramos el contenido que se quiere mostrar y dependiendo de esto imprimimos la ficha tecnica respondiente a la clase instanciada.
[Ejemplo](../java-poo/src/estudio/personal/Main.java#L122)

# Decima primera clase en Java.

## Clases Abstractas.

En esta clase aplique la teoria de las clases abstractas tratando las clases hijas de Contenido, modificando el comportamiento de algunos metodos que comparten varias clases hijas, obligando a que cada una sea tratada de manera diferente.
[Clase Abstracta(Padre) y metodos abstractos](../java-poo/src/estudio/personal/contenido/Contenido.java)

## Interfaces. 

Aplique tambien el concepto de interfaces, empezando a conocer un poco del principio solid de inversion de independencias, donde cada clase debe de depender de abstracciones y no de clases concretas creando la interface Promocionable donde definimos el metodo promocionar que sera implementado directamente en la plataforma mostradonos los contenidos promocionables.
[Clase Interface(Promocionable)](../java-poo/src/estudio/personal/contenido/Promocionable.java)


