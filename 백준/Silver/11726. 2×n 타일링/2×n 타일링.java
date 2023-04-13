
import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		short n = Short.parseShort(br.readLine());
		
		int[] d = new int[n+1];
		d[0]=1;
		d[1]=1;
		if(n>=2) {
			for(int i=2;i<=n;i++) {
				d[i]=(d[i-2]+d[i-1])%10007;
			}
		}
		System.out.println(d[n]);
		

	}

}
