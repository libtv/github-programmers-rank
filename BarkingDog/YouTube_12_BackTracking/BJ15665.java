package BarkingDog.YouTube_12_BackTracking;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

// https://www.acmicpc.net/problem/15665
// N과 M (11) 실버2
public class BJ15665 {
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
            int temp = Integer.parseInt(split2[i]);
            if (!list.contains(temp)) {
                list.add(temp);
            }
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
        for (int i = 0; i < list.size(); i++) {
            arr[depth] = list.get(i);
            func(depth + 1);
        }
    }
}
/*
N개의 자연수 중에서 M개를 고른 수열
같은 수를 여러 번 골라도 된다.
 */