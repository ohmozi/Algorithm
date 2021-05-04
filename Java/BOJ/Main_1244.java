import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


// 스위치 켜고 끄기

public class Main_1244 {
	public static boolean light[];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		light = new boolean[N+1];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			boolean temp = (Integer.parseInt(st.nextToken()) == 1) ? true : false;
			light[i] = temp;
		}
		
		int M = Integer.parseInt(br.readLine());
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int sex = Integer.parseInt(st.nextToken());
			int number = Integer.parseInt(st.nextToken());
			
			if(sex == 1) {					// 남자일경우 배수를 토글
				for (int j = 1; j <= N; j++) {
					if(j%number == 0)			
						light[j] = !light[j];	
				}
			} 
			else {						// 여자일경우 대칭을 토글
				light[number] = !light[number];
				int index = 0;
				while(true) {
					index++;
					if(number-index > 0 && number+index <= N) {			// 범위안에 있으면 진행
						if(light[number-index] == light[number+index]) {		// 대칭이면  토글
							light[number-index] = !light[number-index];
							light[number+index] = !light[number+index];
						}
						else 						// 대칭이 아니면 break
							break;
					} 
					else 					// 범위를 넘어가면 break
						break;
				}
			}
		}
		
		for (int i = 1; i <= N; i++) {				// print
			int num = (light[i] == true) ? 1 : 0;
			System.out.print(num + " ");
			if(i%20 == 0)
				System.out.println();
		}
	}
}
