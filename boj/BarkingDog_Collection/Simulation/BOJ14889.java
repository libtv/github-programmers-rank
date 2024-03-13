package org.example.boj.BarkingDog_Collection.Simulation;

// 스타트와 링크 실버1
import java.util.*;
import java.io.*;
public class BOJ14889 {
    static int [][] memo; static int n; static int min;
    static boolean [] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        memo = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n ; j++) {
                memo[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        min = Integer.MAX_VALUE;
        visited = new boolean[n];
        BackTracking(0,0);
        System.out.println(min);
    }
    public static void BackTracking(int cur, int check){
        if(check == n/2 || cur == n){
           if(check == n/2){
              calculate();
           }
            return;
        }
        for (int i = cur; i < n; i++) {
            if(!visited[i]){
                visited[i] = true;
                BackTracking(i + 1, check + 1);
                visited[i] = false;
            }
        }
    }
    public static void calculate(){
        int team1 = 0; int team2 = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(i == j) continue;
                if(visited[i] && visited[j]){
                    team1 += memo[i][j];
                }
                else if(!visited[i] && !visited[j]){
                    team2 += memo[i][j];
                }
            }
        }
        min = Math.min(min , Math.abs(team1 - team2));
    }
}
/* 문제 설명
오늘은 스타트링크에 다니는 사람들이 모여서 축구를 해보려고 한다.
축구는 평일 오후에 하고 의무 참석도 아니다.
축구를 하기 위해 모인 사람은 총 N명이고 신기하게도 N은 짝수이다. 신기하네 .. ㅋㅋ
이제 N/2명으로 이루어진 스타트 팀과 링크 팀으로 사람들을 나눠야 한다.

BOJ를 운영하는 회사 답게 사람에게 번호를 1부터 N까지로 배정했고, 아래와 같은 능력치를 조사했다.
능력치 Sij는 i번 사람과 j번 사람이 같은 팀에 속했을 때, 팀에 더해지는 능력치이다.
팀의 능력치는 팀에 속한 모든 쌍의 능력치 Sij의 합이다.
Sij는 Sji와 다를 수도 있으며, i번 사람과 j번 사람이 같은 팀에 속했을 때, 팀에 더해지는 능력치는 Sij와 Sji이다.

N=4이고, S가 아래와 같은 경우를 살펴보자.

i\j	1	2	3	4
1	 	1	2	3
2	4	 	5	6
3	7	1	 	2
4	3	4	5

축구를 재미있게 하기 위해서 스타트 팀의 능력치와 링크 팀의 능력치의 차이를 최소로 하려고 한다.

 */