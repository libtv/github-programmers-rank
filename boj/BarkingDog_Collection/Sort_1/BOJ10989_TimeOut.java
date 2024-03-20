package boj.BarkingDog_Collection.Sort_1;

// 수 정렬하기 3 브론즈1
import java.io.*;
public class BOJ10989_TimeOut {
    static int [] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr = new int[n];
        for (int i = 0; i < n ; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        QuickSort(0, n - 1);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n ; i++) {
            sb.append(arr[i]).append("\n");
        }
        System.out.println(sb);
    }
    public static void QuickSort(int low, int high){
        if(low < high){
            int pivot_idx = func(low, high);
            QuickSort(low, pivot_idx - 1);
            QuickSort(pivot_idx + 1, high);
        }
    }
    public static int func(int low, int high){
        int pivot = arr[low];
        int l = low + 1;
        int r = high;
        while (l <= r){
            while (l <= r && pivot > arr[l]) l++;
            while (l <= r && pivot <= arr[r]) r--;
            if(l < r){
                swap(l ,r);
            }
        }
        swap(low, r);
        return r;
    }
    public static void swap(int l , int r){
        int temp = arr[r];
        arr[r] = arr[l];
        arr[l] = temp;
    }
}
