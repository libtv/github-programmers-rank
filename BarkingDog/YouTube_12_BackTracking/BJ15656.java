package org.example.BarkingDog.YouTube_12_BackTracking;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

// https://www.acmicpc.net/problem/15656
// N과 M (7) 실버3
public class BJ15656 {

    static int N;
    static int M;
    static ArrayList<Integer> list;
    static int [] arr;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        N = Integer.parseInt(split[0]);
        M = Integer.parseInt(split[1]);
        list = new ArrayList<>();
        arr = new int[M];
        String[] split2 = br.readLine().split(" ");
        for (int i = 0; i < N ; i++) {
            list.add(Integer.parseInt(split2[i]));
        }
        Collections.sort(list);
        func(0);
        bw.flush();
        bw.close();
    }
    public static void func(int depth) throws IOException{
        if(depth == M){
            for(int target : arr){
                bw.write(target + " ");
            }
            bw.write("\n");
            return;
        }
        for (int i = 0; i < N ; i++) {
            arr[depth] = list.get(i);
            func(depth + 1);
        }
    }
}
/*
N개의 자연수 중에서 M개를 고른 수열
같은 수를 여러 번 골라도 된다.
수열은 사전 순으로 증가하는 순서로 출력해야 한다.
 */