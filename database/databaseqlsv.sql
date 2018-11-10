-- phpMyAdmin SQL Dump
-- version 4.8.2
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1:3308
-- Thời gian đã tạo: Th10 10, 2018 lúc 02:34 PM
-- Phiên bản máy phục vụ: 10.1.34-MariaDB
-- Phiên bản PHP: 7.2.7

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `databaseqlsv`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `class`
--

CREATE TABLE `class` (
  `idClass` int(10) NOT NULL,
  `className` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `schoolYear` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `idTeacher` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `class`
--

INSERT INTO `class` (`idClass`, `className`, `schoolYear`, `idTeacher`) VALUES
(1, 'CN16A', '2017', 1);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `faculty`
--

CREATE TABLE `faculty` (
  `idFaculty` int(11) NOT NULL,
  `facultyName` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `faculty`
--

INSERT INTO `faculty` (`idFaculty`, `facultyName`) VALUES
(1, 'CNTT');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `student`
--

CREATE TABLE `student` (
  `idStudent` int(11) NOT NULL,
  `studentName` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `yearOfBirth` date NOT NULL,
  `genDer` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `studentAddress` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `studentPhone` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `idClass` int(10) NOT NULL,
  `userName` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `passWord` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `student`
--

INSERT INTO `student` (`idStudent`, `studentName`, `yearOfBirth`, `genDer`, `studentAddress`, `studentPhone`, `idClass`, `userName`, `passWord`) VALUES
(2, 'Tran Van B', '1992-05-03', 'Nam', 'Quận 12', '0938303099', 1, 'tranvanb', 'tranvanb');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `studentscore`
--

CREATE TABLE `studentscore` (
  `idStudent` int(11) NOT NULL,
  `idSubject` int(11) NOT NULL,
  `Score` float DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `studentscore`
--

INSERT INTO `studentscore` (`idStudent`, `idSubject`, `Score`) VALUES
(2, 7, 5.2),
(2, 8, 7),
(2, 9, 5.8),
(2, 10, 5.2),
(2, 12, 7);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `subject`
--

CREATE TABLE `subject` (
  `idSubject` int(10) NOT NULL,
  `subjectName` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `numberCredit` int(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `subject`
--

INSERT INTO `subject` (`idSubject`, `subjectName`, `numberCredit`) VALUES
(7, 'LAP TRINH PHP', 4),
(8, 'LAP TRINH C#', 3),
(9, 'LAP TRINH C#', 3),
(10, 'LAP TRINH C++', 3),
(11, 'LAP TRINH C++', 3),
(12, 'LAP TRINH C++', 3);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `subjectteacher`
--

CREATE TABLE `subjectteacher` (
  `idTeacher` int(11) NOT NULL,
  `idSubject` int(11) NOT NULL,
  `note` text
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `teacher`
--

CREATE TABLE `teacher` (
  `idTeacher` int(11) NOT NULL,
  `teacherName` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `idFaculty` int(11) DEFAULT NULL,
  `userName` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `passWord` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `teacher`
--

INSERT INTO `teacher` (`idTeacher`, `teacherName`, `idFaculty`, `userName`, `passWord`) VALUES
(1, 'Nguyen Van A', 1, 'nguyenvana', '123');

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `class`
--
ALTER TABLE `class`
  ADD PRIMARY KEY (`idClass`);

--
-- Chỉ mục cho bảng `faculty`
--
ALTER TABLE `faculty`
  ADD PRIMARY KEY (`idFaculty`);

--
-- Chỉ mục cho bảng `student`
--
ALTER TABLE `student`
  ADD PRIMARY KEY (`idStudent`);

--
-- Chỉ mục cho bảng `studentscore`
--
ALTER TABLE `studentscore`
  ADD PRIMARY KEY (`idStudent`,`idSubject`),
  ADD KEY `idSubject` (`idSubject`);

--
-- Chỉ mục cho bảng `subject`
--
ALTER TABLE `subject`
  ADD PRIMARY KEY (`idSubject`);

--
-- Chỉ mục cho bảng `subjectteacher`
--
ALTER TABLE `subjectteacher`
  ADD KEY `MAGIANGVIEN` (`idTeacher`),
  ADD KEY `MAMH` (`idSubject`);

--
-- Chỉ mục cho bảng `teacher`
--
ALTER TABLE `teacher`
  ADD PRIMARY KEY (`idTeacher`),
  ADD KEY `MAKHOA` (`idFaculty`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `class`
--
ALTER TABLE `class`
  MODIFY `idClass` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT cho bảng `faculty`
--
ALTER TABLE `faculty`
  MODIFY `idFaculty` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT cho bảng `student`
--
ALTER TABLE `student`
  MODIFY `idStudent` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT cho bảng `subject`
--
ALTER TABLE `subject`
  MODIFY `idSubject` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT cho bảng `teacher`
--
ALTER TABLE `teacher`
  MODIFY `idTeacher` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- Các ràng buộc cho các bảng đã đổ
--

--
-- Các ràng buộc cho bảng `studentscore`
--
ALTER TABLE `studentscore`
  ADD CONSTRAINT `studentscore_ibfk_1` FOREIGN KEY (`idStudent`) REFERENCES `student` (`idStudent`),
  ADD CONSTRAINT `studentscore_ibfk_2` FOREIGN KEY (`idSubject`) REFERENCES `subject` (`idSubject`);

--
-- Các ràng buộc cho bảng `subjectteacher`
--
ALTER TABLE `subjectteacher`
  ADD CONSTRAINT `subjectteacher_ibfk_1` FOREIGN KEY (`idSubject`) REFERENCES `subject` (`idSubject`),
  ADD CONSTRAINT `subjectteacher_ibfk_2` FOREIGN KEY (`idTeacher`) REFERENCES `teacher` (`idTeacher`);

--
-- Các ràng buộc cho bảng `teacher`
--
ALTER TABLE `teacher`
  ADD CONSTRAINT `teacher_ibfk_1` FOREIGN KEY (`idFaculty`) REFERENCES `faculty` (`idFaculty`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
