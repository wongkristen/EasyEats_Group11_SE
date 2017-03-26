<?php
	//$connect = mysqli_connect("localhost","root","","easyeats");
	include("../connectionSQLi.php");
	
	$data = json_decode(file_get_contents("php://input"));
	if (count($data) > 0) {
		$name = mysqli_real_escape_string($connect, $data->name);
		$quantity = $data->quantity;
		$btn_name = $data->btnName;
		
		if($btn_name == "Add") {
			$query = "INSERT INTO utensils(name,quantity) VALUES ('$name', $quantity)";
			if (mysqli_query($connect, $query)) {
				echo "Data inserted";
			}
			else {
				echo "Error";
			}
		}
		
		if ($btn_name == 'Update') {
			$id = $data->id;
			$query = "UPDATE utensils SET name = '$name', quantity = '$quantity' WHERE id = '$id'";
			
			if (mysqli_query($connect, $query)) {
				echo 'Data Updated';
			}
			else {
				echo 'Error';
			}
		}
	}

?>