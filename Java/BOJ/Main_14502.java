import java.awt.List;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 연구소
// BFS와 DFS

public class Main_14502 {

	public static int board[][];
	public static int board_virus[][];
	public static int temp[][];
	public static boolean visited[][];
	public static int dx[] = {-1, 0, 1, 0};
	public static int dy[] = {0, -1, 0, 1};
	public static int N, M;
	public static ArrayList<Integer> safeAreaList = new ArrayList<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		board = new int[N][M];
		temp = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 1.벽을세운다
		// 2.바이러스감염
		// 3.카운트

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(board[i][j] == 0) {				// 벽을 하나 정해서 세우기   (벽을 세울때마다 즉, DFS를 하기 전에 board의 상태를 복사해놔야해서 벽하나 선택한 이후에 DFS(2)만 진행하기 ) -> 이부분이 헷깔렸음
					for (int a = 0; a < N; a++) {
						for (int b = 0; b < M; b++) {
							temp[a][b] = board[a][b];
						}
					}
					
					temp[i][j] = 3;
					DFS(1);
					temp[i][j] = 0;
				}
			}
		}

		safeAreaList.sort(null);
		System.out.println(safeAreaList.get(safeAreaList.size()-1));
	}
	
	public static void DFS(int count) {			// 브루트포스
		if(count == 3) {
			BFS();						// 벽을 3개 세우면 그 상황에서 바이러스 퍼진 모습 확인
//			Print();
			return;
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(temp[i][j] == 0) {
					temp[i][j] = 3;		// 벽세우기
					DFS(count+1);
					temp[i][j] = 0;		// 벽허물기
				}
			}	
		}
	}
	
	public static void BFS() {			// 벽을 세우고나서 바이러스가 퍼진후, 안전영역의 크기를 구한다.
		visited = new boolean[N][M];
		board_virus = new int[N][M];
		for (int i = 0; i < N; i++) {			// 벽세운 모습 복사
			for (int j = 0; j < M; j++) {
				board_virus[i][j] = temp[i][j];
			}
		}
		for (int i = 0; i < N; i++) {			// 바이러스 퍼진다.
			for (int j = 0; j < M; j++) {
				if(board_virus[i][j] == 2 && !visited[i][j]) {
					BFS_virus(i, j);
				}
			}
		}
		
		int cnt = 0;
		for (int i = 0; i < N; i++) {			// 안전영역 카운트
			for (int j = 0; j < M; j++) {
				if(board_virus[i][j] == 0)
					cnt++;
			}
		}
		safeAreaList.add(cnt);
	}
	
	public static void BFS_virus(int x, int y) {		// 바이러스 퍼지는 것 계산
		visited[x][y] = true;
		Queue<Loc> queue = new LinkedList<>();
		queue.add(new Loc(x,y));
		
		while(!queue.isEmpty()) {
			Loc loc = queue.poll();
			for (int i = 0; i < 4; i++) {
				int mx = loc.x + dx[i];
				int my = loc.y + dy[i];
				if(mx >=0 && mx <N && my >= 0 && my < M && board_virus[mx][my]==0 && !visited[mx][my]) {
					visited[mx][my] = true;
					board_virus[mx][my] = 2;
					queue.add(new Loc(mx, my));
				}
			}
		}
	}
	
	public static void Print() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(board_virus[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("===================");
	}
	
	public static class Loc{
		private int x, y;
		Loc(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
}
