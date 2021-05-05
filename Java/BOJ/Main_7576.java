import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


// 토마토
// BFS

public class Main_7576 {

	public static int N, M;
	public static int board[][];
	public static boolean visited[][];
	public static int dx[] = {-1, 0, 1, 0};
	public static int dy[] = {0, -1, 0, 1};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		board = new int[M][N];
		visited = new boolean[M][N];
		for (int i = 0; i < M; i++) {		// 4
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {			//6
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int result = 0;
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if(board[i][j] == 1) {
					result += BFS(i,j);
				}
			}
		}
		System.out.println(result);

	}
	
	public static int BFS(int x, int y) {
		Queue<Loc> queue = new LinkedList<>();
		queue.add(new Loc(x, y));
		int count = -1;
		visited[x][y] = true;
		while(!queue.isEmpty()) {
			Loc loc = queue.poll();
			for (int i = 0; i < 4; i++) {
				int mx = loc.x + dx[i];
				int my = loc.y + dy[i];
				if( mx >= 0 && mx < M && my >= 0 && my < N && board[mx][my]==0 && !visited[mx][my]) {
					queue.add(new Loc(mx, my));
					visited[mx][my] = true;
				}
			}
		}
		System.out.println(count);
		return count;
	}
	public static class Loc{
		private int x, y;
		Loc(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}

// 토마토가 있는 부분(1)의 좌표를 저장해놓기
// 그 좌표부터 단계별로 BFS(더이상 갈곳이 없으면 break)
// 다 완료하고  스캔했는데 0인게 남아있다?  그럼 거긴 못가는곳임   -1출력

