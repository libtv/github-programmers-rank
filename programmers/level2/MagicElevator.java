package programmers.level2;

// https://school.programmers.co.kr/learn/courses/30/lessons/148653
// 프로그래머스 level 2 마법의 엘리베이터
public class MagicElevator {
    public int solution(int storey) {
        int answer = 0;

        String temp = Integer.toString(storey);
        int [] arr = new int [temp.length() + 1];
        for(int i = 1; i <= temp.length(); i++){
            arr[i] = temp.charAt(i-1) - '0';
        }
        for(int i = temp.length(); i >=1; i--){
            int check = arr[i];
            if(check == 0){
                continue;
            }
            if(check <= 4){
                arr[i] = 0;
                answer += check;
            }
            else if(check == 5){
                if(arr[i - 1] >= 5){
                    arr[i - 1] += 1;
                }
                answer += 5;
            }
            else if( 6 <= check && check <= 9){
                arr[i] = 0;
                answer += (10 - check);
                arr[i - 1] += 1;
            }
            else{
                arr[i - 1] += 1;
            }
        }
        return answer += arr[0];
    }
}
