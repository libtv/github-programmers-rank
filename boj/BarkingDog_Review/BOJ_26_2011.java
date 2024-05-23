package boj.BarkingDog_Review;

// 암호코드
import java.io.*;

public class BOJ_26_2011 {
    static final  int INF = 1000000;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int size = input.length();

        long [] DP = new long[size+1];

        if(input.charAt(0) - '0' == 0){ // 시작이 0이면 해석 불가능
            System.out.println(0);
            return;
        }

        DP[1] = 1; // 1 ~ 9 a b c d e f ...
        for (int i = 2; i <= size; i++) {              // z = 26
            int temp = input.charAt(i - 1) - '0';
            if(temp != 0){
                DP[i] = DP[i-1];
            }
            else{
                if(input.charAt(i - 2) - '0' >= 3){
                    System.out.println(0);
                    return;
                }
            }

            int check = Integer.parseInt(input.substring(i - 2 , i));
            if(check == 0){
                System.out.println(0);
                return;
            }
            if(10 <= check && check <= 26){
                if(DP[i-2] == 0) DP[i-2] = 1;
                DP[i] += DP[i-2];
                DP[i] %= INF;
            }
        }
        System.out.println(DP[size]);
    }
}
/*
A를 1이라고 하고, B는 2로, 그리고 Z는 26으로 하는거야.

"BEAN"을 암호화하면 25114

25114 ->  "BEAAD", "YAAD", "YAN", "YKD", "BEKD", "BEAN" 총 6가지

암호가 잘못되어 암호를 해석할 수 없는 경우에는 0을 출력한다.


2     -> B

25    -> BE , Y

251   -> BEA, YA

2511  -> BEAA, YAA, BEK, YK

25114 -> BEAAD, YAAD, BEKD, YKD, BEAN, YAN


2504

2  -> B
25 -> BE  Y

250 ->
2504  ->

 */