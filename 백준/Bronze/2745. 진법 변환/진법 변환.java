import java.util.Scanner;
public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String N = sc.next();
        int B = sc.nextInt();
        int result = 0;
        int len = N.length();
        for(int i=0;i<len;i++){
            int ch = N.charAt(i);
            if(ch>=65 && ch<=90){
                result += (ch-55)*Math.pow(B,len-i-1);
            }
            else{
                result += (ch-48)*Math.pow(B,len-i-1);
            }
        }
        System.out.println(result);
        sc.close();
    }
}