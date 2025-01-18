import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;

public class Main{

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int inputCount = sc.nextInt();
        int wordCount = inputCount;
        for(int i=0;i<inputCount;i++){
            char[] words = sc.next().toCharArray();
            Map<Character,Integer> dup = new HashMap<>();
            char prev = words[0];
            dup.put(prev,1);
            for(int j=1;j<words.length;j++) {
                if (words[j] == prev) {
                    dup.put(prev, dup.get(prev) + 1);
                } else {
                    if (dup.getOrDefault(words[j], 0) == 0) {
                        dup.put(words[j], 1);
                        prev = words[j];
                    } else {
                        wordCount--;
                        break;
                    }
                }
            }
        }
        System.out.println(wordCount);
    }
}