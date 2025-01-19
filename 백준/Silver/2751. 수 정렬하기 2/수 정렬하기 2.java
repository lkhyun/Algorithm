import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 빠른 입력을 위한 BufferedReader 사용
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 첫 번째 줄에서 N 읽기
        int N = Integer.parseInt(br.readLine());
        int[] numbers = new int[N];

        // 배열에 숫자 저장
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(br.readLine());
        }

        // 배열 정렬
        Arrays.sort(numbers);

        // 정렬된 결과 출력
        for (int num : numbers) {
            bw.write(num + "\n");
        }

        // BufferedWriter 닫기
        bw.flush();
        bw.close();
    }
}