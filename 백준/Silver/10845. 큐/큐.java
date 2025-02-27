import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        ArrayDeque<Integer> q = new ArrayDeque<>();
        for(int i=0;i<N;i++){
            String cmd = sc.next();
            if(cmd.equals("push")){
                int X = sc.nextInt();
                q.add(X);
            }else if(cmd.equals("pop")){
                Integer temp = q.poll();
                if(temp != null){
                    System.out.println(temp);
                }else{
                    System.out.println("-1");
                }
            }else if(cmd.equals("size")){
                System.out.println(q.size());
            }else if(cmd.equals("empty")){
                if(q.isEmpty()){
                    System.out.println("1");
                }else{
                    System.out.println("0");
                }
                
            }else if(cmd.equals("front")){
                if(q.peek() != null){
                    System.out.println(q.peek());
                }else{
                    System.out.println("-1");
                }
            }else if(cmd.equals("back")){
                if(q.peekLast() != null){
                    System.out.println(q.peekLast());
                }else{
                    System.out.println("-1");
                }
            }
        }
    }
}