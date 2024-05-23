package programmers.level2;

// https://school.programmers.co.kr/learn/courses/30/lessons/160585
public class TicTacToeAlone {
    public int solution(String[] board) {

        // "0", "X" 둘다 가로 세로 대각선으로 연결하면 3개인 경우
        // 후공인 "X"가 선공인 "O"보다 많은 경우
        // "O" + "X" = 9 이미 게임판이 다 채워져서 진행 X

        // 빈칸 "." = 0  / "0" = 1 "X" = 2
        int [][] map = new int [3][3];
        int first = 0; int second = 0;
        for(int i = 0; i < 3; i ++){
            String temp = board[i];
            for(int j = 0; j < 3; j++){
                if(temp.charAt(j) == 'O'){
                    map[i][j] = 1;
                    first++;
                }
                else if(temp.charAt(j) == 'X'){
                    map[i][j] = 2;
                    second++;
                }
            }
        }
        // 틱택토를 진행했을 때 나올 수 있는 게임 상황이면 1을 아니라면 0
        boolean check = true;
        if(first < second){
            check = false;
        }

        int first_3 = 0; int second_3 = 0;
        // 좌우   [0][0] -> 2개, [1][0]-> 2개  [2][0] -> 2개
        for(int i = 0; i < 3 ; i++){
            if(map[i][0] == map[i][1] && map[i][1] == map[i][2]){
                boolean flag = map[i][0] == 1 ? true : false;
                if(flag && map[i][0]!=0) first_3++;
                else if(!flag && map[i][0]!=0) second_3++;
            }
        }
        // 위아래 [0][0] [0][1] [0][2]
        for(int i = 0; i < 3; i++){
            if(map[0][i] == map[1][i] && map[1][i] == map[2][i]){
                boolean flag = map[0][i] == 1 ? true : false;
                if(flag && map[0][i]!=0) first_3++;
                else if(!flag && map[0][i]!= 0) second_3++;
            }
        }
        // 대각선 [0][0] 오른쪽 아래 대각선 확인 [0][2] 왼쪽 아래 대각선 확인
        if(map[0][0] == map[1][1] && map[1][1] == map[2][2]){
            boolean flag = map[0][0] == 1 ? true : false;
            if(flag && map[0][0]!=0) first_3++;
            else if(!flag && map[0][0]!=0) second_3++;
        }
        if(map[0][2] == map[1][1] && map[1][1] == map[2][0]){
            boolean flag = map[1][1] == 1 ? true : false;
            if(flag && map[1][1]!=0) first_3++;
            else if(!flag && map[1][1]!=0) second_3++;
        }
        if(check){
            if(first == second){
                if(first_3 == 0 && second_3 == 0){
                    return 1;
                }
                else if(first_3 == 0 && second_3 <= 2){
                    return 1;
                }
            }
            else if(first > second && first - second == 1){
                if(first_3 == 0 && second_3 == 0){
                    return 1;
                }
                else if(first_3 <= 2 && second_3 == 0){
                    return 1;
                }
            }
            else{
                return 0;
            }
        }
        return 0;
    }
}
