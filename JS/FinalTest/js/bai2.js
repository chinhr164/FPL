var app = angular.module('zr', []);
app.controller('zr', function ($scope) {
    $scope.validate = function () {
        //1. Khách hàng
        if ($scope.name == null || $scope.name == "")
            $scope.name_error = "Vui lòng nhập tên KH";
        else
            $scope.name_error = "";

        //2. Loại hàng
        if ($scope.style == null || $scope.style == "")
            $scope.style_error = "Vui lòng chọn Loại hàng";
        else
            $scope.style_error = "";

        //3. Số lượng
        if ($scope.qty == "" || $scope.qty == null)
            $scope.qty_error = "Vui lòng nhập Số lượng";
        else
            $scope.qty_error = "";

        //4. Nơi nhận hàng
        if ($scope.address == null)
            $scope.address_error = "Vui lòng chọn Nơi nhận hàng";
        else
            $scope.address_error = "";

        //Thông báo đăng ký thành công
        if($scope.name != null && $scope.name != "" 
            && $scope.style != null && $scope.style != "" 
            && $scope.qty != "" && $scope.qty != null 
            && $scope.address != null){
              alert('Đặt mua thành công!!');
              location.reload();
            }
            
    };

    $scope.pay = function () {
        switch (Number($scope.style)) {
            case 0:
                $scope.price = "";
                break;

            case 1:
                $scope.price = 50000;
                break;

            case 2:
                $scope.price = 30000;
                break;

            case 3:
                $scope.price = 10000;
                break;
        }

        $scope.total = Number($scope.price) * Number($scope.qty);
    };

    $scope.check = function () {
        if ($scope.address == 1)
            return true;
        else
            return false;
    }

})