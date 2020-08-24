package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main_2151 {
    //  1. 거울설치
    //
    //  2. 빛이 통과해서 집 지나가기
    //
    //  3. BFS
    static boolean[][] visited;
    static char[][] mmap;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};        // N, E, S, W
    static int min = 9999;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        // 맵 만들기
        mmap = new char[N][N];
        visited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < N; j++) {
                mmap[i][j] = str.charAt(j);
                if(mmap[i][j] == '*')
                    visited[i][j] = true;
            }
        }
        for (int i = 0; i < N; i++) {
            boolean flag = false;
            for (int j = 0; j < N; j++) {
                if(mmap[i][j] == '#'){
                    if(i == 0)
                        BFS(i, j, 2);       // 남쪽방향시작
                    else if(i == N-1)
                        BFS(i, j, 0);      // 북쪽방향시작
                    else if(j == 0)
                        BFS(i, j, 1);       // 동쪽방향시작
                    else if(j == N-1)
                        BFS(i, j, 3);       // 서쪽방향시작
                    flag = true;
                    break;
                }
            }
            if(flag)
                break;
        }
//        for (int i = 0; i < N; i++) {
//            for (int j = 0; j < N; j++) {
//                System.out.print(mmap[i][j]);
//            }
//            System.out.println();
//        }
        System.out.println(min);
    }

    public static void BFS(int i, int j, int dir) {

        int answer = 0;
        char count = 48;            // 맵에 디버깅하느라 char
        Queue<Loc> queue = new LinkedList<>();
        queue.add(new Loc(i, j, dir, count));
        visited[i][j] = true;
        while(!queue.isEmpty()){
            Loc l = queue.poll();
            int curDir = l.dir;
            int my = l.y + dy[curDir];
            int mx = l.x + dx[curDir];
            char mcount = l.c;

            if(mx>=0 && mx<mmap.length && my>=0 && my<mmap.length && !visited[my][mx]){
                if(mmap[my][mx]=='#') {
                    answer = Character.getNumericValue(mcount);
                    if(min > answer)
                        min = answer;
                }
                visited[my][mx] = true;
                if(mmap[my][mx]=='!'){
                    if (curDir-1 <0) {
                        curDir = curDir +4;
                    }
                    queue.add(new Loc(my, mx, (curDir-1)%4, (char)(mcount+1)));
                    queue.add(new Loc(my, mx, (curDir+1)%4, (char)(mcount+1)));
                    // add의 문제가 아니라 Loc의 변수선언이 static이었음..
                }
                else
                    queue.add(new Loc(my, mx, curDir, mcount));
                mmap[my][mx] = mcount;
            }
        }
    }
    private static class Loc {
        private int x, y, dir;
        private char c;
        Loc(int y, int x, int dir, char c){
            this.y = y;
            this.x = x;
            this.dir = dir;
            this.c =c;
        }
    }
}
