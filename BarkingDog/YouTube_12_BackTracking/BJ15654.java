package org.example.BarkingDog.YouTube_12_BackTracking;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

// https://www.acmicpc.net/problem/15654
// N과 M (5) 실버3
public class BJ15654 {
    static int N;
    static int M;
    static ArrayList<Integer> list;
    static int [] arr;
    static boolean [] visited;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        N = Integer.parseInt(split[0]);
        M = Integer.parseInt(split[1]);
        list = new ArrayList<>();
        arr = new int[M];
        visited = new boolean[N];
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
            if(!visited[i]){
                arr[depth] = list.get(i);
                visited[i] = true;
                func(depth +1);
                visited[i] = false;
            }
        }
    }
}
