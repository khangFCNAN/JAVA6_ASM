const app = angular.module("app", []);

app.controller("update-status-ctrl", function($scope, $http, $window, $location) {






	// Lấy giá trị của tham số idHd từ URL
	var idHd = $location.search().idHd;

	// Lấy dữ liệu đơn hàng từ localStorage
	var donhang = JSON.parse(localStorage.getItem('donhang'));

	// Sử dụng dữ liệu đơn hàng
	$scope.donhang = donhang;

	// ...

	$scope.trangThai = {
		'Chưa duyệt': 'Chưa duyệt',
		'Đang xử lý': 'Đang xử lý',
		'Chờ vận chuyển': 'Chờ vận chuyển',
		'Đang giao': 'Đang giao',
		'Hoàn thành': 'Hoàn thành'
	};

$scope.validateTrangThai = function() {
    if ($scope.donhang.trangThai === 'Chưa duyệt') {
        $scope.trangThaiKhoa = ['Chưa duyệt', 'Đang xử lý'];
    } else if ($scope.donhang.trangThai === 'Đang xử lý') {
        $scope.trangThaiKhoa = ['Đang xử lý', 'Chờ vận chuyển'];
    } else if ($scope.donhang.trangThai === 'Chờ vận chuyển') {
        $scope.trangThaiKhoa = ['Chờ vận chuyển', 'Đang giao'];
    } else if ($scope.donhang.trangThai === 'Đang giao') {
        $scope.trangThaiKhoa = ['Đang giao', 'Hoàn thành'];
    } else {
        $scope.trangThaiKhoa = ['Hoàn thành'];
        $scope.donhang.trangThai = 'Hoàn thành';
    }
};




	$scope.updateTrangThai = function() {
		$scope.donhangs = [];
		$scope.donhang = {};

		$http.get("/donhang/list").then(resp => {
			$scope.donhangs = resp.data;
			$scope.donhangs.forEach(donhang => {
				donhang.createDate = new Date(donhang.createDate);
			});
		});
		console.log($scope.donhangs);

		var trangThai = $scope.donhang.trangThai; // Lấy giá trị của select

		var formData = new FormData();
		formData.append('trangThai', trangThai);

		$http.put(`/donhang/update/${donhang.idHd}`, donhang).then(resp => {
			var index = $scope.donhangs.findIndex(d => d.idHd == donhang.idHd);
			$scope.donhangs[index].trangThai = trangThai;

			$scope.donhang.trangThai = trangThai;

			window.location.href = '/quanLyDonHang/list';
			alert("Cập nhật trạng thái đơn hàng thành công!");
		});
	}

});



