import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 전자레인지
// 단순계산

public class Main_10162 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
//		5분:300초  / 1분:60초  / 10초
		int[] ans = new int[3];
		
		if(N%10 != 0) {
			System.out.println("-1");
		}
		else {
			ans[0] = N/300;
			ans[1] = (N%300)/60;
			ans[2] = ((N%300)%60)/10;

			for (int i : ans) {
				System.out.printf(i + " ");
			}
		}
	}
//	Scanner sc= new Scanner(System.in);
//	int k= sc.nextInt();
//	int a=k/300,b=(k%300)/60,c=((k%300)%60)/10;
//	
//	if(k%10!=0) {System.out.println(-1);}
//	else {System.out.println(a+" "+b+" "+c);}
}