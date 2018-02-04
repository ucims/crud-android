<?php
require_once'koneksi.php';
if($_SERVER['REQUEST_METHOD'] == 'POST'){
	
	//$id_berita = $_POST['id_berita'];	
	$tanggal = $_POST['tanggal'];
	$isi = $_POST['isi'];
	$jenis = $_POST['jenis'];
	$judul = $_POST['judul'];
	
	
	$query = "INSERT INTO tbl_berita (id_berita,tanggal,isi,jenis,judul) VALUES('$id_berita','$tanggal','$isi','$jenis','$judul')"; 	
	$exeQuery = mysqli_query($konek,$query);
	echo ($exeQuery) ? json_encode(array('kode'=>1,'pesan'=>'data berhasil disimpan'))
	: json_encode(array('kode'=>2,'pesan'=>'data gagal disimpan'));
}else{
	echo json_encode(array('kode'=>101,'pesan'=>'request tidak valid'));
}
?>