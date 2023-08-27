import java.util.*;
class Solution {
    public int solution(int[] order) {
        int answer = 0;
        Stack<Integer> s = new Stack<>();
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<order.length;i++){
            q.offer(i+1);
        }
        
        for(int i=0;i<order.length;i++){
            if(!q.isEmpty() && q.peek() == order[i]){
                q.poll();
                answer++;
            }else if((!q.isEmpty() && q.peek() != order[i]) || q.isEmpty()){
                if(!s.isEmpty() && s.peek() == order[i]){
                    s.pop();
                    answer++;
                }else if(s.isEmpty() || (!q.isEmpty() && q.peek() != order[i])){
                    while(!q.isEmpty() && q.peek() != order[i]){
                        s.push(q.poll());
                    }
                    if(!q.isEmpty() && q.peek() == order[i]){
                        answer++;
                        q.poll();
                    }
                }else if((!s.isEmpty() && s.peek() != order[i]) || q.isEmpty()){
                    break;
                }
            }
        }
        return answer;
    }
}