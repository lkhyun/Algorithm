import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        ArrayDeque<Integer> stk = new ArrayDeque<>();
        for(int i=0;i<N;i++){
            String cmd = sc.next();
            if(cmd.equals("push")){
                int X = sc.nextInt();
                stk.push(X);
            }else if(cmd.equals("pop")){
                Integer temp = stk.poll();
                if(temp != null){
                    System.out.println(temp);
                }else{
                    System.out.println("-1");
                }
            }else if(cmd.equals("size")){
                System.out.println(stk.size());
            }else if(cmd.equals("empty")){
                if(stk.isEmpty()){
                    System.out.println("1");
                }else{
                    System.out.println("0");
                }
                
            }else if(cmd.equals("top")){
                if(stk.peek() != null){
                    System.out.println(stk.peek());
                }else{
                    System.out.println("-1");
                }
                
            }
        }
    }
}