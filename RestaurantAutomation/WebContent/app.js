var app = angular.module("UserAuthTutorial", ["ui.router"]);

app.config(function($stateProvider, $urlRouterProvider){
    $urlRouterProvider.otherwise('/');
	$stateProvider
        .state("login", {
        url:"/",
        controller: "LoginController",
        templateUrl: "views/login.html"
        })

        .state("managerHome", {
        	url:"/managerHome",
        	controller: "ManagerController",
        	templateUrl: "views/managerHome.html"
        })

        .state("managerHome", {
        	url:"/managerHome",
        	controller: "",
        	templateUrl: "views/managerHome.html"
        })

})
