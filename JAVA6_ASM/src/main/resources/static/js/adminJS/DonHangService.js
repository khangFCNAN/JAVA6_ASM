app.service('DonHangService', function() {
  var donhang = {}; // Đối tượng để lưu trữ dữ liệu donhang

  // Phương thức để đặt dữ liệu donhang
  this.setDonHang = function(data) {
    donhang = data;
  };

  // Phương thức để lấy dữ liệu donhang
  this.getDonHang = function() {
    return donhang;
  };
});