package org.example.BarkingDog.YouTube_12_BackTracking;

import java.io.*;
// https://www.acmicpc.net/problem/16987
// 계란으로 계란치기 골드5
public class BJ16987 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N;
    static int max;
    static int[] weight;
    static int[] Durability;
    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        weight = new int[N];
        Durability = new int[N];
        max = 0; // 초기화
        for (int i = 0; i < N; i++) {
            String[] split = br.readLine().split(" ");
            Durability[i] = Integer.parseInt(split[0]);
            weight[i] = Integer.parseInt(split[1]);
        }
        egg(0, 0);
        bw.write(max + " ");
        bw.flush();
        bw.close();
    }
    // cnt는 현재 계란 sum은 깨진 계란
    public static void egg(int cnt, int sum) throws IOException{
        if(cnt == N - 1){ // 마지막 계란이라면? 검사 하고 해야하네
            if(Durability[cnt] > 0){
                int check = sum;
                for (int i = 0; i < N ; i++) { // 깨고 싶은 계란 찾기~
                    if(Durability[i] > 0 && i!= cnt){
                        Durability[cnt] -= weight[i];
                        Durability[i] -= weight[cnt];
                        int count = sum;
                        if(Durability[cnt] <= 0){
                            count += 1;
                        }
                        if(Durability[i] <= 0){
                            count += 1;
                        }
                        Durability[cnt] += weight[i];
                        Durability[i] += weight[cnt];
                        if(count > check){
                            check = count;
                        }
                    }
                }
                if(check > max){
                    max = check;
                }
                return;
            }
            else{
                if(sum > max){
                    max = sum;
                }
                return;
            }
        }
        // 현재 계란이 안 깨진 계란이라면? 근데 다른 계란들이 다 깨져있어..
        if(Durability[cnt] > 0){
            boolean flag = false;
            for (int i = 0; i < N ; i++) { // 깨고 싶은 계란 찾기~
                if(Durability[i] > 0 && i!= cnt){
                   Durability[cnt] -= weight[i];
                   Durability[i] -= weight[cnt];
                   int count = sum;
                   if(Durability[cnt] <= 0){
                       count += 1;
                   }
                   if(Durability[i] <= 0){
                       count += 1;
                   }
                   egg(cnt + 1, count);
                   Durability[cnt] += weight[i];
                   Durability[i] += weight[cnt];
                   flag = true;
                }
            }
            if(!flag){ // 만약 다른 계란들이 다 깨져있으면?
                egg(cnt + 1, sum);
            }
        }
        else{ // 현재 계란이 깨진 계란이라면? 다음 계란으로
            egg(cnt + 1, sum);
        }
    }
}
// 인범이는 BOJ에서 틀린 제출을 할 때마다 턱걸이를 5회 하는 기적의 운동 루틴을 통해 뇌와 근육을 동시에 단련한다.
// 계란에는 내구도와 무게가 정해져있다.
// 계란으로 계란을 치게 되면 각 계란의 내구도는 상대 계란의 무게만큼 깎이게 된다.
// 그리고 내구도가 0 이하가 되는 순간 계란은 깨지게 된다.
// 계란 1의 내구도가 7, 무게가 5이고 계란 2의 내구도가 3, 무게가 4라고 해보자.
// 계란 1으로 계란 2를 치게 되면 계란 1의 내구도는 4만큼 감소해 3이 되고 계란 2의 내구도는 5만큼 감소해 -2가 된다.
// 충돌 결과 계란 1은 아직 깨지지 않았고 계란 2는 깨졌다.
// 계란에 대해 왼쪽부터 차례로 들어서 한 번씩만 다른 계란을 쳐 최대한 많은 계란을 깨는 문제였다.
/*
1. 가장 왼쪽의 계란을 든다.
2. 손에 들고 있는 계란으로 깨지지 않은 다른 계란 중에서 하나를 친다.
   손에 든 계란이 깨졌거나 깨지지 않은 다른 계란이 없으면 치지 않고 넘어간다. 이후 손에 든 계란을 원래 자리에 내려놓고 3번 과정을 진행한다.
3. 가장 최근에 든 계란의 한 칸 오른쪽 계란을 손에 들고 2번 과정을 다시 진행한다.
   단, 가장 최근에 든 계란이 가장 오른쪽에 위치한 계란일 경우 계란을 치는 과정을 종료한다.
 */

/* 예제입력1 예제입력2 분석
3
8 5
1 100
3 5
output : 3

// 제일 왼쪽에 있는 계란을 든다. (8-5)
8-5랑 1-100이랑 하면 서로 깨진다. 그리고 3-5를 들면 break 제일 마지막 계란이니까
8-5랑 3-5를 먼저 한다면 8-5 -> 3-5   3-5 -> -2 - 5 (깨진 계란)

그럼
3 5
1 100  1 100으로 남은 계란인 3 5를 한다.  1-100 3-5 둘다 깨진다. 총 깨진 계란은 3개
깨짐
 */

/*
테스트 케이스 1~6 , 8,9 통과
테스트 케이스 7만 틀림

 */