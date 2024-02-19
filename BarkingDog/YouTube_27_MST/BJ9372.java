package org.example.BarkingDog.YouTube_27_MST;


import java.util.*;
import java.io.*;
// 상근이의 여행 실버4
public class BJ9372 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine()); // 테스트 케이스 개수
        StringTokenizer st;
        while (t-->0){
            String [] split = br.readLine().split(" ");
            int n = Integer.parseInt(split[0]); // 국가의 수
            int m = Integer.parseInt(split[1]); // 비행기의 종류
            ArrayList<Integer>[] graph = new ArrayList[n+1]; // 그래프 생성
            for (int i = 0; i <= n; i++) { // 그래프 초기화
                graph[i] = new ArrayList<>();
            }
            while (m-->0) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                graph[a].add(b);
                graph[b].add(a);
            }
            boolean[] check = new boolean[n+1];
            Queue<Integer> q = new LinkedList<>();
            check[1] = true;
            for (int next: graph[1]) {
                q.add(next);
            }
            int ans = 0;
            while (!q.isEmpty()){
                int cur = q.poll();
                if(check[cur]) continue;
                check[cur] = true;
                ans++;
                for (int next: graph[cur]) {
                    if(!check[next]){
                        q.add(next);
                    }
                }
            }
            System.out.println(ans);
        }
    }
}
/*
상근이는 겨울방학을 맞아 N개국을 여행하면서 자아를 찾기로 마음먹었다.
하지만 상근이는 새로운 비행기를 무서워하기 때문에, 최대한 적은 종류의 비행기를 타고 국가들을 이동하려고 한다.
이번 방학 동안의 비행 스케줄이 주어졌을 때, 상근이가 가장 적은 종류의 비행기를 타고 모든 국가들을 여행할 수 있도록 도와주자.
상근이가 한 국가에서 다른 국가로 이동할 때 다른 국가를 거쳐 가도(심지어 이미 방문한 국가라도) 된다.
 */