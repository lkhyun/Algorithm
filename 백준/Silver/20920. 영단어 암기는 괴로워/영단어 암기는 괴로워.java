import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

class Word{
    String word;
    int count;
    Word(String word,int count){
        this.word = word;
        this.count = count;
    }
}
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        Map<String,Integer> wordMap = new HashMap<>();
        for(int i=0;i<N;i++){
            String str = br.readLine();
            if(str.length()>=M){
                wordMap.put(str,wordMap.getOrDefault(str, 0)+1);
            }
        }
        Word[] Wordbook = new Word[wordMap.size()];
        int i=0;
        for(Map.Entry<String,Integer> s:wordMap.entrySet()){
            Wordbook[i++] = new Word(s.getKey(), s.getValue());
        }
        List<Word> words = new ArrayList<>(Arrays.asList(Wordbook));
        words.sort(Comparator.comparingInt((Word w) -> w.count)
                             .thenComparingInt(w -> w.word.length())
                             .reversed()
                             .thenComparing(w -> w.word));
        for(Word str : words){
            bw.write(str.word + "\n");
        }
        bw.flush();
    }
}
