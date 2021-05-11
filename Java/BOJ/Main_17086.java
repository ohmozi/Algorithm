import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 아기상어 2
// BFS

public class Main_17086 {
	public static int board[][];
	public static boolean visited[][];
	public static int[] dx = {-1, 0, 1, 0, -1, -1, 1, 1};			// 8방향
	public static int[] dy = {0, 1, 0, -1, -1, 1, -1, 1};
	public static int safeDistanceMax = 0;
	public static int N, M;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		board = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(board[i][j]==0) {
					visited = new boolean[N][M];
					BFS(i, j, 0);
				}
			}
		}
		System.out.println(safeDistanceMax);

	}
	public static void BFS(int x, int y, int d) {
		Queue<Loc> queue = new LinkedList<>();
		queue.add(new Loc(x, y, d));
		visited[x][y] = true;
		
		while(!queue.isEmpty()) {
			Loc loc = queue.poll();
			if(board[loc.x][loc.y] == 1) {
				if(safeDistanceMax < loc.dist) {
					safeDistanceMax = loc.dist;
				}
				break;
			}
			for (int i = 0; i < 8; i++) {
				int mx = loc.x + dx[i];
				int my = loc.y + dy[i];
				if((mx>=0 && mx<N) && (my>=0 && my<M) && !visited[mx][my]) {
					queue.add(new Loc(mx, my, loc.dist + 1));
					visited[mx][my] = true;
				}
			}
		}
	}
	
	public static class Loc{
		private int x, y, dist;
		Loc(int x, int y, int dist){
			this.x = x;
			this.y = y;
			this.dist = dist;
		}
	}
}
