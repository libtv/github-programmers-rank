package org.example.BarkingDog.YouTube_9_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// https://www.acmicpc.net/problem/1697
// 숨바꼭질 실버1
public class BJ1697 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 수빈이는 동생과 숨바꼭질을 하고 있다. 수빈이는 현재 점 N(0 ≤ N ≤ 100,000)에 있고, 동생은 점 K(0 ≤ K ≤ 100,000)에 있다.
        // 수빈이는 걷거나 순간이동을 할 수 있다.
        // 수빈이의 위치가 X일 때 걷는다면 1초 후에 X-1 또는 X+1로 이동하게 된다.
        // 순간이동을 하는 경우에는 1초 후에 2*X의 위치로 이동하게 된다.
        String[] split = br.readLine().split(" ");

        int N = Integer.parseInt(split[0]);
        int K = Integer.parseInt(split[1]);
        boolean first = false; // 운 좋은놈
        if(N==K){
            first = true;
        }

        Queue<Integer> bfs = new LinkedList<>();

        int[] map = new int[100001];
        // System.out.println(Arrays.toString(map)); // 0으로 초기화
        map[N] = -2; // 시작지점
        map[K] = -1; // 도착지점
        // 들렸던곳 -2
        bfs.offer(N);
        int end = 100001;
        int time = 1; // 수빈이가 5-10-9-18-17 순으로 가면 4초만에 동생을 찾을 수 있다.
        int update = bfs.size();
        int cnt = 0;
        boolean endPoint = false;
        while (!bfs.isEmpty()){
            int gps = bfs.poll();
            cnt++;
            for (int i = 0; i < 3 ; i++) { // 0,1,2
                if(i==0){
                    gps = gps * 2;
                    if(0 <= gps && gps < end){
                         if(map[gps] == -1){
                             endPoint = true;
                             bfs.clear();
                             break;
                         }
                         else if(map[gps]!= -2){
                             map[gps] = -2;
                             bfs.offer(gps);
                         }
                    }
                    gps = gps / 2;
                }
                else if(i==1){
                    gps += 1;
                    if(0 <= gps && gps < end){
                        if(map[gps] == -1){
                            endPoint = true;
                            bfs.clear();
                            break;
                        }
                        else if(map[gps]!= -2){
                            map[gps] = -2;
                            bfs.offer(gps);
                        }
                    }
                    gps -= 1;
                }
                else if(i==2){
                    gps -= 1;
                    if(0 <= gps && gps < end){
                        if(map[gps] == -1){
                            endPoint = true;
                            bfs.clear();
                            break;
                        }
                        else if(map[gps]!= -2){
                            map[gps] = -2;
                            bfs.offer(gps);
                        }
                    }
                    gps += 1;
                }
            }
            if(cnt == update && !endPoint){
                time++;
                cnt = 0;
                update = bfs.size();
            }
            // System.out.println(bfs);
        }
        // System.out.println(bfs);
        if(first){
            System.out.println(0);
        }
        else{
            System.out.println(time);
        }
    }
}
// 시작 위치랑 끝나는 위치가 동일한 경우를 고려못함