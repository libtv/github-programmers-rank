package boj.BarkingDog_Collection.BinarySearch;

// 용액 골드5
import java.util.*;
import java.io.*;
public class BOJ2467 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int [] liquid = new int[n];

        StringTokenizer s = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            liquid[i] = Integer.parseInt(s.nextToken());
        }

        Arrays.sort(liquid);
        int a = 0; int b = 0;
        int min = 1000000000;
        for (int i = 0; i < n; i++) {
           int st = 0;
           int en = n - 1;
           while (st <= en){
               int mid = (st + en) / 2;
               int temp = liquid[mid] + liquid[i];
               if(temp < 0){
                   st = mid + 1;
               }
               else if(temp > 0){
                   en = mid - 1;
               }
               else{
                   if(liquid[mid] >= liquid[i]){
                       System.out.println(liquid[i] + " " + liquid[mid]);
                   }
                   else System.out.println(liquid[mid] + " " + liquid[i]);
                   return;
               }
               if(min > Math.abs(temp) && mid != i){
                   min = Math.abs(temp);
                   a = liquid[i];
                   b = liquid[mid];
               }
           }
        }
        if(a >= b){
            System.out.println(b + " " + a);
        }
        else  System.out.println(a + " " + b);
    }
}
