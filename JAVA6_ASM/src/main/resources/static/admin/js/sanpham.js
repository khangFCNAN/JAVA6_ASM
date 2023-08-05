app.controller("app", []){
	$scope.sanphams = [];
	$scope.sanpham = {};
	
	$scope.initialize = function(){
		$http.get("/sanpham/list").then(resp => {
			$scope.items = resp.data;
			$scope.items.forEach(item => {
				item.createDate = new Date(item.createDate)
			})
		});
	}
})