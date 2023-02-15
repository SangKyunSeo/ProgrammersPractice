import java.util.*;

class Solution {
    static List<Integer> list = new ArrayList<>();
    
    public int[] solution(int[][] arr) {
        int[] answer = new int[2];
        int size = arr.length;
        
        quadTree(0,0,size,arr);
        
        for(int i=0;i<list.size();i++){
            if(list.get(i)==0)answer[0]++;
            else answer[1]++;
        }
        return answer;
    }
    public static void quadTree(int x,int y,int size,int[][] arr){
        if(isPossible(x,y,arr,size)){
            list.add(arr[x][y]);
            return;
        }
        
        int newSize = size/2;
        
        quadTree(x,y,newSize,arr);
        quadTree(x,y+newSize,newSize,arr);
        quadTree(x+newSize,y,newSize,arr);
        quadTree(x+newSize,y+newSize,newSize,arr);
        
    }
    public static boolean isPossible(int x,int y,int[][] arr,int size){
        int val = arr[x][y];
        
        for(int i=x;i<x+size;i++){
            for(int j=y;j<y+size;j++){
                if(arr[i][j]!=val)return false;
            }
        }
        return true;
    }
}