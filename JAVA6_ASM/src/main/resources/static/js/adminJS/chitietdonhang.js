//const app = angular.module("app", []);
//app.controller("donhangchitiet-ctrl", function($scope, $http) {
//	$scope.donhangchitiet = {};
//
//	var urlParams = new URLSearchParams(window.location.search);
//	var idHd = urlParams.get('idHd');
//	// Sử dụng idHd để thực hiện các xử lý tương ứng (ví dụ: gọi API để lấy thông tin hóa đơn)
//	$scope.initialize = function() {
//		$http.get('/donhang/edit/' + idHd).then(resp => {
//			$scope.donhangchitiet = resp.data;
//			// nên copy ra, không nên bõ thẳng vào.
//			$scope.donhangchitiet = angular.copy(donhangchitiet);
//		})
//	}
//	
//	$scope.initialize();
//	// Ví dụ: In thông tin idHd ra console
//	console.log(donhang);
//});

