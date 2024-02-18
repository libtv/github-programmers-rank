package org.example.BarkingDog.YouTube_26_TopologicalSorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 계보 복원가 호석 골드2
public class BJ21276 {
    static StringTokenizer st;
    static ArrayList<Integer>[] graph1;
    static StringBuilder sb;
    static int [] depth;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine()); // 석호촌에 살고 있는 사람의 수 n

        ArrayList<String> people = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>(); // 이름 <-> 번호
        HashMap<Integer, String> map2 = new HashMap<>(); // 번호 <-> 이름

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            String name = st.nextToken();
            map.put(name , i + 1);
            map2.put(i + 1, name);
            people.add(name);
        }
        graph1 = new ArrayList[n+1];
        for (int i = 0; i <= n; i++) {  // 그래프 초기화
            graph1[i] = new ArrayList<>();
        }

        int [] InDegree = new int[n+1]; // 위상 정렬을 위한 in degree
        int m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            String name1 = st.nextToken();
            String name2 = st.nextToken();
            int one = map.get(name1);
            int two = map.get(name2);
            InDegree[two]++;
            graph1[one].add(two);
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            if(InDegree[i] == 0){
                q.add(i);
            }
        }
        ArrayList<String> ancestor = new ArrayList<>(); // 조상 각 트리의 루트

        HashMap<Integer, ArrayList<Integer>> map3 = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            map3.put(i, new ArrayList<>());
        }

        while (!q.isEmpty()){
            int cur = q.poll();
            if(graph1[cur].isEmpty()){
                ancestor.add(map2.get(cur));
            }
            for (int next : graph1[cur]) {
                InDegree[next]--;
                ArrayList<Integer> parent = map3.get(next);
                for (int child :map3.get(cur)) {
                    if(parent.contains(child)){
                        parent.remove(Integer.valueOf(child));
                    }
                }
                parent.add(cur);
                if(InDegree[next] == 0){
                    q.add(next);
                }
            }
        }
        sb = new StringBuilder();
        Collections.sort(ancestor); // 사전 순서대로 정렬
        Collections.sort(people);

        depth = new int[n+1];

        sb.append(ancestor.size()).append("\n");
        for (String target: ancestor) {
            sb.append(target).append(" ");
        }
        sb.append("\n");

        int size = people.size();
        for (int i = 0; i < size; i++) {
             String target = people.get(i);
             int num = map.get(target);
             ArrayList<Integer> list = map3.get(num);
             sb.append(target).append(" ").append(list.size()).append(" ");
             ArrayList<String> names = new ArrayList<>();
             for (int next : list) {
                names.add(map2.get(next));
             }
             Collections.sort(names);
            for (String name: names) {
                sb.append(name).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}


/*
또한, 각 가문은 한 명의 시조를 root로 하는 트리 형태를 띈다는 것도 알아냈다. 이 때 "조상"이란, "자신의 부모"와 "부모의 조상"을 모두 합친 것을 의미한다.
이를 기반으로 몇 개의 가문이 존재했는 지, 각 가문에 대한 정보를 출력하는 프로그램을 작성해서 호석이를 도와주자!

세번째 줄부터는 이름의 사전순 대로 사람의 이름과 자식의 수, 그리고 사전순으로 자식들의 이름을 공백으로 구분하여 출력하라.
 */

/*
graph 1 : 위상 정렬로 조상을 찾기 위한 그래프

graph 2 : 모든 간선 연결한 양방향 트리 그래프 depth가 낮은 친구들 부터 BFS를 진행해서 메모제이션 용도로 사용



 */




