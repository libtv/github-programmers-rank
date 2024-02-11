package org.example.BarkingDog.YouTube_22_BST;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

// 이중 우선순위 큐
public class BJ7662 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (t-->0){
            int n = Integer.parseInt(br.readLine());
            TreeMap<Long, Integer> map = new TreeMap<>();
            while (n-->0){
                StringTokenizer st = new StringTokenizer(br.readLine());
                String command = st.nextToken();
                if(command.equals("I")){
                   long temp = Long.parseLong(st.nextToken());
                   map.put(temp, map.getOrDefault(temp , 0) + 1);
                }
                else{ // D
                    int check = Integer.parseInt(st.nextToken());
                    if(map.size() > 0 && check == -1){
                       Long key = map.firstKey();
                       map.put(key, map.get(key)-1);
                       if(map.get(key) == 0){
                           map.remove(key);
                       }
                    }
                    else if(map.size() > 0 && check == 1){
                        Long key = map.lastKey();
                        map.put(key, map.get(key)-1);
                        if(map.get(key) == 0){
                            map.remove(key);
                        }
                    }
                }
            }
            if(map.isEmpty()){
                sb.append("EMPTY").append("\n");
            }
            else{
                sb.append(map.lastKey()).append(" ");
                sb.append(map.firstKey()).append("\n");
            }
        }
        System.out.println(sb);
    }
}
/*
이중 우선순위 큐(dual priority queue)는 전형적인 우선순위 큐처럼 데이터를 삽입, 삭제할 수 있는 자료 구조이다
이중 우선순위 큐를 위해선 두 가지 연산이 사용되는데, 하나는 데이터를 삽입하는 연산이고 다른 하나는 데이터를 삭제하는 연산이다.
데이터를 삭제하는 연산은 또 두 가지로 구분되는데 하나는 우선순위가 가장 높은 것을 삭제하기 위한 것이고
다른 하나는 우선순위가 가장 낮은 것을 삭제하기 위한 것이다.

정수만 저장하는 이중 우선순위 큐 Q가 있다고 가정하자. Q에 저장된 각 정수의 값 자체를 우선순위라고 간주하자.
Q에 적용될 일련의 연산이 주어질 때 이를 처리한 후 최종적으로 Q에 저장된 데이터 중 최댓값과 최솟값을 출력하는 프로그램을 작성하라.

D  1 은 최댓값 삭제
D -1 은 최솟값 삭제

만약 Q가 비어있는데 적용할 연산이 ‘D’라면 이 연산은 무시해도 좋다.

출력은 표준출력을 사용한다. 각 테스트 데이터에 대해, 모든 연산을 처리한 후 Q에 남아 있는 값 중 최댓값과 최솟값을 출력하라.
두 값은 한 줄에 출력하되 하나의 공백으로 구분하라. 만약 Q가 비어있다면 ‘EMPTY’를 출력하라.


 */