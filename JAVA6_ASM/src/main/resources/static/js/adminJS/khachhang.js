const app = angular.module("app", []);

app.controller("khachhang-ctrl", function($scope, $http) {
	// Quản lý thương hiệu
	$scope.khachhangs = []; // Danh sách hiển thị
	$scope.khachhang = {}; // Biểu mẫu hiển thị

	// Hiển thị danh sách thương hiệu
	$scope.initialize = function() {
		$http.get("/khachHang/list").then(resp => {
			$scope.khachhangs = resp.data;
		
		});
	};
	$scope.initialize();
	console.log($scope.khachhangs);

});