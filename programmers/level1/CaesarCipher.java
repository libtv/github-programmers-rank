package org.example.programmers.level1;

// https://school.programmers.co.kr/learn/courses/30/lessons/12926
// 시저 암호
public class CaesarCipher {
    public static void main(String[] args) {

    }
    public String solution(String s, int n) {

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); i++){
            if(!(s.charAt(i) == ' ')){
                sb.append(change(s.charAt(i) , n));
            }
            else{
                sb.append(" ");
            }
        }
        // System.out.println((int)'z'- 25); // 'a'=97 'z'=122 'A'=65 'Z'=90

        return sb.toString();

    }
    public char change(char ch , int n){
        if(Character.isUpperCase(ch)){ // 대문자냐?
            int check = (int)ch + n;
            if(check > 90){
                check = check - 26;
            }
            return (char)check;
        }
        else{
            int check = (int)ch + n;
            if(check > 122){
                check = check - 26;
            }
            return (char)check;
        }
    }
}
