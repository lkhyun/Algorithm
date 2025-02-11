import java.util.*;
import java.io.*;

public class Main {
    static int A;
    static int B;
    static int totalUse;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            A = Integer.parseInt(st.nextToken()); 
            B = Integer.parseInt(st.nextToken());
            
            if (A == 0 && B == 0) break;
            
            totalUse = convertToUse(A); // 총 사용량
            int sangeunUse = binarySearch(0, totalUse); // 상근이의 사용량 결정
            
            // 올바른 요금 선택 (더 작은 값을 출력)
            int fee1 = convertToFee(sangeunUse);
            int fee2 = convertToFee(totalUse - sangeunUse);
            bw.write(Math.min(fee1, fee2) + "\n");
        }
        
        bw.flush();
    }

    public static int binarySearch(int left, int right) {
        while (left <= right) {
            int mid = (left + right) / 2;
            int sangeunFee = convertToFee(mid);
            int nextToFee = convertToFee(totalUse - mid);
            
            int diff = Math.abs(nextToFee - sangeunFee);
            if (diff == B) return mid;
            else if (diff < B) right = mid - 1;
            else left = mid + 1;
        }
        return left;
    }

    public static int convertToFee(int use) { // 사용량 -> 요금 변환
        if (use > 1000000) return 4979900 + (use - 1000000) * 7;
        if (use > 10000) return 29900 + (use - 10000) * 5;
        if (use > 100) return 200 + (use - 100) * 3;
        return use * 2;
    }

    public static int convertToUse(int fee) { // 요금 -> 사용량 변환
        if (fee > 4979900) return 1000000 + (fee - 4979900) / 7;
        if (fee > 29900) return 10000 + (fee - 29900) / 5;
        if (fee > 200) return 100 + (fee - 200) / 3;
        return fee / 2;
    }
}
