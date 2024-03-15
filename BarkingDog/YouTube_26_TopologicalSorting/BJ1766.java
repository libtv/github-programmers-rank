package BarkingDog.YouTube_26_TopologicalSorting;

import java.io.*;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 문제집 골드2
public class BJ1766 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String [] split = br.readLine().split(" ");

        int n = Integer.parseInt(split[0]); // 문제의 수
        int m = Integer.parseInt(split[1]); // 정보의 개수

        ArrayList<Integer>[] graph = new ArrayList[n+1]; // 그래프 선언
        for (int i = 0; i <= n; i++) { // 그래프 초기화
            graph[i] = new ArrayList<>();
        }

        StringTokenizer st;

        int [] InDegree = new int[n+1]; // InDegree 초기화

        while (m-->0){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            InDegree[b]++;
        }

        StringBuilder sb = new StringBuilder();

        PriorityQueue<Integer> pq = new PriorityQueue<>(); // 최소힙 우선순위 큐

        for (int i = 1; i <= n; i++) {
            if(InDegree[i] == 0){
                pq.add(i);
            }
        }

        boolean [] visited = new boolean[n+1];

        while (!pq.isEmpty()){
            int cur = pq.poll();
            visited[cur] = true;
            sb.append(cur).append(" ");
            for (int next : graph[cur]) {
                InDegree[next]--;
                if(InDegree[next] == 0){
                    pq.add(next);
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            if(!visited[i]){
                sb.append(i).append(" ");
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
/*
민오는 1번부터 N번까지 총 N개의 문제로 되어 있는 문제집을 풀려고 한다.
문제는 난이도 순서로 출제되어 있다. 즉 1번 문제가 가장 쉬운 문제이고 N번 문제가 가장 어려운 문제가 된다.

1번 문제를 풀고 나면 4번 문제가 쉽게 풀린다거나 하는 식이다.
민오는 다음의 세 가지 조건에 따라 문제를 풀 순서를 정하기로 하였다.

1. N개의 문제는 모두 풀어야 한다.
2. 먼저 푸는 것이 좋은 문제가 있는 문제는, 먼저 푸는 것이 좋은 문제를 반드시 먼저 풀어야 한다.
3. 가능하면 쉬운 문제부터 풀어야 한다.

예를 들어서 네 개의 문제가 있다고 하자.
4번 문제는 2번 문제보다 먼저 푸는 것이 좋고, 3번 문제는 1번 문제보다 먼저 푸는 것이 좋다고 하자.

4 -> 2
3 -> 1

Indegree : 0 은  3, 4
3 -> 1 -> 4 -> 2


 */