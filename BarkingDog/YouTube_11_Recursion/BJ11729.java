package BarkingDog.YouTube_11_Recursion;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

// https://www.acmicpc.net/problem/11729
// 하노이 탑 이동 순서 골드5
public class BJ11729 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    /*
    전체 이동횟수를 구하는 식
    a1 = 1;  원판이 1개라면 기둥1에서 기둥3으로 가는 이동은 1이다.
    an = ?   n개의 원판을 이동시키기 위한 이동 횟수를 an이라고 하면 a(n-1) * 2 + 1이다.
    an = 2(an-1) + 1;
    a1 = 1;
    a2 = 2 * 1 + 1 = 3;
    a3 = 2 * 3 + 1 = 7;
    즉 총 횟수는 2의 n승 -1이다.
     */
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        // 옮김 횟수 먼저 출력
        bw.write(String.valueOf((int)Math.pow(2,n)-1) + "\n");
        fnc(1,3, n);
        bw.flush();
        bw.close();

    }
    // (1, 3, 3)
    public static void fnc(int a, int b, int n) throws IOException {// 원판 n개를 a에서 b 기둥으로 옮기는 방법을 출력하는 함수
        if(n == 1){
            bw.write(a + " " + b + "\n");
        }
        else{
            fnc(a , 6-a-b, n-1);  // ( 1, 2 , 2)
            bw.write(a + " " + b + "\n");
            fnc(6-a-b , b, n-1);
        }
    }
    /*
    느낀점
    항상 약간 자연의 원리? 같은 느낌을 하나 찾아야함
    하노이탑 같은 경우는 n개의 원판을 옮긴다고 하면 n-1개는 1->2  n번 원판을 1->3 그리고 n-1개의 원판을 2->3
    이런 당연한 원리를 대입 해놓고 항상 최소값으로 baseConditon을 생각하고 구현 (원판이 1개)
    그렇게 하고 원판이 2개를 생각하면서 구현하면 재귀가 완성 .. ㅋㅋ
     */

}

/* 귀납적 관점으로 접근하기

         n개의 원판
          기둥 1          기둥 2         기둥 3

모든 원판을 기둥1에서 기둥 3으로 옮기려면 n번 원판을 기둥1에서 기둥 3으로 옮겨야 한다.
n번 원판을 기둥 1에서 3으로 옮기려면 n-1번원판까지 모드 기둥2로 옮겨져야 n번 원판을 기둥 3으로 옮길 수 있다.
n번 원판을 3으로 옮긴 이후에 n-1개의 원판을 기둥2에서 기둥3으로 옮기면 끝

n-1개의 원판을 원하는 곳으로 옮길 수 만 있다면 n개의 원판을 처리할 수 있다.

n-1개의 원판을 기둥1에서 기둥2로 옮긴다.
n번 원판을 기둥 1에서 기둥 3으로 옮긴다.
n-1개의 원판을 기둥 2에서 기둥 3으로 옮긴다.

-> 원판이 n-1개일 때 옮길 수 있으면 원판이 n개일 때에도 옮길 수 있다. (재귀)

즉 원판이 1개일 때 원판을 내가 원하는 곳으로 옮길 수 있다.
원판이 k개일 때 옮길 수 있으면 원판이 k+1일 때에도 옮길 수 있다.


1. 함수의 정의
void func(int a, int b, int n)
원판 n개를 a번 기둥에서 b번 기둥으로 옮기는 방법을 출력하는 함수

2. base condition
n = 1일 때 a에서 b로 옮긴다.

3. 재귀 식
기둥 a도 아니고 b도 아닌 기둥의 번호는 6-a-b이다. => 2

n-1개의 원판을 기둥 a에서 기둥 6-a-b로 옮긴다.    func(a, 6-a-b, n-1)
n번 원판을 기둥 a에서 기둥 b로 옮긴다.            func(a, b , 1)
n-1개의 원판을 기둥 6-a-b에서 기둥 b로 옮긴다.    func(6-a-b, b, n-1);

 */