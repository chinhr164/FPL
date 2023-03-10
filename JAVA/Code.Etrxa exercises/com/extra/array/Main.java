package com.extra.array;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public void minMax(int[] arr) {

        int min = arr[0], index = 1,
                max = arr[0], index1 = 1;
        for (int i = 1; i < arr.length; i++) {
            if (min > arr[i]) {
                min = arr[i];
                index = i + 1;
            }
            if (max < arr[i]) {
                max = arr[i];
                index1 = i + 1;
            }
        }
        System.out.printf("\n>1< Số nhỏ nhất trong mảng: %d - Vị trí: %d", min, index);
        System.out.printf("\n>2< Số lớn nhất trong mảng: %d - Vị trí: %d", max, index1);
    }

    public void minMaxBietLap(int[] arr) {
        ArrayList<Integer> bietLap = new ArrayList<>();
        ArrayList<Integer> chiSo = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            int j = 0;
            for (; j < arr.length; j++) {
                if (arr[j] == arr[i]) {
                    break;
                }
            }
            if (j == arr.length) {
                bietLap.add(arr[i]);
                chiSo.add(i + 1);
            }
        }

        int min = bietLap.get(0), index = chiSo.get(0),
                max = bietLap.get(0), index1 = chiSo.get(0);
        for (int x : bietLap) {
            if (min > x) {
                min = x;
                index = chiSo.get(bietLap.indexOf(x));
            }
            if (max < x) {
                max = x;
                index1 = chiSo.get(bietLap.indexOf(x));
            }
        }
        if (bietLap.size() == 0) {
            System.out.print(">3< - >4< Mảng không có giá trị lớn nhất và nhỏ nhất"
                                     + " thoả mãn điểu kiện hông bằng số nào khác trong mảng.");
        } else {
            System.out.printf("\n>3< Số biệt lập nhỏ nhất trong mảng: %d - Vị trí: %d", min, index);
            System.out.printf("\n>4< Số biệt lập lớn nhất trong mảng: %d - Vị trí: %d", max,
                              index1);
        }
    }

    public void demSNT_HopSo(int[] arr) {
        int soNT = 0, hopSo = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] <= 1) {
                soNT--;
            }
            int j = 2;
            for (; j < arr[i]; j++) {
                if (arr[i] % j == 0) {
                    hopSo++;
                    break;
                }
            }
        }
        soNT += (arr.length - hopSo);
        System.out.printf("\n>5< Có %d hợp số trong mảng.", hopSo);
        System.out.printf("\n>6< Có %d số nguyên tố trong mảng.", Math.max(0, soNT));
    }

    public void soNT(int[] arr) {
        System.out.print("\n>7< Số nguyên tố trong mảng: ");
        for (int k : arr) {
            int j = 2;
            for (; j < k; j++) {
                if (k % j == 0) {
                    break;
                }
            }
            if (j == k) {
                System.out.printf("%4d", k);
            }
        }
    }


    public void softDown(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] < arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        System.out.print("\n>8< Mảng sắp xếp giảm dần:");
        for (int x : arr) {
            System.out.printf("%4d", x);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("\n>.< Nhập số lượng phần tử của mảng: ");
        int n = Integer.parseInt(sc.nextLine());
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            System.out.printf(" - Nhập phần tử thứ %d: ", i + 1);
            arr[i] = Integer.parseInt(sc.nextLine());
        }

        Main code = new Main();
        code.minMax(arr);
        code.minMaxBietLap(arr);
        code.demSNT_HopSo(arr);
        code.soNT(arr);
        code.softDown(arr);
    }
}
