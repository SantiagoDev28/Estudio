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
