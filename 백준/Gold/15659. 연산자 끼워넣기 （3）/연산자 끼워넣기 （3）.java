import java.util.*;
import java.io.*;
public class Main{
    static int N;
    static int[] numbers;
    static int[] operator = new int[4];
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;
    static ArrayDeque<Integer> operation = new ArrayDeque<>();

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        numbers = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            numbers[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<4;i++){
            operator[i] = Integer.parseInt(st.nextToken());
        }
        findMaxMin(0);
        bw.write(max+"\n");
        bw.write(min+"\n");
        bw.flush();
    }

    public static void findMaxMin(int depth){
        if(depth == N-1){
            int total = 0;
            int lastElement = numbers[depth];
            ArrayDeque<Integer> operandStk = new ArrayDeque<>();
            ArrayDeque<Integer> operatorStk = new ArrayDeque<>();
            ArrayDeque<Integer> provider = operation.clone();
            while(!provider.isEmpty()){
                if(!operandStk.isEmpty() && !operatorStk.isEmpty() && operatorStk.getLast()>=2){
                    int operand = operandStk.pollLast();
                    int opcode = operatorStk.pollLast();
                    int result = calculate(operand, provider.pollFirst(), opcode);
                    operandStk.addLast(result);
                    operatorStk.addLast(provider.pollFirst());
                }else{
                    operandStk.addLast(provider.pollFirst());
                    operatorStk.addLast(provider.pollFirst());
                }
            }
            if(!operatorStk.isEmpty() && operatorStk.getLast()>=2){
                lastElement = calculate(operandStk.pollLast(), lastElement, operatorStk.pollLast());
            }
            operandStk.addLast(lastElement);
            total = operandStk.pollFirst();
            while(!operandStk.isEmpty() && !operatorStk.isEmpty()){
                total = calculate(total, operandStk.pollFirst(), operatorStk.pollFirst());
            }
            max = Math.max(max,total);
            min = Math.min(min,total);
            return;
        }
        
        for(int i=0;i<4;i++){
            if(operator[i] > 0){
                operation.addLast(numbers[depth]);
                operation.addLast(i);
                operator[i]--;
                findMaxMin(depth+1);
                operator[i]++;
                operation.pollLast();
                operation.pollLast();
            }
        }
    }
    public static int calculate(int x, int y, int op){// 0:+ 1:- 2:x 3:/
        if(op==0){
            return x+y;
        }else if(op==1){
            return x-y;
        }else if(op==2){
            return x*y;
        }else if(op==3){
            return x/y;
        }
        return 0;
    }
}