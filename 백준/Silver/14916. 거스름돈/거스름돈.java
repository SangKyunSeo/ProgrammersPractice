
/*
 * 거스름돈 - 탐욕 알고리즘
 */
import java.io.*;
public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int count = 0;
		if(n%5==0) {
			System.out.println(n/5);
			return;
		}else {
			while(n>0) {
				if(n%5!=0) {
					n-=2;
					count++;
				}else {
					System.out.println((n/5)+count);
					return;
				}
				
				if(n==0) {
					System.out.println(count);
					return;
				}
			}
		}
		System.out.println(-1);
	}

}
