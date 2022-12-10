
/*
 * 강의실 배정
 */
import java.io.*;
import java.util.*;
class point{
	int start,end;
	point(int start, int end){
		this.start = start;
		this.end = end;
	}
}
public class Main {

	static int n;
	static PriorityQueue<Integer> pq = new PriorityQueue<>();
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		point[] p = new point[n];
		StringTokenizer st;
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			p[i]=new point(start,end);
		}
		
		Arrays.sort(p,new Comparator<point>(){
			public int compare(point o1,point o2) {
				if(o1.start==o2.start) 
					return o1.end-o2.end;
				return o1.start-o2.start;
			}
		});
		
		pq.offer(p[0].end);
		
		for(int i=1;i<n;i++) {
			if(p[i].start>=pq.peek()) {
				pq.poll();
			}
			pq.offer(p[i].end);
		}
		
		System.out.println(pq.size());
		
		
		
	}

}
