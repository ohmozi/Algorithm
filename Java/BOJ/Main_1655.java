import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 가운데를 말해요
// 우선순위큐
public class Main_1655 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		PriorityQueue<Integer> priorityQueueMin = new PriorityQueue<>();
		PriorityQueue<Integer> priorityQueueMax = new PriorityQueue<>(Collections.reverseOrder());
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			int number = Integer.parseInt(br.readLine());
			// 일단 짝수 홀수번에 따라 집어넣기
			if(priorityQueueMax.size() == priorityQueueMin.size()) 
				priorityQueueMax.add(number);
			else
				priorityQueueMin.add(number);
			// 그 후에 우선순위를 비교해서 스왑하기
			if(!priorityQueueMax.isEmpty() && !priorityQueueMin.isEmpty()) {
				if(priorityQueueMin.peek() < priorityQueueMax.peek()) {		// 스왑필요
					int temp = priorityQueueMax.poll();
					priorityQueueMin.add(temp);
					priorityQueueMax.add(priorityQueueMin.poll());
				}	
			}
			sb.append(priorityQueueMax.peek() + "\n");
		}
		System.out.println(sb);
	}

}
