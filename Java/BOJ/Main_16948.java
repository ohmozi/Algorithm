package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_16948 {
    public static int dx[] = {-2, -2, 0, 0, 2, 2};
    public static int dy[] = {-1, 1, -2, 2, -1, 1};
    public static boolean visited[][];
    public static int mmap[][];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        mmap = new int[N][N];
        visited = new boolean[N][N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        int loca[] = new int[4];
        for (int i =0; i<4; i++){
            loca[i] = Integer.parseInt(st.nextToken());
        }
        int answer = bfs(loca[0], loca[1], loca[2], loca[3]);

        System.out.println(answer);
    }

    public static int bfs(int x, int y, int goal_x, int goal_y){
        Queue<Loc> queue = new LinkedList<>();
        queue.add(new Loc(x,y));
        visited[x][y]= true;
        boolean check = false;

        while(!queue.isEmpty()){
            Loc loc = queue.poll();
            for(int i =0; i<dx.length; i++){
                int mx = loc.x + dx[i];
                int my = loc.y + dy[i];
                if (mx >=0 && mx < visited.length && my >= 0 && my < visited.length && !visited[mx][my]){   // 숫자 더해가기
                    mmap[mx][my] = mmap[loc.x][loc.y] + 1;
                    visited[mx][my] = true;
                    queue.add(new Loc(mx, my));
                    if(mx == goal_x && my == goal_y) {
                        check = true;
                        break;
                    }
                }
            }
            if (check)
                break;
        }
        if (check)
            return mmap[goal_x][goal_y];
        else
            return -1;
    }

    public static class Loc{
        private int x, y;
        Loc(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
