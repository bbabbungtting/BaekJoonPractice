//백준 2839번 '설탕 배달' / 실버 4 / 10분 / greedy

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        System.out.println(countBag(N, N / 5));
    }

    static int countBag(int N, int num5) {
        int num3 = checkDivide3(N - num5 * 5);

        if (num3 == -1) {
            if (num5 == 0) {
                return -1;
            }
            else{
                return countBag(N, num5 - 1);
            }
        } else {
            return num5 + num3;
        }
    }

    static int checkDivide3(int n) {
        if (n % 3 == 0) {
            return n / 3;
        } else {
            return -1;
        }
    }
}
