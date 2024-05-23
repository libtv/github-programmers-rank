package BarkingDog.YouTube_18_Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 이항 계수 1 브론즈1
public class BJ11050 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int answer = 1;
        for (int i = 1; i <= N; i++) {
            answer *= i;
        }
        int temp = 1;
        for (int i = 1; i <= N-K; i++) {
            temp *= i;
        }
        answer /= temp;
        temp = 1;
        for (int i = 1; i <= K; i++) {
            temp *= i;
        }
        answer /= temp;
        System.out.println(answer);
    }
}
/*
자연수 N과 K가 주어졌을 때 이항 계수 (N K)를 구하는 프로그램을 작성하시오.

이항계수는 2가지 방법이 있다.
1. 순서를 고려한다.
순서를 고려한다고 하면  = N! / (N-K)!
2. 순서를 고려X
 = N! / (N-K)!K!

 */