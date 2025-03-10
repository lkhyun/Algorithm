import java.util.*;
import java.io.*;

public class Main {
    static int L;
    static int C;
    static String jaeum;
    static String moeum;
    static char[] arr;
    static StringBuilder sb = new StringBuilder();
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        arr = new char[C];
        for(int i=0;i<C;i++){
            arr[i] = st.nextToken().charAt(0);
        }
        Arrays.sort(arr);
        
        createPassword(0, 0, 0, 0);
        bw.close();
    }
    public static void createPassword(int ja, int mo, int start, int cnt) throws Exception{
        if(cnt==L){
            if(ja<2 || mo<1){
                return;
            }else{
                bw.write(sb.toString()+"\n");
            }
        }
        for(int i=start;i<C;i++){
            sb.append(arr[i]);
            if(arr[i]=='a' || arr[i]=='e' || arr[i]=='i' || arr[i]=='o' || arr[i]=='u'){
                createPassword(ja, mo+1, i+1, cnt+1);
            }else{
                createPassword(ja+1, mo, i+1, cnt+1);
            }
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
