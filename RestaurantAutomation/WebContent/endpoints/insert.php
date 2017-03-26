<?php
	//$connect = mysqli_connect("localhost","root","","easyeats");
	include("../connectionSQLi.php");
	
	$data = json_decode(file_get_contents("php://input"));
	if (count($data) > 0) {
		$name = mysqli_real_escape_string($connect, $data->name);
		$quantity = $data->quantity;
		$btn_name = $data->btnName;
		
		if($btn_name == "Add") {
			$query = "INSERT INTO perishables(name,quantity) VALUES ('$name', $quantity)";
			if (mysqli_query($connect, $query)) {
				echo "Data inserted";
			}
			else {
				echo "Error";
			}
		}
		
		if ($btn_name == 'Update') {
			$id = $data->id;
			$query = "UPDATE perishables SET name = '$name', quantity = '$quantity' WHERE id = '$id'";
			
			if (mysqli_query($connect, $query)) {
				echo 'Data Updated';
			}
			else {
				echo 'Error';
			}
		}
	}

	/*	This code also works, uses PDO
	include("../connection.php");
	$data = json_decode(file_get_contents("php://input"));
	$name = $data->name;
	$quantity= $data->quantity;
	
	$q = "INSERT INTO perishables (name, quantity)  VALUES (:name, :quantity)";
	$query = $db->prepare($q);
	$execute = $query->execute(array(
			":name" => $name,
			":quantity" => $quantity
	));
	
	echo json_encode($name);
	*/	

?>