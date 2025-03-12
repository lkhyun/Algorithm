import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        double sum = 0;
        long middle = 0;
        long many = 0;
        long range = 0;

        long[] arr = new long[N];
        Map<Long,Integer> m = new HashMap<>();
        for(int i=0;i<N;i++){
            long temp = Long.parseLong(br.readLine());
            arr[i] = temp;
            sum += temp;
            m.put(temp,m.getOrDefault(temp,0)+1);
        }
        long mean = Math.round(sum/N);
        Arrays.sort(arr);
        long max = 0;
        int maxcount = 0;
        for(Map.Entry<Long,Integer> e : m.entrySet()){
            if(e.getValue()>maxcount){
                max = e.getKey();
                maxcount = e.getValue();
            }
        }
        List<Long> manyArr = new ArrayList<>();
        for(Map.Entry<Long,Integer> e : m.entrySet()){
            if(e.getValue()==maxcount){
                manyArr.add(e.getKey());
            }
        }
        Collections.sort(manyArr);
        if(manyArr.size()>1){
            many = manyArr.get(1);
        }else{
            many = max;
        }
        middle = arr[N/2];
        range = arr[N-1] - arr[0];
        System.out.println(mean);
        System.out.println(middle);
        System.out.println(many);
        System.out.println(range);
    }
}
