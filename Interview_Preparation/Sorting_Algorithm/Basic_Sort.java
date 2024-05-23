package Interview_Preparation.Sorting_Algorithm;

import java.util.Arrays;
// 기초 정렬 (선택 정렬)
public class Basic_Sort {
    public static void main(String[] args) {
        int [] arr = {3, 2, 7, 116, 62, 235, 1, 23, 55, 77};
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            int idx = i;
            for (int j = i + 1; j < n; j++) {
                if(arr[j] < arr[idx]) idx = j;
            }
            int temp = arr[i];
            arr[i] = arr[idx];
            arr[idx] = temp;
        }
        System.out.println(Arrays.toString(arr));
    }
}
