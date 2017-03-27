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
        
        .state("inventoryManager", {
        	url:"/inventoryManager",
        	controller: "inventoryController",
        	templateUrl: "views/inventoryManager.html"
        })
        
        .state("managerHome", {
        	url:"/managerHome",
        	controller: "",
        	templateUrl: "views/managerHome.html"
        })
})