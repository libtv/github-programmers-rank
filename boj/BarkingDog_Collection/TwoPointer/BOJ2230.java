package boj.BarkingDog_Collection.TwoPointer;

// 수 고르기 골드5
import java.io.*;
import java.util.*;
public class BOJ2230 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int [] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);

        int sx = 0;
        int ex = 0;
        int min = Integer.MAX_VALUE;
        while (sx <= ex && sx < n && ex < n){
            int temp = Math.abs(arr[sx] - arr[ex]);

            if(m <= temp){
                min = Math.min(min, temp);
            }
            if(temp == m){
                System.out.println(temp);
                return;
            }
            else if(temp < m || sx == ex){
                ex++;
            }
            else sx++;
        }
        System.out.println(min);
    }
}
