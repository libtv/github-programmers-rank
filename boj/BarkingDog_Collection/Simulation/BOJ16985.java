package boj.BarkingDog_Collection.Simulation;

// Mazzzzzzzze 골드2
import java.io.*;
import java.util.*;
public class BOJ16985 {
    static StringTokenizer st; static int answer = Integer.MAX_VALUE;
    static int [][][] map = new int[5][5][5];
    static boolean [] visited = new boolean[5];
    static int [] arr = new int[5];
    static int [][][] copy;
    static int [] arx = {-1,1,0,0,0,0};
    static int [] ary = {0,0,-1,1,0,0};
    static int [] arz = {0,0,0,0,-1,1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5 ; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < 5 ; k++) {
                    map[j][k][i] = Integer.parseInt(st.nextToken());
                }
            }
        }
        BackTracking(0);
        if(answer == Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(answer);
    }
    public static void BackTracking(int depth){
        if(depth == 5){
            BFS();
            return;
        }
        for (int i = 0; i < 5 ; i++) {
            if(!visited[i]){
                visited[i] = true;
                arr[depth] = i;
                BackTracking(depth + 1);
                visited[i] = false;
            }
        }
    }
    public static void BFS(){
        copy = new int[5][5][5];
        for (int i = 0; i < 5 ; i++) {
            for (int j = 0; j < 5 ; j++) {
                for (int k = 0; k < 5; k++) {
                    copy[j][k][i] = map[j][k][arr[i]];
                }
            }
        }
        for (int i = 0; i < 4 ; i++) {
            if(i != 0 ) rotate(0);
            for (int j = 0; j < 4 ; j++) {
                if(j != 0 ) rotate(1);
                for (int k = 0; k < 4 ; k++) {
                    if(k != 0 ) rotate(2);
                    for (int l = 0; l < 4 ; l++) {
                        if(l != 0 ) rotate(3);
                        for (int m = 0; m < 4 ; m++) {
                            if(m != 0) rotate(4);
                            check(copy);
                        }
                    }
                }
            }
        }
    }
    public static void rotate(int i){
        int [][] temp = new int[5][5];
        for (int j = 0; j < 5 ; j++) {
            for (int k = 0; k < 5; k++) {
                temp[k][4-j] = copy[j][k][i];
            }
        }
        for (int j = 0; j < 5 ; j++) {
            for (int k = 0; k < 5; k++) {
                copy[j][k][i] = temp[j][k];
            }
        }
    }
    public static void check(int [][][] update){
        if(update[0][0][0] == 0 || update[4][4][4] == 0) return;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0,0,0,0});
        boolean [][][] visited = new boolean[5][5][5];
        visited[0][0][0] = true;
        while (!q.isEmpty()){
            int [] temp = q.poll();
            for (int i = 0; i < 6 ; i++) {
                int nx = temp[0] + arx[i];
                int ny = temp[1] + ary[i];
                int nz = temp[2] + arz[i];
                if(0 <= nx && 0 <= ny && 0 <= nz && nx < 5 && ny < 5 && nz < 5){
                    if(!visited[nx][ny][nz] && copy[nx][ny][nz] == 1){
                        visited[nx][ny][nz] = true;
                        if(nx == 4 && ny == 4 && nz == 4){
                            answer = Math.min(answer, temp[3] + 1);
                            return;
                        }
                        else{
                            q.add(new int[]{nx,ny,nz,temp[3] + 1});
                        }
                    }
                }
            }
        }
    }
}
