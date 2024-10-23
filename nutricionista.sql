-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 24-10-2024 a las 01:48:58
-- Versión del servidor: 10.4.32-MariaDB
-- Versión de PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `nutricionista`
--
CREATE DATABASE IF NOT EXISTS `nutricionista` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `nutricionista`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `alimento`
--

CREATE TABLE `alimento` (
  `idAlimento` int(11) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `tipoComida` varchar(50) NOT NULL,
  `caloriasX100gr` int(11) NOT NULL,
  `detalle` varchar(150) NOT NULL,
  `estado` tinyint(1) NOT NULL DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `dieta`
--

CREATE TABLE `dieta` (
  `idDieta` int(11) NOT NULL,
  `nombreD` varchar(60) NOT NULL,
  `idMenu` int(11) NOT NULL,
  `idPaciente` int(11) NOT NULL,
  `fechaIni` date NOT NULL,
  `fechaFin` date NOT NULL,
  `pesoInicial` double NOT NULL,
  `pesoFinal` double NOT NULL,
  `totalCalorias` int(11) NOT NULL,
  `estado` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `menudiario`
--

CREATE TABLE `menudiario` (
  `idMenu` int(11) NOT NULL,
  `dia` int(11) NOT NULL,
  `idRenglon` int(11) NOT NULL,
  `caloriasDelMenu` int(11) NOT NULL,
  `estado` tinyint(1) NOT NULL,
  `idDieta` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `paciente`
--

CREATE TABLE `paciente` (
  `idPaciente` int(11) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `edad` int(11) NOT NULL,
  `altura` double NOT NULL,
  `pesoActual` double NOT NULL,
  `pesoBuscado` double NOT NULL,
  `estado` tinyint(1) NOT NULL DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `paciente`
--

INSERT INTO `paciente` (`idPaciente`, `nombre`, `edad`, `altura`, `pesoActual`, `pesoBuscado`, `estado`) VALUES
(1, 'Ariel', 21, 1.54, 900, 70.3, 1),
(2, 'Raul', 3, 0.5, 73, 150.6, 1),
(3, 'Raul', 2, 0.45, 8, 6.5, 1),
(4, 'Juan', 25, 1.8, 72, 85.3, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `renglondemenu`
--

CREATE TABLE `renglondemenu` (
  `idRenglon` int(11) NOT NULL,
  `idAlimento` int(11) NOT NULL,
  `cantidadGrs` double NOT NULL,
  `subtotalCalorias` int(11) NOT NULL,
  `idMenu` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `alimento`
--
ALTER TABLE `alimento`
  ADD PRIMARY KEY (`idAlimento`);

--
-- Indices de la tabla `dieta`
--
ALTER TABLE `dieta`
  ADD PRIMARY KEY (`idDieta`),
  ADD KEY `idMenu` (`idMenu`),
  ADD KEY `idPaciente` (`idPaciente`);

--
-- Indices de la tabla `menudiario`
--
ALTER TABLE `menudiario`
  ADD PRIMARY KEY (`idMenu`),
  ADD KEY `idRenglon` (`idRenglon`),
  ADD KEY `idDieta` (`idDieta`);

--
-- Indices de la tabla `paciente`
--
ALTER TABLE `paciente`
  ADD PRIMARY KEY (`idPaciente`);

--
-- Indices de la tabla `renglondemenu`
--
ALTER TABLE `renglondemenu`
  ADD PRIMARY KEY (`idRenglon`),
  ADD KEY `idAlimento` (`idAlimento`),
  ADD KEY `idMenu` (`idMenu`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `alimento`
--
ALTER TABLE `alimento`
  MODIFY `idAlimento` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `dieta`
--
ALTER TABLE `dieta`
  MODIFY `idDieta` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `menudiario`
--
ALTER TABLE `menudiario`
  MODIFY `idMenu` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `paciente`
--
ALTER TABLE `paciente`
  MODIFY `idPaciente` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `renglondemenu`
--
ALTER TABLE `renglondemenu`
  MODIFY `idRenglon` int(11) NOT NULL AUTO_INCREMENT;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `alimento`
--
ALTER TABLE `alimento`
  ADD CONSTRAINT `alimento_ibfk_1` FOREIGN KEY (`idAlimento`) REFERENCES `renglondemenu` (`idAlimento`);

--
-- Filtros para la tabla `dieta`
--
ALTER TABLE `dieta`
  ADD CONSTRAINT `dieta_ibfk_1` FOREIGN KEY (`idPaciente`) REFERENCES `paciente` (`idPaciente`);

--
-- Filtros para la tabla `menudiario`
--
ALTER TABLE `menudiario`
  ADD CONSTRAINT `menudiario_ibfk_1` FOREIGN KEY (`idDieta`) REFERENCES `dieta` (`idDieta`);

--
-- Filtros para la tabla `renglondemenu`
--
ALTER TABLE `renglondemenu`
  ADD CONSTRAINT `renglondemenu_ibfk_1` FOREIGN KEY (`idMenu`) REFERENCES `menudiario` (`idMenu`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
