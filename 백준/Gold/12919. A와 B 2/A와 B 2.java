
/*
 * A와 B 2
 */
import java.util.*;
import java.io.*;

public class Main {

	static String s;
	static String t;
	static boolean flag = false;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		s = br.readLine();
		t = br.readLine();
		
	
		dfs(s);
		
		if(flag)System.out.println(1);
		else System.out.println(0);
	}
	public static void dfs(String s) {
		if(s.length()>=t.length()) {
			if(s.equals(t))flag = true;
			return;
		}
		StringBuilder sb = new StringBuilder(s);
		StringBuilder ssb = new StringBuilder(s);
		if(t.contains(s+"A")||t.contains(ssb.append("A").reverse().toString())){
			dfs(s+"A");
			dfs("B"+sb.reverse().toString());
		}else {
			dfs("B"+sb.reverse().toString());
		}
	}
}
