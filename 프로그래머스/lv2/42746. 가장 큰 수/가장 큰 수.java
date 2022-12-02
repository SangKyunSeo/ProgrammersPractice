import java.util.*;
class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        String[] arr = new String[numbers.length];
        for(int i=0;i<numbers.length;i++){
            arr[i]=Integer.toString(numbers[i]);
        }
        
        Arrays.sort(arr,new Comparator<String>(){
            public int compare(String a, String b){
                return (b+a).compareTo(a+b);
            }
        });
        
        if(arr[0].equals("0"))return "0";
        for(int i=0;i<arr.length;i++){
            sb.append(arr[i]);
        }
        
        return answer = sb.toString();
    }
}