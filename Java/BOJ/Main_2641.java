import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

// 다각형그리기
// 함수형으로 만들수있음

public class Main_2641 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int[] match = {3,4,1,2};
		int ans = 0;
		
		int N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		
		int[] num1 = new int[N];
		int[] num2 = new int[N];

		ArrayList<String> ansList = new ArrayList<>();
		
		for (int i = 0; i < N; i++) {
			int temp = Integer.parseInt(st.nextToken());
			num1[i] = temp;					// 시계방향 저장
			num2[N-1-i] = match[temp-1];	// 반시계방향 저장
		}
		
		int M = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < M; i++) {
			boolean status = false;
			int[] num3 = new int[N];
			
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {		// 타겟 저장
				num3[j] = Integer.parseInt(st.nextToken());
			}
			
			// 판단
			for (int j = 0; j < N; j++) {		// 타겟을 시계방향과 반시계방향과 비교
				int index = 0;
				for (int iter = 0; iter < N; iter++) {
					if(num1[index] == num3[(j+index)%N]) {		// 같으면 카운트 업
						index++;
					}
					else {					// 다르면 해당 반복 종료
						break;
					}
				}
				if(index==N) {				// 한 사이클 완료 후 카운트가 N과 같을 경우
					status=true;
					break;
				}
			}
			if(status) {			// 나중에 출력하기위해 string으로 만들어 저장한건데  이차원배열로 만들어서 플래그로 그냥 확인후 출력해도 될거같음(시간은 더 오래걸릴듯)
				String result = "";
				for (int j = 0; j < N; j++) {
					result += num3[j] + " ";
				}
				ansList.add(result);
				ans++;
				continue;
			}
			
			for (int j = 0; j < N; j++) {
				int index = 0;
				for (int iter = 0; iter < N; iter++) {
					if(num2[index]==num3[(j+index)%N]) {
						index++;
					}
					else {
						break;
					}
				}

				if(index==N) {
					status=true;
					break;
				}
			}

			if(status) {
				String result = "";
				for (int j = 0; j < N; j++) {
					result += num3[j] + " ";
				}
				ansList.add(result);
				ans++;
			}

		}
		System.out.println(ansList.size());	
		for (int i = 0; i < ansList.size(); i++) {
			System.out.println(ansList.get(i));
		}

	}

}
