package boj.BarkingDog_Collection.BinarySearchTree;

// 문제 추천 시스템 Version 1 골드4
import java.util.*;
import java.io.*;
public class BOJ21939 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        TreeMap<Integer,TreeSet<Integer>> treeMap = new TreeMap<>(); // level, 번호
        int [] memo = new int[100001]; // 번호 레벨
        int n = Integer.parseInt(br.readLine());
        while (n --> 0){
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken()); // 문제 번호
            int l = Integer.parseInt(st.nextToken()); // 문제 난이도
            memo[p] = l;
            if(treeMap.containsKey(l)){
                treeMap.get(l).add(p);
            }
            else{
                TreeSet<Integer> treeSet = new TreeSet<>();
                treeSet.add(p);
                treeMap.put(l , treeSet);
            }
        }
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (t-->0){
            // System.out.println(treeMap);
            st = new StringTokenizer(br.readLine());
            String action = st.nextToken();
            if(action.equals("add")){
                int p = Integer.parseInt(st.nextToken());
                int l = Integer.parseInt(st.nextToken());
                memo[p] = l;
                if(treeMap.containsKey(l)){
                    treeMap.get(l).add(p);
                }
                else{
                    TreeSet<Integer> treeSet = new TreeSet<>();
                    treeSet.add(p);
                    treeMap.put(l , treeSet);
                }
            }
            else if(action.equals("recommend")){
                int num = Integer.parseInt(st.nextToken());
                if(num == 1){
                    int target = treeMap.lastKey();
                    sb.append(treeMap.get(target).last());
                }
                else{
                    int target = treeMap.firstKey();
                    sb.append(treeMap.get(target).first());
                }
                sb.append("\n");
            }
            else{ // solved
                int target = Integer.parseInt(st.nextToken());
                int l = memo[target];
                treeMap.get(l).remove(Integer.valueOf(target));
                if(treeMap.get(l).isEmpty()) treeMap.remove(l);
            }
        }
        System.out.println(sb);
    }
}
