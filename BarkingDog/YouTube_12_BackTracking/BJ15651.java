package org.example.BarkingDog.YouTube_12_BackTracking;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

// https://www.acmicpc.net/problem/15651
// N과 M (3) 실버3
public class BJ15651 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N;
    static int M;
    static int[] arr;
    public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        arr = new int[M];
        func(0 );
        bw.flush();
        bw.close();
    }
    public static void func(int cnt) throws IOException {
         if(cnt == M){
             for (int target : arr) {
                 bw.write(target + " ");
             }
             bw.write("\n");
             return;
         }
        for (int i = 1; i <= N; i++) {
            arr[cnt] = i;
            func(cnt + 1);
        }
    }
}

// 자연수 N과 M이 주어졌을 때, 아래 조건을 만족하는 길이가 M인 수열을 모두 구하는 프로그램을 작성하시오.
// 1부터 N까지 자연수 중에서 M개를 고른 수열
// 같은 수를 여러 번 골라도 된다.