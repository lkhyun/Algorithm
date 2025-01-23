import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

public class Main {
    static int subin;
    static int brother;
    static boolean visited[] = new boolean[100001];
    static int time = 0;
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        subin = sc.nextInt();
        brother = sc.nextInt();
        if(brother < subin){System.out.println(subin-brother); return;}
        BFS();
        System.out.println(time);
        sc.close();
    }
    static void BFS(){
        Queue<Integer> q = new LinkedList<>();
        Queue<Integer> timeq = new LinkedList<>();
        q.offer(subin);
        timeq.offer(time);
        while(!q.isEmpty()){
            int currentPosition = q.poll();
            time = timeq.poll();
            if(currentPosition == brother){break;}

            if(currentPosition*2>=0 && currentPosition*2<=100000 && !visited[currentPosition*2]){
                q.offer(currentPosition*2);
                visited[currentPosition*2] = true;
                timeq.offer(time+1);
            }
            if(currentPosition+1>=0 && currentPosition+1<=100000 && !visited[currentPosition+1]){
                q.offer(currentPosition+1);
                visited[currentPosition+1] = true;
                timeq.offer(time+1);
            }
            if(currentPosition-1>=0 && currentPosition-1<=100000 && !visited[currentPosition-1] ){
                q.offer(currentPosition-1);
                visited[currentPosition-1] = true;
                timeq.offer(time+1);
            }
            
        }
    }
}
