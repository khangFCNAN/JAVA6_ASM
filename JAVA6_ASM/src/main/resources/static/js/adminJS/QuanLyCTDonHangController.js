app.controller('QuanLyCTDonHangController', function($scope, DonHangService) {
  var donhang = DonHangService.getDonHang();
  $scope.inputTaiKhoan = donhang.khachhang.taiKhoan;
  $scope.inputHoTen = donhang.khachhang.hoTen;
  // ... Các dòng code khác
});