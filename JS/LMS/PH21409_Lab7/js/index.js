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
    if (idSV == "" || idSV == null) {
        showError("idSV", "Vui lòng nhập mã sinh viên");
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

setInterval(function () {
    var idSV = document.querySelector('#idSV').value.trim();
    var name = document.querySelector('#name').value.trim();
    var email = document.querySelector('#email').value.trim();
    var gender = document.querySelectorAll('input[name="gender"]:checked').length;
    var favor = document.querySelectorAll('input[name="favorite"]:checked').length;
    var national = document.querySelector('#national').value;
    console.log(idSV);
    console.log(name);
    console.log(email);
    console.log(gender);
    console.log(favor);
    console.log(national);

    var info = document.querySelector('.info').style;

    var idSV_I = document.querySelector('div.info .idSV').style;
    var name_I = document.querySelector('div.info .name').style;
    var email_I = document.querySelector('div.info .email').style;
    var gender_I = document.querySelector('div.info .gender').style;
    var favor_I = document.querySelector('div.info .favor').style;
    var national_I = document.querySelector('div.info .national').style;

    if (idSV == "" && name == "" && email == "" && gender == 0 && favor == 0 && national == "") {
        info.display = "none";
        idSV_I.display = "none";
        name_I.display = "none";
        email_I.display = "none";
        gender_I.display = "none";
        favor_I.display = "none";
        national_I.display = "none";
    }
    else {
        info.display = "";
        if (idSV != "")
            idSV_I.display = "";
        else
            idSV_I.display = "none";

        if (name != "")
            name_I.display = "";
        else
            name_I.display = "none";

        if (email != "")
            email_I.display = "";
        else
            email_I.display = "none";

        if (gender > 0)
            gender_I.display = "";
        else
            gender_I.display = "none";

        if (favor > 0)
            favor_I.display = "";
        else
            favor_I.display = "none";

        if (national != "")
            national_I.display = "";
        else
            national_I.display = "none";
    }
}, 500)