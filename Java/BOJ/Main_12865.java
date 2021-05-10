import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 평범한배낭
// DP Knapsack 알고리즘(무게와 가치가 따로있고 가치를 최대로하는 알고리즘)

public class Main_12865 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int item[][] = new int[101][2];
		int dp[][] = new int[101][100001];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			item[i][0] = Integer.parseInt(st.nextToken());
			item[i][1] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 1; i <= N; i++) {
			int weight = item[i][0];
			int value = item[i][1];
			for (int j = 0; j <= K; j++) {
				if(j<item[i][0])
					dp[i][j] = dp[i-1][j];
				else
					dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-weight]+value);
			}
		}
		/*  디버깅
		for (int i = 1; i <= N; i++) {
			for (int j = 0; j < 20; j++) {
				System.out.print(dp[i][j]+" ");
			}
			System.out.println();
		}*/
		System.out.println(dp[N][K]);
	}
}
