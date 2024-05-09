package DataStructure.BinarySearchTree.TreeMap;

import java.util.Collections;
import java.util.TreeMap;

public class TreeMapPractice {
    public static void main(String[] args) {
        TreeMap<Integer, Integer> treeMap = new TreeMap<>(Collections.reverseOrder());
        treeMap.comparator();
    }
}
