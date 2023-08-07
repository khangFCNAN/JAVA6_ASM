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
		if (!isEditing) {
			document.getElementById('createButton').disabled = true;
			document.getElementById('updateButton').disabled = false;
			document.getElementById('resetButton').disabled = false;
		} else {
			document.getElementById('createButton').disabled = true;
			document.getElementById('updateButton').disabled = false;
			document.getElementById('resetButton').disabled = false;
		}

	}


	$scope.reset = function() {
		$scope.phanloai = {
			idLoai: '',
			tenLoai: ''

		};
		document.getElementById('createButton').disabled = false;
		document.getElementById('updateButton').disabled = true;
		document.getElementById('resetButton').disabled = false;
	}

	$scope.create = function() {
		var phanloai = angular.copy($scope.phanloai);


		// Kiểm tra các trường bắt buộc trước khi thêm sản phẩm mới
		$scope.errors = {}; // Xóa thông báo lỗi cũ trước khi kiểm tra

		if (!phanloai.tenLoai) {
			$scope.errors.tenLoai = "Vui lòng nhập tên Loại";
			
		}
		// Kiểm tra nếu có lỗi thì dừng việc thêm loại
		if (Object.keys($scope.errors).length > 0) {

			return;
		}


		$http.post(`/loaisanpham/create`, phanloai).then(resp => {
			resp.data.createDate = new Date(resp.data.createDate)
			$scope.phanloais.push(resp.data);
		
			$scope.reset();

			alert("Thêm mới sản phẩm thành công!");
		}).catch(error => {
			alert("Lỗi thêm mới loại!");
			console.log("Error", error);
		});
	}

	$scope.update = function() {
		var phanloai = angular.copy($scope.phanloai);
		$http.put(`/loaisanpham/update/${phanloai.idLoai}`, phanloai).then(resp => {
			var index = $scope.phanloais.findIndex(p => p.id == phanloai.idLoai);
			$scope.phanloais[index] = phanloai;
			$scope.reset();
			alert("Cập nhật sản phẩm thành công!");
			window.location.href = '/quanLyLoaiSp/delete/' + phanloai.idLoai;
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