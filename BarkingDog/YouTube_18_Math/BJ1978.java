package org.example.BarkingDog.YouTube_18_Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 소수 찾기 브론즈2
public class BJ1978 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int cnt = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N ; i++) {
            int temp = Integer.parseInt(st.nextToken());
            boolean flag = false;
            for (int j = 2; j <= Math.sqrt(temp); j++) { // Math.sqrt 활용
                if(temp % j == 0){
                    flag = true;
                    break;
                }
            }
            if(!flag && temp != 1){
                cnt++;
            }
        }
        System.out.println(cnt);

    }
}
/*
주어진 수 N개 중에서 소수가 몇 개인지 찾아서 출력하는 프로그램을 작성하시오.

1은 합성수도 소수도 아니다.

 */

/*  루트 n을 j * j로 표현한 방법
public class BJ1978 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int cnt = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N ; i++) {
            int temp = Integer.parseInt(st.nextToken());
            boolean flag = false;
            for (int j = 2; j * j <= temp ; j++) { // 루트까지
                if(temp % j == 0){
                    flag = true;
                    break;
                }
            }
            if(!flag && temp != 1){
                cnt++;
            }
        }
        System.out.println(cnt);

    }
}
 */