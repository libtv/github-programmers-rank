package org.example.BarkingDog.YouTube_17_Greedy;

import java.io.IOException;
import java.util.Scanner;

// 게임을 만든 동준이 실버4
public class BJ2847 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int [] arr = new int[N];
        for (int i = 0; i < N ; i++) {
            arr[i] = sc.nextInt();
        }
        int cnt = 0;
        while (true){
            boolean flag = true;
            for (int i = 0; i < N-1; i++) {
                while (arr[i] >= arr[i+1]){
                    cnt++;
                    arr[i] -= 1;
                    flag = false;
                }
            }
            if(flag){
                break;
            }
        }
        System.out.println(cnt);
    }
}
/*

5 3 7 5

5 -> 2  3
7 -> 4  3


 */