
/*
 * 회전 초밥
 */
import java.util.*;
import java.io.*;

public class Main {

	static int n,d,k,c;
	static int sushi[];
	static int number[] = new int[3001];
	static int max = Integer.MIN_VALUE;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		sushi = new int[n];
		
		for(int i=0;i<n;i++) {
			sushi[i] = Integer.parseInt(br.readLine());
		}
		
		int a = 0;
		int b = 1;
		number[sushi[a]]+=1;
		number[c]+=1;
		int count = 1;
		int result = 0;
		if(number[c]==1)result = 2;
		else result = 1;
		while(a<n) {
			while(count<k) {
				if(b>=n) {
					b=b-n;
				}
				if(number[sushi[b]]==0) {
					result++;
				}
				number[sushi[b]]+=1;
				b++;
				count++;
			}
			max = Math.max(max, result);
			number[sushi[a]]-=1;
			
			if(number[sushi[a]]==0)result--;
			a++;
			count--;
			
		}
		
		System.out.println(max);
	}
	public static int calc() {
		int count = 0;
		for(int i=0;i<number.length;i++) {
			if(number[i]!=0)count++;
		}
		return count;
	}
}
