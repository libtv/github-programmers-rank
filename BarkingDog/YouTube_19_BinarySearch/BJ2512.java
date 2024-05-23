package BarkingDog.YouTube_19_BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 예산 실버2
public class BJ2512 {
    static long [] arr;
    static long budget; // 전체 예산
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 지방의 수
        arr = new long[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n ; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }
        budget = Long.parseLong(br.readLine());
        Arrays.sort(arr);
        System.out.println(BinarySearch(1, arr[n-1]));
    }
    public static long BinarySearch(long start , long end){
        while(start <= end){
            long mid = (start + end) / 2;
            if(find(mid) > budget){
                end = mid -1;
            }
            else if(find(mid) <= budget){
                start = mid + 1;
            }
        }
        return end;
    }
    public static long find(long limit){
        long sum = 0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] <= limit){
                sum += arr[i];
            }
            else{
                sum += limit;
            }
        }
        return sum;
    }
}
/*
국가의 역할 중 하나는 여러 지방의 예산요청을 심사하여 국가의 예산을 분배하는 것이다.
모든 요청이 배정될 수 있는 경우에는 요청한 금액을 그대로 배정한다.
모든 요청이 배정될 수 없는 경우에는 특정한 정수 상한액을 계산하여 그 이상인 예산요청에는 모두 상한액을 배정한다.
상한액 이하의 예산요청에 대해서는 요청한 금액을 그대로 배정한다.

여러 지방의 예산요청과 국가예산의 총액이 주어졌을 때, 위의 조건을 모두 만족하도록 예산을 배정하는 프로그램을 작성하시오.

 */