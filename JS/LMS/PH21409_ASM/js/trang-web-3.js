//Tạo đối tượng SP
function Product(id, name, price, quantity, amount) {
    this.id = id;
    this.name = name;
    this.price = price;
    this.quantity = quantity;
    this.amount = amount;

    this.showRow = function () {
        const row = `
        <tr>
            <td class="checkColumn">
                <input type="checkbox" id="check${this.id}"
                    onchange="enable(this,${this.id})"
                    class="checkInput">
            </td>
            <td class="nameColumn">${this.name}</td>
            <td class="priceColumn">${this.price}</td>
            <td class="qtyColumn">
                <input type="number" min="0" id="qty${this.id}"
                value="${this.quantity > 0 ? this.quantity : ""}"
                disabled onchange="calculateAmount(this,${id},${this.price})"
                class="quantity">
            </td>
            <td class="amountColumn">
                <span id="amount${this.id}">
                    ${this.quantity > 0 ? this.quantity * this.price : ""}
                </span>
            </td>
        </tr>`;

        return row;
    }
}

//Tạo danh sách sản phẩm
const productlist = [
    new Product(1, "iPhone 9", 700, 0, 0),
    new Product(2, "Samsung", 400, 0, 0),
    new Product(3, "Nokia", 100, 0, 0),
    new Product(4, "Sony Xperia", 450, 0, 0),
    new Product(5, "Motorola", 180, 0, 0),
    new Product(6, "Oppo", 600, 0, 0),
    new Product(7, "bPhone", 90, 0, 0),
]

//Hiển thị sản phẩm theo mức giá
function filterPriceLevel() {
    const tbodyC = document.getElementById("tbody");
    const pricelvl = Number(document.getElementById("priceLevel").value);

    var tbodyContent = "";
    for (const element of productlist) {
        switch (pricelvl) {
            case 0:
                tbodyContent += element.showRow()
                break;

            case 1:
                if (0 < element.price && element.price <= 300)
                    tbodyContent += element.showRow()
                break;

            case 2:
                if (300 < element.price && element.price <= 700)
                    tbodyContent += element.showRow()
                break;

            case 3:
                if (700 < element.price && element.price <= 1000)
                    tbodyContent += element.showRow()
                break;

            case 4:
                if (element.price > 1000)
                    tbodyContent += element.showRow()
                break;
        }
        tbodyC.innerHTML = tbodyContent;
    }
}

//Bặt/tắt toàn bộ nhập số lượng
function checkAll(check){
    const checkInputC = document.getElementsByClassName("checkInput");

    for (const element of checkInputC) {
        element.checked = check.checked;
        var envent = new Event ("change");
        element.dispatchEvent(envent);
    }
}

//Cho phép chức năng kiêm tra hoạt động
function enable(check, id) {
    const qtyC = document.getElementById("qty" + id);
    if (check.checked)
        qtyC.removeAttribute("disabled");
    else {
        qtyC.setAttribute("disabled", "");
        const amountC = document.getElementById("amount" + id);
        amountC.innerText = "";
        qtyC.value = "";
    }
    calculateTotal();
}

//Hàm tính lại thành tiền
function calculateAmount(qty, id, price) {
    const value = Number(qty.value);
    const amountC = document.getElementById("amount" + id);

    if (value > 0)
        amountC.innerText = (value * price);
    else
        amountC.innerText = "";
    calculateTotal();
}

//Tính tổng tiền
function calculateTotal() {
    const amountSpans = document.getElementsByClassName("amountColumn");
    const totalSpan = document.getElementById("total");

    if (!!amountSpans && amountSpans.length > 0){
        var total = 0;

        for (const span of amountSpans) {
            if(span.innerText != "")
                total += Number(span.innerText);
        }
        totalSpan.innerText = total;
        return;
    }
    totalSpan.innerText = 0;
}