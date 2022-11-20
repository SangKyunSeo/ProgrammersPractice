import java.util.*;
import java.io.*;

public class Main {

	static int n = 0;
	static List<String> list = new ArrayList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		String pattern = br.readLine();
		for(int i=0;i<n;i++) {
			list.add(br.readLine());
		}
		String start = pattern.substring(0,pattern.indexOf("*"));
		String end = pattern.substring(pattern.indexOf("*")+1,pattern.length());
	
		for(int i=0;i<list.size();i++) {
			if(list.get(i).startsWith(start)&&list.get(i).endsWith(end)&&list.get(i).length()>=pattern.length()-1)
				System.out.println("DA");
			else
				System.out.println("NE");
			
		}
	}

}
