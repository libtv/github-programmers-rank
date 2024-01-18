package org.example.BarkingDog.YouTube_12_BackTracking;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

//https://www.acmicpc.net/problem/15663
// N과 M (9) 실버2
public class BJ15663 {
    static int N;
    static int M;
    static ArrayList<Integer> list;
    static int [] arr;
    static int [] visited2;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args)  throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        N = Integer.parseInt(split[0]);
        M = Integer.parseInt(split[1]);
        list = new ArrayList<>();
        arr = new int[M];
        visited2 = new int[100];
        String[] split2 = br.readLine().split(" ");

        for (int i = 0; i < N ; i++) {
            int temp = Integer.parseInt(split2[i]);
            if (!list.contains(temp)) {
                list.add(temp);
                visited2[temp] += 1;
            } else {
                visited2[temp] += 1;
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
        for (int i = 0; i < list.size(); i++) { // 1 7 9
            int temp = list.get(i);
            if(visited2[temp] > 0){
                arr[depth] = temp;
                visited2[temp]-= 1;
                func(depth + 1);
                visited2[temp]+= 1;
            }
        }

    }
}
/*
중복된 숫자가 있는 경우는
M의 크기에 따라 제한 한다.
EX) M = 1 이면 1번까지 M = 2이면 4번까지
 */