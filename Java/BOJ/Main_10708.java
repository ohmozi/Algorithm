package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_10708 {
    //  1. 크리스마스 파티
    //
    //  2. 타겟맞추기
    //
    //  3. 구현, 2차원배열

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        int[] target = new int[M];
        int[] score = new int[N];
        int[][] mmap = new int[M][N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            target[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < M; i++) {
            int wrongCount = 0;
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                mmap[i][j] = Integer.parseInt(st.nextToken());
                if(mmap[i][j]==target[i]){
                    score[j]++;
                } else{
                    wrongCount++;
                }
            }
            score[target[i]-1] += wrongCount;
        }
        for (int i = 0; i < N; i++) {
            System.out.println(score[i]);
        }
    }
}
