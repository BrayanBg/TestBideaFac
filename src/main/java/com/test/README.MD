# Test Bidea Factory 

Crear una API rest que permite reservar una casa, para lo cual se debe recibir un request,
validar dicho request, si se indica algún código de descuento validarlo a través de una api rest, y para
finalizar guardar los datos del request en una bbdd postgresql.

## Base de datos

- Se debe tener una base datos de nombre [BideaFactory] en PostgrSQL 
- Se debe ajustar el usuario y contraseña en el archivo [application.properties]
```bash
spring.datasource.username= $BD_USER
spring.datasource.password= $BD_PASSWORD
```

Una vez configurados los accesos a la base de datos ejecutar
