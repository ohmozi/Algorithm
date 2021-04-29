import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 키 순서
// 플로이드 와샬

public class Main_2458 {
	public static final int INF = 987654321;
	public static int[][] board;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		board = new int[N+1][N+1];
		for (int i = 0; i < N+1; i++) {
			for (int j = 0; j < N+1; j++) {
				if(i != j)
					board[i][j] = INF;
			}
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			board[x][y] = 1;
		}
		// 플로이드 와샬 알고리즘
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				for (int k = 1; k <= N; k++) {
					 if (board[j][k] > board[j][i] + board[i][k]) {
					 	board[j][k] = board[j][i] + board[i][k];
                    }
				}
			}
		}
		
		int result = 0;
		for (int i = 1; i <= N; i++) {
			int count = 0;
			// 나에게로 올수있는것
			for (int j = 1; j <= N; j++) {
				if(i==j)		// 자신은 건너뛰기
					continue;
				if(board[i][j] != 987654321)
					count++;
			}
			// 내가 갈수있는 것
			for (int j = 1; j <= N; j++) {
				if(i==j)		// 자신은 건너뛰기
					continue;
				if(board[j][i] != 987654321)
					count++;
			}
			if(count == N-1)		// 자신을 뺀 나머지의 위치를 정확히 알면 됨
				result++;
		}
		/*
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
		*/
		System.out.println(result);
	}
}
