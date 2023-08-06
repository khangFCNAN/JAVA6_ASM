const app = angular.module("app", []);
app.controller("donhang-ctrl", function($scope, $http){
	//quan ly san pham
	$scope.donhangs = []; //show list
	$scope.doahang = {}; //show form
	//show list san pham
	$scope.initialize = function(){
		$http.get("/donhang/list").then(resp => {
			$scope.donhangs = resp.data;
				$scope.donhangs.forEach( donhang=> {
				donhang.createDate = new Date(donhang.createDate)
			})
		});
	}
	$scope.initialize();
	console.log($scope.donhangs);
	
	$scope.xemHoaDon = function(donhang){
		$scope.donhang = angular.copy(donhang); // nên copy ra, không nên bõ thẳng vào.
	}
//	function redirectToInvoice() {
//  const button = document.getElementById('viewButton');
//  const id = button.id;
//
//  // Chuyển đến trang khác và truyền dữ liệu qua
//  window.location.href = 'quanLyChiTietDonhang.html?id=' + id;
//}
$scope.edit = function(donhang){
		$scope.form = angular.copy(donhang);
		$location.path('/homeAD/quanLyChiTietDonhang');
	}

	
	
})
