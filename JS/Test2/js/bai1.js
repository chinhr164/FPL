//Lấy giá trị từng input
function getValue(key) {
    return document.querySelector(key).value.trim();
}

function validate() {
    //1. Họ tên
    var name = getValue('#name');
    if (name == "" || name == null)
        alert('Vui lòng nhập Họ tên');
    else if (name.length <8)
        alert('Họ tên tối thiểu 8 ký tự');

    //2. Giới tính
    var gender = document.querySelector('input[name=gender]:checked');
    if (gender == null) {
        alert('Vui lòng chọn Giới tính');
    }

    //3. Số điện thoại
    var tel = getValue('#tel');
    var telCheck = /0\d{9}/
    if (name == "" || name == null) {
        alert('Vui lòng nhập Số điện thoại');
    } else if (!telCheck.test(tel) || !(tel.length == 10)) {
        alert('Số điện thoại không đúng định dạng');
    }

    if (name != "" && name.length >= 8 && gender != null && telCheck.test(tel) && tel.length == 10) {
        alert('Đăng ký thành công');
        return true;
    } else
        return false;
}