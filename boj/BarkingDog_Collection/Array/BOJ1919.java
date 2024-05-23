package boj.BarkingDog_Collection.Array;

// 애너그램 만들기 브론즈2
import java.io.*;
public class BOJ1919 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String a = br.readLine();
        String b = br.readLine();
        int [] arr  = new int[26];
        int [] arr2 = new int[26];
        for (int i = 0; i < a.length(); i++) {
            arr[a.charAt(i) - '0' - 49] += 1;
        }
        for (int i = 0; i < b.length(); i++) {
            arr2[b.charAt(i)- '0' - 49] += 1;
        }
        int cnt = 0;
        for (int i = 0; i < 26; i++) {
            if(arr[i] == arr2[i]) continue;
            cnt += Math.abs(arr[i] - arr2[i]);
        }
        System.out.println(cnt);
    }
}
