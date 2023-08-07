const app = angular.module("app", []);
app.controller("thongke-ctrl", function($scope, $http){
	//Hiển thị sản phẩm của thống kê
		$scope.sanphams = []; //show list
		$scope.sanpham = {}; //show form
		$scope.initialize = function() {
		$http.get("/sanpham/list").then(resp => {
			$scope.sanphams = resp.data;
			$scope.sanphams.forEach(sanpham => {
				donhang.createDate = new Date(sanpham.createDate)
			})
		});
	}
	$scope.initialize();
	console.log($scope.sanphams);
	};