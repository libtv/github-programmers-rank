package BarkingDog.YouTube_20_TwoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 수들의 합 2 실버4
public class BJ2003 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        int N = Integer.parseInt(split[0]);
        long M = Long.parseLong(split[1]);
        int [] arr = new int[N];
        long [] prefixSum = new long[N+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N ; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            if(i == 0) continue;
            prefixSum[i] = prefixSum[i-1] + arr[i-1];
        }
        prefixSum[N] = prefixSum[N-1] + arr[N-1];
        // System.out.println(Arrays.toString(prefixSum)); 입력 확인

        int left = 0;
        int right = 1;
        int count = 0;
        while (left <= right && left <= N && right <= N){
            long temp = prefixSum[right] - prefixSum[left];
            if(left == right){
                right++;
            }
            else if (temp == M){
                count++;
                right++;
            }
            else if (temp > M){
                left++;
            }
            else if(temp < M){
                right++;
            }
        }
        System.out.println(count);

    }
}
/*
N개의 수로 된 수열 A[1], A[2], …, A[N] 이 있다.
이 수열의 i번째 수부터 j번째 수까지의 합 A[i] + A[i+1] + … + A[j-1] + A[j]가 M이 되는 경우의 수를 구하는 프로그램을 작성하시오.

 */