package boj.BarkingDog_Collection.Math;

import java.io.*;
import java.util.*;
public class BOJ1476_2 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int e = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int cnt = 0;

        if(e == 15) e = 0;
        if(s == 28) s = 0;
        if(m == 19) m = 0;

        while (true){
            int temp = e + (15 * cnt);
            if(temp == 0){
                cnt++;
                continue;
            }
            if(temp % 28 == s && temp % 19 == m){
                System.out.println(temp);
                break;
            }
            cnt++;
        }
    }
}
