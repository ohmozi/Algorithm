import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2621_next {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int colorCount[] = new int[4];
		int numberTotal = 0;
		int numberCount[] = new int[10];
		for (int i = 0; i < 5; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			char color = st.nextToken().charAt(0);
			int number = Integer.parseInt(st.nextToken());
			
			numberCount[number]++;
			
			switch (color) {
				case 'R':
					colorCount[0]++;
					break;
				case 'G':	
					colorCount[1]++;
					break;
				case 'B':
					colorCount[2]++;
					break;
				case 'Y':
					colorCount[3]++;
					break;
			}
				
			
		}

	}

}
