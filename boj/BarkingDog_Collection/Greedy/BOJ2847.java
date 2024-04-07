package boj.BarkingDog_Collection.Greedy;

// 게임을 만든 동준이 실버4
import java.io.*;
public class BOJ2847 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int [] data = new int[n];
        for (int i = 0; i < n; i++) {
            data[i] = Integer.parseInt(br.readLine());
        }
        int count = 0;
        for (int i = n - 2; i >= 0; i--) {
            if(data[i] >= data[i+1]){
                count += (data[i] - data[i+1]) + 1;
                data[i] = data[i+1] - 1;
            }
        }
        System.out.println(count);
    }
}