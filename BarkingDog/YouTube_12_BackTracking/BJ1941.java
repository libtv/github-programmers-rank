package BarkingDog.YouTube_12_BackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

// https://www.acmicpc.net/problem/1941
// 소문난 칠공주 골드3
public class BJ1941 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int [] arr; // 7
    static int answer;
    static int[][] map;

    static int[] arx = {-1,1,0,0};
    static int[] ary = {0,0,-1,1};
    public static void main(String[] args) throws IOException {
        answer = 0;
        map = new int[5][5];
        arr = new int[7];

        for (int i = 0; i < 5; i++) {
            String[] split = br.readLine().split("");
            for (int j = 0; j < 5 ; j++) {
                String temp = split[j];
                if(temp.equals("Y")){ // 임도연
                    map[i][j] = 1;
                }
                else{
                    map[i][j] = 2;    // 이다솜
                }
            }
        }
        func(0, 0, 0);
        System.out.println(answer);
    }
    public static void func(int depth, int n , int count){
        if(depth == 7){
            if(count >= 4){
                if(check(arr)){
                    answer++;
                }
            }
            return;
        }
        if(n == 25){
            return;
        }
        int[] temp = find(n);
        int num = map[temp[0]][temp[1]];
        // 선택
        arr[depth] = n;
        if( num == 2){ // 이다솜
            func(depth + 1 , n + 1, count + 1);
        }
        else{ // 임도연
            func(depth + 1, n + 1, count);
        }
        // pass
        func(depth, n + 1, count);
    }
    public static boolean check(int[] arr) {
        boolean[][] visited = new boolean[5][5]; // 방문 여부를 저장하는 배열

        // 7개의 좌표를 방문했다고 표시
        for (int i = 0; i < 7; i++) {
            int[] temp = find(arr[i]);
            visited[temp[0]][temp[1]] = true;
        }

        int count = 0; // 붙어있는 좌표의 개수
        Queue<int[]> queue = new LinkedList<>();
        int[] start = find(arr[0]);
        queue.offer(start);
        visited[start[0]][start[1]] = false; // 시작 좌표는 이미 방문한 것으로 처리

        while (!queue.isEmpty()) {
            int[] temp = queue.poll();
            count++;

            for (int i = 0; i < 4; i++) {
                int temp_x = temp[0] + arx[i];
                int temp_y = temp[1] + ary[i];

                if (0 <= temp_x && 0 <= temp_y && temp_x < 5 && temp_y < 5 && visited[temp_x][temp_y]) {
                    queue.offer(new int[]{temp_x, temp_y});
                    visited[temp_x][temp_y] = false;
                }
            }
        }
        boolean flag = false;
        if(count == 7){
            flag = true;
        }
        return flag; // 붙어있는 좌표의 개수가 7인지 반환
    }

    public static int[] find(int num){ // 숫자가 들어오면 좌표가 어디인지 알려주는
        int [] temp = new int[2];
        temp[0] = num / 5;
        temp[1] = num % 5;
        return temp;
    }
}
/*
총 25명의 여학생들로 이루어진 여학생반은 5×5의 정사각형 격자 형태로 자리가 배치되었고
이다솜과 임도연이라는 두 학생이 두각을 나타내며 다른 학생들을 휘어잡기 시작했다.
이다솜파’와 ‘임도연파’의 두 파로 갈라지게 되었으며, 얼마 지나지 않아 ‘임도연파’가 세력을 확장시키며 ‘이다솜파’를 위협하기 시작했다.
낀 ‘이다솜파’의 학생들은 과감히 현재의 체제를 포기하고, ‘소문난 칠공주’를 결성하는 것이 유일한 생존 수단임을 깨달았다.
‘소문난 칠공주’는 다음과 같은 규칙을 만족해야 한다.
이름이 이름인 만큼, 7명의 여학생들로 구성되어야 한다.
강한 결속력을 위해, 7명의 자리는 서로 가로나 세로로 반드시 인접해 있어야 한다.
화합과 번영을 위해, 반드시 ‘이다솜파’의 학생들로만 구성될 필요는 없다.
그러나 생존을 위해, ‘이다솜파’가 반드시 우위를 점해야 한다. 따라서 7명의 학생 중 ‘이다솜파’의 학생이 적어도 4명 이상은 반드시 포함되어 있어야 한다.
여학생반의 자리 배치도가 주어졌을 때, ‘소문난 칠공주’를 결성할 수 있는 모든 경우의 수를 구하는 프로그램을 작성하시오.
S'(이다‘솜’파의 학생을 나타냄) 또는 'Y'(임도‘연’파의 학생을 나타냄)을 값으로 갖는 5*5 행렬이 공백 없이 첫째 줄부터 다섯 줄에 걸쳐 주어진다.
 */