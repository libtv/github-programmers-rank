package org.example.BarkingDog.YouTube_14_Sort_1;

import java.lang.reflect.Array;
import java.util.Arrays;

// 머지 솔트
public class Merge_Sort {
    public static void main(String[] args) {
        int [] arr1 = {-9, 1, 6, 8, 12};
        int [] arr2 = {-7, 7, 13, 15};
        int num1 = arr1.length;
        int num2 = arr2.length;

        int [] arr3 = new int[num1+num2];
        int cnt1 = 0;
        int cnt2 = 0;
        int cnt3 = 0;
        for (int i = 0; i < num1 + num2; i++) {
            if(cnt1 <= num1-1 && cnt2 <= num2-1){
                if(arr1[cnt1] < arr2[cnt2]){
                    arr3[cnt3] = arr1[cnt1];
                    cnt3++;
                    cnt1++;
                }
                else{
                    arr3[cnt3] = arr2[cnt2];
                    cnt2++;
                    cnt3++;
                }
            }
            else if(cnt1 <= num1-1 && cnt2 > num2-1){
                arr3[cnt3] = arr1[cnt1];
                cnt1++;
                cnt3++;
            }
            else if(cnt1 > num1-1 && cnt2 <= num2-1){
                arr3[cnt3] = arr2[cnt2];
                cnt2++;
                cnt3++;
            }
        }
        System.out.println(Arrays.toString(arr3));
    }
}

/*
Merge Sort는 재귀적으로 수열을 나눠 정렬한 후 합치는 정렬법이다.
시간 복잡도는 O(NlogN)이다.

Merge Sort를 하기 위해서는 먼저 길이가 N, M인 두 정렬된 리스트를 합쳐서
길이 N+M의 정렬된 리스트를 만드는 방법을 알아야 한다.

-9 1 6 8 12
-7 7 13 15
두 정렬된 배열이 있다.

-9와 -7을 비교하면 -9가 더 작다. 제일 작으니 제일 앞에는 -9가 들어간다.
새로운 배열 -9 삽입 O(1)에 해결

그 다음은 각 리스트에 가장 앞에 있는 원소인 1과 -7을 비교한다.

길이가 N,M인 두 정렬된 리스트를 합치는건 O(N+M)에 수행이 가능하다.

이걸 응용해서 BOJ 11728을 풀어보자.

 */