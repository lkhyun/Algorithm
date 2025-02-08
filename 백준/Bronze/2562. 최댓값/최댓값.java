import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[9];
        int max = sc.nextInt();
        int maxIndex = 1;
        for(int i=1;i<9;i++) {
            arr[i] = sc.nextInt();
            if(max<arr[i]){
                max = arr[i];
                maxIndex = i+1;
            }
        }
        System.out.println(max);
        System.out.println(maxIndex);
    }
}
