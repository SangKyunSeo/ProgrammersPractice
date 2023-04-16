

import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		short num = Short.parseShort(br.readLine());
		short n = 0;
		
		for(int i=0;i<num;i++) {
			n = Short.parseShort(br.readLine());
			int d[] = new int[n+1];
			
			d[0]=0;
			d[1]=1;
			if(n==2) {
				d[2]=2;
			}else if(n>=3) {
				d[2]=2;
				d[3]=4;
				for(int j=4;j<=n;j++) {
					d[j]=d[j-3]+d[j-2]+d[j-1];
				}
			}
			
			System.out.println(d[n]);
			
		}
		
		
	}

}
