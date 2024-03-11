//백준 2579번 '계단 오르기' / 실버 3 / 50분 / DP

import java.io.BufferedReader;
import java.util.*;

public class Main {

    static Integer dp[];
    static int arr[];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        dp = new Integer[N + 1];
        arr = new int[N + 1];

        for (int i = 0; i < N; i++) {
            arr[i + 1] = sc.nextInt();
        }

        dp[0] = arr[0];
        dp[1] = arr[1];

        if (N >= 2) {
            dp[2] = arr[1] + arr[2];
        }
        System.out.println(find(N));
    }

    static int find(int N) {
        if (dp[N] == null) {
            dp[N] = Math.max(find(N - 2), find(N - 3) + arr[N - 1]) + arr[N];
        }
        return dp[N];
    }
}
