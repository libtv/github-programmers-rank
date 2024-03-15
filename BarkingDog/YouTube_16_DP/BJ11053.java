package BarkingDog.YouTube_16_DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://www.acmicpc.net/problem/11053
// 가장 긴 증가하는 부분 수열 실버2
public class BJ11053 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int [] arr = new int[n+1];
        String[]split = br.readLine().split(" ");
        for (int i = 1; i <= n ; i++) {
            arr[i] = Integer.parseInt(split[i-1]);
        }
        int [] DP = new int[n+1];
        if(n==1){
            System.out.println(1);
        }
        else{
            Arrays.fill(DP, 1);
            for (int i = 2; i <= n ; i++) {
                for (int j = 1; j < i; j++) {
                    if(arr[i] > arr[j]){
                        DP[i] = Math.max(DP[i], DP[j] + 1);
                    }
                }
            }
            System.out.println(Arrays.toString(DP));
            int max = Integer.MIN_VALUE;
            for (int i = 1; i <= n; i++) {
                max = Math.max(max, DP[i]);
            }
            System.out.println(max);
        }

    }
}
/*
수열 A가 주어졌을 때, 가장 긴 증가하는 부분 수열을 구하는 프로그램을 작성하시오.
예를 들어, 수열 A = {10, 20, 10, 30, 20, 50} 인 경우에 가장 긴 증가하는 부분 수열은 A = {10, 20, 10, 30, 20, 50} 이고, 길이는 4이다.
 */