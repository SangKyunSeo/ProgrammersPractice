import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        Arrays.sort(lost);
        Arrays.sort(reserve);
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<Integer> lostList = new ArrayList<>();
        for(int i=0;i<lost.length;i++){
            lostList.add(lost[i]);
        }
        for(int i=0;i<reserve.length;i++){
            list.add(reserve[i]);
        }
        
        check(lostList,list);
        
        for(int i=0;i<lostList.size();i++){
            if(list.contains(lostList.get(i)-1)){
                list.remove(Integer.valueOf(lostList.get(i)-1));
                lostList.remove(i);
                i=-1;
            }
            else if(list.contains(lostList.get(i)+1)){
                list.remove(Integer.valueOf(lostList.get(i)+1));
                lostList.remove(i);
                i=-1;
            }
        }
        
        answer = n - lostList.size();
        return answer;
    }
    public static void check( ArrayList<Integer> lostList, ArrayList<Integer> list){
        for(int i=0;i<lostList.size();i++){
            if(list.contains(lostList.get(i))){
                list.remove(Integer.valueOf(lostList.get(i)));
                lostList.remove(i);
                i=-1;
            }
        }
    }
}