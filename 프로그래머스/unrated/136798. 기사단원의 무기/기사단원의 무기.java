import java.util.*;

class Solution {
    static int[] arr;
    public int solution(int number, int limit, int power) {
        int answer = 0;
        arr = new int[number];
        arr[0]=1;
        for(int i=2;i<=number;i++){
            arr[i-1] = divisor(i);
        }
        
        for(int i=0;i<arr.length;i++){
            if(arr[i]<=limit){
                answer+=arr[i];
            }else{
                answer+=power;
            }
        }
        
        return answer;
    }
    public static int divisor(int number){
        int count = 0;
        if(number% Math.sqrt(number)==0)count+=1;
        
        for(int i=1;i<Math.sqrt(number);i++){
            
            if(number%i==0){
                count+=2;
            }
        }
        return count;
    }
}