import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


// 달팽이는 올라가고 싶다

public class Main_2869 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());			
		int B = Integer.parseInt(st.nextToken());
		int V = Integer.parseInt(st.nextToken());
		
		int day = (V-A)/(A-B);
		int loc = (A-B)*day;
		while(true) {
			day++;
			loc += A;
			if(loc >= V)
				break;
			else
				loc -= B;
		}
		System.out.println(day);
	}
}
