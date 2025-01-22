import java.util.Scanner;
public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        int N = sc.nextInt();
        int minimum = N+1;
        int sum = 0;
        for(int i=N;i>=M;i--){
            int root = (int)Math.sqrt(i);
            int j;
            if(i==1){continue;}
            for(j=2;j<=root;j++){
                if(i%j==0){break;}
            }
            if(j>root){
                sum += i;
                if(minimum>i || minimum==N+1){minimum = i;}
            }
        }
        if(sum==0){
            System.out.println("-1");
        }
        else{
            System.out.println(sum);
            System.out.println(minimum);
        }
        sc.close();
    }
}
