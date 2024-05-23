package boj.BarkingDog_Collection.BinarySearch;

/**
 * 합이 0인 네 정수 골드2
 * 이분 탐색
 */
import java.util.*;
import java.io.*;
public class BOJ7453 {
    static int size, n;
    static int [] A, B, C, D;
    static int [] a, b;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        size = n * n;
        A = new int[n];
        B = new int[n];
        C = new int[n];
        D = new int[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            A[i] = Integer.parseInt(st.nextToken());
            B[i] = Integer.parseInt(st.nextToken());
            C[i] = Integer.parseInt(st.nextToken());
            D[i] = Integer.parseInt(st.nextToken());
        }
        a = new int[size];
        b = new int[size];
        int a_idx = 0;
        int b_idx = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                a[a_idx++] = A[i] + B[j];
                b[b_idx++] = C[i] + D[j];
            }
        }
        Arrays.sort(a);
        Arrays.sort(b);
        long sum = 0;
        for (int i = 0; i < size; i++) {
            int target = -a[i];
            sum += upper_idx(target) - lower_idx(target);
        }
        System.out.println(sum);
    }
    public static int upper_idx(int target){
        int end = size;
        int start = 0;
        while (start < end){
            int mid = (start + end) / 2;
            if(b[mid] > target){
                end = mid;
            }
            else start = mid + 1;
        }
        return end;
    }
    public static int lower_idx(int target){
        int end = size;
        int start = 0;
        while (start < end){
            int mid = (start + end) / 2;
            if(b[mid] < target){
                start = mid + 1;
            }
            else end = mid;
        }
        return start;
    }
}
