# JavaWeb_Banco
Sistema de gestión para un banco, desarrollado con Java/JSP.

## Integrantes:
> Benetti, Guido Nehuen
>
> Dalama, Melany Nahir
>
> Rouco, Zoe
>
> Vitale, Luciano
>
> Mosto, Pilar


## About
``` 
Usuario banco:

• ABML de clientes. Tener en cuenta que a cada cliente se le asignará un usuario y contraseña para poder acceder a la web del banco.
El administrador podrá cambiar la contraseña, pero nunca se podrá modificar el usuario de ese cliente.

• ABML de cuentas y asignación de cuenta a cliente. Una cuenta debe pertenecer a un solo cliente. Se le podrá asignar un máximo de
3 cuentas a un cliente. Al crear la cuenta se le asignará un monto inicial fijo de $10.000.

• Autorización de préstamos. El administrador podrá autorizar o rechazar los préstamos solicitados por el cliente. Si se aprueba
el préstamo entonces se le asignará al cliente el monto pedido. Tener en cuenta que se deberán generar las cuotas para que luego
pague el cliente.

• Incluir informe/ reportes estadísticos para el administrador.


Usuario cliente:

• El cliente podrá seleccionar una cuenta y observar el historial de los movimientos realizados en esa cuenta.

• Transferencias a otros clientes: Un cliente podrá transferir dinero entre sus propias cuentas o a cuentas de otros clientes
utilizando el CBU. Se podrá realizar la transferencia mientras el usuario cuente con dinero disponible. Si no posee dinero no podrá
transferir.

• Pedido de préstamo. El cliente podrá pedir un préstamo de cierto dinero al banco, seleccionar la cantidad de cuotas en las que
quiere abonarlo y elegir la cuenta en donde se le depositará el pago del préstamo. El banco recibirá el pedido y autorizará o no
dicho préstamo.

• El cliente tendrá un menú de pago de préstamos en donde figure las cuotas que debe pagar, podrá pagar seleccionando la cuota y
cuenta de donde se descontará dicho gasto. Cada vez que se pague una cuota se guardará la fecha en la cual se pagó la misma.

• El cliente podrá visualizar su información personal. No podrá cambiar los datos, solo los visualizará.


Observaciones:

Asumiremos que no se generan intereses por el pago fuera de término de la cuota de un préstamo, la cuota es fija. También asumiremos
que toda la funcionalidad pertenece a un mismo banco (en la tabla usuario de la base de datos deberán tener un usuario de tipo administrador
de banco para que pueda acceder a la aplicación). No es necesario hacer un ABML de tipo de cuentas posibles y tipos de movimientos, los
mismos deben estar cargados previamente en la base de datos. Las cuentas no pueden quedar con saldos negativos.


Tipos de cuentas posibles:

• Caja de ahorro.

• Cuenta corriente.


Tipos de movimientos posibles:

• Alta de cuenta: El alta de una cuenta genera un movimiento de dinero positivo en la cuenta origen.

• Alta de un préstamo: El alta de un préstamo genera un movimiento de dinero positivo en la cuenta origen.

• Pago de préstamo: El pago de un préstamo genera un movimiento de dinero negativo en la cuenta origen.

• Transferencia: Una transferencia genera dos movimientos, un movimiento negativo en la cuenta de origen (extracción de dinero)
y un movimiento positivo en la cuenta destino (depósito de dinero).
```

### Diagrama Entidad Relacion
![Diagrama de entidad-relacion](./Recursos/img/DER.jpg)


## Programas utilizados
IDE: Eclipse
DATABASE: MySQL
CODE: Java, JSP (Java Server Pages), SQL, JavaScript, Bootstrap, HTML y CSS.
