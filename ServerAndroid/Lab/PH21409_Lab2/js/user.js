//Đọc thông tin thuộc tính thẻ
var tbody = document.querySelector('tbody');
var rowList = tbody.children;

for (i = 0; i < rowList.length; i++) {
    var statusS = rowList[i].lastElementChild.previousElementSibling;
    if (statusS.textContent == 'Active')
        statusS.setAttribute('style', 'color:green')
    else
        statusS.setAttribute('style', 'color:red')
}