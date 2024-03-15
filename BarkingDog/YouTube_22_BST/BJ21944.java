package BarkingDog.YouTube_22_BST;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.TreeSet;

// 문제 추천 시스템 Version 2 골드2
class Problem{
    int L, G;
    public Problem(int L, int G){
        this.L = L;
        this.G = G;
    }
}
public class BJ21944 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        // key : 알고리즘 분류  (key : 난이도 value : 문제번호) recommend1 을 위한 map
        HashMap<Integer, TreeMap<Integer, TreeSet<Integer>>> map1 = new HashMap<>();
        // key : 난이도 value 문제 번호 recommend2, recommend3 위한 map
        TreeMap<Integer, TreeSet<Integer>> map2 = new TreeMap<>();
        // key : 문제 번호 value : L, G
        HashMap<Integer, Problem> map3 = new HashMap<>();
        while (n-->0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int P = Integer.parseInt(st.nextToken()); // 문제 번호
            int L = Integer.parseInt(st.nextToken()); // 문제 난이도
            int G = Integer.parseInt(st.nextToken()); // 알고리즘 분류 G
            if(map1.containsKey(G)){
                TreeMap<Integer, TreeSet<Integer>> temp = map1.get(G);
                if(temp.containsKey(L)){
                    temp.get(L).add(P);
                }
                else{
                    TreeSet<Integer> set = new TreeSet<>();
                    set.add(P);
                    temp.put(L , set);
                }
            }
            else{
                TreeSet<Integer> set = new TreeSet<>();
                set.add(P);
                TreeMap<Integer,TreeSet<Integer>> temp = new TreeMap<>();
                temp.put(L, set);
                map1.put(G, temp);
            }
            if (map2.containsKey(L)) {
                map2.get(L).add(P);
            }
            else{
                TreeSet<Integer> set = new TreeSet<>();
                set.add(P);
                map2.put(L , set);
            }
            map3.put(P, new Problem(L, G));
        }

        int m = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (m-->0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            if(str.equals("add")){
                int P = Integer.parseInt(st.nextToken()); // 문제 번호
                int L = Integer.parseInt(st.nextToken()); // 문제 난이도
                int G = Integer.parseInt(st.nextToken()); // 알고리즘 분류 G
                if(map1.containsKey(G)){
                    TreeMap<Integer, TreeSet<Integer>> temp = map1.get(G);
                    if(temp.containsKey(L)){
                        temp.get(L).add(P);
                    }
                    else{
                        TreeSet<Integer> set = new TreeSet<>();
                        set.add(P);
                        temp.put(L , set);
                    }
                }
                else{
                    TreeSet<Integer> set = new TreeSet<>();
                    set.add(P);
                    TreeMap<Integer,TreeSet<Integer>> temp = new TreeMap<>();
                    temp.put(L, set);
                    map1.put(G, temp);
                }
                if (map2.containsKey(L)) {
                    map2.get(L).add(P);
                }
                else{
                    TreeSet<Integer> set = new TreeSet<>();
                    set.add(P);
                    map2.put(L , set);
                }
                map3.put(P, new Problem(L, G));
            }
            else if(str.equals("solved")){
                int P = Integer.parseInt(st.nextToken());
                int L = map3.get(P).L;
                int G = map3.get(P).G;
                map3.remove(P);
                map2.get(L).remove(Integer.valueOf(P));
                if(map2.get(L).isEmpty()){
                    map2.remove(L);
                }
                map1.get(G).get(L).remove(Integer.valueOf(P));
                if(map1.get(G).get(L).isEmpty()){
                    map1.get(G).remove(L);
                }
                if(map1.get(G).isEmpty()){
                    map1.remove(G);
                }
            }
            else if(str.equals("recommend")){
                int G = Integer.parseInt(st.nextToken()); // 알고리즘 분류
                int temp = Integer.parseInt(st.nextToken());
                if(temp == 1){
                    int L = map1.get(G).lastKey();
                    sb.append(map1.get(G).get(L).last()).append("\n");
                }
                else if(temp == -1){
                    int L = map1.get(G).firstKey();
                    sb.append(map1.get(G).get(L).first()).append("\n");
                }
            }
            else if(str.equals("recommend2")){
                int temp = Integer.parseInt(st.nextToken());
                if(temp == 1){
                    int L = map2.lastKey();
                    sb.append(map2.get(L).last()).append("\n");
                }
                else if(temp == -1){
                    int L = map2.firstKey();
                    sb.append(map2.get(L).first()).append("\n");
                }
            }
            else if(str.equals("recommend3")){
                int temp = Integer.parseInt(st.nextToken());
                if(temp == 1){
                    int L = Integer.parseInt(st.nextToken());
                    Integer target = map2.ceilingKey(L);
                    if(target == null){
                        sb.append(-1).append("\n");
                    }
                    else{
                        sb.append(map2.get(target).first()).append("\n");
                    }
                }
                else if(temp == -1){
                    int L = Integer.parseInt(st.nextToken());
                    Integer target = map2.lowerKey(L);
                    if(target == null){
                        sb.append(-1).append("\n");
                    }
                    else if(target != null){
                        sb.append(map2.get(target).last()).append("\n");
                    }
                }
            }
        }
        System.out.println(sb);
    }
}
/*
// 문제번호 난이도 알고리즘 분류

recommend1 1 : 알고리즘 분류 G인 문제 중 가장 어려운 문제 번호를 출력. 가장 큰 문제 번호
           -1 : 알고리즘 분류 G인 문제 중 가장 쉬운 문제 가장 작은
HashMap : key 알고리즘 분류 value TreeMap()  key 난이도 value TreeSet()

recommend2 1 : 알고리즘 분류 상관x 가장 어려운 문제 번호 여러개라면 문제 번호가 가장 큰 것으로 출력 -1 은 반대
recommend3 1 : 난이도가 L보다 크거나 같은 문제 중 가장 쉬운 문제 조건을 만족하는 문제가 여러개 문제 번호가 가장 작은 것
               없다면 -1 출력

          -1 : 난이도가 L보다 작은 문제 중 가장 어려운 문제 조건을 만족하는 문제 여러개 가장 큰 문제 번호 없다면 -1을 출력

solved P : 추천 문제 리스트에서 문제 번호 P 제거
add P L G : 문제번호 P 난이도 L 알고리즘 분류 G 문제 추가


 */