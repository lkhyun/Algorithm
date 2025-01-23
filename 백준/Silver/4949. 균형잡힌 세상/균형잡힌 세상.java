import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws Exception{
        Stack<String> stk = new Stack<>();
        Scanner sc = new Scanner(System.in);
        while(true){
            String[] lines = sc.nextLine().split("");
            if(lines.length==1 && lines[0].equals(".")){break;}
            for(int i=0;i<lines.length;i++){
                String cursor = lines[i];
                if(cursor.equals("(")||cursor.equals("[")){stk.push(cursor);}
                else if(cursor.equals(")")){
                    if(stk.isEmpty()){stk.push(cursor);break;}
                    else if(stk.peek().equals("(")){
                        stk.pop();
                    }
                    else{
                        break;
                    }
                }
                else if(cursor.equals("]")){
                    if(stk.isEmpty()){stk.push(cursor);break;}
                    else if(stk.peek().equals("[")){
                        stk.pop();
                    }
                    else{
                        break;
                    }
                }
            }
            if(stk.size()==0){System.out.println("yes");}
            else{System.out.println("no");}
            stk.clear();
        }
        sc.close();
    }
}
