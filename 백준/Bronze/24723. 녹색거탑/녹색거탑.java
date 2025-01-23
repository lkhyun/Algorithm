import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int total = 1;
        for(int i = 1; i<=N;i++){
            total *= 2;
        }
        System.out.println(total);
    }
}
