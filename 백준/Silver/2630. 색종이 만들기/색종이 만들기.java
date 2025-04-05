import java.util.*;
import java.io.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int N;
    static int[][] matrix;
    static int[] cnt = new int[2];

    public static void main(String[] args) throws Exception {
        N = Integer.parseInt(br.readLine());
        matrix = new int[N][N];
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        paper(0,N-1,0,N-1,N*N);

        bw.write(cnt[0]+"\n");
        bw.write(cnt[1]+"\n");
        bw.close();
    }
    public static int paper(int si,int ei,int sj,int ej,int size){
        if(size == 1){
            return matrix[si][sj];
        }

        int one = paper(si,(si+ei)/2,sj,(sj+ej)/2,size/4);
        int two = paper(si,(si+ei)/2,(sj+ej)/2 + 1,ej,size/4);
        int three = paper((si+ei)/2 + 1,ei,sj,(sj+ej)/2,size/4);
        int four = paper((si+ei)/2 + 1,ei,(sj+ej)/2 + 1,ej,size/4);

        if(one == -1 || two == -1 || three == -1 || four == -1){
            if(one != -1) cnt[one]++;
            if(two != -1) cnt[two]++;
            if(three != -1) cnt[three]++;
            if(four != -1) cnt[four]++;
            return -1;
        }
        if(one==two && three==four && one==three){
            if(size == N*N) cnt[one]++;
            return one;
        }else{
            cnt[one]++;
            cnt[two]++;
            cnt[three]++;
            cnt[four]++;
            return -1;
        }

    }

}
