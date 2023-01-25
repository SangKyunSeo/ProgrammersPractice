
/*
 * 사과나무
 */
import java.io.*;
import java.util.*;

public class Main {

	static int n;
	static int arr[];
	static int sum = 0;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++) {
			arr[i]=Integer.parseInt(st.nextToken());
			sum+=arr[i];
		}
		
		if(sum%3==0) {
			if(check())System.out.println("YES");
			else System.out.println("NO");
		}else
			System.out.println("NO");
		
	}
	public static boolean check() {
		int count = 0;
		for(int i=0;i<n;i++) {
			if(arr[i]%2!=0)count++;
		}
		
		if(count<=(sum/3))return true;
		return false;
	}

}
