package org.example.study;

import java.util.Arrays;
import java.util.Comparator;

// Comparator와 Comparable 공부
public class ComparatorAndComparable {
    public static void main(String[] args) {
        String [] arr1 = {"b", "a"};
        Arrays.sort(arr1, new ComparatorTest()); // 사전 순서 반대로
        System.out.println(Arrays.toString(arr1)); // [b, a]
    }
}
 class ComparatorTest implements Comparator<String> {
   public int compare(String s1, String s2){
       return s2.compareTo(s1); // 사전 역순으로 비교
       // return s1.compareTo(s2) * (-1)
   }
}

/*
Comparable: Comparable은 자바에서 기본적으로 제공되는 인터페이스로, 객체의 기본 정렬 기준을 정의하는 데 사용됩니다.
Comparable 인터페이스를 구현한 클래스의 인스턴스들은 "자연적인 순서(natural order)"에 따라 정렬될 수 있습니다.
Comparable 인터페이스는 compareTo() 메서드를 포함하고 있으며, 이 메서드를 구현하여 객체 간의 비교 로직을 정의합니다.
예를 들어, String 클래스는 Comparable 인터페이스를 구현하고 있어서 문자열을 기본적으로 사전식 순서로 정렬할 수 있습니다.
다른 예로, 사용자가 직접 정의한 Person 클래스가 Comparable 인터페이스를 구현한다면, 해당 클래스의 인스턴스들을 정렬할 때 compareTo() 메서드의 구현에 따라 정렬 순서를 지정할 수 있습니다.

Comparator: Comparator는 정렬 기준을 별도로 지정하고 싶을 때 사용되는 인터페이스입니다.
Comparable 인터페이스와는 달리, Comparator는 객체 간의 비교 로직을 외부에서 제공하는 방식으로 정렬을 수행합니다.
Comparator 인터페이스는 compare() 메서드를 포함하고 있으며, 이 메서드를 구현하여 비교 로직을 정의합니다.
 */