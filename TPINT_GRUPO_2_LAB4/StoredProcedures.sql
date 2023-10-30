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
			telefono_primario, relefono_secundario, estado;
END //

DELIMITER ;