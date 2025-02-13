import java.util.*;
import java.io.*;
public class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        long K = Long.parseLong(st.nextToken());
        int[] workSpeed = new int[N];
        
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            workSpeed[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(workSpeed);

        int min = workSpeed[0]; //어느 한쪽 팀은 무조건 전체 속도의 최솟값을 가지게 될거임. 이를 a로 설정
        int aTeamCount = 0;
        int aTeamSpeed = min;
        int bTeamCount = 0;
        long bTeamSpeed = 0;
        long totalSpeed = 0;
        long maxSpeed = 0;
        for(int i=1;i<N;i++){
            bTeamSpeed = workSpeed[i]; // 작업 속도배열을 순회하며 하나씩 최솟값이 존재하지 않는 다른 팀의 하한으로 결정
            aTeamCount = i;
            bTeamCount = N-i;
            /* 작업 속도는 정렬되어 있고 총 작업 속도의 최댓값을 찾는 것이 목적. 이때 작업속도의 최솟값이 존재하지
             * 않는 bTeam의 작업자 입장에서는 ateam의 하한에 곱해질 바에 bteam의 하한에 곱해지는게 무조건 이득임.
             */
            totalSpeed = (long)aTeamCount*aTeamSpeed + bTeamCount*bTeamSpeed;
            maxSpeed = Math.max(maxSpeed,totalSpeed);
        }
        bw.write((K+maxSpeed-1)/maxSpeed+"");
        
        bw.flush();
    }
}