import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 오목
// 좌표설정이 헷깔림

public class Main_2615 {

	public static int board[][] = new int[20][20];
	
	public static int dx[] = {-1, 0, 1, 1};				// 정방향
	public static int dy[] = {1, 1, 1, 0};				// 2시, 3시, 5시, 6시   4가지만 보면되지않을까  		
	public static int xx[] = {1, 0, -1, -1};			// 역방향
	public static int xy[] = {-1, -1, -1, 0};			// 7시, 9시, 11시, 12시
	// 찾고자하는 방향 반대로 이전에 같은 색이있는지만 확인하기
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int i = 1; i < 20; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 1; j < 20; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		boolean isWinner = false;			// 승리자가 있는지 없는지
		for (int j = 1; j < 20; j++) {
			for (int i = 1; i < 20; i++) {
				if(board[i][j] != 0) {		// 바둑알이 놓여있으면 왼쪽열부터 스캔하면서 DFS
					for (int k = 0; k < 4; k++) {
						int result = 0;
						
						int mmx = i + xx[k];		// 역방향이 현재돌과 색이 다를때  탐색진행
						int mmy = j + xy[k];
						if(mmx >= 0 && mmx <=19 && mmy >= 0 && mmy <=19 && board[mmx][mmy]!=board[i][j]) {
							result = DFS(i, j, k, board[i][j]);
						}
						
//						System.out.println(i + ", " + j + " / " + k + " => " + result);
						if(result == 5) {			// 5개가 연속이면 승리자 존재
							isWinner= true;
							System.out.println(board[i][j]);
							System.out.println(i + " " + j);
							return;
						}
					}
				}
			}
		}
		if(!isWinner)				
			System.out.println(0);
	}
	
	public static int DFS(int x, int y, int option, int color) {			// 색을 넘겨받아야한다. 8방향을 그대로 쭉가봐야한다.( 8방향을 보는게 맞나? )
		int result = 1;
		int mx = x;
		int my = y;
		while(true) {
			mx = mx + dx[option];
			my = my + dy[option];
			if(mx >= 1 && mx <= 19 && my >= 1 && my <= 19 && board[mx][my]==color ) {		// 같은색이면 카운트업
				result++;
			}
			else
				break;
		}
		return result;
	}
}
