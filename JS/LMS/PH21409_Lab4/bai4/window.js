var windowChild;

function new_tab() {
    windowChild = window.open("http://www.google.com.vn/", "timkiem",
        "menubar = yes, toolbar = yes, width = 150, height = 150");
}

function close_tab() {
    windowChild.close();
}

function kiem_tra() {
    if (windowChild.closed)
        alert("Cửa sổ mới đã đóng!");
    else
        alert("Cửa sổ mới chưa được đóng!");
}