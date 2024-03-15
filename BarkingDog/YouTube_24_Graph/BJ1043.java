package BarkingDog.YouTube_24_Graph;

import java.io.*;
import java.util.*;

// 거짓말 골드4
public class BJ1043 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String [] split = br.readLine().split(" ");
        int n = Integer.parseInt(split[0]); // 사람의 수 N
        int m = Integer.parseInt(split[1]); // 파티의 수 M
        ArrayList<Integer> know = new ArrayList<>();  // 맨 처음 진실을 아는 사람들 명단
        StringTokenizer ST = new StringTokenizer(br.readLine());
        int num = Integer.parseInt(ST.nextToken());
        while (num-->0){
            know.add(Integer.parseInt(ST.nextToken()));
        }
        ArrayList<Integer>[] list = new ArrayList[n+1]; // 그래프 (간선)
        for (int i = 0; i <= n; i++) {
            list[i] = new ArrayList<>();
        }
        ArrayList<Integer>[] party = new ArrayList[m]; //  각 파티에 참석하는 사람들 명단 기록
        int cnt = 0;
        for (int i = 0; i < m ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int number = Integer.parseInt(st.nextToken());
            ArrayList<Integer> temp = new ArrayList<>();
            for (int j = 0; j < number; j++) {
                temp.add(Integer.parseInt(st.nextToken()));
            }
            party[cnt] = temp;
            int size = temp.size();
            for (int j = 0; j < size; j++) {
                for (int k = j+1; k < size; k++) {
                    int a = temp.get(j);
                    int b = temp.get(k);
                    list[a].add(b);
                    list[b].add(a);
                }
            }
            cnt++;
        }
        // System.out.println(Arrays.toString(list));
        // System.out.println(Arrays.toString(party));
        boolean[] visited = new boolean[n+1];
        Set<Integer> check = new TreeSet<>();
        for (int i = 0; i < know.size(); i++) {
            int start = know.get(i);
            Queue<Integer> q = new LinkedList<>();
            visited[start] = true;
            q.add(start);
            while (!q.isEmpty()){
                int x = q.poll();
                int size = list[x].size();
                for (int j = 0; j < size; j++) {
                    int next = list[x].get(j);
                    if(!visited[next]){
                        q.add(next);
                        visited[next] = true;
                    }
                }
            }
        }
        for (int i = 1; i <= n; i++) {
            if(visited[i]){
                check.add(i);
            }
        }
        int count = 0;
        for (int i = 0; i < m ; i++) {
            ArrayList<Integer> temp = party[i];
            boolean flag = true;
            for (int target : temp) {
                if(check.contains(target)){
                    flag = false;
                    break;
                }
            }
            if(flag){
                count++;
            }
        }
        bw.write(String.valueOf(count));
        bw.flush();
        bw.close();
        br.close();
    }
}
/*
지민이는 파티에 가서 이야기 하는 것을 좋아한다. 파티에 갈 때마다, 지민이는 지민이가 가장 좋아하는 이야기를 한다.
지민이는 그 이야기를 말할 때, 있는 그대로 진실로 말하거나 엄청나게 과장해서 말한다.
당연히 과장해서 이야기하는 것이 훨씬 더 재미있기 때문에, 되도록이면 과장해서 이야기하려고 한다.
하지만, 지민이는 거짓말쟁이로 알려지기는 싫어한다.
문제는 몇몇 사람들은 그 이야기의 진실을 안다는 것이다. 따라서 이런 사람들이 파티에 왔을 때는, 지민이는 진실을 이야기할 수 밖에 없다.
당연히, 어떤 사람이 어떤 파티에서는 진실을 듣고, 또다른 파티에서는 과장된 이야기를 들었을 때도 지민이는 거짓말쟁이로 알려지게 된다.
지민이는 이런 일을 모두 피해야 한다.
사람의 수 N이 주어진다. 그리고 그 이야기의 진실을 아는 사람이 주어진다.
그리고 각 파티에 오는 사람들의 번호가 주어진다. 지민이는 모든 파티에 참가해야 한다.
이때, 지민이가 거짓말쟁이로 알려지지 않으면서, 과장된 이야기를 할 수 있는 파티 개수의 최댓값을 구하는 프로그램을 작성하시오.


 */