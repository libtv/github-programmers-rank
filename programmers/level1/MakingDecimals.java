package programmers.level1;

import java.util.ArrayList;

// https://school.programmers.co.kr/learn/courses/30/lessons/12977
// 소수 만들기
public class MakingDecimals {
    public static void main(String[] args) {

    }
    public int solution(int[] nums) { // 조합의수
        int cnt = 0;
        for(int i = 0; i < nums.length; i++){
            for(int j = i+1; j < nums.length; j++){
                for(int k = j+1; k < nums.length; k++){
                    if(find(nums[i]+nums[j]+nums[k])){
                        cnt++;
                    }
                }
            }
        }
        return cnt;
    }
    public static boolean find(int sum){
        boolean flag = false;
        for(int i = 2; i <= Math.sqrt(sum); i++){
            if(sum%i==0){
                flag = true;
                break;
            }
        }
        if(flag){
            return false;
        }
        return true;
    }

}

