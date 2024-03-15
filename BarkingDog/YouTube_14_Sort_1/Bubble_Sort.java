package BarkingDog.YouTube_14_Sort_1;

import java.lang.reflect.Array;
import java.util.Arrays;

// 버블 정렬
/*
앞에서 부터 인접한 두 원소를
앞의 원소가 뒤의 원소보다 클 경우 자리를 바꾸는 것을 반복하면 제일 큰 것 부터 오른쪽으로 쌓인다.
O(N^2)
 */
public class Bubble_Sort {
    public static void main(String[] args) {
        int[] arr = {2, 13, 6, 4, -2};
        int num = arr.length;
        for (int i = 0; i < num ; i++) {
            for (int j = 0; j < num - i - 1; j++) {
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(arr));

    }
}

/*
2 13 6 4 -2 를 원소로 가지는 배열이 있다.


2 - 13 그대로
13  6 -> 2 6 13 4 -2
13  4 -> 2 6 4 13 -2
13 -2 -> 2 6 4 -2 13

이걸 반복

 */