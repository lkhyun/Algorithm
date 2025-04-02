import java.util.*;
import java.io.*;
class Node{
    int i,j;

    public Node(int i, int j) {
        this.i = i;
        this.j = j;
    }
}

public class Solution {
    static int N;
    static boolean[][] exynos;
    static List<Node> cells;
    static int min;
    static int maxCount;
    static int[] di = {-1,1,0,0};
    static int[] dj = {0,0,-1,1};
    public static void main(String[] args) throws Exception {
        //System.setIn(new FileInputStream("sample_input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for(int t = 1;t<=T;t++){
            bw.write("#"+t+" ");
            N = Integer.parseInt(br.readLine());
            exynos = new boolean[N][N];
            cells = new ArrayList<>();
            min = Integer.MAX_VALUE;
            maxCount = 0;

            for(int i=0;i<N;i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0;j<N;j++){
                    int input = Integer.parseInt(st.nextToken());
                    if(input == 1){
                        exynos[i][j] = true;
                        cells.add(new Node(i, j));
                    }else{
                        exynos[i][j] = false;
                    }
                }
            }
            backtracking(0, 0, 0, 0);

            bw.write(min+"\n");
        }
        bw.close();
    }
    public static void backtracking(int start,int count,int depth,int sum){
        if((cells.size()-depth + count) < maxCount) return;
        if(depth == cells.size()){
            if(count > maxCount){
                min = sum;
                maxCount = count;
            }else if(count == maxCount){
                min = Math.min(sum,min);
            }
            return;
        }

        for(int i = start;i<cells.size();i++){
            Node cur = cells.get(i);
            if(cur.i==0 || cur.j==0 || cur.i==N-1 || cur.j==N-1){
                backtracking(i+1, count+1, depth+1, sum);
            }else{
                for(int k = 0;k<4;k++){
                    int newi = cur.i + di[k];
                    int newj = cur.j + dj[k];
                    int selectedCnt = 0;
                    while(newi>0&&newi<N-1&&newj>0&&newj<N-1&&!exynos[newi][newj]){
                        selectedCnt++;
                        exynos[newi][newj] = true;
                        newi += di[k];
                        newj += dj[k];
                    }
                    if(exynos[newi][newj]){
                        newi = cur.i + di[k];
                        newj = cur.j + dj[k];
                        for(int j=0;j<selectedCnt;j++){
                            exynos[newi][newj] = false;
                            newi += di[k];
                            newj += dj[k];
                        }
                        backtracking(i+1, count, depth+1, sum);
                    }else if(newi==0 || newj==0 || newi==N-1 || newj==N-1){
                        selectedCnt++;
                        exynos[newi][newj] = true;
                        backtracking(i+1, count+1, depth+1, sum+selectedCnt);
                        newi = cur.i + di[k];
                        newj = cur.j + dj[k];
                        for(int j=0;j<selectedCnt;j++){
                            exynos[newi][newj] = false;
                            newi += di[k];
                            newj += dj[k];
                        }
                    }
                    
                }
            }
            
        }
    }
}
