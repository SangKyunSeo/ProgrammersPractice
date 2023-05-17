
import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException{
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String str = br.readLine();
			int dp[] = new int[str.length()+1];
			char ch[] = str.toCharArray();
			int DIV = 1000000;
			if(str.charAt(0)=='0') {
				System.out.println(0);
				return;
			}
			dp[1]=1;
			dp[0]=1;
			for(int i=2;i<=str.length();i++) {
				String s = Character.toString(ch[i-2])+ch[i-1];
				if(ch[i-1]=='0') {
					if(ch[i-2]=='1' || ch[i-2]=='2') {
						dp[i]=dp[i-2]%DIV;
					}else {
						System.out.println(0);
						return;
					}
				}else {
					if(ch[i-2]=='0')
						dp[i]=dp[i-1]%DIV;
					else {
						if(Integer.parseInt(s)>=1 && Integer.parseInt(s)<=26)dp[i]=(dp[i-1]+dp[i-2])%DIV;
						else
							dp[i]=dp[i-1]%DIV;
					}
				}
			}
			System.out.println(dp[str.length()]%DIV);
			
			

	}

}
