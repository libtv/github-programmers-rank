package programmers.level1;

import java.util.ArrayList;

// https://school.programmers.co.kr/learn/courses/30/lessons/161989
// 덧칠하기
public class ApplyMorePaint {
    public static void main(String[] args) {

    }
    public int solution(int n, int m, int[] section) {
        int cnt = 0; // 페인트

        ArrayList<Integer> list = new ArrayList<>();

        for(int i = 0; i < section.length; i++){
            list.add(section[i]);
        }
        // System.out.println(list);
        while(list.size() > 0){
            int start = list.get(0);
            for(int i= start; i < start + m ;i++){
                if(list.contains(i)){
                    int index = list.indexOf(i);
                    list.remove(index);
                }
            }
            cnt++;
        }

        return cnt;
    }

}
