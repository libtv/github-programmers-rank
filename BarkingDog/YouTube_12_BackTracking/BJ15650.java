package org.example.BarkingDog.YouTube_12_BackTracking;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

// https://www.acmicpc.net/problem/15650
// N과 M (2) 실버3
public class BJ15650 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N;
    static int M;
    static boolean[] visited;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        visited = new boolean[N+1];
        arr = new int[M];
        func(0, 1);
        bw.flush();
        bw.close();
    }
    public static void func(int cnt , int n) throws IOException {
        if(cnt == M){
            for (int target : arr) {
                bw.write(target + " ");
            }
            bw.write("\n");
            return;
        }
        if( n > N){
            return;
        }
        arr[cnt] = n;
        func(cnt + 1, n + 1);
        func(cnt , n + 1);
    }
}
/*
자연수 N과 M이 주어졌을 때, 아래 조건을 만족하는 길이가 M인 수열을 모두 구하는 프로그램을 작성하시오.
1부터 N까지 자연수 중에서 중복 없이 M개를 고른 수열
1부터 N까지 자연수 중에서 중복 없이 M개를 고른 수열


 */