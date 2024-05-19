-- Active: 1704807633484@@127.0.0.1@3306@quanlycuahang
-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th5 12, 2024 lúc 07:51 AM
-- Phiên bản máy phục vụ: 10.4.28-MariaDB
-- Phiên bản PHP: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";

SELECT * FROM ngk WHERE `maNGK` LIKE '%%' AND `maNB` LIKE '%0%' AND giabanle BETWEEN 10000 AND 20000;

SELECT * FROM hoadon WHERE ngaylap BETWEEN '2024-01-01' AND '2024-05-01';

SELECT * FROM taikhoan  WHERE `trangThai`=1

SELECT ngk.`maNGK`, ngk.`tenNGK`, SUM(chitietphieunhap.`soLuong`) as totalQuantity, SUM(phieunhap.`tongTien`) as totalPrice, SUM(chitietphieunhap.`soLuong`)/SUM(phieunhap.`tongTien`) as price 
FROM phieunhap INNER JOIN chitietphieunhap ON phieunhap.`maPN` = chitietphieunhap.`maPN` INNER JOIN ngk ON ngk.`maNGK` = chitietphieunhap.`maSP`
GROUP BY ngk.`maNGK`, ngk.`tenNGK`

  SELECT * FROM phieunhap WHERE `maPN` LIKE '%p%'


SELECT ngk.`maNGK`, ngk.`tenNGK`, SUM(chitietphieunhap.`soLuong`) as totalQuantity, SUM(phieunhap.`tongTien`) as totalPrice, SUM(chitietphieunhap.`soLuong`)/SUM(phieunhap.`tongTien`) as price 
FROM phieunhap INNER JOIN chitietphieunhap ON phieunhap.`maPN` = chitietphieunhap.`maPN` INNER JOIN ngk ON ngk.`maNGK` = chitietphieunhap.`maSP`
WHERE  YEAR(phieunhap.`ngayNhap`) =0
GROUP BY ngk.`maNGK`, ngk.`tenNGK`

SELECT 
    ngk.`maNGK`, 
    ngk.`tenNGK`, 
    SUM(chitietphieunhap.`soLuong`) as totalQuantity, 
    SUM(phieunhap.`tongTien`) as totalPrice, 
    SUM(chitietphieunhap.`soLuong`) / NULLIF(SUM(phieunhap.`tongTien`), 0) as price 
FROM 
    phieunhap 
INNER JOIN 
    chitietphieunhap ON phieunhap.`maPN` = chitietphieunhap.`maPN` 
INNER JOIN 
    ngk ON ngk.`maNGK` = chitietphieunhap.`maSP`
GROUP BY 
    ngk.`maNGK`, 
    ngk.`tenNGK`


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `quanlycuahang`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `chitietphieunhap`
--

CREATE TABLE `chitietphieunhap` (
  `maPN` varchar(10) NOT NULL,
  `maSP` varchar(5) NOT NULL,
  `soLuong` int(11) DEFAULT NULL,
  `donGia` decimal(10,2) DEFAULT NULL,
  `thanhTien` decimal(10,2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `chitietphieunhap`
--

INSERT INTO `chitietphieunhap` (`maPN`, `maSP`, `soLuong`, `donGia`, `thanhTien`) VALUES
('pn001', 'ngk01', 100, 6000.00, 600000.00),
('pn002', 'ngk02', 200, 23000.00, 4600000.00),
('pn002', 'ngk03', 150, 10000.00, 1500000.00),
('pn003', 'ngk01', 50, 6000.00, 300000.00),
('pn003', 'ngk02', 100, 23000.00, 2300000.00),
('pn004', 'ngk04', 150, 18400.00, 2760000.00),
('pn004', 'ngk05', 100, 31000.00, 3100000.00),
('pn005', 'ngk03', 200, 10000.00, 2000000.00),
('pn006', 'ngk02', 120, 23000.00, 2760000.00),
('pn006', 'ngk04', 80, 25300.00, 2024000.00),
('pn007', 'ngk01', 150, 6000.00, 900000.00),
('pn007', 'ngk03', 100, 20700.00, 2070000.00),
('pn008', 'ngk01', 200, 6000.00, 1200000.00),
('pn008', 'ngk02', 150, 23000.00, 3450000.00),
('pn009', 'ngk03', 300, 10000.00, 3000000.00),
('pn009', 'ngk04', 200, 9000.00, 1800000.00),
('pn010', 'ngk02', 100, 23000.00, 2300000.00),
('pn010', 'ngk03', 150, 10000.00, 1500000.00),
('pn011', 'ngk01', 120, 10000.00, 1200000.00),
('pn011', 'ngk05', 80, 31000.00, 2480000.00),
('pn012', 'ngk02', 150, 23000.00, 3450000.00),
('pn012', 'ngk03', 200, 10000.00, 2000000.00),
('pn013', 'ngk01', 180, 6000.00, 1080000.00),
('pn013', 'ngk04', 220, 9000.00, 1980000.00),
('pn014', 'ngk02', 180, 23000.00, 4140000.00),
('pn014', 'ngk05', 120, 31000.00, 3720000.00),
('pn015', 'ngk01', 160, 9800.00, 1568000.00),
('pn015', 'ngk03', 140, 10000.00, 1400000.00),
('pn001', 'ngk03', 100, 10000.00, 1000000.00),
('pn005', 'ngk01', 150, 6000.00, 900000.00),
('pn002', 'ngk04', 100, 9000.00, 900000.00),
('pn016', 'ngk12', 100, 40000.00, 4000000.00),
('pn017', 'ngk06', 200, 8000.00, 1600000.00),
('pn016', 'ngk07', 130, 10000.00, 1300000.00),
('pn017', 'ngk08', 420, 11000.00, 4620000.00),
('pn018', 'ngk09', 230, 60000.00, 13800000.00),
('pn018', 'ngk10', 250, 14000.00, 3500000.00),
('pn018', 'ngk11', 300, 10000.00, 3000000.00),
('pn017', 'ngk12', 500, 40000.00, 20000000.00),
('pn019', 'ngk13', 160, 19000.00, 3040000.00),
('pn019', 'ngk14', 400, 37000.00, 14800000.00),
('pn019', 'ngk15', 600, 37000.00, 22200000.00),
('pn020', 'ngk16', 650, 37000.00, 24050000.00),
('pn020', 'ngk12', 350, 40000.00, 14000000.00),
('pn001', 'ngk13', 1000, 19000.00, 19000000.00),
('pn015', 'ngk07', 1360, 10000.00, 13600000.00),
('pn020', 'ngk09', 550, 60000.00, 33000000.00),
('pn016', 'ngk10', 650, 14000.00, 9100000.00),
('pn021', 'ngk08', 5, 11000.00, 55000.00),
('pn022', 'ngk08', 40, 11000.00, 440000.00),
('pn023', 'ngk01', 100, 6000.00, 600000.00),
('pn024', 'ngk01', 100, 6000.00, 600000.00),
('pn025', 'ngk01', 100, 6000.00, 600000.00),
('pn026', 'ngk01', 1000, 6000.00, 6000000.00),
('pn026', 'ngk02', 100, 23000.00, 2300000.00);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `chucvu`
--

CREATE TABLE `chucvu` (
  `ma` varchar(20) NOT NULL,
  `ten` varchar(50) DEFAULT NULL,
  `moTa` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `chucvu`
--

INSERT INTO `chucvu` (`ma`, `ten`, `moTa`) VALUES
('admin', 'Người quản trị', 'Chức vụ cao nhất trong tổ chức, có quyền hạn cao nhất và chịu trách nhiệm về quản lý và ra quyết định trong các vấn đề quan trọng.'),
('giamdoc', 'Quản lý doanh nghiệp', 'Chức vụ cao nhất trong doanh nghiệp, có quyền hạn tối cao và chịu trách nhiệm về quản lý toàn bộ hoạt động của doanh nghiệp.'),
('khachhang', 'Khách hàng', 'Chức vụ đại diện cho khách hàng, người mua sản phẩm.'),
('nguoiban', 'Người bán', 'Chức vụ đại diện cho nhân viên bán hàng, người thực hiện giao dịch mua bán sản phẩm.'),
('quanlykho', 'Quản lý kho', 'Chức vụ đại diện cho nhân viên quản lý và kiểm soát hàng tồn kho trong cửa hàng hoặc kho hàng.');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `ctgiohang`
--

CREATE TABLE `ctgiohang` (
  `maCTGH` varchar(5) NOT NULL,
  `maNGK` varchar(5) DEFAULT NULL,
  `soluong` int(11) DEFAULT NULL,
  `thanhtien` mediumtext DEFAULT NULL,
  `maGH` varchar(5) DEFAULT NULL,
  `tinhTrang` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `cthoadon`
--

CREATE TABLE `cthoadon` (
  `maCTHD` varchar(5) NOT NULL,
  `maKH` varchar(20) DEFAULT NULL,
  `maNGK` varchar(5) DEFAULT NULL,
  `soluong` int(11) DEFAULT NULL,
  `thanhtien` mediumtext DEFAULT NULL,
  `soHD` varchar(5) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `cthoadon`
--

INSERT INTO `cthoadon` (`maCTHD`, `maKH`, `maNGK`, `soluong`, `thanhtien`, `soHD`) VALUES
('c0001', 'nam0001', 'ngk01', 10, '60000', 'hd001'),
('c0002', 'nam0001', 'ngk03', 10, '100000', 'hd001'),
('c0003', 'nam0001', 'ngk07', 10, '100000', 'hd001'),
('c0004', 'dung0002', 'ngk04', 21, '189000', 'hd002'),
('c0005', 'dung0002', 'ngk07', 17, '170000', 'hd002'),
('c0006', 'thuy0003', 'ngk10', 18, '252000', 'hd003'),
('c0007', 'dung0002', 'ngk02', 2, '46000', 'hd004'),
('c0008', 'dung0002', 'ngk04', 3, '27000', 'hd004'),
('c0009', 'dung0002', 'ngk06', 2, '16000', 'hd004'),
('c0010', 'nhan0004', 'ngk12', 7, '280000', 'hd005'),
('c0011', 'le0005', 'ngk08', 10, '110000', 'hd006'),
('c0012', 'le0005', 'ngk03', 10, '100000', 'hd006'),
('c0013', 'le0005', 'ngk05', 10, '310000', 'hd006'),
('c0014', 'van0006', 'ngk07', 3, '30000', 'hd007'),
('c0015', 'van0006', 'ngk09', 4, '240000', 'hd007'),
('c0016', 'van0006', 'ngk11', 5, '50000', 'hd007'),
('c0017', 'hung0007', 'ngk11', 30, '300000', 'hd008'),
('c0018', 'luc0008', 'ngk04', 3, '27000', 'hd009'),
('c0019', 'luc0008', 'ngk05', 2, '62000', 'hd009'),
('c0020', 'trang0009', 'ngk08', 10, '110000', 'hd010'),
('c0021', 'chau0010', 'ngk04', 12, '108000', 'hd011'),
('c0022', 'thuy0003', 'ngk01', 100, '600000', 'hd012'),
('c0023', 'yen0011', 'ngk02', 3, '69000', 'hd013'),
('c0024', 'yen0011', 'ngk03', 4, '40000', 'hd013'),
('c0025', 'yen0011', 'ngk04', 3, '27000', 'hd013'),
('c0026', 'nhan0004', 'ngk06', 7, '56000', 'hd014'),
('c0027', 'le0005', 'ngk07', 8, '80000', 'hd015'),
('c0028', 'anh0012', 'ngk03', 12, '120000', 'hd016'),
('c0029', 'phat0013', 'ngk11', 7, '70000', 'hd017'),
('c0030', 'phat0013', 'ngk12', 7, '280000', 'hd017'),
('c0031', 'tien0014', 'ngk05', 4, '124000', 'hd018'),
('c0032', 'tien0014', 'ngk09', 5, '300000', 'hd019'),
('c0033', 'lam0015', 'ngk01', 3, '18000', 'hd020'),
('c0034', 'lam0015', 'ngk11', 3, '30000', 'hd020'),
('c0035', 'chau0010', 'ngk04', 10, '90000', 'hd021'),
('c0036', 'trang0009', 'ngk04', 10, '90000', 'hd022'),
('c0037', 'nhan0004', 'ngk01', 100, '600000', 'hd023'),
('c0038', 'nhan0004', 'ngk02', 17, '391000', 'hd023'),
('c0039', 'nhan0004', 'ngk06', 17, '136000', 'hd023'),
('c0040', 'nhan0004', 'ngk07', 21, '210000', 'hd023'),
('c0041', 'nhan0004', 'ngk09', 21, '1260000', 'hd023'),
('c0042', 'hai0016', 'ngk03', 15, '150000', 'hd024'),
('c0043', 'hai0016', 'ngk04', 15, '135000', 'hd024'),
('c0044', 'hai0016', 'ngk08', 15, '165000', 'hd024'),
('c0045', 'nam0001', 'ngk03', 3, '30000', 'hd025'),
('c0046', 'nam0001', 'ngk01', 5, '30000', 'hd026'),
('c0047', 'nam0001', 'ngk08', 5, '55000', 'hd027'),
('c0048', 'nam0001', 'ngk01', 4, '24000', 'hd028'),
('c0049', 'nam0001', 'ngk10', 10, '140000', 'hd028'),
('c0050', 'nam0001', 'ngk05', 5, '155000', 'hd028'),
('c0051', 'nam0001', 'ngk05', 5, '155000', 'hd028'),
('c0052', 'nam0001', 'ngk04', 2, '18000', 'hd028'),
('c0053', 'nam0001', 'ngk03', 2, '20000', 'hd029'),
('c0054', 'nam0001', 'ngk10', 15, '210000', 'hd030'),
('c0055', 'nam0001', 'ngk08', 10, '110000', 'hd030'),
('c0056', 'nam0001', 'ngk14', 20, '740000', 'hd030'),
('c0057', 'nam0001', 'ngk13', 20, '380000', 'hd030'),
('c0058', 'nam0001', 'ngk01', 96, '576000', 'hd031'),
('c0059', 'nam0001', 'ngk01', 96, '576000', 'hd031'),
('c0060', 'nam0001', 'ngk03', 12, '120000', 'hd031'),
('c0061', 'nam0001', 'ngk05', 10, '310000', 'hd031'),
('c0062', 'nam0001', 'ngk02', 58, '1334000', 'hd032');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `giohang`
--

CREATE TABLE `giohang` (
  `maGH` varchar(5) NOT NULL,
  `maKH` varchar(20) DEFAULT NULL,
  `soluonghang` int(11) DEFAULT NULL,
  `tongtien` mediumtext DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `giohang`
--

INSERT INTO `giohang` (`maGH`, `maKH`, `soluonghang`, `tongtien`) VALUES
('gh001', 'nam0001', 0, '0'),
('gh002', 'dung0002', 0, '0'),
('gh003', 'thuy0003', 0, '0'),
('gh004', 'nhan0004', 0, '0'),
('gh005', 'le0005', 0, '0'),
('gh007', 'hung0007', 0, '0'),
('gh008', 'luc0008', 0, '0'),
('gh009', 'trang0009', 0, '0'),
('gh010', 'chau0010', 0, '0'),
('gh011', 'yen0011', 0, '0'),
('gh012', 'anh0012', 0, '0'),
('gh013', 'phat0013', 0, '0'),
('gh014', 'tien0014', 0, '0'),
('gh015', 'lam0015', 0, '0'),
('gh016', 'hai0016', 0, '0'),
('gh017', 'nguyen0017', 0, '0'),
('gh018', 'hau0018', 0, '0'),
('gh019', 'loc0019', 0, '0'),
('gh020', 'huy0020', 0, '0'),
('gh021', 'khanh111', 1, '120000'),
('gh022', 'khanh123', 0, '0'),
('gh023', 'kh0020', 0, '0');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `hangsx`
--

CREATE TABLE `hangsx` (
  `maHSX` varchar(5) NOT NULL,
  `tenHSX` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `hangsx`
--

INSERT INTO `hangsx` (`maHSX`, `tenHSX`) VALUES
('coca', 'The Coca-Cola Compan'),
('mbc', 'Monster Beverage Cor'),
('ppico', 'PepsiCo'),
('redbg', 'Red Bull GmbH'),
('rock', 'Rockstar, Inc'),
('sport', 'VPX Sports'),
('starc', 'Starbucks Corporatio');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `hoadon`
--

CREATE TABLE `hoadon` (
  `soHD` varchar(5) NOT NULL,
  `ngaylap` date DEFAULT NULL,
  `tongtien` mediumtext DEFAULT NULL,
  `maKH` varchar(20) DEFAULT NULL,
  `trangThai` varchar(255) DEFAULT NULL,
  `moTa` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `hoadon`
--

INSERT INTO `hoadon` (`soHD`, `ngaylap`, `tongtien`, `maKH`, `trangThai`, `moTa`) VALUES
('hd001', '2023-01-01', '260000', 'nam0001', 'Hoàn thành', NULL),
('hd002', '2023-01-09', '359000', 'dung0002', 'Hoàn thành', NULL),
('hd003', '2023-01-17', '252000', 'thuy0003', 'Hoàn thành', NULL),
('hd004', '2023-01-24', '89000', 'dung0002', 'Hoàn thành', NULL),
('hd005', '2023-02-12', '280000', 'nhan0004', 'Hoàn thành', NULL),
('hd006', '2023-02-24', '520000', 'le0005', 'Hoàn thành', NULL),
('hd007', '2023-02-26', '320000', 'van0006', 'Hoàn thành', NULL),
('hd008', '2023-02-27', '300000', 'hung0007', 'Hoàn thành', NULL),
('hd009', '2023-03-03', '89000', 'luc0008', 'Hoàn thành', NULL),
('hd010', '2023-03-19', '110000', 'trang0009', 'Hoàn thành', NULL),
('hd011', '2023-03-23', '108000', 'chau0010', 'Hoàn thành', NULL),
('hd012', '2023-04-04', '600000', 'thuy0003', 'Hoàn thành', NULL),
('hd013', '2023-04-12', '136000', 'yen0011', 'Hoàn thành', NULL),
('hd014', '2023-04-12', '56000', 'nhan0004', 'Hoàn thành', NULL),
('hd015', '2023-04-26', '80000', 'le0005', 'Hoàn thành', NULL),
('hd016', '2023-05-05', '120000', 'anh0012', 'Hoàn thành', NULL),
('hd017', '2023-05-12', '350000', 'phat0013', 'Hoàn thành', NULL),
('hd018', '2023-05-17', '124000', 'tien0014', 'Hoàn thành', NULL),
('hd019', '2023-05-19', '300000', 'tien0014', 'Hoàn thành', NULL),
('hd020', '2023-06-03', '48000', 'lam0015', 'Hoàn thành', NULL),
('hd021', '2023-06-12', '90000', 'chau0010', 'Hoàn thành', NULL),
('hd022', '2023-06-17', '90000', 'trang0009', 'Hoàn thành', NULL),
('hd023', '2023-07-09', '2597000', 'nhan0004', 'Hoàn thành', NULL),
('hd024', '2023-08-13', '660000', 'hai0016', 'Hoàn thành', NULL),
('hd025', '2024-05-02', '30000', 'nam0001', 'Chờ duyệt', NULL),
('hd026', '2024-05-02', '30000', 'nam0001', 'Đã thanh toán', NULL),
('hd027', '2024-05-02', '55000', 'nam0001', 'Từ chối', NULL),
('hd028', '2024-05-02', '492000', 'nam0001', 'Đang giao', NULL),
('hd029', '2024-05-06', '20000', 'nam0001', 'Hoàn thành', NULL),
('hd030', '2024-05-09', '1440000', 'nam0001', 'Đang giao', NULL),
('hd031', '2024-05-10', '310000', 'nam0001', 'Chờ duyệt', NULL),
('hd032', '2024-05-10', '1334000', 'nam0001', 'Hoàn thành', NULL);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `ngk`
--

CREATE TABLE `ngk` (
  `maNGK` varchar(5) NOT NULL,
  `tenNGK` varchar(30) DEFAULT NULL,
  `donvitinh` varchar(10) DEFAULT NULL,
  `slcon` int(11) DEFAULT NULL,
  `giabanle` mediumtext DEFAULT NULL,
  `tenloai` varchar(50) DEFAULT NULL,
  `maNB` varchar(5) DEFAULT NULL,
  `maHSX` varchar(5) DEFAULT NULL,
  `maQL` varchar(5) DEFAULT NULL,
  `img` varchar(255) DEFAULT NULL,
  `trangThai` tinyint(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `ngk`
--

INSERT INTO `ngk` (`maNGK`, `tenNGK`, `donvitinh`, `slcon`, `giabanle`, `tenloai`, `maNB`, `maHSX`, `maQL`, `img`, `trangThai`) VALUES
('ngk01', 'Aquafina', 'Chai', 1096, '6000', 'Nước suối', 'nb001', 'ppico', 'ql001', './src/img/Product/aquafina.png', 1),
('ngk02', 'Bang Energy', 'Lon', 100, '23000', 'Nước tăng lực', 'nb001', 'sport', 'ql001', './src/img/Product/bang-energy.png', 1),
('ngk03', 'CocaCola', 'Lon', 78, '10000', 'Nước có ga', 'nb002', 'coca', 'ql001', './src/img/Product/cocacola.png', 1),
('ngk04', 'Fanta', 'Lon', 70, '9000', 'Nước có ga', 'nb003', 'coca', 'ql001', './src/img/Product/fanta.png', 1),
('ngk05', 'Monter Energy', 'Lon', 90, '31000', 'Nước tăng lực', 'nb001', 'mbc', 'ql001', './src/img/Product/monsterenergy.png', 1),
('ngk06', 'Mountain Dew', 'Lon', 45, '8000', 'Nước có ga', 'nb003', 'ppico', 'ql001', './src/img/Product/mountaindew.png', 1),
('ngk07', 'Nos Energy', 'Lon', 60, '10000', 'Nước tăng lực', 'nb002', 'mbc', 'ql001', './src/img/Product/nos-energy-drink.png', 1),
('ngk08', 'Pepsi', 'Lon', 70, '11000', 'Nước có ga', 'nb002', 'ppico', 'ql001', './src/img/Product/pepsi.png', 1),
('ngk09', 'Powerade', 'Chai', 40, '60000', 'Nước uống Thể Thao', 'nb002', 'coca', 'ql001', './src/img/Product/powerade.png', 1),
('ngk10', 'Red Bull', 'Lon', 50, '14000', 'Nước tăng lực', 'nb003', 'redbg', 'ql001', './src/img/Product/redbull.png', 1),
('ngk11', 'Rock Star Energy', 'Lon', 56, '10000', 'Nước tăng lực', 'nb003', 'rock', 'ql001', './src/img/Product/rockstarenergy.png', 1),
('ngk12', 'Double Shot Energy', 'Lon', 40, '40000', 'Coffee', 'nb003', 'starc', 'ql001', './src/img/Product/starbucks-doubleshot-energy.png', 1),
('ngk13', 'Fanta_1000ml', 'Lon', 50, '19000', 'Nước có ga', 'nb003', 'coca', 'ql001', './src/img/Product/fanta.png', 1),
('ngk14', 'Double Shot Energy', 'Lon', 480, '37000', 'Coffee', 'nb003', 'starc', 'ql001', './src/img/Product/starbucks-doubleshot-energy.png', 1),
('ngk15', 'Double Shot Energy', 'Lon', 80, '37000', 'Coffee', 'nb003', 'starc', 'ql001', NULL, 0),
('ngk16', 'Double Shot Energy', 'Lon', 80, '37000', 'Coffee', 'nb003', 'starc', 'ql001', NULL, 0);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `nhacungcap`
--

CREATE TABLE `nhacungcap` (
  `maNCC` varchar(10) NOT NULL,
  `tenNCC` varchar(100) NOT NULL,
  `diaChi` varchar(500) DEFAULT NULL,
  `sdt` varchar(10) NOT NULL,
  `trangThai` tinyint(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `nhacungcap`
--

INSERT INTO `nhacungcap` (`maNCC`, `tenNCC`, `diaChi`, `sdt`, `trangThai`) VALUES
('ncc01', 'Công Ty Cổ Phần ABC', 'Tp. Hồ Chí Minh', '0931213888', 1),
('ncc02', 'Công Ty Cổ Phần XYZ', 'Tp. Hồ Chí Minh', '0896727444', 0);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `phanquyen`
--

CREATE TABLE `phanquyen` (
  `ma` varchar(20) NOT NULL,
  `chucVu_ma` varchar(20) DEFAULT NULL,
  `tenChucNang` varchar(100) DEFAULT NULL,
  `trangThai` tinyint(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `phanquyen`
--

INSERT INTO `phanquyen` (`ma`, `chucVu_ma`, `tenChucNang`, `trangThai`) VALUES
('ad1', 'admin', 'Xem thông tin người dùng', 1),
('ad2', 'admin', 'Thêm người dùng', 1),
('ad3', 'admin', 'Sửa người dùng', 1),
('ad4', 'admin', 'Khóa người dùng', 1),
('ad5', 'admin', 'Xóa người dùng', 1),
('gd1', 'giamdoc', 'Toàn quyền', 1),
('kh1', 'khachhang', 'Xem sản phẩm', 1),
('kh2', 'khachhang', 'Thêm giỏ hàng', 1),
('kh3', 'khachhang', 'Xóa giỏ hàng', 1),
('kh4', 'khachhang', 'Đặt hàng', 1),
('kh5', 'khachhang', 'Sửa thông tin cá nhân', 1),
('nb1', 'nguoiban', 'Xem hóa đơn', 1),
('nb2', 'nguoiban', 'Duyệt đơn hàng', 1),
('nb3', 'nguoiban', 'Xem khách hàng', 1),
('nb4', 'nguoiban', 'Khóa khách hàng', 1),
('nb5', 'nguoiban', 'Xóa khách hàng', 1),
('nb6', 'nguoiban', 'Xem thống kê bán hàng', 1),
('qlk1', 'quanlykho', 'Thêm sản phẩm', 1),
('qlk10', 'quanlykho', 'Xem thống kê nhập xuất', 1),
('qlk2', 'quanlykho', 'Sửa sản phẩm', 1),
('qlk3', 'quanlykho', 'Xóa sản phẩm', 1),
('qlk4', 'quanlykho', 'Thêm nhà cung cấp', 1),
('qlk5', 'quanlykho', 'Sửa nhà cung cấp', 1),
('qlk6', 'quanlykho', 'Xóa nhà cung cấp', 1),
('qlk7', 'quanlykho', 'Lập phiếu nhập', 1),
('qlk8', 'quanlykho', 'Xóa phiếu nhập', 1),
('qlk9', 'quanlykho', 'Cập nhật phiếu nhập', 1);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `phieunhap`
--

CREATE TABLE `phieunhap` (
  `maPN` varchar(10) NOT NULL,
  `ngayNhap` date NOT NULL DEFAULT curdate(),
  `maNN` varchar(20) NOT NULL,
  `maNCC` varchar(10) DEFAULT NULL,
  `tongTien` decimal(10,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `phieunhap`
--

INSERT INTO `phieunhap` (`maPN`, `ngayNhap`, `maNN`, `maNCC`, `tongTien`) VALUES
('pn001', '2024-04-13', 'ql001', 'ncc01', 20600000.00),
('pn002', '2024-04-14', 'ql001', 'ncc01', 7000000.00),
('pn003', '2024-04-15', 'ql001', 'ncc01', 2600000.00),
('pn004', '2024-04-16', 'ql001', 'ncc01', 5860000.00),
('pn005', '2024-04-17', 'ql001', 'ncc01', 2900000.00),
('pn006', '2024-04-18', 'ql001', 'ncc01', 4784000.00),
('pn007', '2024-04-19', 'ql001', 'ncc01', 2970000.00),
('pn008', '2024-04-20', 'ql001', 'ncc01', 4650000.00),
('pn009', '2024-04-21', 'ql001', 'ncc01', 4800000.00),
('pn010', '2024-04-22', 'ql001', 'ncc01', 3800000.00),
('pn011', '2024-04-23', 'ql001', 'ncc01', 3680000.00),
('pn012', '2024-04-24', 'ql001', 'ncc01', 5450000.00),
('pn013', '2024-04-25', 'ql001', 'ncc01', 3060000.00),
('pn014', '2024-04-26', 'ql001', 'ncc01', 7860000.00),
('pn015', '2024-04-27', 'ql001', 'ncc01', 16568000.00),
('pn016', '2024-04-25', 'ql001', 'ncc01', 14400000.00),
('pn017', '2024-04-25', 'ql001', 'ncc01', 26220000.00),
('pn018', '2024-04-25', 'ql001', 'ncc01', 20300000.00),
('pn019', '2024-04-23', 'ql001', 'ncc01', 40040000.00),
('pn020', '2024-04-23', 'ql001', 'ncc01', 71050000.00),
('pn021', '2024-04-23', 'ql001', 'ncc01', 55000.00),
('pn022', '2024-04-23', 'ql001', 'ncc01', 440000.00),
('pn023', '2024-05-06', 'ql001', 'ncc01', 600000.00),
('pn024', '2024-05-06', 'ql001', 'ncc01', 600000.00),
('pn025', '2024-05-06', 'ql001', 'ncc01', 600000.00),
('pn026', '2024-05-06', 'ql001', 'ncc01', 8300000.00);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `taikhoan`
--

CREATE TABLE `taikhoan` (
  `ma` varchar(20) NOT NULL,
  `tenTK` varchar(30) DEFAULT NULL,
  `diachi` varchar(255) DEFAULT NULL,
  `sdt` varchar(10) DEFAULT NULL,
  `matkhau` varchar(20) DEFAULT NULL,
  `trangThai` tinyint(1) DEFAULT NULL,
  `role` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `taikhoan`
--

INSERT INTO `taikhoan` (`ma`, `tenTK`, `diachi`, `sdt`, `matkhau`, `trangThai`, `role`) VALUES
('admin', 'Nguyễn Văn A', '7 Nguyễn Du, Quận 1, Tp Hồ Chí Minh', '0989898989', '00000', 1, 'admin'),
('anh0012', 'Nguyễn Hoàng Anh', '567 Ba Tháng Hai, Quận 10, Tp Hồ Chí Minh', '0765432198', 'kh0012', 1, 'khachhang'),
('chau0010', 'Vũ Hoàng Châu', '13 Tô Vinh Diện, Thủ Đức, Tp Hồ Chí Minh', '0987654321', 'kh0010', 1, 'khachhang'),
('dung0002', 'Trần Quan Dũng', '566 Nguyễn Trãi, Quận 5, Tp Hồ Chí Minh', '0234567891', 'kh0000', 1, 'khachhang'),
('giamdoc', 'Nguyễn Văn A', NULL, '099999999', 'giamdoc', 1, 'giamdoc'),
('hai0016', 'Hà Thanh Hải', 'Lê Văn Thọ, Gò Vấp, Tp Hồ Chí Minh', '0321987654', 'hai0016', 1, 'khachhang'),
('hau0018', 'Vũ Trung Hậu', 'Lý Tự Trọng, Quận 1, Tp Hồ Chí Minh', '0198765432', 'kh0018', 1, 'khachhang'),
('hung0007', 'Cao Thanh Hùng', '456 Điện Biên Phủ, Quận 3, Tp Hồ Chí Minh', '0789123456', 'kh0007', 1, 'khachhang'),
('huy0020', 'Nguyễn Ngọc Huy', 'Lạc Long Quân, Quận 11, Tp Hồ Chí Minh', '0121212345', 'kh0020', 1, 'khachhang'),
('kh0020', 'Bùi Thúy Vân', '3 Lê Lai, Quận 1, Tp Hồ Chí Minh', '0678912345', 'kh0006', 1, 'khachhang'),
('khanh111', 'Nguyễn Khánh', 'An Giang', '0112233333', 'khanh111', 1, 'khachhang'),
('khanh123', 'Nguyễn Khánh', 'An GIang', '0343434343', '123', 1, 'khachhang'),
('lam0015', 'Phan Huỳnh Lãm', 'Quang Trung, Gò Vấp, Tp Hồ Chí Minh', '0432198765', 'kh0015', 1, 'khachhang'),
('le0005', 'Hà Thị Lê', 'Nguyễn Thị Định, Thủ Đức, Tp Hồ Chí Minh', '0567891234', 'kh0005', 1, 'quanlykho'),
('loc0019', 'Tạ Khánh Lộc', 'Lê Duẩn, Quận 1, Tp Hồ Chí Minh', '0989876543', 'kh0019', 1, 'khachhang'),
('luc0008', 'Trần Tiến Lực', '320 Pasteur, Quận 3, Tp Hồ Chí Minh', '0891234567', 'kh0008', 1, 'khachhang'),
('nam0001', 'Nguyễn Tiến Nam', 'Nguyễn Văn Lượng, Gò Vấp, Tp Hồ Chí Minh', '0123456789', 'kh000111', 0, 'khachhang'),
('nb001', 'Nguyễn Quốc Quân', '350 Nguyễn Thị Minh Khai, Quận 1, Tp Hồ Chí Minh', '0121212121', 'nb001', 1, 'nguoiban'),
('nb002', 'Phan Thị Ngọc Trang', '567 Ba Tháng Hai, Quận 10, Tp Hồ Chí Minh', '0343434343', 'nb002', 1, 'nguoiban'),
('nb003', 'Nguyễn Văn Sơn', '199 Bà Hạt, Quận 10, Tp Hồ Chí Minh', '0454545454', 'nb003', 1, 'nguoiban'),
('nguyen0017', 'Nguyễn Trung Nguyên', 'Bình Thạnh, Tp Hồ Chí Minh', '0219876543', 'kh0017', 1, 'khachhang'),
('nhan0004', 'Châu Văn Nhàn', '45 Nguyễn Huệ, Quận 1, Tp Hồ Chí Minh', '0456789123', 'kh0004', 1, 'khachhang'),
('phat0013', 'Huỳnh Phát', '382 Lê Văn Lương, Quận 7, Tp Hồ Chí Minh', '0654321987', 'kh0013', 1, 'khachhang'),
('ql001', 'Nguyễn Ngọc', '767 Trần Hưng Đạo, Quận 5, Tp Hồ Chí Minh', '0123123123', 'ql001', 1, 'quanlykho'),
('thuy0003', 'Hà Thị Thu Thúy', '799 Phan Văn Trị, Gò Vấp, Tp Hồ Chí Minh', '0345678912', 'kh0003', 1, 'khachhang'),
('tien0014', 'Hà Thanh Tiền', 'Bình Quới, Bình Thạnh, Tp Hồ Chí Minh', '0543219876', 'kh0014', 0, 'khachhang'),
('trang0009', 'Cao Trang', '320 Đặng Văn Bi, Thủ Đức, Tp Hồ Chí Minh', '0912345678', 'kh0009', 0, 'khachhang'),
('yen0011', 'Hải Yến', 'Quận 3, Tp Hồ Chí Minh', '0876543219', 'yen0011', 1, 'nguoiban');

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `chitietphieunhap`
--
ALTER TABLE `chitietphieunhap`
  ADD KEY `fk_chitietphieunhap_ngk` (`maSP`),
  ADD KEY `fk_chitietphieunhap_phieunhap` (`maPN`);

--
-- Chỉ mục cho bảng `chucvu`
--
ALTER TABLE `chucvu`
  ADD PRIMARY KEY (`ma`);

--
-- Chỉ mục cho bảng `ctgiohang`
--
ALTER TABLE `ctgiohang`
  ADD PRIMARY KEY (`maCTGH`),
  ADD KEY `maNGK` (`maNGK`),
  ADD KEY `maGH` (`maGH`);

--
-- Chỉ mục cho bảng `cthoadon`
--
ALTER TABLE `cthoadon`
  ADD PRIMARY KEY (`maCTHD`),
  ADD KEY `soHD` (`soHD`),
  ADD KEY `maNGK` (`maNGK`),
  ADD KEY `maKH` (`maKH`);

--
-- Chỉ mục cho bảng `giohang`
--
ALTER TABLE `giohang`
  ADD PRIMARY KEY (`maGH`),
  ADD KEY `maKH` (`maKH`);

--
-- Chỉ mục cho bảng `hangsx`
--
ALTER TABLE `hangsx`
  ADD PRIMARY KEY (`maHSX`);

--
-- Chỉ mục cho bảng `hoadon`
--
ALTER TABLE `hoadon`
  ADD PRIMARY KEY (`soHD`);

--
-- Chỉ mục cho bảng `ngk`
--
ALTER TABLE `ngk`
  ADD PRIMARY KEY (`maNGK`),
  ADD KEY `maHSX` (`maHSX`),
  ADD KEY `fk_ngk_maNB` (`maNB`),
  ADD KEY `fk_ngk_maQL` (`maQL`);

--
-- Chỉ mục cho bảng `nhacungcap`
--
ALTER TABLE `nhacungcap`
  ADD PRIMARY KEY (`maNCC`);

--
-- Chỉ mục cho bảng `phanquyen`
--
ALTER TABLE `phanquyen`
  ADD PRIMARY KEY (`ma`),
  ADD KEY `chucVu_ma` (`chucVu_ma`);

--
-- Chỉ mục cho bảng `phieunhap`
--
ALTER TABLE `phieunhap`
  ADD PRIMARY KEY (`maPN`),
  ADD KEY `fk_phieunhap_nhacungcap` (`maNCC`);

--
-- Chỉ mục cho bảng `taikhoan`
--
ALTER TABLE `taikhoan`
  ADD PRIMARY KEY (`ma`);

--
-- Các ràng buộc cho các bảng đã đổ
--

--
-- Các ràng buộc cho bảng `chitietphieunhap`
--
ALTER TABLE `chitietphieunhap`
  ADD CONSTRAINT `fk_chitietphieunhap_ngk` FOREIGN KEY (`maSP`) REFERENCES `ngk` (`maNGK`),
  ADD CONSTRAINT `fk_chitietphieunhap_phieunhap` FOREIGN KEY (`maPN`) REFERENCES `phieunhap` (`maPN`);

--
-- Các ràng buộc cho bảng `ctgiohang`
--
ALTER TABLE `ctgiohang`
  ADD CONSTRAINT `ctgiohang_ibfk_1` FOREIGN KEY (`maNGK`) REFERENCES `ngk` (`maNGK`),
  ADD CONSTRAINT `ctgiohang_ibfk_2` FOREIGN KEY (`maGH`) REFERENCES `giohang` (`maGH`);

--
-- Các ràng buộc cho bảng `cthoadon`
--
ALTER TABLE `cthoadon`
  ADD CONSTRAINT `cthoadon_ibfk_2` FOREIGN KEY (`maNGK`) REFERENCES `ngk` (`maNGK`),
  ADD CONSTRAINT `cthoadon_ibfk_3` FOREIGN KEY (`soHD`) REFERENCES `hoadon` (`soHD`),
  ADD CONSTRAINT `cthoadon_ibfk_4` FOREIGN KEY (`soHD`) REFERENCES `hoadon` (`soHD`);

--
-- Các ràng buộc cho bảng `giohang`
--
ALTER TABLE `giohang`
  ADD CONSTRAINT `giohang_ibfk_1` FOREIGN KEY (`maKH`) REFERENCES `taikhoan` (`ma`),
  ADD CONSTRAINT `giohang_ibfk_2` FOREIGN KEY (`maKH`) REFERENCES `taikhoan` (`ma`);

--
-- Các ràng buộc cho bảng `ngk`
--
ALTER TABLE `ngk`
  ADD CONSTRAINT `fk_ngk_maNB` FOREIGN KEY (`maNB`) REFERENCES `taikhoan` (`ma`),
  ADD CONSTRAINT `fk_ngk_maQL` FOREIGN KEY (`maQL`) REFERENCES `taikhoan` (`ma`),
  ADD CONSTRAINT `ngk_ibfk_2` FOREIGN KEY (`maHSX`) REFERENCES `hangsx` (`maHSX`);

--
-- Các ràng buộc cho bảng `phanquyen`
--
ALTER TABLE `phanquyen`
  ADD CONSTRAINT `phanquyen_ibfk_1` FOREIGN KEY (`chucVu_ma`) REFERENCES `chucvu` (`ma`);

--
-- Các ràng buộc cho bảng `phieunhap`
--
ALTER TABLE `phieunhap`
  ADD CONSTRAINT `fk_phieunhap_nhacungcap` FOREIGN KEY (`maNCC`) REFERENCES `nhacungcap` (`maNCC`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
