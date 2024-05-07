package boj.BarkingDog_Collection.BinarySearch;

// 수 찾기 실버4
import java.util.*;
import java.io.*;
public class BOJ1920 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int [] A = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(A);

        int t = Integer.parseInt(br.readLine());
        int [] array = new int[t];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < t; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < t; i++) {
            int target = array[i];
            int start = 0;
            int end   = n - 1;
            int input = 0;
            while (start <= end){
                int mid = (start + end) / 2;
                if(A[mid] == target){
                    input = 1;
                    break;
                }
                else if(A[mid] < target){
                    start = mid + 1;
                }
                else end = mid - 1;
            }
            sb.append(input).append("\n");
        }
        System.out.println(sb);
    }
}
