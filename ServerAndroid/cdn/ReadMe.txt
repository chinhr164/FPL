(*) import CSS:
 - cdn/bootstrap/css/bootstrap.min.css
 - cdn/datatables/css/dataTables.bootstrap5.css

(*) import JS:
 - cdn/bootstrap/js/bootstrap.bundle.js
 - cdn/jQuery/jquery-3.6.0.js
 - cdn/datatables/js/jquery.dataTables.js
 - cdn/datatables/js/dataTables.bootstrap5.js

(*) create one file JS include code:
  $(document).ready(function () {
      $('#example').DataTable();
  });

 - #example is id of <table>