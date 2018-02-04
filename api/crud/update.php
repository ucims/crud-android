<?php
require_once'koneksi.php';
if($_SERVER['REQUEST_METHOD'] == 'POST'){
	
	$id_berita = $_POST['id_berita'];	
	$tanggal = $_POST['tanggal'];
	$isi = $_POST['isi'];
	$jenis = $_POST['jenis'];
	$judul = $_POST['judul'];
	
	$query = "UPDATE tbl_berita set tanggal = '$tanggal', isi = '$isi', jenis = '$jenis', judul = '$judul' WHERE id_berita = '$id_berita'"; 	
	$exeQuery = mysqli_query($konek,$query);
	echo ($exeQuery) ? json_encode(array('kode'=>1,'pesan'=>'data berhasil diubah'))
	: json_encode(array('kode'=>2,'pesan'=>'data gagal diupdate'));
}else{
	echo json_encode(array('kode'=>101,'pesan'=>'request tidak valid'));
}
?>