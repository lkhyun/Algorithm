import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        int[] Ms = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            Ms[i] = Integer.parseInt(st.nextToken());
        }
        List<int[]> Ns = new ArrayList<>(N); 
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            Ns.add(new int[]{x,y});
        }

        Arrays.sort(Ms);

        int count=0;
        for (int[] i:Ns) {
            int state = Arrays.binarySearch(Ms, i[0]);
            if(state>=0){
                if(i[1]<=L){
                    count++;
                }

            }else{
                int temp = -(state+1);
                int lefttemp = temp-1;
                int righttemp = temp;
                if(lefttemp<0){
                    if((long)Ms[righttemp] - i[0] + i[1] <= (long)L){
                        count++;
                    }
                }else if(righttemp==Ms.length){
                    if((long)i[0]-Ms[lefttemp] + i[1] <= (long)L){
                        count++;
                    }

                }else{
                    if((long)Ms[righttemp]-i[0]>(long)i[0]-Ms[lefttemp]){
                        if((long)i[0]-Ms[lefttemp] + i[1] <= (long)L){
                            count++;
                        }
                    }else{
                        if((long)Ms[righttemp] - i[0] + i[1] <= (long)L){
                            count++;
                        }
                    }
                }
            }
        }
        bw.write(String.valueOf(count));
        bw.flush();
    }    
}
