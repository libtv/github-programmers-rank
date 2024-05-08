package boj.BarkingDog_Collection.BinarySearch;

// 용액 합성하기 골드5
import java.util.*;
import java.io.*;
public class BOJ14921 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int [] liquid = new int[n];
        StringTokenizer s = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            liquid[i] = Integer.parseInt(s.nextToken());
        }
        Arrays.sort(liquid);

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int target = liquid[i];
            int st = 0;
            int en = n - 1;
            while (st <= en){
                int mid = (st + en) / 2;
                int temp = target + liquid[mid];
                if(temp == 0){
                    if(i != mid){
                        System.out.println(0);
                        return;
                    }
                    break;
                }
                else if(temp > 0){
                    en = mid - 1;
                }
                else st = mid + 1;

                if(Math.abs(min) > Math.abs(temp) && i != mid){
                    min = temp;
                }
            }
        }
        System.out.println(min);
    }
}
