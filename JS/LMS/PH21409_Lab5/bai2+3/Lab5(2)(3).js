function them(obj) {
    var row = obj.parentElement.parentElement.cloneNode(true);
    var cart = document.querySelector('#cart');

    cart.appendChild(row);
    var cartList = cart.children

    for (i = 0; i < cartList.length; i++) {
        var lastChild = cartList[i].lastElementChild.lastElementChild;
        cartList[i].lastElementChild.removeChild(lastChild);
        var newElement = document.createElement('button');
        newElement.innerText = 'Xóa'
        newElement.setAttribute('onclick', 'xoa(this)');
        cartList[i].lastElementChild.appendChild(newElement);
    }
    tongTien();
}

function xoa(obj) {
    var row = obj.parentElement.parentElement;
    var cart = document.querySelector('#cart');

    cart.removeChild(row);
    tongTien();
}

function tongTien() {
    var tr = document.querySelectorAll('#cart>tr')
    var total = 0;

    for (let i = 0; i < tr.length; i++) {
        var td = tr[i].firstElementChild.nextElementSibling.innerText;
        console.log(td);
        total += Number(td);
        console.log((total));
    }

    var tongTien = document.querySelector('#tongTien');
    if (total == 0)
        tongTien.innerHTML = "Không có sản phẩm";
    else if (total > 6000)
        tongTien.innerHTML = `Tổng: <span style="color:yellow; text-shadow: 0 0 2px rgb(255, 0, 0);">$${total}</span>`;
    else { 
        tongTien.innerHTML = `Tổng: <span>${total}</span>`;
    }
}