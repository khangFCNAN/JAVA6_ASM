const app = angular.module("app", []);

app.controller('login-ctrl', function($scope, $http) {
	$scope.taiKhoans = [];
	$scope.taiKhoan = {};
	
	$scope.initialize = function() {
		$http.get("/khachHang/list").then(resp => { // đến api
			$scope.taiKhoans = resp.data;
			console.log($scope.taiKhoans);
		});

	}

	$scope.initialize();

	$scope.check = function() {
		if (!$scope.inputTaiKhoan.trim() && !$scope.inputMatKhau.trim()) {
			console.log("Vui lòng nhập đầy đủ thông tin");
			return;
		}
		console.log($scope.inputTaiKhoan);
		console.log($scope.inputMatKhau);
		$http.get("/khachHang/list").then(resp => { // đến api
			$scope.taiKhoans = resp.data;
			console.log($scope.taiKhoans);

			var found = false;

			$scope.taiKhoans.forEach(function(taiKhoan) {

				if (taiKhoan.taiKhoan.trim() === $scope.inputTaiKhoan.trim() && taiKhoan.matKhau.trim() === $scope.inputMatKhau.trim()) { // Thay someProperty bằng tên thuộc tính cần so sánh
					found = true;

//					var cleanedInputTaiKhoan = $scope.inputTaiKhoan.trim();
//					var cleanedInputMatKhau = $scope.inputMatKhau.trim();
//
//					var loggedInAccount = { taiKhoan: cleanedInputTaiKhoan, matKhau: cleanedInputMatKhau };
//					sessionStorage.setItem('loggedInAccount', JSON.stringify(loggedInAccount));
					var loggedInAccountJSON = JSON.stringify(taiKhoan);
					sessionStorage.setItem('loggedInAccount', loggedInAccountJSON);
					console.log($scope.taiKhoan);
					console.log("Đăng nhập thành công.");
					window.location.href = '/index/form';
					alert('Dăng nhập thành công :) ');
				}

			});
			
			if (!found) {
				alert('Sai thông tin đăng nhập, kiểm tra lại');
				console.log("Sai thông tin đăng nhập, kiểm tra lại");
			}
		});

	};
});
