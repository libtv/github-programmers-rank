package org.example.programmers.HighScoreKit.Greedy;

import java.util.Arrays;

// https://school.programmers.co.kr/learn/courses/30/lessons/42862
// 알고리즘 고득점 KIT GREEDY LEVE1 체육복
public class GymSuit {
    public static void main(String[] args) {
        int [] lost = {2, 4};
        int [] reserve = {1, 3, 5};
        System.out.println(solution(5, lost,reserve));
    }
    public static int solution(int n, int[] lost, int[] reserve) {

        int [] check = new int[n];

        for(int i = 0; i < n; i++){
            check[i] = 1;
        }

        for(int i = 0; i < lost.length; i++){
            check[lost[i]-1]--;
        }

        for(int i = 0; i < reserve.length; i++){
            check[reserve[i]-1]++;
        }

        boolean flag = false;

        for (int i = 0; i < check.length; i++) {
           if(i==0){
               if(check[i]==0 && check[i+1]==2){
                   check[i]=1;
                   check[i+1]=1;
               }
           }
           else if(i==check.length-1){
               if(check[i]==0 && check[i-1]==2){
                   check[i]=1;
                   check[i-1]=1;
               }
           }
           else{
               if(check[i]==0 && check[i-1]==2){
                   check[i]=1;
                   check[i-1]=1;
               }
               else if(check[i]==0 && check[i+1]==2){
                   check[i]=1;
                   check[i+1]=1;
               }
           }
        }
        System.out.println(Arrays.toString(check));
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if(check[i]==1 || check[i]==2){
                cnt++;
            }
        }
        return cnt;
    }
}

/*
 public static int solution(int n, int[] lost, int[] reserve) {

        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();

        for(int i=0; i < lost.length; i++){
            sb.append(Integer.toString(lost[i]-1));
        }

        String losts = sb.toString();
        System.out.println(losts);

        for(int i=0; i < reserve.length; i++){
            sb2.append(Integer.toString(reserve[i]-1));
        }

        String reverses = sb2.toString();
        System.out.println(reverses);

        int [] check = new int[n];
        for(int i=0; i < n; i++){
            check[i] = 1;
            String deliver = Integer.toString(i);
            if(losts.contains(deliver)){
                check[i]--;
            }
            if(reverses.contains(deliver)){
                check[i]++;
            }
        }
        System.out.println(Arrays.toString(check));

        for (int i = 0; i < check.length ; i++) {
            if(check[i]==0 && i==0){ // 제일 첫번째
                if(check[i+1]==2){
                    check[i] = 1;
                    check[i+1] = 1;
                }
            }
            else if(check[i]==0 && i == check.length-1){ // 제일 마지막
                if(check[i-1]==2){
                    check[i] = 1;
                    check[i-1] = 1;
                }
            }
            else if(check[i]==0){
                if(check[i-1]==2){
                    check[i] = 1;
                    check[i-1] = 1;
                }
                else if(check[i+1]==2){
                    check[i] = 1;
                    check[i+1] = 1;
                }
            }
        }
        System.out.println(Arrays.toString(check));
        int cnt = 0;
        for (int i = 0; i < check.length ; i++) {
            if(check[i]==1 || check[i]==2){
                cnt++;
            }
        }
        return cnt;
    }
 */