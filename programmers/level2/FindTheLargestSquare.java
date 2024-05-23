package programmers.level2;

// 가장 큰 정사각형 찾기
import java.util.*;
public class FindTheLargestSquare {
    static int [] arx = {-1,0,-1};
    static int [] ary = {-1,-1,0};
    static int n, m;
    public int solution(int [][]board){
        n = board.length;
        m = board[0].length;

        int max = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(board[i][j] == 0) continue;
                if(max < board[i][j]) max = board[i][j];
                boolean flag = true;
                int min = Integer.MAX_VALUE;
                for(int k = 0; k < 3; k++){
                    int nx = i + arx[k];
                    int ny = j + ary[k];
                    if(!validation(nx,ny) || board[nx][ny] == 0){
                        flag = false;
                        break;
                    }
                    min = Math.min(min, board[nx][ny]);
                }
                if(!flag) continue;
                min = (int)Math.sqrt(min);
                board[i][j] = (min + 1) * (min + 1);
                if(max < board[i][j]) max = board[i][j];
            }
        }
        return max;
    }
    public static boolean validation(int nx, int ny){
        if(0 <= nx && 0 <= ny && nx < n && ny < m) return true;
        return false;
    }

}
