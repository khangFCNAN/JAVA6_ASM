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

//Phân trang
	$scope.pager = {
		page: 0,
		size: 3,
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