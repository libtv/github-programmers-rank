package boj.BarkingDog_Collection.Tree;

// 트리 순회 실버1
import java.util.*;
import java.io.*;
public class BOJ1991_Node {
    static StringBuilder sb = new StringBuilder();
    static class Node{
        String data;
        Node left;
        Node right;
        Node(String data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
        public void addLeft(Node node){
            this.left = node;
        }
        public void addRight(Node node){
            this.right = node;
        }
        public static void PreOrder(Node node){ // 선위 순회 루트 -> 왼쪽 -> 오른쪽
            if(node == null) return;
            sb.append(node.data);
            PreOrder(node.left);
            PreOrder(node.right);
        }

        public static void InOrder(Node node){ // 중위 순회  왼쪽 -> 루트 -> 오른쪽
            if(node == null) return;
            InOrder(node.left);
            sb.append(node.data);
            InOrder(node.right);
        }
        public static void PostOrder(Node node){ // 후위 순회 왼쪽 -> 오른쪽 -> 루트
            if(node == null) return;
            PostOrder(node.left);
            PostOrder(node.right);
            sb.append(node.data);
        }

    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        HashMap<String , Node> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String parent = st.nextToken();
            String left   = st.nextToken();
            String right  = st.nextToken();

            if(!map.containsKey(parent)){
                map.put(parent, new Node(parent));
            }
            if(!left.equals(".")){
                if(!map.containsKey(left)){
                    map.put(left, new Node(left));
                }
                map.get(parent).addLeft(map.get(left));
            }
            if(!right.equals(".")){
                if(!map.containsKey(right)){
                    map.put(right, new Node(right));
                }
                map.get(parent).addRight(map.get(right));
            }
        }
        Node.PreOrder(map.get("A"));
        sb.append("\n");
        Node.InOrder(map.get("A"));
        sb.append("\n");
        Node.PostOrder(map.get("A"));

        System.out.println(sb);
    }
}
/*
이진 트리를 입력받아
전위 순회(preorder traversal), 중위 순회(inorder traversal), 후위 순회(postorder traversal)한
결과를 출력하는 프로그램을 작성하시오.
 */