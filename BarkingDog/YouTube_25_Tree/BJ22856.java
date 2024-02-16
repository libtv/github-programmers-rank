package org.example.BarkingDog.YouTube_25_Tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 트리 순회 골드4
public class BJ22856 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 노드의 개수
        int [] lc = new int[n+1];
        int [] rc = new int[n+1];
        for (int i = 0; i < n ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int current = Integer.parseInt(st.nextToken());
            int left = Integer.parseInt(st.nextToken());
            int right = Integer.parseInt(st.nextToken());
            if(left >= 1){
                lc[current] = left;
            }
            if(right >= 1){
                rc[current] = right;
            }
        }
        int count = 0;
        Queue<go> q = new LinkedList<>();
        q.add(new go(1, false));
        while (!q.isEmpty()){
            go go = q.poll();
            int cur = go.cur;
            boolean flag = go.flag;
            if(rc[cur]!=0){
                count += flag ? 2 : 1;
                q.add(new go(rc[cur], flag));
            }
            if(lc[cur]!=0){
                if(!flag) flag = true;
                count += 2;
                q.add(new go(lc[cur], flag));
            }
        }
        System.out.println(count);
    }
}
class go{
    int cur;
    boolean flag;
    public go(int cur , boolean flag){
        this.cur = cur;
        this.flag = flag;
    }
}