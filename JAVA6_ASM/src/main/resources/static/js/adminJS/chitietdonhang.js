const app = angular.module("app", []);
app.controller("donhangchitiet-ctrl", function($scope, $http) {
    $scope.donhangchitiet = {};

    var urlParams = new URLSearchParams(window.location.search);
    var idHd = urlParams.get(idHd);

    // Sử dụng idHd để thực hiện các xử lý tương ứng (ví dụ: gọi API để lấy thông tin hóa đơn)
    $scope.initialize = function() {
        if (!isNaN(idHd) && Number.isInteger(parseFloat(idHd))) {
            var idHdInt = parseInt(idHd);
            $http.get('/donhang/edit/' + idHdInt).then(resp => {
                $scope.donhangchitiet = resp.data;
                // nên copy ra, không nên bỏ thẳng vào.
                $scope.donhangchitiet = angular.copy($scope.donhangchitiet);

                // Ví dụ: In thông tin idHdInt ra console
                console.log(idHdInt);
            }).catch(error => {
                // Xử lý lỗi khi không thể lấy thông tin hóa đơn
                console.error(error);
            });
        } else {
            // Xử lý trường hợp idHd không hợp lệ
            console.error("idHd không phải là một số nguyên hợp lệ");
        }
    }
    
    $scope.initialize();
});