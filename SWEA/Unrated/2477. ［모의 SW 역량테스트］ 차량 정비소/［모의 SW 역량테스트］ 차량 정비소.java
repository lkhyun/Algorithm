import java.io.*;
import java.util.*;

class Node{
    boolean flag;
    int number,time,receptionNumber;

    public Node(int number, int time, int receptionNumber, boolean flag) {
        this.flag = flag;
        this.number = number;
        this.receptionNumber = receptionNumber;
        this.time = time;
    }
}
class Order{
    boolean flag;
    int number;
    int finishTime;

    public Order(){
        this.number = -1;
    }

    public Order(int number, int finishTime,boolean flag) {
        this.number = number;
        this.finishTime = finishTime;
        this.flag = flag;
    }
}

public class Solution {
    static int N; // 접수 창구 개수
    static int M; // 정비 창구 개수
    static int K; // 고객 수
    static int A; // 지갑을 두고 간 고객이 이용한 접수 창구 번호
    static int B; // 지갑을 두고 간 고객이 이용한 정비 창구 번호
    static int[] Ni; // i번째 접수 창구가 처리하는데 걸리는 시간
    static int[] Mi; // i번째 정비 창구가 처리하는데 걸리는 시간
    static Map<Integer,List<Integer>> arrivedTime; //고객들이 정비소에 도착한 시간

    static PriorityQueue<Node> receptionQ;
    static PriorityQueue<Node> repairQ;
    static Order[] receptionDesk;
    static Order[] repairDesk;
    
    public static void main(String[] args) throws Exception {
        //System.setIn(new FileInputStream("sample_input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for(int t = 1;t<=T;t++){
            bw.write("#"+t+" ");
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            A = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());
            Ni = new int[N+1];
            Mi = new int[M+1];
            arrivedTime = new HashMap<>();
            receptionQ = new PriorityQueue<>((a,b) -> a.number-b.number);
            repairQ = new PriorityQueue<>((a,b) -> {
                if(a.time == b.time){
                    return a.receptionNumber-b.receptionNumber;
                }else{
                    return a.time - b.time;
                }
            });
            receptionDesk = new Order[N+1];
            for(int i=1;i<=N;i++) receptionDesk[i] = new Order();
            repairDesk = new Order[M+1];
            for(int i=1;i<=M;i++) repairDesk[i] = new Order();

            int currentTime = 0;
            int finishedCnt = 0;
            List<Integer> answers = new ArrayList<>();

            st = new StringTokenizer(br.readLine());
            for(int i=1;i<=N;i++){
                Ni[i] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for(int i=1;i<=M;i++){
                Mi[i] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for(int i=1;i<=K;i++){
                int temp = Integer.parseInt(st.nextToken());
                List<Integer> tempList = arrivedTime.getOrDefault(temp,new ArrayList<>());
                tempList.add(i);
                arrivedTime.put(temp,tempList);
            }

            while(finishedCnt != K){
                List<Integer> currentpeople = arrivedTime.get(currentTime); // 현재 시간에 도착한 사람들 가져옴
                if(currentpeople != null){ //있으면
                    for(int n : currentpeople){
                        receptionQ.add(new Node(n,currentTime,0,false)); //모두 접수 대기큐에 넣기
                    }
                }

                for(int i=1;i<=N;i++){ //접수 데스크 상태 확인
                    Order r = receptionDesk[i];
                    if(r.number == -1) continue; //빈 상태면 넘어가기
                    if(r.finishTime == currentTime){ // 끝날 시간이라면
                        if(i == A){ //A번 창구를 이용한 경우 플래그 set
                            repairQ.add(new Node(r.number, currentTime, i, true));// 수리 큐에 넣기
                        }else{
                            repairQ.add(new Node(r.number, currentTime, i, false));// 수리 큐에 넣기
                        }
                        r.number = -1; //빈 상태로 만들기
                        r.flag = false;
                    }
                }
                for(int i=1;i<=M;i++){ //수리 데스크 상태 확인
                    Order r = repairDesk[i];
                    if(r.number == -1) continue; //빈 상태면 넘어가기
                    if(r.finishTime == currentTime){ // 끝날 시간이라면
                        if(i == B && r.flag){
                            answers.add(r.number);
                        }
                        r.number = -1; //빈 상태로 만들기
                        r.flag = false;
                        finishedCnt++; //끝난 사람 수 증가
                    }
                }
                for(int i=1;i<=N;i++){ // 접수 데스크에 집어 넣기
                    if(receptionQ.isEmpty()) break;
                    Order r = receptionDesk[i];
                    if(r.number == -1){ // 비었다면
                        Node n = receptionQ.poll();
                        r.number = n.number;
                        r.finishTime = currentTime + Ni[i];
                        r.flag = n.flag;
                    }
                }
                for(int i=1;i<=M;i++){ //수리 데스크에 집어 넣기
                    if(repairQ.isEmpty()) break;
                    Order r = repairDesk[i];
                    if(r.number == -1){ // 비었다면
                        Node n = repairQ.poll();
                        r.number = n.number;
                        r.finishTime = currentTime + Mi[i];
                        r.flag = n.flag;
                    }
                }

                currentTime++;
            }
            int total = 0;
            for(int i:answers){
                total += i;
            }
            if(total == 0){
                bw.write("-1\n");
            }else{
                bw.write(total+"\n");
            }
        }
        
        bw.close();
    }
}
