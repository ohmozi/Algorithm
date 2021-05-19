import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 공약수
// 정수론
// https://peanut2016.tistory.com/161

public class Main_2436 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());			
		int b = Integer.parseInt(st.nextToken());			
		b = b/a;			
		int x = 0;
		int res1, res2;
		
		for (int i = 1; i*i <= b; i++) {
			if(b%i==0 && gcd(i, b/i)==1) {
				x = i;
			}
		}
		res1 = x * a;
		res2 = (b/x) * a;
		System.out.println(res1 + " " + res2);

	}
	public static int gcd(int x, int y) {
		if (y == 0) {
			return x;
		}
		else {
			return gcd(y, x % y);
		}
	}
}
