# SPRING_BOOT

## Inicializar un proyecto de Spring Boot.

    - Dirígete a start.spring.io, la plataforma oficial Spring Initializer.
    - Elige la configuración sugerida: proyecto Gradle, lenguaje Java, versión 3.5.3 de Spring Boot.
    - Establece el grupo como com.(nombre del proyecto) y el artefacto como (nombre del proyecto).
    - Especifica el objetivo del proyecto. 
    - Usa com.(nombre del proyecto) como nombre de paquete y selecciona el empaquetado JAR para aprovechar el servidor embebido.
    - Selecciona la dependencia Spring Web para crear servicios RESTful apoyados por Spring MVC y el servidor embebido Apache Tomcat

Corremos el proyecto ejecutando la clase Main en el paquete principal.

# Clase #1 en Spring Boot.

## Controlador REST simple:
  En esta clase creamos nuestro primer endpoint para poder hacer peticiones a nuestro servidor.
  [Endpoint creado](./pelist/src/main/java/com/pelist/HelloController.java)

## Integracion de IA a nuestros Endpoints.

  Utilizamos una libreria llamada Langchain4j para poder integrar LLM'S a nuestros Endpoints.
  Configuramos las variables de entorno para poder utilizar la libreria en el archivo `application.properties`.
  [Interface creada para las respuestas de IA](./pelist/src/main/java/com/pelist/PelistAiService.java)

# Clase #2 en Spring Boot.

## Configuracion de los diferentes entornos.

  En esta clase vimos que podemos tener diferentes entornos de trabajo, uno general que almacena las variables generales de todo el aplicativo, otro para el entorno de desarrollo y otro para el entorno de produccion.
  Cada uno de ellos se encuentra dentro de la carpeta resources y maneja diferentes parametros de configuracion. En el archivo `application.properties` se puede definir cual usar de acuerdo a la variable `spring.profiles.active`.
  [Carpeta resources](./pelist/src/main/resources)
  [Archivo application.properties](./pelist/src/main/resources/application.properties)
