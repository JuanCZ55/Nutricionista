-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 27-10-2024 a las 00:13:34
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
-- Base de datos: `nutricionista2.0`
--
CREATE DATABASE IF NOT EXISTS `nutricionista2.0` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `nutricionista2.0`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `comidas`
--

CREATE TABLE `comidas` (
  `IdComidas` int(11) NOT NULL,
  `Nombre` varchar(100) NOT NULL,
  `TipoDeComida` varchar(100) NOT NULL,
  `CaloriasTotal` int(11) NOT NULL,
  `Apto` int(11) NOT NULL,
  `Estado` tinyint(1) NOT NULL DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `dieta`
--

CREATE TABLE `dieta` (
  `IdDieta` int(11) NOT NULL,
  `NombreDieta` varchar(100) NOT NULL,
  `FechaInicial` date NOT NULL,
  `FechaFinal` date NOT NULL,
  `TotalCalorias` double NOT NULL,
  `IdPaciente` int(11) NOT NULL,
  `Estado` tinyint(1) NOT NULL DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ingredientes`
--

CREATE TABLE `ingredientes` (
  `IdIngredientes` int(11) NOT NULL,
  `Nombre` varchar(100) NOT NULL,
  `CaloriasPor100` double NOT NULL,
  `Peso` double NOT NULL,
  `NoApto` varchar(100) NOT NULL,
  `Estado` tinyint(1) NOT NULL DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ingredientescomidas`
--

CREATE TABLE `ingredientescomidas` (
  `IdIngredientesComidas` int(11) NOT NULL,
  `IdComidas` int(11) NOT NULL,
  `IdIngredientes` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `menucomidas`
--

CREATE TABLE `menucomidas` (
  `IdMenuComidas` int(11) NOT NULL,
  `IdMenuDiario` int(11) NOT NULL,
  `IdComidas` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `menudiario`
--

CREATE TABLE `menudiario` (
  `IdMenuDiario` int(11) NOT NULL,
  `Dia` int(11) NOT NULL,
  `CaloriasDia` double NOT NULL,
  `IdDieta` int(11) NOT NULL,
  `Estado` tinyint(1) NOT NULL DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `paciente`
--

CREATE TABLE `paciente` (
  `IdPaciente` int(11) NOT NULL,
  `Nombre` varchar(50) NOT NULL,
  `Edad` int(11) NOT NULL,
  `Altura` double NOT NULL,
  `CondicionSalud` varchar(150) NOT NULL,
  `PesoActual` double NOT NULL,
  `PesoBuscado` double NOT NULL,
  `PesoInical` double NOT NULL,
  `Estado` tinyint(1) NOT NULL DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `comidas`
--
ALTER TABLE `comidas`
  ADD PRIMARY KEY (`IdComidas`);

--
-- Indices de la tabla `dieta`
--
ALTER TABLE `dieta`
  ADD PRIMARY KEY (`IdDieta`),
  ADD KEY `IdPaciente` (`IdPaciente`);

--
-- Indices de la tabla `ingredientes`
--
ALTER TABLE `ingredientes`
  ADD PRIMARY KEY (`IdIngredientes`);

--
-- Indices de la tabla `ingredientescomidas`
--
ALTER TABLE `ingredientescomidas`
  ADD PRIMARY KEY (`IdIngredientesComidas`),
  ADD KEY `IdComidas` (`IdComidas`),
  ADD KEY `IdIngredientes` (`IdIngredientes`);

--
-- Indices de la tabla `menucomidas`
--
ALTER TABLE `menucomidas`
  ADD PRIMARY KEY (`IdMenuComidas`),
  ADD KEY `IdMenuDiario` (`IdMenuDiario`),
  ADD KEY `IdComidas` (`IdComidas`);

--
-- Indices de la tabla `menudiario`
--
ALTER TABLE `menudiario`
  ADD PRIMARY KEY (`IdMenuDiario`),
  ADD KEY `IdDieta` (`IdDieta`);

--
-- Indices de la tabla `paciente`
--
ALTER TABLE `paciente`
  ADD PRIMARY KEY (`IdPaciente`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `comidas`
--
ALTER TABLE `comidas`
  MODIFY `IdComidas` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `dieta`
--
ALTER TABLE `dieta`
  MODIFY `IdDieta` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `ingredientes`
--
ALTER TABLE `ingredientes`
  MODIFY `IdIngredientes` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `ingredientescomidas`
--
ALTER TABLE `ingredientescomidas`
  MODIFY `IdIngredientesComidas` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `menucomidas`
--
ALTER TABLE `menucomidas`
  MODIFY `IdMenuComidas` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `menudiario`
--
ALTER TABLE `menudiario`
  MODIFY `IdMenuDiario` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `paciente`
--
ALTER TABLE `paciente`
  MODIFY `IdPaciente` int(11) NOT NULL AUTO_INCREMENT;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `dieta`
--
ALTER TABLE `dieta`
  ADD CONSTRAINT `dieta_ibfk_1` FOREIGN KEY (`IdPaciente`) REFERENCES `paciente` (`IdPaciente`);

--
-- Filtros para la tabla `ingredientescomidas`
--
ALTER TABLE `ingredientescomidas`
  ADD CONSTRAINT `ingredientescomidas_ibfk_1` FOREIGN KEY (`IdComidas`) REFERENCES `comidas` (`IdComidas`),
  ADD CONSTRAINT `ingredientescomidas_ibfk_2` FOREIGN KEY (`IdIngredientes`) REFERENCES `ingredientes` (`IdIngredientes`);

--
-- Filtros para la tabla `menucomidas`
--
ALTER TABLE `menucomidas`
  ADD CONSTRAINT `menucomidas_ibfk_1` FOREIGN KEY (`IdMenuDiario`) REFERENCES `menudiario` (`IdMenuDiario`),
  ADD CONSTRAINT `menucomidas_ibfk_2` FOREIGN KEY (`IdComidas`) REFERENCES `comidas` (`IdComidas`);

--
-- Filtros para la tabla `menudiario`
--
ALTER TABLE `menudiario`
  ADD CONSTRAINT `menudiario_ibfk_1` FOREIGN KEY (`IdDieta`) REFERENCES `dieta` (`IdDieta`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
