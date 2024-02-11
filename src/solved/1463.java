//백준 1463번 '1로 만들기' / 실버 3 / 200분 / DP

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        System.out.println(DP(N, 0));
    }

    static int DP(int N, int count){
        if(N<2){
            return count;
        }

        return Math.min(DP(N/2,count+1+(N%2)),DP(N/3,count+1+(N%3)));
    }
}
