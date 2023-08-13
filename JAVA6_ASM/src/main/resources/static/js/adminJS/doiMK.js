//const app = angular.module("app", []);
//
//app.controller("doiMKCtrl", function($scope, $http) {
//  $scope.doiMatKhau = function() {
//    var data = {
//      taiKhoan: $scope.taiKhoan,
//      matKhau: $scope.matKhau,
//      matKhauMoi: $scope.matKhauMoi,
//      xacNhanMatKhauMoi: $scope.xacNhanMatKhauMoi
//    };
//
//    $http({
//      method: 'POST',
//      url: '/api/doimatkhau',
//      data: data
//    })
//      .then(function(response) {
//        // Xử lý phản hồi từ API sau khi đổi mật khẩu thành công
//        console.log(response.data);
//      })
//      .catch(function(error) {
//        // Xử lý lỗi nếu có
//        console.error(error);
//      });
//  };
//});