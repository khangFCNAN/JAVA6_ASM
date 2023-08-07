const app = angular.module("app", []);

app.controller("khachhang-ctrl", function($scope, $http) {
	// Quản lý thương hiệu
	$scope.khachhangs = []; // Danh sách hiển thị
	$scope.khachhang = {}; // Biểu mẫu hiển thị

	// Hiển thị danh sách thương hiệu
	$scope.initialize = function() {
		$http.get("/khachHang/list").then(resp => {
			$scope.khachhangs = resp.data;

		});
	};
	$scope.initialize();
	console.log($scope.khachhangs);
	//Tìm 
	$scope.filterItems = function() {
		return function(khachhang) {
			if (!$scope.searchTerm) {
				return true; // Hiển thị tất cả các phần tử nếu searchTerm là rỗng
			}

			var searchTermWithoutDiacritics = removeDiacritics($scope.searchTerm.toLowerCase());
			var khachhangNameWithoutDiacritics = removeDiacritics(khachhang.name.toLowerCase());

			if (khachhangNameWithoutDiacritics.includes(searchTermWithoutDiacritics)) {
				return true; // Kiểm tra nếu từ khóa tìm kiếm tồn tại trong tên khách hàng (không có dấu)
			}

			return false; // Nếu không tìm thấy từ khóa tìm kiếm trong tên khách hàng, trả về false
		};
	};

	$scope.filteredItems = function() {
		var filtered = $scope.khachhangs.filter($scope.filterItems());
		$scope.pager.count = Math.ceil(1.0 * filtered.length / $scope.pager.size);
		return filtered;
	};

	// Hàm chuyển đổi chuỗi có dấu thành chuỗi không dấu
	function removeDiacritics(str) {
		return str.normalize('NFD').replace(/[\u0300-\u036f]/g, '');
	}
	//Phân trang
	$scope.pager = {
		page: 0,
		size: 7,
		get khachhangs() {
			if (this.page < 0) {
				this.last();
			}
			if (this.page >= this.count) {
				this.first();
			}
			var start = this.page * this.size;
			return $scope.khachhangs.slice(start, start + this.size)
		},
		get count() {
			return Math.ceil(1.0 * $scope.khachhangs.length / this.size);
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

});