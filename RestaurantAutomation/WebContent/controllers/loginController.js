app.controller("LoginController", function($scope, $http, $state){

	// Variables
	$scope.signUpInfo = {
			username:undefined,
			password:undefined
	}

	$scope.loginInfo = {
			username:undefined,
			password:undefined
	}

	//Functions

	$scope.signUserUp = function() {
		var data = {
				username: $scope.signUpInfo.username,
				password: $scope.signUpInfo.password
		}

		$http.post("endpoints/signup.php", data).success(function(response) {
			console.log(response);
			localStorage.setItem("user", JSON.stringify({user: response}))
			$state.go("managerHome");
		}).error(function(error) {
			console.error(error);
		})
	}

	$scope.loginUser = function() {
		var data = {
				username: $scope.loginInfo.username,
				password: $scope.loginInfo.password
		}

		$http.post("endpoints/login.php", data).success(function(response) {
			console.log(response);
			localStorage.setItem("user", JSON.stringify({user: response[0].email}));
			$state.go("managerHome");
		}).error(function(error) {
			console.error(error);
		})
	}
	//Init

})