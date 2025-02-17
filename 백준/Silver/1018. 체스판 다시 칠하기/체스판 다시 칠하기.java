import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        char[][] chessBoard = new char[N][M];
        char[][] testBoard1 = {{'B','W','B','W','B','W','B','W'},
                               {'W','B','W','B','W','B','W','B'},
                               {'B','W','B','W','B','W','B','W'},
                               {'W','B','W','B','W','B','W','B'},
                               {'B','W','B','W','B','W','B','W'},
                               {'W','B','W','B','W','B','W','B'},
                               {'B','W','B','W','B','W','B','W'},
                               {'W','B','W','B','W','B','W','B'}};
        char[][] testBoard2 = {{'W','B','W','B','W','B','W','B'},
                               {'B','W','B','W','B','W','B','W'},
                               {'W','B','W','B','W','B','W','B'},
                               {'B','W','B','W','B','W','B','W'},
                               {'W','B','W','B','W','B','W','B'},
                               {'B','W','B','W','B','W','B','W'},
                               {'W','B','W','B','W','B','W','B'},
                               {'B','W','B','W','B','W','B','W'}};


        for(int i=0;i<N;i++) {
            char[] str = br.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                chessBoard[i][j] = str[j];
            }
        }
        int min1 = 64;
        int min2 = 64;
        for(int i=0;i<=N-8;i++){
            for(int j=0;j<=M-8;j++){
                int count1 = 0;
                int count2 = 0;
                for(int k=0;k<8;k++){
                    for(int l=0;l<8;l++){
                        if(chessBoard[i+k][j+l] != testBoard1[k][l]) {
                            count1++;
                        }
                        if(chessBoard[i+k][j+l] != testBoard2[k][l]) {
                            count2++;
                        }
                    }
                }
                min1 = Math.min(count1,min1);
                min2 = Math.min(count2,min2);
            }
        }
        bw.write(String.valueOf(Math.min(min1,min2)));
        bw.flush();
    }
}
