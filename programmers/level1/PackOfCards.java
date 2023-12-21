package org.example.programmers.level1;

// https://school.programmers.co.kr/learn/courses/30/lessons/159994
// 카드 뭉치
public class PackOfCards {
    public static void main(String[] args) {

    }
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        String result = "Yes";

        int cardsIndex1 = 0;
        int cardsIndex2 = 0;

        for(int i = 0; i < goal.length; i++){
            String target = goal[i];
            if( cardsIndex1 < cards1.length && cards1[cardsIndex1].equals(target)){
                cardsIndex1++;

            }
            else if(cardsIndex2 < cards2.length && cards2[cardsIndex2].equals(target)){
                cardsIndex2++;
            }
            else{
                result = "No";
                break;
            }
        }
        return result;

    }
}
