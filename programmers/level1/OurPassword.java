package programmers.level1;

import java.util.ArrayList;

// https://school.programmers.co.kr/learn/courses/30/lessons/155652
// 둘만의 암호
public class OurPassword {
    public static void main(String[] args) {

    }
    public String solution(String s, String skip, int index) {

        ArrayList<Character> list = new ArrayList<>();
        for(int i = 0; i < skip.length(); i++){
            list.add(skip.charAt(i));
        }

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < s.length(); i++){
            char target = s.charAt(0);
            int start_index = index;
            while(start_index!=0){
                int targets = (int)target + 1;
                start_index--;
                target = (char) targets;
                if(!list.contains(target)){
                    start_index++;
                }
            }
            sb.append(Character.toString(target));
        }
        return sb.toString();
    }

}
/*
문자를 숫자로 변환:
문자를 ASCII 코드로 변환하려면 (int) 형변환을 사용하면 됩니다.

char ch = 'a';
int asciiValue = (int) ch;
이제 asciiValue에는 'a'의 ASCII 코드 값인 97이 저장됩니다.

숫자를 문자로 변환:
ASCII 코드를 문자로 변환하려면 (char) 형변환을 사용하면 됩니다.

int asciiValue = 97;
char ch = (char) asciiValue;
이제 ch에는 ASCII 코드 값이 97인 문자 'a'가 저장됩니다.

'z' + 1은 문자 'z'의 ASCII 코드에 1을 더한 값입니다. Java에서 문자와 숫자 간의 산술 연산이 가능하며, 결과는 산술 연산을 통해 얻은 숫자에 해당하는 문자로 자동 형변환이 이루어집니다.
'z'의 ASCII 코드는 122이며, 122 + 1은 123입니다. 이 값은 ASCII 코드에서 '{'에 해당하는 값입니다. 따라서 ('z' + 1)의 결과는 문자 '{'가 됩니다.
그러므로 ('z' + 1)은 숫자로 계산된 뒤에 해당하는 문자로 변환됩니다.
 */