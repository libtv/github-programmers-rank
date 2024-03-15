package BarkingDog.YouTube_18_Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 에라토스테네스의 체 실버4
public class BJ2960 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        int N = Integer.parseInt(split[0]);
        int K = Integer.parseInt(split[1]);
        int [] DP = new int[N+1];
        int cnt = 0;
        int answer = 0;
        for (int i = 2; i <= N; i++) {
            if(DP[i] == 1){
                continue;
            }
            boolean flag = false;
            for (int j = 1; j <= N; j++) {
                if(i * j > N){
                    break;
                }
                if(DP[i * j] == 0){
                    cnt++;
                    DP[i * j] = 1;
                }
                if(cnt == K){
                    answer = i * j;
                    flag = true;
                    break;
                }
            }
            if(flag){
                break;
            }
        }
        System.out.println(answer);
    }
}
/*
에라토스테네스의 체는 N보다 작거나 같은 모든 소수를 찾는 유명한 알고리즘이다.
2부터 N까지 모든 정수를 적는다.
N, K가 주어졌을 때, K번째 지우는 수를 구하는 프로그램을 작성하시오.
 */