import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 삼각형 만들기

public class Main_2622 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int cnt = 0;
		
		for (int i = 1; i <= N/2; i++) {
			for (int j = i; j <= N-1-i; j++) {
				int k = N - (i+j);
				if(k < j) 
					break;	// 중복제거
				if(i+j > k)
					cnt++;
			}
		}
		System.out.println(cnt);
	}
}