package org.example.BarkingDog.YouTube_4_Linked_List;

import java.util.*;

// https://www.acmicpc.net/problem/1158
// 요세푸스 문제
public class BJ1158 {

    // 1 2 3 4 5 6 7 ppp d ppp d [ 1 2 4 5 7] list.size() - 1 nextIndex 4
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();

        List<Integer> list = new LinkedList<>();
        for (int i = 1; i <= N ; i++) {
            list.add(i);
        }
        ListIterator<Integer> iterator = list.listIterator();

        List<Integer> answer = new ArrayList<>();
        while (list.size()!=0){
            for(int i = 0; i < K-1 ; i++) {
                if(iterator.hasNext()){
                    iterator.next();
                }
                else{
                    iterator = list.listIterator();
                    iterator.next();
                }
            }
            if(iterator.hasNext()){
                answer.add(iterator.next());
                iterator.remove();
            }
            else{
                iterator = list.listIterator();
                answer.add(iterator.next());
                iterator.remove();
            }
            if(list.size()==1){
                answer.add(list.get(0));
                break;
            }
        }
        int stop = answer.get(answer.size()-1);

        System.out.print("<");
        for (int target : answer) {
            if(target != stop){
                System.out.printf(target + "," + " ");
            }
            else{
                System.out.print(target);
            }
        }
        System.out.print(">");

    }
}


