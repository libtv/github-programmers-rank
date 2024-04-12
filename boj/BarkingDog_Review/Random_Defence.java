package boj.BarkingDog_Review;

/* 백준 실버~골드
Array, Linked_List, Stack, Queue, Deque, StackUses, BFS, DFS, Recursion, BackTracking
Sort1, Sort2, DP, Greedy 복습용
 */
import java.io.*;
import java.util.*;
public class Random_Defence {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Set<Integer> set = new HashSet<>();
        while (true){
            int input = Integer.parseInt(br.readLine());
            set.add(input);
            if(input == 0) break;
        }
        System.out.println(set.size());
        Iterator<Integer> it = set.iterator();
        while (it.hasNext()){
            System.out.println(it.next());
        }
    }
}
/*       49문제 --> 하루에 4시간 투자 시간 체크하기!
11652    PASS 20분
1799     PASS 58분
11660    PASS 9분
2447
2448
7570     PASS 10분
17298
8980
5014
13335
16920
2457
2206
9251
1700
14501
10799
2482
1074
14002
6198
2493
10942
11967
9663
1744
11729
4179
2133
2011
1629
2156
9328
1520
17140
2293
17142
1398
2294
17143
1912
11000
18809
9466
2170
1915
2302
15486
4991
 */








