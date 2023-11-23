# proyecto-banco

Integrantes:
1. Juan David Gomez Calderon
2. Sebastian Andres Guerra Rodriguez

Version SDK: 20
Version Spring: 3.0.0

En los controladores se implementaron metodos POST, GET, DELETE en los controladores los cuales permiten agregar por medio de @RequestBody y ver clientes, ademas de tambien poder eliminar clientes y cuentas segun el id proporcionado. Para la seccion de transacciones podemos hacer deposito y transacciones a otras cuentas, estas se guardaran en su respectiva tabla de transacciones, la cual quedara guardada con la fecha actual.

Se configuro la autenticacion con JWT haciendo uso de login y signup, guardando todos los perfiles en una MySql database

Para el front se opto por usar el framework Angular en la version 16.0.2, para los styles usamos la biblioteca Bootstrap.



