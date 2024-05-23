package Interview_Preparation.Sorting_Algorithm;

import java.util.Arrays;
// Quick Sort 구현하기
public class Quick_Sort {
    static  int[] arr = {6, -8, 1, 12, 8, 3, 7, -7};
    public static void main(String[] args) {
        int n = arr.length;
        QuickSort(0, n - 1);
        System.out.println(Arrays.toString(arr));
    }
    public static void QuickSort(int low, int high){
        if(low < high){
            int pivot_index = func(low, high);
            QuickSort(low, pivot_index - 1);
            QuickSort(pivot_index + 1, high);
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
                swap(l, r);
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

