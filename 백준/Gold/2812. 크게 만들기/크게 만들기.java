
/*
 * 크게 만들기
 */
import java.io.*;
import java.util.*;

public class Main {

	static int n,k;
	static int arr[];
	static Stack<Integer> s = new Stack<>();
	static Stack<Integer> ss = new Stack<>();
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		arr = new int[n];
		int count = 0;
		int index = 0;
		char c[] = br.readLine().toCharArray();
		for(int i=0;i<n;i++) {
			arr[i] = Character.getNumericValue(c[i]);
		}
		
		for(int i=0;i<n;i++) {
			if(s.isEmpty()) {
				s.push(arr[i]);
			}else {
				if(s.peek()<arr[i]) {
					s.pop();
					i--;
					count++;
				}else if(s.peek()==arr[i]){
					s.push(arr[i]);
				}else {
					s.push(arr[i]);
				}
			}
			
			if(count==k) {
				index=i+1;
				break;
			}
		}
		if(count!=k) {
			for(int i=0;i<k-count;i++) {
				s.pop();
			}
			Stack<Integer> stack = new Stack<>();
			while(!s.isEmpty()) {
				stack.push(s.pop());
			}
			while(!stack.isEmpty()) {
				sb.append(stack.pop());
			}
		}else {
			while(!s.isEmpty()) {
				ss.push(s.pop());
			}
			
			while(!ss.isEmpty()) {
				sb.append(ss.pop());
			}
			
			for(int i=index;i<n;i++) {
				sb.append(arr[i]);
			}
		}
		System.out.println(sb.toString());
	}

}
