package boj.BarkingDog_Collection.Math;

// 분수찾기 실버5
import java.util.*;
public class BOJ1193 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();
        int cur = 0;
        int cnt = 1;
        int start = 0; int end = 0;
        while (true){
            if(cur <= input && input <= cur + cnt){
                if(cnt % 2 == 1){
                    start = cnt;
                    end  = 1;
                    for (int i = cur + 1; i < input; i++) {
                        start--;
                        end++;
                    }
                }
                else{
                    start = 1;
                    end = cnt;
                    for (int i = cur + 1; i < input; i++) {
                        start++;
                        end--;
                    }
                }
                break;
            }
            cur += cnt;
            cnt++;
        }
        System.out.println(start + "/" + end);
    }
}
/*
짝수면 위에서 아래
홀수면 아래에서 위로


 */