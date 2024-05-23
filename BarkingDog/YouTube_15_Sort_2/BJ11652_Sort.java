package BarkingDog.YouTube_15_Sort_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

// https://www.acmicpc.net/problem/11652
// 카드 실버4
public class BJ11652_Sort {

    static int N;
    static ArrayList<Long> list;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        list = new ArrayList<>();
        for (int i = 0; i < N ; i++) {
            list.add(Long.parseLong(br.readLine()));
        }
        Collections.sort(list); // 오름차순 정렬


        long maxValue = Long.MIN_VALUE;
        long value = Long.MIN_VALUE;
        int MaxCount = 0;
        int cnt = 0;

        for (int i = 0; i < N ; i++) {
            long temp = list.get(i);
            if(i == 0){
                cnt++;
                MaxCount = 1;
                value = temp;
                maxValue = temp;
            }
            else if( i == list.size() - 1){
                if(temp > maxValue){
                    if(cnt > MaxCount){
                        value = maxValue;
                    }
                }
                else if(temp == maxValue){
                    cnt++;
                    if(cnt > MaxCount){
                        value = maxValue;
                    }
                }
                break;
            }
            else if(temp > maxValue){
                if(cnt > MaxCount){
                    MaxCount = cnt;
                    value = maxValue;
                }
                maxValue = temp;
                cnt = 1;
            }
            else if(temp == maxValue){
                cnt++;
            }
        }
        System.out.println(value);

    }
}
