import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int result = 1;
        int division = 1;
        for(int i = 0; i<K;i++){
            result *= N-i;
            division *= K-i;
        }
        System.out.println(result/division);
    }
}
