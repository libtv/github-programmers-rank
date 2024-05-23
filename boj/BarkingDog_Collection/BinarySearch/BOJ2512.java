package boj.BarkingDog_Collection.BinarySearch;

// 예산 실버2
import java.io.*;
import java.util.*;
public class BOJ2512 {
    static int [] want;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        want = new int[n];
        StringTokenizer ST = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            want[i] = Integer.parseInt(ST.nextToken());
        }
        int budget = Integer.parseInt(br.readLine());

        int st = 0;
        int en = 1000000000;
        while (st <= en){
            int mid = (st + en) / 2;
            long count = calculate(mid);
            if(count <= budget){
                st = mid + 1;
            }
            else en = mid - 1;
        }
        System.out.println(findMax(en));
    }
    public static long calculate(int input){
        long sum = 0;
        for (int i = 0; i < want.length; i++) {
            sum += want[i] >= input ? input : want[i];
        }
        return sum;
    }

    public static long findMax(int input){
        int max = 0;
        for (int i = 0; i < want.length; i++) {
            int cur = want[i] >= input ? input : want[i];
            max = Math.max(max, cur);
        }
        return max;
    }
}
