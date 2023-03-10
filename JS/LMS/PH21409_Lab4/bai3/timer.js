var now = new Date();

setTimeout(function () {
    var h = now.getHours();
    var m = now.getMinutes();
    var s = now.getSeconds();

    document.write("<b><h1 align=\"center\">" + h + " : " + m + " : " + s + "</h1></b>");
    location.reload();
}, 1000)