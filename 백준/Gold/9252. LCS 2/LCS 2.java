import java.io.*;
import java.util.*;

public class Main {
    static class Node{
        int pos;
        int len;
        Node(int pos, int len){
            this.pos = pos;
            this.len = len;
        }
    }
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        char[] str1 = br.readLine().toCharArray();
        char[] str2 = br.readLine().toCharArray();
        Node[][] LCS = new Node[1001][1001]; // 공통 문자와 길이를 함께 저장할거
        for (int i = 0; i <= 1000; i++) {
            LCS[i][0] = new Node(0, 0);
            LCS[0][i] = new Node(0, 0);
        }

        for (int i = 1; i <= str1.length; i++) {
            for (int j = 1; j <= str2.length; j++) {
                if(str1[i-1] == str2[j-1]){
                    LCS[i][j] = new Node(0, LCS[i-1][j-1].len +1);
                }else if(LCS[i-1][j].len >= LCS[i][j-1].len){
                    LCS[i][j] = new Node(1, LCS[i-1][j].len);
                }else if(LCS[i][j-1].len >= LCS[i-1][j].len){
                    LCS[i][j] = new Node(2, LCS[i][j-1].len);
                }
            }
        }
        int ans1 = LCS[str1.length][str2.length].len;
        char[] ans2 = new char[ans1];
        int i = str1.length;
        int j = str2.length;
        for (int k = 0; k < ans1; k++) {
            while(i>0 && j>0 && LCS[i][j].pos != 0){
                if(LCS[i][j].pos == 1){
                    i--;
                }else if(LCS[i][j].pos == 2){
                    j--;
                }
            }
            ans2[k] = str1[i-1];
            i--;
            j--;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(ans1).append("\n");
        for (int k = ans1-1; k >= 0 ; k--) {
            sb.append(ans2[k]);
        }
        bw.write(sb.toString());
        bw.close();
    }
}
