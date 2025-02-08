import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int H;
        int W;
        int N;
        int height;
        int weight;
        for(int t = 1;t<=T;t++) {
            H = sc.nextInt();
            W = sc.nextInt();
            N = sc.nextInt();
            height = N%H;
            weight = N/H + 1;
            if(height == 0){
                height = H;
                weight -= 1;
            }
            if(weight < 10){
                System.out.println(height + "0" + weight);
            }
            else{
                System.out.println(height + "" + weight);
            }
        }
        sc.close();
    }
}
