package boj.BarkingDog_Collection.BinarySearchTree;

// 문제 추천 시스템 Version2

import java.util.*;
import java.io.*;
public class BOJ21944 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine()); // 문제의 개수 n

        /**
         * 1. key : 문제번호 value : int [] : 난이도, 알고리즘     HashMap<Integer, int[]>
         * 2. key : 알고리즘 분류 value :  key : 난이도 value : 문제 번호  TreeMap<Integer, TreeMap<Integer, TreeSet<Integer>>>
         * 3. key : 난이도 value : 문제번호 TreeMap<Integer, TreeSet<Integer>>
         * map1, map2, map3
         */
        HashMap<Integer, int []> map1 = new HashMap<>();
        TreeMap<Integer, TreeMap<Integer, TreeSet<Integer>>> map2 = new TreeMap<>();
        TreeMap<Integer, TreeSet<Integer>> map3 = new TreeMap<>();

        while (n -->0){
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken()); // 문제 번호
            int l = Integer.parseInt(st.nextToken()); // 문제 난이도
            int g = Integer.parseInt(st.nextToken()); // 알고리즘 분류

            map1.put(p, new int[]{l, g});

            if(map2.containsKey(g)){
                TreeMap<Integer, TreeSet<Integer>> temp = map2.get(g);
                if(temp.containsKey(l)){
                    temp.get(l).add(p);
                }
                else{
                    TreeSet<Integer> treeSet = new TreeSet<>();
                    treeSet.add(p);
                    temp.put(l, treeSet);
                }
            }
            else{
                TreeMap<Integer, TreeSet<Integer>> temp = new TreeMap<>();
                TreeSet<Integer> treeSet = new TreeSet<>();
                treeSet.add(p);
                temp.put(l, treeSet);
                map2.put(g, temp);
            }

            if(map3.containsKey(l)){
                map3.get(l).add(p);
            }
            else{
                TreeSet<Integer> treeSet = new TreeSet<>();
                treeSet.add(p);
                map3.put(l, treeSet);
            }
        }

        int m = Integer.parseInt(br.readLine()); // 명령어의 개수
        StringBuilder sb = new StringBuilder();
        while (m-->0){
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            if(command.equals("recommend")){
                int g = Integer.parseInt(st.nextToken()); // 알고리즘 분류
                int x = Integer.parseInt(st.nextToken()); // 1 or -1
                TreeMap<Integer, TreeSet<Integer>> temp = map2.get(g);
                if(x == 1){
                    int last = temp.lastKey(); // 가장 높은 난이도
                    sb.append(temp.get(last).last());
                }
                else{ // -1
                    int first = temp.firstKey(); // 가장 낮은 난이도
                    sb.append(temp.get(first).first());
                }
                sb.append("\n");
            }
            else if(command.equals("recommend2")){
                int x = Integer.parseInt(st.nextToken());
                if(x == 1){
                    int l = map3.lastKey();
                    sb.append(map3.get(l).last());
                }
                else{ // - 1
                    int l = map3.firstKey();
                    sb.append(map3.get(l).first());
                }
                sb.append("\n");
            }
            else if(command.equals("recommend3")){
                int x = Integer.parseInt(st.nextToken());
                int le = Integer.parseInt(st.nextToken());
                if(x == 1){
                    Integer l = map3.ceilingKey(le); // 크거나 같은
                    if(l == null){
                        sb.append("-1");
                    }
                    else{
                        sb.append(map3.get(l).first());
                    }
                }
                else{ // -1
                    Integer l = map3.lowerKey(le); // 작은
                    if(l == null){
                        sb.append("-1");
                    }
                    else{
                        sb.append(map3.get(l).last());
                    }
                }
                sb.append("\n");
            }
            else if(command.equals("add")){
                int p = Integer.parseInt(st.nextToken()); // 문제 번호
                int l = Integer.parseInt(st.nextToken()); // 문제 난이도
                int g = Integer.parseInt(st.nextToken()); // 알고리즘 분류

                map1.put(p, new int[]{l, g});

                if(map2.containsKey(g)){
                    TreeMap<Integer, TreeSet<Integer>> temp = map2.get(g);
                    if(temp.containsKey(l)){
                        temp.get(l).add(p);
                    }
                    else{
                        TreeSet<Integer> treeSet = new TreeSet<>();
                        treeSet.add(p);
                        temp.put(l, treeSet);
                    }
                }
                else{
                    TreeMap<Integer, TreeSet<Integer>> temp = new TreeMap<>();
                    TreeSet<Integer> treeSet = new TreeSet<>();
                    treeSet.add(p);
                    temp.put(l, treeSet);
                    map2.put(g, temp);
                }

                if(map3.containsKey(l)){
                    map3.get(l).add(p);
                }
                else{
                    TreeSet<Integer> treeSet = new TreeSet<>();
                    treeSet.add(p);
                    map3.put(l, treeSet);
                }
            }
            else{ // solved
                int p = Integer.parseInt(st.nextToken());
                int l = map1.get(p)[0];
                int g = map1.get(p)[1];
                map1.remove(Integer.valueOf(p));
                TreeSet<Integer> treeSet = map3.get(l);
                treeSet.remove(Integer.valueOf(p));
                if(treeSet.isEmpty()){
                    map3.remove(Integer.valueOf(l));
                }
                TreeMap<Integer, TreeSet<Integer>> treeMap = map2.get(g);
                TreeSet<Integer> set = treeMap.get(l);
                set.remove(Integer.valueOf(p));
                if(set.isEmpty()){
                    treeMap.remove(Integer.valueOf(l));
                }
                if(treeMap.isEmpty()){
                    map2.remove(Integer.valueOf(g));
                }
            }
        }
        System.out.println(sb);
    }
}
/*

알고리즘 분류, 난이도, 문제 번호

recommend G x : 1
알고리즘 분류 : G 가장 어려운 문제 여러 개라면 그 중 문제 번호가 큰 것

recommend G x : -1
알고리즘 분류 : G 가장 쉬운 문제 / 여러 개라면 그 중 문제 번호가 가장 작은 것

recommend2 x : 1
알고리즘 분류 상관 x 가장 어려운 문제 / 여러 개라면 그 중 문제 번호가 큰 것

recommend2 x : -1
알고리즘 분류 상관 x 가장 쉬운 문제 / 여러 개라면 그 중 문제 번호가 가장 작은 것

recommend3 x L (x : 1)
알고리즘 분류 상관 x 난이도가 l보다 크거나 같은 문제 중 가장 쉬운 문제 번호 여러 개라면 가장 작은 것 없으면 -1

recommend3 x L (x : -1)
알고리즘 분류 상관 x 난이도가 l보다 낮은 문제 중 가장 어려운 문제 번호 여러 개라면 가장 큰 것 없으면 -1

add P L G
난이도 L G P 추가

solved P
문제 번호 P 제거 (추천 문제 리스트에 있는 문제 번호만 주어진다.)

 */