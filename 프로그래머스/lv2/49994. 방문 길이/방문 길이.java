class Solution {
    static int dx[] = {-1,1,0,0};
    static int dy[] = {0,0,-1,1};
    static int map[][][] = new int[11][11][4];
    public int solution(String dirs) {
        int answer = 0;
        int nx = 5;
        int ny = 5;
        for(int i=0;i<dirs.length();i++){
            char command = dirs.charAt(i);
            if(command == 'U' && nx+dx[0]>=0){
                map[nx+dx[0]][ny][0]=1;
                map[nx][ny][1]-=1;
                nx = nx + dx[0];
            }else if(command == 'D' && nx+dx[1]<11){
                map[nx+dx[1]][ny][1]=1;
                map[nx][ny][0]-=1;
                nx = nx + dx[1];
            }else if(command == 'L' && ny+dy[2]>=0){
                map[nx][ny+dy[2]][2]=1;
                map[nx][ny][3]-=1;
                ny = ny + dy[2];
            }else if(command == 'R' && ny+dy[3]<11){
                map[nx][ny+dy[3]][3]=1;
                map[nx][ny][2]-=1;
                ny = ny + dy[3];
            }
        }
        
        for(int i=0;i<11;i++){
            for(int j=0;j<11;j++){
                for(int k=0;k<4;k++){
                    if(map[i][j][k]>=0)
                        answer+=map[i][j][k];
                }
                
            }
        }
     
  
        return answer;
    }
}