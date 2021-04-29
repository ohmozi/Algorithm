import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 평균은 넘겠지
// 사칙연산

public class Main_4344 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int M = Integer.parseInt(st.nextToken());
			int array[] = new int[M];
			
			int total = 0;
			for (int j = 0; j < M; j++) {
				int temp = Integer.parseInt(st.nextToken());
				total += temp;
				array[j] = temp;
			}
			
			float avg = (float)total/M;
			int count = 0;
			for (int j = 0; j < M; j++) {
				if(avg < array[j])
					count++;
			}
			
			float result = (float)count/M;
			System.out.println(String.format("%.3f", result*100)+"%");
		}
	}
}
