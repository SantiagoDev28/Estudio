# Introduccion a la programacion orientada a objetos

Un objeto es cualquier cosa, real o abstracta, en la que se almacenan datos y aquellas operaciones que manipulan esos datos. 

# Ventajas de la POO

1. Reusabilidad: Podemos usar el mismo codigo en diferentes partes y proyectos sin tener que volverlo a escribir.

2. Mantenibilida: Es mas facil entender y depurar codigo con el tiempo pues todo esta dividido de manera modular.

3. Modificabilidad: Se pueden cambiar y agregar nuevos elementos sin romper nada de lo que ya esta escrito.

4. Fiabilidad: Al dividir el proyecto en pequeñas partes sera mas sencillo controlar errores y el software es mucho mas estable. 

# Pilares de la POO

1. Abstraccion: 

    En programación orientada a objetos, cada objeto se define por atributos y métodos.
    Los atributos representan las características o propiedades que identifican al objeto, mientras que los métodos describen las acciones o comportamientos que este puede realizar.

    Por ejemplo, una película puede tener atributos como título, descripción y año de lanzamiento. A su vez, puede contar con métodos que definan su comportamiento, como reproducir(), calificar() u obtenerDatos().

    La abstracción consiste en modelar un objeto mostrando únicamente la información y los comportamientos relevantes, ocultando los detalles internos que no son necesarios para su uso.

2. Encapsulamiento:
    El encapsulamiento en POO nos permite proteger los detalles sensibles de nuestras clases, manteniendo su integridad y seguridad.
    Siendo accesibles unicamente desde la misma clase con metodos especiales llamados Getters y Setters.
    Mas sobre el encapsulamiento se encuentra:
    [Clase #4](../java/ejercicios/java-poo/README.md#encapsulamiento-en-java)
    
3. Herencia:
    La herencia en POO nos permite crear nuevas clases basadas en clases existentes, heredando sus atributos y comportamientos.
    Esto nos permite reutilizar codigo y facilitar la mantenibilidad de nuestros proyectos.
    Mas sobre la herencia se encuentra:
    [Clase #9](../java/ejercicios/java-poo/README.md#HERENCIA)

4. Polimorfismo: 
    El polimorfismo nos permite crear objetos de diferentes clases que comparten la misma interfaz, pero pueden tener comportamientos diferentes.
    Esto nos permite crear objetos dinamicamente y facilitar la flexibilidad de nuestros proyectos.
    Mas sobre el polimorfismo se encuentra:
    [Clase #10](../java/ejercicios/java-poo/README.md#POLIMORFISMO)

# Constructores.
Los constructores en Programacion orientada a objetos son metodos especiales que se llaman al crear un objeto, y se encargan de inicializar los atributos de la clase.