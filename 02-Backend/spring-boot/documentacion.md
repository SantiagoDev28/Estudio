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
  