import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 프린터 큐
// 우선순위 큐 사용 생각

public class Main_1966 {

	public static int list[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		String result = "";
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int loc = Integer.parseInt(st.nextToken());
			
			Queue<Print> queue = new LinkedList<>();
			st = new StringTokenizer(br.readLine());
			list = new int[10];
			for (int j = 0; j < n; j++) {
				int value = Integer.parseInt(st.nextToken());
				list[value]++;
				queue.add(new Print(value, j));
			}
			
			boolean check_1 = false;
			boolean check_2 = false;
			int count = 0;
			for (int j = list.length-1; j >0 ; j--) {
				while(list[j]!=0) {
					int nowPrior = j;
					while(true) {
						Print print = queue.poll();
						if(print.prior != nowPrior) {
							queue.add(print);
						}
						if(print.prior == nowPrior) {
							list[j]--;
							count++;
							if(print.loc == loc) {
								check_1 = true;
								check_2 = true;
							}
							break;
						}
						
					}
					if(check_1)
						break;
				}
				if(check_2)
					break;
			}
			result += count +"";
			result += "\n";
		}

		System.out.println(result);
	}
	
	public static class Print{
		private int prior, loc;
		Print(int prior, int loc){
			this.prior = prior;
			this.loc = loc;
		}
	}

}
