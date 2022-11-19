package Solution_D3_1244;

import java.util.Scanner;
import java.io.FileInputStream;


public class main {
	static StringBuilder sb = new StringBuilder();
	static int result = 0;
	public static void main(String[] args) throws Exception {
		
		Scanner sc = new Scanner(System.in);
		
		int T;
		T=sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			char[] arr = Integer.toString(sc.nextInt()).toCharArray();
			int count = sc.nextInt();
			if(count>10)count = 10;
			result = 0;
			dfs(arr,0,count);
			System.out.println("#"+test_case+" "+result);
		}

	}
	public static void dfs(char[] arr,int start, int count) {
		if(count==0) {
			sb = new StringBuilder();
			for(int i=0;i<arr.length;i++) {
				sb.append(arr[i]);
			}
			int number = Integer.parseInt(sb.toString());
			if(result<number)result = number;
			return;
		}
		
		for(int i=start;i<arr.length-1;i++) {
			for(int j=i+1;j<arr.length;j++) {
				char a = arr[i];
				char b = arr[j];
				
				arr[i]=b;
				arr[j]=a;
				dfs(arr,i,count-1);
				arr[i]=a;
				arr[j]=b;
			}
		}
	}
	public static void swap(char[] arr,int i,int j) {
		char temp = arr[i];
		arr[i]=arr[j];
		arr[j]=temp;
	}
}
