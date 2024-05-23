package boj.BarkingDog_Review;

// 확장 게임
import java.io.*;
import java.util.*;
public class BOJ_9_16920 {
    static int n,m,p; static int [][] init; static long [] player;
    static int [] arx = {-1,1,0,0};
    static int [] ary = {0,0,-1,1};
    static Queue<int[]>[] game;
    static int [] answer;
    public static void main(String[] args) throws IOException{
        // long start_time = System.currentTimeMillis();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        p = Integer.parseInt(st.nextToken());  // 플레이어의 수 p
        init = new int[n][m];
        player = new long[p+1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= p; i++) {
            player[i] = Long.parseLong(st.nextToken());
        }
        game = new Queue[p+1];
        answer = new int[p+1];
        for (int i = 0; i <= p; i++) {
            game[i] = new LinkedList<>();
        }
        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            for (int j = 0; j < m; j++) {
                char temp = input.charAt(j);
                if(temp == '.') continue;
                else if(temp == '#'){
                    init[i][j] = -1;
                    continue;
                }

                int castle = temp - '0';
                game[castle].add(new int[]{i,j});
                init[i][j] = castle;
                answer[castle]++;
            }
        }
        game_start();
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= p; i++) {
            sb.append(answer[i]).append(" ");
        }
        System.out.println(sb);
    }
    public static void game_start(){
        while (true){
            int count = 0;
            for (int i = 1; i <= p; i++) {
                if(game[i].isEmpty()){
                    count++;
                    continue;
                }
                long distance = player[i];
                for (int j = 0; j < distance; j++) {
                    int size = game[i].size();
                    for (int k = 0; k < size; k++) {
                        int [] temp = game[i].poll();
                        for (int l = 0; l < 4; l++) {
                            int nx = temp[0] + arx[l];
                            int ny = temp[1] + ary[l];
                            if(validation(nx,ny) && init[nx][ny] == 0){
                                init[nx][ny] = i;
                                answer[i]++;
                                game[i].add(new int[]{nx,ny});
                            }
                        }
                    }
                    if(game[i].isEmpty()) break;
                }
            }
            if(count == p) return;
        }
    }
    public static boolean validation(int nx, int ny){
        if(0 <= nx && 0 <= ny && nx < n && ny < m) return true;
        else return false;
    }
}
/*
1000 * 1000 = 1000/000

어떻게 시간초과를 해결할까?

내가 원하는건 새로 생긴 길은 방문 가능 방문 했던 곳은 방문 x




 */