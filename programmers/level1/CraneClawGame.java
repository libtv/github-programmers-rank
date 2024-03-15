package programmers.level1;

import java.util.Stack;

// https://school.programmers.co.kr/learn/courses/30/lessons/64061
// 2019 카카오 개발자 겨울 인턴십 크레인 인형뽑기 게임
public class CraneClawGame {
    public static void main(String[] args) {

    }
    public int solution(int[][] board, int[] moves) {
        int answer = 0; // 사라진 인형의 개수
        Stack<Integer> st = new Stack(); // 바구니

        int movesLength = moves.length;
        int boardLength = board.length;

        for(int i = 0; i < movesLength; i++){
            int num = moves[i]-1;
            for(int j = 0; j < boardLength; j++){
                if(board[j][num]!=0){
                    if(st.size() == 0){
                        st.push(board[j][num]);
                        board[j][num] = 0;

                    }
                    else if(st.peek() != board[j][num]){
                        st.push(board[j][num]);
                        board[j][num] = 0;

                    }
                    else if(st.peek() == board[j][num]){
                        st.pop();
                        answer = answer + 2;
                        board[j][num] = 0;

                    }
                    break;
                }
            }
            // System.out.println(st);
        }
        return answer;
    }

}
/* 더 간결하게 리팩토링
public int solution(int[][] board, int[] moves) {
        int answer = 0; // 사라진 인형의 개수
        Stack<Integer> st = new Stack(); // 바구니

        int movesLength = moves.length;
        int boardLength = board.length;

        for(int i = 0; i < movesLength; i++){
             int num = moves[i]-1;
             for(int j = 0; j < boardLength; j++){
                 if(board[j][num]!=0){
                     if(st.size() >=1 && st.peek() == board[j][num]){
                         st.pop();
                         answer = answer + 2;
                         board[j][num] = 0;

                     }
                     else{
                         st.push(board[j][num]);
                         board[j][num] = 0;
                     }
                     break;
                 }
             }
             // System.out.println(st);
        }
        return answer;
    }
 */