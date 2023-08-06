const app = angular.module("app", []);
app.controller("phanloai-ctrl", function($scope, $http) {
	//quan ly phan loai
	let isEditing = false;

	$scope.phanloais = []; //show list
	$scope.phanloai = {}; //show form
	
	//show list phan loai
	$scope.initialize = function() {
		$http.get("/loaisanpham/list").then(resp => {
			$scope.thuonghieus = resp.data;

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
	$scope.reset = function() {
		$scope.sanpham = {
			idSp: '',
			tenSp: '',
			anhSp: '',
			giaSp: 0.0,
			idLoai: '',
			moTa: '',
			soLuong: 0,
			idTh: '',
			ngayTao: new Date(),
			anhSp: 'uploadAnh.png',
			baoHanh: true,
		};
	}

	$scope.create = function() {
		var sanpham = angular.copy($scope.sanpham);
		$http.post(`/sanpham/create`, sanpham).then(resp => {
			resp.data.createDate = new Date(resp.data.createDate)
			$scope.sanphams.push(resp.data);

			alert("Thêm mới sản phẩm thành công!");
		}).catch(error => {
			alert("Lỗi thêm mới sản phẩm!");
			console.log("Error", error);
		});
	}

	$scope.update = function() {
		var sanpham = angular.copy($scope.sanpham);
		$http.put(`/sanpham/update/${sanpham.idSp}`, sanpham).then(resp => {
			var index = $scope.sanphams.findIndex(p => p.id == sanpham.idSp);
			$scope.sanphams[index] = sanpham;
			alert("Cập nhật sản phẩm thành công!");
		})
			.catch(error => {
				alert("Lỗi cập nhật sản phẩm!");
				console.log("Error", error);
			});
	}

	$scope.delete = function(sanpham) {
		if (confirm("Bạn muốn xóa sản phẩm này?")) {
			$http.delete(`/sanpham/delete/${sanpham.idSp}`).then(resp => {
				var index = $scope.sanphams.findIndex(p => p.id == sanpham.idSp);
				$scope.sanphams.splice(index, 1);
				alert("Xóa sản phẩm thành công!");
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
	// chạy giao diện

});