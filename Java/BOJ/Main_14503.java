package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_14503 {
    //  1. 로봇 청소기
    //
    //  2. 보는 방향이 있고 벽과 빈공간, 얼마나 청소할수있는지
    //
    //  3. 구현, 객체
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int direction;
    static boolean[][] visited;
    static int[][] mmap;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        mmap = new int[N][M];
        visited = new boolean[N][M];

        st = new StringTokenizer(br.readLine());
        int xLoc = Integer.parseInt(st.nextToken());
        int yLoc = Integer.parseInt(st.nextToken());
        direction = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                mmap[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        bfs(xLoc, yLoc);

    }
    public static void bfs(int x, int y){
        Queue<Loc> q = new LinkedList<>();
        q.add(new Loc(x, y));
        mmap[x][y] = 1;
        while(!q.isEmpty()){
            Loc loc = q.poll();
            for (int i = 0; i < 4; i++) {
                int mx = loc.x + dx[i];
                int my = loc.y + dy[i];
            }
        }
    }

    public static class Loc {
        private int x, y;
        Loc(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}
