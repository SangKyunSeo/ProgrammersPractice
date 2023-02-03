
/*
 * 애너그램
 */
import java.util.*;
import java.io.*;

public class Main {

	static int n;
	static String str;
	static char[] ch;
	static int size;
	static char[] result;
	static char[] temp;
	static boolean visit[];
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		for(int i=0;i<n;i++) {
			str = br.readLine();
			ch = str.toCharArray();
			Arrays.sort(ch);
			size = str.length();
			visit = new boolean[size];
			result = new char[size];
			temp = new char[size];
			dfs(0);
		}
	}
	public static void dfs(int depth) {
		if(depth==size) {
			StringBuilder sb = new StringBuilder();
			for(int i=0;i<result.length;i++) {
				sb.append(result[i]);
			}
			System.out.println(sb.toString());
			return;
		}
		
		temp[depth]=0;
		for(int i=0;i<size;i++) {
			if(!visit[i]) {
				if(temp[depth]>=ch[i])continue;
				visit[i]=true;
				temp[depth]=ch[i];
				result[depth]=ch[i];
				dfs(depth+1);
				visit[i]=false;
			}
			
		}
	}

}
