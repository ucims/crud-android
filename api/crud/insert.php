<?php
require_once'koneksi.php';
if($_SERVER['REQUEST_METHOD'] == 'POST'){
	
	$id_user = $_POST['id_user'];	
	$nama_depan = $_POST['nama_depan'];
	$nama_belakang = $_POST['nama_belakang'];
	$username = $_POST['username'];
	$password = $_POST['password'];
	$email = $_POST['email'];
	$no_hp = $_POST['no_hp'];
	$hak_akses = $_POST['hak_akses'];
	
	$query = "INSERT INTO tbl_user (id_user,nama_depan,nama_belakang,username,password,email,no_hp,hak_akses) VALUES('$id_user','$nama_depan','$nama_belakang','$username','$password','$email','$no_hp','$hak_akses')"; 	
	$exeQuery = mysqli_query($konek,$query);
	echo ($exeQuery) ? json_encode(array('kode'=>1,'pesan'=>'data berhasil disimpan'))
	: json_encode(array('kode'=>2,'pesan'=>'data gagal disimpan'));
}else{
	echo json_encode(array('kode'=>101,'pesan'=>'request tidak valid'));
}
?>