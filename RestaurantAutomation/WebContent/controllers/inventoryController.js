app.controller('inventoryController', function($scope,$http) {
	$scope.btnName ="Add";
	// ------------- Perishable functions------------
	$scope.insertData = function(){
		if($scope.name == null) {
			alert("Item name is required");
		}
		else if ($scope.quantity == null) {
			alert("Amount is required");
		}
		else {
			$http.post("endpoints/insert.php",{
				'name': $scope.name,
				'quantity': $scope.quantity,
				'btnName': $scope.btnName,
				'id': $scope.id
			})
			.success(function(data){
				alert(data);
				$scope.displayData();
				$scope.btnName ="Add";
				$scope.name = null;
				$scope.quantity = null;
			});
		}
	}
	
	$scope.displayData = function() {
		$http.get("endpoints/select.php")
		.success(function(data) {
			$scope.names = data;
		})
	}
	
	$scope.updateData = function(id, name, quantity) {
		$scope.id = id;
		$scope.name = name;
		$scope.quantity = quantity;
		$scope.btnName ="Update";
	}
	
	$scope.deleteData = function(id) {
		if(confirm("Are you sure you want to delete this item?")) {
			$http.post("endpoints/delete.php", {
				'id': id
			})
			.success(function(data) {
				$scope.displayData();
				alert(data);
			});
		}
		else {
			return false;
		}
	}
	
	// ---------------Non Perishable functions-------------
	$scope.insertDataNon = function(){
		if($scope.name == null) {
			alert("Item name is required");
		}
		else if ($scope.quantity == null) {
			alert("Amount is required");
		}
		else {
			$http.post("endpoints/insertNon.php",{
				'name': $scope.name,
				'quantity': $scope.quantity,
				'btnName': $scope.btnName,
				'id': $scope.id
			})
			.success(function(data){
				alert(data);
				$scope.displayDataNon();
				$scope.btnName ="Add";
				$scope.name = null;
				$scope.quantity = null;
			});
		}
	}
	
	$scope.displayDataNon = function() {
		$http.get("endpoints/selectNon.php")
		.success(function(data) {
			$scope.names = data;
		})
	}
	
	$scope.updateDataNon = function(id, name, quantity) {
		$scope.id = id;
		$scope.name = name;
		$scope.quantity = quantity;
		$scope.btnName ="Update";
	}
	
	$scope.deleteDataNon = function(id) {
		if(confirm("Are you sure you want to delete this item?")) {
			$http.post("endpoints/deleteNon.php", {
				'id': id
			})
			.success(function(data) {
				$scope.displayDataNon();
				alert(data);
			});
		}
		else {
			return false;
		}
	}
	
	//---------------Drinks Functions---------------
	$scope.insertDataDrink = function(){
		if($scope.name == null) {
			alert("Item name is required");
		}
		else if ($scope.quantity == null) {
			alert("Amount is required");
		}
		else {
			$http.post("endpoints/insertDrink.php",{
				'name': $scope.name,
				'quantity': $scope.quantity,
				'btnName': $scope.btnName,
				'id': $scope.id
			})
			.success(function(data){
				alert(data);
				$scope.displayDataDrink();
				$scope.btnName ="Add";
				$scope.name = null;
				$scope.quantity = null;
			});
		}
	}
	
	$scope.displayDataDrink = function() {
		$http.get("endpoints/selectDrink.php")
		.success(function(data) {
			$scope.names = data;
		})
	}
	
	$scope.updateDataDrink = function(id, name, quantity) {
		$scope.id = id;
		$scope.name = name;
		$scope.quantity = quantity;
		$scope.btnName ="Update";
	}
	
	$scope.deleteDataDrink = function(id) {
		if(confirm("Are you sure you want to delete this item?")) {
			$http.post("endpoints/deleteDrink.php", {
				'id': id
			})
			.success(function(data) {
				$scope.displayDataDrink();
				alert(data);
			});
		}
		else {
			return false;
		}
	}
	
	//-----------------Utensils-------------------------
	$scope.insertDataUtensil = function(){
		if($scope.name == null) {
			alert("Item name is required");
		}
		else if ($scope.quantity == null) {
			alert("Amount is required");
		}
		else {
			$http.post("endpoints/insertUtensil.php",{
				'name': $scope.name,
				'quantity': $scope.quantity,
				'btnName': $scope.btnName,
				'id': $scope.id
			})
			.success(function(data){
				alert(data);
				$scope.displayDataUtensil();
				$scope.btnName ="Add";
				$scope.name = null;
				$scope.quantity = null;
			});
		}
	}
	
	$scope.displayDataUtensil = function() {
		$http.get("endpoints/selectUtensil.php")
		.success(function(data) {
			$scope.names = data;
		})
	}
	
	$scope.updateDataUtensil = function(id, name, quantity) {
		$scope.id = id;
		$scope.name = name;
		$scope.quantity = quantity;
		$scope.btnName ="Update";
	}
	
	$scope.deleteDataUtensil = function(id) {
		if(confirm("Are you sure you want to delete this item?")) {
			$http.post("endpoints/deleteUtensil.php", {
				'id': id
			})
			.success(function(data) {
				$scope.displayDataUtensil();
				alert(data);
			});
		}
		else {
			return false;
		}
	}
})