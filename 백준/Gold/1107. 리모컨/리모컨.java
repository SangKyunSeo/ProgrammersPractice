

/*
 * 리모컨 - 브루트 포스
 */

import java.util.*;
import java.io.*;

public class Main {

	static int n;
	static int k;
	static List<Character> list = new ArrayList<>();
	static int countUp = 0;
	static int countDown = 0;
	static int onlyUp = 0;
	static int onlyDown = 0;
	static int min = Integer.MAX_VALUE;
	static int onlyMin = Integer.MAX_VALUE;
	static int a = 0, b=0;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());
		k = Integer.parseInt(br.readLine());
		if(k!=0) {
			st = new StringTokenizer(br.readLine());
			for(int i=0;i<k;i++) {
				list.add(st.nextToken().charAt(0));
			}
		}
	
		if(n==100) {
			System.out.println(0);
			return;
		}
		
		checkUp(n);
		checkDown(n);
		
		min = Math.min(countUp + String.valueOf(b).length(), countDown + String.valueOf(a).length());
		
		Up(n);
		Down(n);
		onlyMin = Math.min(onlyUp, onlyDown);
		min = Math.min(min, onlyMin);
		
		System.out.println(min);
	}
	public static void Up(int num) {
		int start = 100;
		while(true) {
			if(onlyUp == 500000) break;
			if(start!=num) {
				start++;
				onlyUp++;
			}else {
				break;
			}
		}
	}
	public static void Down(int num) {
		int start = 100;
		while(true) {
			if(onlyDown == 500000) break;
			if(start!=num) {
				start--;
				onlyDown++;
			}else {
				break;
			}
		}
	}
	public static void checkUp(int num) {
		while(true) {
			
			if(countDown == 500000)break;

			if(contain(num)) {
				countDown++;
				num--;
			}
			else {
				a = num;
				break;
			}
		}
	}
	
	public static void checkDown(int num) {
		while(true) {
			
			if(countUp == 500000)break;
			if(contain(num)) {
				countUp++;
				num++;
			}else {
				b = num;
				break;
			}
		}
	}
	public static boolean contain(int num) {
		char arr[] = String.valueOf(num).toCharArray();
		for(int i=0;i<arr.length;i++) {
			if(list.contains(arr[i])) return true;
		}
		return false;
	}
}
