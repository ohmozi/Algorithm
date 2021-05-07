import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

// 쇠막대기
// 스택

public class Main_10799 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		int result = pipe(input);
		System.out.println(result);
	}
	
	public static int pipe(String input) {
		Stack<Integer> st = new Stack<>();
		int count = 0;
		for (int i = 0; i < input.length(); i++) {
			if(input.substring(i,i+1).equals("("))
				st.push(i);
			else {				
				if(st.peek() == i-1) {		//  레이저를 만나면
					st.pop();				
					count+=st.size();			// 막대의 종류(개수)만큼 추가
				}
				else {					// 레이저가 아닌 막대의 끝을 만나면
					st.pop();			// 막대 한종류는 끝,  단면의 마지막에 한덩이 추가
					count++;
				}
			}
		}
		return count;
	}
}
