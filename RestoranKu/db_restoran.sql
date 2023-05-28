-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jan 20, 2023 at 12:50 AM
-- Server version: 10.4.24-MariaDB
-- PHP Version: 8.1.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `db_restoran`
--

-- --------------------------------------------------------

--
-- Table structure for table `tb_detail_order`
--

CREATE TABLE `tb_detail_order` (
  `id_detail_order` int(12) NOT NULL,
  `id_order` varchar(12) CHARACTER SET latin1 NOT NULL,
  `id_masakan` varchar(12) CHARACTER SET latin1 NOT NULL,
  `keterangan` varchar(20) CHARACTER SET latin1 NOT NULL,
  `status_detail_order` varchar(25) CHARACTER SET latin1 NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tb_detail_order`
--

INSERT INTO `tb_detail_order` (`id_detail_order`, `id_order`, `id_masakan`, `keterangan`, `status_detail_order`) VALUES
(17, 'ORD-4602', '03', '1', 'Delivery'),
(18, 'ORD-1704', '04', '2', 'Delivery'),
(19, 'ORD-4627', '04', '1', 'Ditempat'),
(20, 'ORD-4808', '02', '1', 'Delivery');

-- --------------------------------------------------------

--
-- Table structure for table `tb_masakan`
--

CREATE TABLE `tb_masakan` (
  `id_masakan` varchar(12) CHARACTER SET latin1 NOT NULL,
  `nama_masakan` varchar(30) CHARACTER SET latin1 NOT NULL,
  `harga` int(20) NOT NULL,
  `status_masakan` varchar(25) CHARACTER SET latin1 NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tb_masakan`
--

INSERT INTO `tb_masakan` (`id_masakan`, `nama_masakan`, `harga`, `status_masakan`) VALUES
('01', 'Nasi Goreng', 12000, 'Tersedia'),
('02', 'Nasi Kucing', 3000, 'Tersedia'),
('03', 'Ikan  Ko', 12000, 'Tersedia'),
('04', 'Ikan Nila Bakar', 15000, 'Tersedia'),
('05', 'Nasi Padang', 13000, 'Kosong');

-- --------------------------------------------------------

--
-- Table structure for table `tb_order`
--

CREATE TABLE `tb_order` (
  `id_order` varchar(12) CHARACTER SET latin1 NOT NULL,
  `no_meja` varchar(12) CHARACTER SET latin1 NOT NULL,
  `tanggal` date NOT NULL,
  `keterangan` text CHARACTER SET latin1 NOT NULL,
  `status_order` varchar(12) CHARACTER SET latin1 NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tb_order`
--

INSERT INTO `tb_order` (`id_order`, `no_meja`, `tanggal`, `keterangan`, `status_order`) VALUES
('ORD-1704', 'null', '2023-01-16', '2', 'Delivery'),
('ORD-4602', 'null', '2023-01-16', '1', 'Delivery'),
('ORD-4627', '003', '2023-01-20', '1', 'Ditempat'),
('ORD-4808', 'null', '2023-01-20', '1', 'Delivery');

-- --------------------------------------------------------

--
-- Table structure for table `tb_transaksi`
--

CREATE TABLE `tb_transaksi` (
  `id_transaksi` int(12) NOT NULL,
  `id_order` varchar(12) CHARACTER SET latin1 NOT NULL,
  `tanggal` date NOT NULL,
  `total_bayar` int(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tb_transaksi`
--

INSERT INTO `tb_transaksi` (`id_transaksi`, `id_order`, `tanggal`, `total_bayar`) VALUES
(5, 'ORD-4602', '2023-01-16', 12000),
(6, 'ORD-4602', '2023-01-16', 12000),
(7, 'ORD-1704', '2023-01-16', 30000),
(8, 'ORD-4627', '2023-01-20', 15000),
(9, 'ORD-4808', '2023-01-20', 3000);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `tb_detail_order`
--
ALTER TABLE `tb_detail_order`
  ADD PRIMARY KEY (`id_detail_order`),
  ADD KEY `id_order` (`id_order`,`id_masakan`),
  ADD KEY `id_masakan` (`id_masakan`);

--
-- Indexes for table `tb_masakan`
--
ALTER TABLE `tb_masakan`
  ADD PRIMARY KEY (`id_masakan`);

--
-- Indexes for table `tb_order`
--
ALTER TABLE `tb_order`
  ADD PRIMARY KEY (`id_order`);

--
-- Indexes for table `tb_transaksi`
--
ALTER TABLE `tb_transaksi`
  ADD PRIMARY KEY (`id_transaksi`),
  ADD KEY `id_user` (`id_order`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `tb_detail_order`
--
ALTER TABLE `tb_detail_order`
  MODIFY `id_detail_order` int(12) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

--
-- AUTO_INCREMENT for table `tb_transaksi`
--
ALTER TABLE `tb_transaksi`
  MODIFY `id_transaksi` int(12) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `tb_detail_order`
--
ALTER TABLE `tb_detail_order`
  ADD CONSTRAINT `tb_detail_order_ibfk_1` FOREIGN KEY (`id_order`) REFERENCES `tb_order` (`id_order`),
  ADD CONSTRAINT `tb_detail_order_ibfk_2` FOREIGN KEY (`id_masakan`) REFERENCES `tb_masakan` (`id_masakan`);

--
-- Constraints for table `tb_transaksi`
--
ALTER TABLE `tb_transaksi`
  ADD CONSTRAINT `tb_transaksi_ibfk_2` FOREIGN KEY (`id_order`) REFERENCES `tb_order` (`id_order`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
