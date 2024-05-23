package boj.BarkingDog_Collection.DP;

import java.util.*;
// 제곱수의 합 실버2
public class BOJ1699 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 1 <= n <= 100000
        int start = 1;
        ArrayList<Integer> list = new ArrayList<>();
        while (Math.pow(start, 2) <= n){
            list.add((int)Math.pow(start, 2));
            start++;
        }
        int [] arr = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            arr[i] = list.get(i);
        }
        int [] DP = new int[n+1];
        Arrays.fill(DP, Integer.MAX_VALUE / 2);
        DP[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < list.size(); j++) {
                if(i == list.get(j)){
                    DP[i] = 1;
                    break;
                }
                if(i - list.get(j) < 1){
                    break;
                }
                DP[i] = Math.min(DP[i], DP[i - list.get(j)] + 1);
            }
        }
        System.out.println(DP[n]);
    }
}
