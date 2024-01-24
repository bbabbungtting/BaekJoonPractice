//백준 20125번 '쿠키의 신체 측정' / 실버 4 / 60분

import java.util.*;

public class Main {
    static char arr[][];
    static int N;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();

        arr = new char[N][N];

        for (int i = 0; i < N; i++) {
            String input = sc.next();
            for (int j = 0; j < N; j++) {
                arr[i][j] = input.charAt(j);
            }
        }
        for (int i = 1; i < N; i++) {
            for (int j = 1; j < N; j++) {
                if (arr[i][j] == '*') {
                    if (isHeart(i, j)) {
                        System.out.println((i + 1) + " " + (j + 1));
                        measureLength(i, j);
                        break;
                    }
                }
            }
        }
    }

    static void measureLength(int x, int y) {
        System.out.print(armLength(x, y, -1) + " ");
        System.out.print(armLength(x, y, 1) + " ");
        int waist = legLength(x + 1, y);
        System.out.print(waist + " ");
        System.out.print(legLength(x + waist + 1, y - 1) + " ");
        System.out.print(legLength(x + waist + 1, y + 1));
    }

    static int armLength(int x, int y, int way) {
        int length = 0;
        for (int i = y + way; 0 <= i && i < N; i += way) {
            if (arr[x][i] == '*') {
                length++;
            } else {
                break;
            }
        }
        return length;
    }

    static int legLength(int x, int y) {
        int length = 0;
        for (int i = x; i < N; i++) {
            if (arr[i][y] == '*') {
                length++;
            } else {
                break;
            }
        }
        return length;
    }

    //심장 찾기
    static boolean isHeart(int x, int y) {
        int[] check_x = {-1, 0, 1, 0};
        int[] check_y = {0, -1, 0, 1};

        for (int i = 0; i < 4; i++) {
            if (arr[x + check_x[i]][y + check_y[i]] == '_') {
                return false;
            }
        }
        return true;
    }
}