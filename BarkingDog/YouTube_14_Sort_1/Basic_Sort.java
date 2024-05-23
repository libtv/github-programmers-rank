package BarkingDog.YouTube_14_Sort_1;

import java.util.Arrays;

// 기초 정렬 || 선택 정렬
/*
처음 배열이 n개라면 n개에서 가장 큰값을 찾고 큰 값을 배열 n-1번째에 보낸다.
그다음 n-1개에서 가장 큰값을 n-2에 보낸다. 이걸 반복
O(N^2)
 */
public class Basic_Sort {
    public static void main(String[] args) {
        int[] arr = {3,2,7,116,62,235,1,23,55,77};
        int num = arr.length;
        for (int i = 0; i < num; i++) {
            int idx = 0;
            for (int j = num-1-i; j >=0 ; j--) {
                 if(arr[j] > arr[idx]){
                     idx = j;
                 }
            }
            int temp = arr[num-1-i];
            arr[num-1-i] = arr[idx];
            arr[idx] = temp;
        }
        System.out.println(Arrays.toString(arr));

        // Math.max(a,b)활용해보기
        int[] arr2 = {3,2,7,116,62,235,1,23,55,77};
        int num2 = arr2.length;

        for (int i = 0; i < num2; i++) {
            int idx = 0;
            for (int j = num2-1-i; j >=0 ; j--) {
                if(Math.max(arr2[j] , arr2[idx]) == arr2[j]){
                    idx = j;
                }
            }
            int temp = arr2[num-1-i];
            arr2[num-1-i] = arr2[idx];
            arr2[idx] = temp;
        }
        System.out.println(Arrays.toString(arr2));
    }
}
