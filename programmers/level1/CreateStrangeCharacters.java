package org.example.programmers.level1;

// https://school.programmers.co.kr/learn/courses/30/lessons/12930
// 이상한 문자 만들기
public class CreateStrangeCharacters {
    public static void main(String[] args) {

    }
    public String solution(String s) { // 공백이 >=1 을 고려한 solution
        StringBuilder sb = new StringBuilder();
        int index = 0;
        for(int i = 0; i < s.length(); i++){
            int temp = (int)s.charAt(i);
            if((65<=temp && temp<=90)|| (97<=temp && temp<=122)){
                char a;
                if(index%2==0){ // 대문자
                    a = Character.toUpperCase(s.charAt(i));
                }
                else{ // 소문자
                    a = Character.toLowerCase(s.charAt(i));
                }
                sb.append(a);
                index++;
            }
            else{
                sb.append(" ");
                index = 0;
            }
        }
        return sb.toString();
    }

}
/* 공백이 하나... 문제 조건은 공백이 하나 이상..
public String solution(String s) {
        StringBuilder sb = new StringBuilder();

        String[] arr = s.split(" ");
        // System.out.println(Arrays.toString(arr));
        for(String target : arr){
            String temp = "";
            for(int i = 0; i < target.length(); i++){
                char a;
                if(i%2==0){
                    a =Character.toUpperCase(target.charAt(i));
                }
                else {
                    a =Character.toLowerCase(target.charAt(i));
                }

                temp += Character.toString(a);

            }
            temp += " ";
            sb.append(temp);
        }
        return sb.substring(0, sb.length()-1).toString();

    }
 */