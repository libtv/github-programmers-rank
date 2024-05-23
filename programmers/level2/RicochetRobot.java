package programmers.level2;

// https://school.programmers.co.kr/learn/courses/30/lessons/169199
// 프로그래머스 level2 리코쳇 로봇
import java.util.*;
public class RicochetRobot {
    static int [] arx = {-1,1,0,0};
    static int [] ary = {0,0,-1,1};

    static class node{
        int count; int x; int y;
        public node(int count, int x, int y){
            this.count = count; this.x = x; this.y = y;
        }
    }
    public int solution(String[] board) {
        int answer = Integer.MAX_VALUE;
        int a = board.length;
        int b = board[0].length();
        int [][] map = new int [a][b];
        Queue<node> q = new LinkedList<>();
        boolean [][] visited = new boolean [a][b];
        for(int i = 0; i < a; i++){
            String temp = board[i];
            for(int j = 0; j < b; j++){
                if(temp.charAt(j) == 'D'){
                    map[i][j] = 1;
                }
                else if(temp.charAt(j)== 'R'){
                    map[i][j] = 2;
                    q.add(new node(0, i, j));
                    visited[i][j] = true;
                }
                else if(temp.charAt(j) == 'G'){
                    map[i][j] = 3;
                }
            }
        }
        // System.out.println(Arrays.deepToString(map));
        while(!q.isEmpty()){
            node node = q.poll();
            int x = node.x;
            int y = node.y;
            for(int i = 0; i < 4; i++){
                int nx = x;
                int ny = y;
                while(0<= nx + arx[i] && 0<= ny + ary[i] && nx + arx[i] < a && ny + ary[i]< b && map[nx + arx[i]][ny + ary[i]]!=1){
                    nx = nx + arx[i];
                    ny = ny + ary[i];
                }
                if(map[nx][ny] == 3){
                    answer = Math.min(answer, node.count + 1);
                }
                else if(!visited[nx][ny]){
                    visited[nx][ny] = true;
                    q.add(new node(node.count + 1, nx, ny));
                }

            }
        }
        if(answer == Integer.MAX_VALUE) return -1;
        return answer;
    }
}
