import java.util.*;

class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        List<String> list = new ArrayList<>();
        List<Integer> zeroIndexList = new ArrayList<>();
        
        // k진법으로 나타내기
        list = calNumber(n, k);
        
        // 0의 인덱스 찾아오기
        if(!list.get(0).equals("0")){
            zeroIndexList.add(-1);    
        }
        findZeroIndex(zeroIndexList,list);
        zeroIndexList.add(list.size());     
        
        // 숫자 찾기
        for(int i = 0; i < zeroIndexList.size() - 1; i++){
            // 소수 판별
            if(isPrime(findCheckNumber(list, zeroIndexList.get(i) + 1, zeroIndexList.get(i+1)))){
                answer++;
            }   
        }
        
        return answer;
    }
    
    // k 진법으로 변환후 list 반환
    public List<String> calNumber(int n, int k){
        Stack<Integer> stack = new Stack<>();
        List<String> list = new ArrayList<>();
        while(n > 0){
            stack.push(n%k);
            n /= k;
        }
        while(!stack.isEmpty()){
            list.add(String.valueOf(stack.pop()));
        }
        return list;
    }
    
    // k 진법으로 표시한 수의 0 의 인덱스 list 반환
    public void findZeroIndex(List<Integer> zeroIndexList, List<String> list){
        
        for(int i = 0; i < list.size(); i++){
            if(list.get(i).equals("0")) zeroIndexList.add(i);
        }
    }
    
    // k 진법으로 표시 한 수에서 소수인지를 판단할 숫자를 구하기
    public List<String> findCheckNumber(List<String> list, int start, int end){
        List<String> numberList = new ArrayList<>();
        numberList = list.subList(start, end);
        return numberList;
    }
    
    // 소수 판별
    public Boolean isPrime(List<String> list){
        Long number = 0L;
        String sNumber = "";
        if(list.size() == 0) return false;
        
        for(String s : list){
            sNumber += s;
        }
        
        number = Long.parseLong(sNumber);
        if(number == 1) return false;
        if(number == 2) return true;
        
        for(int i=2; i <= Math.sqrt(number);i++){
            if(number % i == 0) return false;
        }
        return true;
    }
}