package BarkingDog.YouTube_21_Hash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 회사에 있는 사람 실버5
public class BJ7785 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        HashMap<String, Integer> enter = new HashMap<>();
        HashMap<String, Integer> leave = new HashMap<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            String action = st.nextToken();
            if(action.equals("enter")){
                enter.put(name, enter.getOrDefault(name, 0) + 1);
            }
            else{
                leave.put(name, leave.getOrDefault(name, 0) + 1);
            }
        }
        ArrayList<String> list = new ArrayList<>();
        Iterator<Map.Entry<String, Integer>> iterator = enter.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<String , Integer> entry = iterator.next();
            String name = entry.getKey();
            int number = entry.getValue();
            if((leave.containsKey(name) && number > leave.get(name)) || !leave.containsKey(name))
                list.add(name);
        }
        Collections.sort(list, Collections.reverseOrder());
        StringBuilder sb = new StringBuilder();
        for (String target: list) {
            sb.append(target).append("\n");
        }
        System.out.println(sb);

    }
}
/*
현재 회사에 있는 모든 사람을 구하는 프로그램을 작성하시오.
첫째 줄에 로그에 기록된 출입 기록의 수 n이 주어진다. (2 ≤ n ≤ 10^6)
"enter"나 "leave"가 주어진다.

회사에는 동명이인이 없으며, 대소문자가 다른 경우에는 다른 이름이다. 사람들의 이름은 알파벳 대소문자로 구성된 5글자 이하의 문자열이다.
현재 회사에 있는 사람의 이름을 사전 순의 역순으로 한 줄에 한 명씩 출력한다.

 */