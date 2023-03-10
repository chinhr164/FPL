package com.fpoly.assignment;

import java.util.Scanner;

public class HanhChinh extends NhanVien {

    public HanhChinh(){
    }

    public HanhChinh(String manv, String hoTen, double luong) {
        super(manv, hoTen, luong);
    }

    @Override
    public double getThuNhap() {
        return (getLuong());
    }
}
