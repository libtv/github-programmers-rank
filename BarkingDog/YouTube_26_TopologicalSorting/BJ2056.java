package BarkingDog.YouTube_26_TopologicalSorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 작업 골드4
public class BJ2056 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ArrayList<Integer>[] graph = new ArrayList[n+1];
        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        int [] times = new int[n+1];
        int [] InDegree = new int[n+1];
        StringTokenizer st;
        int cnt = 0;
        int number = n;
        while (number-->0){
            cnt++;
            st = new StringTokenizer(br.readLine());
            times[cnt] = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());
            while (num-->0){
                int target = Integer.parseInt(st.nextToken());
                InDegree[cnt]++;
                graph[target].add(cnt);
            }
        }
        // System.out.println(Arrays.toString(times));
        // System.out.println(Arrays.toString(InDegree));
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
             if(InDegree[i] == 0){
                 q.add(i);
             }
        }
        int [] time_max = new int[n+1];
        int max = 0;
        while (!q.isEmpty()){
            int cur = q.poll();
            boolean flag = false;
            for (int next: graph[cur]) {
                InDegree[next]--;
                time_max[next] = Math.max(time_max[next], time_max[cur] + times[cur]);
                if(InDegree[next] == 0){
                    q.add(next);
                    flag = true;
                }
            }
            if(!flag){
                time_max[cur] = time_max[cur] + times[cur];
            }
        }
        for (int i = 1; i <= n; i++) {
            max = Math.max(max, time_max[i]);
        }
        System.out.println(max);
    }
}

/*
수행해야 할 작업 N개 (3 ≤ N ≤ 10000)가 있다. 각각의 작업마다 걸리는 시간(1 ≤ 시간 ≤ 100)이 정수로 주어진다.
몇몇 작업들 사이에는 선행 관계라는 게 있어서, 어떤 작업을 수행하기 위해 반드시 먼저 완료되어야 할 작업들이 있다.
이 작업들은 번호가 아주 예쁘게 매겨져 있어서, K번 작업에 대해 선행 관계에 있는(즉, K번 작업을 시작하기 전에 반드시 먼저 완료되어야 하는) 작업들의 번호는 모두 1 이상 (K-1) 이하이다.
작업들 중에는, 그것에 대해 선행 관계에 있는 작업이 하나도 없는 작업이 반드시 하나 이상 존재한다. (1번 작업이 항상 그러하다)
모든 작업을 완료하기 위해 필요한 최소 시간을 구하여라. 물론, 서로 선행 관계가 없는 작업들은 동시에 수행 가능하다.

 */