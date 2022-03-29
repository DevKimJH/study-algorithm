package studyAlgorithm.D220313;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 총 8개의 톱니를 가지고 있는 톱니바퀴 4개가 일렬
 톱니는 N극 또는 S극 중 하나
 톱니바퀴에는 번호가 매겨져 있는데, 가장 왼쪽 톱니바퀴부터 1, 2, 3, 4

 톱니바퀴를 K번 회전시키려고 한다. 톱니바퀴의 회전은 한 칸을 기준으로 한다. 회전은 시계방향과 반시계 방향이 있고 아래 그림과 같이 회전한다.

 톱니바퀴를 회전시키려면, 회전시킬 톱니바퀴와 회전시킬 방향을 결정해야 한다. 톱니바퀴가 회전할 때, 서로 맞닿은 극에 따라서 옆에 있는 톱니바퀴를 회전시킬 수도 있고, 회전시키지 안흥ㄹ 수도 있다,.

 톱니바퀴 A를 회전할 때, 그 옆에 있는 톱니바퀴 B와 서로 맞닿은 톱니의 극이 다르다면, B는 A가 회전한 방향과 반대방향으로 회전하게 된다.



 */
public class b14891톱니바퀴 {

    static StringBuilder[] wheelInfo;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int answer = 0;
        wheelInfo = new StringBuilder[4];

        //int[][] wheelArr = new int[4][8];

        //Queue[] wheelInfo = new Queue[4];

        for(int i = 0 ; i < 4 ; i++){
            wheelInfo[i] = new StringBuilder();
        }

        for(int i = 0 ; i < 4 ; i++){
            String inputWheelInfo = br.readLine();

            for(int j = 0 ; j < 8 ; j++){
                //wheelInfo[i].add(inputWheelInfo.charAt(j));
                wheelInfo[i].append(inputWheelInfo.charAt(j) - '0');
            }
        }

        // 회전 횟수 K
        int K = Integer.parseInt(br.readLine());

        for(int i = 0 ; i < K ; i++){
            st = new StringTokenizer(br.readLine(), " ");

            // 회전시키는 톱니바퀴
            int wheelNumber = Integer.parseInt(st.nextToken());
            wheelNumber = wheelNumber-1;

            // 방향 1 : 시계 , -1 : 반시계
            int direction = Integer.parseInt(st.nextToken());

            // 양방향 다 체크
            process(wheelNumber, direction, 2);
        }

        for(int i = 0 ; i < 4; i++){
            if(wheelInfo[i].charAt(0) == '1' ){
                //System.out.println(Math.pow(2.0, i));
                answer = answer + (int)Math.pow(2.0, i);
            }
        }

        System.out.println(answer);
    }


    static void process(int wheelNumber, int direction, int flag){

        int right = wheelInfo[wheelNumber].charAt(2)-'0';
        int left = wheelInfo[wheelNumber].charAt(6)-'0';

        // 톱니 오른쪽(시계) 회전
        if(direction == 1){
            //  Character.getNumericValue() 대체 가능
            int moveNumber = wheelInfo[wheelNumber].charAt(7) - '0';
            wheelInfo[wheelNumber].deleteCharAt(7);
            wheelInfo[wheelNumber].insert(0, moveNumber);
        }
        // 톱니 왼쪽(반시계) 회전
        else if(direction == -1){
            int moveNumber = wheelInfo[wheelNumber].charAt(0) - '0';
            wheelInfo[wheelNumber].deleteCharAt(0);
            wheelInfo[wheelNumber].append(moveNumber);
        }

        // 돌린 톱니 오른쪽 체크
        if(flag != 0 && wheelNumber < 3){
            // 선택된 톱니바퀴랑 오른쪽 톱니바퀴 맞닿는 톱니가 다르면 반대로 회전
            if(right != wheelInfo[wheelNumber+1].charAt(6) - '0'){
                process(wheelNumber+1, direction * -1, 1);
            }
            // 다르면 반대로 회전
            //else{

            //}
        }
        // 돌린 톱니 왼쪽 체크
        if(flag != 1 && wheelNumber > 0){
            // 선택된 톱니바퀴랑 왼쪽 톱니바퀴 맞닿는 톱니가 다르면 반대로 회전
            if(left != wheelInfo[wheelNumber-1].charAt(2) - '0'){
                //process(wheelNumber-1, direction, 0);
                process(wheelNumber-1, direction * -1, 0);
            }
            // 다르면 반대로 회전
            else{

            }
        }
    }
}
