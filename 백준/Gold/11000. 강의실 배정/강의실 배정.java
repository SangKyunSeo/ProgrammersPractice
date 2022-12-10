
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
			
			// 시작 시간을 기준으로 오름차순 정렬한다.(왜? 우선순위큐에 종료시간을 넣을것인데. 가장 작은 종료시간과 비교하기 위해서다)
			Arrays.sort(p,new Comparator<point>(){
				public int compare(point o1,point o2) {
					if(o1.start==o2.start) 
						return o1.end-o2.end;
					return o1.start-o2.start;
				}
			});
			
			// 첫번 째 강의의 종료시간을 우선순위 큐에 넣어준다(강의실을 배정해준것이다)
			pq.offer(p[0].end);
			
			for(int i=1;i<n;i++) {
				
				//(다음번째 강의의 시작시간과 우선순위 큐에있는 강의의 종료시간을 비교한다)
				if(p[i].start>=pq.peek()) {
					// 시작시간이 종료시간 이후라면 같은 강의실에 배정해준다. 따라서 기존에 있던 강의는 큐에서 빼주는 작업이 필요한 것이다
					pq.poll();
				}
				
				// 같은 강의실에 배정되지 않거나, 같은 강의실에 배정될 강의는 이미 빼주었으므로 그대로 큐에 종료시간을 넣어준다.
				pq.offer(p[i].end);
				// 우선순위 큐에 의해서 종료시간이 가장 빠른게 위로 온다.
			}
			
			// 그렇게 모든 강의에 대해 작업이 끝났다면 큐에 남아있는 만큼이 배정된 강의실의 수가 될 것이다.
			// 왜? 같은 강의실에 배정되었다는 것은 시작시간이 종료시간 이후였다는 것이고 
			// 우선순위 큐와 시작시간을 기준으로 오름차순 정렬한 작업 때문에 최소한의 강의 실 배정이 가능해 진 것이다. 
			// 종료시간을 기준으로 정렬을 하면 안되는 이유는 무엇일까? 
			// 시작시간과 종료시간의 차이를 줄여야하는것이 목표인데 종료시간은 짧은순이나 시작시간의 정렬을 보장 할 수 없기에 
			// 1 3 , 5 6 , 13 14 , 4 12 , 7 13 의 경우 3개의 강의실이 생기나 최소 강의실은 1 3, 4 12, / 5 6, 7, 13, 13 14 로 2개이므로 반례가 존재한다.
			System.out.println(pq.size());
			
			
			
		}
	
	}
