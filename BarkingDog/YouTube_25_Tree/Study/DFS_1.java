package org.example.BarkingDog.YouTube_25_Tree.Study;

import java.util.ArrayList;
import java.util.Stack;

// DFS 예시 코드 1 - 부모와 depth 배열 채우기, 비재귀
public class DFS_1 {
    public static void main(String[] args) {
        // 그래프 생성
        ArrayList<Integer>[] list = new ArrayList[10]; // 보통 정점의 개수 + 1로 만든다.
        // 그래프 초기화
        for (int i = 0; i <= 9 ; i++) {
            list[i] = new ArrayList<>();
        }
        // 그래프 간선 추가 생략

        // 각 노드의 부모 정보를 저장하는 parent 배열 생성
        int [] parent = new int[10];

        // 각 노드의 depth를 저장하는 depth 배열 생성  루트의 depth는 0
        int [] depth = new int[10];

        Stack<Integer> stack = new Stack<>();
        stack.push(1); // 루트 노드

        while (!stack.isEmpty()){
            int cur = stack.pop();
            for (int next :list[cur]) {
                if(parent[next] == 0){
                    stack.push(next);
                    parent[next] = cur;           // 부모 정보 저장
                    depth[next] = depth[cur] + 1; // depth 저장
                }
            }
        }
    }
}
