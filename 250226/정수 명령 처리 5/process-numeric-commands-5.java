import java.util.Scanner;
import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Integer> l = new ArrayList<>();
        for(int i=0;i<n;i++){
            String str = sc.next();
            if(str.equals("push_back")){
                int k = sc.nextInt();
                l.add(l.size(),k);
            }else if(str.equals("get")){
                int k = sc.nextInt();
                System.out.println(l.get(k-1));
            }else if(str.equals("pop_back")){
                l.remove(l.size()-1);

            }else if(str.equals("size")){
                System.out.println(l.size());
            }
        }
    }
}