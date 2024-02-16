package org.example.BarkingDog.YouTube_25_Tree;

import java.io.*;
import java.util.*;

// 회사 문화1 골드4
public class BJ14267_TimeOut {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String [] split = br.readLine().split(" ");
        int n = Integer.parseInt(split[0]); // 회사의 직원 수 n명
        int m = Integer.parseInt(split[1]); // 칭찬 횟수 m
        ArrayList<Integer>[] graph = new ArrayList[n+1];
        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            int input = Integer.parseInt(st.nextToken());
            if(i == 1) continue;
            graph[i].add(input);
            graph[input].add(i);
        }
        int [] depth = new int[n+1];
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        while (!q.isEmpty()){
            int cur = q.poll();
            for (int next: graph[cur]) {
                if(depth[next] == 0){
                    q.add(next);
                    depth[next] = depth[cur] + 1;
                }
            }
        }
        int [] scores = new int[n+1];
        while (m-->0){
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int target = Integer.parseInt(st2.nextToken()); // 칭찬을 받는 직원
            int num = Integer.parseInt(st2.nextToken()); // 창찬점수
            q.add(target);
            scores[target] += num;
            while (!q.isEmpty()){
                int cur = q.poll();
                for (int next: graph[cur]) {
                    if(depth[next] > depth[cur]){
                        q.add(next);
                        scores[next] += num;
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            if(i == 1) {
                sb.append(0).append(" ");
                continue;
            }
            sb.append(scores[i]).append(" ");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
/*
영선회사에는 매우 좋은 문화가 있는데, 바로 상사가 직속 부하를 칭찬하면 그 부하가 부하의 직속 부하를 연쇄적으로 칭찬하는 내리 칭찬이 있다.
즉, 상사가 한 직속 부하를 칭찬하면 그 부하의 모든 부하들이 칭찬을 받는다.
모든 칭찬에는 칭찬의 정도를 의미하는 수치가 있는데, 이 수치 또한 부하들에게 똑같이 칭찬 받는다.
직속 상사와 직속 부하관계에 대해 주어지고, 칭찬에 대한 정보가 주어질 때, 각자 얼마의 칭찬을 받았는지 출력하시오.

 */