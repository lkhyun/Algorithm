import java.util.Scanner;
public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();
        int count = 1;
        int i=1;
        while(input>count){
            count += ++i;
        }
        int temp = count-input;
        if(i%2==0){System.out.printf("%d/%d\n",i-temp,1+temp);}
        else{System.out.printf("%d/%d\n",1+temp,i-temp);}
        sc.close();
    }
}
