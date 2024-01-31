package org.example.BarkingDog.YouTube_18_Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 소수 구하기 실버3
public class BJ1929 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        boolean[] check = new boolean[N+1];
        check[1] = true;
        for (int i = 2; i <= N; i++) {
            if(!check[i]){
                for (int j = 2; j <= N; j++) {
                    if(i * j <= N){
                        check[i * j] = true;
                    }
                    else{
                        break;
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = M; i <= N; i++) {
            if(!check[i]){
                sb.append(i);
                sb.append("\n");
            }
        }
        System.out.println(sb);

    }
}
/* M이상 N이하의 소수를 모두 출력하는 프로그램을 작성하시오

1. 2 ~ N까지 에라토스테네스의 체를 이용해서 배열을 채운다.
2. M이상 N이상의 값들을 배열에서 true인지 확인한다.
3. true 값들을 StringBuilder 객체에 append
4. 출력


 */