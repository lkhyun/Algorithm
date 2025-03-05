import java.io.*;
import java.util.StringTokenizer;

public class Solution {
    static int[][] flim;
    static int D;
    static int W;
    static int K;
    static int min;

    public static void main(String[] args) throws Exception{
        //System.setIn(new FileInputStream("sample_input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            D = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            min = K;
            flim = new int[D][W];

            for(int i=0;i<D;i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0;j<W;j++){
                    flim[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            printing(0,0);
            bw.write("#"+t+" "+min+"\n");
        }
        bw.close();
    }
    public static void printing(int cnt,int start){
        if(cnt>=min) return;
        if(isOK()){
            min = Math.min(min,cnt);
            return;
        }
        int[] originalRow = new int[W];
        for(int i=start;i<D;i++){
            for(int j=0;j<W;j++){
                originalRow[j] = flim[i][j];
                flim[i][j] = 0;
            }
            printing(cnt+1, i+1);

            for(int j=0;j<W;j++){
                flim[i][j] = 1;
            }
            printing(cnt+1, i+1);
            for(int j=0;j<W;j++){
                flim[i][j] = originalRow[j];
            }
        }
    }
    public static boolean isOK(){
        for(int k=0;k<W;k++){//범위
            int temp = 0;
            boolean flag = false;
            for(int i=0;i<=D-K;i++){//깊이
                if(i==0){
                    for(int j=0;j<K;j++){
                        temp += flim[j][k];
                    }
                }else{
                    temp -= flim[i-1][k];
                    temp += flim[i+K-1][k];
                }
                if(temp==0 || temp==K){
                    flag = true;
                    break;
                }
            }
            if(!flag){
                return false;
            }
        }
        return true;
    }
}
