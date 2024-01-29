package org.example;

import java.util.*;

public class Main {
    public static void main(String[] args)  {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        String lastInput;
        Stack<String> stack = new Stack<>();

        for(int i=0;i<N;i++){
            String input = sc.next();

            for(int j=0;j<input.length();j++){
                if(input.charAt(j)==')'){
                    if(!stack.isEmpty()){
                        lastInput=stack.lastElement();
                        if(lastInput == "("){
                            stack.pop();
                        }
                        else{
                            break;
                        }
                    }
                }
                else{
                    stack.push("" + input.charAt(j));
                }
            }
            if(stack.isEmpty()){
                System.out.println("YES");
            }
            else{
                System.out.println("NO");
            }
        }

    }
}
