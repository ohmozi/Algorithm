package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main_11559 {
//    1. Puyo Puyo
//
//    2. 내 필드의 뿌요뿌요게임
//
//    3. BFS, 한줄씩 내리기
    static final int COLUMN = 12;
    static final int ROW = 6;
    static char[][] mmap = new char[COLUMN][ROW];
    static int[][] status = new int[COLUMN][ROW];   // 0:빈공간 1:타일이있는공간 2:타일이 없어질 공간
    static boolean check = true;
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int i =0; i<COLUMN; i++){
            String t = br.readLine();
            for(int j = 0; j<ROW; j++){
                mmap[i][j] = t.charAt(j);
                if(t.charAt(j)=='.')
                    status[i][j] = 0;           // 선언하면서 0으로 초기화 된다했나?
                else
                    status[i][j] = 1;
            }
        }

        while(check) {
            check = false;
            for (int i = COLUMN - 1; i >= 0; i--) {     // 아래서 부터 확인해오기
                for (int j = ROW - 1; j > 0; j--) {
                    if (status[i][j] != 0)
                        boolean isOverFour = find(i, j);
                }
            }
        }


    }
    public void down(){      // 아래까지 내려가는 함수

    }
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,-1,0,1};
    public static boolean find(int x, int y){
        check = true;           // 맵에서 계속 진행할지 체크
        boolean isOverFour = false;
        int count = 0;
        Queue<Loc> queue = new LinkedList<>();
        queue.add(new Loc(x, y));
        status[x][y]= 2;
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
                    queue.add(new Main_3184.Loc(mx,my));
                }
            }
        }
        answer++;
        return isOverFour;
    }
    private static class Loc {
        private int x, y;
        Loc(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}
