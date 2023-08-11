const app = angular.module("app", []);

angular.module("app").controller("update-status-ctrl", function($scope, $http, $window, $location) {
  // Lấy giá trị của tham số idHd từ URL
  var idHd = $location.search().idHd;

  // Lấy dữ liệu đơn hàng từ localStorage
  var donhang = JSON.parse(localStorage.getItem('donhang'));

  // Sử dụng dữ liệu đơn hàng
  $scope.donhang = donhang;

  // ...
});

// Trang cập nhật trạng thái (update-status.js)
//angular.module("app").controller("update-status-ctrl", function($scope, $http, $window, $location) {
//  // Lấy giá trị của tham số idHd từ URL
//  var idHd = $location.search().idHd;
//
//  // Lấy đơn hàng từ dịch vụ hoặc truy vấn API bằng idHd
//  $http.get('/donhang/edit/' + idHd)
//    .then(function(response) {
//      // Xử lý dữ liệu đơn hàng
//      var donhang = response.data;
//      // ...
//    })
//    .catch(function(error) {
//      // Xử lý lỗi
//      console.error(error);
//    });
//
//  // Các hàm và logic xử lý khác trong controller
//  // ...
//});

