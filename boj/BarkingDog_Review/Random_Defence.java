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
17298    PASS 10분
8980     PASS 25분
5014     PASS 09분
13335    PASS 14분
16920    내 풀이 참고 -> REJECT
2457     PASS 62분
2206     PASS 31분
9251     PASS 30분
1700     PASS 32분
14501    PASS 20분
10799    PASS 35분
2482     REJECT 풀긴 풀었는데 2시간 걸림
1074     PASS 28분
14002    PASS 16분
6198     PASS 29분
2493     PASS 12분
10942    PASS 9분
11967    PASS 31분
9663     PASS 15분
1744     PASS 32분
11729
4179     PASS 31분
2133
2011     REJECT
1629     PASS 17분
2156     PASS 15분
9328     PASS 52분
1520     PASS 21분
17140    PASS 57분
2293     PASS
17142    PASS
1398     REJECT
2294     PASS
17143
1912     PASS
11000    PASS
18809
9466
2170
1915
2302
15486
4991
 */








