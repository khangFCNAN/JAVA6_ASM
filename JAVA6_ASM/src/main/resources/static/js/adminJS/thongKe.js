const app = angular.module("app", []);
app.controller("thongke-ctrl", function($scope, $http) {
	//Hiển thị sản phẩm của thống kê
	$scope.sanphams = []; //show list
	$scope.sanpham = {}; //show form
	$scope.initialize = function() {
		$http.get("/sanpham/banchay").then(resp => {
			$scope.sanphams = resp.data;
			$scope.sanphams.forEach(sanpham => {
				sanpham.createDate = new Date(sanpham.createDate);
			});
		});
	}

	//	console.log($scope.sanphams);
	$scope.initialize();
});