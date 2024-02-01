package org.example.BarkingDog.YouTube_18_Math;

import java.util.Scanner;

// 만취한 상범 브론즈2
public class BJ6359 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        boolean [] prison;
        for (int i = 0; i < T ; i++) {
            int N = sc.nextInt();
            prison = new boolean[N+1]; // false가 잠겨 있는 true는 열려 있는
            for (int j = 1; j <= N; j++) { // 1~N번 라운드
                for (int k = 1; k <= N; k++) {
                    if(j * k > N){
                        break;
                    }
                    if(prison[j * k]){
                        prison[j * k] = false;
                    }
                    else{
                        prison[j * k ] = true;
                    }
                }
            }
            int count = 0;
            for (int j = 1; j <= N; j++) {
                if(prison[j]){
                    count++;
                }
            }
            System.out.println(count);
        }

    }
}
/*
입력의 첫 번째 줄에는 테스트 케이스의 개수 T가 주어진다. 각 테스트 케이스는 한 줄에 한 개씩 방의 개수 n(5 ≤ n ≤ 100)이 주어진다.


 */