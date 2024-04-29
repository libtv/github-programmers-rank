package boj.BarkingDog_Review;

// 동전 문제
import java.io.*;
import java.util.*;
public class BOJ_35_1398 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        int [] DP = new int[100];
        Arrays.fill(DP, Integer.MAX_VALUE / 1000);
        int [] arr = {1, 10, 25};
        for (int i = 0; i < 3; i++) {
            int cur = arr[i];
            DP[cur] = 1;
            for (int j = 1; j < 100; j++) {
                if(j - cur >= 0){
                    DP[j] = Math.min(DP[j - cur] + 1, DP[j]);
                }
            }
        }
        // System.out.println(Arrays.toString(DP));
        DP[0] = 0;
        while (t-->0){
            int sum = 0;
            long target = Long.parseLong(br.readLine());
            while (target > 0){
                int temp = (int)(target % 100);
                sum += DP[temp];
                target /= 100;
            }
            sb.append(sum).append("\n");
        }
        System.out.println(sb);
    }
}
/*

구사과국은 동전만 사용하고, 동전의 가치는 다음과 같다.

1, 10, 25, 100, 1000, 2500, 10000, 100000, 250000, 1000000 ...

즉, 식으로 표현하면 K ≥ 0를 만족하는 모든 K에 대해서, 가치가 10K인 동전과 25×100K인 동전이 있는 것이다.

이를 구매하기 위해 필요한 동전 개수의 최솟값을 구해보자. 각 동전의 개수는 무한하고, 구매할 때는 정확하게 초콜릿의 가격만큼만 지불해야 한다.


 */