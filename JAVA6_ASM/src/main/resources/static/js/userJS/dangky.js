const app = angular.module("app", []);

app.controller("dangKyCtrl", function($scope, $http) {
  $scope.registerUser = function() {
    var taiKhoan = $scope.taiKhoan;
    var matKhau = $scope.matKhau;
    var nhapLaiMatKhau = $scope.nhapLaiMatKhau;
    var hoTen = $scope.hoTen;
    var email = $scope.email;

    var isValidForm = true;
    $scope.errors = {};

    if (!taiKhoan) {
      $scope.errors.taiKhoan = "Vui lòng nhập tài khoản";
      isValidForm = false;
    }
    if (!matKhau) {
      $scope.errors.matKhau = "Vui lòng nhập mật khẩu";
      isValidForm = false;
    }
    if (matKhau !== nhapLaiMatKhau) {
      $scope.errors.nhapLaiMatKhau = "Vui lòng nhập đúng mật khẩu";
      isValidForm = false;
    }
    if (!hoTen) {
      $scope.errors.hoTen = "Vui lòng nhập họ tên";
      isValidForm = false;
    }
    if (!email) {
      $scope.errors.email = "Vui lòng nhập email";
      isValidForm = false;
    }

    if (!isValidForm) {
      return;
    }

 $scope.sendConfirmationCode = function() {
    // Lấy giá trị mã xác nhận từ trường nhập liệu
    var maXacNhan = $scope.maXacNhan;

    // Kiểm tra tính hợp lệ của mã xác nhận
    var isValidCode = true;
    $scope.errors = {};

    // Kiểm tra mã xác nhận
    if (!maXacNhan) {
      $scope.errors.maXacNhan = "Vui lòng nhập mã xác nhận";
      isValidCode = false;
    }
    // Kiểm tra các điều kiện khác về mã xác nhận...

    // Nếu mã không hợp lệ, dừng lại và hiển thị lỗi
    if (!isValidCode) {
      return;
    }

    // Gửi yêu cầu POST chứa mã xác nhận từ phía người dùng đến máy chủ
    $http.post('/verifyCode', {
      code: maXacNhan
    }).then(function(response) {
      console.log(response.data); // In phản hồi từ server lên console

      // Xử lý phản hồi từ máy chủ sau khi kiểm tra mã xác nhận
      if (response.data.isValid) {
        console.log("Mã xác nhận hợp lệ. Tiếp tục xử lý đăng ký.");
        // Tiếp tục xử lý đăng ký sau khi mã xác nhận hợp lệ
      } else {
        console.log("Mã xác nhận không hợp lệ. Vui lòng kiểm tra lại.");
        // Hiển thị thông báo lỗi về mã xác nhận không hợp lệ
      }
    }).catch(function(error) {
      console.log(error); // In lỗi từ server lên console
    });

    // Xóa giá trị trong trường nhập liệu mã xác nhận sau khi gửi đi
    $scope.maXacNhan = '';
  };

    const confirmationCode = Math.floor(100000 + Math.random() * 900000);

    const mailOptions = {
      from: 'phucltpc03359@fpt.edu.vn',
      to: email,
      subject: 'Mã xác nhận đăng ký',
      text: 'Mã xác nhận của bạn là: ' + confirmationCode
    };

    $http.post('/khachHang/create', {
      taiKhoan: taiKhoan,
      matKhau: matKhau,
      hoTen: hoTen,
      email: email
    }).then(function(response) {
      console.log(response.data); // In phản hồi từ server lên console
      transporter.sendMail(mailOptions, function(error, info) {
        if (error) {
          console.log(error);
        } else {
          console.log('Email sent: ' + info.response);
        }
      });
    }).catch(function(error) {
      console.log(error); // In lỗi từ server lên console
    });

    $scope.taiKhoan = '';
    $scope.matKhau = '';
    $scope.nhapLaiMatKhau = '';
    $scope.hoTen = '';
    $scope.email = '';
  }
});