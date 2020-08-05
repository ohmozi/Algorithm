package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_10026 {
//    1. 적록색약
//
//    2. 색들의 구역 수
//
//    3. bfs
    public static void main(String[] args) throws IOException {
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        char[][] mmap = new char[N][N];
        boolean[][] visitedNormal = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            String t = br.readLine();
            for (int j = 0; j < N; j++) {
                mmap[i][j] = t.charAt(j);
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                bfsNormal(i,j);
            }
        }
    }
    public void bfsNormal(int i, int j){

    }
    public void bfsAbnormal(int i, int j){

    }
}
