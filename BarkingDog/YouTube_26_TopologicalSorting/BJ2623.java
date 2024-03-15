package BarkingDog.YouTube_26_TopologicalSorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 음악프로그램 골드3
public class BJ2623 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String [] split = br.readLine().split(" ");
        int n = Integer.parseInt(split[0]); // 가수의 수
        int m = Integer.parseInt(split[1]); // pd 수 m
        ArrayList<Integer>[] graph = new ArrayList[n+1];
        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        StringTokenizer st;
        int [] InDegree = new int[n+1];
        while (m-->0){
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int before = 0;
            while (num-->0){
                  int target = Integer.parseInt(st.nextToken());
                  if(before == 0){
                      before = target;
                      continue;
                  }
                  graph[before].add(target);
                  InDegree[target]++;
                  before = target;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            if(InDegree[i] == 0){
                q.add(i);
            }
        }
        StringBuilder sb = new StringBuilder();
        int count = 0;
        while (!q.isEmpty()){
            int cur = q.poll();
            sb.append(cur).append("\n");
            count ++;
            for (int next: graph[cur]) {
                InDegree[next]--;
                if(InDegree[next] == 0) q.add(next);
            }
        }
        if(count != n){
            System.out.println(0);
            return;
        }
        System.out.println(sb);
    }
}
/*
인터넷 방송 KOI(Korea Open Internet)의 음악 프로그램 PD인 남일이는 자기가 맡은 프로그램
'뮤직 KOI'에서 가수의 출연 순서를 정하는 일을 매우 골치 아파한다.
순서를 정하기 위해서는 많은 조건을 따져야 한다.

그래서 오늘 출연 예정인 여섯 팀의 가수에 대해서 남일이가 보조 PD 세 명에게 각자 담당한 가수의 출연 순서를 정해오게 하였다.
보조 PD들이 가져온 것은 아래와 같다.

1 4 3
6 2 5 4
2 3

 */