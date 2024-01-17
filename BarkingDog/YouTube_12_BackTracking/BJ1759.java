package org.example.BarkingDog.YouTube_12_BackTracking;

import java.io.*;
import java.util.Arrays;

// https://www.acmicpc.net/problem/1759
// 암호 만들기 골드5
public class BJ1759 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int L;
    static int C;
    static String[] visited;
    static String[] arr;
    public static void main(String[] args) throws IOException {
        String[]split = br.readLine().split(" ");
        L = Integer.parseInt(split[0]);
        C = Integer.parseInt(split[1]);
        arr = new String[C];
        visited = new String[L];
        String[]split2 = br.readLine().split(" ");
        for (int i = 0; i < C ; i++) {
            arr[i] = split2[i];
        }
        Arrays.sort(arr); // 사전 순서대로
        func(0,0,0,0);
        bw.flush();
        bw.close();
    }
    // cnt는 배열에 넣은 개수 n은 받아온 문자열들 위치 check는 모음의 개수 check2는 자음의 개수
    public static void func(int cnt, int n, int check , int check2) throws IOException{
        // 자음이 2개 이상인가? 최소 모음이 1개인가
        if( cnt == L ){
            if(check >=1 && check2 >=2){
                for(String target : visited){
                    bw.write(target);
                }
                bw.write("\n");
            }
            return;
        }
        if(n == C){
            return;
        }
        visited[cnt] = arr[n];
        // 이번 글자 넣기
        // 이번 글자가 모음인가 자음인가?
        if(arr[n].equals("a") || arr[n].equals("e") || arr[n].equals("i") || arr[n].equals("o") || arr[n].equals("u")){
            check  = check + 1;
            func(cnt+1, n+1, check, check2);
            check = check - 1;
        }
        else{
            check2 = check2 + 1;
            func(cnt+1, n+1, check, check2);
            check2 = check2 - 1;
        }
        // 이번 글자 pass
        func(cnt,n+1, check, check2);
    }
}
/*
암호는 서로 다른 L개의 알파벳 소문자들로 구성되며
최소 한 개의 모음(a, e, i, o, u)
최소 두 개의 자음으로 구성되어 있다고 알려져 있다.
abc는 가능성이 있는 암호이지만 bac는 그렇지 않다.
C개의 문자들이 모두 주어졌을 때, 가능성 있는 암호들을 모두 구하는 프로그램을 작성하시오.

 */