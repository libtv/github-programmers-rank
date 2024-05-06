package boj.BarkingDog_Collection.Math;

// ACM 호텔 브론즈3
import java.util.*;
import java.io.*;
public class BOJ10250 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (t-->0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int h = Integer.parseInt(st.nextToken()); // 높이
            int w = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());

            // 호수
            int temp = n / h + (n % h == 0 ? 0 : 1);

            // 층
            int temp2 = n % h + (n % h == 0 ? h : 0 );

            sb.append(temp2);
            if(temp < 10){
                sb.append(0).append(temp);
            }
            else sb.append(temp);

            sb.append("\n");

        }
        System.out.println(sb);
    }
}
