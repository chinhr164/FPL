function table() {
    var tbody = document.querySelector('.box tbody');
    var tr = tbody.children;
    for (var i = 0; i < tr.length; i++) {
        var td = tr[i].children;
        var tong = (Number(td[3].innerText) + Number(td[4].innerText)) / 2
        td[5].innerText = tong;
    }
}

function color() {
    var tbody = document.querySelector('.box tbody');
    var tr = tbody.children;
    var mark = document.querySelector('input[name=mark]:checked');
    for (var i = 0; i < tr.length; i++) {
        var td = tr[i].children;
        if (mark.value == 1) {
            if (Number(td[5].innerText) >= 5) {
                tr[i].style.backgroundColor = 'azure';
            } else
                tr[i].style.backgroundColor = 'white';
        } else {
            if (Number(td[5].innerText) < 5) {
                tr[i].style.backgroundColor = 'red';
            } else
                tr[i].style.backgroundColor = 'white';
        }
    }
}