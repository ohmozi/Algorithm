import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 자동분무기
// https://milkclouds.github.io/2019/02/10/BOJ-2514-%EC%9E%90%EB%8F%99%EB%B6%84%EB%AC%B4%EA%B8%B0/

public class Main_2514_fail {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int[][] board = new int[8][8];
		int M = Integer.parseInt(br.readLine());
		int K = Integer.parseInt(br.readLine());
		for (int i = 0; i < board.length; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < board.length; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
			
		}
		
		

	}

}
