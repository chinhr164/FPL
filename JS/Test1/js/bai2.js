var app = angular.module("myApp", []);
app.controller("myController", function ($scope) {
    $scope.validate = function () {
        //1. Họ tên
        if ($scope.name == "" || $scope.name == null)
            $scope.name_error = "Vui lòng nhập Họ tên";
        else
            $scope.name_error = "";

        // 2. Emai
        var emailCheck = /[\w\d]+@[\w\d]+(\.[\w\d])+/;
        if ($scope.email == "" || $scope.email == null)
            $scope.email_error = "Vui lòng nhập Email";
        else if (!emailCheck.test($scope.email))
            $scope.email_error = "Email chưa đúng định dạng";
        else
            $scope.email_error = "";

        //3. Điện thoại
        var telCheck = /0\d{9}/;
        if ($scope.tel == "" || $scope.tel == null)
            $scope.tel_error = "Vui lòng nhập Số điện thoại";
        else if (!telCheck.test($scope.tel) || !($scope.tel.length == 10))
            $scope.tel_error = "Số điện thoại chưa đúng định dạng";
        else
            $scope.tel_error = "";

        //4. Khóa học
        if ($scope.less == "" || $scope.less == null)
            $scope.less_error = "Vui lòng chọn Khóa học";
        else
            $scope.less_error = "";

        // 5. Hình thức học
        if ($scope.form == null)
            $scope.form_error = "Vui lòng chọn Hình thức học";
        else
            $scope.form_error = "";

        if ($scope.name != null && emailCheck.test($scope.email) && telCheck.test($scope.tel) && $scope.tel.length == 10 && $scope.less != null &&  $scope.form != null)
            alert("Đăng ký thành công!!");
    };

    $scope.schoolFees = function () {
        switch (Number($scope.less)) {
            case 0:
                $scope.fee = "";
                break;

            case 1:
                $scope.fee = 500;
                break;

            case 2:
                $scope.fee = 800;
                break;

            case 3:
                $scope.fee = 1000;
                break;
        }
    }
});