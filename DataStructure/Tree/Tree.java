package DataStructure.Tree;

public class Tree {
    static class Node{
        int data;
        Node left;
        Node right;

        public Node(int data){
            this.data  = data;
            this.left  = null;
            this.right = null;
        }
        public void addLeft(Node node){
            this.left = node;
        }
        public void addRight(Node node){
            this.right = node;
        }

        public static void PreOrder(Node node){ // 전위 순회
            if(node == null) return;
            System.out.println(node.data);
            PreOrder(node.left);
            PreOrder(node.right);
        }
        public static void InOrder(Node node){ // 중위 순회
            if(node == null) return;
            InOrder(node.left);
            System.out.println(node.data);
            InOrder(node.right);
        }
        public static void PostOrder(Node node){ // 후위 순회
            if(node == null) return;
            PostOrder(node.left);
            PostOrder(node.right);
            System.out.println(node.data);
        }
    }
    /*
             1
         2       3
       4   5    6  7
             8
     */
    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        Node node7 = new Node(7);
        Node node8 = new Node(8);

        node1.addLeft(node2);
        node1.addRight(node3);

        node2.addLeft(node4);
        node2.addRight(node5);

        node5.addRight(node8);

        node3.addLeft(node6);
        node3.addRight(node7);

        Node.PreOrder(node1);
        System.out.println("------");
        Node.InOrder(node1);
        System.out.println("------");
        Node.PostOrder(node1);

    }
}
