import java.util.Scanner;
public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        int V = sc.nextInt();
        int day = (V-B)/(A-B);
        int flag = (V-B)%(A-B);
        if(flag==0){
            System.out.println(day);
        }
        else{
            System.out.println(day+1);
        }
        sc.close();
    }
}
