package boj.BarkingDog_Collection.Simulation;

/**
 * 배열 돌리기 골드4
 * Simulation
 * 기존 rotate 로직 개선
 */
import java.util.*;
import java.io.*;
public class BOJ17406_2 {
    static int n,m,k;
    static int [][] rotate; // 회전 연산 저장소
    static boolean [] visited; // 백트래킹을 위한 visited
    static int [] arr;
    static int [][] init;
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException{
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
    public static void check(){
        int [][] copy = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                copy[i][j] = init[i][j];
            }
        }
        System.out.println("start");
        System.out.println(Arrays.deepToString(copy));
        for (int i = 0; i < k; i++) {
            int [] calculate = rotate[arr[i]];
            int sx = calculate[0] - calculate[2] - 1;
            int ex = calculate[0] + calculate[2] - 1;
            int sy = calculate[1] - calculate[2] - 1;
            int ey = calculate[1] + calculate[2] - 1;
            int before = 0;
            while (ex - sx != 0 && ey - sy != 0){

                for (int j = sy; j <= ey; j++) { // -> 오른쪽
                    int temp = copy[sx][j];
                    copy[sx][j] = before;
                    before = temp;
                }

                for (int j = sx+1; j <= ex; j++) { // -> 아래쪽
                    int temp = copy[j][ey];
                    copy[j][ey] = before;
                    before = temp;
                }

                for (int j = ey - 1; j >= sy; j--) { // -> 왼쪽
                    int temp = copy[ex][j];
                    copy[ex][j] = before;
                    before = temp;
                }

                for (int j = ex - 1; j >= sx ; j--) {
                    int temp = copy[j][sy];
                    copy[j][sy] = before;
                    before = temp;
                }
                sx++;
                ex--;
                sy++;
                ey--;
            }
            System.out.println(Arrays.deepToString(copy));
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
}
