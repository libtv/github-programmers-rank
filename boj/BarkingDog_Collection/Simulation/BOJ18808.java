package boj.BarkingDog_Collection.Simulation;

// 스티커 붙이기 골드3
import java.io.*;
import java.util.*;
public class BOJ18808 {
    static int n, m; static int [][] map; static int x; static int y;
    static int [][] input; static int [][] tmp;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); m = Integer.parseInt(st.nextToken());
        int num = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        while (num-->0){
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken()); y = Integer.parseInt(st.nextToken());
            input = new int[x][y];
            for (int i = 0; i < x; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < y ; j++) {
                    input[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            check();
        }
        int sum = 0;
        for (int i = 0; i < n ; i++) {
            for (int j = 0; j < m ; j++) {
                if(map[i][j] == 1) sum++;
            }
        }
        System.out.println(sum);
    }
    public static void check(){
        if(validation(input)) return;
        for (int i = 0; i < 3 ; i++) { // 90 180 270
           if(i == 0){
               tmp = rotate(input);
           }
           else{
               tmp = rotate(tmp);
           }
           if(validation(tmp)) return;
        }
    }
    public static int [][] rotate(int [][] in){
        int n = in.length;
        int m = in[0].length;
        int [][] temp = new int[m][n];
        for (int i = 0; i < m ; i++) {
            for (int j = 0; j < n; j++) {
                temp[i][j] = in[n-1-j][i];
            }
        }
        return temp;
    }
    public static boolean validation(int [][] arr){
        ArrayList<int[]> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if(arr[i][j] == 1) list.add(new int[]{i,j});
            }
        }
        for (int i = 0; i < n ; i++) {
            for (int j = 0; j < m ; j++) {
                boolean flag = true;
                for (int [] temp : list) {
                    int x = i + temp[0];
                    int y = j + temp[1];
                    if(0 <= x && 0 <= y && x < n && y < m && map[x][y] == 0) continue;
                    flag = false;
                    break;
                }
                if(flag){
                    for (int [] temp: list) {
                        map[i + temp[0]][j + temp[1]] = 1;
                    }
                    return true;
                }
            }
        }
        return false;
    }
}
