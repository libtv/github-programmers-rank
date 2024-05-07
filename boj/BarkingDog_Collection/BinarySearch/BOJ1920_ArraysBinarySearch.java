package boj.BarkingDog_Collection.BinarySearch;

// 수 찾기 실버4
import java.util.*;
import java.io.*;
public class BOJ1920_ArraysBinarySearch {
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
        for (int i = 0; i < t ; i++) {
            int target = array[i];
            int index = Arrays.binarySearch(A, target);
            if(index >= 0) sb.append(1);
            else sb.append(0);
            sb.append("\n");
        }
        System.out.println(sb);

    }
}
