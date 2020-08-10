package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class arrayList구현 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int u = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        ArrayList<Point>[] list = new ArrayList[u];
        for (int i = 0; i < u; i++) {
            list[i] = new ArrayList<>();
        }

    }

    static class Point{
        int count;
        String first_buy;
        public Point(int count, String first_buy) {
            super();
            this.count = count;
            this.first_buy = first_buy;
        }
    }
}

