package org.example;

//백준 14247번 '나무 자르기' / 실버 2 / 40분

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int [] treeLength;
    static int [] growLength;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        treeLength = new int [N];
        growLength = new int [N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            treeLength[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            growLength[i] = Integer.parseInt(st.nextToken());
        }

        //Main Logic
        int length = 0;
        int max = -1;
        int maxIndex = -1;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < treeLength.length; j++) {
                if(treeLength[j] > max){
                    max = treeLength[j];
                    maxIndex = j;
                }
            }
            length+=max;
            treeLength[maxIndex] = 0;

            growTree(N);

        }

        System.out.println(length);
    }

    static void growTree(int N){
        for (int i = 0; i < N; i++) {
            treeLength[i] += growLength[i];
        }
    }


}
