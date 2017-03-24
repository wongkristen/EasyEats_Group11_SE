/**
 *
 */
angular.module('myApp', []).controller('namesCtrl', function($scope) {
    $scope.names = [
        {name:'Jani',country:'Norway'},
        {name:'Hege',country:'Sweden'},
        {name:'Kai',country:'Denmark'}
    ];
});

angular.module('goodsApp', []).controller('goodsCtrl',function($scope,$http) {
	$http.get('getItem.php').success(function(data) {
		$scope.kitchen_goods = data;
	});
});
