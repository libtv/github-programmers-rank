package boj.BarkingDog_Collection.Greedy;


// 실버4 동전 0
import java.io.*;
import java.util.*;
public class BOJ11047_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); int k = Integer.parseInt(st.nextToken());
        Stack<Integer> stack = new Stack<>();
        while (n-->0){
            stack.push(Integer.parseInt(br.readLine()));
        }
        int cnt = 0;
        while (k!=0){
            int tmp = stack.pop();
            cnt += k / tmp;
            k %= tmp;
        }
        System.out.println(cnt);
    }

}
