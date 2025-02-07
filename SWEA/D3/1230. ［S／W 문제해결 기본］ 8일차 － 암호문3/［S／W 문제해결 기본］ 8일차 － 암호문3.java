import java.io.*;
import java.util.*;
public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        for(int t=1;t<=10;t++){
            int N = Integer.parseInt(br.readLine());
            List<Integer> Codes = new LinkedList<>();
            st = new StringTokenizer(br.readLine());
            for(int i=0;i<N;i++) { //말뭉치 저장
                Codes.add(Integer.parseInt(st.nextToken()));
            }
            int commands = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            for(int i=0;i<commands;i++){ // 명령어 개수만큼
                String command = st.nextToken();
                if(command.equals("I")){ //삽입
                    int insertposition = Integer.parseInt(st.nextToken());
                    int insertcount = Integer.parseInt(st.nextToken());
                    List<Integer> addList = new LinkedList<>();
                    for(int j=0;j<insertcount;j++) {
                        addList.add(Integer.parseInt(st.nextToken()));
                    }
                    Codes.addAll(insertposition,addList);
                }else if(command.equals("D")){ //삭제
                    int deleteposition = Integer.parseInt(st.nextToken());
                    int deletecount = Integer.parseInt(st.nextToken());
                    for(int j=0;j<deletecount;j++){
                        if(deleteposition < Codes.size()) {
                            Codes.remove(deleteposition);
                        }
                    }
                }else if(command.equals("A")){ //추가
                    int addcount = Integer.parseInt(st.nextToken());
                    List<Integer> addList= new LinkedList<>();
                    for(int j=0;j<addcount;j++){
                        addList.add(Integer.parseInt(st.nextToken()));
                    }
                    Codes.addAll(addList);
                }
            }
            bw.write("#"+t);
            for(int i=0;i<10;i++){
                bw.write(" "+Codes.get(i));
            }
            bw.write("\n");

        }
        bw.flush();
    }
}
