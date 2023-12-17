package org.example.programmers.level0;

import java.util.*;

// https://school.programmers.co.kr/learn/courses/30/lessons/181916
// 주사위 게임 3
public class DiceGame3 {
    public static void main(String[] args) {

    }
    public int solution(int a, int b, int c, int d) {
        HashSet<Integer> set = new HashSet<>();
        set.add(a);
        set.add(b);
        set.add(c);
        set.add(d);
        ArrayList<Integer> list = new ArrayList<>();
        list.add(a);
        list.add(b);
        list.add(c);
        list.add(d);

        Collections.sort(list);

        if (set.size() == 1) {
            return 1111 * a;
        }
        else if (set.size() == 4) {
            return Collections.min(set);
        }
        else if (set.size() == 3){ // 2개는 같고 각각 다른 (1, 1, 2, 3)   (1 , 2,  2, 3) ( 1 2 3 3)
            if(list.get(0) == list.get(1)){
                return list.get(2) * list.get(3);
            }
            else if(list.get(1) == list.get(2)){
                return list.get(0) * list.get(3);
            }
            else{
                return list.get(0) * list.get(1);
            }
        }
        else{  // (3 3 2 2 ) (2 2 3 3 ) (1 1 1 2 ) (1 2 2 2 )

            if(list.get(0) == list.get(1) && list.get(1)!=list.get(2)){
                if(list.get(1)-list.get(2) < 0 ){
                    return (list.get(1)+list.get(2)) * (-(list.get(1)-list.get(2)));
                }
                 return (list.get(1)+list.get(2)) * ((list.get(1)-list.get(2)));
            }
            else{
                if(list.get(0)==list.get(1)){
                    return (10 * list.get(0) + list.get(3)) * (10 * list.get(0) + list.get(3));
                }
                else{
                    return (10 * list.get(1) + list.get(0)) *  (10 * list.get(1) + list.get(0));
                }
            }
        }
    }
}
