package org.example.programmers.level0;

import java.util.ArrayList;
import java.util.Arrays;

// https://school.programmers.co.kr/learn/courses/30/lessons/181921
// 배열 만들기 2
public class CreatingAnArray2 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(5	,555	)));
    }
    public static int[] solution(int l, int r) {

        ArrayList<Integer> list = new ArrayList<>();

        for(int i=l; i<=r; i++){

            boolean flag = true;
            String test = Integer.toString(i);

            for(int y = 0; y < test.length(); y++){
                if(test.charAt(y)!='5' && test.charAt(y)!='0'){
                    flag = false;
                }
            }
            if(flag){
                list.add(i);
            }
        }
        if(list.size()==0){
            int[] answer = {-1};
            return answer;
        }
        else {
            int [] answer = new int[list.size()];
            for(int i = 0; i < list.size(); i++){
                answer[i] = list.get(i);
            }
            return answer;
        }

    }
}
