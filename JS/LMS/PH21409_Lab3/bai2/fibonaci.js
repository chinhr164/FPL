function top10_Fibonaci() {
    var f0 = 1;
    var f1 = 1;
    document.write(f0 + ", " + f1);
    for (var i = 0; i < 8; i++) {
        var f = f0 + f1;
        f0 = f1;
        f1 = f;
        document.write(", "+f);
    }
}