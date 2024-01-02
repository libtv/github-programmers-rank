package org.example.study;

import java.util.*;
/*
Iterator와 ListIterator의 차이:

단방향 vs 양방향:

Iterator는 단방향 순회만을 지원합니다. 순방향으로만 이동 가능합니다.
ListIterator는 양방향 순회를 지원합니다. 순방향 및 역방향으로 이동이 가능합니다.
인덱스 접근:

Iterator는 현재 위치의 인덱스를 직접 얻거나 설정할 수 있는 메서드가 없습니다.
ListIterator는 previousIndex()와 nextIndex() 메서드를 통해 현재 위치의 인덱스를 얻을 수 있습니다.
요소 수정 및 추가:

Iterator는 현재 위치의 요소를 수정하거나 추가하는 기능이 없습니다.
ListIterator는 현재 위치의 요소를 수정하거나 추가할 수 있는 set() 및 add() 메서드를 제공합니다.
 */
public class ListIteratorStudy {
    public static void main(String[] args) {
        List<String> myList = new ArrayList<>();
        myList.add("Apple");
        myList.add("Banana");
        myList.add("Orange");

        ListIterator<String> listIterator = myList.listIterator();

        // 순방향으로 이동하면서 출력
        while (listIterator.hasNext()) {
            String fruit = listIterator.next();
            System.out.println("Forward: " + fruit);
        }

        // 인덱스 확인
        int nextIndex = listIterator.nextIndex();
        System.out.println("Next Index: " + nextIndex);

        // 역방향으로 이동하면서 출력
        while (listIterator.hasPrevious()) {
            String fruit = listIterator.previous();
            System.out.println("Backward: " + fruit);
        }

        // 현재 위치의 요소 수정
        listIterator.next();
        listIterator.set("Mango");

        // 현재 위치에 새로운 요소 추가
        listIterator.add("Grapes");

        // 리스트 출력
        System.out.println("Updated list:");
        for (String fruit : myList) {
            System.out.println(fruit);
        }
    }
}
/* 메서드들
순방향 이동:
boolean hasNext(): 다음 요소가 있으면 true를 반환합니다.
Object next(): 다음 요소를 반환하고, 다음 위치로 이동합니다.
역방향 이동:

boolean hasPrevious(): 이전 요소가 있으면 true를 반환합니다.
Object previous(): 이전 요소를 반환하고, 이전 위치로 이동합니다.
인덱스 반환:

int nextIndex(): 다음 요소의 인덱스를 반환합니다.
int previousIndex(): 이전 요소의 인덱스를 반환합니다.
요소 추가 및 수정:

void add(E e): 현재 위치에 새로운 요소를 추가합니다.
void set(E e): 현재 위치의 요소를 지정한 요소로 대체합니다.
요소 삭제:

void remove(): 현재 위치의 요소를 삭제합니다.

 */