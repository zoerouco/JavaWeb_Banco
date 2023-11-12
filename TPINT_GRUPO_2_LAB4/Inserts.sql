INSERT INTO generos (id_genero, descripcion)
SELECT 'M','Masculino' UNION
SELECT 'F','Femenino' UNION
SELECT 'NB','No Binario' UNION
SELECT 'NULL','Prefiero no revelarlo';

INSERT INTO tipo_cuenta(id_tipo, descripcion)
SELECT 'CA','Caja de ahorro' UNION
SELECT 'CC','Cuenta corriente';

INSERT INTO tipo_movimiento(id_tipo, descripcion)
SELECT 'alta_cuenta','Genera un movimiento de dinero positivo en la cuenta.' UNION
SELECT 'alta_prestamo','Genera un movimiento de dinero positivo en la cuenta. ' UNION
SELECT 'pago_prestamo','Genera un movimiento de dinero negativo en la cuenta.' UNION
SELECT 'transferencia_enviada','Genera un movimiento de dinero negativo en la cuenta.' UNION
SELECT 'transferencia_recibida','Genera un movimiento de dinero positivo en la cuenta.';

INSERT INTO clientes(DNI, id_genero, id_nacionalidad, id_provincia, id_localidades, CUIL, nombre, apellido, fecha_nacimiento, direccion, 
						correo_electronico, telefono_primario, telefono_secundario, estado)
SELECT '01', 'NULL', '1', '1', '1', '01', NULL, NULL, NULL, 'globank 0101', 'support_globank@gmail.com', '1105263398', NULL, 1 UNION
SELECT '45879526', 'M', '1', '1', '1', '23458795263', 'Natalia', 'Gomez', '2000/08/03', 'velez 189', 'natigomez@gmail.com', '1189758630', '1178452033', 1;

INSERT INTO usuarios(id_usuario,DNI, esAdmin, id_ref, contraseña, nombre_usuario, estado)
SELECT '00','45879526', 1, 1, 'globankroot', 'admin_banco', 1; 

INSERT INTO usuarios(id_usuario,DNI, esAdmin, id_ref, contraseña, nombre_usuario, estado)
SELECT '2','45879526', 1, 1, 'globankuser', 'user', 1; 

INSERT INTO usuarios(id_usuario,DNI, esAdmin, id_ref, contraseña, nombre_usuario, estado)
SELECT '3','45879526', 0, 1, 'user', 'user1', 1; 


Select * from bdglobank.usuarios;