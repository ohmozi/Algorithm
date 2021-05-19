import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 수열
// 이중포문으로 안풀기 - 80퍼쯤에서 틀림.. 왜틀리는지 모르겠음 ㅠ

public class Main_2559 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());			
		int K = Integer.parseInt(st.nextToken());
		
		int array[] = new int[N];	
		int temp = 0, max = Integer.MIN_VALUE;			// max를 0으로 풀면 틀림
		st = new StringTokenizer(br.readLine());
		if(K == N) {				// N=2, K=2일때
			for (int i = 0; i < N; i++) {
				array[i] = Integer.parseInt(st.nextToken());
				temp += array[i];
			}
			System.out.println(temp);
		}
		else {
			for (int i = 0; i < N; i++) {
				array[i] = Integer.parseInt(st.nextToken());
				temp += array[i];
				if(i > K-1) {			// K개 이상일경우 제외되는 값을 지워주고 최댓값 비교하기
					temp -= array[i-K];
					if(max < temp)
						max = temp;
				}
			}
			System.out.println(max);
		}
	}
}
