//백준 14916번 '거스름돈' / 실버 5 / 20분 / greedy

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        System.out.println(exchangeAll(N, N / 5));
    }

    static int exchangeAll(int N, int num5) {
        int num2 = exchange2(N - num5 * 5);

        if (num2 == -1) {
            if (num5 == 0) {
                return -1;
            }
            else{
                //5원의 개수를 줄여서 재귀
                return exchangeAll(N, num5 - 1);
            }
        } else {
            return num5 + num2;
        }
    }

    //2원으로 거슬러 줄 수 있는지
    static int exchange2(int n) {
        if (n % 2 == 0) {
            return n / 2;
        } else {
            return -1;
        }
    }
}
