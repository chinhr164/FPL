package com.poly.lab1;

public class NoTaxProduct extends Product {
    public NoTaxProduct() {}

    public NoTaxProduct(String name, double price) {
        super(name, price);
    }

    @Override
    public double getImportTax() {
        return 0;
    }

    @Override
    public void nhap() {
        super.nhap();
    }

    @Override
    public void xuat(int index) {
        super.xuat(index);
    }
}
