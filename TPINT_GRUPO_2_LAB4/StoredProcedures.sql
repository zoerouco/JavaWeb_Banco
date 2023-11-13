
/*
 * LISTA de SP:
 - AgregarCliente
 - AgregarPrestamos
 - AgregarCuenta
 - AgregarMovimiento
 
 *ALTER TABLES
 
 * TRIGGERS:
 -TR_CrearUsuario
 
   */


/*----------------------------------*/
DELIMITER //

CREATE PROCEDURE AgregarCliente(
	IN DNI char(20),
    IN id_genero char(5),
    IN id_nacionalidad int(11),
    IN id_provincia int(10),
    IN id_localidades int(11),
    IN CUIL char(11),
    IN nombre varchar(100),
    IN apellido varchar(100),
    IN fecha_nacimiento date,
    IN direccion varchar(100),
    IN correo_electronico varchar(100),
    IN telefono_primario varchar(10),
    IN telefono_secundario varchar(10),
    IN estado bit
)
BEGIN
	INSERT INTO clientes(DNI, id_genero, id_nacionalidad, id_provincia, id_localidades, CUIL, nombre, apellido, fecha_nacimiento, direccion, 
						correo_electronico, telefono_primario, telefono_secundario, estado)
	SELECT DNI, id_genero, id_nacionalidad, id_provincia, id_localidades, CUIL, nombre, apellido, fecha_nacimiento, direccion, correo_electronico,
			telefono_primario, telefono_secundario, estado;
END //

DELIMITER ;

/*----------------------------------*/

DELIMITER //

CREATE PROCEDURE AgregarPrestamo(
    IN id_prestamo CHAR(20),
    IN CBU CHAR(22),
    IN importe_con_intereses DECIMAL(18, 2),
    IN importe_pedido DECIMAL(18, 2),
    IN monto_x_mes DECIMAL(18, 2),
    IN cantidad_cuotas INT,
    IN estado CHAR(20)
)
BEGIN
    INSERT INTO Prestamos (id_prestamo, CBU, fecha_realizacion, importe_con_intereses, importe_pedido, monto_x_mes, cantidad_cuotas, estado)
    SELECT id_prestamo, CBU, NOW(), importe_con_intereses, importe_pedido, monto_x_mes, cantidad_cuotas, estado;
END //

DELIMITER ;

/*----------------------------------*/

DELIMITER //
CREATE PROCEDURE AgregarCuenta(
	IN	CBU char(22) ,
	IN	id_tipo char(5) ,
	IN   DNI char(20),
    IN nro_cuenta char(20) ,
    IN saldo decimal(18,2) 
)
BEGIN
INSERT INTO cuentas(CBU,id_tipo,DNI,fecha_creacion,nro_cuenta,saldo,estado)
SELECT CBU,id_tipo,DNI,now(),nro_cuenta,10000,true;
END 
//
DELIMITER ;

/*----------------------------------*/

DELIMITER //

 CREATE PROCEDURE AgregarMovimiento(
    IN id_tipo CHAR(30),
    IN CBU CHAR(22),
    IN CBU_Destino CHAR(22),
    IN Importe decimal,
    IN Detalle VARCHAR(255),
    IN Estado BOOLEAN
)
BEGIN
    INSERT INTO Movimientos (id_tipo, CBU, CBU_Destino, fecha, Importe, Detalle, Estado)
    VALUES (id_tipo, CBU, CBU_Destino, NOW(), Importe, Detalle, Estado);
END //

DELIMITER ;


/*--------------NUEVO 11/11--------------------*/


DELIMITER //

 CREATE PROCEDURE AgregarMovimientoxPrestamo(
	IN id_movimiento int,
    IN CBU char(22),
    IN id_prestamo int
)
BEGIN
    INSERT INTO movimientosxprestamos (id_movimiento, CBU, id_prestamo)
    VALUES (id_movimiento, CBU, id_prestamo);
END //

DELIMITER ;

/*----------------------------------*/

/*----------------------------------*/


 /* ------- ALTERS TABLES ------- */


	
	/*------- TRIGGERS -------*/


	
	DELIMITER //
	CREATE TRIGGER TR_CrearUsuario AFTER INSERT ON clientes
	FOR EACH ROW
	
	BEGIN
    INSERT INTO usuarios(DNI, esAdmin, id_ref, contraseña, nombre_usuario, estado)
    VALUES (NEW.DNI, false, 0, NEW.DNI, CONCAT(NEW.nombre, NEW.apellido), true);
	END;
	//
	DELIMITER ;
	
	
	/*------12/11---------*/
		DELIMITER //
		CREATE TRIGGER TR_AltaCuenta_Movimientos AFTER INSERT ON cuentas
		FOR EACH ROW
		
		BEGIN
			INSERT INTO movimientos(CBU, id_tipo, CBU_destino, fecha, detalle, importe, estado)
			VALUES (NEW.CBU, 'alta_cuenta', '1000000000000000000001', NOW(), 'alta_cuenta',NEW.saldo, 1);
		END;
		// DELIMITER ;
		
		
		/*-------------------------*/
		DELIMITER //
		CREATE TRIGGER TR_AltaPrestamos_Movimientos AFTER UPDATE ON prestamos
		FOR EACH ROW
		BEGIN
			IF NEW.estado = 'Aprobado' THEN
				INSERT INTO movimientos(CBU, id_tipo, CBU_destino, fecha, detalle, importe, estado)
	            VALUES ('1000000000000000000001', 'alta_prestamo', NEW.CBU, NOW(), 'alta_prestamo', NEW.importe_pedido, 1);
				
	            UPDATE cuentas SET saldo = saldo + NEW.importe_pedido WHERE cuentas.CBU = NEW.CBU;
			END IF;
		END;
		// DELIMITER ;