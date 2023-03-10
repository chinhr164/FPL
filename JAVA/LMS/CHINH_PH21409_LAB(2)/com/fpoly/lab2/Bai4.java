package com.fpoly.lab2;

import java.util.Scanner;

public class Bai4 {

    public static void main(String [] arg) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print("\n+------------- MENU -------------+\n");
            System.out.print("\t1. Giải phương trình bậc nhất.\n");
            System.out.print("\t2. Giải phương trình bậc hai.\n");
            System.out.print("\t3. Tính tiền điện.\n");
            System.out.print("\t4. Kiểm tra số nguyên.\n");
            System.out.print("\t5. Tổng số âm mảng [n-0].\n");
            System.out.print("\t6. Kiểm tra số chính phương.\n");
            System.out.print("\t0. Thoát chương trình.\n");
            System.out.print("+--------------------------------+\n");
            System.out.print("Chọn chức năng: ");
            int cn = sc.nextInt();
            switch (cn) {
                case 1:
                    Bai1.main(arg);
                    break;

                case 2:
                    Bai2.main(arg);
                    break;

                case 3:
                    Bai3.main(arg);
                    break;

                case 4:
                    Bai6.main(arg);
                    break;

                case 5:
                    Bai7.main(arg);
                    break;

                case 6:
                    Bai8.main(arg);
                    break;
                case 0:
                    System.exit(0);

                default:
                    System.out.print("\n>>Chức năng được chọn nằm ngoài phạm vi.\n");
            }
        }
    }
}
