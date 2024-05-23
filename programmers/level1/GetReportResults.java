package programmers.level1;

import java.util.ArrayList;
import java.util.HashMap;

// https://school.programmers.co.kr/learn/courses/30/lessons/92334
// 2022 KAKAO BLIND RECRUITMENT
// 신고 결과 받기
public class GetReportResults {
    public static void main(String[] args) {

    }
    public int[] solution(String[] id_list, String[] report, int k) {

        HashMap<String, ArrayList<String>> map = new HashMap<>();
        for(int i = 0; i < report.length; i++){
            String[]split = report[i].split(" ");
            if(!map.containsKey(split[0])){
                ArrayList<String> list = new ArrayList<>();
                list.add(split[1]);
                map.put(split[0], list);
            }
            else{
                map.get(split[0]).add(split[1]);
            }
        }
        // System.out.println(map);

        ArrayList<String> ban = new ArrayList<>();

        for(int i = 0; i < id_list.length; i++){
            String check = id_list[i];
            int cnt = 0;
            for(int j = 0; j < id_list.length; j++){
                if(i==j){
                    continue;
                }
                else{
                    if(map.containsKey(id_list[j])){
                        if(map.get(id_list[j]).contains(check)){
                            cnt++;
                        }
                    }
                }
            }
            if(cnt >= k ){
                ban.add(check);
            }
        }
        System.out.println(ban);

        ArrayList<Integer>result = new ArrayList<>();
        for(int i = 0; i < id_list.length; i++){
            int cnt = 0;
            if(map.containsKey(id_list[i])){
                for(int j = 0; j < ban.size(); j++){ // 벤 리스트에 신고한 기록 확인
                    if(map.get(id_list[i]).contains(ban.get(j))){
                        cnt++;
                    }
                }
            }
            result.add(cnt);
        }

        int [] ArrayResult = new int[result.size()];
        for(int i = 0; i < result.size(); i++){
            ArrayResult[i] = result.get(i);
        }
        return ArrayResult;
    }
}
