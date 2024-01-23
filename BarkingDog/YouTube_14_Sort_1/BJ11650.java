package org.example.BarkingDog.YouTube_14_Sort_1;

import java.io.*;
import java.util.Arrays;

// https://www.acmicpc.net/problem/11650
// 좌표 정렬하기 실버5
public class BJ11650 {
    static int N;
    static int [] Xarray;
    static int [] Yarray;
    static int [] temp;
    static int [] temp2;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        // 1. y좌표가 증가하는 순서로 정렬
        // 2. x좌표가 증가하는 순서로 정렬
        N = Integer.parseInt(br.readLine());
        Xarray = new int[N];
        Yarray = new int[N];
        temp = new int[N];
        temp2 = new int[N];
        for (int i = 0; i < N ; i++) {
            String[] split = br.readLine().split(" ");
            Xarray[i] = Integer.parseInt(split[0]);
            Yarray[i] = Integer.parseInt(split[1]);
        }
        funcY(0, N);
        funcX(0, N);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N ; i++) {
            sb.append(Xarray[i]);
            sb.append(" ");
            sb.append(Yarray[i]);
            sb.append("\n");
        }
        System.out.println(sb);

    }
    public static void funcY(int start, int end){ // Y 좌표 순으로 정렬
        if(end - start == 1){
            return;
        }
        int mid = (start + end) / 2;
        funcY(start, mid);
        funcY(mid , end);
        func2Y(start, end);
    }
    public static void func2Y(int start, int end){
        int mid = (start + end) / 2;
        int cnt1 = start;
        int cnt2 = mid;
        for (int i = start; i < end; i++) {
            if(cnt1 == mid){
                temp[i] = Xarray[cnt2];
                temp2[i] = Yarray[cnt2];
                cnt2++;
            }
            else if(cnt2 == end){
                temp[i] = Xarray[cnt1];
                temp2[i] = Yarray[cnt1];
                cnt1++;
            }
            else if(Yarray[cnt1] < Yarray[cnt2]){
                temp[i] = Xarray[cnt1];
                temp2[i] = Yarray[cnt1];
                cnt1++;
            }
            else{
                temp[i] = Xarray[cnt2];
                temp2[i] = Yarray[cnt2];
                cnt2++;
            }
        }
        for (int i = start; i < end ; i++) {
            Xarray[i] = temp[i];
            Yarray[i] = temp2[i];
        }
    }
    public static void funcX(int start, int end){ // Y 좌표 순으로 정렬
        if(end - start == 1){
            return;
        }
        int mid = (start + end) / 2;
        funcX(start, mid);
        funcX(mid , end);
        func2X(start, end);
    }
    public static void func2X(int start, int end){
        int mid = (start + end) / 2;
        int cnt1 = start;
        int cnt2 = mid;
        for (int i = start; i < end; i++) {
            if(cnt1 == mid){
                temp[i] = Xarray[cnt2];
                temp2[i] = Yarray[cnt2];
                cnt2++;
            }
            else if(cnt2 == end){
                temp[i] = Xarray[cnt1];
                temp2[i] = Yarray[cnt1];
                cnt1++;
            }
            else if(Xarray[cnt1] <= Xarray[cnt2]){
                temp[i] = Xarray[cnt1];
                temp2[i] = Yarray[cnt1];
                cnt1++;
            }
            else{
                temp[i] = Xarray[cnt2];
                temp2[i] = Yarray[cnt2];
                cnt2++;
            }
        }
        for (int i = start; i < end ; i++) {
            Xarray[i] = temp[i];
            Yarray[i] = temp2[i];
        }
    }
}

/*
2차원 평면 위의 점 N개가 주어진다. 좌표를 x좌표가 증가하는 순으로, x좌표가 같으면 y좌표가 증가하는 순서로 정렬한 다음 출력하는 프로그램을 작성하시오.
 */