package org.example.BarkingDog.YouTube_16_DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://www.acmicpc.net/problem/14002
// 가장 긴 증가하는 부분 수열 4 골드4
public class BJ14002 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int [] arr = new int[n+1];
        String[] split = br.readLine().split(" ");

        for (int i = 1; i <= n ; i++) {
            arr[i] = Integer.parseInt(split[i-1]);
        }
        if(n==1){
            System.out.println(1);
            System.out.println(arr[1]);
        }
        else{
            int [] DP = new int[1001];
            int [] memo = new int[1001];
            DP[1] = 1;
            for (int i = 2; i <= n ; i++) {
                int max = 0;
                int x = 1;
                for (int j = i-1; j >= 1; j--) {
                    if(arr[i] > arr[j]){
                        max = Math.max(max, DP[j]);
                        if(max == DP[j]){
                            x = j;
                        }
                    }
                }
                DP[i] = max + 1;
                memo[i] = x;
            }
            int max = Integer.MIN_VALUE;
            int x = 1;
            for (int i = 1; i <= n; i++) {
                max = Math.max(max , DP[i]);
                if(max == DP[i]){
                    x = i;
                }
            }
            System.out.println(max);
            if(max == 1){
                System.out.println(arr[x]);
            }
            else{
                StringBuilder sb = new StringBuilder();
                sb.append(" " + arr[x]);
                int nx = x;
                int end = max - 1;
                int cnt = 0;
                while (true){
                    cnt++;
                    int temp = memo[nx];
                    if(cnt == end){
                        sb.insert(0, arr[temp]);
                        break;
                    }else{
                        sb.insert(0, " " + arr[temp]);
                    }
                    nx = temp;
                }
                System.out.println(sb);
            }
        }
    }
}
/*
수열 A가 주어졌을 때, 가장 긴 증가하는 부분 수열을 구하는 프로그램을 작성하시오.
예를 들어, 수열 A = {10, 20, 10, 30, 20, 50} 인 경우에 가장 긴 증가하는 부분 수열은 A = {10, 20, 10, 30, 20, 50} 이고, 길이는 4이다.

첫째 줄에 수열 A의 가장 긴 증가하는 부분 수열의 길이를 출력한다.
둘째 줄에는 가장 긴 증가하는 부분 수열을 출력한다. 그러한 수열이 여러가지인 경우 아무거나 출력한다.
 */

/*
DP[K] 는 현재 시점에서 최대길이


 */