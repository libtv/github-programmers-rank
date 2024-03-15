package BarkingDog.YouTube_26_TopologicalSorting;

import java.io.*;
import java.util.*;

// 줄 세우기 골드3
public class BJ2252 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String [] split = br.readLine().split(" ");
        int n = Integer.parseInt(split[0]); // 학생의 수
        int m = Integer.parseInt(split[1]); // m 키를 비교한 횟수
        // 두 학생의 번호 A, B가 주어진다. 이는 학생 A가 학생 B의 앞에 서야 한다는 의미이다.
        ArrayList<Integer>[] graph = new ArrayList[n+1];
        for (int i = 0; i <= n; i++) { // 그래프 초기화
            graph[i] = new ArrayList<>();
        }
        StringTokenizer st;
        while (m-->0){ // 비교
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            graph[A].add(B);
        }
        // indegree 배열 채우기
        int [] InDegree = new int[n+1];
        for (int i = 1; i <= n; i++) {
            for (int next: graph[i]) {
                InDegree[next] += 1;
            }
        }
        StringBuilder sb = new StringBuilder();
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            if(InDegree[i] == 0){
                q.add(i);
            }
        }
        while (!q.isEmpty()){
            int cur = q.poll();
            sb.append(cur).append(" ");
            for (int next: graph[cur]) {
                InDegree[next]--;
                if(InDegree[next] == 0)
                    q.add(next);
            }
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
/*
N명의 학생들을 키 순서대로 줄을 세우려고 한다.
각 학생의 키를 직접 재서 정렬하면 간단하겠지만, 마땅한 방법이 없어서 두 학생의 키를 비교하는 방법을 사용하기로 하였다.
그나마도 모든 학생들을 다 비교해 본 것이 아니고, 일부 학생들의 키만을 비교해 보았다.
일부 학생들의 키를 비교한 결과가 주어졌을 때, 줄을 세우는 프로그램을 작성하시오.
 */