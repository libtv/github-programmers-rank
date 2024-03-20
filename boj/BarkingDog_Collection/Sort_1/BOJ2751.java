package boj.BarkingDog_Collection.Sort_1;

// 수 정렬하기2 실버5
import java.io.*;
public class BOJ2751 {
    static int n; static int [] arr; static int [] temp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        temp = new int[n];
        for (int i = 0; i < n ; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        func(0, n);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(arr[i]).append("\n");
        }
        System.out.println(sb);
    }
    public static void func(int start, int end){
        if(end - start == 1) return;
        int mid = (start + end ) / 2;
        func(start, mid);
        func(mid, end);
        func2(start, end);
    }
    public static  void func2(int start, int end){
        int mid = (start + end) / 2;
        int idx1 = start;
        int idx2 = mid;
        for (int i = start; i < end; i++) {
            if(idx1 == mid) temp[i] = arr[idx2++];
            else if(idx2 == end) temp[i] = arr[idx1++];
            else{
                if(arr[idx1] <= arr[idx2]) temp[i] = arr[idx1++];
                else temp[i] = arr[idx2++];
            }
        }
        for (int j = start; j < end; j++) {
            arr[j] = temp[j];
        }
    }
}
