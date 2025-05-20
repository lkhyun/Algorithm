import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    // 연산자 우선순위 반환 함수
    static int getPriority(char op) {
        if (op == '+' || op == '-') return 1;
        if (op == '*' || op == '/') return 2;
        return 0; // '('의 경우
    }

    public static void main(String[] args) throws IOException {
        char[] splitstr = br.readLine().toCharArray();
        ArrayDeque<Character> stack = new ArrayDeque<>();

        for (char c : splitstr) {
            if (c >= 'A' && c <= 'Z' || c >= 'a' && c <= 'z' || c >= '0' && c <= '9') {
                // 피연산자는 바로 출력
                bw.write(c);
            } else if (c == '(') {
                // 여는 괄호는 스택에 푸시
                stack.push(c);
            } else if (c == ')') {
                // 닫는 괄호는 여는 괄호를 만날 때까지 스택에서 팝하여 출력
                while (!stack.isEmpty() && stack.peek() != '(') {
                    bw.write(stack.pop());
                }
                if (!stack.isEmpty() && stack.peek() == '(') {
                    stack.pop(); // '(' 제거
                }
            } else if (c == '+' || c == '-' || c == '*' || c == '/') {
                // 현재 연산자보다 우선순위가 높거나 같은 연산자들을 모두 출력
                while (!stack.isEmpty() && stack.peek() != '(' &&
                        getPriority(stack.peek()) >= getPriority(c)) {
                    bw.write(stack.pop());
                }
                stack.push(c);
            }
        }

        // 스택에 남아있는 모든 연산자를 출력
        while (!stack.isEmpty()) {
            if (stack.peek() != '(') { // 여는 괄호는 출력하지 않음
                bw.write(stack.pop());
            } else {
                stack.pop();
            }
        }

        bw.flush();
        bw.close();
    }
}