import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 촌수계산
// 플로이드와샬

public class Main_2644 {

	public static int INF = 999999;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int board[][] = new int[n+1][n+1];
		for (int i = 0; i <= n; i++) {
			for (int j = 0; j <= n; j++) {
				board[i][j] = INF;
			}
		}
		StringTokenizer st = new StringTokenizer(br.readLine());
		int person1 = Integer.parseInt(st.nextToken());
		int person2 = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			board[x][y] = board[y][x] = 1;
		}
		
		// 플로이드 와샬 알고리즘
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				for (int k = 1; k <= n; k++) {
					 if (board[j][k] > board[j][i] + board[i][k]) {
					 	board[j][k] = board[j][i] + board[i][k];
                    }
				}
			}
		}
		if(board[person1][person2] < INF)
			System.out.println(board[person1][person2]);
		else
			System.out.println(-1);
	}
}
