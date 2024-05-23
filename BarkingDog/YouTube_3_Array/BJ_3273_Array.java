package BarkingDog.YouTube_3_Array;

import java.util.ArrayList;
import java.util.Scanner;

// https://www.acmicpc.net/problem/3273
// 두 수의 합
// 실버 3
public class BJ_3273_Array {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < n ; i++) {
            list.add(sc.nextInt());
        }
        int sum = sc.nextInt();
        boolean [] visited = new boolean[10000000+1];

        for (int target : list) {
            visited[target] = true;
        }
        int cnt = 0;
        for (int i = 0; i < list.size(); i++) {
            int temp = list.get(i);
            if (temp > sum) {
                continue;
            }
            if (visited[temp] && visited[sum - temp]) {
                cnt++;
            }
        }

        System.out.println(cnt/2);
    }
}
