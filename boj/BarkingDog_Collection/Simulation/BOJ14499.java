package boj.BarkingDog_Collection.Simulation;

// 주사위 굴리기 골드4
import java.io.*;
import java.util.*;
public class BOJ14499 {
    static int [] arx = {0,0,0,-1,1}; // 동쪽은 1, 서쪽은 2, 북쪽은 3, 남쪽은 4
    static int [] ary = {0,1,-1,0,0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); int m = Integer.parseInt(st.nextToken());
        int start_x = Integer.parseInt(st.nextToken()); int start_y = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int [][] map = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int [] dice = new int[7];
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{start_x, start_y});
        StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < k; i++) {
            int cmd = Integer.parseInt(st.nextToken());
            int [] temp = q.poll();
            int nx = temp[0] + arx[cmd];
            int ny = temp[1] + ary[cmd];
            if(0 > nx || 0 > ny || n <= nx || m <= ny ){
                q.add(temp);
                continue;
            }
            int tmp = 0;
            int tmp2 = 0;
            if(cmd == 1){ // 동쪽으로
                tmp = dice[6];
                dice[6] = dice[3];
                tmp2 = dice[4];
                dice[4] = tmp;
                tmp = dice[1];
                dice[1] = tmp2;
                dice[3] = tmp;
            }
            else if(cmd == 2){ // 서쪽으로
                tmp = dice[1];
                dice[1] = dice[3];
                tmp2 = dice[4];
                dice[4] = tmp;
                tmp = dice[6];
                dice[6] = tmp2;
                dice[3] = tmp;
            }
            else if(cmd == 3){ // 북쪽으로
                tmp = dice[2];
                dice[2] = dice[1];
                tmp2 = dice[6];
                dice[6] = tmp;
                tmp = dice[5];
                dice[5] = tmp2;
                dice[1] = tmp;
            }
            else if(cmd == 4){ // 남쪽으로
                tmp = dice[6];
                dice[6] = dice[5];
                tmp2 = dice[2];
                dice[2] = tmp;
                tmp = dice[1];
                dice[1] = tmp2;
                dice[5] = tmp;
            }
            if(map[nx][ny] == 0){
                map[nx][ny] = dice[6];
            }
            else{
                dice[6] = map[nx][ny];
                map[nx][ny] = 0;
            }
            sb.append(dice[1]).append("\n");
            q.add(new int[]{nx,ny});
        }
        System.out.println(sb);

    }
}
/*
윗면이 1
아랫면이 6

  2
4 1 3
  5
  6

동쪽으로 이동
3 -> 6 6 -> 4 4 -> 1 1 -> 3
서쪽으로 이동
3 -> 1 1 -> 4 4 -> 6 6 -> 3
북쪽으로 이동
1 -> 2 2 -> 6 6 -> 5 5 -> 1
남쪽으로 이동
5 -> 6 6 -> 2 2 -> 1 1 -> 5



이동한 칸에 쓰여 있는 숫자가 0이면 주사위의 바닥면에 쓰여있는 숫자가 칸에 복사
0이 아닌 경우에는 칸에 쓰여 있는 수가 주사위의 바닥면으로 복사되며, 칸에 쓰여 있는 숫자가 0이된다.


 */