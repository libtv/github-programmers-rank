package org.example.BarkingDog.YouTube_18_Math;

import java.util.Scanner;

// 분수찾기 실버5
public class BJ1193 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long sum = 0;
        int check = 0;
        boolean flag = false;
        int answer1 = 0;
        int answer2 = 0;
        boolean END = false;
        for (int i = 1; i <= 10000000; i++) {
            check = i;
            flag = !flag;
            sum += i;
            if(n <= sum){
                END = true;
                long cnt = sum - i;
                if(!flag){ // 위에서부터
                    int start = 1;
                    int end = check;
                    while (true){
                        cnt++;
                        if(cnt == n){
                            answer1 = start;
                            answer2 = end;
                            break;
                        }
                        start++;
                        end--;
                    }
                }
                else if(flag){ // 아래에서부터
                    int start = check;
                    int end = 1;
                    while (true){
                        cnt++;
                        if(cnt == n){
                            answer1 = start;
                            answer2 = end;
                            break;
                        }
                        start--;
                        end++;
                    }
                }
            }
            if(END){
                break;
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(answer1).append("/").append(answer2);
        System.out.println(sb);
    }
}
/*
1 2 3 4 5


 */

/*
분수찾기

1/1 : 1
1/2 : 2
2/1 : 3
3/1 : 4
2/2 : 5
?
1/3 : 6
1/4 : 7
2/3 : 8
3/2 : 9

4/1 : 10

 */