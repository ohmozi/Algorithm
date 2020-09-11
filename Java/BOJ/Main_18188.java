package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_18188 {
    //  1. 다오의 데이트
    //
    //  2. 디지니를 만나러간다, 마리드는 방해한다
    //
    //  3. BFS, 브루트포스
    static char mmap[][];
    static boolean visited[][];
    static char Marid[][];
    static int dx[] = {0,-1,0,1};       // W,A,S,D
    static int dy[] = {-1,0,1,0};
    static int H, W;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        mmap = new char[H][W];
        visited = new boolean[H][W];
        int D_X=0, D_Y=0, Z_X=0, Z_Y=0;
        for (int i = 0; i < H; i++) {
            String str = br.readLine();
            for (int j = 0; j < W; j++) {
                mmap[i][j] = str.charAt(j);
                if(mmap[i][j]=='@'){
                    visited[i][j] = true;
                } else if(mmap[i][j]=='D'){
                    D_Y = i;
                    D_X = j;
                } else if(mmap[i][j]=='Z'){
                    Z_Y = i;
                    Z_X = j;
                }
            }
        }
        int N = Integer.parseInt(br.readLine());
        Marid = new char[N][2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            Marid[i][0] = st.nextToken().charAt(0);
            Marid[i][1] = st.nextToken().charAt(0);
        }
        BFS(D_X, D_Y, 0, Z_X, Z_Y, "");
    }
    public static void BFS(int i, int j, int c, int a, int b, String footPrint){
        int next_x = 0;
        int next_y = 0;
        boolean isAnswer = false;
        visited[j][i] = true;
        Queue<Loc> queue = new LinkedList<>();
        queue.add(new Loc(i, j, c, footPrint));

        while(!queue.isEmpty()){
            Loc l = queue.poll();
            if(l.x == a && l.y == b){
                isAnswer = true;
                System.out.println("YES");
//                System.out.println(l.count);    // 일단 몇번 지나서 도착했는지 출력
                System.out.println(l.footPrint);  // 경로저장해서 반환하기
                break;
            }
            boolean finish = true;
            for (int k = 0; k < 2; k++) {
                if(Marid[l.count][k]=='W'){
                    next_x = l.x + dx[0];
                    next_y = l.y + dy[0];
                } else if(Marid[l.count][k]=='A'){
                    next_x = l.x + dx[1];
                    next_y = l.y + dy[1];
                } else if(Marid[l.count][k]=='S'){
                    next_x = l.x + dx[2];
                    next_y = l.y + dy[2];
                } else if(Marid[l.count][k]=='D'){
                    next_x = l.x + dx[3];
                    next_y = l.y + dy[3];
                }
//                만약 마리드가 제시한 두 방향 중 어느 방향으로도 다오가 갈 수 없다면, 다오는 더 이상 움직일 수 없다.
                if(next_x>=0 && next_x<W && next_y>=0 && next_y<H && !visited[next_y][next_x]) {
//                    finish = false;
                    visited[next_y][next_x] = true;
                    queue.add(new Loc(next_x, next_y, l.count + 1, l.footPrint + Marid[l.count][k]));
                }
            }
//            if(finish)
//                break;
        }
        if(!isAnswer){
            System.out.println("NO");
        }
    }
    public static class Loc{
        private int x, y, count;
        private String footPrint;
        Loc(int x, int y, int count, String footPrint){
            this.x = x;
            this.y = y;
            this.count = count;
            this.footPrint = footPrint;
        }
    }
}
