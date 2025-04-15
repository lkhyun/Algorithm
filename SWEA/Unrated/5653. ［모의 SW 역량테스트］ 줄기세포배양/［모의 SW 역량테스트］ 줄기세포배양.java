import java.util.*;
import java.io.*;

public class Solution {
    static int N, M, K;
    static int[][] area;// 영역
    static int[] survive;// 인덱스 시간에 살아있는 세포의 수
    static PriorityQueue<int[]> pq;
    static boolean[][] visited;
    static int[] di = {-1, 1, 0, 0};
    static int[] dj = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        // System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            bw.write("#" + t + " ");
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            area = new int[1000][1000]; // k가 300까지라서 가장 빠르게 2씩 증가한다고 했을때 이정도로 잡기
            survive = new int[K + 30]; // 1-base 시간 단위니까

            // pq - input: int[0]: i, int[1]: j, int[2]: 시작시간, int[3]: 생명력
            pq = new PriorityQueue<>((a, b) -> {
                if (a[2] != b[2]) {
                    return a[2] - b[2];
                } else {
                    return b[3] - a[3];
                }
            }); // 시작 시간은 낮은거부터 생명력 높은거부터
            visited = new boolean[1000][1000];

            int endi, endj;
            if (N % 2 == 1)
                endi = 501 + (N / 2);
            else
                endi = 500 + (N / 2);
            if (M % 2 == 1)
                endj = 501 + (M / 2);
            else
                endj = 500 + (M / 2);

            for (int i = 500 - (N / 2); i < endi; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 500 - (M / 2); j < endj; j++) {
                    area[i][j] = Integer.parseInt(st.nextToken());
                    if (area[i][j] != 0) {
                        pq.add(new int[] {i, j, area[i][j], area[i][j]});
                        visited[i][j] = true;
                    }
                }
            }

            int time = 0;
            while (time <= K && !pq.isEmpty()) {
                survive[time] += pq.size();// 비활성화 상태인 세포들 개수 저장
                while (pq.peek()[2] == time) {// 활성화될 세포 있음.
                    int[] cur = pq.poll();

                    for (int i = 1; i < cur[3]; i++) { // 큐에서 나가더라도 생명력만큼 살아 있음.
                        survive[time + i]++;
                    }

                    for (int k = 0; k < 4; k++) {
                        int newi = cur[0] + di[k];
                        int newj = cur[1] + dj[k];

                        if (visited[newi][newj])
                            continue;
                        pq.add(new int[] {newi, newj, time + cur[3] + 1, cur[3]});
                        visited[newi][newj] = true;
                    }
                }
                time++;
            }
            bw.write(survive[K] + "\n");
        }
        bw.close();
    }
}
