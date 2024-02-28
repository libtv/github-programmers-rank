package org.example.programmers.level2;

// https://school.programmers.co.kr/learn/courses/30/lessons/1829
// 프로그래머스 level2 카카오프렌즈 컬러링북
import java.util.*;
public class KakaoFriendsColoringBook {
    static class node{
        int x; int y;
        public node(int x, int y){
            this.x = x; this.y = y;
        }
    }
    static int [] arx = {-1,1,0,0};
    static int [] ary = {0,0,-1,1};
    public int[] solution(int m, int n, int[][] picture) {
        int [] answer = new int [2];
        ArrayList<Integer> list = new ArrayList<>();
        boolean [][] visited = new boolean [m][n];
        Queue<node> q = new LinkedList<>();
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(!visited[i][j] && picture[i][j] != 0){
                    int count = 1;
                    visited[i][j] = true;
                    long color = picture[i][j];
                    q.add(new node(i, j));
                    while(!q.isEmpty()){
                        node node = q.poll();
                        for(int k = 0; k < 4; k++){
                            int nx = node.x + arx[k];
                            int ny = node.y + ary[k];
                            if(0 <= nx && 0 <= ny && nx < m && ny < n){
                                if(!visited[nx][ny] && picture[nx][ny] == color){
                                    visited[nx][ny] = true;
                                    count++;
                                    q.add(new node(nx, ny));
                                }
                            }
                        }
                    }
                    list.add(count);
                }
            }
        }
        answer[0] = list.size();
        answer[1] = Collections.max(list);
        return answer;
    }
}
