import java.util.Scanner;
public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int count = 2;
        for(int i=0;i<N;i++){
            count += count-1;
        }
        System.out.println(count*count);
        sc.close();
    }
}