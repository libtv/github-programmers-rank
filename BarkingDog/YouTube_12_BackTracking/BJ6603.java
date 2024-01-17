package org.example.BarkingDog.YouTube_12_BackTracking;

import java.io.*;

// https://www.acmicpc.net/problem/6603
// 로또 실버2
public class BJ6603 {
    static int K;
    static int[] S; // 집합 S
    static int[] arr;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        while (true){
            String[]split = br.readLine().split(" ");
            if(split[0].equals("0")){
                break;
            }
            K = Integer.parseInt(split[0]);
            S = new int[K];
            arr = new int[6]; // 로또의 크기
            for (int i = 0; i < K ; i++) {
                S[i] = Integer.parseInt(split[i+1]);
            }
            func(0 , 0);
            bw.write("\n");
        }
        bw.flush();
        bw.close();
    }
    public static void func(int cnt , int n) throws IOException{
        if(cnt == 6){
            for(int target : arr ){
                bw.write(target + " ");
            }
            bw.write("\n");
            return;
        }
        if(n == K){
            return;
        }
        arr[cnt] = S[n];
        // 만약 S집합의 첫 번째 숫자를 선택 했다면?
        func(cnt + 1, n + 1);
        // else
        func( cnt , n + 1);
    }
}
/*
 로또 {1, 2, ..., 49}에서 수 6개를 고른다.
 로또 번호를 선택하는데 사용되는 가장 유명한 전략은 49가지 수 중 k(k>6)개의 수를 골라 집합 S를 만든 다음 그 수만 가지고 번호를 선택하는 것이다.

입력 : 입력은 여러 개의 테스트 케이스로 이루어져 있다.
각 테스트 케이스는 한 줄로 이루어져 있다.
첫 번째 수는 k (6 < k < 13)이고, 다음 k개 수는 집합 S에 포함되는 수이다. S의 원소는 오름차순으로 주어진다.
입력의 마지막 줄에는 0이 하나 주어진다.

 */