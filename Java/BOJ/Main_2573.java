import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 빙산
// BFS

public class Main_2573 {

	public static int board[][];
	public static int board_temp[][];
	public static boolean visited[][];
	public static int[] dx= {-1, 0, 1, 0};
	public static int[] dy= {0, -1 ,0 ,1};
	
	public static int N, M;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		board = new int[N][M];
		board_temp = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int years = 0;
		boolean all_melt = false;
		while(true) {
			years++;
			adjacent();		// 얼마나 물이 인접한지 탐색
//			printBoard();
			visited = new boolean[N][M];
			int group = 0;
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if(board[i][j]!=0 && !visited[i][j])
						group += BFS(i, j);		// 덩어리의 개수 탐색
				}
			}
//			System.out.println(years + " years : " + group);
			if(group >= 2) {		// 덩어리가 2 이상
				break;
			}
			if(group == 0) {		// 모두 녹으면 덩어리가 0
				all_melt = true;
				break;
			}
		}
		
		if(all_melt)			// 모두 녹음
			System.out.println(0);
		else
			System.out.println(years);
	}
	
	public static void adjacent() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				int cnt = 0;
				if(board[i][j] != 0) {
					for (int k = 0; k < 4; k++) {
						int mx = i + dx[k];
						int my = j + dy[k];
						if( mx >= 0 && mx < N && my >= 0 && my < M && board[mx][my]==0) // 주변이 물이면 카운트업
							cnt++;
					}
				}
				if(cnt > board[i][j])				// 주변 바다의 수가 빙산보다 많을때 기록
					board_temp[i][j] = board[i][j];
				else
					board_temp[i][j] = cnt;			// 빙산이 주변 바다수보다 높을때 기록
			}
		}
		for (int i = 0; i < N; i++) {		// 여기서 보드탐색을 한번에 해결할순없을까?
			for (int j = 0; j < M; j++) {
				board[i][j] -= board_temp[i][j];
			}
		}
	}
	
	public static int BFS(int x, int y) {
		visited[x][y] = true;
		Queue<Loc> queue = new LinkedList<>();
		queue.add(new Loc(x, y));
		while(!queue.isEmpty()) {
			Loc loc = queue.poll();
			for (int i = 0; i < 4; i++) {
				int mx = loc.x + dx[i];
				int my = loc.y + dy[i];
				if( mx >= 0 && mx < N && my >= 0 && my < M && board[mx][my]!=0 && !visited[mx][my]) {
					visited[mx][my] = true;
					queue.add(new Loc(mx, my));
				}
			}
		}
		return 1;
	}
	
	public static class Loc{
		private int x,y;
		Loc(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
}
