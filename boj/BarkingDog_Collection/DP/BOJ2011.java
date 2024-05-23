package boj.BarkingDog_Collection.DP;

import java.io.*;
public class BOJ2011 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        /*int cnt = 1;
        for (int i = 'A'; i <= 'Z' ; i++) {
            System.out.println((char)i);
            System.out.println(cnt);
            cnt++;
        }*/
        // 1 <= 조합 <= 26
        int [] DP = new int[input.length()+1];
        if(input.charAt(0) - '0' != 0){ // 1 ~ 9 면
            DP[1] = 1;
        }
        else{
            System.out.println(0);
            return;
        }
        for (int i = 2; i <= input.length(); i++) {
            int temp = input.charAt(i-1) - '0';
            if(temp != 0){
                DP[i] = DP[i-1];
            }
            String check = input.substring(i-2, i);
            int tmp = Integer.parseInt(check);
            if(tmp == 0){
                System.out.println(0);
                return;
            }
            if(10 <= tmp && tmp <= 26){
                if(DP[i-2] == 0){
                    DP[i-2] = 1;
                }
                DP[i] += DP[i-2];
                DP[i] %= 1000000;
            }
            else if(tmp < 10){ // 01 02 03 04 05 06 08 09
                if(i >= 3){
                    if(input.charAt(i-3) - '0' >= 3){
                        System.out.println(0);
                        return;
                    }
                }
            }
        }
        // System.out.println(Arrays.toString(DP));
        System.out.println(DP[input.length()]);
    }
}
/*

25114

DP[1] = 1(2)
DP[2] = 1(25) + 1(2 + 5) = 2
DP[3] = 1(25 + 1) + 1(2 + 5 + 1)
DP[4] = (25 + 11) + (2 + 5 + 1 + 1) + (25 + 1 + 1) + (2 + 5 + 11)

DP[5] = 25 + 11 + 4 , 2 + 5 + 1 + 1 + 4, 25 + 1 + 1 + 4 , 2 + 5 + 11 + 4 , 25 + 1 + 14 , 2 + 5 + 1 + 14



 */