package boj.BarkingDog_Collection.DP;

// 가장 큰 증가하는 부분 수열 실버2
import java.io.*;
import java.util.*;
public class BOJ11055 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int max = Integer.MIN_VALUE;
        StringTokenizer st = new StringTokenizer(br.readLine());
        int [] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int [][] DP = new int[n+1][2];
        for (int i = 1; i <= n; i++) {
            int input = arr[i-1];
            int check = Integer.MIN_VALUE;
            for (int j = i-1; j >=0 ; j--) {
                if(DP[j][0] < input){
                    if(check < DP[j][1]) check = DP[j][1];
                }
            }
            DP[i][0] = input;
            if(check == Integer.MIN_VALUE){
                DP[i][1] = input;
            }
            else{
                DP[i][1] = input + check;
            }
        }
        int temp = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            temp = Math.max(temp, DP[i][1]);
        }
        System.out.println(temp);
    }
}
