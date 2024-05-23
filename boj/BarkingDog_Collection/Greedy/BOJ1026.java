package boj.BarkingDog_Collection.Greedy;

// 보물 실버4
import java.io.*;
import java.util.*;
public class BOJ1026 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n  = Integer.parseInt(br.readLine());
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int [] A = new int[n];
        for (int i = 0; i < n; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        int [] B = new int[n];
        for (int i = 0; i < n; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(A);
        Arrays.sort(B);
        int cnt = 0;
        int min = 0;
        for (int i = n-1; i >= 0; i--) {
            min += B[i] * A[cnt];
            cnt++;
        }
        System.out.println(min);
    }
}
