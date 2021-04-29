import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 벨트
// 삼항연산자

public class Main_10834 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		
		int[] input = new int[3];
		int way = 0;
		int time = 1;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			
			for (int j = 0; j < 3; j++) {
				input[j] = Integer.parseInt(st.nextToken());
			}
			way += input[2];
			time = time/input[0]*input[1];
		}
		
		String answer = (way%2==0) ? "0 " : "1 ";
		
		answer += time;
		System.out.println(answer);
	}
}
