package BarkingDog.YouTube_24_Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 구슬 찾기 골드4
public class BJ2617 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        int n = Integer.parseInt(split[0]);
        int m = Integer.parseInt(split[1]);
        ArrayList<Integer>[] list;
        int[][] arr = new int[m][2];
        int check = 0;
        while (m-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[check][0] = a;
            arr[check][1] = b;
            check++;
        }
        list = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < arr.length; i++) {
            int a = arr[i][0];
            int b = arr[i][1];
            list[a].add(b);
        }
        boolean[] visited;
        Set<Integer> ans = new HashSet<>();
        for (int i = 1; i <= n; i++) {
            visited = new boolean[n + 1];
            Queue<Integer> q = new LinkedList<>();
            q.add(i);
            visited[i] = true;
            while (!q.isEmpty()) {
                int x = q.poll();
                int size = list[x].size();
                for (int j = 0; j < size; j++) {
                    int next = list[x].get(j);
                    if (!visited[next]) {
                        visited[next] = true;
                        q.add(next);
                    }
                }
            }
            int cnt = 0;
            for (int j = 1; j <= n; j++) {
                if (visited[j]) {
                    cnt++;
                }
            }
            cnt--;
            if (cnt > n / 2) {
                ans.add(i);
            }
        }
        list = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < arr.length; i++) {
            int a = arr[i][0];
            int b = arr[i][1];
            list[b].add(a);
        }
        for (int i = 1; i <= n; i++) {
            if(ans.contains(i))
                continue;
            visited = new boolean[n + 1];
            Queue<Integer> q = new LinkedList<>();
            q.add(i);
            visited[i] = true;
            while (!q.isEmpty()) {
                int x = q.poll();
                int size = list[x].size();
                for (int j = 0; j < size; j++) {
                    int next = list[x].get(j);
                    if (!visited[next]) {
                        visited[next] = true;
                        q.add(next);
                    }
                }
            }
            int cnt = 0;
            for (int j = 1; j <= n; j++) {
                if (visited[j]) {
                    cnt++;
                }
            }
            cnt--;
            if (cnt > n/2) {
                ans.add(i);
            }
        }
        System.out.println(ans.size());
    }
}


/*
모양은 같으나, 무게가 모두 다른 N개의 구슬이 있다.
N은 홀수이며, 구슬에는 번호가 1,2,...,N으로 붙어 있다.
이 구슬 중에서 무게가 전체의 중간인 (무게 순서로 (N+1)/2번째) 구슬을 찾기 위해서 아래와 같은 일을 하려 한다.

우리에게 주어진 것은 양팔 저울이다. 한 쌍의 구슬을 골라서 양팔 저울의 양쪽에 하나씩 올려 보면 어느 쪽이 무거운가를 알 수 있다.
이렇게 M개의 쌍을 골라서 각각 양팔 저울에 올려서 어느 것이 무거운가를 모두 알아냈다.
이 결과를 이용하여 무게가 중간이 될 가능성이 전혀 없는 구슬들은 먼저 제외한다.

구슬 2번이 구슬 1번보다 무겁다.
구슬 4번이 구슬 3번보다 무겁다.
구슬 5번이 구슬 1번보다 무겁다.
구슬 4번이 구슬 2번보다 무겁다.


1번 구슬보다 무거운 것이 2, 4, 5번 구슬이고, 4번 보다 가벼운 것이 1, 2, 3번이다.
따라서 답은 2개이다.

     오른쪽이 더 무겁다.
1 -> 2 -> 4
1 -> 5

1 -> 4
3 -> 4
2 -> 4



 */