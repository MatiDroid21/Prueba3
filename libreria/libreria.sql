-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 24-11-2024 a las 23:12:34
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
-- Base de datos: `libreria`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cliente`
--

CREATE TABLE `cliente` (
  `id_cliente` int(11) NOT NULL,
  `rut` varchar(20) DEFAULT NULL,
  `nomcli` varchar(50) DEFAULT NULL,
  `ap_patcli` varchar(50) DEFAULT NULL,
  `ap_matcli` varchar(50) DEFAULT NULL,
  `direccion` varchar(100) DEFAULT NULL,
  `correo` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `cliente`
--

INSERT INTO `cliente` (`id_cliente`, `rut`, `nomcli`, `ap_patcli`, `ap_matcli`, `direccion`, `correo`) VALUES
(1, '20816014-1', 'Matias', 'Chavez', 'Garay', 'Limahuida 9229', 'mati@gmail.cl'),
(7, '18345672-9', 'Luis', 'Rodriguez', 'Perez', 'Limahioda 9229', 'ddd'),
(8, '12345678-9', 'Marcos', 'Sanchez', 'Martinez', 'las parcelas 1234', 'msan32@gmail.com');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `libro`
--

CREATE TABLE `libro` (
  `codLibro` varchar(100) NOT NULL,
  `isbn` varchar(50) DEFAULT NULL,
  `autor` varchar(50) DEFAULT NULL,
  `titulo` varchar(100) DEFAULT NULL,
  `anio` int(4) DEFAULT NULL,
  `id_libro` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `libro`
--

INSERT INTO `libro` (`codLibro`, `isbn`, `autor`, `titulo`, `anio`, `id_libro`) VALUES
('lb1', 'asd', 'yo', 'milibro', 2010, 1),
('lbl3', 'isbn1', 'no se ', 'Caballero armadura oxidada', 2010, 3);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `venta`
--

CREATE TABLE `venta` (
  `id_venta` int(11) NOT NULL,
  `codVenta` varchar(10) DEFAULT NULL,
  `cliente` varchar(50) NOT NULL,
  `libro` varchar(50) NOT NULL,
  `cantidad` int(11) DEFAULT 1,
  `fecha_venta` date DEFAULT NULL,
  `neto` int(11) DEFAULT NULL,
  `total` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `venta`
--

INSERT INTO `venta` (`id_venta`, `codVenta`, `cliente`, `libro`, `cantidad`, `fecha_venta`, `neto`, `total`) VALUES
(1, 'v01', 'Matias', 'milibro', 2, '2024-11-23', 1500, 1785),
(2, 'v02', 'Marcos', 'Caballero armadura oxidada', 1, '2024-11-23', 1000, 1190),
(3, 'reretre', 'Matias', 'Caballero armadura oxidada', 2, '2024-11-23', 32, 38);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `cliente`
--
ALTER TABLE `cliente`
  ADD PRIMARY KEY (`id_cliente`);

--
-- Indices de la tabla `libro`
--
ALTER TABLE `libro`
  ADD PRIMARY KEY (`id_libro`);

--
-- Indices de la tabla `venta`
--
ALTER TABLE `venta`
  ADD PRIMARY KEY (`id_venta`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `cliente`
--
ALTER TABLE `cliente`
  MODIFY `id_cliente` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT de la tabla `libro`
--
ALTER TABLE `libro`
  MODIFY `id_libro` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `venta`
--
ALTER TABLE `venta`
  MODIFY `id_venta` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
