const app = angular.module("app", []);
app.controller("lichsu-ctrl", function($scope, $http, $window) {
	$scope.isButtonDisabled = true;
	//quan ly san pham
	$scope.listHoaDon = []; //show list
	$scope.hoadon = {}; //show form
	//show list san pham
	$scope.initialize = function() {
		$http.get("/lichSu/list").then(resp => {
			$scope.listHoaDon = resp.data;
			console.log($scope.listHoaDon)
			$scope.listHoaDon.forEach(hoadon => {
				hoadon.createDate = new Date(hoadon.createDate)
			})
		}).catch(err => {
			console.log(err)
		});
	}
	$scope.initialize();
}
)
