package study.math;

import java.util.ArrayList;
import java.util.Collections;

// 약수
public class Divisor {
    public static void main(String[] args) {

        int target = 18;
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 1; i * i <= target; i++) {
            if(target % i != 0) continue;
            int temp = target / i;
            if(temp != i){
                list.add(temp);
                list.add(i);
            }
            else list.add(i);
        }
        Collections.sort(list);
        System.out.println(list);

        list.clear();
        target = 16;
        for (int i = 1; i * i <= target; i++) {
            if(target % i != 0) continue;
            int temp = target / i;
            if(temp != i){
                list.add(temp);
                list.add(i);
            }
            else list.add(i);
        }
        Collections.sort(list);
        System.out.println(list);
    }
}
