-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 09, 2023 at 04:41 AM
-- Server version: 10.4.28-MariaDB
-- PHP Version: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `absensimahasiswa`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `Username` varchar(20) NOT NULL,
  `Password` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`Username`, `Password`) VALUES
('Hello', '#ello123');

-- --------------------------------------------------------

--
-- Table structure for table `dosen`
--

CREATE TABLE `dosen` (
  `NIDN` varchar(20) NOT NULL,
  `Nama` varchar(50) NOT NULL,
  `MataKuliah` varchar(80) NOT NULL,
  `JurusanMengajar` varchar(50) NOT NULL,
  `Hadir` int(35) NOT NULL,
  `Sakit` int(35) NOT NULL,
  `Izin` int(35) NOT NULL,
  `Alpha` int(35) NOT NULL,
  `JamMasuk` varchar(20) NOT NULL,
  `JamKeluar` varchar(20) NOT NULL,
  `Tanggal` varchar(20) NOT NULL,
  `TanggalTidakHadir` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `dosen`
--

INSERT INTO `dosen` (`NIDN`, `Nama`, `MataKuliah`, `JurusanMengajar`, `Hadir`, `Sakit`, `Izin`, `Alpha`, `JamMasuk`, `JamKeluar`, `Tanggal`, `TanggalTidakHadir`) VALUES
('062230701544', 'Husnawaty', 'Pengantar IoT', 'D3 Teknik komputer', 1, 0, 0, 0, '13.00', '14.00', '08-12-2023', '-');

-- --------------------------------------------------------

--
-- Table structure for table `mahasiswa`
--

CREATE TABLE `mahasiswa` (
  `NIM` varchar(20) NOT NULL,
  `Nama` varchar(100) NOT NULL,
  `Kelas` varchar(5) NOT NULL,
  `Jurusan` varchar(20) NOT NULL,
  `Keterangan` char(4) NOT NULL,
  `Tanggal` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `mahasiswa`
--

INSERT INTO `mahasiswa` (`NIM`, `Nama`, `Kelas`, `Jurusan`, `Keterangan`, `Tanggal`) VALUES
('062230701544', 'Bagus Ananta H', '3cm', 'D3 Tekkom', 'H', '12-11-2023');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`Username`);

--
-- Indexes for table `dosen`
--
ALTER TABLE `dosen`
  ADD PRIMARY KEY (`NIDN`);

--
-- Indexes for table `mahasiswa`
--
ALTER TABLE `mahasiswa`
  ADD PRIMARY KEY (`NIM`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
