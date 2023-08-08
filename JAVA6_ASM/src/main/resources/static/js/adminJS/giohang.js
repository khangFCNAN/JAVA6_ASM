const app = angular.module("app", []);
app.controller("giohang-ctrl", function($scope, $http){
	// quản lý giỏ hàng
	var $cart = $scope.cart = {
        items: [],
         saveToLocalStorage(){ // lưu giỏ hàng vào local storage
        	var json = JSON.stringify(angular.copy(this.items));
            localStorage.setItem("cart", json);
        },
        loadFromLocalStorage(){ // đọc giỏ hàng từ local storage
            var json = localStorage.getItem("cart");
            this.items = json ? JSON.parse(json) : [];
        },
        add(id){ // thêm sản phẩm vào giỏ hàng
        	var item = this.items.find(item => item.idSp == id);
            if(item){
				console.log(item);
                item.soLuong++;
                this.saveToLocalStorage();
            }
            else{
            	 $http.get(`/sanpham/${id}`).then(resp => {
                    var newItem = resp.data;
                    newItem.soLuong = 1;
                    this.items.push(newItem);
                    this.saveToLocalStorage();
                });
            }
        },
        remove(id){ // xóa sản phẩm khỏi giỏ hàng
        	var index = this.items.findIndex(item => item.id == id);
            this.items.splice(index, 1);
            this.saveToLocalStorage();
        },
        clear(){ // Xóa sạch các mặt hàng trong giỏ
            this.items = []
            this.saveToLocalStorage();
        },
        amt_of(item){ // tính thành tiền của 1 sản phẩm
        	return item.giaSp * item.soLuong;
        },
        get count(){ // tính tổng số lượng các mặt hàng trong giỏ
            return this.items
            	.map(item => item.soLuong)
                .reduce((total, soLuong) => total += soLuong, 0);
        },
        get amount(){ // tổng thành tiền các mặt hàng trong giỏ
            return this.items
            	.map(item => this.amt_of(item))
                .reduce((total, amt) => total += amt, 0);
        }
       
    };
	
	$cart.loadFromLocalStorage();
	
	//đặt hàng
	$scope.order = {
		get account(){
				return {khachhang: $auth.user.taiKhoan}
			},
			
			createDate: new Date(),
			dChi: "",
			
			get orderDetails(){
				return $cart.items.map(item => {
					return {
						product:{id: item.id},
						price: item.price,
						quantity: item.qty
					}
				});
			},
			purchase(){
				var order = angular.copy(this);
				// Thực hiện đặt hàng
				$http.post("/donhang/create", order).then(resp => {
					resp.data.createDate = new Date(resp.data.createDate)
					alert("Đặt hàng thành công!");
					$cart.clear();
					location.href = "/quanLyDonHang/chiTietDonHang/" + resp.data.idHd;
				}).catch(error => {
					alert("Đặt hàng lỗi!")
					console.log(error)
				})
			}
	}
	// Tính tổng tiền trong giỏ hàng
		$scope.totalAmount = function() {
			return $scope.cart.items.reduce(function(total, item) {
				return total + $scope.cart.amt_of(item);
			}, 0);
		};
	
		// Tính tổng số sản phẩm trong giỏ hàng
		$scope.totalItems = function() {
			return $scope.cart.items.reduce(function(total, item) {
				return total + item.soLuong;
			}, 0);
		};

	})