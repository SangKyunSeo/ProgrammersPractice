class Solution {
    public int[] solution(int n) {
        
        int[][] map = new int[n][n];
        
        int c_row = 0;
        int c_col = 0;
        int row = n-1;
        int col = n-1;
        
        int current_count = 1;
        int count = 0;
        
        for(int i=n;i>=1;i--){
            count+=i;
        }
        int[] answer = new int[count];
        
        while(current_count <= count){
            for(;c_row<=row;c_row++){
                map[c_row][c_col] = current_count++;
            }
            if(current_count > count) break;
            c_row--;
            c_col++;
            row--;
            for(;c_col<=col;c_col++){
                map[c_row][c_col] = current_count++;
            }
            if(current_count > count) break;
            c_col--;
            col-=2;
            while(true){
                if(map[c_row-1][c_col-1] != 0){
                    break;
                }
                map[c_row-1][c_col-1] = current_count++;
                c_row-=1;
                c_col-=1;
            }
            if(current_count > count) break;
            c_row++;
        }
        int cnt = 0;
        int idx = 0;
        for(int i=0;i<map.length;i++){
            for(int j=0;j<=cnt;j++){
                answer[idx++] = map[i][j];
            }
            cnt++;
        }
        
        return answer;
    }
}