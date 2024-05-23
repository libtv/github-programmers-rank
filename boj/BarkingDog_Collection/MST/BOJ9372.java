package boj.BarkingDog_Collection.MST;

/**
 * 상근이의 여행 실버4
 * 최소 신장 트리
 */
import java.util.*;
import java.io.*;
public class BOJ9372 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        while (t-->0){
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken()); // 국가의 수
            int m = Integer.parseInt(st.nextToken()); // 비행기의 종류
            while (m-->0){
                st = new StringTokenizer(br.readLine());
            }
            sb.append(n - 1).append("\n");
        }
        System.out.println(sb);
    }
}
