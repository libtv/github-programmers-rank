package BarkingDog.YouTube_17_Greedy;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

// 보물 실버4
public class BJ1026 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        ArrayList<Integer> A = new ArrayList<>();
        ArrayList<Integer> B = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N ; i++) {
            A.add(Integer.parseInt(st.nextToken()));
        }
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for (int i = 0; i < N ; i++) {
            B.add(Integer.parseInt(st2.nextToken()));
        }
        Collections.sort(A);
        Collections.sort(B, Collections.reverseOrder());
        int sum = 0;
        for (int i = 0; i < N; i++) {
            sum += A.get(i) * B.get(i);
        }
        bw.write(Integer.toString(sum));
        bw.flush();
        bw.close();
        br.close();
    }
}
/*
옛날 옛적에 수학이 항상 큰 골칫거리였던 나라가 있었다. 이 나라의 국왕 김지민은 다음과 같은 문제를 내고 큰 상금을 걸었다.
길이가 N인 정수 배열 A와 B가 있다. 다음과 같이 함수 S를 정의하자.
S = A[0] × B[0] + ... + A[N-1] × B[N-1]
S의 값을 가장 작게 만들기 위해 A의 수를 재배열하자. 단, B에 있는 수는 재배열하면 안 된다.
S의 최솟값을 출력하는 프로그램을 작성하시오.
 */

/*
1 1 1 6 0  = 18
2 7 8 3 1

7 + 3 + 2 + 6 = 18

단, B에 있는 수는 재배열하면 안 된다. 왜?

 */