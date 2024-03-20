package Interview_Preparation.Sorting_Algorithm;

// Merge_Sort 병합 정렬 O(NlogN)
import java.util.*;
public class Merge_Sort {
    static int [] arr = {-3, -1, 4, -5, 7, 5, 3, 0, 2, 9, 8};
    static int [] tmp = new int[arr.length];

    public static void main(String[] args) {
        func(0, arr.length);
        System.out.println(Arrays.toString(arr));
    }
    public static void func(int start, int end){
        if(end - start == 1){
            return;
        }
        int mid = (start + end) / 2;
        func(start, mid);
        func2(start, end);
    }
    public static void func2(int start, int end){
        int mid = (start + end) / 2;
        int idx1 = start;
        int idx2 = mid;
        for (int i = start; i < end; i++) {
            if(idx1 == mid){
                tmp[i] = arr[idx2++];
            }
            else if(idx2 == end){
                tmp[i] = arr[idx1++];
            }
            else{
                if(arr[idx1] <= arr[idx2]){
                    tmp[i] = arr[idx1++];
                }
                else{
                    tmp[i] = arr[idx2++];
                }
            }
        }
        for (int i = start; i < end; i++) {
            arr[i] = tmp[i];
        }
    }
}
