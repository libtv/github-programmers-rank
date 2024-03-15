package boj.BarkingDog_Collection.BFS;

// 상범 빌딩 골드5
import java.io.*;
import java.util.*;
public class BOJ6593 {
    static int [] arx = {-1,1,0,0,0,0};
    static int [] ary = {0,0,-1,1,0,0};
    static int [] arz = {0,0,0,0,-1,1};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        while (true){
            st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken()); // z
            int n = Integer.parseInt(st.nextToken()); // x
            int m = Integer.parseInt(st.nextToken()); // y
            if(l == 0) break;
            int [][][] map = new int[n][m][l];
            Queue<int[]> q = new LinkedList<>();
            int end_x = 0;
            int end_y = 0;
            int end_z = 0;
            for (int i = 0; i < l ; i++) {
                for (int j = 0; j < n ; j++) {
                    String input = br.readLine();
                    for (int k = 0; k < m; k++) {
                        char target = input.charAt(k);
                        if(target == 'S'){
                            map[j][k][i] = 0;
                            q.add(new int[]{j,k,i});
                        }
                        else if(target == '#'){
                            map[j][k][i] = Integer.MAX_VALUE;
                        }
                        else if(target == 'E'){
                            map[j][k][i] = -2;
                            end_x = j;
                            end_y = k;
                            end_z = i;
                        }
                        else{
                            map[j][k][i] = -1;
                        }
                    }
                }
                br.readLine();
            }
            boolean flag = false;
            int answer = 0;
            while (!q.isEmpty()){
                int [] temp = q.poll();
                if(temp[0] == end_x && temp[1] == end_y && temp[2] == end_z){
                    flag = true;
                    break;
                }
                for (int i = 0; i < 6 ; i++) {
                    int nx = temp[0] + arx[i];
                    int ny = temp[1] + ary[i];
                    int nz = temp[2] + arz[i];
                    if(0 <= nx && 0 <= ny && 0 <= nz && nx < n && ny < m && nz < l){
                        if(map[nx][ny][nz] == -2){
                            map[nx][ny][nz] = map[temp[0]][temp[1]][temp[2]] + 1;
                            flag = true;
                            q.clear();
                            break;
                        }
                        else if(map[nx][ny][nz] == -1){
                            map[nx][ny][nz] = map[temp[0]][temp[1]][temp[2]] + 1;
                            q.add(new int[]{nx,ny,nz});
                        }
                    }
                }
            }
            if(flag) sb.append("Escaped in ").append(map[end_x][end_y][end_z]).append(" minute(s).").append("\n");
            else sb.append("Trapped!").append("\n");
        }
        System.out.println(sb);
    }
}
