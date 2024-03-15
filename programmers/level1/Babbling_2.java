package programmers.level1;

import java.util.ArrayList;

// https://school.programmers.co.kr/learn/courses/30/lessons/133499
// 옹알이 (2)
public class Babbling_2 {
    static ArrayList<String> list = new ArrayList<>();

    static int result = 0;

    public static void main(String[] args) {

    }

    public static int solution(String[] babbling) {
        list.add("aya");
        list.add("ye");
        list.add("woo");
        list.add("ma");
        for (int i = 0; i < babbling.length ; i++) {
            String str = babbling[i];
            int babblingLength = babbling[i].length();
            for (int j = 0; j < 4 ; j++) {
                String strCheck = list.get(j) + list.get(j);
                if(str.contains(strCheck)){
                    break;
                }
                babblingLength = babblingLength - test(str, j);
            }
            if(babblingLength==0){
                result++;
            }
        }
        return result;

    }

    public static int test(String str , int cnt){
        int returnInt = 0;
        int length = list.get(cnt).length();
        while(str.contains(list.get(cnt))){
            int check = str.indexOf(list.get(cnt));
            str = str.substring(0, check) + str.substring(check+ length);
            returnInt ++;
        }
        return returnInt * length;
    }


}