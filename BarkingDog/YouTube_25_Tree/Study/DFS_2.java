package BarkingDog.YouTube_25_Tree.Study;

import java.util.ArrayList;

// DFS 예시 코드 2 - 부모와 depth 배열 채우기, 재귀
public class DFS_2 {
    static int [] parent;
    static int [] depth;
    static ArrayList<Integer>[] list;
    public static void main(String[] args) {
        list = new ArrayList[10];

        // 그래프 초기화
        for (int i = 0; i <= 9 ; i++) {
            list[i] = new ArrayList<>();
        }
        // 그래프 간선 추가 생략

        // 각 노드의 부모 정보를 저장하는 parent 배열 생성
        parent = new int[10];

        // 각 노드의 depth를 저장하는 depth 배열 생성  루트의 depth는 0
        depth = new int[10];

        DFS(1);

    }
    public static void DFS(int x){
        for (int next: list[x]) {
            if(parent[next] == 0){
                parent[next] = x;           // 부모 정보 저장
                depth[next] = depth[x] + 1; // depth 저장
                DFS(next);
            }
        }
    }
}


/*
만약 스택 메모리가 1MB로 제한되어 있을 땐 V가 대략 3만 이상일 때 1-2-3-4-5-6 .. 형태의 일자 트리 모양에서
스택 메모리의 한계를 넘어설 수 있기 때문에 스택 메모리에 대한 별도의 제한이 있을 때에는 주의해야 한다.
 */