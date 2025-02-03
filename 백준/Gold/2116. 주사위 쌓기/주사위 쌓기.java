import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[] diceInput = new int[6];
        int[][] Dices = new int[N][7];
        for(int i=0;i<N;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 6; j++) {
                diceInput[j] = Integer.parseInt(st.nextToken());
            }
            Dices[i][diceInput[0]] = diceInput[5]; //A F
            Dices[i][diceInput[1]] = diceInput[3]; //B D
            Dices[i][diceInput[2]] = diceInput[4]; //C E
            Dices[i][diceInput[3]] = diceInput[1]; //D B
            Dices[i][diceInput[4]] = diceInput[2]; //E C
            Dices[i][diceInput[5]] = diceInput[0]; //F A
        }
        int max = 0;
        for(int i=1;i<7;i++){
            int bottom = i;
            int top = Dices[0][i];
            int sum = 0;
            if(bottom != 6 && top != 6){ sum = 6;}
            else if(bottom != 5 && top != 5) { sum = 5;}
            else{sum=4;}
            for(int j=1;j<N;j++){
                bottom = top;
                top = Dices[j][bottom];
                if(bottom != 6 && top != 6){ sum += 6;}
                else if(bottom != 5 && top != 5) { sum += 5;}
                else{sum += 4;}
            }
            if(max<sum){max = sum;}
        }
        bw.write(max+"");
        bw.flush();
    }
}
