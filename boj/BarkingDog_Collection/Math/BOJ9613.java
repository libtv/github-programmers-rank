package boj.BarkingDog_Collection.Math;

import java.util.*;
import java.io.*;

// GCD 합 실버4
public class BOJ9613 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        while (t-->0){
            st = new StringTokenizer(br.readLine());
            ArrayList<Integer> list = new ArrayList<>();
            while (st.hasMoreTokens()){
                if(list.size() == 0) st.nextToken();
                list.add(Integer.parseInt(st.nextToken()));
            }
            int size = list.size();
            long sum = 0;
            for (int i = 0; i < size; i++) {
                int cur = list.get(i);
                for (int j = i+1; j < size; j++) {
                    int temp = list.get(j);
                    if(cur > temp){
                       sum += GCD(cur, temp);
                    }
                    else if(cur == temp){
                        sum += cur;
                    }
                    else{ // cur < temp
                        sum += GCD(temp, cur);
                    }
                }
            }
            sb.append(sum).append("\n");
        }
        System.out.println(sb);
    }
    public static int GCD(int a, int b){
        if(b == 0) return a;
        return GCD(b, a % b);
    }
}
