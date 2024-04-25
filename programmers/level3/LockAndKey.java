package programmers.level3;

// 자물쇠와 열쇠
import java.util.*;
public class LockAndKey {
    static int m, n;
    static int count;
    static int [][] Lock;
    public boolean solution(int[][] key, int[][] lock) {
        m = key.length;
        n = lock.length;

        Lock = new int [n][n];

        // 빈칸 개수
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(lock[i][j] == 0) count++;
                Lock[i][j] = lock[i][j];
            }
        }

        if(count == 0) return true;

        int [][] copy = new int [m][m];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < m; j++){
                copy[i][j] = key[i][j];
            }
        }
        for(int i = 0; i < 4; i++){
            if(i != 0){
                copy = rotate(copy);
            }
            if(check(copy)) return true;
        }

        return false;
    }
    public static int [][] rotate(int [][] cur){
        int [][] temp = new int [m][m];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < m; j++){
                temp[i][j] = cur[m-1-j][i];
            }
        }
        return temp;
    }
    public static boolean validation(int nx, int ny){
        if(0 <= nx && 0 <= ny && nx < n && ny < n) return true;
        return false;
    }
    public static boolean check(int [][] input){
        ArrayList<int [] > list = new ArrayList<>();
        for(int i = 0; i < m; i++){
            for(int j = 0; j < m; j++){
                if(input[i][j] == 1){
                    list.add(new int [] {i,j});
                }
            }
        }
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(Lock[i][j] == 1) continue;
                for(int [] target : list){ // 기준
                    int x = target[0];
                    int y = target[1];
                    int sum = 1;
                    boolean flag = true;
                    for(int [] same : list){
                        int next_x = same[0] - x;
                        int next_y = same[1] - y;
                        if(next_x == 0 && next_y == 0) continue;
                        int check_x = i + next_x;
                        int check_y = j + next_y;
                        if(!validation(check_x, check_y)) continue;
                        if(Lock[check_x][check_y] == 1){
                            flag = false;
                            break;
                        }
                        else sum++;
                    }
                    if(flag && sum == count){
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
