package org.example.boj.BarkingDog_Collection.BFS;

// 확장 게임 골드2
import java.io.*;
import java.util.*;
public class BOJ16920 {
    static int [] arx = {-1,1,0,0};
    static int [] ary = {0,0,-1,1};
    static int n; static int m; static int p;
    static int [][] map; static long [] distance;
    static Queue<int[]>[] q; static int [] answer;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        p = Integer.parseInt(st.nextToken());
        map = new int[n][m]; distance = new long[p+1]; answer = new int[p+1];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < p ; i++) {
            distance[i+1] = Long.parseLong(st.nextToken());
        }

        q = new Queue[p+1];
        for (int i = 0; i <= p ; i++) {
            q[i] = new LinkedList<>();
        }

        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            for (int j = 0; j < m ; j++) {
                char target = input.charAt(j);
                if(target == '.') continue;
                if(target == '#'){
                    map[i][j] = -1;
                    continue;
                }
                int temp = target - '0';
                q[temp].add(new int[]{i,j});
                map[i][j] = temp;
                answer[temp]++;
            }
        }
        bfs();
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= p; i++) {
            sb.append(answer[i]).append(" ");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
    public static void bfs(){
        while (true){
            for (int i = 1; i <= p; i++) {
                long dis = distance[i];
                if(q[i].isEmpty()) continue;
                for (int j = 0; j < dis; j++) {
                    int size = q[i].size();
                    for (int k = 0; k < size; k++) {
                        int [] temp = q[i].poll();
                        for (int l = 0; l < 4 ; l++) {
                            int nx = temp[0] + arx[l];
                            int ny = temp[1] + ary[l];
                            if(!validation(nx, ny)) continue;
                            if(map[nx][ny] == 0){
                                map[nx][ny] = i;
                                q[i].add(new int[]{nx,ny});
                                answer[i]++;
                            }
                        }
                    }
                    if(q[i].isEmpty()) break;
                }
            }
            if(check()) break;
        }
    }
    public static boolean validation(int nx, int ny){
        if(0 <= nx && 0 <= ny && nx < n && ny < m) return true;
        else return false;
    }
    public static boolean check(){
        boolean flag = true;
        for (int i = 0; i <= p ; i++) {
            if(q[i].size() > 0){
                flag = false;
                break;
            }
        }
        return flag;
    }
}
