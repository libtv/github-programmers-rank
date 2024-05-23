package BarkingDog.YouTube_19_BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

// 세 수의 합 골드4
public class BJ2295_Upgrade {
    static long [] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr = new long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(br.readLine());
        }
        Arrays.sort(arr);

        Set<Long> set = new HashSet<>();
        for (int i = 0; i < n-1 ; i++) {
            for (int j = 0; j < n-1; j++) {
                set.add(arr[i] + arr[j]);
            }
        }
        for (int i = n-1; i >=1 ; i--) {
            long temp = arr[i];
            boolean flag = false;
            for (int j = i-1; j >=0 ; j--) {
                long target = temp - arr[j];
                if(set.contains(target)){
                    flag = true;
                    break;
                }
            }
            if(flag){
                System.out.println(temp);
                break;
            }
        }
    }
}
