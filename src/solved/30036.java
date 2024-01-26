// 백준 30036번 'INK' / 실버 1 / 100분
import org.w3c.dom.ls.LSOutput;

import java.util.*;

public class Main {
    static int I, N, K;
    static String ink;
    static int jumpNum;
    static char map[][];
    static Square square;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        I = sc.nextInt();
        N = sc.nextInt();
        K = sc.nextInt();

        map = new char[N][N];

        ink = sc.next();
        jumpNum = 0;

        for (int i = 0; i < N; i++) {
            String input = sc.next();
            for (int j = 0; j < N; j++) {
                map[i][j] = input.charAt(j);
                if (map[i][j] == '@') {
                    square = new Square(i, j);
                }
            }
        }

        String command = sc.next();

        for (int i = 0; i < K; i++) {
            doCommand(command.charAt(i));
        }
        //출력
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
    }

    static void doCommand(char command) {
        switch (command) {
            //이동
            case 'U':
                move(-1, 0);
                break;
            case 'D':
                move(1, 0);
                break;
            case 'L':
                move(0, -1);
                break;
            case 'R':
                move(0, 1);
                break;
            //잉크 충전
            case 'j':
                square.chargeInk();
                break;
            //점프 커맨드
            case 'J':
                jump(square.getPosition(), ink.charAt(jumpNum % I), square.getInk());
                jumpNum++;
                square.resetInk();
                break;
        }
    }



    static void jump(int[] position, char color, int inkAmount) {
        int x = position[0];
        int y = position[1];

        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(map[i][j]!='.' && map[i][j]!='@'){
                    if(Math.abs(x-i) + Math.abs(y-j) <= inkAmount){
                        map[i][j] = color;
                    }
                }
            }
        }
    }

    static void move(int x, int y) {
        int[] nowPosition = square.getPosition();
        int[] newPosition = {nowPosition[0] + x, nowPosition[1] + y};

        if (notMapOut(newPosition[0])) {
            if (notMapOut(newPosition[1])) {
                if (map[newPosition[0]][newPosition[1]] == '.') {
                    map[nowPosition[0]][nowPosition[1]] = '.';
                    map[newPosition[0]][newPosition[1]] = '@';
                    square.movePosition(newPosition);
                }
            }
        }

    }

    static boolean notMapOut(int x) {
        if (0 <= x && x < N) {
            return true;
        }
        return false;
    }
}

class Square {
    private int[] position = {0, 0};
    private int ink;

    Square(int x, int y) {
        this.position[0] = x;
        this.position[1] = y;
        ink = 0;
    }

    public int[] getPosition() {
        return position;
    }

    public void movePosition(int[] newPosition) {
        position = newPosition;
    }

    public void chargeInk() {
        ink++;
    }

    public int getInk(){
        return ink;
    }

    public void resetInk(){
        ink = 0;
    }
}