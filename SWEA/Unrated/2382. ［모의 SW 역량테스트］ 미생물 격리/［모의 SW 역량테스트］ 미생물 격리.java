import java.util.*;

import java.io.*;

class colony{
    int x;
    int y;
    int count;
    int direction;
    colony(int x, int y, int count, int direction){
        this.x = x;
        this.y = y;
        this.count = count;
        this.direction = direction;
    }
    colony deepcopy(){
        return new colony(x, y, count, direction);
    }
    @Override
    public String toString() {
        return "colony [x=" + x + ", y=" + y + ", count=" + count + ", direction=" + direction + "]";
    }
}

public class Solution{
    public static void main(String[] args) throws Exception{
        //System.setIn(new FileInputStream("sample_input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter((System.out)));
        int T = Integer.parseInt(br.readLine());
        for(int t = 1;t<=T;t++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());    
            List<colony> map = new ArrayList<>();
            for(int i = 1;i<=K;i++){// 군집 개수만큼
                st = new StringTokenizer(br.readLine());
                int y = Integer.parseInt(st.nextToken());
                int x = Integer.parseInt(st.nextToken());
                int count = Integer.parseInt(st.nextToken());
                int direction = Integer.parseInt(st.nextToken());
                map.add(new colony(x,y,count,direction)); 
            }

            for(int k=1; k<=M;k++){ // 시간
                for(colony cur : map){//군집 개수 순회
                    if(cur.direction==1){//상
                        cur.y--;
                        if(cur.y==0 || cur.y==N-1){
                            cur.count/=2;
                            cur.direction = 2;
                        }
                    }else if(cur.direction==2){//하
                        cur.y++;
                        if(cur.y==0 || cur.y==N-1){
                            cur.count/=2;
                            cur.direction = 1;
                        }
                    }else if(cur.direction==3){//좌
                        cur.x--;
                        if(cur.x==0 || cur.x==N-1){
                            cur.count/=2;
                            cur.direction = 4;
                        }
                    }else if(cur.direction==4){//우
                        cur.x++;
                        if(cur.x==0 || cur.x==N-1){
                            cur.count/=2;
                            cur.direction = 3;
                        }
                    }
                }
                
                Map<String, List<colony>> checkDuplicated = new HashMap<>();
                for(colony cur : map){
                    String key = cur.x +","+ cur.y;
                    if(checkDuplicated.containsKey(key)){
                        List<colony> temp = checkDuplicated.get(key);
                        temp.add(cur.deepcopy());
                    }else{
                        List<colony> temp = new ArrayList<>();
                        temp.add(cur.deepcopy());
                        checkDuplicated.put(key,temp);
                    }
                }
                List<colony> finalList = new ArrayList<>();
                for(List<colony> l :checkDuplicated.values()){
                    int x = l.get(0).x;
                    int y = l.get(0).y;
                    int maxcount = 0;
                    int direction = 0;
                    for(colony c : l){
                        if(maxcount <= c.count){
                            maxcount = c.count;
                            direction = c.direction;
                        }
                    }
                    int totalcount = 0;
                    for(colony c : l){
                        totalcount += c.count;
                    }
                    finalList.add(new colony(x, y, totalcount, direction));
                }
                map = new ArrayList<>(finalList);
            }
            int total = 0;
            for(colony c:map){
                total += c.count;
            }
            bw.write("#"+t+" "+total+"\n");
        }
        bw.close();
    }
}