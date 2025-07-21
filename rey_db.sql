-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 21-07-2025 a las 19:19:52
-- Versión del servidor: 10.4.17-MariaDB
-- Versión de PHP: 8.0.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `rey_db`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `articulo`
--

CREATE TABLE `articulo` (
  `id` bigint(20) NOT NULL,
  `nombre` varchar(255) NOT NULL,
  `precio` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `articulo`
--

INSERT INTO `articulo` (`id`, `nombre`, `precio`) VALUES
(1, 'keyboard mecanico genius', 35700),
(3, 'auriculares sony', 67000),
(4, 'galaxy A 20', 455000),
(10, 'playstation 5', 1200000),
(12, 'mouse gamer', 50000);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cliente`
--

CREATE TABLE `cliente` (
  `id` bigint(20) NOT NULL,
  `nombre` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `telefono` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `cliente`
--

INSERT INTO `cliente` (`id`, `nombre`, `email`, `telefono`) VALUES
(1, 'lomachenko', 'loma@gmail.com', '11122233'),
(2, 'roy jones', 'roy@gmail.com', '117778888999'),
(3, 'shakur stevenson', 'shakur@mail.com', NULL),
(10, 'shakur stevenson', 'floyd@gmail.com', NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pedido`
--

CREATE TABLE `pedido` (
  `id` bigint(20) NOT NULL,
  `fecha` datetime DEFAULT NULL,
  `cliente_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `pedido`
--

INSERT INTO `pedido` (`id`, `fecha`, `cliente_id`) VALUES
(14, '2025-07-16 19:49:11', 1),
(15, '2025-07-17 15:45:51', 3);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pedido_articulo`
--

CREATE TABLE `pedido_articulo` (
  `id` bigint(20) NOT NULL,
  `cantidad` int(11) NOT NULL,
  `articulo_id` bigint(20) NOT NULL,
  `pedido_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `pedido_articulo`
--

INSERT INTO `pedido_articulo` (`id`, `cantidad`, `articulo_id`, `pedido_id`) VALUES
(24, 2, 1, 14),
(25, 2, 3, 14),
(26, 1, 1, 15),
(27, 2, 3, 15),
(28, 3, 4, 15);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `articulo`
--
ALTER TABLE `articulo`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `cliente`
--
ALTER TABLE `cliente`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `email` (`email`);

--
-- Indices de la tabla `pedido`
--
ALTER TABLE `pedido`
  ADD PRIMARY KEY (`id`),
  ADD KEY `cliente_id` (`cliente_id`);

--
-- Indices de la tabla `pedido_articulo`
--
ALTER TABLE `pedido_articulo`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKkax26138toihkiww2akkpk73i` (`articulo_id`),
  ADD KEY `FK1gq0scwvbghp998v6ddxs17oj` (`pedido_id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `articulo`
--
ALTER TABLE `articulo`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT de la tabla `cliente`
--
ALTER TABLE `cliente`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT de la tabla `pedido`
--
ALTER TABLE `pedido`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- AUTO_INCREMENT de la tabla `pedido_articulo`
--
ALTER TABLE `pedido_articulo`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=33;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `pedido`
--
ALTER TABLE `pedido`
  ADD CONSTRAINT `pedido_ibfk_1` FOREIGN KEY (`cliente_id`) REFERENCES `cliente` (`id`) ON DELETE CASCADE;

--
-- Filtros para la tabla `pedido_articulo`
--
ALTER TABLE `pedido_articulo`
  ADD CONSTRAINT `FK1gq0scwvbghp998v6ddxs17oj` FOREIGN KEY (`pedido_id`) REFERENCES `pedido` (`id`),
  ADD CONSTRAINT `FKkax26138toihkiww2akkpk73i` FOREIGN KEY (`articulo_id`) REFERENCES `articulo` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
