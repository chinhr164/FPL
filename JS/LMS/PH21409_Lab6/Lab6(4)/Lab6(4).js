// Lấy giá trị từng thẻ input
function getValue(obj) {
    return document.querySelector(obj).value.trim();
}

// Hiện 'span' lỗi
function showError(obj, mess) {
    document.querySelector(obj + "_error").innerText = mess;
}

// Ẩn 'span' lỗi
function hideError(obj) {
    document.querySelector(obj + "_error").innerText = "";
}

// Láy thuộc tính style
function getStyle(obj) {
    return document.querySelector(obj).style;
}

function validate() {
    // 1. Họ
    var lastName = getValue("#lastName");
    if (lastName == "") {
        showError("#lastName", "Vui lòng nhập Họ");
        getStyle("#lastName").border = "1px solid red";
    } else {
        hideError("#lastName")
        getStyle("#lastName").border = "1px solid black";
    }

    //2. Tên
    var firstName = getValue("#firstName");
    if (firstName == "") {
        showError("#firstName", "Vui lòng nhập Tên");
        getStyle("#firstName").border = "1px solid red";
    } else {
        hideError("#firstName")
        getStyle("#firstName").border = "1px solid black";
    }

    //3. Ngày sinh
    var birthday = document.querySelectorAll(".birthday");
    var flag = true;

    for (var i = 0; i < birthday.length; i++) {
        if (birthday[i].value.trim() == "") {
            flag = !flag
            showError("#birthday", "Vui lòng nhập Ngày sinh");
            break;
        }
    }
    if (flag) {
        hideError("#birthday");
    }

    // 4. Giới tính
    var gender = document.querySelectorAll(".gender");
    var flag2 = true;

    for (var i = 0; i < gender.length; i++) {
        if (gender[i].checked) {
            flag2 = true;
            break;
        }
        if (i == length) {
            flag2 = false;
        }
    }
    if (flag2) {
        hideError("#gender");

    } else {
        showError("#gender", "Vui lòng chọn Giới tính");
    }

    // 5. Số điện thoại
    var tel = getValue("#tel");
    var telRexg = /^\d{10,11}$/

    if (!telRexg.test(tel) && tel != "") {
        showError("#tel", "Số điện thoại không hợp lệ");
        getStyle("#tel").border = "1px solid red";
    } else {
        hideError("#tel")
        getStyle("#tel").border = "1px solid black";
    }

    // 6. Sở thích
    var favor = document.querySelectorAll(".favor");
    var flag3 = true;

    for (var i = 0; i < favor.length; i++) {
        if (favor[i].checked) {
            flag3 = true;
            break;
        }
        if (i == length) {
            flag3 = false;
        }
    }
    if (flag3) {
        hideError("#favor");

    } else {
        showError("#favor", "Vui lòng chọn Sở thích");
    }

    if (lastName && firstName && flag && flag2 && (telRexg.test(tel) || tel == "") && flag3) {
        alert("Đăng ký thành công!");
        return true;
    } else
        return false;
}

// Xử lý ngày sinh
function birth() {
    var day = document.querySelectorAll(".birthday")[0];
    var month = day.nextElementSibling;
    var year = month.nextElementSibling;

    switch (Number(month.value)) {
        case 1: case 3: case 5: case 7: case 8: case 10: case 12:
            day.setAttribute("max", "31");
            break;

        case 4: case 6: case 9: case 11:
            day.setAttribute("max", "30");
            break;

        case 2:
            var y = Number(year.value)
            if (y % 4 == 0 && y % 100 != 0 || y % 400 == 0)
                day.setAttribute("max", "29");
            else
                day.setAttribute("max", "28");
            break;
    }
}

//Xử lý Sở thích
function favorD(obj) {
    if(obj.checked){
        obj.nextElementSibling.innerHTML = '&ensp;Khác:&ensp;<input type="text">'
    }else{
        obj.nextElementSibling.innerHTML = "&ensp;Khác"
    }
}
