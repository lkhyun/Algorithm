import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        //1,2,Fizz,4,Buzz,Fizz,7,8,Fizz,Buzz,11,Fizz,13,14,FizzBuzz ...
        //3번마다 Fizz, 5번마다 Buzz, 15번마다 FizzBuzz 결국 이게 반복
        //따라서 3개를 추출했을때 무조건 숫자가 최소 한개는 들어가있음.
        int number=0;
        String[] strs = new String[3];
        for(int i=0;i<3;i++){
            strs[i] = br.readLine();
        }
        for(int i=0;i<3;i++){
            if(!strs[i].contains("Fizz") && !strs[i].contains("Buzz")){
                number = Integer.parseInt(strs[i]) + (3-i);
                break;
            }
        }
        if(number%3==0&&number%5==0){
            bw.write("FizzBuzz");
        }else if(number%3==0){
            bw.write("Fizz");
        }else if(number%5==0){
            bw.write("Buzz");
        }else{
            bw.write(number+"");
        }
        bw.flush();
    }
    
}
