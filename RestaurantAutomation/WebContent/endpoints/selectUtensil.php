<?php

	//$connect = mysqli_connect("localhost","root","","easyeats");
	include("../connectionSQLi.php");

	$output = array();
	
	$query = "SELECT * FROM utensils ORDER BY name";
	
	$result = mysqli_query($connect, $query);
	
	if(mysqli_num_rows($result) > 0) {
		while ($row = mysqli_fetch_array($result)) {
			$output[] = $row;
		}
		echo json_encode($output);
	}
?>