package BarkingDog.YouTube_13_Simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;

// https://www.acmicpc.net/problem/14891
// 톱니바퀴 골드5
public class BJ14891 {
    // 12 / 1.5 / 3  / 4.5 / 6 / 7.5 / 9 / 10.5
    static int[] one = new int[8];
    static int[] two = new int[8];
    static int[] three = new int[8];
    static int[] four = new int[8];
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        String[] split1 = br.readLine().split("");
        for (int i = 0; i < 8; i++) {
            one[i] = Integer.parseInt(split1[i]);
        }

        String[] split2 = br.readLine().split("");
        for (int i = 0; i < 8; i++) {
            two[i] = Integer.parseInt(split2[i]);
        }

        String[] split3 = br.readLine().split("");
        for (int i = 0; i < 8; i++) {
            three[i] = Integer.parseInt(split3[i]);
        }

        String[] split4 = br.readLine().split("");
        for (int i = 0; i < 8; i++) {
            four[i] = Integer.parseInt(split4[i]);
        }

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n ; i++) {
            String[] split = br.readLine().split(" ");
            func(Integer.parseInt(split[0]), Integer.parseInt(split[1]));
        }

        int sum = 0;

        if(one[0] == 1){
            sum += 1;
        }
        if(two[0] == 1){
            sum += 2;
        }
        if(three[0] == 1){
            sum += 4;
        }
        if(four[0] == 1){
            sum += 8;
        }
        System.out.println(sum);


    }
    // N극 = 0 S극 = 1
    //  톱니바퀴 A를 회전할 때, 그 옆에 있는 톱니바퀴 B와 서로 맞닿은 톱니의 극이 다르다면, B는 A가 회전한 방향과 반대방향으로 회전하게 된다.

    public static void func(int num, int direction){ // num = 톱니번호 direction = 방향 1이면 시계 -1 반시계
        int [] check = new int[4];

        if(num == 1){
            check[0] = direction;
            if(one[2]!=two[6]){
                direction *= -1;
                check[1] = direction;
                if(two[2]!=three[6]){
                    direction *= -1;
                    check[2] = direction;
                    if(three[2]!=four[6]){
                        direction *= -1;
                        check[3] = direction;
                    }
                }
            }
        }
        else if(num == 2){
            check[1] = direction;
            if(one[2]!=two[6]){
                check[0] = direction * (-1);
            }
            if(two[2]!=three[6]){
                direction *= -1;
                check[2] = direction;
                if(three[2]!=four[6]){
                    direction *= -1;
                    check[3] = direction;
                }
            }
        }
        else if(num == 3){
            check[2] = direction;
            if(three[2]!=four[6]){
                check[3] = direction * (-1);
            }
            if(three[6]!=two[2]){
                direction *= -1;
                check[1] = direction;
                if(two[6]!=one[2]){
                    direction *= -1;
                    check[0] = direction;
                }
            }
        }
        else if(num == 4){
            check[3] = direction;
            if(four[6]!=three[2]){
                direction *= -1;
                check[2] = direction;
                if(three[6]!=two[2]){
                    direction *= -1;
                    check[1] = direction;
                    if(two[6]!=one[2]){
                        direction *= -1;
                        check[0] = direction;
                    }
                }
            }
        }
        // System.out.println(Arrays.toString(check));
        rotate(check);
    }
    public static void rotate(int [] arr){
        ArrayList<int []> list = new ArrayList<>();
        list.add(one);
        list.add(two);
        list.add(three);
        list.add(four);
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < 4 ; i++) {
            int temp = arr[i];
            if( temp == 0){
                continue;
            }
            else if(temp == -1){
                stack.push(list.get(i)[0]);
                for (int j = 7; j >=1 ; j--) {
                    stack.push(list.get(i)[j]);
                }
                for (int j = 0; j < 8 ; j++) {
                    list.get(i)[j] = stack.pop();
                }
            }
            else if( temp == 1){
                for( int j = 6; j >=0; j--){
                    stack.push(list.get(i)[j]);
                }
                list.get(i)[0] = list.get(i)[7];
                for (int j = 1; j <= 7 ; j++) {
                    list.get(i)[j] = stack.pop();
                }
            }
        }
    }
}
/* 문제 설명 2:11 pm 시작

총 8개의 톱니를 가지고 있는 톱니바퀴 4개가 아래 그림과 같이 일렬로 놓여져 있다.
톱니는 N극 또는 S극 중 하나를 나타내고 있다.


이때, 톱니바퀴를 총 K번 회전시키려고 한다. 톱니바퀴의 회전은 한 칸을 기준으로 한다. 회전은 시계 방향과 반시계 방향이 있고, 아래 그림과 같이 회전한다.
톱니바퀴를 회전시키려면, 회전시킬 톱니바퀴와 회전시킬 방향을 결정해야 한다.
톱니바퀴가 회전할 때, 서로 맞닿은 극에 따라서 옆에 있는 톱니바퀴를 회전시킬 수도 있고, 회전시키지 않을 수도 있다.

톱니바퀴 A를 회전할 때, 그 옆에 있는 톱니바퀴 B와 서로 맞닿은 톱니의 극이 다르다면, B는 A가 회전한 방향과 반대방향으로 회전하게 된다.

 */