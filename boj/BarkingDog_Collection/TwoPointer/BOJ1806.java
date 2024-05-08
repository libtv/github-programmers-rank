package boj.BarkingDog_Collection.TwoPointer;

// 부분합 골드4
import java.util.*;
import java.io.*;
public class BOJ1806 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());

        int [] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(Arrays.toString(arr));
        int sx   = 0;
        int ex   = 0;
        long sum  = arr[0];
        int min = Integer.MAX_VALUE;
        while (sx <= ex && ex < n) {
            if(s <= sum){
                min = Math.min(min, (ex - sx) + 1);
                if(sx == ex){
                    ex++;
                    if(ex == n) break;
                    sum += arr[ex];
                }
                else{
                    sum -= arr[sx++];
                }
            }
            else{
                ex++;
                if(ex == n) break;
                sum += arr[ex];
            }
            System.out.println(sx + " " + ex + " " + sum);
        }
        if(min == Integer.MAX_VALUE) System.out.println(0);
        else System.out.println(min);
    }
}
