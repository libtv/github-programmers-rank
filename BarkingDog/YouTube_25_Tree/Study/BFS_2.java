package BarkingDog.YouTube_25_Tree.Study;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

// BFS 예시 코드 2 - 부모 + depth 배열 채우기
public class BFS_2 {
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

        // 시작 노드 (root 노드) 1이라고 가정
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        while (!q.isEmpty()){
            int cur = q.poll();
            for (int child : list[cur]) {
                if(parent[child] == 0){
                    q.offer(child);
                    parent[child] = cur;  // 부모 정보를 저장
                    depth[child] = depth[cur] + 1; // depth를 저장
                }
            }
        }

    }
}
// 자식의 depth는 부모의 depth + 1