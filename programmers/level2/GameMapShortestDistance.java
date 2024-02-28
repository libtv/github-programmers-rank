package org.example.programmers.level2;

// https://school.programmers.co.kr/learn/courses/30/lessons/1844
// 프로그래머스 Level 2 게임 맵 최단거리
import java.util.*;
public class GameMapShortestDistance {
    static int [] arx = {-1,1,0,0};
    static int [] ary = {0,0,-1,1};
    public int solution(int[][] maps) {
        int answer = -1;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {0, 0});
        maps[0][0] = 1;    // 벽은 0 / 빈 공간 1
        while(!q.isEmpty()){
            int [] cur = q.poll();
            for(int i = 0; i < 4; i++){
                int nx = cur[0] + arx[i];
                int ny = cur[1] + ary[i];
                if(0 <= nx && 0 <= ny && nx < maps.length && ny < maps[0].length){
                    if(nx == maps.length - 1 && ny == maps[0].length - 1){
                        answer = maps[cur[0]][cur[1]] + 1;
                        q.clear();
                        break;
                    }
                    else if(maps[nx][ny] == 1){
                        maps[nx][ny] = maps[cur[0]][cur[1]] + 1;
                        q.add(new int [] {nx, ny});
                    }
                }
            }
        }
        return answer;
    }
}
