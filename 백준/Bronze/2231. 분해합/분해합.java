import java.util.Scanner;
public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        for(int i=1;i<N;i++){
            int temp = i;
            int total = i;
            while(temp%10!=0){
                total += temp%10;
                temp/=10;
            }
            if(total == N){System.out.println(i); return;}
        }
        System.out.println(0);

        sc.close();
    }
}
