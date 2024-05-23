package boj.BarkingDog_Collection.Math;

// 달팽이는 올라가고 싶다 브론즈 1

import java.io.*;
import java.util.*;
public class BOJ2869 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());

        int remain = v - a;

        if(remain <= 0){
            System.out.println(1);
        }
        else{
            int sum = 0;
            sum = (remain / (a - b));
            sum += remain % (a - b) != 0 ? 1 : 0;
            System.out.println(sum + 1);
        }
    }
}
