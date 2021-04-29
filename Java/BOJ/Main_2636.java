import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

// 치즈
// BFS
public class Main_2636 {

	public static int board[][];
	public static boolean visited[][];
	public static boolean visited_1[][];
	public static int dx[] = {-1, 0, 1, 0};
	public static int dy[] = {0, -1, 0, 1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		board = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int result, hour = result = 0;

		while(true) {
			int cnt = 0;
			BFS_air(0, 0, N, M);
			BFS_melt(0, 0, N, M);
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if(visited_1[i][j]) {
						cnt++;
						board[i][j] = 0;
					}
//					System.out.printf(board[i][j] + " ");
				}
//				System.out.println();
			}
//			System.out.println();
			if (cnt == 0) {
				break;
			}
			hour++;
			result = cnt;
		}
		System.out.println(hour);
		System.out.println(result);
	}
	
	public static void BFS_air(int x, int y, int N, int M) {
		visited = new boolean[N][M];
		Queue<Loc> queue = new LinkedList<>();
		queue.add(new Loc(x, y));
		visited[x][y] = true;
		
		while(!queue.isEmpty()) {
			Loc loc = queue.poll();
			for (int i = 0; i < 4; i++) {
				int mx = loc.x + dx[i];
				int my = loc.y + dy[i];
				if( mx >= 0 && mx < N && my >= 0 && my < M && board[mx][my]==0 && !visited[mx][my]) {
					visited[mx][my] = true;
					queue.add(new Loc(mx, my));
					
				}
			}
		}
	}
	
	public static void BFS_melt(int x, int y, int N, int M) {
		visited_1 = new boolean[N][M];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				for (int k = 0; k < 4; k++) {
					int mx = i + dx[k];
					int my = j + dy[k];
					if( mx >= 0 && mx < N && my >= 0 && my < M) {
						if(visited[i][j]== true && board[mx][my] == 1 ){
							visited_1[mx][my] = true;
						}
					}
				}
			}
		}	
	}
	
	public static class Loc{
		private int x, y;
		Loc(int x, int y){
			this.x = x;
			this.y = y;
		}
	}

}
