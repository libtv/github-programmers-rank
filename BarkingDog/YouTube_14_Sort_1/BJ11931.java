package org.example.BarkingDog.YouTube_14_Sort_1;

import java.io.*;
public class BJ11931 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N;
    static int [] arr;
    static int [] temp;
    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        temp = new int[N];
        for (int i = 0; i < N ; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        // 머지 정렬 (병합 정렬) 연습하기
        func(0, N);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N ; i++) {
            sb.append(arr[i]);
            sb.append("\n");
        }
        System.out.println(sb);
        br.close();
    }
    public static void func(int start, int end){
        if(end - start == 1){
            return;
        }
        int mid = (start + end) / 2;
        func(start, mid);
        func(mid ,end);
        func2(start ,end);
    }
    public static void func2(int start, int end){
        int mid = (start + end) / 2;
        int cnt1 = start;
        int cnt2 = mid;
        for (int i = start; i < end ; i++) {
            if(cnt1 == mid){
                temp[i] = arr[cnt2];
                cnt2++;
            }
            else if(cnt2 == end){
                temp[i] = arr[cnt1];
                cnt1++;
            }
            else if(arr[cnt2] >= arr[cnt1]){
                temp[i] = arr[cnt2];
                cnt2++;
            }
            else{
                temp[i] = arr[cnt1];
                cnt1++;
            }
        }
        for (int i = start; i < end ; i++) {
            arr[i] = temp[i];
        }
    }
}
