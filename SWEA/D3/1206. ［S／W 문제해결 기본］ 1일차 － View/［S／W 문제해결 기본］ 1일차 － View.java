import java.util.Scanner;
class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		for(int t=1;t<=10;t++) { //10개의 테스트케이스(고정)
			int answer = 0;
			int N = sc.nextInt(); //건물 개수 입력
			int[] buildings = new int[N];
			for(int n=0;n<N;n++) { //건물 개수만큼 입력받을것
				buildings[n] = sc.nextInt();
			}
			for(int n=2;n<N-2;n++) {
				int temp1 = Math.max(buildings[n-2], buildings[n-1]);
				int temp2 = Math.max(buildings[n+1], buildings[n+2]);
				int sideMaxBuilding = Math.max(temp1, temp2);
				if(sideMaxBuilding < buildings[n]) {
					answer += buildings[n]-sideMaxBuilding;
				}
			}
			System.out.printf("#%d %d\n",t,answer);
		}
	}
}