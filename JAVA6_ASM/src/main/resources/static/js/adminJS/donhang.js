const app = angular.module("app", []);
app.controller("donhang-ctrl", function($scope, $http) {
	//quan ly san pham
	$scope.donhangs = []; //show list
	$scope.donhang = {}; //show form
	//show list san pham
	$scope.initialize = function() {
		$http.get("/lichSu/list").then(resp => {
			$scope.donhangs = resp.data;
			$scope.donhangs.forEach(donhang => {
				
			})
		});
	}
	$scope.initialize();
	console.log($scope.donhangs);

})