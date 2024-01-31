package org.example.BarkingDog.YouTube_17_Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

// 수 묶기 골드4
public class BJ1744 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> list1 = new ArrayList<>(); // -1000 ~ -1
        ArrayList<Integer> list2 = new ArrayList<>(); // 1 ~ 1000
        ArrayList<Integer> list3 = new ArrayList<>(); // 0
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            int temp = Integer.parseInt(br.readLine());
            if( temp < 0){
                list1.add(temp);
            }
            else if(temp > 0){
                list2.add(temp);
            }
            else if(temp == 0){
                list3.add(temp);
            }
        }

        Collections.sort(list1, new Comparator_2());
        Collections.sort(list2, new Comparator_2());
        int MinusSize = list1.size();
        int PlusSize = list2.size();
        int sum = 0;
        for (int i = 0; i <= MinusSize-1; i++) {
            if(i + 1 <= MinusSize -1){
                sum += list1.get(i) * list1.get(i+1);
                i++;
            }
        }
        if(list3.size() == 0 && list1.size() % 2 == 1){
            sum += list1.get(MinusSize-1);
        }
        int idx = 0;
        boolean flag = false;
        for (int i = 0; i <= PlusSize-1; i++) {
            if(i + 1 <= PlusSize-1){
                if(list2.get(i) > 1 && list2.get(i+1) > 1){
                    sum += list2.get(i) * list2.get(i+1);
                    i++;
                }
                else{
                    idx = i;
                    flag = true;
                    break;
                }
            }
            else{
                flag = true;
                idx = i;
                break;
            }
        }
        if(flag){
            for (int i = idx; i <= PlusSize-1; i++) {
                sum += list2.get(i);
            }
        }
        System.out.println(sum);
    }
}

// 먼저 절댓값이 큰 순서대로 내림차순으로 정렬한다. 그리고
class Comparator_2 implements Comparator<Integer>{
    public int compare(Integer o1, Integer o2){
        if(Math.abs(o1) > Math.abs(o2)){
            return -1;
        }
        else if(Math.abs(o1) < Math.abs(o2)){
            return 1;
        }
        else{
            return 0;
        }
    }
}



/*
길이가 N인 수열이 주어졌을 때, 그 수열의 합을 구하려고 한다.
하지만, 그냥 그 수열의 합을 모두 더해서 구하는 것이 아니라, 수열의 두 수를 묶으려고 한다.
어떤 수를 묶으려고 할 때, 위치에 상관없이 묶을 수 있다.
그리고 어떤 수를 묶게 되면, 수열의 합을 구할 때 묶은 수는 서로 곱한 후에 더한다.

예를 들면, 어떤 수열이 {0, 1, 2, 4, 3, 5}일 때, 그냥 이 수열의 합을 구하면 0+1+2+4+3+5 = 15이다. 하지만, 2와 3을 묶고, 4와 5를 묶게 되면, 0+1+(2*3)+(4*5) = 27이 되어 최대가 된다.
수열의 모든 수는 단 한번만 묶거나, 아니면 묶지 않아야한다.
수열이 주어졌을 때, 수열의 각 수를 적절히 묶었을 때, 그 합이 최대가 되게 하는 프로그램을 작성하시오.

 */