package BarkingDog.YouTube_16_DP;

import java.util.Scanner;

// https://www.acmicpc.net/problem/12852
// 1로 만들기2 실버1
public class BJ12852 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        if(num == 1){
            System.out.println(0);
            System.out.println(1);
        }
        else if(num == 2){
            System.out.println(1);
            System.out.println(2+" "+1);
        }
        else{ // 3이상
           int [] DP = new int[num+1];
           int [] pre = new int[num+1];
           pre[1] = 0;
           pre[2] = 1;
           DP[1] = 0;
           DP[2] = 1;
            for (int i = 3; i <= num ; i++) {
                DP[i] = DP[i-1] + 1;
                pre[i] = i-1;
                if(i % 3 ==0 && DP[i] > DP[i/3] + 1){
                    DP[i] = DP[i/3] + 1;
                    pre[i] = i/3;
                }
                if(i % 2 ==0 && DP[i] > DP[i/2] + 1){
                    DP[i] = DP[i/2] + 1;
                    pre[i] = i/2;
                }
            }
            System.out.println(DP[num]);
            StringBuilder sb = new StringBuilder();
            sb.append(num);
            sb.append(" ");
            int cur = num;
            while (true){
                cur = pre[cur];
                sb.append(cur);
                sb.append(" ");
                if(cur == 1){
                    break;
                }
            }
            System.out.println(sb);
        }
    }
}
/* 문제
정수 X에 사용할 수 있는 연산은 다음과 같이 세 가지 이다.
X가 3으로 나누어 떨어지면, 3으로 나눈다.
X가 2로 나누어 떨어지면, 2로 나눈다.
1을 뺀다.

정수 N이 주어졌을 때, 위와 같은 연산 세 개를 적절히 사용해서 1을 만들려고 한다. 연산을 사용하는 횟수의 최솟값을 출력하시오.
둘째 줄에는 N을 1로 만드는 방법에 포함되어 있는 수를 공백으로 구분해서 순서대로 출력한다. 정답이 여러 가지인 경우에는 아무거나 출력한다.
 */

/* 점화식 세우기
D[K] = D[K+1] + 1;
if(K % 3 == 0)
D[K] = Math.min(d
D[K] = Math.min(


 */