-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 14-11-2024 a las 20:30:56
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
  `CaloriasComida` double NOT NULL,
  `NoApto` varchar(150) NOT NULL,
  `Estado` tinyint(1) NOT NULL DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `comidas`
--

INSERT INTO `comidas` (`IdComidas`, `Nombre`, `TipoDeComida`, `CaloriasComida`, `NoApto`, `Estado`) VALUES
(1, 'Pollo con arroz blanco', 'Cena', 382, 'Diabetes', 1),
(2, 'Pollo con ensalada fresca', 'Cena', 497.2, '', 1),
(3, 'Ensalda de frutas', 'Colacion', 62.9, '', 1),
(4, 'Sanguche integral de pavo con mayonesa', 'Almuerzo', 389.7, 'Hipertension,Celiaca', 1),
(5, 'Matambre de cerdo con pure de papa (sin sal)', 'Cena', 1550.6, 'Diabetes,Hipertension', 1),
(6, 'Frutas secas', 'Colacion', 325, 'Diabetes', 1),
(7, 'Pizza Especial', 'Cena', 971.5, 'Hipertension,Celiaca', 1),
(8, 'Yogur con tostada con mermelada', 'Desayuno', 441.6, 'Diabetes,Celiaca', 1),
(9, 'Yogur con tostada con palta', 'Desayuno', 434, 'Celiaca', 1),
(10, 'Yogur natural con tostada de pan integral con palta', 'Desayuno', 465.8, 'Celiaca', 1),
(11, 'Marinera de cerdo con ensalada', 'Almuerzo', 511.9, 'Celiaca', 1),
(12, 'Café con leche y pan con huevo revuelto con palta', 'Desayuno', 498.3, 'Celiaca', 1),
(13, 'Zumo de manzana con sanguche de jamon con queso', 'Desayuno', 446.3, 'Hipertension,Celiaca', 1),
(14, 'Pechuga de pollo con ensalda cruda', 'Cena', 446.8, '', 1),
(15, 'Pollo asado con ensalda cruda', 'Cena', 631.8, '', 1),
(16, 'Pollo asado con pure de papa con leche de almendras', 'Cena', 722.9, 'Diabetes', 1),
(17, 'Pollo asado con ensalda rusa', 'Cena', 801.65, 'Diabetes', 1),
(18, 'Pechuga de pllo con ensalada rusa', 'Cena', 616.65, 'Diabetes', 1),
(19, 'Tortilla de papa (sin sal)', 'Cena', 370.3, 'Diabetes', 1),
(20, 'Omelte de queso y atun', 'Desayuno', 496, '', 1),
(21, 'Arroz integral con atun (sin sal)', 'Almuerzo', 404.1, '', 1),
(22, 'Avena con leche de almendras', 'Desayuno', 392.6, 'Diabetes', 1),
(23, 'Salchicon con ensaldada cruda', 'Almuerzo', 842.7, 'Hipertension', 1),
(24, 'Pollo asado con ensalda de remolacha con huevo', 'Almuerzo', 658.1, 'Diabetes', 1),
(25, 'Tostada de pan blanco con mantequilla', 'Colacion', 249.4, 'Hipertension,Celiaca', 1),
(26, 'Aceitunas con zumo de piña', 'Colacion', 108.4, 'Hipertension', 1),
(27, 'Licuado de manzana y leche de almendras', 'Colacion', 63.8, '', 1),
(28, 'Licuado de fresa con leche de almendra', 'Colacion', 45.8, '', 1),
(29, 'Yogur grigo con arandanos secos', 'Colacion', 311.4, 'Diabetes', 1),
(30, 'Licuado de sandia con leche entera', 'Colacion', 84.9, '', 1),
(31, 'Te negro con pan integral con mermelada', 'Merienda', 334.4, 'Diabetes,Celiaca', 1),
(32, 'Te verde con pan integral con mantequilla', 'Merienda', 464.1, 'Hipertension,Celiaca', 1),
(33, 'Yogur natural con pasas', 'Merienda', 357.2, 'Diabetes', 1),
(34, 'Frutas', 'Merienda', 140, '', 1);

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

--
-- Volcado de datos para la tabla `dieta`
--

INSERT INTO `dieta` (`IdDieta`, `NombreDieta`, `FechaInicial`, `FechaFinal`, `TotalCalorias`, `IdPaciente`, `Estado`) VALUES
(1, 'Dieta baja de peso', '2000-05-05', '2000-05-05', 5977.450000000001, 13654789, 1),
(2, 'Dieta Roja', '2024-11-01', '2024-11-30', 6087.8, 30856902, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ingredientes`
--

CREATE TABLE `ingredientes` (
  `IdIngredientes` int(11) NOT NULL,
  `Nombre` varchar(100) NOT NULL,
  `CaloriasPor100` double NOT NULL,
  `NoApto` varchar(100) NOT NULL,
  `Estado` tinyint(1) NOT NULL DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `ingredientes`
--

INSERT INTO `ingredientes` (`IdIngredientes`, `Nombre`, `CaloriasPor100`, `NoApto`, `Estado`) VALUES
(1, 'Tomate', 18, ' ', 1),
(2, 'Pepino', 16, ' ', 1),
(3, 'Zanahoria', 41, ' ', 1),
(4, 'Lechuga', 14, ' ', 1),
(5, 'Espinaca', 23, ' ', 1),
(6, 'Papa', 77, 'Diabetes', 1),
(7, 'Maíz', 86, 'Diabetes', 1),
(8, 'Calabacín', 17, ' ', 1),
(9, 'Aguacate', 160, ' ', 1),
(10, 'Aceituna', 115, 'Hipertension', 1),
(11, 'Champiñones', 22, ' ', 1),
(12, 'Cebolla', 40, ' ', 1),
(13, 'Ajo', 149, ' ', 1),
(14, 'Brócoli', 34, ' ', 1),
(15, 'Coliflor', 25, ' ', 1),
(16, 'Repollo', 25, ' ', 1),
(17, 'Remolacha', 43, 'Diabetes', 1),
(18, 'Pimiento rojo', 31, ' ', 1),
(19, 'Pimiento verde', 20, ' ', 1),
(20, 'Berenjena', 24, ' ', 1),
(21, 'Calabaza', 26, ' ', 1),
(22, 'Nabo', 28, ' ', 1),
(23, 'Batata', 86, 'Diabetes', 1),
(24, 'Manzana', 52, ' ', 1),
(25, 'Plátano', 89, 'Diabetes', 1),
(26, 'Naranja', 47, ' ', 1),
(27, 'Fresa', 32, ' ', 1),
(28, 'Cereza', 50, ' ', 1),
(29, 'Pera', 57, ' ', 1),
(30, 'Uva', 69, 'Diabetes', 1),
(31, 'Kiwi', 61, '', 1),
(32, 'Mango', 60, 'Diabetes', 1),
(33, 'Piña', 50, '', 1),
(34, 'Melón', 34, '', 1),
(35, 'Sandía', 30, '', 1),
(36, 'Higo', 74, 'Diabetes', 1),
(37, 'Ciruela', 46, '', 1),
(38, 'Almendra', 579, 'Hipertension', 1),
(39, 'Nuez', 654, 'Hipertension', 1),
(40, 'Avellana', 628, 'Hipertension', 1),
(41, 'Castaña', 213, '', 1),
(42, 'Maní', 567, 'Hipertension', 1),
(43, 'Semillas de girasol', 584, 'Hipertension', 1),
(44, 'Semillas de calabaza', 446, 'Hipertension', 1),
(45, 'Coco rallado', 354, '', 1),
(46, 'Harina de trigo', 364, 'Celiaca', 1),
(47, 'Harina de maíz', 361, '', 1),
(48, 'Arroz blanco', 130, 'Diabetes', 1),
(49, 'Arroz integral', 111, '', 1),
(50, 'Quinoa', 120, '', 1),
(51, 'Avena', 389, 'Diabetes', 1),
(52, 'Trigo sarraceno', 343, '', 1),
(53, 'Pan blanco', 265, 'Celiaca', 1),
(54, 'Pan integral', 247, 'Celiaca', 1),
(55, 'Pasta de trigo', 131, 'Celiaca', 1),
(56, 'Pasta integral', 124, 'Celiaca', 1),
(57, 'Harina de almendra', 570, 'Hipertension', 1),
(58, 'Aceite de oliva', 884, '', 1),
(59, 'Aceite de girasol', 884, '', 1),
(60, 'Aceite de coco', 862, '', 1),
(61, 'Mantequilla', 717, 'Hipertension', 1),
(62, 'Margarina', 717, 'Hipertension', 1),
(63, 'Yogur natural', 59, '', 1),
(64, 'Yogur griego', 97, '', 1),
(65, 'Leche entera', 61, '', 1),
(66, 'Leche descremada', 42, '', 1),
(67, 'Queso cheddar', 402, 'Hipertension', 1),
(68, 'Queso mozzarella', 280, '', 1),
(69, 'Queso fresco', 72, '', 1),
(70, 'Queso de cabra', 364, 'Hipertension', 1),
(71, 'Huevo', 155, '', 1),
(72, 'Clara de huevo', 52, '', 1),
(73, 'Pollo asado', 239, '', 1),
(74, 'Pechuga de pollo', 165, '', 1),
(75, 'Muslo de pollo', 209, '', 1),
(76, 'Carne de res', 250, '', 1),
(77, 'Carne de cerdo', 242, '', 1),
(78, 'Jamón cocido', 145, 'Hipertension', 1),
(79, 'Jamón serrano', 241, 'Hipertension', 1),
(80, 'Chorizo', 455, 'Hipertension', 1),
(81, 'Salchichón', 410, 'Hipertension', 1),
(82, 'Pavo asado', 104, '', 1),
(83, 'Pescado blanco', 96, '', 1),
(84, 'Pescado azul', 206, '', 1),
(85, 'Atún enlatado', 132, '', 1),
(86, 'Sardinas en aceite', 208, 'Hipertension', 1),
(87, 'Salmón', 208, '', 1),
(88, 'Trucha', 168, '', 1),
(89, 'Bacalao', 82, '', 1),
(90, 'Gamba', 99, '', 1),
(91, 'Calamar', 175, '', 1),
(92, 'Pulpo', 82, '', 1),
(93, 'Mejillón', 172, '', 1),
(94, 'Langosta', 89, '', 1),
(95, 'Galletas saladas', 471, 'Celiaca', 1),
(96, 'Galletas dulces', 502, 'Diabetes', 1),
(97, 'Miel', 304, 'Diabetes', 1),
(98, 'Mermelada', 278, 'Diabetes', 1),
(99, 'Azúcar', 387, 'Diabetes', 1),
(100, 'Stevia', 0, '', 1),
(101, 'Jarabe de arce', 260, 'Diabetes', 1),
(102, 'Chocolate negro', 546, 'Diabetes', 1),
(103, 'Chocolate con leche', 535, 'Diabetes', 1),
(104, 'Caramelo', 382, 'Diabetes', 1),
(105, 'Helado de vainilla', 207, 'Diabetes', 1),
(106, 'Pastel de chocolate', 370, 'Diabetes', 1),
(107, 'Pastel de manzana', 265, '', 1),
(108, 'Tarta de queso', 321, 'Diabetes', 1),
(109, 'Flan de huevo', 146, '', 1),
(110, 'Gelatina', 62, '', 1),
(111, 'Bizcocho', 298, 'Celiaca', 1),
(112, 'Croissant', 406, 'Celiaca', 1),
(113, 'Donuts', 452, 'Diabetes', 1),
(114, 'Pizza de queso', 266, 'Celiaca', 1),
(115, 'Pizza de pepperoni', 298, 'Celiaca', 1),
(116, 'Empanada de carne', 252, 'Celiaca', 1),
(117, 'Lentejas cocidas', 116, '', 1),
(118, 'Garbanzos cocidos', 164, '', 1),
(119, 'Frijoles negros', 132, '', 1),
(120, 'Soja', 446, '', 1),
(121, 'Tofu', 76, '', 1),
(122, 'Edamame', 121, '', 1),
(123, 'Tempeh', 193, '', 1),
(124, 'Carne de soja', 296, '', 1),
(125, 'Tallarines de arroz', 109, '', 1),
(126, 'Sushi', 140, 'Hipertension', 1),
(127, 'Fideos de huevo', 138, 'Celiaca', 1),
(128, 'Tallarines de trigo', 131, 'Celiaca', 1),
(129, 'Pan de pita', 275, 'Celiaca', 1),
(130, 'Tortilla de harina', 306, 'Celiaca', 1),
(131, 'Tortilla de maíz', 218, '', 1),
(132, 'Polenta', 70, '', 1),
(133, 'Falafel', 333, '', 1),
(134, 'Hummus', 166, '', 1),
(135, 'Guacamole', 150, '', 1),
(136, 'Tzatziki', 85, '', 1),
(137, 'Salsa de tomate', 29, '', 1),
(138, 'Ketchup', 112, 'Diabetes', 1),
(139, 'Mostaza', 66, '', 1),
(140, 'Mayonesa', 680, 'Hipertension', 1),
(141, 'Salsa de soja', 53, 'Hipertension', 1),
(142, 'Salsa barbacoa', 117, 'Diabetes', 1),
(143, 'Pesto', 303, '', 1),
(144, 'Salsa Alfredo', 517, 'Hipertension', 1),
(145, 'Aceitunas negras', 115, 'Hipertension', 1),
(146, 'Aceitunas verdes', 145, 'Hipertension', 1),
(147, 'Anchoas', 131, 'Hipertension', 1),
(148, 'Pimientos en conserva', 22, '', 1),
(149, 'Pepinillos en vinagre', 11, 'Hipertension', 1),
(150, 'Mantequilla de maní', 588, 'Hipertension', 1),
(151, 'Tahini', 595, '', 1),
(152, 'Nata líquida', 292, 'Hipertension', 1),
(153, 'Crema agria', 193, '', 1),
(154, 'Leche de almendra', 17, '', 1),
(155, 'Leche de coco', 230, '', 1),
(156, 'Leche de soja', 33, '', 1),
(157, 'Leche de avena', 47, '', 1),
(158, 'Batata cocida', 76, 'Diabetes', 1),
(159, 'Ñame cocido', 118, 'Diabetes', 1),
(160, 'Yuca', 160, 'Diabetes', 1),
(161, 'Platano maduro', 122, 'Diabetes', 1),
(162, 'Fruta deshidratada', 325, 'Diabetes', 1),
(163, 'Pasas', 299, 'Diabetes', 1),
(164, 'Arándanos secos', 325, 'Diabetes', 1),
(165, 'Dátiles', 277, 'Diabetes', 1),
(166, 'Higos secos', 249, 'Diabetes', 1),
(167, 'Almendras tostadas', 579, 'Hipertension', 1),
(168, 'Pistachos', 562, 'Hipertension', 1),
(169, 'Piñones', 673, 'Hipertension', 1),
(170, 'Castañas cocidas', 131, '', 1),
(171, 'Cacao en polvo', 228, 'Diabetes', 1),
(172, 'Infusión de manzanilla', 1, '', 1),
(173, 'Té verde', 1, '', 1),
(174, 'Té negro', 2, '', 1),
(175, 'Café negro', 2, '', 1),
(176, 'Café con leche', 26, '', 1),
(177, 'Café descafeinado', 0, '', 1),
(178, 'Agua mineral', 0, '', 1),
(179, 'Agua con gas', 0, '', 1),
(180, 'Soda', 41, 'Diabetes', 1),
(181, 'Refresco de cola', 42, 'Diabetes', 1),
(182, 'Refresco de limón', 45, 'Diabetes', 1),
(183, 'Zumo de naranja', 45, '', 1),
(184, 'Zumo de manzana', 46, '', 1),
(185, 'Zumo de arándano', 46, '', 1),
(186, 'Zumo de piña', 48, '', 1),
(187, 'Zumo de pomelo', 39, '', 1),
(188, 'Cerveza', 43, 'Hipertension', 1),
(189, 'Vino tinto', 85, 'Hipertension', 1),
(190, 'Vino blanco', 82, 'Hipertension', 1),
(191, 'Sidra', 50, '', 1),
(192, 'Ron', 231, 'Hipertension', 1),
(193, 'Vodka', 231, 'Hipertension', 1),
(194, 'Whisky', 250, 'Hipertension', 1),
(195, 'Ginebra', 263, 'Hipertension', 1),
(196, 'Tónica', 34, '', 1),
(197, 'Sangría', 81, 'Hipertension', 1),
(198, 'Cocktail Margarita', 168, 'Hipertension', 1),
(199, 'Cocktail Mojito', 242, 'Hipertension', 1),
(200, 'Cocktail Piña Colada', 226, 'Hipertension', 1),
(201, 'Batido de frutas', 90, '', 1),
(202, 'Smoothie verde', 60, '', 1),
(203, 'Zumo de zanahoria', 40, '', 1),
(204, 'Zumo de remolacha', 43, '', 1),
(205, 'Horchata', 70, '', 1),
(206, 'Leche malteada', 109, 'Diabetes', 1),
(207, 'Prepizza', 110, 'Celiaca', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ingredientescomidas`
--

CREATE TABLE `ingredientescomidas` (
  `IdIngredientesComidas` int(11) NOT NULL,
  `IdComidas` int(11) NOT NULL,
  `IdIngredientes` int(11) NOT NULL,
  `peso` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `ingredientescomidas`
--

INSERT INTO `ingredientescomidas` (`IdIngredientesComidas`, `IdComidas`, `IdIngredientes`, `peso`) VALUES
(1, 1, 48, 40),
(2, 1, 74, 200),
(6, 2, 1, 30),
(7, 2, 3, 20),
(8, 2, 4, 40),
(9, 2, 73, 200),
(15, 3, 35, 40),
(16, 3, 37, 30),
(17, 3, 24, 20),
(18, 3, 27, 30),
(19, 3, 29, 30),
(30, 6, 162, 100),
(31, 6, 178, 50),
(36, 7, 1, 50),
(37, 7, 68, 200),
(38, 7, 78, 50),
(39, 7, 207, 300),
(40, 8, 98, 20),
(41, 8, 53, 90),
(42, 8, 63, 250),
(43, 9, 53, 90),
(44, 9, 9, 30),
(45, 9, 63, 250),
(46, 10, 54, 90),
(47, 10, 9, 60),
(48, 10, 63, 250),
(49, 11, 178, 50),
(50, 11, 3, 90),
(51, 11, 4, 20),
(52, 11, 77, 150),
(53, 11, 46, 30),
(54, 4, 1, 30),
(55, 4, 82, 150),
(56, 4, 4, 20),
(57, 4, 54, 50),
(58, 4, 140, 15),
(59, 12, 176, 150),
(60, 12, 54, 90),
(61, 12, 71, 60),
(62, 12, 9, 90),
(63, 13, 69, 40),
(64, 13, 53, 90),
(65, 13, 184, 200),
(66, 13, 78, 60),
(67, 5, 68, 30),
(68, 5, 6, 200),
(69, 5, 77, 350),
(70, 5, 61, 40),
(71, 5, 13, 120),
(72, 14, 1, 40),
(73, 14, 3, 30),
(74, 14, 4, 20),
(75, 14, 74, 250),
(76, 14, 12, 30),
(77, 15, 1, 40),
(78, 15, 3, 30),
(79, 15, 4, 20),
(80, 15, 73, 250),
(81, 15, 12, 30),
(82, 16, 6, 150),
(83, 16, 73, 250),
(84, 16, 156, 30),
(85, 17, 3, 45),
(86, 17, 6, 60),
(87, 17, 71, 90),
(88, 17, 73, 250),
(89, 18, 3, 45),
(90, 18, 6, 60),
(91, 18, 71, 90),
(92, 18, 74, 250),
(93, 19, 6, 200),
(94, 19, 71, 110),
(95, 19, 12, 40),
(96, 19, 13, 20),
(97, 20, 68, 40),
(98, 20, 85, 150),
(99, 20, 71, 120),
(100, 21, 49, 150),
(101, 21, 85, 180),
(102, 22, 51, 90),
(103, 22, 154, 250),
(104, 23, 81, 200),
(105, 23, 1, 40),
(106, 23, 4, 25),
(107, 23, 12, 30),
(108, 24, 17, 150),
(109, 24, 71, 90),
(110, 24, 73, 190),
(111, 25, 53, 40),
(112, 25, 61, 20),
(113, 26, 10, 40),
(114, 26, 186, 130),
(115, 27, 24, 90),
(116, 27, 154, 100),
(117, 28, 154, 100),
(118, 28, 27, 90),
(119, 29, 64, 120),
(120, 29, 164, 60),
(121, 30, 65, 90),
(122, 30, 35, 100),
(123, 31, 98, 30),
(124, 31, 54, 100),
(125, 31, 174, 200),
(126, 32, 54, 100),
(127, 32, 61, 30),
(128, 32, 173, 200),
(129, 33, 163, 80),
(130, 33, 63, 200),
(131, 34, 26, 100),
(132, 34, 27, 100),
(133, 34, 31, 100);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `menucomidas`
--

CREATE TABLE `menucomidas` (
  `IdMenuComidas` int(11) NOT NULL,
  `IdMenuDiario` int(11) NOT NULL,
  `IdComidas` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `menucomidas`
--

INSERT INTO `menucomidas` (`IdMenuComidas`, `IdMenuDiario`, `IdComidas`) VALUES
(31, 7, 11),
(32, 7, 1),
(33, 7, 29),
(34, 7, 10),
(35, 7, 33),
(36, 8, 21),
(37, 8, 15),
(38, 8, 3),
(39, 8, 12),
(40, 8, 31),
(41, 9, 21),
(42, 9, 17),
(43, 9, 30),
(44, 9, 22),
(45, 9, 31),
(46, 10, 11),
(47, 10, 15),
(48, 10, 27),
(49, 10, 20),
(50, 10, 34),
(51, 11, 11),
(52, 11, 7),
(53, 11, 25),
(54, 11, 13),
(55, 11, 34),
(56, 12, 4),
(57, 12, 2),
(58, 12, 26),
(59, 12, 10),
(60, 12, 32);

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

--
-- Volcado de datos para la tabla `menudiario`
--

INSERT INTO `menudiario` (`IdMenuDiario`, `Dia`, `CaloriasDia`, `IdDieta`, `Estado`) VALUES
(7, 1, 2028.3, 1, 1),
(8, 2, 1931.5, 1, 1),
(9, 3, 2017.65, 1, 1),
(10, 1, 1843.4999999999998, 2, 1),
(11, 2, 2319.1000000000004, 2, 1),
(12, 3, 1925.1999999999998, 2, 1);

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
-- Volcado de datos para la tabla `paciente`
--

INSERT INTO `paciente` (`IdPaciente`, `Nombre`, `Edad`, `Altura`, `CondicionSalud`, `PesoActual`, `PesoBuscado`, `PesoInical`, `Estado`) VALUES
(10356894, 'Franco Gimenez', 35, 1.68, 'Celiaca', 77, 77, 77, 1),
(11356728, 'Alberto Vega', 62, 1.83, 'Celiaca', 79.6, 90, 79.6, 1),
(12987432, 'Cintia Dominguez', 38, 1.6, '', 64, 64, 64, 1),
(13654789, 'Nicolas Suarez', 24, 1.77, 'Hipertension', 83, 83, 83, 1),
(14753290, 'Carolina Rivas', 44, 1.6, 'Celiaca', 49, 60, 49, 1),
(15987654, 'Kevin Lara', 18, 1.76, '', 82, 82, 82, 1),
(16827634, 'Pablo Muñoz', 27, 1.77, 'Hipertension', 70, 65, 70, 1),
(17654321, 'Sergio Gil', 54, 1.8, 'Diabetes', 89.1, 81, 89.1, 1),
(18456172, 'Teresa Paredez', 43, 1.7, 'Diabetes,Hipertension,Celiaca', 92.4, 70, 92.4, 0),
(19345671, 'Rocio Perez', 36, 1.56, '', 62, 62, 62, 1),
(20451567, 'Sofia Ledesma', 27, 1.65, '', 66, 66, 66, 1),
(21987345, 'Facundo Lucero', 19, 1.72, 'Diabetes,Hipertension', 80, 80, 80, 1),
(22456128, 'Gabriela Mercedez', 72, 1.54, '', 61, 61, 61, 1),
(23675812, 'Cristian Lucero', 43, 1.68, 'Diabetes,Hipertension', 77, 77, 77, 1),
(24965231, 'Isabel Cruz', 30, 1.55, 'Celiaca', 48, 57, 48, 1),
(25431987, 'Andrés Romero', 44, 1.76, '', 71.3, 79, 71.3, 1),
(26872315, 'Raquel Morales', 38, 1.64, '', 44, 52, 44, 1),
(27564128, 'David Rodríguez', 53, 1.71, 'Diabetes,Hipertension', 59, 52, 59, 1),
(28763409, 'Clara Ortega', 25, 1.58, 'Celiaca', 59, 52, 59, 1),
(29654721, 'Javier Hernández', 41, 1.76, 'Hipertension', 85, 77, 85, 1),
(30856902, 'Lucía Sánchez', 34, 1.67, 'Diabetes,Hipertension,Celiaca', 77.2, 70, 77.2, 1),
(31457628, 'Ricardo Morales', 49, 1.82, 'Diabetes,Hipertension,Celiaca', 110.6, 95, 110.6, 1),
(32348751, 'Sofía Torres', 23, 1.59, 'Hipertension', 55, 50, 55, 1),
(33029846, 'Pedro Martínez', 60, 1.78, 'Diabetes,Celiaca', 95.3, 85, 95.3, 1),
(34572610, 'Elena García', 56, 160, 'Diabetes,Hipertension', 75.5, 68, 75.5, 1),
(35281937, 'Michael ', 39, 1.73, 'Diabetes', 80, 72, 80, 1);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `comidas`
--
ALTER TABLE `comidas`
  ADD PRIMARY KEY (`IdComidas`),
  ADD UNIQUE KEY `Nombre` (`Nombre`);

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
  ADD PRIMARY KEY (`IdIngredientes`),
  ADD UNIQUE KEY `Nombre` (`Nombre`);

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
  MODIFY `IdComidas` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=35;

--
-- AUTO_INCREMENT de la tabla `dieta`
--
ALTER TABLE `dieta`
  MODIFY `IdDieta` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `ingredientes`
--
ALTER TABLE `ingredientes`
  MODIFY `IdIngredientes` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=208;

--
-- AUTO_INCREMENT de la tabla `ingredientescomidas`
--
ALTER TABLE `ingredientescomidas`
  MODIFY `IdIngredientesComidas` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=134;

--
-- AUTO_INCREMENT de la tabla `menucomidas`
--
ALTER TABLE `menucomidas`
  MODIFY `IdMenuComidas` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=61;

--
-- AUTO_INCREMENT de la tabla `menudiario`
--
ALTER TABLE `menudiario`
  MODIFY `IdMenuDiario` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT de la tabla `paciente`
--
ALTER TABLE `paciente`
  MODIFY `IdPaciente` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=35281938;

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
