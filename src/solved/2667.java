//백준 2667번 '단지번호붙이기' / 실버 1 / 70분 / graph

import java.uti.*;

public class Main {
    static int[][] map;
    static int dx[] = {-1, 0, 1, 0};
    static int dy[] = {0, 1, 0, -1};

    static List<Integer> apt;
    static int N;
    static int cnt;

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();

        map = new int[N][N];

        apt = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            String[] strArr = sc.next().split("");

            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(strArr[j]);
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                cnt = 0;
                if (map[i][j] == 1) {
                    DFS(i, j);
                    apt.add(cnt);
                }
            }
        }
        Collections.sort(apt);

        System.out.println(apt.size());
        for (int num : apt) {
            System.out.println(num);
        }

    }

    public static void DFS(int i, int j) {
        map[i][j] += (1 + apt.size());
        cnt++;

        for (int k = 0; k < 4; k++) {
            int nx = i + dx[k];
            int ny = j + dy[k];

            if (check(nx, ny)) {
                DFS(nx, ny);
            }

        }

    }

    public static boolean check(int i, int j) {
        if (i < 0 || N <= i) {
            return false;
        }
        if (j < 0 || N <= j) {
            return false;
        }
        if (map[i][j] == 0) {
            return false;
        }
        if(map[i][j]==1){
            return true;
        }
        return false;
    }
}
