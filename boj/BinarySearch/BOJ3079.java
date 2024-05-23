package boj.BinarySearch;

/**
 * 입국 심사 골드5
 * 이분탐색 - 매개 변수 탐색
 */
import java.util.*;
import java.io.*;
public class BOJ3079 {
    static int [] time;
    static int n, m;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); // 입국 심사관
        m = Integer.parseInt(st.nextToken()); // 입국 심사 받는 사람
        time = new int[n];
        int max = 0;
        for (int i = 0; i < n; i++) {
            time[i] = Integer.parseInt(br.readLine()); // 10^9
            max = Math.max(max, time[i]);
        }
        long start = 0;
        long end   = (long)1000000000 * 1000000000; // n = 1 m = 10^9 t = 10^9
        while (start < end){
            long mid = (start + end) / 2;
            long output = calculate(mid);
            if(m <= output){
                end = mid;
            }
            else start = mid + 1;
        }
        System.out.println(start);
    }
    public static long calculate(long input){
        long sum = 0;
        for (int i = 0; i < n; i++) {
            sum += input / time[i];
            if(sum > m) return sum;
        }
        return sum;
    }
}