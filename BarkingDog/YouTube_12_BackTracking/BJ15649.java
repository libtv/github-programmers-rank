package BarkingDog.YouTube_12_BackTracking;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

// https://www.acmicpc.net/problem/15649
// N과 M(1) 실버3
public class BJ15649 {
    static int N;
    static int M;

    static boolean[] visit = new boolean[N+1]; // 1~N까지 방문 했는지 확인하는 용도의 visit 배열

    static int [] arr = new int[M]; // 수열의 크기 == M  / 값을 담을 int 배열 arr

    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        // 자연수 N과 M이 주어졌을 때, 아래 조건을 만족하는 길이가 M인 수열을 모두 구하는 프로그램을 작성하시오.
        // 1부터 N까지 자연수 중에서 중복 없이 M개를 고른 수열
        // 한 줄에 하나씩 문제의 조건을 만족하는 수열을 출력한다.
        // 중복되는 수열을 여러 번 출력하면 안되며, 각 수열은 공백으로 구분해서 출력해야 한다.
        // 수열은 사전 순으로 증가하는 순서로 출력해야 한다.
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        visit = new boolean[N + 1];  // 0은 제외
        arr = new int[M];
        func(0);
        bw.flush();
        bw.close();

    }
    public static void func(int depth) throws IOException {
        if(depth == M){
            for (int i = 0; i < M; i++) {
                bw.write(arr[i] + " ");
            }
            bw.write("\n");
            return;
        }
        else{
            for (int i = 1; i < N+1; i++) {
                if(!visit[i]){
                    visit[i] = true;
                    arr[depth] = i;
                    func(depth + 1);
                    visit[i] = false;
                }
            }
        }
    }
}

