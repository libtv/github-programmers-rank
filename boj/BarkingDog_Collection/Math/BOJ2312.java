package boj.BarkingDog_Collection.Math;

// 수 복원하기 실버3
import java.io.*;
public class BOJ2312 {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        while (t-->0){
            int input = Integer.parseInt(br.readLine());

            for (int i = 2; i * i <= input; i++) {
                int cnt = 0;
                while (input % i == 0){
                    cnt++;
                    input /= i;
                }
                if(cnt == 0) continue;
                sb.append(i).append(" ").append(cnt).append("\n");
            }
            if(input != 1) sb.append(input).append(" ").append(1).append("\n");
        }
        System.out.println(sb);
    }
}
