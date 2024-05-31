-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Versión del servidor:         5.6.17-log - MySQL Community Server (GPL)
-- SO del servidor:              Win64
-- HeidiSQL Versión:             12.6.0.6765
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Volcando estructura de base de datos para clinica
CREATE DATABASE IF NOT EXISTS `clinica` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `clinica`;

-- Volcando estructura para tabla clinica.antecedente_clinico
CREATE TABLE IF NOT EXISTS `antecedente_clinico` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_paciente` int(11) NOT NULL DEFAULT '0',
  `id_antecedente_clinico` int(11) NOT NULL DEFAULT '0',
  `respuesta` varchar(255) DEFAULT NULL,
  `usuario` varchar(255) DEFAULT NULL,
  `observaciones` varchar(255) DEFAULT NULL,
  `created_time` datetime(6) DEFAULT NULL,
  `update_time` datetime(6) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_paciente_id_antecedente_clinico` (`id_paciente`,`id_antecedente_clinico`),
  KEY `FK_antecedente_clinico_tipo_antecedente_clinico` (`id_antecedente_clinico`),
  CONSTRAINT `FK_antecedente_clinico_paciente` FOREIGN KEY (`id_paciente`) REFERENCES `paciente` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_antecedente_clinico_tipo_antecedente_clinico` FOREIGN KEY (`id_antecedente_clinico`) REFERENCES `tipo_antecedente_clinico` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=236 DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla clinica.antecedente_clinico: ~1 rows (aproximadamente)
INSERT INTO `antecedente_clinico` (`id`, `id_paciente`, `id_antecedente_clinico`, `respuesta`, `usuario`, `observaciones`, `created_time`, `update_time`) VALUES
	(235, 172, 2, NULL, 'SISTEMA', NULL, NULL, NULL);

-- Volcando estructura para tabla clinica.aparato_sistemas
CREATE TABLE IF NOT EXISTS `aparato_sistemas` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_paciente` int(11) NOT NULL DEFAULT '0',
  `id_aparato_sistema` int(11) DEFAULT NULL,
  `respuesta` int(11) DEFAULT NULL,
  `usuario` varchar(50) DEFAULT NULL,
  `observaciones` varchar(200) DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `clave` varchar(255) DEFAULT NULL,
  `descripcion` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_paciente_id_aparato_sistema` (`id_paciente`,`id_aparato_sistema`),
  KEY `fk_paciente_aparato_idx` (`id_paciente`),
  KEY `FKnyd2spap2ahydn9slw380iss2` (`id_aparato_sistema`),
  CONSTRAINT `FK_aparato_sistemas_paciente` FOREIGN KEY (`id_paciente`) REFERENCES `paciente` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_aparato_sistemas_tipo_aparato_sistemas` FOREIGN KEY (`id_aparato_sistema`) REFERENCES `tipo_aparato_sistemas` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla clinica.aparato_sistemas: ~1 rows (aproximadamente)
INSERT INTO `aparato_sistemas` (`id`, `id_paciente`, `id_aparato_sistema`, `respuesta`, `usuario`, `observaciones`, `create_time`, `update_time`, `clave`, `descripcion`) VALUES
	(35, 172, 1, NULL, 'SISTEMA', NULL, '2024-05-30 23:40:48', '2024-05-30 23:40:48', NULL, NULL);

-- Volcando estructura para tabla clinica.centro_costo
CREATE TABLE IF NOT EXISTS `centro_costo` (
  `idcc` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(90) DEFAULT NULL,
  PRIMARY KEY (`idcc`)
) ENGINE=InnoDB AUTO_INCREMENT=177 DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla clinica.centro_costo: ~2 rows (aproximadamente)
INSERT INTO `centro_costo` (`idcc`, `descripcion`) VALUES
	(86, 'FINCA 07'),
	(176, 'FINCA 81');

-- Volcando estructura para tabla clinica.empleado
CREATE TABLE IF NOT EXISTS `empleado` (
  `dpi` varchar(45) COLLATE utf8_spanish2_ci DEFAULT NULL COMMENT 'DPI',
  `cue` int(11) NOT NULL COMMENT 'Cue',
  `nombre1` varchar(45) COLLATE utf8_spanish2_ci DEFAULT NULL COMMENT 'Primer Nombre',
  `nombre2` varchar(45) COLLATE utf8_spanish2_ci DEFAULT NULL COMMENT 'Segundo Nombre',
  `apellido1` varchar(45) COLLATE utf8_spanish2_ci DEFAULT NULL COMMENT 'Primer Apellido',
  `apellido2` varchar(45) COLLATE utf8_spanish2_ci DEFAULT NULL COMMENT 'Segundo Apellido',
  `apellidoc` varchar(45) COLLATE utf8_spanish2_ci DEFAULT NULL COMMENT 'Apellido de Casada',
  `nacionalidad` varchar(45) COLLATE utf8_spanish2_ci DEFAULT NULL COMMENT 'Nacionalidad',
  `fecha_nacimiento` date DEFAULT NULL COMMENT 'Fecha Nacimiento',
  `genero` varchar(45) COLLATE utf8_spanish2_ci DEFAULT NULL COMMENT 'Genero',
  `idregion` int(11) DEFAULT NULL,
  `ocupacion` int(11) DEFAULT NULL COMMENT 'Ocupación',
  `estado_civil` varchar(45) COLLATE utf8_spanish2_ci DEFAULT NULL COMMENT 'Estado Civil',
  `fecha_desde` date DEFAULT NULL COMMENT 'Fecha Desde',
  `fecha_hasta` date DEFAULT NULL COMMENT 'Fecha Hasta',
  `fecha_ultimo_aguinaldo` date DEFAULT NULL,
  `fecha_ultimo_bono14` date DEFAULT NULL,
  `fecha_ultimas_vacaciones` date DEFAULT NULL,
  `estado` varchar(30) COLLATE utf8_spanish2_ci DEFAULT NULL,
  PRIMARY KEY (`cue`) USING BTREE,
  KEY `indx_dpi` (`dpi`) USING BTREE,
  KEY `idx_fecha_desde` (`fecha_desde`) USING BTREE,
  KEY `idx_fecha_bono14` (`fecha_ultimo_bono14`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci COMMENT='Empleado';

-- Volcando datos para la tabla clinica.empleado: ~2 rows (aproximadamente)
INSERT INTO `empleado` (`dpi`, `cue`, `nombre1`, `nombre2`, `apellido1`, `apellido2`, `apellidoc`, `nacionalidad`, `fecha_nacimiento`, `genero`, `idregion`, `ocupacion`, `estado_civil`, `fecha_desde`, `fecha_hasta`, `fecha_ultimo_aguinaldo`, `fecha_ultimo_bono14`, `fecha_ultimas_vacaciones`, `estado`) VALUES
	('1909651341508', 0, 'Miguel', NULL, 'Juc', 'Caal', NULL, 'Guatemalteco', '1980-05-20', 'Masculino', 176, 5, 'Casado', '2024-05-27', NULL, NULL, NULL, NULL, NULL),
	('1841394491007', 1281, 'Hermelindo', NULL, 'López', 'García', NULL, 'Guatemalteco', '1962-12-15', 'Masculino', 86, 17, 'Casado', '2016-10-27', NULL, NULL, NULL, NULL, 'ACTIVO'),
	('1909651341508', 69002, 'Miguel', NULL, 'Juc', 'Caal', NULL, 'Guatemalteco', '1980-05-20', 'Masculino', 176, 5, 'Casado', '2024-05-27', NULL, NULL, NULL, NULL, NULL);

-- Volcando estructura para tabla clinica.examen_fisico
CREATE TABLE IF NOT EXISTS `examen_fisico` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_paciente` int(11) DEFAULT NULL,
  `id_examen_fisico` int(11) DEFAULT NULL,
  `respuesta` varchar(45) DEFAULT NULL,
  `resultado` int(11) DEFAULT NULL,
  `observaciones` varchar(200) DEFAULT NULL,
  `usuario` varchar(45) DEFAULT NULL,
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_paciente_id_examen_medico` (`id_paciente`,`id_examen_fisico`) USING BTREE,
  KEY `fk_paciente_examen_fisico_idx` (`id_paciente`),
  KEY `fk_paciente_examenes_idx` (`id_examen_fisico`) USING BTREE,
  CONSTRAINT `FK_examen_fisico_tipo_examen_fisico` FOREIGN KEY (`id_examen_fisico`) REFERENCES `tipo_examen_fisico` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_paciente_examen_fisico` FOREIGN KEY (`id_paciente`) REFERENCES `paciente` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla clinica.examen_fisico: ~0 rows (aproximadamente)
INSERT INTO `examen_fisico` (`id`, `id_paciente`, `id_examen_fisico`, `respuesta`, `resultado`, `observaciones`, `usuario`, `update_time`, `create_time`) VALUES
	(26, 172, 1, NULL, NULL, NULL, 'SISTEMA', '2024-05-30 23:40:48', '2024-05-30 23:40:48');

-- Volcando estructura para tabla clinica.examen_laboratorio
CREATE TABLE IF NOT EXISTS `examen_laboratorio` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_paciente` int(11) DEFAULT NULL,
  `id_examen_laboratorio` int(11) DEFAULT NULL,
  `respuesta` varchar(45) DEFAULT NULL,
  `resultado` int(11) DEFAULT NULL,
  `observaciones` varchar(200) DEFAULT NULL,
  `usuario` varchar(50) DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_paciente_id_examen_laboratorio` (`id_paciente`,`id_examen_laboratorio`),
  KEY `fk_paciente_laboratorio_idx` (`id_paciente`),
  KEY `fk_examen_laboratorio_idx` (`id_examen_laboratorio`) USING BTREE,
  CONSTRAINT `FK_examen_laboratorio_tipo_examen_laboratorio` FOREIGN KEY (`id_examen_laboratorio`) REFERENCES `tipo_examen_laboratorio` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_paciente_laboratorio` FOREIGN KEY (`id_paciente`) REFERENCES `paciente` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla clinica.examen_laboratorio: ~0 rows (aproximadamente)
INSERT INTO `examen_laboratorio` (`id`, `id_paciente`, `id_examen_laboratorio`, `respuesta`, `resultado`, `observaciones`, `usuario`, `create_time`, `update_time`) VALUES
	(26, 172, 1, NULL, NULL, NULL, 'SISTEMA', '2024-05-30 23:40:48', '2024-05-30 23:40:48');

-- Volcando estructura para procedimiento clinica.insertarDatosPacientes
DELIMITER //
CREATE PROCEDURE `insertarDatosPacientes`(
	IN `_id` INT
)
BEGIN
SET @id=_id;  
INSERT IGNORE clinica.antecedente_clinico (id_paciente,id_antecedente_clinico,usuario)
SELECT @id
			, t.id
			, 'SISTEMA' AS usuario
FROM clinica.tipo_antecedente_clinico AS t
WHERE t.estado='ACTIVO';

INSERT IGNORE clinica.aparato_sistemas (id_paciente,id_aparato_sistema,usuario)
SELECT @id
			, t.id
			, 'SISTEMA' AS usuario
FROM clinica.tipo_aparato_sistemas AS t
WHERE t.estado='ACTIVO';

INSERT IGNORE clinica.examen_fisico (id_paciente,id_examen_fisico,usuario)
SELECT @id
			, t.id
			, 'SISTEMA' AS usuario
FROM clinica.tipo_examen_fisico AS t
WHERE t.estado='ACTIVO';

INSERT IGNORE clinica.examen_laboratorio (id_paciente,id_examen_laboratorio,usuario)
SELECT @id
			, t.id
			, 'SISTEMA' AS usuario
FROM clinica.tipo_examen_laboratorio AS t
WHERE t.estado='ACTIVO';
INSERT IGNORE clinica.signo_vital (id_paciente,id_signo_vital,usuario)
SELECT @id
			, t.id
			, 'SISTEMA' AS usuario
FROM clinica.tipo_signo_vital AS t
WHERE t.estado='ACTIVO';
END//
DELIMITER ;

-- Volcando estructura para tabla clinica.paciente
CREATE TABLE IF NOT EXISTS `paciente` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `fecha` date DEFAULT NULL,
  `cue` int(11) DEFAULT NULL,
  `id_tipo_examen` int(11) NOT NULL,
  `recomendacion` varchar(200) DEFAULT NULL,
  `apto_laborar` tinyint(1) DEFAULT NULL,
  `fecha_vencimiento` datetime DEFAULT NULL,
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `usuario` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=173 DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla clinica.paciente: ~1 rows (aproximadamente)
INSERT INTO `paciente` (`id`, `fecha`, `cue`, `id_tipo_examen`, `recomendacion`, `apto_laborar`, `fecha_vencimiento`, `update_time`, `create_time`, `usuario`) VALUES
	(172, '2024-05-01', 1281, 1, '', 0, NULL, NULL, '2024-05-30 23:40:48', NULL);

-- Volcando estructura para tabla clinica.puesto
CREATE TABLE IF NOT EXISTS `puesto` (
  `idpuesto` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(90) DEFAULT NULL,
  PRIMARY KEY (`idpuesto`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla clinica.puesto: ~2 rows (aproximadamente)
INSERT INTO `puesto` (`idpuesto`, `descripcion`) VALUES
	(5, 'Deshojador'),
	(17, 'Cosechero');

-- Volcando estructura para tabla clinica.signo_vital
CREATE TABLE IF NOT EXISTS `signo_vital` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_paciente` int(11) DEFAULT NULL,
  `id_signo_vital` int(11) DEFAULT NULL,
  `respuesta` varchar(50) DEFAULT NULL,
  `observaciones` varchar(200) DEFAULT NULL,
  `usuario` varchar(50) DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_paciente_id_signo_vital` (`id_paciente`,`id_signo_vital`),
  KEY `fk_paciente_signos_vitales_idx` (`id_signo_vital`),
  KEY `fk_paciente_signos_vitales_idx1` (`id_paciente`),
  CONSTRAINT `fk_paciente_signos_vitales` FOREIGN KEY (`id_signo_vital`) REFERENCES `tipo_signo_vital` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_paciente_signos_vitales_paciente` FOREIGN KEY (`id_paciente`) REFERENCES `paciente` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla clinica.signo_vital: ~0 rows (aproximadamente)
INSERT INTO `signo_vital` (`id`, `id_paciente`, `id_signo_vital`, `respuesta`, `observaciones`, `usuario`, `create_time`, `update_time`) VALUES
	(27, 172, 1, NULL, NULL, 'SISTEMA', '2024-05-30 23:40:48', '2024-05-30 23:40:48');

-- Volcando estructura para tabla clinica.tipo_antecedente_clinico
CREATE TABLE IF NOT EXISTS `tipo_antecedente_clinico` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `clave` varchar(45) DEFAULT NULL,
  `descripcion` varchar(100) DEFAULT NULL,
  `estado` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla clinica.tipo_antecedente_clinico: ~2 rows (aproximadamente)
INSERT INTO `tipo_antecedente_clinico` (`id`, `clave`, `descripcion`, `estado`) VALUES
	(1, 'Corazon', 'Corazon', 'INACTIVO'),
	(2, 'Fumar', 'Fumar', 'ACTIVO');

-- Volcando estructura para tabla clinica.tipo_aparato_sistemas
CREATE TABLE IF NOT EXISTS `tipo_aparato_sistemas` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `clave` varchar(45) DEFAULT NULL,
  `descripcion` varchar(100) DEFAULT NULL,
  `estado` varchar(100) DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla clinica.tipo_aparato_sistemas: ~1 rows (aproximadamente)
INSERT INTO `tipo_aparato_sistemas` (`id`, `clave`, `descripcion`, `estado`, `create_time`, `update_time`) VALUES
	(1, 'Pulmones', 'Pulmones', 'ACTIVO', '2024-05-29 22:13:24', '2024-05-29 22:13:42');

-- Volcando estructura para tabla clinica.tipo_examen
CREATE TABLE IF NOT EXISTS `tipo_examen` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `clave` varchar(200) NOT NULL DEFAULT '0',
  `descripcion` varchar(200) NOT NULL DEFAULT '0',
  `estado` varchar(200) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla clinica.tipo_examen: ~2 rows (aproximadamente)
INSERT INTO `tipo_examen` (`id`, `clave`, `descripcion`, `estado`) VALUES
	(0, 'cxzc', 'zxc', 'ACTIVO'),
	(1, 'local', 'local', 'ACTIVO');

-- Volcando estructura para tabla clinica.tipo_examen_fisico
CREATE TABLE IF NOT EXISTS `tipo_examen_fisico` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `clave` varchar(45) DEFAULT NULL,
  `descripcion` varchar(100) DEFAULT NULL,
  `estado` varchar(100) DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla clinica.tipo_examen_fisico: ~1 rows (aproximadamente)
INSERT INTO `tipo_examen_fisico` (`id`, `clave`, `descripcion`, `estado`, `create_time`, `update_time`) VALUES
	(1, 'fisico', 'Fisico', 'ACTIVO', '2024-05-29 22:15:36', '2024-05-29 22:15:47');

-- Volcando estructura para tabla clinica.tipo_examen_laboratorio
CREATE TABLE IF NOT EXISTS `tipo_examen_laboratorio` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `clave` varchar(45) DEFAULT NULL,
  `descripcion` varchar(100) DEFAULT NULL,
  `estado` varchar(100) DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla clinica.tipo_examen_laboratorio: ~0 rows (aproximadamente)
INSERT INTO `tipo_examen_laboratorio` (`id`, `clave`, `descripcion`, `estado`, `create_time`, `update_time`) VALUES
	(1, 'laboratorio', 'Laboratorio', 'ACTIVO', '2024-05-29 22:16:10', '2024-05-29 22:16:10');

-- Volcando estructura para tabla clinica.tipo_signo_vital
CREATE TABLE IF NOT EXISTS `tipo_signo_vital` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `clave` varchar(45) DEFAULT NULL,
  `descripcion` varchar(50) DEFAULT NULL,
  `estado` varchar(50) DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla clinica.tipo_signo_vital: ~0 rows (aproximadamente)
INSERT INTO `tipo_signo_vital` (`id`, `clave`, `descripcion`, `estado`, `create_time`, `update_time`) VALUES
	(1, 'sigo', 'signo vital', 'ACTIVO', '2024-05-29 22:16:33', '2024-05-29 22:16:33');

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
