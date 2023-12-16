package org.example.programmers.level0;

import java.util.ArrayList;
import java.util.Arrays;

// https://school.programmers.co.kr/learn/courses/30/lessons/181918
// 배열 만들기 4
public class CreatingAnArray4 {
    public static void main(String[] args) {
        CreatingAnArray4 creatingAnArray4 = new CreatingAnArray4();
        int [] arr = {1, 4, 2, 5, 3};
        System.out.println(Arrays.toString(creatingAnArray4.solution(arr)));
    }

    public int[] solution(int[] arr) {

        int i = 0;
        ArrayList<Integer> stkList = new ArrayList<>();

        while(arr.length > i){

            if(stkList.size() ==0 ){
                stkList.add(arr[i]);
                i++;
            }
            else if(stkList.size() > 0 && (stkList.get(stkList.size()-1) < arr[i])){
                stkList.add(arr[i]);
                i++;
            }
            else if(stkList.size() > 0 && (stkList.get(stkList.size()-1) >= arr[i])){
                stkList.remove(stkList.size()-1);
            }
        }

        int[] stk = new int[stkList.size()];

        for(int j = 0; j < stkList.size(); j++){
            stk[j] = stkList.get(j);
        }

        return stk;
    }
}
