import java.util.Scanner;
public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int destination = sc.nextInt();
        int i=1;
        int number = 1;
        while(destination>number){
            number += 6*i++;
        }
        System.out.println(i);
        sc.close();
    }
}