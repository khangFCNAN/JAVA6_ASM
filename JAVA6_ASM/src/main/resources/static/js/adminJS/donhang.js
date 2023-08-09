const app = angular.module("app", []);
app.controller("donhang-ctrl", function($scope, $http) {
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


	//	function redirectToInvoice() {
	//  const button = document.getElementById('viewButton');
	//  const id = button.id;
	//
	//  // Chuyển đến trang khác và truyền dữ liệu qua
	//  window.location.href = 'quanLyChiTietDonhang.html?id=' + id;
	//}

//		$scope.edit = function(donhang) {
//			var idHd = donhang.idHd;
//			$http.get('/donhang/edit/'+ idHd).then(resp => {
//	        $scope.donhang = resp.data;
//	      	$scope.donhang = angular.copy(donhang);
//		    window.location.href = '/quanlyctdonhang/list?idHd='+ idHd;
//	    	})
//		}
//		console.log($scope.donhang);

//	$scope.edit = function(idHd) {
//		// Thực hiện yêu cầu HTTP để lấy thông tin đơn hàng dựa trên mã
//			var idHdInt  = parseInt(idHd);
//
//		$http.get('/donhang/edit/'+idHdInt)
//			.then(function(resp) {
//				resp.data.createDate = new Date(resp.data.createDate)
//				$scope.donhang = resp.data;
//				window.location.href = '/quanlyctdonhang/list?idHd='+ idHd;
//			});
//		console.log(idHd);
//	}

	$scope.edit = function(donhang) {
	    $http.get('/donhang/edit/' + donhang.idHd)
	        .then(function(resp) {
	            $scope.donhang = resp.data;
//	               // Lấy giá trị từng thuộc tính và gán vào các input
//	            $scope.inputTaiKhoan = $scope.donhang.khachhang.taiKhoan;
//	            $scope.inputHoTen = $scope.donhang.khachhang.hoTen;
//				$scope.inputSdt = $scope.donhang.sdt;
//	            $scope.inputNgayTao = $scope.donhang.ngayTao;
//	            $scope.inputEmail = $scope.donhang.khachhang.taiKhoan;
//	            $scope.inputIdHd = $scope.donhang.idHd;

				var taiKhoan = donhang.khachhang.taiKhoan;
				var hoTen = donhang.khachhang.hoTen;
				var sdt = donhang.sdt;
				var ngayTao = donhang.ngayTao;
				var email = donhang.khachhang.taiKhoan;
				var idHd = donhang.idHd;
	        
	        	 // Ví dụ: gán giá trị vào các trường input
			    $scope.inputTaiKhoan = taiKhoan;
			    $scope.inputHoTen = hoTen;
			    $scope.inputSdt = sdt;
			    $scope.inputNgayTao = ngayTao;
			    $scope.inputEmail = email;
			    $scope.inputIdHd = idHd;
	        
	            var url = 'redirect:/quanLyDonHang/list';
	            window.location.href = url;
	            
	            console.log($scope.donhang);
	        	 console.log($scope.donhang.taiKhoan);
	     });}
	//Tìm
	$scope.searchTerm = '';

	$scope.filterItems = function() {
		return function(donhang) {
			if (!$scope.searchTerm) {
				return true; // Hiển thị tất cả các phần tử nếu searchTerm là rỗng
			}

			if (donhang.name.toLowerCase().includes($scope.searchTerm.toLowerCase())) {
				return true; // Kiểm tra nếu từ khóa tìm kiếm tồn tại trong tên tài khoản
			}

			return false; // Nếu không tìm thấy từ khóa tìm kiếm trong tên tài khoản, trả về false
		};
	};

	$scope.filteredItems = function() {
		var filtered = $scope.thuonghieus.filter($scope.filterItems());
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





})
