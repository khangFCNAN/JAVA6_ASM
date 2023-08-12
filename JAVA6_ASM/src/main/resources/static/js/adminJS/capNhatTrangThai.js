const app = angular.module("app", []);

angular.module("app").controller("update-status-ctrl", function($scope, $http, $window, $location) {
	// Lấy giá trị của tham số idHd từ URL
	var idHd = $location.search().idHd;

	// Lấy dữ liệu đơn hàng từ localStorage
	var donhang = JSON.parse(localStorage.getItem('donhang'));

	// Sử dụng dữ liệu đơn hàng
	$scope.donhang = donhang;

	// ...

	$scope.updateTrangThai = function() {
		var trangThai = document.getElementById("trangThai").value; // Lấy giá trị của select

		// Tạo một đối tượng FormData chứa các thông tin cần gửi đi
		var formData = new FormData();
		formData.append('trangThai', trangThai);

		$http.put(`/donhang/update/${donhang.idHd}`, { trangThai: donhang.trangThai }).then(resp => {
			var index = $scope.donhangs.findIndex(d => d.idHd == donhang.idHd);
			$scope.donhangs[index].trangThai = donhang.trangThai;
			// Sắp xếp đơn hàng
			$scope.donhangs.sort(function(a, b) {
				return b.idHd - a.idDh;
			});
			$scope.reset();
			alert("Cập nhật trạng thái đơn hàng thành công!");
			
			window.location.href = '/quanLyDonHang/update/' + donhang.idHd;
		});
	}
});



