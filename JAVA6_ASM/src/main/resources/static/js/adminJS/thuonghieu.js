const app = angular.module("app", []);

app.controller("thuonghieu-ctrl", function($scope, $http) {
	// Quản lý thương hiệu
	$scope.thuonghieus = []; // Danh sách hiển thị
	$scope.thuonghieu = {}; // Biểu mẫu hiển thị

	// Hiển thị danh sách thương hiệu
	$scope.initialize = function() {
		$http.get("/thuongHieu/list").then(resp => {
			$scope.thuonghieus = resp.data;

		});
	};

	$scope.initialize();
	console.log($scope.thuonghieus);

	//edit
	$scope.edit = function(thuonghieu) {
		$scope.form = angular.copy(thuonghieu);
	}


	//Thêm
	$scope.create = function() {
		var thuonghieu = angular.copy($scope.form);
		$http.post(`/thuongHieu/create`, thuonghieu).then(resp => {
			alert("Thêm mới thương hiệu thành công!");
			$scope.thuonghieus.push(resp.data);

		}).catch(error => {
			alert("Lỗi thêm mới thương hiệu!");
			console.log("Error", error);
		});
	}

	//Sửa
	$scope.update = function() {
		var thuonghieu = angular.copy($scope.form);
		$http.put(`/thuongHieu/update/${thuonghieu.idTh}`, thuonghieu).then(resp => {
			var index = $scope.thuonghieus.findIndex(p => p.idTh == thuonghieu.id);
			$scope.thuonghieus[index] = thuonghieu;
			alert("Cập nhật thành công!");
		})
			.catch(error => {
				alert("Lỗi cập nhật!");
				console.log("Error", error);
			});
	}


	//Xóa 
	$scope.delete = function(thuonghieu) {
		if (confirm("Bạn muốn xóa sản phẩm này?")) {
			$http.delete(`/thuongHieu/delete/${thuonghieu.idTh}`).then(resp => {
				var index = $scope.thuonghieus.findIndex(p => p.idTh == thuonghieu.id);
				$scope.thuonghieus.splice(index, 0);
				$scope.initialize();
				alert("Xóa thành công!");
			}).catch(error => {
				alert("Lỗi xóa!");
				console.log("Error", error);
			})
		}
	}

	//Phân trang
	$scope.initialize();
	$scope.pager = {
		page: 0,
		size: 3,
		get thuonghieus() {
			if (this.page < 0) {
				this.last();
			}
			if (this.page >= this.count) {
				this.first();
			}
			var start = this.page * this.size;
			return $scope.thuonghieus.slice(start, start + this.size)
		},
		get count() {
			return Math.ceil(1.0 * $scope.thuonghieus.length / this.size);
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