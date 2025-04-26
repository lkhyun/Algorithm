import java.util.*;
import java.io.*;
public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    public static void main(String[] args) throws Exception{
        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            int operCnt = Integer.parseInt(br.readLine());
            PriorityQueue<Integer> minheap = new PriorityQueue<>((a,b) -> Integer.compare(a,b));
            PriorityQueue<Integer> maxheap = new PriorityQueue<>((a,b) -> Integer.compare(b,a));
            Map<Integer,Integer> m = new HashMap<>();

            for (int i = 0; i < operCnt; i++) {
                st = new StringTokenizer(br.readLine());
                String cmd = st.nextToken();
                int value = Integer.parseInt(st.nextToken());

                if(cmd.equals("I")){ //insert
                    minheap.add(value);
                    maxheap.add(value);
                    m.put(value,m.getOrDefault(value,0)+1);
                }else if(cmd.equals("D")) { //delete
                    if (m.isEmpty()) continue;

                    if (value == 1) {
                        Integer target = maxheap.poll();
                        while (!maxheap.isEmpty() && !m.containsKey(target)) {
                            target = maxheap.poll();
                        }
                        if (target == null) continue;

                        if (m.get(target) == 1) {
                            m.remove(target);
                        } else {
                            m.put(target, m.get(target) - 1);
                        }
                    } else if (value == -1) {
                        Integer target = minheap.poll();
                        while (!minheap.isEmpty() && !m.containsKey(target)) {
                            target = minheap.poll();
                        }
                        if (target == null) continue;

                        if (m.get(target) == 1) {
                            m.remove(target);
                        } else {
                            m.put(target, m.get(target) - 1);
                        }
                    }
                }
            }
            if(m.isEmpty()){
                bw.write("EMPTY\n");
            }else{
                Integer target = maxheap.poll();
                while (!maxheap.isEmpty() && !m.containsKey(target)) {
                    target = maxheap.poll();
                }
                bw.write(target+" ");
                target = minheap.poll();
                while (!minheap.isEmpty() && !m.containsKey(target)) {
                    target = minheap.poll();
                }
                bw.write(target+"\n");
            }
            bw.flush();
        }
        bw.close();
    }
}

