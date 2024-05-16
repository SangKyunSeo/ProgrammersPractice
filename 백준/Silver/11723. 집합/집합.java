
/*
 * 비트마스킹
 * 집합
 */

import java.io.*;
import java.util.*;

public class Main {
	static int[] S;
	static int M;
	static String op;
	static int x;
	static int bitset = 0;
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		M = Integer.parseInt(br.readLine());
		S = new int[20];
		
		for(int i=0;i<S.length;i++) {
			S[i]=0;
		}
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			op = st.nextToken();
			 switch (op){
             case "add" :
                 x = Integer.parseInt(st.nextToken());
                 if(S[x-1]==0)S[x-1]=1;
                 break;
             case "remove" :
                 x = Integer.parseInt(st.nextToken());
                 if(S[x-1]!=0)S[x-1]=0;
                 break;
             case "check" :
                 x = Integer.parseInt(st.nextToken());
                sb.append(S[x-1] != 0 ? "1\n" : "0\n");
                 break;
             case "toggle" :
                 x = Integer.parseInt(st.nextToken());
                 if(S[x-1]==0)S[x-1]=1;
                 else S[x-1]=0;
                 break;
             case "all" :
                 for(int j=0;j<20;j++)
                	 S[j]=1;
                 break;
             case "empty" :
                 for(int j=0;j<20;j++)
                	 S[j]=0;
                 break;
			 }
		}
		
		bw.write(sb.toString());
		bw.close();
		br.close();
	}
}
