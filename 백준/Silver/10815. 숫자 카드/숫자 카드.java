import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;
public class Main {
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        Map<Integer,Integer> sanggeun = new HashMap<>();
        for(int i=0;i<N;i++){
            sanggeun.put(sc.nextInt(),1);   
        }
        int M = sc.nextInt();
        for(int i=0;i<M;i++){
            System.out.print(sanggeun.getOrDefault(sc.nextInt(), 0) + " ");
        }
        sc.close();
    }
}
