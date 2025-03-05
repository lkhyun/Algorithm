import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
    static int[][] grid;
    static int N;
    static String cmd;

    public static void main(String[] args) throws Exception{
        //System.setIn(new FileInputStream("sample_input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            cmd = st.nextToken();
            grid = new int[N][N];

            for(int i = 0;i<N;i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0;j<N;j++){
                    grid[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            int[][] result = new int[N][N];
            if(cmd.equals("left")){
                for(int i = 0;i<N;i++){
                    List<Integer> templist = new ArrayList<>(N);
                    for(int j=0;j<N;j++){
                        int k = 1;
                        while(j+k < N && grid[i][j] == 0){
                            grid[i][j] = grid[i][j+k];
                            grid[i][j+k] = 0;
                            k++;
                        }
                        if(j+k >=N){break;}
                    }
                    for(int j=0;j<N;j++){
                        if(j==N-1){
                            templist.add(grid[i][j]);
                            break;
                        }
                        if(grid[i][j]==grid[i][j+1]){
                            templist.add(grid[i][j]+grid[i][j+1]);
                            j++;
                        }else{
                            if(grid[i][j] == 0) continue;
                            templist.add(grid[i][j]);
                        }
                    }
                    for(int k=0;k<templist.size();k++){
                        result[i][k] = templist.get(k);
                    }
                }
            }else if(cmd.equals("right")){
                for(int i = 0;i<N;i++){
                    List<Integer> templist = new ArrayList<>(N);
                    for(int j=N-1;j>=0;j--){
                        int k = 1;
                        while(j-k >=0 && grid[i][j] == 0){
                            grid[i][j] = grid[i][j-k];
                            grid[i][j-k] = 0;
                            k++;
                        }
                        if(j-k < 0){break;}
                    }
                    for(int j=N-1;j>=0;j--){
                        if(j==0){
                            templist.add(grid[i][j]);
                            break;
                        }
                        if(grid[i][j]==grid[i][j-1]){
                            templist.add(grid[i][j]+grid[i][j-1]);
                            j--;
                        }else{
                            if(grid[i][j] == 0) continue;
                            templist.add(grid[i][j]);
                        }
                    }
                    int temp = 0;
                    for(int k=N-1;k>=N-templist.size();k--,temp++){
                        result[i][k] = templist.get(temp);
                    }
                }
            }else if(cmd.equals("up")){
                for(int i = 0;i<N;i++){
                    List<Integer> templist = new ArrayList<>(N);
                    for(int j=0;j<N;j++){
                        int k = 1;
                        while(j+k < N && grid[j][i] == 0){
                            grid[j][i] = grid[j+k][i];
                            grid[j+k][i] = 0;
                            k++;
                        }
                        if(j+k >=N){break;}
                    }
                    for(int j=0;j<N;j++){
                        if(j==N-1){
                            templist.add(grid[j][i]);
                            break;
                        }
                        if(grid[j][i]==grid[j+1][i]){
                            templist.add(grid[j][i]+grid[j+1][i]);
                            j++;
                        }else{
                            if(grid[j][i] == 0) continue;
                            templist.add(grid[j][i]);
                        }
                    }
                    for(int k=0;k<templist.size();k++){
                        result[k][i] = templist.get(k);
                    }
                }
            }else if(cmd.equals("down")){
                for(int i = 0;i<N;i++){
                    List<Integer> templist = new ArrayList<>(N);
                    for(int j=N-1;j>=0;j--){
                        int k = 1;
                        while(j-k >=0 && grid[j][i] == 0){
                            grid[j][i] = grid[j-k][i];
                            grid[j-k][i] = 0;
                            k++;
                        }
                        if(j-k < 0){break;}
                    }
                    for(int j=N-1;j>=0;j--){
                        if(j==0){
                            templist.add(grid[j][i]);
                            break;
                        }
                        if(grid[j][i]==grid[j-1][i]){
                            templist.add(grid[j][i]+grid[j-1][i]);
                            j--;
                        }else{
                            if(grid[j][i] == 0) continue;
                            templist.add(grid[j][i]);
                        }
                    }
                    int temp = 0;
                    for(int k=N-1;k>=N-templist.size();k--,temp++){
                        result[k][i] = templist.get(temp);
                    }
                }
            }
            
            bw.write("#"+t+"\n");
            for(int i=0;i<N;i++){
                for(int j=0;j<N;j++){
                    bw.write(result[i][j]+" ");
                }
                bw.write("\n");
            }
        }
        bw.close();
    }
}
