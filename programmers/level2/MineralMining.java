package programmers.level2;

// 프로그래머스 level2 광물 캐기
import java.util.*;
public class MineralMining {
    static int count; // 광물의 개수
    static int answer;
    static int[] pick;
    static String[] mineral;
    public int solution(int[] picks, String[] minerals) {
        answer = Integer.MAX_VALUE;
        count = minerals.length;
        pick = new int[picks.length];
        pick = Arrays.copyOf(picks, picks.length);
        mineral = new String[minerals.length];
        mineral = Arrays.copyOf(minerals, minerals.length);
        BackTracking(0, 0);
        return answer;
    }
    public static void BackTracking(int sum , int depth){
        int check = 0;
        for(int i = 0; i < 3; i++){
            check += pick[i];
        }
        if(depth == count || check == 0){
            answer = Math.min(answer, sum);
            return;
        }
        for(int i = 0; i < 3; i++){
            if(pick[i] > 0){
                pick[i]--;
                int cnt = 0;
                int temp = 0;
                for(int j = depth; j < count; j++){
                    if(cnt == 5) break;
                    if(i == 0){
                        temp++;
                        cnt++;
                    }
                    else if(i == 1){
                        if(mineral[j].equals("diamond")){
                            temp += 5;
                        }
                        else{
                            temp++;
                        }
                        cnt++;
                    }
                    else{
                        if(mineral[j].equals("diamond")){
                            temp += 25;
                        }
                        else if(mineral[j].equals("iron")){
                            temp += 5;
                        }
                        else{
                            temp++;
                        }
                        cnt++;
                    }
                }
                BackTracking(sum + temp, depth + cnt);
                pick[i]++;
            }
        }
    }
}
