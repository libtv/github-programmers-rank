package BarkingDog.YouTube_22_BST;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 문제 추천 시스템 Version 1 골드4
public class BJ21939 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        TreeMap<Integer, TreeSet<Integer>> map = new TreeMap<>(); // 문제 난이도 key 문제 번호 value
        HashMap<Integer, Integer> map2 = new HashMap<>(); // 문제 번호 key 문제 난이도 value
        while (n-->0){
            // 문제 번호 P, 문제 난이도 L
            StringTokenizer st = new StringTokenizer(br.readLine());
            int P = Integer.parseInt(st.nextToken());
            int L = Integer.parseInt(st.nextToken());
            map2.put(P, L);
            if(map.containsKey(L)){
                map.get(L).add(P);
            }
            else if(!map.containsKey(L)){
                TreeSet<Integer> set = new TreeSet<>();
                set.add(P);
                map.put(L , set);
            }
        }
        int m = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (m-->0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            if(command.equals("add")){
                int p = Integer.parseInt(st.nextToken()); // 문제 번호
                int l = Integer.parseInt(st.nextToken()); // 문제 난이도
                map2.put(p , l);
                if(map.containsKey(l)){
                    map.get(l).add(p);
                }
                else if(!map.containsKey(l)){
                    TreeSet<Integer> set = new TreeSet<>();
                    set.add(p);
                    map.put(l, set);
                }
            }
            else if(command.equals("recommend")){
                int command2 = Integer.parseInt(st.nextToken());
                if(command2 == 1){
                    TreeSet<Integer> set = map.get(map.lastKey());
                    sb.append(set.last()).append("\n");
                }
                else if(command2 == -1){
                    TreeSet<Integer> set = map.get(map.firstKey());
                    sb.append(set.first()).append("\n");
                }
            }
            else if(command.equals("solved")){
                int p = Integer.parseInt(st.nextToken()); // 문제 번호 삭제
                int l = map2.get(p); // 문제 난이도 가져오기
                map2.remove(p);
                TreeSet<Integer> set = map.get(l);
                set.remove(Integer.valueOf(p));
                if(set.isEmpty()){
                    map.remove(l);
                }
            }
        }
        System.out.println(sb);
    }
}
/*
ony9402는 최근 깃헙에 코딩테스트 대비 문제를 직접 뽑아서 "문제 번호, 난이도"로 정리해놨다.
깃헙을 이용하여 공부하시는 분들을 위해 새로운 기능을 추가해보려고 한다.
만들려고 하는 명령어는 총 3가지가 있다. 아래 표는 각 명령어에 대한 설명이다.

x가 1인 경우 추천 문제 리스트에서 가장 어려운 문제의 번호를 출력한다.
만약 가장 어려운 문제가 여러 개라면 문제 번호가 큰 것으로 출력한다.
x가 -1인 경우 가장 쉬운 문제의 번호를 출력한다. 만약 가장 쉬운 문제가 여러 개라면 문제 번호가 작은 것으로 출력한다.

add P L 추천 문제 리스트에 난이도 L인 문제 번호 P를 추가한다. 추천 문제 리스트에 없는 문제 번호 P만 입력으로 주어진다.

solved P 추천 문제 리스트에서 문제 번호 P를 제거한다. (추천 문제 리스트에 있는 문제 번호 P만 입력으로 주어진다.)

recommend 명령이 주어질 때마다 문제 번호를 한 줄씩 출력한다. 최소 한번의 recommend 명령어가 들어온다.

 */