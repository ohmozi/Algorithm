import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 히스토그램

public class Main_1725 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int areaMax = 0; 
		int area = 0;
		
		int height = 0;
		for (int i = 0; i < N; i++) {
			int hist = Integer.parseInt(br.readLine());
			if(height <= hist) {
				area += hist;
				System.out.println("area : "+area);
			}
			else {
				area = hist;
				height = hist;
			}
			if(areaMax < area) {
				areaMax = area;
				System.out.println(areaMax);
			}
		}
	}
}
