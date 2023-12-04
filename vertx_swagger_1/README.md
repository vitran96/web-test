# Vertx swagger generate code

Resource:

* https://vertx.io/blog/presentation-of-the-vert-x-swagger-project/
* https://github.com/anupsaund/vertx-auto-swagger#
* https://github.com/AlexeySoshin/VertxSwaggerUI/tree/master/src/main
* https://github.com/swagger-api/swagger-ui/blob/master/docs/usage/installation.md
* https://github.com/phiz71/vertx-swagger/blob/master/sample/petstore-vertx-server/src/main/java/io/swagger/server/api/MainApiVerticle.java

Swagger editor: https://editor.swagger.io/

How to set up swagger UI manually:

1. Download swagger-ui from swagger-dist package
2. Copy dist folder to src/main/resources/webroot
3. Serve index.html from webroot folder
4. Serve swagger.json to api path /swagger (or maybe /swagger.json)

Now you can access swagger UI from http://localhost:8080/index.html
