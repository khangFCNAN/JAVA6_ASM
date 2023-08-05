const app = angular.module("app", []);
app.controller("sanpham-ctrl", function($scope, $http){
	//quan ly san pham
	$scope.sanphams = []; //show list
	$scope.sanpham = {}; //show form
	//show list san pham
	$scope.initialize = function(){
		$http.get("/sanpham/list").then(resp => { // đến ipa
			$scope.sanphams = resp.data;
				$scope.sanphams.forEach(sanpham => {
				sanpham.createDate = new Date(sanpham.createDate)
			})
		});
	}
	$scope.initialize(); // chạy giao diện
	console.log($scope.sanphams); //in ra console xem có dữ liệu chưa
	
	$scope.edit = function(sanpham){
		$scope.sanpham = angular.copy(sanpham); // nên copy ra, không nên bõ thẳng vào.
	}
})