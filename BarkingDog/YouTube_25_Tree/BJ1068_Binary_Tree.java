package BarkingDog.YouTube_25_Tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 트리 골드5
public class BJ1068_Binary_Tree {
    static int [] lc;
    static int [] rc;
    static int [] parent;
    static int count;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 노드의 개수
        int root = 0; // 루트 노드
        parent = new int[n];
        lc = new int[n];
        rc = new int[n];
        Arrays.fill(rc, -1);
        Arrays.fill(lc, -1);
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int input = Integer.parseInt(st.nextToken());
            if(input == -1){
                root = i;
                continue;
            }
            if(lc[input] == -1){
                lc[input] = i;
            }
            else if(rc[input] == -1){
                rc[input] = i;
            }
            parent[i] = input;
        }
        int delete = Integer.parseInt(br.readLine());
        int mom = parent[delete];
        if(delete == root){
            System.out.println(0); // 루트 노드를 삭제하면 리프 노드 == 0
            return;
        }
        if(lc[mom] == delete){
            lc[mom] = -1;
        }
        else if(rc[mom] == delete){
            rc[mom] = -1;
        }
        DFS(root);
        System.out.println(count);

    }
    public static void DFS(int cur){
        if(lc[cur] != -1){
            DFS(lc[cur]);
        }
        if(rc[cur] != -1){
            DFS(rc[cur]);
        }

        if(lc[cur]==-1 && rc[cur]== -1){
            count++;
        }
    }
}
/*
트리에서 리프 노드란, 자식의 개수가 0인 노드를 말한다.
트리가 주어졌을 때, 노드 하나를 지울 것이다. 그 때, 남은 트리에서 리프 노드의 개수를 구하는 프로그램을 작성하시오.
노드를 지우면 그 노드와 노드의 모든 자손이 트리에서 제거된다.
 */