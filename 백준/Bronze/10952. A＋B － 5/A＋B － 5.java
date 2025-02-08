import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextInt()){
            int A = sc.nextInt();
            int B = sc.nextInt();
            if(A==0 && B==0){break;}
            System.out.println(A+B);
        }

    }
}
