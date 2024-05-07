package boj.BarkingDog_Collection.Math;

// Fly me to the Alpha Centauri 골드5
import java.io.*;
import java.util.*;
public class BOJ1011 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while (t-->0){
            StringTokenizer st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end   = Integer.parseInt(st.nextToken());

            int remain = end - start;

            int max = (int) Math.sqrt(remain);
            int answer = max * 2 - 1;
            remain -= (max * max);

            answer += (remain / max);
            answer +=  remain % max != 0 ? 1 : 0;
            sb.append(answer).append("\n");
        }
        System.out.println(sb);
    }
}
/*

if use 2

1 2 1              4

1 2 3 2 1          9

1 2 3 4 3 2 1      16

1 2 3 4 5 4 3 2 1  25

1 -> 2  2 -> 4 4 -> 1
 1  2  1
 1  1  1

1 -> 2 -> 2 -> 1

0 -> 1  1 -> 3  3 -> 5  5 -> 6  6 -> 7
   1      2       2       1       1

0 -> 1  1 -> 3  3 -> 6  6 -> 8  8 -> 9
 1       2        3        2      1

 */