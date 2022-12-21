
/*
 * A와 B 2
 */
import java.util.*;
import java.io.*;

public class Main {

	static String s;
	static String t;
	static int check = 0;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		s = br.readLine();
		t = br.readLine();
		
		dfs(s);
		if(check!=0)System.out.println(1);
		else System.out.println(0);
	}
	public static void dfs(String s) {
		if(s.length()==t.length()) {
			if(s.equals(t)) {
				check=1;
			}
			return;
		}
		
		if(t.contains(reverse(s+"A"))||t.contains(s+"A")) {
			dfs(s+"A");
			dfs(reverse(s+"B"));
		}
		else dfs(reverse(s+"B"));	
	}
	public static String reverse(String s) {
		StringBuilder sb = new StringBuilder();
		for(int i=s.length()-1;i>=0;i--) {
			sb.append(s.charAt(i));
		}
		return sb.toString();
	}

}
