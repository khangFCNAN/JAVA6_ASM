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



