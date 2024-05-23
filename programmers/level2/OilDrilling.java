package programmers.level2;
// https://school.programmers.co.kr/learn/courses/30/lessons/250136
// [PCCP 기출문제] 2번 / 석유 시추
import java.util.*;
public class OilDrilling {
    static int [] arx = {-1,1,0,0};
    static int [] ary = {0,0,-1,1};
    public int solution(int[][] land) {
        // 0이면 빈땅 1이면 석유 2, 3, 4, 5, 6, ... 발견한 석유
        int answer = 0;
        boolean [][] visited;
        int a = land.length;
        int b = land[0].length;
        HashMap<Integer, Integer> map = new HashMap<>(); // 석유갱 이름, 크기
        int cnt = 2; // 석유 이름
        for(int i = 0; i < a; i++){
            for(int j = 0; j < b; j++){
                if(land[i][j] == 1){
                    int sum = 1;
                    land[i][j] = cnt;
                    Queue<int [] > q = new LinkedList<>();
                    q.add(new int[]{i, j});
                    while(!q.isEmpty()){
                        int [] cur = q.poll();
                        for(int k = 0; k < 4; k++){
                            int nx = arx[k] + cur[0];
                            int ny = ary[k] + cur[1];
                            if(0 <= nx && 0 <= ny && nx < a && ny < b){
                                if(land[nx][ny] == 1){
                                    land[nx][ny] = cnt;
                                    sum++;
                                    q.add(new int[]{nx,ny});
                                }
                            }
                        }
                    }
                    map.put(cnt, sum); // 석유갱 이름, 석유 크기
                    cnt++;
                }
            }
        }
        // System.out.println(Arrays.deepToString(land));
        for(int i = 0; i < b; i++){
            Set<Integer> set = new HashSet<>();
            for(int j = 0; j < a; j++){
                if(land[j][i] == 0) continue;
                set.add(land[j][i]);
            }
            Iterator<Integer> it = set.iterator();
            int sum = 0;
            while(it.hasNext()){
                int next = it.next();
                sum += map.get(next);
            }
            answer = Math.max(answer, sum);
        }

        return answer;
    }
}
