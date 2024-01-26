//백준 5430번 'AC' / 골드 5 / 150분
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        ArrayDeque<Integer> deque;
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for(int i=0;i<T;i++){
            String p = br.readLine();
            int n = Integer.parseInt(br.readLine());

            st = new StringTokenizer(br.readLine(),"[],");

            deque = new ArrayDeque<>();
            for(int j=0;j<n;j++){
                deque.add(Integer.parseInt(st.nextToken()));
            }
            AC(p,deque);
        }
        System.out.println(sb);
    }

    static void AC(String p, ArrayDeque<Integer> deque){
        boolean possible = true;

        for(char cmd:p.toCharArray()){
            if(cmd== 'R'){
                possible = !possible;
                continue;
            }

            if(possible){
                if(deque.pollFirst() == null){
                    sb.append("error\n");
                    return;
                }
            }
            else{
                if(deque.pollLast()==null){
                    sb.append("error\n");
                    return;
                }
            }
        }
        makePrintString(deque,possible);
    }

    static void makePrintString(ArrayDeque<Integer> deque, boolean possible){
        sb.append('[');
        if(deque.size()>0){
            if(possible){ //앞에서부터 출력
                sb.append(deque.pollFirst());
                while(!deque.isEmpty()){
                    sb.append(',').append(deque.pollFirst());
                }
            }
            else{ //뒤에서부터 출력
                sb.append(deque.pollLast());
                while(!deque.isEmpty()){
                    sb.append(',').append(deque.pollLast());
                }
            }
        }
        sb.append(']').append('\n');
    }

}
