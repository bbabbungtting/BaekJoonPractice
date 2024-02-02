//백준 1874번 '스택 수열' / 실버 2 / 60분 / stack

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static Stack<Integer> stack = new Stack<>();
    static int count = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            int input = Integer.parseInt(br.readLine());
            if(stack.contains(input) && stack.peek()!=input){
                System.out.println("NO");
                return;
            }
            for(int j=count;j<=input;j++){
                stack.push(count);
                count++;
                sb.append("+\n");
            }
            stack.pop();
            sb.append("-\n");
        }

        System.out.println(sb.toString());
    }
}
