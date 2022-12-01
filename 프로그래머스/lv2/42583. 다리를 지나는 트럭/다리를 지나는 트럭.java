import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        int time = 0;
        int truckWeight = 0;
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<truck_weights.length;i++){
            if(q.isEmpty()){
                q.offer(truck_weights[i]);
                truckWeight += truck_weights[i];
                time++;
            }else if(q.size()==bridge_length){
                truckWeight -= q.poll();
                i-=1;
            }else{
                if(truckWeight+truck_weights[i]<=weight){
                    q.offer(truck_weights[i]);
                    truckWeight+= truck_weights[i];
                    time++;
                }else{
                    q.offer(0);
                    time++;
                    i-=1;
                }
            }
        }
        
        return time+bridge_length;
    }
}