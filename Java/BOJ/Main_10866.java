import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

// 덱

public class Main_10866 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Deque<Integer> queue = new LinkedList<>();
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String oper = st.nextToken();
			
			switch(oper){
			case "push_back":
				int num1 = Integer.parseInt(st.nextToken());
				queue.addLast(num1);
				break;
				
			case "push_front":
				int num2 = Integer.parseInt(st.nextToken());
				queue.addFirst(num2);
				break;
				
			case "pop_back":
				if(queue.isEmpty())
					System.out.println(-1);
				else
					System.out.println(queue.pollLast());
				break;
				
			case "pop_front":
				if(queue.isEmpty())
					System.out.println(-1);
				else
					System.out.println(queue.pollFirst());
				break;
				
			case "size":
				System.out.println(queue.size());
				break;
				
			case "empty":
				if(queue.isEmpty())
					System.out.println(1);
				else
					System.out.println(0);
				break;
				
			case "back":
				if(queue.isEmpty())
					System.out.println(-1);
				else
					System.out.println(queue.peekLast());
				break;
				
			case "front":
				if(queue.isEmpty())
					System.out.println(-1);
				else
					System.out.println(queue.peekFirst());
				break;
			}
		}
	}
}
