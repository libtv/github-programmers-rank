package BarkingDog.YouTube_20_TwoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 부분합 골드4
public class BJ1806 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        int N = Integer.parseInt(split[0]);
        long S = Long.parseLong(split[1]);
        int [] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N ; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        // Arrays.sort(arr);
        long [] prefixSum = new long[N+1];
        for (int i = 1; i <= N; i++) {
            prefixSum[i] = prefixSum[i-1] + arr[i-1];
        }
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(prefixSum));
        // 첫째 줄에 구하고자 하는 최소의 길이를 출력한다. 만일 그러한 합을 만드는 것이 불가능하다면 0을 출력하면 된다.
        int min = Integer.MAX_VALUE;
        int left = 0;
        int right = 0;
        while (left <= right && left <= N && right <= N){
            long temp = prefixSum[right] - prefixSum[left];
            if(temp >= S && left < right){
                min = Math.min(min , right - left);
                left++;
            }
            else if(temp < S && left < right){
                right++;
            }
            else if(left == right){
                right++;
            }
        }
        if(min !=Integer.MAX_VALUE){
            System.out.println(min);
        }
        else{
            System.out.println(0);
        }
    }
}
/*
10,000 이하의 자연수로 이루어진 길이 N짜리 수열이 주어진다.
이 수열에서 연속된 수들의 부분합 중에 그 합이 S 이상이 되는 것 중
가장 짧은 것의 길이를 구하는 프로그램을 작성하시오.
 */