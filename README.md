# api rest para banco hipotecario

esta es una prueba tecnica para el banco hipotecario, se debe desarrollar una API Rest que pueda consumir recursos de una api externa:
[https://jsonplaceholder.typicode.com](https://jsonplaceholder.typicode.com)

## requisitos tecnicos

2 endpoints,

1. GET/posts 

esta debe poder obtener todos los post de la api

2. DELETE/posts/{id} 

este debe poder eliminar un post por id y retornar una respuesta esperada

3. manejo de excepciones

esto es intrinseco



## entidades

posts: estos estan compuestos por: userId, id, titulo y cuerpo

usuarios: compuesto por id, nombre, usuario, email, address, telefono, website, compañia

direccion: compuesta por calle, suite, ciudad, zip code

compañia: nombre, frase y bs

comentario: idPost, id, nombre, email, cuerpo


## principios

para resolver este problema se uso el paradigma orientado a objetos y como principio primordial el TDD, test-driven-development, se procuro hacer un test previo a cada funcionalidad implementada, asi hasta llegar a una comodidad suficiente para priorizar los test escenciales

## como compilar el proyecto

primero  se debe mediante terminal pararse en el directorio del proyecto

```shell
cd /directorio donde se guarde el proyecto/api-rest-banco-hipotecario/code-with-quarkus
```

una vez ejecutar el comando

```shell
mvnw.cmd       
```

esto buildea el proyecto para poder ejecutarlo, si se tiene quarkus instalado se puede ejecutar el comando 


```shell
quarkus dev     
```

para ejecutarlo en modo dev y poder compilar los test al escribir la r con el servidor local ya ejecutado

## testar endpoints

con el proyecto ya buildeado y ejecutandose ingresar en cualquier navegador al link: [http://localhost:8080/q/swagger-ui/](https://localhost:8080/q/swagger-ui/)

para mediante swagger poder ver los endPoints y testear su funcionalidad

## arquitectura y decisiones tecnicas

se busco que la misma sea los mas escalable posible, se separaron los services, de los providers para garantizar la independencia de los endpoints de la fuente de la informacion, como el servico no conoce a la pagina jsonplaceholder sino a su provider esto le permite poder intercambiar entre providers segun se desee pudiendo asi que si mañana fuese requerido obtener la informacion de los json por otras fuentes esto sea posible de realizar con cambios minimos a la implementacion.

## cosas para mejorar

quedo pendiente la implementacion de un login sencillo por cuestiones manejo de tiempos, se logro generar los endpoints principales y la estructura y solidez en test como para que su implentacion no sea tan compleja, por ultimo reconozco que en futuros proyecto debo de programar en ingles para evitar confusiones a la hora de leer e interpretar el codigo





