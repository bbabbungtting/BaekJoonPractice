//백준 1927번 '최소힙' / 실버 2 / 15분

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            int input = sc.nextInt();
            if(input==0){
                if(minHeap.isEmpty()){
                    System.out.println(0);
                }
                else{
                    System.out.println(minHeap.poll());
                }
            }
            else{
                minHeap.add(input);
            }
        }
    }
}