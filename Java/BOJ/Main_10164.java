import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 격자상의 경로
// DFS

public class Main_10164 {

	public static int board[][];
	public static int[] dx = {0, 1};		// 오른쪽아래로만 이동, 방문여부 체크 불필요
	public static int[] dy = {1, 0};
	public static int cnt = 0;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int param[] = new int[3];
		
		for (int i = 0; i < param.length; i++) {
			param[i] = Integer.parseInt(st.nextToken());
		}
		board = new int[param[0]][param[1]];
		
		if(param[2] == 0) {			// 체크포인트가 없을때
			System.out.println(DFS(0,0,param[0]-1, param[1]-1));
		}
		else {
			int checkPointX = (param[2]-1) / param[1];	 // 체크포인트 계산 헷깔리지않기(ex. 3,5,5)
			int checkPointY = (param[2]-1) % param[1];
//			System.out.println(checkPointX +", " + checkPointY);
			int result_1 = DFS(0, 0, checkPointX, checkPointY);		// 시작점부터 체크포인트까지 경로
			cnt = 0;		// 전역변수 초기화
			int result_2 = DFS(checkPointX, checkPointY, param[0]-1, param[1]-1);	// 체크포인트에서 도착점까지 경로
			System.out.println(result_1*result_2);
		}
		
	}
	
	public static int DFS(int startX, int startY, int endX, int endY) {
		if(startX == endX && startY == endY)		// 탈출조건
			cnt++;
		
		for (int i = 0; i < 2; i++) {
			int mx = startX + dx[i];
			int my = startY + dy[i];
			if( mx >= 0 && mx <= endX && my >= 0 && my <= endY) {
				DFS(mx, my, endX, endY);
			}
		}
		return cnt;
	}
}