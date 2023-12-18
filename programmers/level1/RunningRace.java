package org.example.programmers.level1;

import java.util.*;

// 달리기 경주
public class RunningRace {
    public static void main(String[]args){
        String[] players = {"mumu", "soe", "poe", "kai", "mine"};
        String[] callings = {"kai", "kai", "mine", "mine"};

        String[] ans = solution(players, callings);
        for (int i = 0; i < players.length ; i++) {
            System.out.println(ans[i]);
        }
    }
    public static String[] solution(String[] players, String[] callings) {

        HashMap<String, Integer> playerMap = new HashMap<>();
        HashMap<Integer, String> playerMapReverse = new HashMap<>();
        for (int i = 0; i < players.length ; i++) {
            playerMap.put(players[i], i);  // 1 ~
        }

        for (int i = 0; i < players.length ; i++) {
            playerMapReverse.put(i, players[i]);
        }

        for( int i = 0; i < callings.length; i++){
            int tmp = playerMap.get(callings[i]); // 불린 선수의 순위 가져오기
            if(tmp!=0){
                String tmp2 = playerMapReverse.get(tmp-1);  // 불린 선수의 앞 선수 가져오기
                playerMap.put(callings[i], tmp-1);
                playerMap.put(tmp2, tmp);
                playerMapReverse.put(tmp-1, callings[i]);
                playerMapReverse.put(tmp, tmp2);
            }
        }
        for (int i = 0; i < players.length ; i++) {
            players[i] = playerMapReverse.get(i);
        }

        return players;
    }
}
/*
얀에서는 매년 달리기 경주가 열립니다.
해설진들은 선수들이 자기 바로 앞의 선수를 추월할 때 추월한 선수의 이름을 부릅니다.
예를 들어 1등부터 3등까지 "mumu", "soe", "poe" 선수들이 순서대로 달리고 있을 때,
해설진이 "soe"선수를 불렀다면 2등인 "soe" 선수가 1등인 "mumu" 선수를 추월했다는 것입니다. 즉 "soe" 선수가 1등, "mumu" 선수가 2등으로 바뀝니다.

선수들의 이름이 1등부터 현재 등수 순서대로 담긴 문자열 배열 players와 해설진이 부른 이름을 담은 문자열 배열 callings가 매개변수로 주어질 때,
경주가 끝났을 때 선수들의 이름을 1등부터 등수 순서대로 배열에 담아 return 하는 solution 함수를 완성해주세요.

 */

/*
시간초과 2중 for문 68점
public String[] solution(String[] players, String[] callings) {

        for (int i = 0; i < callings.length ; i++) {
            for (int j = 0; j < players.length ; j++) {
                if(callings[i].equals(players[j])){
                    String tmp = players[j-1];
                    players[j-1] = players[j];
                    players[j] = tmp;
                    break;
                }
            }
        }
        return players;
    }
 */

/* 시간초과 68점
  public static String[] solution(String[] players, String[] callings) {
        ArrayList<String> list = new ArrayList<>();
        for(int i = 0; i < players.length; i++){
            list.add(players[i]);
        }

        for(int i = 0; i < callings.length; i++){
            int index = list.indexOf(callings[i]);
            if(index!=0){
                String tmp = list.get(index-1); // 0 1 2 3 4
                list.remove(index-1);
                list.add(index, tmp);
            }
        }
        String[] answer = new String[players.length];
        for(int i = 0; i < players.length; i++){
            answer[i] = list.get(i);
        }
        return answer;
    }

 */
/*

        LinkedList<String> list = new LinkedList<>();
        for(int i = 0; i < players.length; i++){
            list.add(players[i]);
        }

        for ( String call: callings) {
            int index = list.indexOf(call);
            if(index!=0){
                String tmp = list.get(index-1);
                list.set(index-1, call);
                list.set(index, tmp);
            }
        }
        String[] answer = new String[players.length];
        for(int i = 0; i < players.length; i++){
            answer[i] = list.get(i);
        }
        return answer;

    }
 */
/* 75점 swap
public static String[] solution(String[] players, String[] callings) {
        ArrayList<String> list = new ArrayList<>();
        for(int i = 0; i < players.length; i++){
            list.add(players[i]);
        }
        for(int i = 0; i < callings.length; i++){
            int index = list.indexOf(callings[i]);
            if(index!=0){
                Collections.swap(list, index-1, index);
            }
        }
        String[] answer = new String[players.length];
        for(int i = 0; i < players.length; i++){
            answer[i] = list.get(i);
        }
        return answer;
    }
 */