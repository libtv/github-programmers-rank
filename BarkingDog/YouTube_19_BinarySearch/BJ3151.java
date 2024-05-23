package BarkingDog.YouTube_19_BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 합이 0 골드4
/*
이항계수 개념 + 이분탐색 개념
 */
public class BJ3151 {
    static int [] arr;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        long count = 0;
        for (int i = 0; i < n; i++) {
            if(arr[i] > 0) break;
            int start = i + 1;
            int end = n - 1;
            while (start < end){
                int sum = arr[i] + arr[start] + arr[end];
                if(sum == 0){
                    long left = 1;
                    long right = 1;
                    if(arr[start] == arr[end]){
                        long temp = end - start + 1;
                        count += temp * (temp-1) / 2 ;
                        break;
                    }
                    while (start + 1< end && arr[start] == arr[start+1]){
                        start++;
                        left++;
                    }
                    while (start < end -1 && arr[end] == arr[end-1]){
                        end--;
                        right++;
                    }
                    long temp = left * right;
                    count += temp;
                    start++;
                    end--;
                }
                else if(sum > 0){
                    end--;
                }
                else if(sum < 0){
                    start++;
                }
            }
        }
        System.out.println(count);
    }
}
/*
대회는 정확히 3명으로 구성된 팀만 참가가 가능하다.
코딩 실력이 좋으면 팀워크가 떨어지고, 팀워크가 좋을수록 코딩 실력이 떨어진다.
각각의 코딩 실력 Ai는 -10000부터 10000 사이의 정수로 표시되어 있다
세 팀원의 코딩 실력의 합이 0이 되는 팀을 만들고자 한다.

그녀가 대회에 출전할 수 있는 팀을 얼마나 많이 만들 수 있는지를 계산하여라.
N명의 학생들의 코딩 실력 Ai가 -10000부터 10000사이의 정수로 주어질 때, 합이 0이 되는 3인조를 만들 수 있는 경우의 수를 구하여라.

시간 제한 4초

 */

/* // 시간제한 걸림
반례
10000
0 * 10000개
10000 * 10000 * 10000이라는 시간이 걸림

public class BJ3151 {
    static int [] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        // 서로 index 값들로 2개씩 합치기
        Arrays.sort(arr);
        long count = 0;
        for (int i = n-1; i >=2 ; i--) { // 0 1 2 가 마지막
            for (int j = i-1; j >=1 ; j--) {
                int cur = arr[i] + arr[j];
                count += BinarySearch(0, j-1, cur);
            }
        }
        System.out.println(count);
    }
    public static int BinarySearch(int start, int end, int cur){
        cur = -cur;
        int count = 0;
        while (start <= end){
            int mid = (start + end) / 2;
            if(arr[mid] == cur){
                for (int i = start; i <= end; i++) {
                    if(arr[i] == cur){
                      count++;
                    }
                }
                return count;
            }
            else if(arr[mid] > cur){
                end = mid - 1;
            }
            else if(arr[mid] < cur){
                start = mid + 1;
            }
        }
        return count;
    }
}

 */
