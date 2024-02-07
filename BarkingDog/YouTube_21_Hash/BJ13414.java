package org.example.BarkingDog.YouTube_21_Hash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 수강 신청 실버3
public class BJ13414 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String [] split = br.readLine().split(" ");
        int K = Integer.parseInt(split[0]);
        int L = Integer.parseInt(split[1]);
        HashMap<String, Integer> map = new HashMap<>();
        int cnt = 0;
        while (L-->0){
            map.put(br.readLine(), cnt);
            cnt++;
        }
        ArrayList<Map.Entry<String , Integer>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, new Sort());
        StringBuilder sb = new StringBuilder();
        int count = 0;
        for (Map.Entry<String ,Integer> target: list) {
            count++;
            if(count > K){
                break;
            }
            sb.append(target.getKey()).append("\n");
        }
        System.out.println(sb);
    }
}
class Sort implements Comparator<Map.Entry<String, Integer>>{
    public int compare(Map.Entry<String, Integer> entry1, Map.Entry<String, Integer> entry2){
        if(entry1.getValue() > entry2.getValue())
            return 1;
        else
            return -1;
    }
}

/*
수강신청 버튼이 활성화 된 후, 수강신청 버튼을 조금이라도 빨리 누른 학생이 대기목록에 먼저 들어간다.
이미 대기열에 들어가 있는 상태에서 다시 수강신청 버튼을 누를 경우 대기목록의 맨 뒤로 밀려난다.
잠시 후 수강신청 버튼이 비활성화 되면, 대기목록에서 가장 앞에 있는 학생부터 자동으로 수강신청이 완료되며,
수강 가능 인원이 꽉 찰 경우 나머지 대기목록은 무시하고 수강신청을 종료한다.
 */