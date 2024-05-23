package boj.BarkingDog_Collection.DP;

// 동전 문제 골드2
import java.util.*;
import java.io.*;
public class BOJ1398_MyOwnSolution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        /*
        int k = 0;
        while (25 * Math.pow(100, k) <= Math.pow(10,15)){
            k++;
        }
        System.out.println(25 * Math.pow(100, 6) <= Math.pow(10,15) ? "yes" : "no");
        k-->6

        0 ~ 6  -> 7
        0 ~ 15 -> 16
        -> 23
        */
        long [] coin = new long[25];
        for (int i = 0; i < 8; i++) {
            coin[i] = 25 * (long) Math.pow(100,i);
        }
        for (int i = 8; i < 25; i++) {
            coin[i] = (long) Math.pow(10, i-8);
        }
        Arrays.sort(coin);
        // System.out.println(Arrays.toString(coin));
        while (t-->0){
            long target = Long.parseLong(br.readLine());
            long count = 0;
            int cur = 24;
            while (target!=0){
                if(target < coin[cur]){
                    cur--;
                }
                else{
                    // 25 .. xx 인지 1 .. x인지 구분하기
                    if(coin[cur] * 4 == coin[cur+1]){
                        String temp = Long.toString(target);
                        temp = temp.substring(0, 2);
                        int case1 = 0;
                        int case2 = 0;
                        int tmp = Integer.parseInt(temp);
                        while (tmp != 0){
                            if(tmp >= 25){
                                case1 += tmp / 25;
                                tmp %= 25;
                            }
                            else if(tmp >= 10){
                                case1 += tmp / 10;
                                tmp %= 10;
                            }
                            else{
                                case1 += tmp;
                                tmp = 0;
                            }
                        }
                        tmp = Integer.parseInt(temp);
                        while (tmp != 0){
                            if(tmp >= 10){
                                case2 += tmp / 10;
                                tmp %= 10;
                            }
                            else{
                                case2 += tmp;
                                tmp = 0;
                            }
                        }
                        if(case1 <= case2){
                            target -= coin[cur];
                            count++;
                        }
                        else{
                            cur--;
                        }
                    }
                    else{
                        target -= coin[cur];
                        count++;
                    }
                }
            }
            sb.append(count).append("\n");
        }
        System.out.println(sb);
    }
}
/*

반례
34
answer = 7
output = 10

answer = 10 * 3 + 1 * 4
output = 25 * 1 + 1 * 9


59
59 / 25 = 2 + 9

59 - 25 = 34




59 / 10 = 5 + 9








 */