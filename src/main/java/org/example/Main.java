package org.example;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int testCase = sc.nextInt();

        for(int i = 0;i<testCase;i++){
            //문서의 개수
            int N = sc.nextInt();
            //문서의 위치
            int M = sc.nextInt();
            int turn = 1;

            int [] arr = new int [N];

            for(int j=0;j<N;j++){
                arr[j] = sc.nextInt();
            }

            for(int j=0;j<N;j++){
                if(j<M){
                    if(arr[j] >=  arr[M]){
                        turn++;
                    }
                }
                if(M<j){
                    if(arr[j] >= arr[M]){
                        turn++;
                        for(int k = j;k<N;k++){
                            if(arr[k]>arr[j]){
                                turn--;
                                break;
                            }
                        }
                    }
                }
            }
            System.out.println(turn);
        }
    }
}