package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
//https://zoonvivor.tistory.com/130
public class Main_14503_1 {
    //  1. 로봇 청소기
    //
    //  2. 보는 방향이 있고 벽과 빈공간, 얼마나 청소할수있는지
    //
    //  3. 구현, 객체
    // if 문 때려박지말고 bfs로 풀자

    static int[] lx = {-1,0,1,0};
    static int[] ly = {0,-1,0,1};
    // 좌측 확인 : 서, 북, 동, 남
    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {1, 0, -1, 0};
    // 후진이동 : 남, 서, 북, 동
    static int direction;
    // 0 : 북 , 1 : 동, 2 : 남, 3 : 서

    static boolean[][] visited;
    static int[][] mmap;
    static int cnt = 1;
    static int N;
    static int M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        mmap = new int[N][M];
        visited = new boolean[N][M];
        int answer = 0;
        st = new StringTokenizer(br.readLine());
        int yLoc = Integer.parseInt(st.nextToken());
        int xLoc = Integer.parseInt(st.nextToken());
        direction = Integer.parseInt(st.nextToken());


        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                mmap[i][j] = Integer.parseInt(st.nextToken());
                if (mmap[i][j] == 0)
                    answer++;
            }
        }
        mmap[yLoc][xLoc] = 2;
//        bfs(yLoc, xLoc, direction);


        int y = yLoc;
        int x = xLoc;
        int d = direction;
        boolean finish = true;
        while(finish){
            boolean cleaned = true;
            boolean backWall = false;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    System.out.print(mmap[i][j] + " ");
                }
                System.out.println();
            }
            System.out.println("==============");

            for (int i = 0; i < 4; i++) {       // 사방이 막혀있으면
                if (mmap[y + dy[i]][x + dx[i]] == 0) {
                    cleaned = false;
                }
            }
            if (cleaned) {
                System.out.println("x : " + x + "   y : "+ y);
                if (mmap[y + dy[d]][x + dx[d]] == 1){
                    backWall = true;
                    System.out.println("break!!");
                }
                if (backWall) {
                    finish = false;
                    break;
                }
                else{
                    y = y +dy[d];
                    x = x +dx[d];
                }
            }
            if (mmap[y + ly[d]][x + lx[d]] == 0) {     // 왼쪽이 청소안된경우
                mmap[y + ly[d]][x + lx[d]] = 2;
                cnt++;
                y = y+ly[d];
                x = x+lx[d];
                d = (d+3)%4;
//                bfs(x + ly[d], y + lx[d], (d + 3) % 4);       // 회전하고 전진
            }
            else if (mmap[y + ly[d]][x + lx[d]] == 1 || mmap[y + ly[d]][x + lx[d]] == 2) {        // 왼쪽이 청소거나 벽인경우
                d = (d+3)%4;
//                bfs(x, y, (d + 3) % 4);           // 회전
            }

        }


        System.out.println(cnt);
        System.out.println(answer);
    }
    public static void bfs(int x, int y, int dict) {
        boolean cleaned = true;
        boolean backWall = false;


//        for (int i = 0; i < N; i++) {
//            for (int j = 0; j < M; j++) {
//                System.out.print(mmap[i][j] + " ");
//            }
//            System.out.println();
//        }
//        System.out.println("==============");

        for (int i = 0; i < 4; i++) {       // 사방이 막혀있으면
            if (mmap[x + dy[i]][y + dx[i]] == 0) {
                cleaned = false;
            }
        }
        if (cleaned) {
            System.out.println("x : " + x + "   y : "+ y);
            if (mmap[x + dy[dict]][y + dx[dict]] == 1)
                backWall = true;
            if (backWall)
                return;
            else
                bfs(x + dy[dict], y + dx[dict], dict);
        }

        if (mmap[x + ly[dict]][y + lx[dict]] == 0) {     // 왼쪽이 청소안된경우
            mmap[x + ly[dict]][y + lx[dict]] = 2;
            cnt++;
            bfs(x + ly[dict], y + lx[dict], (dict + 3) % 4);       // 회전하고 전진
        }
        else if (mmap[x + ly[dict]][y + lx[dict]] == 1 || mmap[x + ly[dict]][y + lx[dict]] == 2)        // 왼쪽이 청소거나 벽인경우
            bfs(x, y, (dict + 3) % 4);           // 회전
    }
//
    public static class Loc {
        private int x, y;
        Loc(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}
