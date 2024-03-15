package BarkingDog.YouTube_19_BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// 랜선 자르기
public class BJ1654 {
    static long [] arr;
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        int k = Integer.parseInt(split[0]);
        n = Integer.parseInt(split[1]);
        arr = new long[k];

        for (int i = 0; i < k; i++) {
            arr[i] = Long.parseLong(br.readLine());
        }
        Arrays.sort(arr);
        System.out.println(BinarySearch(1, arr[k-1]));
    }
    /*
    랜선 길이가 up   랜선 개수는 down
    랜선 길이가 down 랜선 개수는 up
     */
    public static long BinarySearch(long start, long end){
        while (start <= end){
            long mid = (start + end) / 2;
            if(find(mid) >= n){ // n 보다 랜선 개수가 많으니까 랜선 길이를 늘린다.
                start = mid + 1;
            }
            else{
                end = mid - 1;
            }
        }
        return end;
    }
    public static long find(long size){ // 랜선의 길이가 들어오면 랜선 개수를 찾아주는 메서드
        long sum = 0;
        for (int i = 0; i < arr.length ; i++) {
            sum += arr[i] / size;
        }
        return sum;
    }
}
/*
 캠프 때 쓸 N개의 랜선을 만들어야 하는데
 이미 자체적으로 K개의 랜선을 가지고 있다.
 그러나 K개의 랜선은 길이가 제각각이다.
 랜선을 모두 N개의 같은 길이의 랜선으로 만들고 싶었기 때문에 K개의 랜선을 잘라서 만들어야 한다.
 예를 들어 300cm 짜리 랜선에서 140cm 짜리 랜선을 두 개 잘라내면 20cm는 버려야 한다.
 이때 만들 수 있는 최대 랜선의 길이를 구하는 프로그램을 작성하시오.

 최적화 문제 N개를 만들 수 있는 랜선의 최대 길이
 -> 랜선의 길이가 X일 때 랜선이 N개 이상인가 아닌가


 */