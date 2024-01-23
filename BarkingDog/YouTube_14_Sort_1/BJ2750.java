package org.example.BarkingDog.YouTube_14_Sort_1;

import java.io.*;

// https://www.acmicpc.net/problem/2750
// 수 정렬하기 브론즈2
// N개의 수가 주어졌을 때, 이를 오름차순으로 정렬하는 프로그램을 작성하시오.
public class BJ2750 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N;
    static int [] arr;
    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        for (int i = 0; i < N ; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        // 버블 정렬 연습하기
        for (int i = 0; i < N ; i++) {
            for (int j = 0; j < N-1; j++) {
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
        for (int i = 0; i < N ; i++) {
            bw.write(arr[i]  + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
