package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_8979 {
    //  1. 올림픽
    //
    //  2. 금, 은, 동 메달로 순위매기기
    //
    //  3. Comparator , Comparable 사용해서 비교연산자 구현
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        ArrayList<Country> arr = new ArrayList<>();
        for (int i =0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());       // 여기 효율적으로 input받는 방법 고치기
            int g = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            Country con = new Country(n,g,s,c);
            arr.add(con);
        }
//        for (int i =0; i < arr.size(); i++){
//            System.out.println(arr.get(i).num + " : " + arr.get(i).score);
//        }
        Collections.sort(arr);

//        System.out.println("========sort========");
//        for (int i = arr.size()-1; i >= 0; i--) {
//            System.out.print(arr.get(i).num + ", ");
//        }
//        System.out.println();
//        System.out.println("========debug========");

        // ***comparable 이용

        int rank = 0;
        int before_g = 0;
        int before_s= 0 ;
        int before_c = 0;
        for (int i = arr.size()-1; i >= 0; i--){
            if (! (before_g == arr.get(i).getGold() && before_s == arr.get(i).getSilver() && before_c == arr.get(i).getCopper())){
                rank = N-i;
            }
            before_g = arr.get(i).getGold();
            before_s = arr.get(i).getSilver();
            before_c = arr.get(i).getCopper();

//            System.out.println(arr.get(i).num + "  -> ranking : " + rank);
            if(arr.get(i).num == K)
                break;
        }
//        System.out.println("\nresult: " + rank);
        System.out.println(rank);
    }
    public static class Country implements Comparable<Country>{
        private int num, gold, silver, copper;
//        private int score;
        Country(int n, int g, int s, int c){
            this.num = n;
            this.gold = g;
            this.silver = s;
            this.copper = c;
//            this.score = g*3 + s*2 + c;         // score로 계산하면 안됨  금메달 1개 = 3점/ 동메달 3개 = 3점  동일이됨
        }
        public int getGold(){
            return gold;
        }
        public int getSilver(){
            return silver;
        }
        public int getCopper(){
            return copper;
        }
//        public int getScore(){
//            return score;
//        }
        @Override
        public int compareTo(Country c) {
            return Comparator.comparing(Country::getGold)
                    .thenComparing(Country::getSilver)
                    .thenComparing(Country::getCopper)
                    .compare(this, c);
        }
/*
        // *** 이 방법도 됨
        골드가 같지않다면 -1이 리턴되면서 골드 내림차순으로 정렬
        골드가 같다면 은메달 문으로 들어가서 마찬가지
        실버가 같다면 동메달 문으로 들어가서 마찬가지
        @Override
        public int compareTo(Country c) {
            if(this.gold == c.gold) {
                if(this.silver == c.silver) {
                    return c.copper - this.copper;
                }
                return c.silver - this.silver;
            }
            return c.gold - this.gold;
        }
*/

//        @Override
//        public int compareTo(Country c){        // 내림차순 정렬
//            if(this.score > c.getScore()){
//                return -1;
//            }
//            else if(this.score < c.getScore()){
//                return 1;
//            }
//            return 0;
//        }
    }
}
