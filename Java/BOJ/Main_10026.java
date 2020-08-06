package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main_10026 {
//    1. 적록색약
//
//    2. 색들의 구역 수
//
//    3. bfs
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static char[][] mmap;
    static boolean[][] visitedNormal;
    static boolean[][] visitedAbnormal;
    static int normalArea = 0 ;
    static int abnormalArea = 0 ;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        mmap = new char[N][N];
        visitedNormal = new boolean[N][N];
        visitedAbnormal = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            String t = br.readLine();
            for (int j = 0; j < N; j++) {
                mmap[i][j] = t.charAt(j);
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(!visitedNormal[i][j])
                    bfsNormal(i, j, mmap[i][j]);
                if(!visitedAbnormal[i][j])
                    bfsAbnormal(i, j, mmap[i][j]);
            }
        }
        System.out.println(normalArea + " " + abnormalArea);
    }
    public static void bfsNormal(int i, int j, char c){
        Queue<Loc> queue = new LinkedList<>();
        queue.add(new Loc(i,j));
        visitedNormal[i][j] = true;
        while(!queue.isEmpty()){
            Loc l = queue.poll();
            for(int k =0; k<4; k++){
                int mx = l.x + dx[k];
                int my = l.y + dy[k];
                if(mx>=0 && mx<mmap.length && my>=0 && my<mmap.length && !visitedNormal[mx][my] && mmap[mx][my] == c){
                    visitedNormal[mx][my] = true;
                    queue.add(new Loc(mx, my));
                }
            }
        }
        normalArea++;
    }
    public static void bfsAbnormal(int i, int j, char c){
        Queue<Loc> queue = new LinkedList<>();
        queue.add(new Loc(i,j));
        visitedAbnormal[i][j] = true;
        while(!queue.isEmpty()){
            Loc l = queue.poll();
            for(int k =0; k<4; k++){
                int mx = l.x + dx[k];
                int my = l.y + dy[k];
                if (c == 'R' || c == 'G'){
                    if(mx>=0 && mx<mmap.length && my>=0 && my<mmap.length && !visitedAbnormal[mx][my]
                            && (mmap[mx][my] == 'R' || mmap[mx][my] =='G')){
                        visitedAbnormal[mx][my] = true;
                        queue.add(new Loc(mx, my));
                    }
                } else{
                    if(mx>=0 && mx<mmap.length && my>=0 && my<mmap.length && !visitedAbnormal[mx][my] && mmap[mx][my] == c){
                        visitedAbnormal[mx][my] = true;
                        queue.add(new Loc(mx, my));
                    }
                }

            }
        }
        abnormalArea++;
    }
    private static class Loc{
        private int x, y;
        Loc(int x , int y){
            this.x = x;
            this.y = y;
        }
    }
}
