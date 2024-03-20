package Interview_Preparation.Sorting_Algorithm;

// 버블 정렬
import java.util.*;
public class Bubble_Sort {
    public static void main(String[] args) {
        int [] arr = {3, 2, 7, 116, 62, 235, 1, 23, 55, 77};
        int size = arr.length;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size - 1; j++) {
                if(arr[j] > arr[j+1]){
                    int temp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
