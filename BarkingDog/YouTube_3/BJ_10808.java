package org.example.BarkingDog.YouTube_3;

// https://www.acmicpc.net/problem/10808
// 알파벳 개수

import java.util.*;

public class BJ_10808 {
    public static void main(String[] args) {
        // System.out.println((int)'a'); 97
        // System.out.println((int)'z'); 122
        Scanner sc = new Scanner(System.in);

        String input = sc.next(); // next() 메서드는 공백을 기준으로 한 단어씩 읽어들입니다. 따라서, 공백을 포함하지 않은 문자열만을 읽어들입니다.
        /*
        nextLine() 메서드는 공백을 포함한 한 줄 전체를 읽어들입니다. 따라서, 엔터 키를 입력할 때까지 입력값을 받아들입니다.
        즉, 다음 줄로 넘어가기 전까지의 모든 문자열을 읽어들입니다.
         */
        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 97; i <= 122; i++) {
            map.put((char)i, 0 );
        }

        for (int i = 0; i < input.length() ; i++) {
            char temp = input.charAt(i);
            map.put(temp, map.getOrDefault(temp, 0) + 1 );
        }

        Set<Map.Entry<Character, Integer>> set = map.entrySet();
        // System.out.println(set);

        /*
        Java의 HashMap 클래스는 순서를 보장하지 않습니다. 그러나 entrySet() 메서드를 통해 얻은 Set은 내부적으로 LinkedHashSet을 사용하며, LinkedHashSet은 순서를 보장하는 특성을 가지고 있습니다.
        따라서 map.entrySet()을 통해 얻은 Set은 키(Key)에 해당하는 값이 자동으로 사전순으로 정렬된 상태로 반환됩니다. 이는 내부적으로 LinkedHashSet이 순서를 유지하기 때문입니다.
         */

        Iterator<Map.Entry<Character, Integer>> it = set.iterator();

        StringBuilder sb = new StringBuilder();

        while(it.hasNext()){
            Map.Entry<Character, Integer> entry = it.next();
            sb.append(entry.getValue());
            sb.append(" ");
        }
        System.out.println(sb);
    }
}
