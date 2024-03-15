package programmers.level1;

// https://school.programmers.co.kr/learn/courses/30/lessons/12948
// 핸드폰 번호 가리기
public class HideYourCellPhoneNumber {
    public static void main(String[] args) {

    }
    public String solution(String phone_number) {

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < phone_number.length()-4; i++){
            sb.append("*");
        }
        StringBuilder sb2 = new StringBuilder();

        for(int i = phone_number.length()-1; i > phone_number.length()-5; i--){
            sb2.append(phone_number.charAt(i));
        }

        String temp = sb2.reverse().toString();
        sb.append(temp);
        return sb.toString();
    }

}
