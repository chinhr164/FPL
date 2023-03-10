package com.extra.basic;

public class In_15_SoNguyenToDauTien {

    public static void main(String[] args) {
        System.out.print("\n\t>< 15 SỐ NGUYÊN TỐ ĐẦU TIÊN ><\n\n\t\t");
        int i = 0, j, breakL = 1, line = 0;
        while (breakL <= 15) {
            if (i == 2) {
                System.out.printf("%-6d", i);
                breakL++;
                line++;
            } else {
                for (j = 2; j < i; j++) {
                    if (i % j == 0) {
                        break;
                    }
                }
                if (j == i) {
                    System.out.printf("%-6d", i);
                    breakL++;
                    if (++line % 5 == 0) {
                        System.out.print("\n\t\t");
                    }
                }
            }
            i++;
        }
    }
}