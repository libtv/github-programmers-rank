package programmers.level2;

import java.util.*;
// 코딩테스트 연습 완전탐색 모음사전
public class CollectionDictionary {
    static int cnt = 1;
    static HashMap<String, Integer> map = new HashMap<>();
    // A == 0 E == 1 I == 2 O == 3 U == 4
    public int solution(String word) {
        init(0, "");

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < word.length(); i++){
            char target = word.charAt(i);
            if(target == 'A') sb.append(0);
            else if(target == 'E') sb.append(1);
            else if(target == 'I') sb.append(2);
            else if(target == 'O') sb.append(3);
            else if(target == 'U') sb.append(4);
        }
        String key = sb.toString();
        return map.get(key);
    }
    public static void init(int depth, String cur){
        if(depth == 5) return;

        for(int i = 0; i < 5; i++){
            String next = cur + Integer.toString(i);
            map.put(next, cnt);
            cnt++;
            init(depth + 1, next);
        }
    }
}
