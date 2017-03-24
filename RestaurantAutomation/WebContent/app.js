var app = angular.module("UserAuthTutorial", ["ui.router"]);

app.config(function($stateProvider, $urlRouterProvider){
    $urlRouterProvider.otherwise('/');
	$stateProvider
        .state("login", {
        url:"/",
        controller: "LoginController",
        templateUrl: "views/login.html"
        })
        
        .state("manager", {
        	url:"/manager",
        	controller: "MainController",
        	templateUrl: "views/manager.html"
        })
})