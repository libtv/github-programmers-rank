package org.example.BarkingDog.YouTube_14_Sort_1;

import java.util.*;
import java.io.*;
public class BJ2751 {
    static int N;
    static int [] arr;
    static int [] temp;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException{
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        temp = new int[N];
        for (int i = 0; i < N ; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        func(0, N);
        for (int i = 0; i < N ; i++) {
            bw.write(arr[i] + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
    public static void func(int sx, int ex){
        if(ex - sx == 1){
            return;
        }
        int mx = (sx + ex) / 2;
        func(sx, mx);
        func(mx, ex);
        func2(sx, ex);
    }
    public static void func2(int sx, int ex){
        int cnt1 = sx;
        int mx = (sx + ex) / 2;
        int cnt2 = mx;
        for (int i = sx; i < ex ; i++) {
            if(cnt1 == mx){
                temp[i] = arr[cnt2];
                cnt2++;
            }
            else if(cnt2 == ex){
                temp[i] = arr[cnt1];
                cnt1++;
            }
            else{
                if(arr[cnt1] < arr[cnt2]){
                    temp[i] = arr[cnt1];
                    cnt1++;
                }
                else{
                    temp[i] = arr[cnt2];
                    cnt2++;
                }
            }
        }
        for (int i = sx; i < ex ; i++) {
            arr[i] = temp[i];
        }
    }
}
