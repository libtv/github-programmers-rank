package boj.BarkingDog_Collection.Greedy;

// 잃어버린 괄호 실버2 -> 99퍼에서 틀림
import java.io.*;
public class BOJ1541_WrongInterpretation {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        int size   = input.length();
        int answer = 0;
        int temp   = 0;
        int idx    = 0;
        boolean flag = false;
        for (int i = 1; i < size; i++) {
            char check = input.charAt(i);
            if(!flag){
                if(check == '+' || i == size-1 ){
                    if(check == '+') answer += Integer.parseInt(input.substring(idx, i));
                    else answer += Integer.parseInt(input.substring(idx, i+1));
                    idx = i + 1;
                }
                else if (check == '-') {
                    answer += Integer.parseInt(input.substring(idx, i));
                    idx = i + 1;
                    flag = true;
                }
            }
            else if(flag){
                if(check == '+'){
                    temp += Integer.parseInt(input.substring(idx, i));
                    idx = i + 1;
                }
                else if(check == '-' || i == size - 1){
                    if(check == '-') temp += Integer.parseInt(input.substring(idx, i));
                    else temp += Integer.parseInt(input.substring(idx, i+1));
                    answer -= temp;
                    temp = 0;
                    idx = i + 1;
                }
            }
        }
        System.out.println(answer);
    }
}
/*
세준이는 양수와 +, -, 그리고 괄호를 가지고 식을 만들었다. 그리고 나서 세준이는 괄호를 모두 지웠다.
그리고 나서 세준이는 괄호를 적절히 쳐서 이 식의 값을 최소로 만들려고 한다.
괄호를 적절히 쳐서 이 식의 값을 최소로 만드는 프로그램을 작성하시오.
 */

