
/*
 * 꿀 따기
 */
import java.io.*;
import java.util.*;

public class Main {

	static int n;
	static int[] honey;
	static long max = Long.MIN_VALUE;
	static long[] toRightSum;
	static long[] toLeftSum;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		honey = new int[n];
		toRightSum = new long[n];
		toLeftSum = new long[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++) {
			honey[i] = Integer.parseInt(st.nextToken());
		}
		toRightSum[0]=honey[0];
		toLeftSum[n-1]=honey[n-1];
		for(int i=1;i<n;i++) {
			toRightSum[i]=toRightSum[i-1]+honey[i];
		}
		for(int i=n-2;i>=0;i--) {
			toLeftSum[i]=toLeftSum[i+1]+honey[i];
		}
		
		
		case1();
		case2();
		case3();
		System.out.println(max);
	}
	public static void case1() {
		for(int i=1;i<n-1;i++) {
			long sum = (toRightSum[i]-toRightSum[0]) + (toLeftSum[i]-toLeftSum[n-1]);
			max = Math.max(max, sum);
		}
	}
	public static void case2() {
		for(int i=1;i<n-1;i++) {
			long sum = (toRightSum[n-1]-toRightSum[0]-honey[i]) + (toRightSum[n-1]-toRightSum[i]);
			max = Math.max(max, sum);
		}
	}
	public static void case3() {
		for(int i=n-2;i>=1;i--) {
			long sum = (toLeftSum[0]-toLeftSum[n-1]-honey[i]) + (toLeftSum[0]-toLeftSum[i]);
			max = Math.max(max, sum);
		}
	}

}
