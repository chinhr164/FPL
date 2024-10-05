$(document).ready(function () {
    $('#example').DataTable({
        dom: "<'row'f>" + "t" + "<'row'<'col-sm-12 col-md-6 p-md-2'l><'col-sm-12 col-md-6'p>>",
        "pagingType": "numbers",
        initComplete: function () {
            var api = this.api();
            api.$('td').click(function () {
                api.search(this.innerHTML).draw();
            });
        },
        columnDefs: [
            {
                searchable: false,
                orderable: false,
                targets: 0,
            },
            {
                targets: -1,
                data: null,
                defaultContent: '<a id="update" style="color: darkorange">Sửa</a>' +'&ensp;'+ '<a id="delete" style="color: red">Xóa</a>',
            },
        ],
    });

    var table = $('#example').DataTable();

    table.on('order.dt search.dt', function () {
        let i = 1;

        table.cells(null, 0).every(function (cell) {
            this.data(i++);
        });
    }).draw();

    $('#example tbody').on('click', '#update', function () {
        var data = table.row($(this).parents('tr')).data();
        alert('Chức năng sửa chưa phát triển');
    });

    $('#example tbody').on('click', '#delete', function () {
        var data = table.row($(this).parents('tr')).data();
        alert('Chức năng xóa chưa phát triển');
    });
});

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