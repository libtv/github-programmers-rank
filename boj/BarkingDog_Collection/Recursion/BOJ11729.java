package org.example.boj.BarkingDog_Collection.Recursion;

import java.io.IOException;
import java.util.Scanner;

// 하노이 탑 이동 순서 골드5
public class BOJ11729 {
    static int count; static StringBuilder sb; static int n;
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt(); sb = new StringBuilder(); count = 0;
        Hanoi(n,1,2,3);
        System.out.println(count);
        System.out.println(sb);

    }
    public static void Hanoi(int N, int start, int mid, int end){
        if(N == 1){
            sb.append(start).append(" ").append(end).append("\n");
            count++;
            return;
        }
        Hanoi(N - 1, start, end, mid);
        sb.append(start).append(" ").append(end).append("\n");
        count++;
        Hanoi(N - 1, mid, start, end);
    }
}
/*

n-1개를 A->B로 옮긴다.
가장 밑의 원반을 A->C
n-1개의 원반을 B->C로 옮긴다.


1     2     3

1
2

1 -> 2 (A->B)
1 -> 3 (A->C)
2 -> 3 (B->C)


 */
