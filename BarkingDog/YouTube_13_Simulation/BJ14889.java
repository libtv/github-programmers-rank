package org.example.BarkingDog.YouTube_13_Simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://www.acmicpc.net/problem/14889
// 스타트와 링크 실버1
public class BJ14889 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static int[][]score;
    static int[] arr;
    static int min;
    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        score = new int[N][N];
        arr = new int[N/2];
        min = 9999999;
        for (int i = 0; i < N ; i++) {
            String[] split = br.readLine().split(" ");
            for (int j = 0; j < N ; j++) {
                score[i][j] = Integer.parseInt(split[j]);
            }
        }
        func(0, 0);
        System.out.println(min);
    }
    public static void func(int depth, int idx){
        if(depth == N/2){
            int temp = find(arr);
            if(min > temp){
                min = temp;
            }
            return;
        }
        if(idx == N){
            return;
        }
        arr[depth] = idx;
        func(depth + 1 , idx + 1);
        func(depth, idx + 1);
    }
    public static int find(int[] arr){
        int [] link = new int[N/2];
        int cnt = 0;
        for (int i = 0; i < N ; i++) {
            boolean flag = false;
            for (int j = 0; j < arr.length; j++) {
                if(arr[j] == i){
                    flag = true;
                }
            }
            if(!flag){
                link[cnt] = i;
                cnt++;
            }
        }
        int sum1 = 0;
        int sum2 = 0;
        for (int i = 0; i < N/2 ; i++) {
            for (int j = 0; j < N/2; j++) {
                if( i == j ){
                    continue;
                }
                else{
                    sum1 += score[arr[i]][arr[j]];
                }
            }
        }
        for (int i = 0; i < N/2 ; i++) {
            for (int j = 0; j < N/2; j++) {
                if( i == j ){
                    continue;
                }
                else{
                    sum2 += score[link[i]][link[j]];
                }
            }
        }
        return Math.abs(sum1 - sum2);
    }
}
