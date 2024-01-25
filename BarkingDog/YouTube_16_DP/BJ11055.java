package org.example.BarkingDog.YouTube_16_DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://www.acmicpc.net/problem/11055
// 가장 큰 증가하는 부분 수열 실버2
public class BJ11055 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        String[] split = br.readLine().split(" ");
        int [] arr = new int[n+1];
        for (int i = 1; i <= n ; i++) {
            arr[i] = Integer.parseInt(split[i-1]);
        }
        int []DP = new int[n+1];
        if(n==1){
            System.out.println(arr[1]);
        }
        else{
            for (int i = 1; i <= n; i++) {
                for (int j = 0; j < i; j++) {
                    if(arr[i] > arr[j]){
                        DP[i] = Math.max(DP[i], DP[j] + arr[i]);
                    }
                }
            }
            int max = Integer.MIN_VALUE;
            for (int i = 1; i <= n ; i++) {
                max = Math.max(max, DP[i]);
            }
            System.out.println(max);
        }
    }
}
/*
수열 A가 주어졌을 때, 그 수열의 증가하는 부분 수열 중에서 합이 가장 큰 것을 구하는 프로그램을 작성하시오.
D[K][0]는 k번째항까지 증가하면 더해진 가장 큰 누적합
D[K][1]는 K번째항까지 더해진 가장큰 누적합 하지만 다음항이 현재항 보다 커서 멈춤
-> 누적합
 */