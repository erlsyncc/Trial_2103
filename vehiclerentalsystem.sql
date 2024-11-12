-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Nov 12, 2024 at 06:28 AM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `vehiclerentalsystem`
--

-- --------------------------------------------------------

--
-- Table structure for table `charges`
--

CREATE TABLE `charges` (
  `chargeID` int(11) NOT NULL,
  `reservationID` int(5) NOT NULL,
  `charge` decimal(10,0) NOT NULL,
  `lateFee` int(10) NOT NULL,
  `repairFee` int(10) NOT NULL,
  `damageFee` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `clients details`
--

CREATE TABLE `clients details` (
  `ClientID` int(10) NOT NULL,
  `FirstName` varchar(50) NOT NULL,
  `LastName` varchar(50) NOT NULL,
  `Address` varchar(200) NOT NULL,
  `ContactNumber` varchar(15) NOT NULL,
  `Email` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `payment`
--

CREATE TABLE `payment` (
  `PaymentID` int(10) NOT NULL,
  `Date` date NOT NULL,
  `amount` decimal(10,2) NOT NULL,
  `Status` enum('Pending','Complete','Failed','') NOT NULL,
  `PaymentMethod` enum('Credit Card','Cash','Check','') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `rentalcontract`
--

CREATE TABLE `rentalcontract` (
  `contractID` int(5) NOT NULL,
  `rentalOwnerSignature` varchar(50) NOT NULL,
  `rentalUserSignature` varchar(50) NOT NULL,
  `dateOfAgreement` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `rentalform`
--

CREATE TABLE `rentalform` (
  `rentalFormID` int(10) NOT NULL,
  `clientID` int(10) NOT NULL,
  `vehicleID` int(10) NOT NULL,
  `paymentID` int(10) NOT NULL,
  `rentalContractID` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `services`
--

CREATE TABLE `services` (
  `ServiceID` int(11) NOT NULL,
  `rentalFormID` int(11) NOT NULL,
  `driverName` varchar(100) NOT NULL,
  `assistantName` varchar(100) NOT NULL,
  `carSeatType` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `vehicle`
--

CREATE TABLE `vehicle` (
  `VehicleID` int(5) NOT NULL,
  `VehicleType` enum('Car','SUV','Van','Truck','Motorcycle') NOT NULL,
  `VehicleStatus` enum('Available','Rented','Under Maintenance','') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `vehiclecar`
--

CREATE TABLE `vehiclecar` (
  `carID` int(5) NOT NULL,
  `vehicleID` int(11) NOT NULL,
  `carModel` varchar(50) NOT NULL,
  `carDescription` text NOT NULL,
  `plateNumber` varchar(20) NOT NULL,
  `carCapacity` int(11) NOT NULL,
  `carPrice` decimal(12,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `vehiclereservreciept`
--

CREATE TABLE `vehiclereservreciept` (
  `reservationID` int(5) NOT NULL,
  `rentalFormID` int(10) NOT NULL,
  `reservationDate` date NOT NULL,
  `rentalStart` date NOT NULL,
  `rentralEnd` date NOT NULL,
  `pickUpLocation` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `charges`
--
ALTER TABLE `charges`
  ADD PRIMARY KEY (`chargeID`);

--
-- Indexes for table `clients details`
--
ALTER TABLE `clients details`
  ADD PRIMARY KEY (`ClientID`);

--
-- Indexes for table `payment`
--
ALTER TABLE `payment`
  ADD PRIMARY KEY (`PaymentID`);

--
-- Indexes for table `rentalcontract`
--
ALTER TABLE `rentalcontract`
  ADD PRIMARY KEY (`contractID`);

--
-- Indexes for table `rentalform`
--
ALTER TABLE `rentalform`
  ADD PRIMARY KEY (`rentalFormID`);

--
-- Indexes for table `services`
--
ALTER TABLE `services`
  ADD PRIMARY KEY (`ServiceID`);

--
-- Indexes for table `vehicle`
--
ALTER TABLE `vehicle`
  ADD PRIMARY KEY (`VehicleID`);

--
-- Indexes for table `vehiclecar`
--
ALTER TABLE `vehiclecar`
  ADD PRIMARY KEY (`carID`),
  ADD UNIQUE KEY `plateNum` (`plateNumber`);

--
-- Indexes for table `vehiclereservreciept`
--
ALTER TABLE `vehiclereservreciept`
  ADD PRIMARY KEY (`reservationID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `charges`
--
ALTER TABLE `charges`
  MODIFY `chargeID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `clients details`
--
ALTER TABLE `clients details`
  MODIFY `ClientID` int(10) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `payment`
--
ALTER TABLE `payment`
  MODIFY `PaymentID` int(10) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `rentalcontract`
--
ALTER TABLE `rentalcontract`
  MODIFY `contractID` int(5) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `rentalform`
--
ALTER TABLE `rentalform`
  MODIFY `rentalFormID` int(10) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `services`
--
ALTER TABLE `services`
  MODIFY `ServiceID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `vehicle`
--
ALTER TABLE `vehicle`
  MODIFY `VehicleID` int(5) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `vehiclecar`
--
ALTER TABLE `vehiclecar`
  MODIFY `carID` int(5) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `vehiclereservreciept`
--
ALTER TABLE `vehiclereservreciept`
  MODIFY `reservationID` int(5) NOT NULL AUTO_INCREMENT;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
