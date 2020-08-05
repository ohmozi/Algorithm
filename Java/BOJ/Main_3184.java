package com.company;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// 컴파일에 순서는 상관없음?
public class Main_3184 {
    //  1. 양
    //
    //  2. 울타리 안에 양과 늑대
    //
    //  3. BFS
    static int r,c;
    static int[][] mmap;
    static boolean[][] visited;

    public static void main(String[] args)  {
        Scanner sc = new Scanner(System.in);
        r = sc.nextInt();
        c = sc.nextInt();
        mmap = new int[r][c];
        for (int i = 0; i < r; i++) {
            String t = sc.next();
            for (int j = 0; j < c; j++) {
                mmap[i][j] = t.charAt(j);
            }
        }

        visited = new boolean[r][c];            // 자동으로 false초기화?
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (mmap[i][j] != '#' && !visited[i][j]) {
                    bfs(i, j);
                }
            }
        }
        System.out.println(totalSheep + " " + totalWolf);
    }
    static int totalWolf, totalSheep;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,-1,0,1};
    public static void bfs(int x, int y){       // static안붙이면 무슨차이?
        Queue<Loc> queue = new LinkedList<>();
        queue.add(new Loc(x,y));
        visited[x][y]= true;
        int wolf = 0;
        int sheep = 0;
        if (mmap[x][y] =='v') wolf++;
        else if(mmap[x][y] == 'o') sheep++;
        while(!queue.isEmpty()){
            Loc loc = queue.poll();
            for (int i=0; i<4; i++){
                int mx = loc.x + dx[i];
                int my = loc.y + dy[i];
                if(mx >=0 && mx < r && my >= 0 && my < c && mmap[mx][my] != '#' && !visited[mx][my]){
                    // 범위 안에 있으면서 울타리가 아니고 방문한적이 없으면 진행
                    if(mmap[mx][my] == 'v') wolf++;
                    else if(mmap[mx][my] == 'o') sheep++;
                    visited[mx][my]=true;
                    queue.add(new Loc(mx,my));
                }
            }
        }
        if(wolf>=sheep)
            sheep = 0;
        else
            wolf=0;

        totalWolf += wolf;
        totalSheep += sheep;
    }

    private static class Loc {
        private int x, y;
        Loc(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}
