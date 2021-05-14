import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 경사로
// 구현
// 1. 경사로의 길이가 중요
// 2. 지금칸과 다음칸의 차이가 2이상이면 바로 끝
// 3. 차이가 1이면 경사로를 놓을수있는지 파악
// 4. 내려가는경우, 올라가는경우 파악

public class Main_14890 {
	public static int board[][];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		board = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int totalPass = 0;
		
		for (int i = 0; i < N; i++) {				// row check
			int flatCount = 1;
			boolean pass = true;
			for (int j = 1; j < N; j++) {
				if(Math.abs(board[i][j] - board[i][j-1]) > 1) {			// 2칸이상 차이날 경우
					pass = false;
					break;
				}
				else if(board[i][j] == board[i][j-1]) {		// 평평할 경우
					flatCount++;
				}
				else if(board[i][j] - board[i][j-1] == 1) {		// 높아지는 경사로를 사용해야하는 경우
					if(flatCount < L) {		// 경사로 길이보다 평평한 지형이 적을경우 - 패스불가
						pass = false;
						break;
					}
					else {
						flatCount = 1;		// 경사로를 사용했기때문에 지금까지 평평한 카운트 초기화
					}
				}
				else if(board[i][j-1] - board[i][j] == 1) {		// 낮아지는 경사로를 사용해야하는 경우
					int downSlope = 0;
					for (int j2 = 0; j2 < L; j2++) {
						if(j+j2 < N && board[i][j+j2] == board[i][j])
							downSlope++;
					}
					if(downSlope < L) {			// 경사로 길이보다 평평한 지형이 적을경우 - 패스불가
						pass = false;
						break;
					}
					if(downSlope == L) {
						j = j + (L-1);		// 경사로 사용하고, 경사로 길이만큼 건너뛰기
						flatCount = 0;		// 경사로를 사용했기때문에 지금까지 평평한 카운트 초기화
					}
				}
			}
			if(pass) {
				totalPass++;
//				System.out.println("pass row " + i);
			}
		}
		
		for (int j = 0; j < N; j++) {				// col check
			int flatCount = 1;
			boolean pass = true;
			for (int i = 1; i < N; i++) {
				if(Math.abs(board[i][j] - board[i-1][j]) > 1) {
					pass = false;
					break;
				}
				else if(board[i][j] == board[i-1][j]) {
					flatCount++;
				}
				else if(board[i][j] - board[i-1][j] == 1) {		// 높아지는 경사로를 사용해야하는 경우
					if(flatCount < L) {
						pass = false;
						break;
					}
					else {
						flatCount = 1;		// 경사로를 사용했기때문에 지금까지 평평한 카운트 초기화
					}
				}
				else if(board[i-1][j] - board[i][j] == 1) {		// 낮아지는 경사로를 사용해야하는 경우
					int downSlope = 0;
					for (int j2 = 0; j2 < L; j2++) {
						if(i+j2 < N && board[i+j2][j] == board[i][j])
							downSlope++;
					}
					if(downSlope < L) {
						pass = false;
						break;
					}
					if(downSlope == L) {
						i = i + (L-1);
						flatCount = 0;		// 경사로를 사용했기때문에 지금까지 평평한 카운트 초기화
					}
				}
			}
			if(pass) {
				totalPass++;
//				System.out.println("pass col " + j);
			}
		}
		
		System.out.println(totalPass);
	}
}
