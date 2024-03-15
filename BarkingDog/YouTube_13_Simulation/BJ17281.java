package BarkingDog.YouTube_13_Simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

// https://www.acmicpc.net/problem/17281
// 야구공 ⚾ 골드4
public class BJ17281 {

    static int innings;
    static int [][] action;
    static int [] arr;
    static boolean [] visited;
    static int Max;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        innings = Integer.parseInt(br.readLine());
        action = new int[innings][9];
        for (int i = 0; i < innings; i++) {
            String [] split = br.readLine().split(" ");
            for (int j = 0; j < 9 ; j++) {
                action[i][j] = Integer.parseInt(split[j]);
            }
        }
        arr = new int[9]; // 선수 순서
        visited = new boolean[10];
        // System.out.println(Arrays.deepToString(action));
        Max = 0;
        BackTracking(0);
        System.out.println(Max);
    }
    public static void BackTracking(int depth){
        if(depth == 9){
            // System.out.println(Arrays.toString(arr));
            findMaxScore(arr);
            return;
        }
        if(depth == 3) {
            arr[depth] = 1; // 1번은 항상 4번타자
            BackTracking(depth + 1);
        }
        else{
            for (int i = 2; i <= 9; i++) {
                if(!visited[i]){
                    arr[depth] = i;
                    visited[i] = true;
                    BackTracking(depth + 1);
                    visited[i] = false;
                }
            }
        }
    }
    public static void findMaxScore(int [] arr){
        int score = 0;
        int cnt = 0;
        for (int i = 0; i < innings; i++) {
            int outCount = 0;
            int base1 = 0;
            int base2 = 0;
            int base3 = 0;
            while (outCount!=3){
                int temp = action[i][arr[cnt]-1];
                cnt ++;
                if(cnt == 9){
                    cnt = 0;
                }
                switch (temp){
                    case 0:
                        outCount++;
                        break;
                    case 1:
                        if(base3 == 1){
                            score++;
                            base3 = 0;
                        }
                        if(base2 == 1){
                            base2 = 0;
                            base3 = 1;
                        }
                        if(base1 == 1){
                            base2 = 1;
                            base1 = 0;
                        }
                        base1 = 1;
                        break;
                    case 2:
                        if(base3 == 1){
                            score++;
                            base3 = 0;
                        }
                        if(base2 == 1){
                            score++;
                            base2 = 0;
                        }
                        if(base1 == 1){
                            base3 = 1;
                            base1 = 0;
                        }
                        base2 = 1;
                        break;
                    case 3:
                        if(base3 == 1){
                            score++;
                            base3 = 0;
                        }
                        if(base2 == 1){
                            score++;
                            base2 = 0;
                        }
                        if(base1 == 1){
                           score++;
                           base1 = 0;
                        }
                        base3 = 1;
                        break;
                    case 4:
                        if(base3 == 1){
                            score++;
                        }
                        if(base2 == 1){
                            score++;
                        }
                        if(base1 == 1){
                            score++;
                        }
                        score++;
                        base3 = 0;
                        base2 = 0;
                        base1 = 0;
                        break;
                }
            }
        }
        if( score > Max){
            Max = score;
        }
    }
}
/* 문제 설명
⚾는 9명으로 이루어진 두 팀이 공격과 수비를 번갈아 하는 게임이다.  N이닝 동안 게임을 진행해야 한다.
한 이닝에 3아웃이 발생하면 이닝이 종료되고, 두 팀이 공격과 수비를 서로 바꾼다.

두 팀은 경기가 시작하기 전까지 타순(타자가 타석에 서는 순서)을 정해야 하고, 경기 중에는 타순을 변경할 수 없다.
9번 타자까지 공을 쳤는데 3아웃이 발생하지 않은 상태면 이닝은 끝나지 않고, 1번 타자가 다시 타석에 선다.
2이닝에 6번 타자가 마지막 타자였다면, 3이닝은 7번 타자부터 타석에 선다.

공격 팀의 선수가 1루, 2루, 3루를 거쳐서 홈에 도착하면 1점을 득점한다.
타자가 공을 쳐서 얻을 수 있는 결과는 안타, 2루타, 3루타, 홈런, 아웃 중 하나이다. 각각이 발생했을 때, 벌어지는 일은 다음과 같다.

안타: 타자와 모든 주자가 한 루씩 진루한다.
2루타: 타자와 모든 주자가 두 루씩 진루한다.
3루타: 타자와 모든 주자가 세 루씩 진루한다.
홈런: 타자와 모든 주자가 홈까지 진루한다.
아웃: 모든 주자는 진루하지 못하고, 공격 팀에 아웃이 하나 증가한다.

한 야구팀의 감독 아인타는 타순을 정하려고 한다. 아인타 팀의 선수는 총 9명이 있고, 1번부터 9번까지 번호가 매겨져 있다.
아인타는 자신이 가장 좋아하는 선수인 1번 선수를 4번 타자로 미리 결정했다. 이제 다른 선수의 타순을 모두 결정해야 한다.
아인타는 각 선수가 각 이닝에서 어떤 결과를 얻는지 미리 알고 있다. 가장 많은 득점을 하는 타순을 찾고, 그 때의 득점을 구해보자.

아인타팀이 얻을 수 있는 최대 점수를 출력한다.

 */
/* 시간 초과 발생 하..
public static void findMaxScore(int [] arr){
        ArrayList<Integer> list = new ArrayList<>();
        int score = 0;
        int cnt = 0;
        for (int i = 0; i < innings ; i++) {
            int outCount = 0;
            boolean [] Runner = new boolean[3]; // 0 = 1루 1 = 2루 2 = 3루
            while (outCount!= 3){
                int temp = arr[cnt]; // 선수
                cnt++;
                if(cnt == 9){
                    cnt = 0;
                }
                int temp2 = action[i][temp-1];
                if(temp2 == 0){
                   outCount++;
                }
                else if(temp2 == 1){
                    for (int j = 0; j < 3; j++) {
                        if(Runner[j]){
                            list.add(j);
                            Runner[j] = false;
                        }
                    }
                    int ch = 0;
                    for (int j = 0; j < list.size(); j++) {
                        if(list.get(ch) < 2){
                            Runner[list.get(ch) + 1] = true;
                            ch++;
                        }
                        else{
                            score++;
                        }
                    }
                    list.clear();
                    Runner[0] = true;
                }
                else if(temp2 == 2){
                    for (int j = 0; j < 3; j++) {
                        if(Runner[j]){
                            list.add(j);
                            Runner[j] = false;
                        }
                    }
                    int ch = 0;
                    for (int j = 0; j < list.size(); j++) {
                        if(list.get(ch) < 1){
                            Runner[list.get(ch) + 2] = true;
                            ch++;
                        }
                        else{
                            score++;
                        }
                    }
                    list.clear();
                    Runner[1] = true;
                }
                else if(temp2 == 3){
                    for (int j = 0; j < 3 ; j++) {
                        if(Runner[j]){
                            score++;
                            Runner[j] = false;
                        }
                    }
                    Runner[2] = true;
                }
                else if(temp2 == 4){ // 홈런
                    score++;
                    for (int j = 0; j < 3 ; j++) {
                        if(Runner[j]){
                            score++;
                            Runner[j] = false;
                        }
                    }
                }
            }
        }
        if( score > Max){
            Max = score;
        }
    }
 */