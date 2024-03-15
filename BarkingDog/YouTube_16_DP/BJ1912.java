package BarkingDog.YouTube_16_DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://www.acmicpc.net/problem/1912
// 연속합 실버2
public class BJ1912 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int [] arr = new int[n+1];
        String[] split = br.readLine().split(" ");
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(split[i-1]);
        }
        int [] PrefixSum = new int[n+1];
        PrefixSum[1] = arr[1];
        for (int i = 2; i <= n; i++) {
            if(PrefixSum[i-1] >= 0){
                PrefixSum[i] = PrefixSum[i-1] + arr[i];
            }
            else{
                PrefixSum[i] = arr[i];
            }
        }
        // System.out.println(Arrays.toString(PrefixSum));
        int max = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            if(PrefixSum[i] > max){
                max = PrefixSum[i];
            }
        }
        System.out.println(max);

    }
}

/*
n개의 정수로 이루어진 임의의 수열이 주어진다. 우리는 이 중 연속된 몇 개의 수를 선택해서 구할 수 있는 합 중 가장 큰 합을 구하려고 한다.
단, 수는 한 개 이상 선택해야 한다.
예를 들어서 10, -4, 3, 1, 5, 6, -35, 12, 21, -1 이라는 수열이 주어졌다고 하자. 여기서 정답은 12+21인 33이 정답이 된다.
 */
/* 문제접근
누가봐도 누적합 ㅋ
 */