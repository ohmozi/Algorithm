import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 감소하는 수
// 브루트포스로 하면 시간초과 날거같음  -> 최대한 건너뛰어서 시간 줄이기

public class Main_1038 {

	public static long MAX = 9876543210L;

	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		long target = 11;
		int count = 10;
	
		if(N <= 10) {			// 10 이하면 그냥 출력
			System.out.println(N);
			return;
		}
		if (N > 1022) {			// MAX를 넘어가면 -1
			System.out.println(-1);
			return;
		}
		
		else {
			while(count<N) {
				long temp = target;
				long jump = 1;				// 만족안하는 숫자들을 건너뛰기위함
				boolean check = true;				
				int before = (int) (temp%10);	// 뒷자리
				temp /= 10;
				
				while(temp > 0) {		// do while쓰던가
					int next = (int) (temp%10);		// 앞자리
					jump *= 10;
					
					if(next<=before) {
						check = false;
						break;
					}
					else {
						temp /= 10;
						before = next;
					}
				}

				if(check) {
//					System.out.println(target);
					count++;
					target++;
				}
				else {
					target += jump;
					target = target / jump * jump; 		// 맨 끝자리를 0으로 초기화
//					System.out.println("jump : " + target);
				}
			}

			System.out.println(target-1);
		}
	}
}
