package boj.BarkingDog_Collection.Math;

// 소인수 분해 브론즈1
import java.io.*;
public class BOJ11653 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 2; i * i <= n; i++) {
            while (n % i == 0){
                sb.append(i).append("\n");
                n /= i;
            }
        }
        if(n != 1) sb.append(n);
        System.out.println(sb);
    }
}
