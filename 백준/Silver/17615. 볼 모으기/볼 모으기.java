
/*
 * 볼 모으기
 */
import java.util.*;
import java.io.*;

public class Main {

	static int n;
	static String balls;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		balls = br.readLine();
		int aCount = 0;
		int bCount = 0;
		int idx = balls.length()-1;
		char end = balls.charAt(balls.length()-1);
		
		for(int i=balls.length()-2;i>=0;i--) {
			if(balls.charAt(i)==end) {
				if(i==idx-1) {
					idx=i;
				}else
					aCount++;
			}else {
				bCount++;
			}
		}
		
		System.out.println(Math.min(bCount, aCount));

	}

}
