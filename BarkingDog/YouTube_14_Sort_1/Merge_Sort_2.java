package BarkingDog.YouTube_14_Sort_1;

import java.util.Arrays;

// Merge_Sort에서 짠 방식은 0(N+M) 시간복잡도이다. 2번만 연산 했으니
// 이걸 1개리스트에서 시작해서 나누고 나누고 나누고 해서 합치고 합치고 합치고 하는 방식으로 하면 O(NlongN)으로 해결 가능하다.
/*
Stable_Sort
검은 파랑 빨강 초록
38 21 21 21
이렇게 동일한 우선 순위의 요소가 있을 때는 정렬한 결과가 유일하지 않을 수 있다.
우선순위가 같은 원소들끼리는 원래의 순서를 따라가도록 하는 정렬이 Stable Sort이다.

Merge_Sort는 자연스럽게 Stable 처리 되어 있다.

 */
public class Merge_Sort_2 {
    static int [] arr = {-3, -1, 4, -5, 7, 5, 3, 0, 2, 9, 8};
    static int [] tmp = new int[arr.length];
    public static void main(String[] args) {
        func(0, arr.length);
        System.out.println(Arrays.toString(arr));
    }
    public static void func(int sx, int ex){ // 나누기
        if(ex - sx == 1){
            return;
        }
        int mx = (ex + sx) / 2;
        func(sx, mx);
        func(mx ,ex);
        func2(sx , ex);
    }
    public static void func2(int sx, int ex){ // 합치기
        int mx = (sx + ex) / 2;
        int cnt1 = sx;
        int cnt2 = mx;
        for (int i = sx; i < ex; i++) { // 0  2
            if(cnt2 == ex){
                tmp[i] = arr[cnt1];
                cnt1++;
            }
            else if(cnt1 == mx){
                tmp[i] = arr[cnt2];
                cnt2++;
            }
            else{
                if(arr[cnt2] < arr[cnt1]){
                    tmp[i] = arr[cnt2];
                    cnt2++;
                }
                else{
                    tmp[i] = arr[cnt1];
                    cnt1++;
                }
            }
        }
        for (int i = sx; i < ex ; i++) {
            arr[i] = tmp[i];
        }
    }
}

// 0 1 2 3 4 의 5크기의 배열이 있다.
// sx = 0 ex = 5

