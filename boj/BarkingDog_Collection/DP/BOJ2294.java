package boj.BarkingDog_Collection.DP;

// 동전 2 골드5
import java.util.*;
import java.io.*;
public class BOJ2294 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int [] coin = new int[n];

        for (int i = 0; i < n; i++) {
            coin[i] = Integer.parseInt(br.readLine());
            if(coin[i] == k){          // 코인이 k원과 똑같다면
                System.out.println(1);
                return;
            }
        }
        Arrays.sort(coin);
        int [] DP = new int[k+1];
        Arrays.fill(DP, Integer.MAX_VALUE/2);
        for (int i = 1; i <= k; i++) {
            for (int j = 0; j < n; j++) {
                int money = coin[j];
                if(money > k) continue;
                else if(money == i){
                    DP[i] = 1;
                    break;
                }
                if(i - money >= 1){
                    DP[i] = Math.min(DP[i], DP[i-money]+1);
                }
            }
        }
        if(DP[k] == Integer.MAX_VALUE/2) System.out.println(-1);
        else System.out.println(DP[k]);
    }
}
/*

동전의 가치는 100,000보다 작거나 같은 자연수이다. 가치가 같은 동전이 여러 번 주어질 수도 있다.
n가지 종류의 동전이 있다. 이 동전들을 적당히 사용해서, 그 가치의 합이 k원이 되도록 하고 싶다.
각각의 동전은 몇 개라도 사용할 수 있다.
그러면서 동전의 개수가 최소가 되도록 하려고 한다.

DP[N] = 동전을 만드는 최소한의 수







 */