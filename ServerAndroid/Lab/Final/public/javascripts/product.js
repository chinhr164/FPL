$(document).ready(function () {
    $('#prodTable tfoot th:gt(0)').each(function () {
        var title = $(this).text();
        $(this).html('<input type="text"/>');
    });

    $('#prodTable').DataTable({
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
                .every(function (indexInArray, valueOfElement) {
                    //Tìm kiếm theo phương thức select
                    if (indexInArray == 3 || indexInArray == 4) {
                        var column = this;
                        var select = $('<select class="py-1" ><option value=""></option></select>')
                            .appendTo($(column.footer()).empty())
                            .on('change', function () {
                                var val = $.fn.dataTable.util.escapeRegex($(this).val());
                                column.search(val ? '^' + val + '$' : '', true, false).draw();
                            });

                        column
                            .data()
                            .unique()
                            .sort()
                            .each(function (d, j) {
                                // d = d.substring(d.indexOf('">') + 2, d.indexOf('</a'));
                                select.append('<option value="' + d + '">' + d + '</option>');
                            });
                    }

                    //Tìm kiếm theo phương thức input
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