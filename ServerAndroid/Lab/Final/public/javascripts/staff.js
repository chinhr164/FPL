$(document).ready(function () {
    $('#staffTable tfoot th:gt(0)').each(function () {
        var title = $(this).text;
        $(this).html('<input type="text" class=""/>');
    });

    $('#staffTable').DataTable({
        dom: '<"top"t><"row"<"col-sm-12 col-md-5"i><"col-sm-12 col-md-7 dataTables_pager mt-2"<"mx-3 mt-1"l>p>><"clear">',
        "pagingType": "numbers",
        lengthMenu: [
            [10, 25, 50, -1],
            [10, 25, 50, 'Tất cả'],
        ],
        initComplete: function () {
            // Apply the search
            this.api()
                .columns()
                .every(function () {
                    var that = this;

                    $('input', this.footer()).on('keyup change clear', function () {
                        if (that.search() !== this.value) {
                            that.search(this.value).draw();
                        }
                    });
                });
        },
    });

})