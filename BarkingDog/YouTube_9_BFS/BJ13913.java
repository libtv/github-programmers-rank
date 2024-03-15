package BarkingDog.YouTube_9_BFS;

// https://www.acmicpc.net/problem/13913
// 숨바꼭질 4 골드4

import java.util.*;
import java.io.*;
public class BJ13913 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 수빈이는 현재 점 N(0 ≤ N ≤ 100,000)에 있고, 동생은 점 K(0 ≤ K ≤ 100,000)에 있다.
        // 수빈이의 위치가 X일 때 걷는다면 1초 후에 X-1 또는 X+1로 이동하게 된다.
        // 순간이동을 하는 경우에는 1초 후에 2*X의 위치로 이동하게 된다.
        // 수빈이와 동생의 위치가 주어졌을 때, 수빈이가 동생을 찾을 수 있는 가장 빠른 시간이 몇 초 후인지 구하는 프로그램을 작성하시오.
        // 첫째 줄에 수빈이가 동생을 찾는 가장 빠른 시간을 출력한다.
        // 둘째 줄에 어떻게 이동해야 하는지 공백으로 구분해 출력한다.

        String[] split = br.readLine().split(" ");
        int sx = Integer.parseInt(split[0]);
        int ex = Integer.parseInt(split[1]);

        boolean lucky = false;

        if(sx == ex){
            lucky = true;
            System.out.println(0);
            System.out.println(sx);
        }

        int[] time = new int [100001]; // 시간 확인 + break 용도
        time[sx] = 1;
        int[] previous = new int[100001]; // 각 좌표마다 이전 좌표가 어디인지 기록

        Queue<Route> q = new LinkedList<>();
        q.offer(new Route(sx, 1));

        boolean first = false;

        // 5 -> 4 -> 8 -> 16 -> 17

        while (!q.isEmpty()){
            Route route = q.poll();
            int x = route.x;
            int cnt = route.cnt;
            int[] arr = {x * 2, x + 1, x - 1};
            for (int i = 0; i < 3; i++) {
                int temp = arr[i];
                if( 0<= temp && temp < 100001){ // IndexTest
                    if ( ex == temp ) {
                        previous[temp] = x;
                        time[temp] = cnt + 1;
                        first = true;
                        break;
                    }
                    else if(time[temp] == 0){
                        time[temp] = cnt + 1;
                        previous[temp] = x;
                        q.offer(new Route(temp , cnt + 1));
                    }
                }
            }
            if(first){
                break;
            }
        }
        if(!lucky){
            System.out.println(time[ex]-1);
            StringBuilder sb = new StringBuilder();
            int go = ex;
            while (go!=sx){
                sb.insert(0, previous[go] + " ");
                go = previous[go];
            }
            sb.append(ex + " ");
            System.out.println(sb);
        }
    }
}

class Route{
    int x; // 좌표
    int cnt; // 이동 카운트
    public Route(int x, int cnt){
        this.x = x;
        this.cnt = cnt;
    }
}

/* // ArrayList 활용 시간초과 발생 46퍼에서 // 문자열 활용 또한 시간초과 발생
public class BJ13913 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 수빈이는 현재 점 N(0 ≤ N ≤ 100,000)에 있고, 동생은 점 K(0 ≤ K ≤ 100,000)에 있다.
        // 수빈이의 위치가 X일 때 걷는다면 1초 후에 X-1 또는 X+1로 이동하게 된다.
        // 순간이동을 하는 경우에는 1초 후에 2*X의 위치로 이동하게 된다.
        // 수빈이와 동생의 위치가 주어졌을 때, 수빈이가 동생을 찾을 수 있는 가장 빠른 시간이 몇 초 후인지 구하는 프로그램을 작성하시오.
        // 첫째 줄에 수빈이가 동생을 찾는 가장 빠른 시간을 출력한다.
        // 둘째 줄에 어떻게 이동해야 하는지 공백으로 구분해 출력한다.

        // 입력이 정수 2개여서 Scanner가 더 빠르겠네...

        String[] split = br.readLine().split(" ");
        int sx = Integer.parseInt(split[0]);
        int ex = Integer.parseInt(split[1]);

        boolean lucky = false;
        if(sx == ex){
            lucky = true;
        }

        int[] map = new int[100001];

        map[sx] = 1;
        map[ex] = 2;

        Deque<Route> q = new LinkedList<>();

        if(!lucky){
            ArrayList<Integer> list = new ArrayList<>();
            list.add(sx);
            q.offer(new Route(sx, list));
        }
        else if(lucky){
            System.out.println(0);
            System.out.println(sx);
        }

        boolean first = false;

        while (!q.isEmpty()){

            Route route = q.poll();
            int x = route.x;
            ArrayList<Integer> list = route.list;

            int [] arr = { x + 1, x * 2, x - 1}; // 곱하기 더하기 빼기
            for (int i = 0; i < 3 ; i++) {
                int temp = arr[i];
                if( 0 <= temp && temp < 100001){
                    if(map[temp] == 2){
                        list.add(temp);
                        map[temp] = 1;
                        first = true;
                        break;
                    }
                    else if(map[temp] == 0) {
                        ArrayList<Integer> list2 = new ArrayList<>(list);
                        map[temp] = 1;
                        list2.add(temp);
                        q.offer(new Route(temp , list2));
                    }
                }
;           }
            if(first){
                System.out.println(list.size()-1);
                for (int i = 0; i < list.size(); i++) {
                    System.out.print(list.get(i) + " ");
                }
                break;
            }
        }
    }
}

class Route{
    int x; // 좌표
    ArrayList<Integer> list; // 경로
    public Route(int x, ArrayList<Integer> list){
        this.x = x;
        this.list = list;
    }
}
 */