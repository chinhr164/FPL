package com.extra.basic;

public class In5SoHoanHaoDauTien {

    public static void main(String[] args) {
        System.out.print("\n\t>< 5 SỐ HOẢN HẢO ĐẦU TIÊN ><\n\n\t");
        int i = 2, j, breakL = 1;
        while (breakL <= 5) {
            double SHH = Math.pow(2, i - 1) * (Math.pow(2, i) - 1);
            if (i == 2) {
                double shhM = Math.pow(2, i) - 1;
                int k = 2;
                for (; k < shhM; k++) {
                    if (shhM % k == 0) {
                        break;
                    }
                }
                if (k == shhM) {
                    System.out.printf("%-10.0f", SHH);
                    breakL++;
                }
            } else {
                for (j = 2; j < i; j++) {
                    if (i % j == 0) {
                        break;
                    }
                }
                if (j == i) {
                    double shhM = Math.pow(2, i) - 1;
                    int k = 2;
                    for (; k < shhM; k++) {
                        if (shhM % k == 0) {
                            break;
                        }
                    }
                    if (k == shhM) {
                        System.out.printf("%-10.0f", SHH);
                        breakL++;
                    }
                }
            }
            i++;
        }
    }
}



