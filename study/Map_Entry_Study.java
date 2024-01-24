package org.example.study;

import java.util.*;

/*
Map.Entry와 ListIterator Iterator  // ArrayList와 ListIterator Iterator 공부
 */
public class Map_Entry_Study {
    public static void main(String[] args) {

        Map<Integer, Integer> map = new HashMap<>();
        // getOrDefault
        map.put(1, map.getOrDefault(1 ,0) + 1);
        map.put(1, map.getOrDefault(1 ,0) + 1);
        System.out.println(map); // {1=2}
        map.put(2, map.getOrDefault(2 ,0) + 1);
        map.put(2, map.getOrDefault(2 ,0) + 1);
        map.put(3, map.getOrDefault(3 ,0) + 1);
        map.put(4, map.getOrDefault(4 ,0) + 1);
        System.out.println(map); // {1=2, 2=2, 3=1, 4=1}

        // Map.Entry는 Set 형태이다.
        Set<Map.Entry<Integer, Integer>> set = map.entrySet();

        // Map.Entry -> Iterator 형태로 변환
        Iterator<Map.Entry<Integer, Integer>> it = set.iterator();

        // Iterator 출력
        while (it.hasNext()){
            System.out.println(it.next());
        }

        /*
        1=2
        2=2
        3=1
        4=1
         */
        // Iterator는 1회용이다.
        while (it.hasNext()){
            System.out.println(it.next());
        }

        // Iterator 새로 생성
        Iterator<Map.Entry<Integer, Integer>> it2 = set.iterator();
        // Iterator Map.Entry를 통한 key value 분리
        while (it2.hasNext()){
            Map.Entry<Integer, Integer> entry = it2.next();
            System.out.println("key : " + entry.getKey() + " " + "value : " + entry.getValue());
        }
        /*
        key : 1 value : 2
        key : 2 value : 2
        key : 3 value : 1
        key : 4 value : 1
         */

        // Set -> List
        // 1. 생성자 활용하기 or  2. addAll() 메서드 활용하기 list.addAll(set)
        Set<Map.Entry<Integer, Integer>> set2 = map.entrySet();
        ArrayList<Map.Entry<Integer, Integer>> list = new ArrayList<>(set2);
        System.out.println(list); // [1=2, 2=2, 3=1, 4=1]
        for (int i = 0; i < list.size(); i++) {
            System.out.println("key : " + list.get(i).getKey() + " " + "value : " + list.get(i).getValue());
        }
        /*
        key : 1 value : 2
        key : 2 value : 2
        key : 3 value : 1
        key : 4 value : 1
         */
        list.remove(0);
        System.out.println(list); // [2=2, 3=1, 4=1]
        // 기존 map는 변환가 없다.
        System.out.println(map);  // {1=2, 2=2, 3=1, 4=1}

        // ListIterator를 사용하면 기존 map에도 변화가 생긴다.

        ListIterator<Map.Entry<Integer, Integer>> listIterator = list.listIterator();

        // key값 1은 현재 value가 2이다. 3으로 바꾸겠다.
        while (listIterator.hasNext()){
            Map.Entry<Integer, Integer> entry = listIterator.next();
            if(entry.getKey() == 1){
                entry.setValue(3);
            }
        }
        System.out.println(list); // 리스트에서 0번 인덱스를 삭제 했었기 때문에 없다. [2=2, 3=1, 4=1]

        // 다시 추가 한다.
        Map.Entry<Integer, Integer> newEntry = new AbstractMap.SimpleEntry<>(5, 5);
        list.add(newEntry);
        System.out.println(list); // [2=2, 3=1, 4=1, 5=5]
        // map은 그대로 유지

        // 그럼 ListIterator로 기존 map을 변화시키려면 ListIterator를 새로 다시 만든다.
        Set<Map.Entry<Integer, Integer>> set1 = map.entrySet();
        ArrayList<Map.Entry<Integer, Integer>> list1 = new ArrayList<>();
        list1.addAll(set1);
        System.out.println(list1); // [1=2, 2=2, 3=1, 4=1]

        ListIterator<Map.Entry<Integer,Integer>> listIterator1 = list1.listIterator();
        while (listIterator1.hasNext()){
           Map.Entry<Integer, Integer> entry = listIterator1.next();
           if(entry.getKey() == 1){
               entry.setValue(10);
           }
           listIterator1.set(entry);
        }
        System.out.println(map);
        System.out.println(list1);

        ArrayList<Integer> list2 = new ArrayList<>();
        list2.add(100);
        list2.add(101);

        ListIterator<Integer> listIterator2 = list2.listIterator();
        while (listIterator2.hasNext()){
            if(listIterator2.next() == 100){
                listIterator2.set(200);
            }
        }
        System.out.println(list2);
    }
}
