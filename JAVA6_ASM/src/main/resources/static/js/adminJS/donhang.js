const app = angular.module("app", []);
app.controller("donhang-ctrl", function($scope, $http, $window) {
	//quan ly san pham
	$scope.donhangs = []; //show list
	$scope.donhang = {}; //show form
	//show list san pham
	$scope.initialize = function() {
		$http.get("/donhang/list").then(resp => {
			$scope.donhangs = resp.data;
			$scope.donhangs.forEach(donhang => {
				donhang.createDate = new Date(donhang.createDate)
			})
		});
	}
	$scope.initialize();
	console.log($scope.donhangs);


	$scope.edit = function(donhang) {
		$http.get('/donhang/edit/' + donhang.idHd)
			.then(function(resp) {
				$scope.donhang = resp.data;

				var taiKhoan = donhang.khachhang.taiKhoan;
				var hoTen = donhang.khachhang.hoTen;
				var sdt = donhang.sdt;
				var ngayTao = donhang.ngayTao;
				var email = donhang.khachhang.email;
				var idHd = donhang.idHd;
				var tongTien = donhang.tongTien;

				// Gán giá trị vào các trường input
				$scope.inputTaiKhoan = taiKhoan;
				$scope.inputHoTen = hoTen;
				$scope.inputSdt = sdt;
				$scope.inputNgayTao = ngayTao;
				$scope.inputEmail = email;
				$scope.inputIdHd = idHd;
				$scope.inputTinhTong = tongTien;

				// Lấy danh sách sản phẩm trong đơn hàng
				$http.get('/donhang/chitiet/' + donhang.idHd)
					.then(function(resp) {
						$scope.danhSachSanPham = resp.data;
					})
					.catch(function(error) {
						console.log('Lỗi khi lấy danh sách sản phẩm trong đơn hàng: ' + error);
					});

				var url = 'redirect:/quanLyDonHang/list';
				window.location.href = url;

				console.log($scope.danhSachSanPham);
				console.log($scope.donhang.taiKhoan);
			});
	}
	//cập nhật trạng thái
	$scope.updateHoaDon = function() {
		// Thực hiện logic cập nhật hóa đơn ở đây
		// Gửi yêu cầu PUT đến API để cập nhật hóa đơn

		$http.put('/donhang/update/' + $scope.idHd, $scope.donhang)
			.then(function(response) {
				// Xử lý kết quả cập nhật thành công
				console.log("Cập nhật hóa đơn thành công!");
			}, function(error) {
				// Xử lý lỗi cập nhật hóa đơn
				console.error("Lỗi cập nhật hóa đơn:", error);
			});
	};
	//cập nhật trang thái

	$scope.openUpdatePage = function(idHd) {
		// Lưu trữ dữ liệu đơn hàng vào localStorage hoặc service
		localStorage.setItem('donhang', JSON.stringify($scope.donhang));
		var donhang = JSON.parse(localStorage.getItem('donhang'));
		// Sử dụng dữ liệu đơn hàng để hiển thị và cập nhật trạng thái

		// Chuyển đến trang cập nhật trạng thái
		$window.location.href = '/quanLyDonHang/capNhatTrangThai?idHd=' + idHd;
	};

	//Tìm kiếm sản phẩm
	$scope.searchTerm = '';
	$scope.filterItems = function() {
		return function(donhang) {
			if (!$scope.searchTerm) {
				return true; // Hiển thị tất cả các phần tử nếu searchTerm là rỗng
			}

			if (donhang.name.toLowerCase().includes($scope.searchTerm.toLowerCase())) {
				return true; // Kiểm tra nếu từ khóa tìm kiếm tồn tại trong tên thương hiệu
			}

			return false; // Nếu không tìm thấy từ khóa tìm kiếm trong tên thương hiệu, trả về false
		};
	};

	$scope.filteredItems = function() {
		var filtered = $scope.donhangs.filter($scope.filterItems());
		$scope.pager.count = Math.ceil(1.0 * filtered.length / $scope.pager.size);
		return filtered;
	};

	$scope.pager = {
		page: 0,
		size: 5,
		get donhangs() {
			if (this.page < 0) {
				this.last();
			}
			if (this.page >= this.count) {
				this.first();
			}
			var start = this.page * this.size;
			return $scope.donhangs.slice(start, start + this.size)
		},
		get count() {
			return Math.ceil(1.0 * $scope.donhangs.length / this.size);
		},
		first() {
			this.page = 0;
		},
		last() {
			this.page = this.count - 1;
		},
		next() {
			this.page++;
			if (this.page >= this.count) {
				this.first();
			}
		},
		prev() {
			this.page--;
			if (this.page < 0) {
				this.last();
			}
		}
	}





}

)
