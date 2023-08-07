const app = angular.module("app", []);
app.controller("sanpham-ctrl", function($scope, $http){
	//quan ly san pham
	$scope.sanphams = []; //show list
	$scope.sanpham = {}; //show form
	$scope.loaisanphams = []; //show loai san pham
	$scope.thuonghieus = []; //show thuong hieu
	//show list san pham
	$scope.initialize = function(){
		$http.get("/thuongHieu/list").then(resp => {
			$scope.thuonghieus = resp.data;
		})
		$http.get("/loaisanpham/list").then(resp => {
			$scope.loaisanphams = resp.data;
		})
		$http.get("/sanpham/list").then(resp => { // đến ipa
			$scope.sanphams = resp.data;
				$scope.sanphams.forEach(sanpham => {
				sanpham.createDate = new Date(sanpham.createDate)
			})
		});
		
	}
	$scope.initialize(); // chạy giao diện
	console.log($scope.sanphams); //in ra console xem có dữ liệu chưa
	
	//nut edit
	$scope.edit = function(sanpham){
		$scope.sanpham = angular.copy(sanpham); // nên copy ra, không nên bõ thẳng vào.
	}
	
	$scope.reset = function(){
		$scope.form = {
			createDate: new Date(),
			available: true,
			image: "cloud-upload.jpg"
		}
	}
	
	$scope.pager = {
		page: 0,
		size: 10,
		get items(){
			if(this.page < 0){
				this.last();
			}
			if(this.page >= this.count){
				this.first();
			}
			var start = this.page*this.size;
			return $scope.items.slice(start, start + this.size)
		},
		get count(){
			return Math.ceil(1.0 * $scope.items.length / this.size);
		},
		first(){
			this.page = 0;
		},
		last(){
			this.page = this.count - 1;
		},
		next(){
			this.page++;
		},
		prev(){
			this.page--;
		}
	}
})