package BarkingDog.YouTube_19_BinarySearch;

import java.io.*;
import java.util.Arrays;

// 세 수의 합 골드4
public class BJ2295 {
    static long target;
    static long [] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr = new long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(br.readLine());
        }
        Arrays.sort(arr);
        for (int i = n-1; i >=1 ; i--) {
            long sum = arr[i];
            boolean flag = false;
            for (int j = i; j >= 0 ; j--) {
                for (int k = j; k >=0; k--) {
                     target = sum - (arr[j] + arr[k]);
                     boolean check = BinarySearch(0, k);
                     if(check){
                         flag = true;
                         break;
                     }
                }
                if(flag){
                    break;
                }
            }
            if(flag){
                System.out.println(sum);
                break;
            }
        }
    }
    public static boolean BinarySearch(int start , int end){
        while (start <= end){
            int mid = (start + end) / 2;
            if(arr[mid] > target){
                end = mid - 1;
            }
            else if(arr[mid] == target){
                return true;
            }
            else if(arr[mid] < target){
                start = mid + 1;
            }
        }
        return false;
    }
}
/*
N(5 ≤ N ≤ 1,000)개의 자연수들로 이루어진 집합 U가 있다.

이 중에서 적당히 세 수를 골랐을 때, 그 세 수의 합 d도 U안에 포함되는 경우가 있을 수 있다.
이러한 경우들 중에서, 가장 큰 d를 찾으라.

 */

/*
이 코드에 이분탐색 적용하기

public class BJ2295 { <-- 46퍼에서 시간초과
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        long [] arr = new long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(br.readLine());
        }
        Arrays.sort(arr);
        for (int i = n-1; i >=3 ; i--) { // 제일 큰값부터
            long sum = arr[i];
            boolean flag = false;
            for (int j = i-1; j >=2; j--) {
                for (int k = j-1; k >=1; k--) {
                    for (int l = j-1; l >=0 ; l--) {
                        if(arr[j] + arr[k] + arr[l] == sum){
                            flag = true;
                            break;
                        }
                    }
                    if(flag){
                        break;
                    }
                }
                if(flag){
                    break;
                }
            }
            if(flag){
                System.out.println(sum);
                break;
            }
        }
    }
}
 */

