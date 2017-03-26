<?php 

	//$connect = mysqli_connect("localhost","root","","easyeats");
	include("../connectionSQLi.php");
	
	$data = json_decode(file_get_contents("php://input"));
	
	if (count($data) > 0) {
		$id = $data->id;
		$query = "DELETE FROM nonperishables WHERE id='$id' ";
		if(mysqli_query($connect, $query)) {
			echo 'Data Deleted';
		}
		else {
			echo 'Error';
		}
	}

?>