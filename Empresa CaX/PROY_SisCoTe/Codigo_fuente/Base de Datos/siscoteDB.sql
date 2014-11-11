-- phpMyAdmin SQL Dump
-- version 3.5.2.2
-- http://www.phpmyadmin.net
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 11-11-2014 a las 06:25:29
-- Versión del servidor: 5.5.27
-- Versión de PHP: 5.4.7

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de datos: `siscote`
--
CREATE DATABASE `siscote` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `siscote`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `autor`
--

CREATE TABLE IF NOT EXISTS `autor` (
  `idAutor` int(11) NOT NULL AUTO_INCREMENT,
  `Codigo` varchar(45) NOT NULL,
  `Nombre` varchar(45) NOT NULL,
  `ApellidoPaterno` varchar(45) NOT NULL,
  `ApellidoMaterno` varchar(45) NOT NULL,
  `GradoAcademico` varchar(45) NOT NULL,
  PRIMARY KEY (`idAutor`),
  UNIQUE KEY `idAutor_UNIQUE` (`idAutor`),
  UNIQUE KEY `Codigo_UNIQUE` (`Codigo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `categoria`
--

CREATE TABLE IF NOT EXISTS `categoria` (
  `idCategoria` int(11) NOT NULL AUTO_INCREMENT,
  `Codigo` varchar(45) NOT NULL,
  `Nombre` varchar(45) NOT NULL,
  `Descripcion` varchar(45) NOT NULL,
  PRIMARY KEY (`idCategoria`),
  UNIQUE KEY `idCategoria_UNIQUE` (`idCategoria`),
  UNIQUE KEY `Codigo_UNIQUE` (`Codigo`),
  UNIQUE KEY `Nombre_UNIQUE` (`Nombre`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `documento`
--

CREATE TABLE IF NOT EXISTS `documento` (
  `idDocumento` int(11) NOT NULL AUTO_INCREMENT,
  `Codigo` varchar(45) NOT NULL,
  `Titulo` varchar(45) NOT NULL,
  `Estado` tinyint(1) NOT NULL,
  `FechaPublicacion` datetime NOT NULL,
  `Especialidad_idEspecialidad` int(11) NOT NULL,
  `Categoria_idCategoria` int(11) NOT NULL,
  PRIMARY KEY (`idDocumento`),
  UNIQUE KEY `idDocumento_UNIQUE` (`idDocumento`),
  UNIQUE KEY `Codigo_UNIQUE` (`Codigo`),
  UNIQUE KEY `Titulo_UNIQUE` (`Titulo`),
  KEY `fk_Documento_Especialidad1_idx` (`Especialidad_idEspecialidad`),
  KEY `fk_Documento_Categoria1_idx` (`Categoria_idCategoria`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `documento_has_autor`
--

CREATE TABLE IF NOT EXISTS `documento_has_autor` (
  `Documento_idDocumento` int(11) NOT NULL,
  `Autor_idAutor` int(11) NOT NULL,
  PRIMARY KEY (`Documento_idDocumento`,`Autor_idAutor`),
  KEY `fk_Documento_has_Autor_Autor1_idx` (`Autor_idAutor`),
  KEY `fk_Documento_has_Autor_Documento1_idx` (`Documento_idDocumento`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `documento_has_tema`
--

CREATE TABLE IF NOT EXISTS `documento_has_tema` (
  `Documento_idDocumento` int(11) NOT NULL,
  `Tema_idTema` int(11) NOT NULL,
  PRIMARY KEY (`Documento_idDocumento`,`Tema_idTema`),
  KEY `fk_Documento_has_Tema_Tema1_idx` (`Tema_idTema`),
  KEY `fk_Documento_has_Tema_Documento1_idx` (`Documento_idDocumento`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `especialidad`
--

CREATE TABLE IF NOT EXISTS `especialidad` (
  `idEspecialidad` int(11) NOT NULL AUTO_INCREMENT,
  `Codigo` varchar(45) NOT NULL,
  `Nombre` varchar(45) NOT NULL,
  `Descripcion` varchar(45) NOT NULL,
  PRIMARY KEY (`idEspecialidad`),
  UNIQUE KEY `idEspecialidad_UNIQUE` (`idEspecialidad`),
  UNIQUE KEY `Codigo_UNIQUE` (`Codigo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `roles`
--

CREATE TABLE IF NOT EXISTS `roles` (
  `idRoles` int(11) NOT NULL AUTO_INCREMENT,
  `Codigo` varchar(45) NOT NULL,
  `Descripcion` varchar(45) NOT NULL,
  PRIMARY KEY (`idRoles`),
  UNIQUE KEY `idRoles_UNIQUE` (`idRoles`),
  UNIQUE KEY `COdigo_UNIQUE` (`Codigo`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=6 ;

--
-- Volcado de datos para la tabla `roles`
--

INSERT INTO `roles` (`idRoles`, `Codigo`, `Descripcion`) VALUES
(3, 'Bibliotecario', 'Encargado de administrar los documentos'),
(4, 'Administrador', 'Administra cualquier parte del sistema'),
(5, 'Usuario', 'Usuario regular que solo consulta');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tema`
--

CREATE TABLE IF NOT EXISTS `tema` (
  `idTema` int(11) NOT NULL AUTO_INCREMENT,
  `Codigo` varchar(45) NOT NULL,
  `Nombre` varchar(45) NOT NULL,
  `Descripcion` varchar(45) NOT NULL,
  PRIMARY KEY (`idTema`),
  UNIQUE KEY `idTema_UNIQUE` (`idTema`),
  UNIQUE KEY `Codigo_UNIQUE` (`Codigo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE IF NOT EXISTS `usuario` (
  `idUsuario` int(11) NOT NULL AUTO_INCREMENT,
  `Codigo` varchar(45) NOT NULL,
  `Username` varchar(45) NOT NULL,
  `Password` varchar(45) NOT NULL,
  `Nombres` varchar(45) NOT NULL,
  `ApellidoPaterno` varchar(45) NOT NULL,
  `ApellidoMaterno` varchar(45) NOT NULL,
  `Estado` tinyint(1) NOT NULL,
  `Roles_idRoles` int(11) NOT NULL,
  PRIMARY KEY (`idUsuario`),
  UNIQUE KEY `idUsuario_UNIQUE` (`idUsuario`),
  UNIQUE KEY `Username_UNIQUE` (`Username`),
  UNIQUE KEY `Password_UNIQUE` (`Password`),
  UNIQUE KEY `COdigo_UNIQUE` (`Codigo`),
  KEY `fk_Usuario_Roles_idx` (`Roles_idRoles`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=6 ;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`idUsuario`, `Codigo`, `Username`, `Password`, `Nombres`, `ApellidoPaterno`, `ApellidoMaterno`, `Estado`, `Roles_idRoles`) VALUES
(3, '10200054', 'andxxi', 'pikachu', 'Andre', 'Calderon', 'Maguiña', 1, 3),
(4, '10200216', 'akira', '123', 'akira', 'tabuchi', 'yagui', 0, 4),
(5, '09200152', 'lilirafer', '456', 'liliana', 'ramirez', 'fernandez', 1, 5);

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `documento`
--
ALTER TABLE `documento`
  ADD CONSTRAINT `fk_Documento_Categoria1` FOREIGN KEY (`Categoria_idCategoria`) REFERENCES `categoria` (`idCategoria`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Documento_Especialidad1` FOREIGN KEY (`Especialidad_idEspecialidad`) REFERENCES `especialidad` (`idEspecialidad`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `documento_has_autor`
--
ALTER TABLE `documento_has_autor`
  ADD CONSTRAINT `fk_Documento_has_Autor_Autor1` FOREIGN KEY (`Autor_idAutor`) REFERENCES `autor` (`idAutor`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Documento_has_Autor_Documento1` FOREIGN KEY (`Documento_idDocumento`) REFERENCES `documento` (`idDocumento`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `documento_has_tema`
--
ALTER TABLE `documento_has_tema`
  ADD CONSTRAINT `fk_Documento_has_Tema_Documento1` FOREIGN KEY (`Documento_idDocumento`) REFERENCES `documento` (`idDocumento`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Documento_has_Tema_Temasiscote1` FOREIGN KEY (`Tema_idTema`) REFERENCES `tema` (`idTema`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD CONSTRAINT `fk_Usuario_Roles` FOREIGN KEY (`Roles_idRoles`) REFERENCES `roles` (`idRoles`) ON DELETE NO ACTION ON UPDATE NO ACTION;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
