import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 숫자 게임

public class Main_2303 {

	public static int[][] board;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		board = new int[N][5];
		int[] sumList = new int[N];
		int[] firstNumList = new int[N];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int sum = 0;
			for (int j = 0; j < 5; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				sum+=board[i][j];
			}
			sumList[i] = sum;
		}
		
		for (int i = 0; i < N; i++) {
			// 2개 숫자 선택해서 합에서 빼기
			int max = 0;
			for (int j = 0; j < 5-1; j++) {
				for (int k = j+1; k < 5; k++) {
					int temp = sumList[i] - (board[i][j] + board[i][k]);
					temp = temp % 10;
					if(temp > max) {
						max = temp;
					}
				}	
			}
			firstNumList[i] = max;
		}
		int answer = 0;
		int max = 0;
		for (int i = 0; i < firstNumList.length; i++) {
//			System.out.println(firstNumList[i]);
			if(max <= firstNumList[i] ) {
				max = firstNumList[i];
				answer = i;
			}
		}
		System.out.println(answer+1);
	}
}
