var count = 1;
function danhDau(obj) {
    if (count % 2 != 0) {
        obj.innerText = "X"
        obj.style.backgroundColor = "aqua";

    } else {
        obj.innerText = "O"
        obj.style.backgroundColor = "yellow";
    }
    obj.style.boxShadow = "2px 2px 2px black"
    obj.setAttribute('disable','true');
    if (count == 9) {
        alert("Trò chơi kết thúc!!!");
        location.reload();
    }
    count++;
}