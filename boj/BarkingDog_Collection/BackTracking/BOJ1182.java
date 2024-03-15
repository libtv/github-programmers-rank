package boj.BarkingDog_Collection.BackTracking;

// 부분수열의 합 실버2
import java.io.*;
import java.util.*;
public class BOJ1182 {
    static int answer; static int s; static int n;
    static int [] arr;
    static boolean [] visited;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        answer = 0;
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); s = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        arr = new int[n]; visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
       for (int i = 1; i <= n; i++) {
            BackTracking(i , 0, 0);
       }
       System.out.println(answer);
    }
    public static void BackTracking(int depth, int sum, int start){
        if(depth == 0 || start == n){
            if(depth == 0){
                if(sum == s) answer++;
            }
            return;
        }
        for (int i = start; i < n; i++) {
            visited[i] = true;
            BackTracking(depth - 1, sum + arr[i], i + 1);
            visited[i] = false;
        }
    }
}
