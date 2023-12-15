package org.example.boj.greedy;

// https://www.acmicpc.net/problem/11501
// 주식

import java.util.*;
public class BJ11501 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int i = 0; i < T; i++) {
            int N = sc.nextInt();
            ArrayList<Integer> stock = new ArrayList<>();
            for (int j = 0; j < N; j++) {
                stock.add(sc.nextInt());
            }
            System.out.println(benefit(stock));
            stock.clear();
        }
    }

    public static long benefit(ArrayList<Integer> stock) {
        long profit = 0;
        int max = 0;
        for (int i = stock.size() - 1; i >= 0; i--) {
            if (stock.get(i) > max) {
                max = stock.get(i);
            } else {
                profit += max - stock.get(i);
            }
        }
        return profit;
    }
}
