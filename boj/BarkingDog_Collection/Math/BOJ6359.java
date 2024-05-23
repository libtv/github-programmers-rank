package boj.BarkingDog_Collection.Math;

// 만취한 상범 브론즈2
import java.io.*;
public class BOJ6359 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (t-->0){
            int input = Integer.parseInt(br.readLine());
            boolean [] room = new boolean[input+1]; // false 탈출x  true 탈출o
            for (int i = 1; i <= input; i++) {
                for (int j = i; j <= input; j+=i) {
                    room[j] = !room[j];
                }
            }
            int cnt = 0;
            for (int i = 1; i <= input; i++) {
                if(room[i]) cnt++;
            }
            sb.append(cnt).append("\n");
        }
        System.out.println(sb);
    }
}