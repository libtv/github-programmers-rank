package boj.BarkingDog_Collection.Greedy;

// 실버4 동전 0
import java.io.*;
import java.util.*;
public class BOJ11047 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); int k = Integer.parseInt(st.nextToken());
        int [] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        int [] DP = new int[k+1];
        for (int i = 1; i <= k; i++) {
            for (int j = 0; j < n; j++) {
                if(i - arr[j] >= 0){
                    if(DP[i] == 0) DP[i] = DP[i-arr[j]] + 1;
                    else DP[i] = Math.min(DP[i], DP[i-arr[j]] + 1);
                }
                else break;
            }
        }
        System.out.println(DP[k]);
    }
}
/*
준규가 가지고 있는 동전은 총 N종류이고, 각각의 동전을 매우 많이 가지고 있다.
동전을 적절히 사용해서 그 가치의 합을 K로 만들려고 한다. 이때 필요한 동전 개수의 최솟값을 구하는 프로그램을 작성하시오.
첫째 줄에 N과 K가 주어진다. (1 ≤ N ≤ 10, 1 ≤ K ≤ 100,000,000)
둘째 줄부터 N개의 줄에 동전의 가치 Ai가 오름차순으로 주어진다. (1 ≤ Ai ≤ 1,000,000, A1 = 1, i ≥ 2인 경우에 Ai는 Ai-1의 배수)
 */