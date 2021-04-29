import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 줄자 접기
public class Main_2597_fail {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		float N = Integer.parseInt(br.readLine());
		Red red;
		Yellow yellow;
		Blue blue;
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		red = new Red(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		st = new StringTokenizer(br.readLine());
		blue = new Blue(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		st = new StringTokenizer(br.readLine());
		yellow = new Yellow(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

		float mark = (red.r1 + red.r2)/2;
//		System.out.println(mark);
		if(mark <= N/2) {
			blue.b1 = Math.abs(mark - blue.b1);  // 절댓값으로 보면?
			blue.b2 = Math.abs(blue.b2 - mark);
			yellow.y1 = Math.abs(mark - yellow.y1);  // 절댓값으로 보면?
			yellow.y2 = Math.abs(yellow.y2 - mark);
		}
		else {
			blue.b2 = N - (blue.b2 - mark);
			yellow.y2 = N - (yellow.y2 - mark);
		}
		N = (mark > N/2) ? mark : N - mark;
//		System.out.println(N);
		
		// 0-----------
		mark = (blue.b1 + blue.b2)/2;
//		System.out.println(blue.b1 + " " + blue.b2);
//		System.out.println(mark);
		if(mark != blue.b1) {
			if(mark <= N/2) {
				yellow.y1 = Math.abs(mark - yellow.y1);  // 절댓값으로 보면?
				yellow.y2 = Math.abs(yellow.y2 - mark);
			}
			else {
				yellow.y2 = N - (yellow.y2 - mark);
			}
			N = (mark > N/2) ? mark : N - mark;
		}
//		System.out.println(N);
		
		mark = (yellow.y1 + yellow.y2)/2;
//		System.out.println(mark);
		if(mark != yellow.y1) {
			N = (mark > N/2) ? mark : N - mark;
		}
//		System.out.println(N);
		int result = (int) (N*10);
		float res = (float) (result/10.0);
		System.out.println(res);
	}
	
	public static class Red{
		private float r1, r2;
		Red(float r1, float r2) {
			this.r1 = r1;
			this.r2 = r2;
		}
	}
	public static class Yellow{
		private float y1, y2;
		Yellow(float y1, float y2) {
			this.y1 = y1;
			this.y2 = y2;
		}
	}
	public static class Blue{
		private float b1, b2;
		Blue(float b1, float b2) {
			this.b1 = b1;
			this.b2 = b2;
		}
	}

}
