//백준 1780번 '종이의 개수' / 실버 2 / 50분

import java.util.*;

public class Main {
    static int arr[][];
    static int[] count = new int[3];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        divide(0, 0, n);

        System.out.println(count[0]);
        System.out.println(count[1]);
        System.out.println(count[2]);
    }

    static void divide(int row, int col, int n) {
        if (check(row, col, n)) {
            count[arr[row][col] + 1]++;
        } else {
            int s = n / 3;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    divide(row + s * i, col + s * j, s);
                }
            }
        }
    }

    static boolean check(int row, int col, int n) {
        int std = arr[row][col];
        for (int i = row; i < row + n; i++) {
            for (int j = col; j < col + n; j++) {
                if (std != arr[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}