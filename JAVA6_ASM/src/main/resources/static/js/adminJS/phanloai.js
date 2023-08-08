const app = angular.module("app", []);
app.controller("phanloai-ctrl", function($scope, $http) {
	//quan ly phan loai
	let isEditing = false;

	$scope.phanloais = []; //show list
	$scope.phanloai = {}; //show form

	//show list phan loai
	$scope.initialize = function() {
		$http.get("/loaisanpham/list").then(resp => {
			$scope.phanloais = resp.data;
			//tạo hàm sắp xếp từ cao xuống thấp dựa trên idSp kiểu integer
			$scope.phanloais.sort(function(a, b) {
				return b.idLoai - a.idLoai;
			});
		});
	}

	console.log($scope.phanloais); //in ra console xem có dữ liệu chưa

	//nut edit
	$scope.edit = function(phanloai) {
		$scope.phanloai = angular.copy(phanloai); // nên copy ra, không nên bõ thẳng vào.
		isEditing = true;
		document.getElementById('createButton').disabled = true;
		document.getElementById('updateButton').disabled = false;
		document.getElementById('resetButton').disabled = false;
	}


	$scope.reset = function() {
		window.location.href = '/quanLyLoaiSp/create';
	}

	//tìm kiếm loại
	$scope.searchTerm = '';
	$scope.filterItems = function() {
		return function(phanloai) {
			if (!$scope.searchTerm) {
				return true; // Hiển thị tất cả các phần tử nếu searchTerm là rỗng
			}

			if (phanloai.name.toLowerCase().includes($scope.searchTerm.toLowerCase())) {
				return true; // Kiểm tra nếu từ khóa tìm kiếm tồn tại trong tên thương hiệu
			}

			return false; // Nếu không tìm thấy từ khóa tìm kiếm trong tên thương hiệu, trả về false
		};
	};

	$scope.filteredItems = function() {
		var filtered = $scope.phanloais.filter($scope.filterItems());
		$scope.pager.count = Math.ceil(1.0 * filtered.length / $scope.pager.size);
		return filtered;
	};
	

	$scope.create = function() {
		var phanloai = angular.copy($scope.phanloai);
		//xóa báo lỗi trước khi kiểm tra
		
		$scope.errors = {};
		
		if (!phanloai.tenLoai) {
			$scope.errors.tenLoai = "Vui lòng nhập tên Loại";
		}
		// Kiểm tra nếu có lỗi thì dừng việc thêm loại
		if (Object.keys($scope.errors).length > 0) {
			return;
		}
		
		$http.post(`/loaisanpham/create`, phanloai).then(resp => {
			$scope.phanloais.push(resp.data);
			//tạo hàm sắp xếp từ cao xuống thấp dựa trên idSp kiểu integer
			$scope.phanloais.sort(function(a, b) {
				return b.idLoai - a.idLoai;
			});
			$scope.reset();
			alert("Thêm mới loại thành công!");
		}).catch(error => {
			alert("Lỗi thêm mới loại!");
			console.log("Error", error);
		});

	}

	$scope.update = function() {
		var phanloai = angular.copy($scope.phanloai);
		var checkerror = false;
		if (!phanloai.tenLoai) {
			$scope.errors.tenLoai = "Vui lòng nhập tên Loại";
		}
		// Kiểm tra nếu có lỗi thì dừng việc thêm loại
		if (Object.keys($scope.errors).length > 0) {
			return;
		}


		$http.put(`/loaisanpham/update/${phanloai.idLoai}`, phanloai).then(resp => {
			var index = $scope.phanloais.findIndex(p => p.id == phanloai.idLoai);
			$scope.phanloais[index] = phanloai;
			$scope.phanloais.sort(function(a, b) {
				return b.idLoai - a.idLoai;
			});
			$scope.reset();
			alert("Cập nhật loại thành công!");
			window.location.href = '/quanLyLoaiSp/update/' + phanloai.idLoai;
		})
			.catch(error => {
				alert("Lỗi cập nhật sản phẩm!");
				console.log("Error", error);
			});
	}

	$scope.delete = function(phanloai) {
		if (confirm("Bạn muốn xóa sản phẩm này?")) {
			$http.delete(`/loaisanpham/delete/${phanloai.idLoai}`).then(resp => {
				var index = $scope.phanloais.findIndex(p => p.idLoai == phanloai.idLoai);
				$scope.phanloais.splice(index, 1);
				alert("Xóa sản phẩm thành công!");
				window.location.href = '/quanLyLoaiSp/delete/' + phanloai.idLoai;
			}).catch(error => {
				alert("Lỗi xóa sản phẩm!");
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

	$scope.initialize();
	$scope.pager = {
		page: 0,
		size: 5,
		get phanloais() {
			if (this.page < 0) {
				this.last();
			}
			if (this.page >= this.count) {
				this.first();
			}
			var start = this.page * this.size;
			return $scope.phanloais.slice(start, start + this.size)
		},
		get count() {
			return Math.ceil(1.0 * $scope.phanloais.length / this.size);
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
	// chạy giao diện

});