-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 12 Apr 2023 pada 16.27
-- Versi server: 10.4.22-MariaDB
-- Versi PHP: 8.1.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `db_dpbo`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `login`
--

CREATE TABLE `login` (
  `id` int(11) NOT NULL,
  `user` varchar(100) NOT NULL,
  `pass` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `login`
--

INSERT INTO `login` (`id`, `user`, `pass`) VALUES
(1, 'admin', 'admin');

-- --------------------------------------------------------

--
-- Struktur dari tabel `tb_drama`
--

CREATE TABLE `tb_drama` (
  `id` int(11) NOT NULL,
  `id_screenwriter` int(11) NOT NULL,
  `drama_name` varchar(100) NOT NULL,
  `plot_summary` text NOT NULL,
  `img` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `tb_drama`
--

INSERT INTO `tb_drama` (`id`, `id_screenwriter`, `drama_name`, `plot_summary`, `img`) VALUES
(34, 6, 'Extracurricular', '\"Ekstrakurikuler\" berpusat di sekitar empat siswa \nsekolah menengah yang mulai melakukan \nkejahatan untuk mendapatkan uang dan bahaya tak \nterduga yang mereka hadapi sebagai akibatnya.', '230412041046446_Extracurricular.jpg'),
(35, 5, 'The Glory Part 1', 'Seorang siswa sekolah menengah atas bermimpi menjadi \nseorang arsitek. Sayangnya, ia harus putus sekolah \nsetelah mengalami kekerasan yang brutal di sekolah. \nBertahun-tahun kemudian, sang pelaku menikah dan \nmempunyai seorang anak. Saat anak itu menginjak bangku \nsekolah dasar, sang mantan korban menjadi guru wali kelasnya \ndan memulai balas dendam terhadap para pelaku dan orang-orang \nyang hanya menyaksikan setiap hari perundungannya.', '23041207260444_The_Glory.jpg'),
(36, 4, 'Signal', 'Hae Yeong adalah petugas polisi dan profiler \nkriminal. Suatu hari, dia menemukan walkie-talkie \nyang memungkinkan dia untuk berhubungan \ndengan Detektif Lee Jae Han yang ada di masa lalu. \nPetugas polisi Hae Yeong, Jae Han, dan Cha So Hyun \nkemudian melakukan perjalanan untuk menyelesaikan kasus dingin.', '230412073420420_Signal.jpg'),
(37, 5, 'Mr Sunshine', 'Mr.Sunshine berpusat pada seorang anak laki-laki \nyang lahir dari keluarga pembantu rumah tangga \ndan melakukan perjalanan ke Amerika Serikat selama\n1871 Shinmiyangyo (ekspedisi AS ke Korea). Dia\nkembali ke tanah airnya nanti sebagai perwira angkatan\nlaut AS. Dia bertemu dan jatuh cinta dengan putri seorang \nbangsawan. Pada saat yang sama, ia menemukan komplotan \npasukan asing untuk menjajah Korea.', '230412074143443_MrSunshine.jpg');

-- --------------------------------------------------------

--
-- Struktur dari tabel `tb_screenwriter`
--

CREATE TABLE `tb_screenwriter` (
  `id` int(11) NOT NULL,
  `nama` varchar(100) NOT NULL,
  `jumlah_drama` int(11) NOT NULL,
  `img` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `tb_screenwriter`
--

INSERT INTO `tb_screenwriter` (`id`, `nama`, `jumlah_drama`, `img`) VALUES
(4, 'Kim Eun Hee', 5, '22033004410131_agatha.jpg'),
(5, 'Kim Eun Sook', 10, '220330044639339_arthur.jpg'),
(6, 'Jin Han Sae', 3, '220330045225325_stephen.jpg');

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `login`
--
ALTER TABLE `login`
  ADD PRIMARY KEY (`id`);

--
-- Indeks untuk tabel `tb_drama`
--
ALTER TABLE `tb_drama`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_author` (`id_screenwriter`);

--
-- Indeks untuk tabel `tb_screenwriter`
--
ALTER TABLE `tb_screenwriter`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT untuk tabel yang dibuang
--

--
-- AUTO_INCREMENT untuk tabel `login`
--
ALTER TABLE `login`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT untuk tabel `tb_drama`
--
ALTER TABLE `tb_drama`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=39;

--
-- AUTO_INCREMENT untuk tabel `tb_screenwriter`
--
ALTER TABLE `tb_screenwriter`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- Ketidakleluasaan untuk tabel pelimpahan (Dumped Tables)
--

--
-- Ketidakleluasaan untuk tabel `tb_drama`
--
ALTER TABLE `tb_drama`
  ADD CONSTRAINT `tb_drama_ibfk_1` FOREIGN KEY (`id_screenwriter`) REFERENCES `tb_screenwriter` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
