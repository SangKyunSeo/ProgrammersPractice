
/*
 * 카잉달력
 */

import java.io.*;
import java.util.*;

public class Main {
 
	static int M;
	static int N;
	static int x;
	static int y;
	static int lcm;
	
	 public static int getGCD(int num1, int num2) {
	        
		 while(num2!=0) {
			 int r = num1%num2;
			 num1=num2;
			 num2=r;
		 }
		 return num1;
	    }
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int k = Integer.parseInt(br.readLine());
		
		for(int i=0;i<k;i++) {
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			
			lcm=M*N/getGCD(M,N);
			
			int n=0;
			int ans = -1;
			while(n*M<lcm) {
				if((n*M+x-y)%N==0) {
					ans=n*M+x;
					break;
				}
				n++;
			}
			
			System.out.println(ans);
		}
		

	}

}
