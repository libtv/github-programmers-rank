package boj.BarkingDog_Collection.Math;

// 설탕 배달 실버4
import java.io.*;
public class BOJ2839 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int cnt = 0;
        while (n > 0){
            if(n % 5 == 0){
                cnt += n / 5;
                n = 0;
                break;
            }
            cnt++;
            n -= 3;
        }
        if(n != 0) System.out.println(-1);
        else System.out.println(cnt);
    }
}
