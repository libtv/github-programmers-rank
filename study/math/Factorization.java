package study.math;

import java.util.ArrayList;

// 소인수 분해
public class Factorization {
    public static void main(String[] args) {
        int target = 999;
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 2; i * i <= target; i++) {
            while (target % i == 0){
                list.add(i);
                target /= i;
            }
        }
        if(target != 1) list.add(target);
        System.out.println(list);
    }
}
