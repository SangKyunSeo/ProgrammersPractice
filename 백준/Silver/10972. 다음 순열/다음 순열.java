
/*
 * 다음 순열
 */
import java.util.*;
import java.io.*;

public class Main {
	static int n;
	static int[] arr;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new int[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i=0;i<n;i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		
		if(next()) {
			for(int i=0;i<n;i++) {
				System.out.print(arr[i]+ " ");
			}
		}else
			System.out.println("-1");
	}
	public static boolean next() {
		int i = arr.length - 1;
		while(i>0 && arr[i-1]>=arr[i])i--;
		if(i<=0)return false;
		
		int j = arr.length - 1;
		while(arr[j]<=arr[i-1])j--;
		
		swap(i-1,j);
		j = arr.length - 1;
		while(i<j) {
			swap(i,j);
			i++;
			j--;
		}
		return true;
	}
	public static void swap(int idx1, int idx2) {
		int tmp = arr[idx1];
		arr[idx1] = arr[idx2];
		arr[idx2] = tmp;
	}
}
