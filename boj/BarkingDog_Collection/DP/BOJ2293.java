package boj.BarkingDog_Collection.DP;
// 동전1 골드5
import java.io.*;
import java.util.*;
public class BOJ2293 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); int k = Integer.parseInt(st.nextToken());
        
        int [] coin = new int[n];
        for (int i = 0; i < n; i++) {
            coin[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(coin);
        int [] DP = new int[k+1];
        for (int i = 0; i < n; i++) {            //  1, 2, 5
            int money = coin[i];
            if(money > k) break;
            DP[money]++;
            for (int j = 1; j <= k; j++) {
                if(j - money >=0){
                    DP[j] += DP[j - money];
                }
            }
        }
        System.out.println(DP[k]);
    }
}
/*
n가지 종류의 동전이 있다.
각각의 동전이 나타내는 가치는 다르다. 이 동전을 적당히 사용해서, 그 가치의 합이 k원이 되도록 하고 싶다.
그 경우의 수를 구하시오. 각각의 동전은 몇 개라도 사용할 수 있다.
사용한 동전의 구성이 같은데, 순서만 다른 것은 같은 경우이다.

DP[N]은 N의 가치를 만들기 위한 경우의 수

1, 2, 5 순서대로

DP[1] = 1



 */

/*

1 1 1 1 1 1 1
1 1 1 1 1 2
1 1 1 2 2
1 2 2 2
1 1 5
2 5




 */