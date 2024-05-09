package boj.BarkingDog_Collection.BinarySearchTree;

// 이중 우선순위 큐 골드4
import java.io.*;
import java.util.*;
public class BOJ7662 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        while (t-->0){
            int n = Integer.parseInt(br.readLine());
            TreeSet<Integer> set = new TreeSet<>();
            HashMap<Integer, Integer> map = new HashMap<>();
            while (n-->0){
                st = new StringTokenizer(br.readLine());
                String action = st.nextToken();
                int target = Integer.parseInt(st.nextToken());
                if(action.equals("I")){
                    set.add(target);
                    map.put(target, map.getOrDefault(target, 0) + 1);
                }
                else{ // D
                    if(set.isEmpty()) continue;

                    if(target == -1){
                        int cur = set.first();
                        int cnt = map.getOrDefault(cur, 0);
                        map.put(cur, --cnt);
                        if(cnt == 0) set.remove(cur);
                    }
                    else{
                        int cur = set.last();
                        int cnt = map.getOrDefault(cur, 0);
                        map.put(cur, --cnt);
                        if(cnt == 0) set.remove(cur);
                    }
                }
            }
            if(set.isEmpty()){
                sb.append("EMPTY");
            }
            else{
                sb.append(set.last()).append(" ").append(set.first());
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
