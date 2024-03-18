package boj.BarkingDog_Collection.Simulation;

// 경사로 골드3
import java.io.*;
import java.util.*;
public class BOJ14890 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); int l = Integer.parseInt(st.nextToken());
        int [][] map = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int count = 0;
        // 행부터 검사
        for (int i = 0; i < n; i++) {
            int [] temp = new int[n+1];
            for (int j = 0; j < n ; j++) {
                temp[j + 1] = map[i][j] + temp[j];
            }
            boolean [] visited = new boolean[n];
            for (int j = 1; j < n; j++) {
                if(map[i][j-1] == map[i][j]){
                    if(j == n - 1){
                        count++;
                    }
                    continue;
                }
                if(Math.abs(map[i][j-1] - map[i][j]) >= 2) break;
                if(map[i][j-1] < map[i][j]){
                    if(j - l < 0) break;
                    int check = temp[j]-temp[j-l];
                    if(check != map[i][j-1] * l) break;
                    boolean flag = false;
                    for (int k = j-l; k < j; k++) {
                        if(visited[k]){
                            flag = true;
                            break;
                        }
                        else visited[k] = true;
                    }
                    if(flag) break;
                }
                if(map[i][j-1] > map[i][j]){
                    if(j - 1 + l > n - 1) break;
                    int check = temp[j + l] - temp[j];
                    if(check != map[i][j] * l) break;
                    boolean flag = false;
                    for (int k = j; k < j + l; k++) {
                        if(visited[k]){
                            flag = true;
                            break;
                        }
                        else visited[k] = true;
                    }
                    if(flag) break;
                }
                if(j == n - 1){
                    count++;
                }
            }
        }
        for (int i = 0; i < n ; i++) {
            int [] temp = new int[n+1];
            for (int j = 0; j < n; j++) {
                temp[j + 1] = temp[j] + map[j][i];
            }
            boolean [] visited = new boolean[n];
            for (int j = 1; j < n; j++) {
                if(map[j-1][i] == map[j][i]){
                    if(j == n - 1){
                        count++;
                    }
                    continue;
                }
                if(Math.abs(map[j-1][i] - map[j][i]) >= 2) break;
                if(map[j-1][i] < map[j][i]){
                    if(j - l < 0) break;
                    int check = temp[j]-temp[j-l];
                    if(check != map[j-1][i] * l) break;
                    boolean flag = false;
                    for (int k = j-l; k < j; k++) {
                        if(visited[k]){
                            flag = true;
                            break;
                        }
                        else visited[k] = true;
                    }
                    if(flag) break;
                }
                else if(map[j-1][i] > map[j][i]){
                    if(j - 1 + l > n - 1) break;
                    int check = temp[j + l] - temp[j];
                    if(check != map[j][i] * l) break;
                    boolean flag = false;
                    for (int k = j; k < j + l; k++) {
                        if(visited[k]){
                            flag = true;
                            break;
                        }
                        else visited[k] = true;
                    }
                    if(flag) break;
                }
                if(j == n - 1){
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}
