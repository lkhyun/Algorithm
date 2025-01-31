import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        PriorityQueue<Integer> minheap = new PriorityQueue<>();
        int arr[] = new int[N];

        for(int i=0;i<N;i++){
            int num = Integer.parseInt(br.readLine());
            minheap.offer(num);
            arr[i] = num;
        }
        int min = minheap.poll();

        /*M은 1보다 크고 두번째로 작은값보단 작을 것.
        모든 값들은 서로 다르고 가장 작은 값을 넘어서면
        그 값의 나머지는 자기 자신이므로 변하지 않고 
        두번째 값을 넘어서면 나머지가 모두 같을 수 없게됨. */
        int GCD = gcd(arr[0]-min, arr[1]-min);
        for(int i=1;i<N;i++){
            GCD = gcd(GCD,arr[i]-min);
        }
        for(int i=2;i<=GCD;i++){
            if(GCD%i==0){bw.write(i+" ");}
        }
        bw.flush();
    }
    public static int gcd(int a, int b){
        int r=0;
        while(b!=0){
            r = a%b;
            a=b;
            b=r;
        }
        return a;
    }
}
