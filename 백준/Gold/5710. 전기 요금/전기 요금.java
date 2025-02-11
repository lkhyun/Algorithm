import java.util.*;
import java.io.*;

public class Main {
    static int A;
    static int B;
    static int totalUse;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        while (st.hasMoreTokens()) {
            A = Integer.parseInt(st.nextToken()); // 총 사용량에 기반한 요금
            B = Integer.parseInt(st.nextToken()); // 요금 차이
            if (A == 0 && B == 0) break;
            
            totalUse = convertToUse(A); // 총 사용량(상한)
            int use1 = binarySearch(0, totalUse); // 상근이의 사용 요금
            int use2 = totalUse-use1;
            bw.write(Math.min(convertToFee(use1),convertToFee(use2)) +"\n");
            st = new StringTokenizer(br.readLine());
        }
        
        bw.flush();
    }

    public static int binarySearch(int left, int right) {
        while (left <= right) {
            int mid = (left + right) / 2;
            int sangeunFee = convertToFee(mid);
            int nextToFee = convertToFee(totalUse - mid);
            
            if (Math.abs(nextToFee - sangeunFee) == B) return mid;
            else if (Math.abs(nextToFee - sangeunFee) < B) right = mid - 1;
            else left = mid + 1;
        }
        return left;
    }

    public static int convertToFee(int use) { // 사용량 -> 요금
        if (use > 1000000) return 4979900 + (use - 1000000) * 7;
        if (use > 10000) return 29900 + (use - 10000) * 5;
        if (use > 100) return 200 + (use - 100) * 3;
        return use * 2;
    }

    public static int convertToUse(int fee) { // 요금 -> 사용량
        if (fee > 4979900) return 1000000 + (fee - 4979900) / 7;
        if (fee > 29900) return 10000 + (fee - 29900) / 5;
        if (fee > 200) return 100 + (fee - 200) / 3;
        return fee / 2;
    }
}
