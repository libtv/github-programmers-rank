package boj.BarkingDog_Collection.Math;

// 캠핑 브론즈1
import java.io.*;
import java.util.*;
public class BOJ4796 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int cnt = 1;
        while (true){
            st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            if(l == 0 && p == 0 && v == 0) break;

            int sum = l * (v / p);
            int remain = v % p;
            if(remain >= l) sum += l;
            else sum += remain;

            sb.append("Case ").append(cnt++).append(": ").append(sum).append("\n");
        }
        System.out.println(sb);
    }
}
