package boj.BarkingDog_Collection.Greedy;

import java.io.*;

// 뒤집기 실버5
public class BOJ1439 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String target = br.readLine();
        int size       = target.length();
        int count_zero = 0;
        int count_one  = 0;

        if(target.length() == 1){
            System.out.println(0);
            return;
        }

        char cur = target.charAt(0);

        if(cur == '0') count_zero++;
        else count_one++;

        for (int i = 1; i < size; i++) {
            if(cur != target.charAt(i)){
                cur = target.charAt(i);
                if(cur == '0') count_zero++;
                else count_one++;
            }
        }
        System.out.println(count_zero >= count_one ? count_one : count_zero);
    }
}
