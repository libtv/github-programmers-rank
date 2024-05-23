package programmers.level1;

import java.util.ArrayList;
import java.util.Collections;

// https://school.programmers.co.kr/learn/courses/30/lessons/86491
// 완전탐색 // 최소직사각형
public class MinimumRectangle {
    public static void main(String[] args) {

    }
    public int solution(int[][] sizes) {
        // [[60, 50], [30, 70], [60, 30], [80, 40]]  = 80 * 50 = 4000
        // [[10, 7], [12, 3], [8, 15], [14, 7], [5, 15]] =  8 * 15 = 120

        // 1. 가로랑 세로중에 큰 것을 찾는다.
        // 2. 만약 가로가 더 크면 세로 min을 찾는다 / 세로가 더 크면 가로 min을 찾는다.
        // how?

        ArrayList<Integer> widthList = new ArrayList<>();
        ArrayList<Integer> lengthList = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();

        for(int i = 0; i < sizes.length; i++){
            int width = sizes[i][0];
            int length = sizes[i][1];
            widthList.add(width);
            lengthList.add(length);
            list.add(width);
            list.add(length);
        }
        int widthMax = Collections.max(widthList);
        int lengthMax = Collections.max(lengthList);

        ArrayList<Integer> compare = new ArrayList<>();

        if(widthMax > lengthMax){
            System.out.println(widthMax);
            for(int i =0; i < list.size(); i= i+2){ // 0 2 4 6
                if(list.get(i) < list.get(i+1)){
                    compare.add(list.get(i));
                }
                else{
                    compare.add(list.get(i+1));
                }
            }
            return widthMax * Collections.max(compare);
        }
        else{
            System.out.println(lengthMax);
            for(int i =0; i < list.size(); i= i+2){ // 0 2 4 6
                if(list.get(i) > list.get(i+1)){
                    compare.add(list.get(i+1));
                }
                else{
                    compare.add(list.get(i));
                }
            }
            return lengthMax * Collections.max(compare);
        }
    }
}
/* 어떻게 했노..
 public int solution(int[][] sizes) {
        int length = 0, height = 0;
        for (int[] card : sizes) {
            length = Math.max(length, Math.max(card[0], card[1]));
            height = Math.max(height, Math.min(card[0], card[1]));
        }
        int answer = length * height;
        return answer;
    }
 */