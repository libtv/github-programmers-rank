package BarkingDog.YouTube_1;

// 시간 복잡도 공부

// 주어진 길이 N인 int 배열 arr에서 합이 100인 서로 다른 위치의 두 원소가 존재하면 1을,
// 존재하지 않으면 0을 반환하는 메서드를 작성해라 arr의 각 수는 0이상 100이하이고 N은 1000 이하이다.

/*
입력: {1, 52, 48} , 3 출력: 1
입력: {50, 42} , 2 출력: 0
입력: {4, 13, 63, 87} , 4 출력: 1
 */

import java.util.*;
public class Sum100 {
    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);
        int N = sc.nextInt();

        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < N ; i++) { // 입력값들 list에 저장
            list.add(sc.nextInt());
        }
        int cnt = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < list.size() ; i++) {
            int temp = list.get(i);
            map.put(100-temp, temp);
        }
        for (int i = 0; i < list.size() ; i++) {
            int check = list.get(i);
            if(map.containsKey(check)){
                cnt++;
            }
        }
        System.out.println(cnt/2);
    }
}
/* 시간복잡도는 N제곱이다.
public class Sum100 {
    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);
        int N = sc.nextInt();

        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < N ; i++) { // 입력값들 list에 저장
            list.add(sc.nextInt());
        }
        int cnt = 0;
        for (int i = 0; i < list.size() ; i++) {
            for (int j = i+1; j < list.size(); j++) {
                if(list.get(i)+list.get(j) == 100){
                    cnt++;
                }
            }
        }
        System.out.println(cnt);
    }
}
 */
