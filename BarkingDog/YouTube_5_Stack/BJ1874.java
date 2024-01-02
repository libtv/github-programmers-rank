package org.example.BarkingDog.YouTube_5_Stack;

import java.util.*;

// https://www.acmicpc.net/problem/1874
// 스택 수열
public class BJ1874 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        Stack<Integer> stack = new Stack<>();
        Queue<Integer> queue = new LinkedList<>();
        ArrayList<Character> answer = new ArrayList<>();
        for (int i = 0; i < N ; i++) {
            queue.offer(sc.nextInt());
        }
        for (int i = 1; i <= N; i++) {
            stack.push(i);
            answer.add('+');
            while(!stack.isEmpty() && !queue.isEmpty() && (int)queue.peek() == (int)stack.peek()){
                stack.pop();
                queue.poll();
                answer.add('-');
            }
        }
        if(stack.isEmpty()){
           for(char target : answer ){
               System.out.println(target);
           }
        }
        else{
            System.out.println("NO");
        }
    }
}
//  Integer끼리의 비교 연산의 경우 ~128~127 의 범위에서만 int의 ==연산과 같은 결과를 기대할 수 있습니다.
/*
자바에서는 -128부터 127까지의 정수 값에 대해서는 객체를 새로 생성하지 않고 이미 생성된 객체를 재사용합니다.
이 범위 내의 값들은 자주 사용되기 때문에 메모리를 절약하기 위해 이러한 최적화가 이루어집니다. 이 범위를 "캐시된 정수" 라고 부릅니다.

따라서 -128부터 127까지의 정수를 나타내는 Integer 객체들은 동일한 객체로 취급됩니다.
이는 == 연산자로 두 Integer 객체를 비교할 때 객체의 참조(주소)를 비교하게 되어 같은 값을 가진 경우에는 true를 반환합니다.

그 이외의 값에 대해서는 새로운 객체가 생성되기 때문에 ==로 비교하면 참조 값이 달라 false를 반환합니다.
따라서 -128부터 127까지의 값에 대한 Integer 비교에서는 equals() 메서드나 compareTo() 메서드를 사용하는 것이 좋습니다.
 */