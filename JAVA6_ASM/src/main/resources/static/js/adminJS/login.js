const app = angular.module("app", []);
app.controller('LoginController', function($scope) {
	$scope.submitForm = function() {
		// Xử lý đăng nhập ở đây
		var username = $scope.username;
		var password = $scope.password;

		// Kiểm tra thông tin đăng nhập
		if (username === 'admin' && password === 'admin123') {
			// Đăng nhập thành công
			alert('Đăng nhập thành công');
		} else {
			// Đăng nhập thất bại
			alert('Thông tin đăng nhập không đúng');
		}

		// Xóa thông tin đăng nhập sau khi xử lý
		$scope.username = '';
		$scope.password = '';
	};
});