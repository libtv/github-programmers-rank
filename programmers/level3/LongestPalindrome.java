package programmers.level3;

// 가장 긴 팰린드롬
public class LongestPalindrome {
    /**
     * 정확성: 72.1
     * 효율성: 27.9
     * 합계: 100.0 / 100.0
     */
    public int solution(String s){
        int answer = 0;
        int size = s.length();
        char [] input = new char[size];

        for(int i = 0; i < size; i++){
            input[i] = s.charAt(i);
        }

        boolean [][] pa = new boolean [size][size];
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                int target = j + i;
                if(target > size - 1) break;
                if(input[j] != input[target]) continue;
                if(i <= 1){
                    pa[j][target] = true;
                    if(target - j + 1 > answer){
                        answer = target - j + 1;
                    }
                    continue;
                }
                if(pa[j+1][target-1]){
                    pa[j][target] = true;
                    if(target - j + 1 > answer){
                        answer = target - j + 1;
                    }
                }
            }
        }
        return answer;
    }
}
