package BarkingDog.YouTube_9_BFS;

// https://www.acmicpc.net/problem/13549
// 숨바꼭질 3 골드5

import java.util.*;
import java.io.*;
public class BJ13549 {
    public static void main(String[] args) throws IOException {
        //  수빈이는 동생과 숨바꼭질을 하고 있다. 수빈이는 현재 점 N(0 ≤ N ≤ 100,000)에 있고, 동생은 점 K(0 ≤ K ≤ 100,000)에 있다
        //  수빈이는 걷거나 순간이동을 할 수 있다. 만약, 수빈이의 위치가 X일 때 걷는다면 1초 후에 X-1 또는 X+1로 이동하게 된다.
        //  순간이동을 하는 경우에는 0초 후에 2*X의 위치로 이동하게 된다.

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        int start = Integer.parseInt(split[0]);
        int end = Integer.parseInt(split[1]);

        int[] map = new int[100001]; // 시작 : 1 끝 : 3  들린곳은 2
        map[start] = 2;
        map[end] = 3;

        boolean lucky = false;
        if(start == end){
            lucky = true;
        }
        Queue<Check> q = new LinkedList<>();
        q.offer(new Check(start, 0));

        int cnt = 0;
        boolean END = false;

        while(!q.isEmpty()){
            Check check = q.poll();
            int x = check.x;
            int time = check.count;
            if(0 <= x * 2 && x * 2 < 100001){
                if(map[x * 2] == 3){
                    map[x * 2] = 2;
                    END = true;
                    cnt = time;
                    break;
                }
                else if(map[x * 2] == 0){
                    map[x * 2] = 2;
                    q.offer(new Check(x * 2, time));
                }
            }
            if(0 <= x - 1 && x - 1 < 100001){
                if(map[x - 1] == 3){
                    map[x - 1] = 2;
                    time++;
                    END = true;
                    cnt = time;
                    break;
                }
                else if(map[x - 1] == 0){
                    map[x - 1] = 2;
                    q.offer(new Check(x - 1 , time+1));
                }
            }
            if(0 <= x + 1 && x + 1 < 100001){
                if(map[x + 1] == 3){
                    map[x + 1] = 2;
                    time++;
                    END = true;
                    cnt = time;
                    break;
                }
                else if(map[x + 1] == 0){
                    map[x + 1] = 2;
                    q.offer(new Check(x + 1 , time+1));
                }
            }

        }
        if(lucky){
            System.out.println(0);
        }
        else if(END){
            System.out.println(cnt);
        }
        else{
            System.out.println("KKKKKKK");
        }
    }
}

class Check{
    int x;
    int count; // 더하기 빼기 사용횟수용도

    public Check(int x, int count){
        this.x = x;
        this.count =count;

    }
}
