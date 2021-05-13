import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

// 스택 수열
// 스택2개 선언

public class Main_1874 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		Stack<Integer> stLeft = new Stack<>();
		
		int index = 1;
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(br.readLine());
			if(stLeft.isEmpty()) {				// 스택이 비어있을때  푸시가 필요
				stLeft.add(index);
				index++;
				sb.append("+\n");
			}
			if(stLeft.peek() < num) {			// 푸시가 필요할 경우
				while(true) {
					stLeft.add(index);
					index++;
					sb.append("+\n");
					if(stLeft.peek() == num)
						break;
				}
			}
			if(stLeft.peek() >= num) {							// 팝이 필요할 경우
				while(true) {
					sb.append("-\n");
					if(stLeft.peek() == num) {
						stLeft.pop();
						break;
					}
					if(stLeft.peek() > num) {
						System.out.println("NO");
						return;
					}
				}
			}
		}
		System.out.println(sb.toString());
	}

}
