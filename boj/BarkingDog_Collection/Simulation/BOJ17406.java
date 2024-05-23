package boj.BarkingDog_Collection.Simulation;

/**
 * 배열 돌리기 골드4
 * Simulation
 */
import java.util.*;
import java.io.*;
public class BOJ17406 {
    static int n,m,k;
    static int [][] rotate; // 회전 연산 저장소
    static boolean [] visited; // 백트래킹을 위한 visited
    static int [] arr;
    static int [][] init;
    static int [] arx = {0,1,0,-1}; // 오른쪽 아래 왼쪽 위
    static int [] ary = {1,0,-1,0};

    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); // 행
        m = Integer.parseInt(st.nextToken()); // 열
        k = Integer.parseInt(st.nextToken()); // 회전 연산 개수

        init = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                init[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        rotate = new int[k][3];
        arr = new int[k];
        visited = new boolean[k];
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                rotate[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        BackTracking(0);
        System.out.println(min);
    }
    public static void BackTracking(int depth){
        if(depth == k){
            check();
            return;
        }
        for (int i = 0; i < k; i++) {
            if(visited[i]) continue;
            arr[depth] = i;
            visited[i] = true;
            BackTracking(depth + 1);
            visited[i] = false;
        }

    }
    public static void check(){ // 회전
        int [][] copy = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                copy[i][j] = init[i][j];
            }
        }

        Deque<Integer> dq = new LinkedList<>();
        for (int i = 0; i < k; i++) {
            int [] calculate = rotate[arr[i]];
            int sx = calculate[0] - calculate[2] - 1; // 0
            int ex = calculate[0] + calculate[2] - 1; // 4
            int sy = calculate[1] - calculate[2] - 1; // 1
            int ey = calculate[1] + calculate[2] - 1; // 4
            while (ex - sx != 0 && ey - sy != 0) {
                int nx = sx;
                int ny = sy;
                dq.add(copy[sx][sy]);
                for (int j = 0; j < 4; j++) {
                    while (true) {
                        nx += arx[j];
                        ny += ary[j];
                        if (!validation(nx, ny) || nx > ex || nx < sx || ny > ey || ny < sy) {
                            nx -= arx[j];
                            ny -= ary[j];
                            break;
                        }
                        dq.add(copy[nx][ny]);
                    }
                }
                dq.pollLast();
                nx = sx;
                ny = sy + 1;
                copy[nx][ny] = dq.pollFirst();
                for (int j = 0; j < 4; j++) {
                    while (true) {
                        nx += arx[j];
                        ny += ary[j];
                        if (!validation(nx, ny) || nx > ex || nx < sx || ny > ey || ny < sy) {
                            nx -= arx[j];
                            ny -= ary[j];
                            break;
                        }
                        copy[nx][ny] = dq.pollFirst();
                    }
                }
                sx++;
                sy++;
                ex--;
                ey--;
            }
        }
        findMin(copy);
    }
    public static void findMin(int [][] output){
        int cur = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int temp = 0;
            for (int j = 0; j < m; j++) {
                temp += output[i][j];
            }
            cur = Math.min(cur, temp);
        }
        min = Math.min(min, cur);
    }
    public static boolean validation(int nx, int ny){
        if(0 <= nx && 0 <= ny && nx < n && ny < m) return true;
        return false;
    }
}
/* 문제 설명

크기가 N×M 크기인 배열 A가 있을때, 배열 A의 값은 각 행에 있는 모든 수의 합 중 최솟값을 의미한다.
배열 A가 아래와 같은 경우 1행의 합은 6, 2행의 합은 4, 3행의 합은 15이다. 따라서, 배열 A의 값은 4이다.
1 2 3
2 1 1
4 5 6

배열은 회전 연산을 수행할 수 있다.
회전 연산은 세 정수 (r, c, s)로 이루어져 있고, 가장 왼쪽 윗 칸이 (r-s, c-s), 가장 오른쪽 아랫 칸이 (r+s, c+s)인 정사각형을 시계 방향으로
한 칸씩 돌린다는 의미이다. 배열의 칸 (r, c)는 r행 c열을 의미한다.

회전 연산이 (3, 4, 2)인 경우
가장 위쪽 왼쪽(3-1, 4-2) 가장 아래쪽 오른쪽 (3 + 2, 4 + 2)

-? (2,2) , (5,6)


 */