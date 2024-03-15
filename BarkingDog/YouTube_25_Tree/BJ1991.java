package BarkingDog.YouTube_25_Tree;

import java.io.*;
import java.util.StringTokenizer;

// 트리 순회 실버1
public class BJ1991 {
    static StringBuilder sb = new StringBuilder();
    static int [] lc;
    static int [] rc;
    public static void main(String[] args) throws IOException {
        // System.out.println((int)'.'); 46
        // System.out.println((int)'A'); 65
        // System.out.println((int)'Z'); 90
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        lc = new int[100];
        rc = new int[100];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String parent = st.nextToken();
            String left = st.nextToken();
            String right = st.nextToken();
            int temp = (int) parent.charAt(0);
            lc[temp] = (int) left.charAt(0);
            rc[temp] = (int) right.charAt(0);
        }
        preorder(65);
        sb.append("\n");
        inorder(65);
        sb.append("\n");
        postorder(65);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
    public static void preorder(int x){ // 전위 순회  정점 왼쪽 오른쪽
        sb.append((char)x);
        if(lc[x]!=46) preorder(lc[x]);
        if(rc[x]!=46) preorder(rc[x]);
    }
    public static void inorder(int x){  // 중위 순회  왼쪽 정점 오른쪽
        if(lc[x]!=46) inorder(lc[x]);
        sb.append((char)x);
        if(rc[x]!=46) inorder(rc[x]);
    }
    public static void postorder(int x){ // 후위 순회 왼쪽 오른쪽 정점
        if(lc[x]!=46) postorder(lc[x]);
        if(rc[x]!=46) postorder(rc[x]);
        sb.append((char)x);
    }
}
/*
이진 트리를 입력받아 전위 순회(preorder traversal), 중위 순회(inorder traversal), 후위 순회(postorder traversal)한 결과를 출력하는 프로그램을 작성하시오.
 */