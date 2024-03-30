package boj.BarkingDog_Collection.DP;

// 동전 문제 골드2
import java.io.*;
import java.util.Arrays;
public class BOJ1398 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        int [] DP = new int[100];
        int [] arr = {1,10,25};
        Arrays.fill(DP, Integer.MAX_VALUE / 2);
        for (int i = 1; i < 100; i++) {
            for (int j = 0; j < 3; j++) {
                int temp = arr[j];
                if(i == temp){
                    DP[i] = 1;
                    break;
                }
                if(i - temp >= 1){
                    DP[i] = Math.min(DP[i], DP[i-temp] + 1);
                }
            }
        }
        DP[0] = 0;
        while (t-->0){
            long target = Long.parseLong(br.readLine());
            int count = 0;
            while (target > 0){
                int num = (int)(target % 100);
                count += DP[num];
                target /= 100;
            }
            sb.append(count).append("\n");
        }
        System.out.println(sb);
    }
}
