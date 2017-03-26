app.controller("MainController", function ($scope, $state) {
	// If user is not logged in
	if (localStorage['user'] == undefined) {
		$state.go("login");
	}
	
	$scope.goToInventory = function() {
		$state.go("inventoryManager");
	}
})