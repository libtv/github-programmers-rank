package boj.BarkingDog_Collection.Greedy;

// 로프 실버4
import java.io.*;
import java.util.Arrays;
public class BOJ2217 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int [] data = new int[n];
        for (int i = 0; i < n; i++) {
            data[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(data);
        long max = 0;
        int cnt = n;
        for (int i = 0; i < n; i++) {
            if(data[i] * cnt > max){
                max = data[i] * cnt;
            }
            cnt--;
        }
        System.out.println(max);
    }
}