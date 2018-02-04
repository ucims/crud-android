<?php
require_once'koneksi.php';
if($_SERVER['REQUEST_METHOD'] == 'POST'){
	
	$id_berita = $_POST['id_berita'];
		
	$query = "DELETE FROM tbl_berita WHERE id_berita = '$id_berita'"; 	
	$exeQuery = mysqli_query($konek,$query);
	echo ($exeQuery) ? json_encode(array('kode'=>1,'pesan'=>'data berhasil dihapus'))
	: json_encode(array('kode'=>2,'pesan'=>'data gagal dihapus'));
}else{
	echo json_encode(array('kode'=>101,'pesan'=>'request tidak valid'));
}
?>