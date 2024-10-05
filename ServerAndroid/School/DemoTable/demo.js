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
        ],
    });

    var table = $('#example').DataTable();
 
    table.on('order.dt search.dt', function () {
        let i = 1;
 
        table.cells(null, 0).every(function (cell) {
            this.data(i++);
        });
    }).draw();
});




