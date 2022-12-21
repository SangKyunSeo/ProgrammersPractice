
/*
 * 홀수 홀릭 호서
 */
import java.util.*;
import java.io.*;
public class Main {

	static int count = 0;
	static boolean exit = false;
	static int min = Integer.MAX_VALUE;
	static int max = Integer.MIN_VALUE;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		
		solve(s,findOdd(s));
		
		System.out.println(min+" "+max);
	}
	public static void solve(String num,int total) {
		
		int n = Integer.parseInt(num);
		if(n>=100)three(n,total);
		else if(n>=10)two(n,total);
		else{
			min = Math.min(min, total);
			max = Math.max(max, total);
		}
		
	}
	public static int findOdd(String num) {
		int count = 0;
		for(int i=0;i<num.length();i++) {
			if(Character.getNumericValue(num.charAt(i))%2!=0)count++;
		}
		return count;
	}
	public static void three(int n,int total) {
		String s = Integer.toString(n);
		for(int i=1;i<s.length()-1;i++) {
			for(int j=i+1;j<s.length();j++) {
				String a = s.substring(0,i);
				String b = s.substring(i,j);
				String c = s.substring(j,s.length());
				
				int sum = Integer.parseInt(a) + Integer.parseInt(b) + Integer.parseInt(c);
				solve(Integer.toString(sum),total+findOdd(Integer.toString(sum)));
			}
		}
		
	}
	public static void two(int n,int total) {
		findOdd(Integer.toString(n));
		int ten = n/10;
		int one = n%10;
		int sum = ten + one;
		solve(Integer.toString(sum),total+findOdd(Integer.toString(sum)));
	}
	

}
