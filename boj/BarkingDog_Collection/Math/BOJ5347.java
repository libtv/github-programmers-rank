package boj.BarkingDog_Collection.Math;

import java.io.*;
import java.util.*;

// LCM 실버5
public class BOJ5347 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while (t-->0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if(a >= b) sb.append(LCM(a, b));
            else sb.append(LCM(b ,a));

            sb.append("\n");
        }
        System.out.println(sb);
    }
    public static long LCM(int a, int b){
        return a / GCD(a, b) * b;
    }

    public static long GCD(int a, int b){
        if(b == 0) return a;
        return GCD(b, a % b);
    }

}
