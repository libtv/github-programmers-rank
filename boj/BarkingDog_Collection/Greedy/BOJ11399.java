package boj.BarkingDog_Collection.Greedy;

// ATM 실버4
import java.io.*;
import java.util.*;
public class BOJ11399 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int [] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int sum = 0;
        int time = 0;
        for (int i = 0; i < arr.length; i++) {
            int temp = arr[i];
            sum  += time + temp;
            time += temp;
        }
        System.out.println(sum);

    }
}
