
/*
 * 잃어버린 괄호
 */
import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		String[] arr = s.split("-");
		int sum = 0;
		for(int i=0;i<arr.length;i++) {
			sum=0;
			if(arr[i].contains("+")) {
				String[] a = arr[i].split("\\+");
				for(int j=0;j<a.length;j++) {
					sum+=Integer.parseInt(a[j]);
				}
				
				arr[i]=Integer.toString(sum);
			}else
				sum=Integer.parseInt(arr[i]);
		}
		if(arr.length==1)System.out.println(sum);
		else {
			int result = Integer.parseInt(arr[0]);
			for(int i=1;i<arr.length;i++) {
				result-=Integer.parseInt(arr[i]);
			}
			System.out.println(result);
		}
		
		
		
		
	}

}
