-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Versión del servidor:         5.6.17 - MySQL Community Server (GPL)
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

-- Volcando estructura para tabla clinica.anteceden_clinico
CREATE TABLE IF NOT EXISTS `anteceden_clinico` (
  `id_paciente` int(11) DEFAULT NULL,
  `id_antecedente_clinico` int(11) DEFAULT NULL,
  `usuario` varchar(45) DEFAULT NULL,
  `observaciones` varchar(200) DEFAULT NULL,
  `respuesta` varchar(200) DEFAULT NULL,
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `created_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  KEY `fk_paciente_idx` (`id_paciente`),
  KEY `fk_antecedente_clinico_idx` (`id_antecedente_clinico`),
  CONSTRAINT `fk_paciente` FOREIGN KEY (`id_paciente`) REFERENCES `paciente` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_antecedente_clinico` FOREIGN KEY (`id_antecedente_clinico`) REFERENCES `tipo_antecedente_clinico` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla clinica.anteceden_clinico: ~0 rows (aproximadamente)

-- Volcando estructura para tabla clinica.aparato_sistemas
CREATE TABLE IF NOT EXISTS `aparato_sistemas` (
  `id_paciente` int(11) DEFAULT NULL,
  `id_aparato_sistema` int(11) DEFAULT NULL,
  `respuesta` int(11) DEFAULT NULL,
  `usuario` varchar(50) DEFAULT NULL,
  `observaciones` varchar(200) DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  KEY `fk_aparato_paciente_idx` (`id_aparato_sistema`),
  KEY `fk_paciente_aparato_idx` (`id_paciente`),
  CONSTRAINT `fk_aparato_paciente` FOREIGN KEY (`id_aparato_sistema`) REFERENCES `tipo_aparato_sistemas` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_paciente_aparato` FOREIGN KEY (`id_paciente`) REFERENCES `paciente` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla clinica.aparato_sistemas: ~0 rows (aproximadamente)

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
	('1841394491007', 1281, 'Hermelindo', NULL, 'López', 'García', NULL, 'Guatemalteco', '1962-12-15', 'Masculino', 86, 17, 'Casado', '2016-10-27', NULL, NULL, NULL, NULL, 'ACTIVO'),
	('1909651341508', 69002, 'Miguel', NULL, 'Juc', 'Caal', NULL, 'Guatemalteco', '1980-05-20', 'Masculino', 176, 5, 'Casado', '2024-05-27', NULL, NULL, NULL, NULL, NULL);

-- Volcando estructura para tabla clinica.examen_fisico
CREATE TABLE IF NOT EXISTS `examen_fisico` (
  `id_paciente` int(11) DEFAULT NULL,
  `id_examen_medico` int(11) DEFAULT NULL,
  `respuesta` varchar(45) DEFAULT NULL,
  `observaciones` varchar(200) DEFAULT NULL,
  `usuario` varchar(45) DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  KEY `fk_paciente_examenes_idx` (`id_examen_medico`),
  KEY `fk_paciente_examen_fisico_idx` (`id_paciente`),
  CONSTRAINT `fk_paciente_examenes` FOREIGN KEY (`id_examen_medico`) REFERENCES `tipo_examen_fisico` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_paciente_examen_fisico` FOREIGN KEY (`id_paciente`) REFERENCES `paciente` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla clinica.examen_fisico: ~0 rows (aproximadamente)

-- Volcando estructura para tabla clinica.examen_laboratorio
CREATE TABLE IF NOT EXISTS `examen_laboratorio` (
  `id_paciente` int(11) DEFAULT NULL,
  `id_examen_lab` int(11) DEFAULT NULL,
  `respuesta` varchar(45) DEFAULT NULL,
  `observaciones` varchar(200) DEFAULT NULL,
  `usuario` varchar(50) DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  KEY `fk_examen_laboratorio_idx` (`id_examen_lab`),
  KEY `fk_paciente_laboratorio_idx` (`id_paciente`),
  CONSTRAINT `fk_paciente_laboratorio` FOREIGN KEY (`id_paciente`) REFERENCES `paciente` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_examen_laboratorio` FOREIGN KEY (`id_examen_lab`) REFERENCES `tipo_examen_laboratorio` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla clinica.examen_laboratorio: ~0 rows (aproximadamente)

-- Volcando estructura para tabla clinica.paciente
CREATE TABLE IF NOT EXISTS `paciente` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `fecha` date DEFAULT NULL,
  `cue` int(11) DEFAULT NULL,
  `id_tipo_examen` int(11) NOT NULL,
  `recomendacion` varchar(200) DEFAULT NULL,
  `apto_laborar` tinyint(1) DEFAULT NULL,
  `fecha_vencimiento` datetime DEFAULT NULL,
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `usuario` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`,`id_tipo_examen`),
  KEY `fk_cue_idx` (`cue`),
  KEY `fk_fecha_paciente` (`fecha`),
  CONSTRAINT `FK_paciente_rrhh.empleado` FOREIGN KEY (`cue`) REFERENCES `rrhh`.`empleado` (`cue`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla clinica.paciente: ~0 rows (aproximadamente)

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
  `id_paciente` int(11) DEFAULT NULL,
  `id_signo_vital` int(11) DEFAULT NULL,
  `respuesta` decimal(18,2) DEFAULT NULL,
  `observaciones` varchar(200) DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `usuario` varchar(50) DEFAULT NULL,
  KEY `fk_paciente_signos_vitales_idx` (`id_signo_vital`),
  KEY `fk_paciente_signos_vitales_idx1` (`id_paciente`),
  CONSTRAINT `fk_paciente_signos_vitales` FOREIGN KEY (`id_signo_vital`) REFERENCES `tipo_signo_vital` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_paciente_signos_vitales_paciente` FOREIGN KEY (`id_paciente`) REFERENCES `paciente` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla clinica.signo_vital: ~0 rows (aproximadamente)

-- Volcando estructura para tabla clinica.tipo_antecedente_clinico
CREATE TABLE IF NOT EXISTS `tipo_antecedente_clinico` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `clave` varchar(45) DEFAULT NULL,
  `descripcion` varchar(100) DEFAULT NULL,
  `estado` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla clinica.tipo_antecedente_clinico: ~0 rows (aproximadamente)

-- Volcando estructura para tabla clinica.tipo_aparato_sistemas
CREATE TABLE IF NOT EXISTS `tipo_aparato_sistemas` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `clave` varchar(45) DEFAULT NULL,
  `descripcion` varchar(100) DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla clinica.tipo_aparato_sistemas: ~0 rows (aproximadamente)

-- Volcando estructura para tabla clinica.tipo_examen_fisico
CREATE TABLE IF NOT EXISTS `tipo_examen_fisico` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `clave` varchar(45) DEFAULT NULL,
  `descripcion` varchar(100) DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla clinica.tipo_examen_fisico: ~0 rows (aproximadamente)

-- Volcando estructura para tabla clinica.tipo_examen_laboratorio
CREATE TABLE IF NOT EXISTS `tipo_examen_laboratorio` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `clave` varchar(45) DEFAULT NULL,
  `descripcion` varchar(100) DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla clinica.tipo_examen_laboratorio: ~0 rows (aproximadamente)

-- Volcando estructura para tabla clinica.tipo_signo_vital
CREATE TABLE IF NOT EXISTS `tipo_signo_vital` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `clave` varchar(45) DEFAULT NULL,
  `descripcion` varchar(50) DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla clinica.tipo_signo_vital: ~0 rows (aproximadamente)

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
