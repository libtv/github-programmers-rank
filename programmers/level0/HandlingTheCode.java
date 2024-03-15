package programmers.level0;

// https://school.programmers.co.kr/learn/courses/30/lessons/181932
// 코드 처리하기

public class HandlingTheCode {
    public static void main(String[] args) {

    }

    public String solution(String code) {

        StringBuilder ret = new StringBuilder();

        int mode = 0;

        for(int i = 0; i < code.length(); i++){

            if(mode == 0){
                if(code.charAt(i) != '1'){
                    if(i%2==0){
                        ret.append(code.charAt(i));
                    }
                }
                else{
                    mode = 1;
                }
            }
            else{ // mode == 1
                if(code.charAt(i) != '1'){
                    if(i%2==1){
                        ret.append(code.charAt(i));
                    }
                }
                else{
                    mode = 0;
                }
            }
        }
        if(ret.toString().length()==0){
            return "EMPTY";
        }
        return ret.toString();
    }

}
