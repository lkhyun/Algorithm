import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        String str = sc.next();
        char[] arr = str.toCharArray();
        int total = 0;
        for(int i=0;i<N;i++){
            total += arr[i] - '0';
        }
        System.out.println(total);
    }
}