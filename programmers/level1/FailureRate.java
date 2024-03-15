package programmers.level1;

// https://school.programmers.co.kr/learn/courses/30/lessons/42889
// 2019 KAKAO BLIND RECRUITMENT 실패율

import java.util.*;
public class FailureRate {
    public static void main(String[] args) {

    }
    public int[] solution(int N, int[] stages) {
        // N 은 스테이지의 개수 stages는 사용자수 stages에서 N+1은 모든 스테이지 클리어 유저

        HashMap<Integer, Integer> map = new HashMap();
        int challenger = stages.length;

        for(int i = 0; i < challenger; i++){
            int tmp = stages[i];
            if(!map.containsKey(tmp)){
                map.put(tmp, 1);
            }
            else{
                map.put(tmp, map.get(tmp) + 1);
            }
        }
        // System.out.println(map);
        HashMap<Double, ArrayList<Integer>> map2 = new HashMap();  // 실패율 / 스테이지
        int people = challenger;
        ArrayList<Double> Failure = new ArrayList<>();

        for(int i = 1; i <= N; i++){
            if(map.containsKey(Integer.valueOf(i))){
                int tmp = map.get(Integer.valueOf(i));
                double check = (double)tmp / (double)people;
                if(!map2.containsKey(Double.valueOf(check))){
                    ArrayList <Integer> list = new ArrayList<>();
                    list.add(i);
                    map2.put(check, list);
                }
                else{
                    map2.get(Double.valueOf(check)).add(i);
                }
                people = people - tmp;
                if(!Failure.contains(Double.valueOf(check))){
                    Failure.add(check);
                }

            }
            else{
                if(!map2.containsKey(0.0)){
                    ArrayList <Integer> list = new ArrayList<>();
                    list.add(i);
                    map2.put(0.0, list);
                }
                else{
                    map2.get(Double.valueOf(0.0)).add(i);
                }
                if(!Failure.contains(Double.valueOf(0.0))){
                    Failure.add(0.0);
                }
            }
        }
        // 스테이지당 실패율 구하기 성공
        // System.out.println(map2);
        Collections.sort(Failure, Collections.reverseOrder());
        // System.out.println(Failure);

        int [] answer = new int[N];
        int cnt = 0;
        for(int i = 0; i < Failure.size(); i++){
            Double tmp = Failure.get(i);
            List<Integer> tempList = map2.get(tmp);
            for(int j = 0; j < tempList.size(); j++){
                int tmpInt = tempList.get(j);
                answer[cnt] = tmpInt;
                cnt++;
            }
        }
        return answer;
    }
}
