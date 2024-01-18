package org.example.BarkingDog.YouTube_12_BackTracking;

import java.io.*;

// https://www.acmicpc.net/problem/15652
// N과 M (4) 실버3
public class BJ15652 {
    static int N;
    static int M;
    static int[] arr;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        N = Integer.parseInt(split[0]);
        M = Integer.parseInt(split[1]);
        arr = new int[M];
        func(0, 1);
        bw.flush();
        bw.close();
    }
    public static void func(int depth, int n) throws IOException{
        if(depth == M){
            for(int target : arr){
                bw.write(target + " ");
            }
            bw.write("\n");
            return;
        }
        if(n > N){
            return;
        }
        arr[depth] = n;
        func(depth + 1, n); // 이번 숫자를 넣는다. 다음 숫자도 그대로
        func(depth, n+1); // 이번 숫자를 그냥 pass 한다.

    }
}
/* 문제
1부터 N까지 자연수 중에서 M개를 고른 수열
같은 수를 여러 번 골라도 된다
고른 수열은 비내림차순이어야 한다

 */

/* 문제 접근


 */