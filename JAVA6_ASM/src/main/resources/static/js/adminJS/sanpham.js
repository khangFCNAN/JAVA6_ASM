const app = angular.module("app", []);
app.controller("sanpham-ctrl", function($scope, $http) {
	//quan ly san pham
	let isEditing = false;

	$scope.searchTerm = '';
	$scope.sanphams = []; //show list
	$scope.sanpham = {}; //show form
	$scope.loaisanphams = []; //show loai san pham
	$scope.thuonghieus = []; //show thuong hieu
	//show list san pham
	$scope.initialize = function() {
		//Lấy dữ liệu từ thương hiệu đổ lên combobox
		$http.get("/sanpham/list").then(resp => {
			$scope.sanphams = resp.data;

		})
		//Lấy dữ liệu loại sản phẩm đổ lên combobox từ loại sản phẩm
		$http.get("/loaisanpham/list").then(resp => {
			$scope.loaisanphams = resp.data;
		})
		$http.get("/thuongHieu/list").then(resp => { // đến ipa
			$scope.thuonghieus = resp.data;
			//tạo hàm sắp xếp từ cao xuống thấp dựa trên idSp kiểu integer
			$scope.sanphams.sort(function(a, b) {
				return b.idSp - a.idSp;
			});
			//Duyệt từng sản phẩm trong mảng thành từng đối tượng
			$scope.sanphams.forEach(sanpham => {
				sanpham.ngayTao = new Date(sanpham.ngayTao)
			})
		});

	}

	console.log($scope.sanphams); //in ra console xem có dữ liệu chưa

	//nut edit
	$scope.edit = function(sanpham) {
		$scope.sanpham = angular.copy(sanpham); // nên copy ra, không nên bõ thẳng vào.
		isEditing = true;
		document.getElementById('createButton').disabled = true;
		document.getElementById('updateButton').disabled = false;
		document.getElementById('resetButton').disabled = false;
	}


	//thay đổi ảnh ngay lập tức khi có thao tác thay đổi ảnh
	$scope.imageChanged = function(files) {
		var data = new FormData();
		data.append('file', files[0]);
		$http.post('/rest/upload/sanphams', data, {
			transformRequest: angular.identity,
			headers: { 'Content-Type': undefined }
		}).then(resp => {
			$scope.sanpham.anhSp = resp.data.name;
		}).catch(error => {
			alert("Lỗi upload hình ảnh");
			console.log("Error", error);
		});
	};

	//Tìm kiếm sản phẩm
	$scope.filterItems = function() {
		return function(thuonghieu) {
			if (!$scope.searchTerm) {
				return true; // Hiển thị tất cả các phần tử nếu searchTerm là rỗng
			}

			if (thuonghieu.name.toLowerCase().includes($scope.searchTerm.toLowerCase())) {
				return true; // Kiểm tra nếu từ khóa tìm kiếm tồn tại trong tên thương hiệu
			}

			return false; // Nếu không tìm thấy từ khóa tìm kiếm trong tên thương hiệu, trả về false
		};
	};

	$scope.filteredItems = function() {
		var filtered = $scope.thuonghieus.filter($scope.filterItems());
		$scope.pager.count = Math.ceil(1.0 * filtered.length / $scope.pager.size);
		return filtered;
	};

	//Làm mới khi nhấn nút reset
	$scope.reset = function() {
		window.location.href = '/quanLySanPham/create';
	}

	//Thêm sản phẩm 
	$scope.create = function() {
		var sanpham = angular.copy($scope.sanpham);

		// Kiểm tra các trường bắt buộc trước khi thêm sản phẩm mới
		$scope.errors = {}; // Xóa thông báo lỗi cũ trước khi kiểm tra

		if (!sanpham.tenSp) {
			$scope.errors.tenSp = "Vui lòng nhập tên sản phẩm";
		}

		if (!sanpham.loaisanpham) {
			$scope.errors.loaisanpham = "Vui lòng chọn loại sản phẩm";
		}

		if (!sanpham.thuonghieu) {
			$scope.errors.thuonghieu = "Vui lòng chọn thương hiệu";
		}

		if (!sanpham.soLuong) {
			$scope.errors.soLuong = "Vui lòng nhập số lượng";
		}

		if (!sanpham.giaSp) {
			$scope.errors.giaSp = "Vui lòng nhập giá sản phẩm";
		}

		if (sanpham.baoHanh === undefined) {
			$scope.errors.baoHanh = "Vui lòng chọn bảo hành";
		}

		// Kiểm tra nếu có lỗi thì dừng việc thêm sản phẩm
		if (Object.keys($scope.errors).length > 0) {

			return;
		}

		$http.post(`/sanpham/create`, sanpham).then(resp => {
			resp.data.createDate = new Date(resp.data.createDate)
			$scope.sanphams.push(resp.data);
			//tạo hàm sắp xếp từ cao xuống thấp dựa trên idSp kiểu integer
			$scope.sanphams.sort(function(a, b) {
				return b.idSp - a.idSp;
			});
			$scope.reset();
			alert("Thêm mới sản phẩm thành công!");
		}).catch(error => {
			alert("Lỗi thêm mới sản phẩm!");
			console.log("Error", error);
		});
	}

	//Cập nhật sản phẩm
	$scope.update = function() {
		var sanpham = angular.copy($scope.sanpham);
		// Kiểm tra các trường bắt buộc trước khi thêm sản phẩm mới
		$scope.errors = {}; // Xóa thông báo lỗi cũ trước khi kiểm tra

		var checkerror = false;

			if (!sanpham.giaSp) {
				$scope.errors.giaSp = "Vui lòng nhập giá sản phẩm";
			}

			if (sanpham.baoHanh === undefined) {
				$scope.errors.baoHanh = "Vui lòng chọn bảo hành";
			}

			if (!sanpham.tenSp) {
				$scope.errors.tenSp = "Vui lòng nhập tên sản phẩm";
			}

			if (!sanpham.loaisanpham) {
				$scope.errors.loaisanpham = "Vui lòng chọn loại sản phẩm";
			}

			if (!sanpham.thuonghieu) {
				$scope.errors.thuonghieu = "Vui lòng chọn thương hiệu";
			}

			if(sanpham.soLuong === 0){
				$scope.errors.soLuong = "Vui lòng nhập số lượng";
				
				if(sanpham.soLuong < 0){
				$scope.errors.soLuong = "Vui lòng nhập sóo luon";
			}
			}
			
			
			


		// Kiểm tra nếu có lỗi thì dừng việc thêm sản phẩm
		if (Object.keys($scope.errors).length > 0) {
			return;
		}
		if(checkerror === true){
			
		}
		$http.put(`/sanpham/update/${sanpham.idSp}`, sanpham).then(resp => {
			var index = $scope.sanphams.findIndex(p => p.id == sanpham.idSp);
			$scope.sanphams[index] = sanpham;
			//tạo hàm sắp xếp từ cao xuống thấp dựa trên idSp kiểu integer
			$scope.sanphams.sort(function(a, b) {
				return b.idSp - a.idSp;
			});
			$scope.reset();
			alert("Cập nhật sản phẩm thành công!");
			window.location.href = '/quanLySanPham/update/' + sanpham.idSp;
		})
			.catch(error => {
				alert("Lỗi cập nhật sản phẩm!");
				console.log("Error", error);
			});
	}

	// Xóa sản phẩm
	$scope.delete = function(sanpham) {
		if (confirm("Bạn muốn xóa sản phẩm này?")) {
			$http.delete(`/sanpham/delete/${sanpham.idSp}`).then(resp => {
				var index = $scope.sanphams.findIndex(p => p.id == sanpham.idSp);
				$scope.sanphams.splice(index, 1);
				alert("Xóa sản phẩm thành công!");
				window.location.href = '/quanLySanPham/delete/' + sanpham.idSp;
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

	//tìm kiếm
	$scope.searchKeyword = ""; // Khởi tạo từ khóa tìm kiếm

	$scope.search = function() {
		var keyword = $scope.searchKeyword.toLowerCase();
		// Lọc sản phẩm dựa trên từ khóa tìm kiếm
		$scope.sanphams = $scope.sanphams.filter(function(sanpham) {
			return sanpham.tenSp.toLowerCase().includes(keyword) ||
				sanpham.moTa.toLowerCase().includes(keyword) ||
				sanpham.loaisanpham.tenLoai.toLowerCase().includes(keyword) ||
				sanpham.sanpham.tenTh.toLowerCase().includes(keyword);
		});
	};
	//Action 
	$scope.initialize();

	//Phân trang
	$scope.pager = {
		page: 0,
		size: 3,
		get sanphams() {
			if (this.page < 0) {
				this.last();
			}
			if (this.page >= this.count) {
				this.first();
			}
			var start = this.page * this.size;
			return $scope.sanphams.slice(start, start + this.size)
		},
		get count() {
			return Math.ceil(1.0 * $scope.sanphams.length / this.size);
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