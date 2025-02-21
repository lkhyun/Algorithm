import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws Exception{
        //System.setIn(new FileInputStream("sample_input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int t = 1; t <= 10; t++) {
            int T = Integer.parseInt(br.readLine());
            int[] arr = new int[8];
            int min = Integer.MAX_VALUE;
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=0;i<8;i++){
                arr[i] = Integer.parseInt(st.nextToken());
                min = Math.min(min,arr[i]);
            }
            if(min>15){
                for(int i=0;i<8;i++){
                    int temp = min/15 - 1;
                    arr[i] -= temp*15;
                }
            }
            arr[0]--;
            int idx = 0; //맨 끝에 있는 인덱스
            int sub = 1;
            while(arr[idx]>0){
                idx = (idx+1)%8;
                arr[idx] -= ((sub%5)+1);
                sub++;
            }
            arr[idx] = 0;
            bw.write("#"+t);
            for(int i=1;i<=arr.length;i++){
                int newIndex = (idx+i)%8;
                bw.write(" "+arr[newIndex]);
            }
            bw.write("\n");
        }

        
        bw.flush();
    }
    

}