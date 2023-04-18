
import java.util.*;
import java.io.*;

public class Main {
	
	final static long mod = 1000000000;
	
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		long[][] d = new long[n+1][10];
		
		for(int i=1;i<=9;i++) {
			d[1][i]=1;
		}
		
		for(int i=2;i<=n;i++) {
			for(int j=0;j<10;j++) {
				
				if(j==0)
					d[i][0]=d[i-1][1]%mod;
				else if(j==9)
					d[i][9]=d[i-1][8]%mod;
				else
					d[i][j]=(d[i-1][j-1]+d[i-1][j+1])%mod;
				
			}
		}
		
		long result = 0;
		for(int i=0;i<10;i++) {
			result+=d[n][i];
		}
		System.out.println(result%mod);
	}

}
