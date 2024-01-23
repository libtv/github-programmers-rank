package org.example.BarkingDog.YouTube_14_Sort_1;

import java.io.*;
public class BJ10989 {
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
                temp[i] = arr[cnt1];
                cnt1++;
            }
            else{
                temp[i] = arr[cnt2];
                cnt2++;
            }
        }
        for (int i = start; i < end ; i++) {
            arr[i] = temp[i];
        }
    }
}
/* 선택정렬 시간초과
 public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        for (int i = 0; i < N ; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        // 선택 정렬 연습하기
        for (int i = 0; i < N ; i++) {
            int idx = 0; // max idx
            for (int j = 0; j < N-i ; j++) {
                if(arr[idx] < arr[j]){
                    idx = j;
                }
            }
            int temp = arr[N-1-i];
            arr[N-1-i] = arr[idx];
            arr[idx] = temp;
        }
        for (int i = 0; i < N ; i++) {
            bw.write(arr[i]  + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
 */

/* 당연히 버블정렬 또한 시간초과
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
 */