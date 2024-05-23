package boj.BarkingDog_Collection.BinarySearch;

// 과자 나눠주기 실버2
import java.io.*;
import java.util.*;
public class BOJ16401 {
    static int [] snack;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer;
        stringTokenizer = new StringTokenizer(br.readLine());

        int m = Integer.parseInt(stringTokenizer.nextToken());
        int n = Integer.parseInt(stringTokenizer.nextToken());

        snack = new int[n];

        stringTokenizer = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            snack[i] = Integer.parseInt(stringTokenizer.nextToken());
        }


        int st = 0;
        int en = 1000000000;
        int max = 0;

        while (st <= en){
            int mid = (st + en + 1) / 2;
            if(mid == 0) break;
            long count = calculate(mid);
            if(m <= count){
                st = mid + 1;
                max = mid;
            }
            else en = mid - 1;
        }
        System.out.println(max);

    }
    public static long calculate(int input){
        long sum = 0;
        for (int i = 0; i < snack.length; i++) {
            sum += snack[i] / input;
        }
        return sum;
    }
}
