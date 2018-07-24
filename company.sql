-- phpMyAdmin SQL Dump
-- version 4.8.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jul 24, 2018 at 10:51 AM
-- Server version: 10.1.33-MariaDB
-- PHP Version: 7.2.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `company`
--

-- --------------------------------------------------------

--
-- Table structure for table `currencies`
--

CREATE TABLE `currencies` (
  `id` int(11) NOT NULL,
  `type` text NOT NULL,
  `NIS_value` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `currencies`
--

INSERT INTO `currencies` (`id`, `type`, `NIS_value`) VALUES
(1, 'JD', 5),
(2, 'NIS', 1),
(3, 'NIS', 1),
(4, 'UD', 3.5),
(5, 'fc', 6),
(6, 'aa', 3.5);

-- --------------------------------------------------------

--
-- Table structure for table `customers`
--

CREATE TABLE `customers` (
  `id` int(11) NOT NULL,
  `name` text NOT NULL,
  `address` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `customers`
--

INSERT INTO `customers` (`id`, `name`, `address`) VALUES
(1, 'bla bla', 'bla bla bla'),
(2, 'yusef', 'fdfdf'),
(3, 'yusef', 'fdfdf'),
(4, 'yusef', 'fdfdf'),
(5, 'yusef', 'fdfdf'),
(6, 'yusef', 'fdfdf'),
(7, 'yusef', 'fdfdf'),
(8, 'ddfdf', 'dsdsd');

-- --------------------------------------------------------

--
-- Table structure for table `ordered_products`
--

CREATE TABLE `ordered_products` (
  `id` int(11) NOT NULL,
  `name` text NOT NULL,
  `price` double NOT NULL,
  `currency_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `ordered_products`
--

INSERT INTO `ordered_products` (`id`, `name`, `price`, `currency_id`) VALUES
(3, 'laptop1', 100, 3),
(4, 'laptop1', 100, 3),
(5, 'laptop1', 100, 3),
(6, 'aaa', 20, 5);

-- --------------------------------------------------------

--
-- Table structure for table `orders`
--

CREATE TABLE `orders` (
  `id` int(11) NOT NULL,
  `customer_id` int(11) NOT NULL,
  `product_id` int(11) NOT NULL,
  `date` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `orders`
--

INSERT INTO `orders` (`id`, `customer_id`, `product_id`, `date`) VALUES
(10, 5, 3, '8/5/2018'),
(11, 5, 4, '8/5/2018'),
(12, 5, 5, '8/5/2018'),
(13, 1, 6, '8/5/2018');

-- --------------------------------------------------------

--
-- Table structure for table `products`
--

CREATE TABLE `products` (
  `id` int(11) NOT NULL,
  `name` text NOT NULL,
  `price` double NOT NULL,
  `currency_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `products`
--

INSERT INTO `products` (`id`, `name`, `price`, `currency_id`) VALUES
(1, 'fff', 10, 3),
(2, 'klklkl', 5, 3),
(4, 'somthing', 100, 6),
(5, 'aaa', 20, 5),
(6, 'aaaaa', 2, 1),
(7, 'rrr', 100, 6),
(8, 'aaa', 20, 5),
(9, 'aaa', 20, 5),
(10, 'aaa', 20, 5),
(11, 'aaa', 20, 5),
(12, 'aaa', 20, 5),
(13, 'aaa', 20, 5),
(14, 'aaa', 20, 5);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `currencies`
--
ALTER TABLE `currencies`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `customers`
--
ALTER TABLE `customers`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `ordered_products`
--
ALTER TABLE `ordered_products`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK7u8dampuh10q21qhur09elh3t` (`currency_id`);

--
-- Indexes for table `orders`
--
ALTER TABLE `orders`
  ADD PRIMARY KEY (`id`),
  ADD KEY `product_orders` (`product_id`),
  ADD KEY `customer_order` (`customer_id`);

--
-- Indexes for table `products`
--
ALTER TABLE `products`
  ADD PRIMARY KEY (`id`),
  ADD KEY `product_currency` (`currency_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `currencies`
--
ALTER TABLE `currencies`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `customers`
--
ALTER TABLE `customers`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `ordered_products`
--
ALTER TABLE `ordered_products`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `orders`
--
ALTER TABLE `orders`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT for table `products`
--
ALTER TABLE `products`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `ordered_products`
--
ALTER TABLE `ordered_products`
  ADD CONSTRAINT `FK7u8dampuh10q21qhur09elh3t` FOREIGN KEY (`currency_id`) REFERENCES `currencies` (`id`);

--
-- Constraints for table `orders`
--
ALTER TABLE `orders`
  ADD CONSTRAINT `customer_order` FOREIGN KEY (`customer_id`) REFERENCES `customers` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `product_orders` FOREIGN KEY (`product_id`) REFERENCES `ordered_products` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `products`
--
ALTER TABLE `products`
  ADD CONSTRAINT `product_currency` FOREIGN KEY (`currency_id`) REFERENCES `currencies` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
