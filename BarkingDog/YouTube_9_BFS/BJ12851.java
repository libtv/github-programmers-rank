package BarkingDog.YouTube_9_BFS;

// https://www.acmicpc.net/problem/12851
// 숨바꼭질 2 골드4

import java.util.*;
import java.io.*;
public class BJ12851 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 1초 후에 X-1 또는 X+1로 이동하게 된다.
        // 순간이동을 하는 경우에는 1초 후에 2*X의 위치로 이동하게 된다.
        // 수빈이가 동생을 찾을 수 있는 가장 빠른 시간이 몇 초 후인지 그리고,
        // 가장 빠른 시간으로 찾는 방법이 몇 가지 인지 구하는 프로그램을 작성하시오.
        String[]split = br.readLine().split(" ");
        int sx = Integer.parseInt(split[0]);
        int ex = Integer.parseInt(split[1]);

        boolean lucky = false; // 시작지점 끝나는지점 같은 경우
        if(sx == ex){
            lucky = true;
        }

        //  1. int[] 배열은 최단시간인지?  2. int[] 배열은 최단거리 방법의 수 저장

        int[] time = new int[100001];
        int[] method = new int[100001];

        time[sx] = 1; // 시간은 나중에 -1 해준다. 시작지점은 원래 0으로 시작
        method[sx] = 1;

        Queue<Node> q = new LinkedList<>();
        if(!lucky){
            q.offer( new Node(sx, 1));

        }

        boolean first = false;
        int check = 0;

        while (!q.isEmpty()){
            Node node = q.poll();
            int x = node.x;
            int cnt = node.cnt;

            if(first){
                check--;
            }

            int[] arr = {x*2, x+1, x-1};  // 곱하기 더하기 빼기
            for (int i = 0; i < 3; i++) {
                int temp = arr[i];
                if(0 <= temp && temp < 100001){  // ArrayBoundsIndex test
                    if(time[temp] == 0){ // 처음 방문 이라면?
                        time[temp] = cnt + 1; // 최단 시간
                        method[temp] = 1; // 첫 방문
                        q.offer(new Node(temp, cnt+1));
                        if(temp == ex && !first){
                            first = true;
                            check = q.size();
                        }
                    }
                    else if(time[temp] > 0 && time[temp] == cnt + 1){ // 처음 방문이 아니라면? 그리고 최단 시간이라면?
                        method[temp] += 1;
                        q.offer(new Node(temp, cnt+1));
                    }
                }
            }
            if(check == 0 && first){
                break;
            }
        }
        // System.out.println(Arrays.toString(method));
        System.out.println(time[ex]-1);
        System.out.println(method[ex]);
    }
}

class Node{
    int x;
    int cnt;
    public Node(int x, int cnt){
        this.x = x;
        this.cnt = cnt;
    }
}
/* 46퍼에서 틀림 왜 그럴까..

반례

0 3
0 1 2 3
0 1 *2 3

밑에 코드는 한번 방문하면 다시는 방문하지 못 한다. 하지만 1에서 2로 가는 방법은
+1도 있지만 곱하기 2도 있다.

public class BJ12851 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 1초 후에 X-1 또는 X+1로 이동하게 된다.
        // 순간이동을 하는 경우에는 1초 후에 2*X의 위치로 이동하게 된다.
        // 수빈이가 동생을 찾을 수 있는 가장 빠른 시간이 몇 초 후인지 그리고,
        // 가장 빠른 시간으로 찾는 방법이 몇 가지 인지 구하는 프로그램을 작성하시오.
        String[]split = br.readLine().split(" ");
        int sx = Integer.parseInt(split[0]);
        int ex = Integer.parseInt(split[1]);

        boolean lucky = false; // 시작지점 끝나는지점 같은 경우
        if(sx == ex){
            lucky = true;
        }

        int[] map = new int[100001]; // 들린 곳 : 1 수빈이 위치 : 2

        map[sx] = 1;
        map[ex] = 2;

        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(sx, 0));

        int min = 0;
        boolean first = true;
        int check = 0;
        int answer = 0;

        while (!q.isEmpty()){
            Node node = q.poll();
            int x = node.x;
            int count = node.cnt;
            if(!first){
                check--;
            }
            if(0 <= x * 2 && x * 2 < 100001){
                if(map[x * 2] == 2){
                    count++;
                    if(first){
                        answer++;
                        first = false;
                        min = count;
                        check = q.size(); // 현재 남아있는 큐 사이즈
                    }
                    else if(!first){
                        if(min == count){
                            answer++;
                        }
                    }
                }
                else if(map [x * 2] == 0){
                    map[x * 2] = 1;
                    q.offer(new Node(x * 2 , count+1));
                }
            }
            if(0 <= x + 1 && x + 1 < 100001){
                if(map[x + 1] == 2){
                    count++;
                    if(first){
                        answer++;
                        first = false;
                        min = count;
                        check = q.size(); // 현재 남아있는 큐 사이즈
                    }
                    else if(!first){
                        if(min == count){
                            answer++;
                        }
                    }
                }
                else if(map [x + 1] == 0){
                    map[x + 1] = 1;
                    q.offer(new Node(x + 1 , count+1));
                }
            }
            if(0 <= x - 1 && x - 1 < 100001){
                if(map[x - 1] == 2){
                    count++;
                    if(first){
                        answer++;
                        first = false;
                        min = count;
                        check = q.size(); // 현재 남아있는 큐 사이즈
                    }
                    else if(!first){
                        if(min == count){
                            answer++;
                        }
                    }
                }
                else if(map [x - 1] == 0){
                    map[x - 1] = 1;
                    q.offer(new Node(x - 1 , count+1));
                }
            }
            if(check == 0 && !first){
                break;
            }
        }
        if(lucky){
            System.out.println(0);
            System.out.println(1);
        }
        else{
            System.out.println(min);
            System.out.println(answer);
        }
    }
}

class Node{
    int x;
    int cnt;
    public Node(int x, int cnt){
        this.x = x;
        this.cnt = cnt;
    }
}
 */