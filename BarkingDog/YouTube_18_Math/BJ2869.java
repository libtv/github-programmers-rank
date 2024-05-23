package BarkingDog.YouTube_18_Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 달팽이는 올라가고 싶다 브론즈1
public class BJ2869 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        int A = Integer.parseInt(split[0]);
        int B = Integer.parseInt(split[1]);
        int V = Integer.parseInt(split[2]);
        long day = 1;
        V -= A;
        while (V > 0){
            int temp =  V / (A-B);
            day += temp;
            V -= temp * (A-B);
            if(V > 0){
                day++;
            }
            break;
        }
        System.out.println(day);
    }
}
/*
땅 위에 달팽이가 있다. 이 달팽이는 높이가 V미터인 나무 막대를 올라갈 것이다.
달팽이는 낮에 A미터 올라갈 수 있다. 하지만, 밤에 잠을 자는 동안 B미터 미끄러진다. 또, 정상에 올라간 후에는 미끄러지지 않는다.
달팽이가 나무 막대를 모두 올라가려면, 며칠이 걸리는지 구하는 프로그램을 작성하시오.


2 1 5

1일차
+ 2
- 1
-> 1

2일차
+ 2
- 1
-> 2

3일차
+ 2
- 1
-> 3

4일차
+ 2
END 5

 */
/* 시간초과 코드

public class BJ2869 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        int A = Integer.parseInt(split[0]);
        int B = Integer.parseInt(split[1]);
        int V = Integer.parseInt(split[2]);
        long day = 0;
        long cur = 0;
        while (true){
            day++;
            cur += A;
            if(cur >= V){
                break;
            }
            cur -= B;
        }
        System.out.println(day);
    }
}
 */