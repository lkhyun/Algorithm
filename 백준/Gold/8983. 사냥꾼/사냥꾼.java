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
        Map<Integer,Integer> Ns = new HashMap<>(N); 
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            Ns.put(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
        }

        Arrays.sort(Ms);

        int count=0;
        for (int i:Ns.keySet()) {
            int state = Arrays.binarySearch(Ms, i);
            if(state>=0){
                if(Ns.get(i)<=L){
                    count++;
                }

            }else{
                int temp = -(state+1);
                int lefttemp = temp-1;
                int righttemp = temp;
                if(lefttemp<0){
                    if(Math.abs(Ms[righttemp] - i) + Ns.get(i) <= L){
                        count++;
                    }
                }else if(righttemp==Ms.length){
                    if(Math.abs(Ms[lefttemp] - i) + Ns.get(i) <= L){
                        count++;
                    }

                }else{
                    if(Math.abs(Ms[righttemp]-i)>Math.abs(Ms[lefttemp]-i)){
                        if(Math.abs(Ms[lefttemp] - i) + Ns.get(i) <= L){
                            count++;
                        }
                    }else{
                        if(Math.abs(Ms[righttemp] - i) + Ns.get(i) <= L){
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
