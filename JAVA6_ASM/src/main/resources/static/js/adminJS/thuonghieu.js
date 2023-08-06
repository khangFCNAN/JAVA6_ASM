const app = angular.module("app", []);

app.controller("thuonghieu-ctrl", function($scope, $http) {
	// Quản lý thương hiệu
	$scope.thuonghieus = []; // Danh sách hiển thị
	$scope.thuonghieu = {}; // Biểu mẫu hiển thị
	let isEditing = false;
	// Hiển thị danh sách thương hiệu
	$scope.initialize = function() {
		$http.get("/thuongHieu/list").then(resp => {
			$scope.thuonghieus = resp.data;

		});
	};


	console.log($scope.thuonghieus);

	$scope.edit = function(thuonghieu) {
		document.getElementById('createButton').disabled = true;
		document.getElementById('updateButton').disabled = false;
		document.getElementById('resetButton').disabled = false;
		isEditing = true;
		$scope.form = angular.copy(thuonghieu);
	}

	//Thêm
	$scope.create = function() {
		var thuonghieu = angular.copy($scope.form);

		// Kiểm tra tên thương hiệu trống
		if (!thuonghieu.tenTh || thuonghieu.tenTh.trim() === '') {
			alert("Vui lòng nhập tên thương hiệu!");
			return;
		}

		// Kiểm tra trùng thương hiệu
		var isDuplicate = $scope.thuonghieus.some(function(item) {
			return item.tenTh === thuonghieu.tenTh;
		});

		if (isDuplicate) {
			alert("Thương hiệu đã tồn tại!");
			return;
		}

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
		var isDuplicate = false;

		// Kiểm tra trùng thương hiệu
		$scope.thuonghieus.forEach(function(item, i) {
			if (item.idTh !== thuonghieu.idTh && item.tenTh === thuonghieu.tenTh) {
				isDuplicate = true;
				return;
			}
		});

		if (isDuplicate) {
			alert("Thương hiệu đã tồn tại!");
			return;
		}

		$http.put(`/thuongHieu/update/${thuonghieu.idTh}`, thuonghieu).then(resp => {
			var index = $scope.thuonghieus.findIndex(p => p.idTh == thuonghieu.id);

			$scope.thuonghieus[index] = thuonghieu;
			alert("Cập nhật thành công!");
		}).catch(error => {
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
				alert("Không thể xóa thương hiệu đã liên kết với sản phẩm!");
				console.log("Error", error);
			})
		}
	}

	// check khoa nut
	function checkEditState() {
		if (isEditing) {
			document.getElementById('updateButton').disabled = false;
			document.getElementById('resetButton').disabled = false;
		} else {
			document.getElementById('updateButton').disabled = true;
			document.getElementById('resetButton').disabled = false;
		}
	}
	checkEditState();

	//Phân trang
	$scope.initialize();
	$scope.pager = {
		page: 0,
		size: 4,
		get thuonghieus() {
			if (this.page < 0) {
				this.last();
			}
			if (this.page >= this.count) {
				this.first();
			}
			var start = this.page * this.size;
			var sortedThuongHieus = $scope.thuonghieus.sort((a, b) => b.idTh - a.idTh); // Sắp xếp thương hiệu theo giảm dần của idTh
			return sortedThuongHieus.slice(start, start + this.size);
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
	};
});