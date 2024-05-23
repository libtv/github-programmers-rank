package BarkingDog.YouTube_3_Array;

import java.util.*;

// https://www.acmicpc.net/problem/3273
// 두 수의 합
// 실버 3
public class BJ_3273_HashSet {
    public static void main(String[] args) {
        // list에서 contains로 요소를 찾는 방법은 O(N)이 걸린다. 하지만 Set에서 Contains는 O(1)이라는 시간만 걸린다를 이용
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < n ; i++) {
            list.add(sc.nextInt());
        }
        int sum = sc.nextInt();

        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n ; i++) {
            set.add(sum-list.get(i));
        }
        int cnt = 0;
        for (int i = 0; i < n ; i++) {
            if(set.contains(list.get(i))){
                cnt++;
            }
        }
        System.out.println(cnt/2);
    }
}
// 112436 KB 956 ms