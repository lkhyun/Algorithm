import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int[][] matrix = new int[9][9];
    static List<int[]> zeroList = new ArrayList<>();
    static boolean flag = false;

    public static void main(String[] args) throws IOException {
        for (int i = 0; i < 9; i++) {
            char[] line = br.readLine().toCharArray();
            for (int j = 0; j < 9; j++) {
                matrix[i][j] = Character.getNumericValue(line[j]);
                if(matrix[i][j] == 0) {
                    zeroList.add(new int[]{i,j});
                }
            }
        }
        backtracking(0);
        bw.close();
    }
    public static void backtracking(int start) throws IOException {
        if(flag) return;
        if(start == zeroList.size()) {
            flag = true;
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    sb.append(matrix[i][j]);
                }
                sb.append('\n');
            }
            bw.write(sb.toString());
            return;
        }
        int curi = zeroList.get(start)[0];
        int curj = zeroList.get(start)[1];
        boolean[] visited = new boolean[10];
        for (int k = 0; k < 9; k++) {
            visited[matrix[k][curj]] = true;
            visited[matrix[curi][k]] = true;
        }
        for (int i = (curi/3)*3; i < (curi/3)*3 + 3; i++) {
            for (int j = (curj/3)*3; j < (curj/3)*3 + 3 ; j++) {
                visited[matrix[i][j]] = true;
            }
        }
        for (int i = 1; i <= 9; i++) {
            if(!visited[i]) {
                matrix[curi][curj] = i;
                backtracking(start+1);
                matrix[curi][curj] = 0;
            }
        }
    }
}
