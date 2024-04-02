package boj.BarkingDog_Collection.DP;

// 가장 큰 정사각형 골드4
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ1915 {
    static int [][] map; static int n,m; static int max = 0;
    static int [] arx = {-1,-1,0}; // 왼쪽 상단 , 상단 , 왼쪽
    static int [] ary = {-1,0,-1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = input.charAt(j) - '0';
                if (map[i][j] == 1 && max == 0) max = 1;
            }
        }
        if (max == 0) {
            System.out.println(0);
            return;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(map[i][j] == 0) continue;
                ArrayList<Integer> list = new ArrayList<>();
                for (int k = 0; k < 3 ; k++) {
                    int nx = i + arx[k];
                    int ny = j + ary[k];
                    if(!validation(nx,ny)){
                        break;
                    }
                    list.add(map[nx][ny]);
                }
                if(list.size() != 3) continue;
                int min = Collections.min(list);
                if(min == 0) continue;
                map[i][j] = (int)Math.pow((int)Math.sqrt(min) + 1, 2);
                System.out.println(Arrays.deepToString(map));
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(max < map[i][j]) max = map[i][j];
            }
        }
        System.out.println(max);
    }
    public static boolean validation(int nx , int ny){
        if(0 <= nx && 0 <= ny && nx < n && ny < m) return true;
        else return false;
    }
}
