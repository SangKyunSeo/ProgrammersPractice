import java.util.*;

class Solution {
    public int solution(int[] topping) {
        int answer = -1;
        
        Map<Integer, Integer> map = new HashMap<>();
        Map<Integer, Integer> chul = new HashMap<>();
        for(int i=0;i<topping.length;i++){
            map.put(topping[i],map.getOrDefault(topping[i],0)+1);
        }
        
        for(int i=0;i<topping.length;i++){
            chul.put(topping[i],chul.getOrDefault(topping[i],0)+1);
            if(map.get(topping[i]) == 1){
                map.remove(topping[i]);
            }else{
                map.put(topping[i],map.get(topping[i])-1);
            }
            
            if(chul.size() == map.size()){
                answer++;
            }
        }
        return answer+1;
    }
}