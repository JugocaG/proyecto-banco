# proyecto-banco

Integrantes:
1. Juan David Gomez Calderon
2. Sebastian Andres Guerra Rodriguez

Version SDK: 20
Version Spring: 2.7.14

En los controladores se implementaron metodos POST, GET, DELETE en los controladores los cuales permiten agregar por medio de @RequestBody y ver clientes, ademas de tambien poder eliminar clientes y cuentas segun el id proporcionado.

Se configuro la autenticacion con dos perfiles:
1. User: juan
Password: ProyectoBanco#1234
2. User: sebastian
Password: ProyectoBanco#4321
El primero es ADMINISTRADOR, por lo que tendra acceso a todos los path, mientras que el segundo es cliente, por lo cual solo podra hacer transacciones, no podra crear ni clientes ni cuentas.



