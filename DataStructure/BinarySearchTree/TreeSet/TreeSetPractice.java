package DataStructure.BinarySearchTree.TreeSet;

import java.util.Collections;
import java.util.Comparator;
import java.util.TreeSet;

/**
 * TreeSet Comparator 출력하기
 * 1. 기본
 * 2. custom
 * 3. Collections 제공
 */
public class TreeSetPractice {
    public static void main(String[] args) {

        /*
        TreeSet<Integer> treeSet = new TreeSet<>();
        System.out.println(treeSet.comparator());
        -> null
         */

       /* TreeSet<Integer> treeSet = new TreeSet<>((o1,o2)->{
            return -(o1-o2);
        });
        System.out.println(treeSet.comparator());
        -> DataStructure.BinarySearchTree.TreeSet.TreeSetPractice$$Lambda$16/0x0000000800c01a00@3b9a45b3
        */

        TreeSet<Integer> treeSet = new TreeSet<>(Collections.reverseOrder());
        System.out.println(treeSet.comparator());

    }
}
