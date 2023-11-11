CREATE DATABASE `bdGlobank`; 
USE bdGlobank; 

CREATE TABLE `generos`(
	`id_genero` char(5) NOT NULL,
    `descripcion` varchar(50) NOT NULL,
    PRIMARY KEY (id_genero)
);

CREATE TABLE `tipo_cuenta`(
	`id_tipo` char(5) NOT NULL,
    `descripcion`char(100) NOT NULL,
    PRIMARY KEY (id_tipo)
);

CREATE TABLE `clientes`(
	`DNI` char(20) NOT NULL,
    `id_genero` char(5) NOT NULL,
    `id_nacionalidad` int(11) NOT NULL,
    `id_provincia` int(10) NOT NULL,
    `id_localidades` int(11) NOT NULL,
    `CUIL` char(11) unique,
    `nombre` varchar(100),
    `apellido` varchar(100),
    `fecha_nacimiento` date,
    `direccion` varchar(100) NOT NULL,
    `correo_electronico` varchar(100) NOT NULL,
    `telefono_primario` varchar(10) NOT NULL,
    `telefono_secundario` varchar(10),
    `estado` bit DEFAULT 1,
    FOREIGN KEY (id_genero) REFERENCES generos (id_genero),
    FOREIGN KEY (id_nacionalidad) REFERENCES nacionalidades (id),
    FOREIGN KEY (id_provincia) REFERENCES provincias (id),
    FOREIGN KEY (id_localidades) REFERENCES localidades (id),
    PRIMARY KEY (DNI)
);

CREATE TABLE `cuentas`(
	`CBU` char(22) NOT NULL,
	`id_tipo` char(5) NOT NULL,
    `DNI` char(20) NOT NULL,
    `fecha_creacion` datetime,
    `nro_cuenta` char(20) DEFAULT 0,
    `saldo` decimal(18,2) DEFAULT 0,
    `estado` bit DEFAULT 1,
	FOREIGN KEY (id_tipo) REFERENCES tipo_cuenta (id_tipo),
    FOREIGN KEY (DNI) REFERENCES clientes (DNI),
    PRIMARY KEY (CBU)
);

CREATE TABLE `tipo_movimiento`(
	`id_tipo` char(30) NOT NULL,
    `descripcion`char(100) NOT NULL,
    PRIMARY KEY (id_tipo)
);

CREATE TABLE `movimientos`(
	`id_movimiento` char(20) NOT NULL,
	`CBU` char(22) NOT NULL,
    `id_tipo` char(30) NOT NULL,
    `CBU_destino` char(22) NOT NULL,
    `fecha` datetime,
    `detalle` varchar(200),
    `importe` decimal(18,2) DEFAULT 0,
	`estado` bit DEFAULT 1,
	FOREIGN KEY (CBU) REFERENCES cuentas (CBU),
    FOREIGN KEY (id_tipo) REFERENCES tipo_movimiento (id_tipo),
	PRIMARY KEY (id_movimiento, CBU)
);

/*---------NUEVA--------*/

CREATE TABLE `movimientosXprestamos` (
    `id_movimiento` char(20) NOT NULL,
    `CBU` char(22) NOT NULL,
    `id_prestamo` char(20) NOT NULL,
    PRIMARY KEY (`id_movimiento`, `CBU`, `id_prestamo`),
    FOREIGN KEY (`id_movimiento`, `CBU`) REFERENCES `movimientos` (`id_movimiento`, `CBU`),
    FOREIGN KEY (`id_prestamo`) REFERENCES `prestamos` (`id_prestamo`)
);

/*---------------------*/

CREATE TABLE `usuarios`(
	`id_usuario` int AUTO_INCREMENT NOT NULL,
    `DNI` char(20) UNIQUE NOT NULL,
    `esAdmin` bit DEFAULT 0,
    `id_ref` int NULL,
    `contraseña` char(30) NOT NULL,
    `nombre_usuario` char(50) NOT NULL,
	`estado` bit DEFAULT 1,
    FOREIGN KEY (DNI) REFERENCES clientes (DNI),
    PRIMARY KEY (id_usuario)
);

CREATE TABLE `prestamos`(
	`id_prestamo` char(20) NOT NULL,
	`CBU` char(22) NOT NULL,
    `fecha_realizacion` datetime,
    `importe_con_intereses` decimal(18,2) DEFAULT 0,
    `importe_pedido` decimal(18,2) DEFAULT 0,
    `monto_x_mes` decimal(18,2) DEFAULT 0,
    `cantidad_cuotas` int DEFAULT 0,
	`estado` varchar(20),
    FOREIGN KEY (CBU) REFERENCES cuentas (CBU),
    PRIMARY KEY (id_prestamo)
);