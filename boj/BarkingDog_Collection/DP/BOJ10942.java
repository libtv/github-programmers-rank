package boj.BarkingDog_Collection.DP;

// 팰린드롬? 골드4
import java.util.*;
import java.io.*;
public class BOJ10942 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int [] arr = new int[n+1];
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int t = Integer.parseInt(br.readLine());

        int [][] DP = new int[n+1][n+1];
        for (int i = 1; i <= n; i++) {
            for (int j = i; j >= 1; j--) {
                if(i - j == 0) DP[j][i] = 1;
                else if(i - j <= 2){
                    if(arr[i] == arr[j]){
                        DP[j][i] = 1;
                    }
                }
                else{
                    if(arr[i] == arr[j] && DP[j+1][i-1] == 1){
                        DP[j][i] = 1;
                    }
                }
            }
        }
        // 1 2 1 3 1 2 1
        /*
        1 1
        2 2 -> 1 2
        3 3 -> 2 3 -> 1 3
        4 4 -> 3 4 -> 2 4 -> 1 4
        5 5 -> 4 5 -> 3 5 -> 2 5 -> 1 5
         */

        StringBuilder sb = new StringBuilder();
        while (t-->0){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            sb.append(DP[s][e]).append("\n");
        }
        System.out.println(sb);
    }
}
/*

123 321 -> 팰린드롬이 아닌다?

12 12   -> 팰린드롬

12 12

12 1 12
12 1 12  -> 순서만 뒤집는 행위

1 2 1 3 1 2 1

[0, 0, 0, 0, 0, 0, 0, 0]
[0, 1, 0, 1, 0, 0, 0, 1]
[0, 0, 1, 0, 0, 0, 0, 0]
[0, 0, 0, 1, 0, 1, 0, 0]
[0, 0, 0, 0, 1, 0, 0, 0]
[0, 0, 0, 0, 0, 1, 0, 1]
[0, 0, 0, 0, 0, 0, 1, 0]
[0, 0, 0, 0, 0, 0, 0, 1]



 */