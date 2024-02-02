//백준 9012번 '괄호' / 실버 4 / 30분 / stack

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        boolean complete = true;
        Stack<String> stack = new Stack<>();

        for (int i = 0; i < N; i++) {
            String input = sc.next();
            complete = true;
            stack.clear();

            for (int j = 0; j < input.length(); j++) {
                char ch = input.charAt(j);
                if (ch == '(') {
                    stack.push(String.valueOf(ch));
                } else {
                    if (stack.isEmpty()) {
                        complete = false;
                        break;
                    }
                    stack.pop();
                }
            }
            if (complete && stack.isEmpty()) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}
