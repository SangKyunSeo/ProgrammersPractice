import java.util.*;
class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = {};
        int[] arr = Arrays.copyOf(numbers,numbers.length);
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        for(int i=1;i<numbers.length;i++){
            while(!stack.empty() && numbers[stack.peek()]<numbers[i]){
                arr[stack.pop()]=numbers[i];
            }
            stack.push(i);
        }
        
        while(!stack.empty()){
            arr[stack.pop()] = -1;
        }
        
        answer = Arrays.copyOf(arr,arr.length);
        return answer;
    }
}