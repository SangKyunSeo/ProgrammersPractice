

import java.util.*;
import java.io.*;

public class Main {

	final static int mod = 10007;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		long[][] d = new long[n+1][10];
		
		for(int i=0;i<10;i++) {
			d[1][i]=1;
		}
		
		for(int i=2;i<=n;i++) {
			for(int j=0;j<10;j++) {
				for(int k=j;k<10;k++) {
					d[i][j]=(d[i][j]+d[i-1][k])%mod;
				}
			}
			
		}
		
		long result = 0;
		for(int i=0;i<10;i++) {
			result += d[n][i];
		}
		System.out.println(result%mod);

	}

}
