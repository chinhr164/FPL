var price = 18200;


function display() {
    var nameP = document.querySelector('label');
    var qty = document.querySelector('#qty');
    var name = document.querySelector('#name');
    var amount = document.querySelector('#amount');

    name.innerText = " " + nameP.innerHTML;
    name.style.color = "red"
    amount.innerText = " " + (Number(qty.value) * price)+"K (VND)";
    amount.style.color = "orange"


    return false;
}

