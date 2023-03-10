// Lấy giá trị của một input
function getValue(id) {
    return document.getElementById(id).value.trim();
}

// Hiển thị lỗi
function showError(key, mess) {
    document.getElementById(key + "_error").innerHTML = mess;
}

// Ẩn lôi
function hideError(key) {
    document.getElementById(key + "_error").innerHTML = "";
}

// Định dạng của một input
function setStyle(id) {
    return document.getElementById(id).style;
}

function validate() {
    // 1. Mã sinh viên
    var idSV = getValue("idSV");
    var idCheck = /^\w{2}\d{5}$/
    if (idSV == "" || idSV == null) {
        showError("idSV", "Vui lòng nhập mã sinh viên");
        setStyle("idSV").border = "1px solid red";
    } else if (!idCheck.test(idSV)) {
        showError("idSV", "Vui lòng nhập đúng định dạng mã sinh viên");
        setStyle("idSV").border = "1px solid red";
    }
    else {
        hideError("idSV");
        setStyle("idSV").border = "1px solid black";
    }


    // 2. password
    var name = getValue("name");
    if (name == "" || name == null) {
        showError("name", "Vưi lòng nhập tên sinh viên");
        setStyle("name").border = "1px solid red";
    } else {
        hideError("name");
        setStyle("name").border = "1px solid black";
    }


    // 3. email
    var email = getValue("email");
    var reGex = /^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\.[a-zA-Z0-9-]+)*$/;
    if (email == "" || email == null) {
        showError("email", "Vui lòng nhập email");
        setStyle("email").border = "1px solid red";
    } else if (!reGex.test(email)) {
        showError("email", "Email không hợp lệ - VD: chinhcv@gmail.com");
        setStyle("email").border = "1px solid red";
    }
    else {
        hideError("email");
        setStyle("email").border = "1px solid black";
    }

    // 4. Giới tính
    var gender = document.getElementsByName("gender");
    for (var i = 0; i < gender.length; i++) {
        if (gender[i].checked) {
            hideError("gender");
            setStyle("gender").border = "1px solid black";
            break;
        }
        if (!gender[i].checked && i == gender.length - 1) {
            showError("gender", "Vui lòng chọn giới tính");
            setStyle("gender").border = "1px solid red";
        }
    }

    // 5. Sở thích
    var favorite = document.getElementsByName("favorite");
    for (var i = 0; i < favorite.length; i++) {
        if (favorite[i].checked) {
            hideError("favorite");
            setStyle("favorite").border = "1px solid black";
            break;
        }
        if (!favorite[i].checked && i == favorite.length - 1) {
            showError("favorite", "Vui lòng chọn sở thích");
            setStyle("favorite").border = "1px solid red";
        }
    }

    // 6. Quốc tịch
    var national = getValue("national");
    if (national == "" || national == null) {
        showError("national", "Vui lòng chọn quốc tịch");
        setStyle("national").border = "1px solid red";
    } else {
        hideError("national");
        setStyle("national").border = "1px solid black";
    }

    // 7. Ghi chú
    var note = getValue("note");
    if (note.length > 200) {
        showError("note", "Ghi chú tối đa 200 ký tự");
        setStyle("note").border = "1px solid red";
    } else {
        hideError("note");
        setStyle("note").border = "1px solid black";
    }

    return false;
}