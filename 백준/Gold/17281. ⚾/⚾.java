import java.util.*;
public class Main {
    static int N;
    static int[][] table;
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws Exception{
        //System.setIn(new FileInputStream("sample_input.txt"));
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt(); //이닝 입력
        table = new int[N][9];
        for(int i=0;i<N;i++){
            for(int j=0;j<9;j++){
                table[i][j] = sc.nextInt();
            }
        }
        int[] order = {1,2,3,4,5,6,7,8};
        do{ //선수 순서 고르기
            int[] playerList = new int[9];
            for (int i = 0; i < playerList.length;i++) {
                if(i==3){
                    playerList[i] = 0;
                }else if(i<3){
                    playerList[i] = order[i];
                }else if(i>3){
                    playerList[i] = order[i-1];
                }
            }
            int outCount = 0; //이닝 종료 시점 결정
            int base = 0; //베이스 상태
            int totalPoint = 0; //해당 순서로 얻은 점수
            int currentbatter = 0; //현재 타자
            for(int i=0;i<N;i++){
                while(outCount != 3){
                    if(table[i][playerList[currentbatter]]==0){ //아웃
                        outCount++;
                    }else if(table[i][playerList[currentbatter]]==1){//안타
                        base = (base<<1) | 1; //한 루씩 이동
                        
                    }else if(table[i][playerList[currentbatter]]==2){//2루타
                        base = (base<<2) | (1<<1);

                    }else if(table[i][playerList[currentbatter]]==3){//3루타
                        base = (base<<3) | (1<<2);

                    }else if(table[i][playerList[currentbatter]]==4){//홈런
                        base = (base<<4) | (1<<3);
                    }
                    totalPoint += getScore(base);
                    currentbatter = (currentbatter+1) % 9;
                    base = base&7;
                }
                outCount = 0;
                base = 0;
            }
            max = Math.max(max,totalPoint);
        }while(np(order));
        System.out.println(max);
        sc.close();
    }

    static boolean np(int[] numbers){
        int i = numbers.length-1;
        while(i>0 && numbers[i-1]>=numbers[i]) --i;
        if(i==0) return false;

        int j = numbers.length-1;
        while(numbers[i-1]>=numbers[j]) --j;
        swap(i-1,j,numbers);

        int k = numbers.length-1;
        while(i<k) swap(i++, k--, numbers);

        return true;
    }
    static void swap(int i, int j, int[] numbers){
        int temp = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = temp;
    }
    static int getScore(int base){
        int count = 0;
        int temp = base>>3;
        while(temp!=0){
            if((temp&1)==1){
                count++;
            }
            temp=temp>>1;
        }
        return count;
    }
}